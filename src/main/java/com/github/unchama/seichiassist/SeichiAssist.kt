package com.github.unchama.seichiassist

import com.github.unchama.menuinventory.MenuHandler
import com.github.unchama.seichiassist.bungee.BungeeReceiver
import com.github.unchama.seichiassist.commands.*
import com.github.unchama.seichiassist.commands.legacy.GachaCommand
import com.github.unchama.seichiassist.data.GachaPrize
import com.github.unchama.seichiassist.data.MineStackGachaData
import com.github.unchama.seichiassist.data.PlayerData
import com.github.unchama.seichiassist.data.RankData
import com.github.unchama.seichiassist.database.DatabaseGateway
import com.github.unchama.seichiassist.listener.*
import com.github.unchama.seichiassist.listener.new_year_event.NewYearsEvent
import com.github.unchama.seichiassist.minestack.MineStackObj
import com.github.unchama.seichiassist.minestack.MineStackObjectCategory
import com.github.unchama.seichiassist.task.HalfHourRankingRoutine
import com.github.unchama.seichiassist.task.PlayerDataBackupTask
import com.github.unchama.seichiassist.task.PlayerDataPeriodicRecalculation
import com.github.unchama.seichiassist.task.PlayerDataSaveTask
import com.github.unchama.seichiassist.util.Util
import com.github.unchama.util.ActionStatus.Fail
import com.github.unchama.util.collection.ImmutableListFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.bukkit.Bukkit
import org.bukkit.ChatColor.GREEN
import org.bukkit.ChatColor.RED
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Entity
import org.bukkit.plugin.java.JavaPlugin
import java.util.*


class SeichiAssist : JavaPlugin() {
  init {
    instance = this
  }

  private var repeatedJobCoroutine: Job? = null

  override fun onEnable() {

    //チャンネルを追加
    Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord")

    // BungeeCordとのI/O
    Bukkit.getMessenger().registerIncomingPluginChannel(this, "SeichiAssistBungee", BungeeReceiver(this))
    Bukkit.getMessenger().registerOutgoingPluginChannel(this, "SeichiAssistBungee")


    //コンフィグ系の設定は全てConfig.javaに移動
    seichiAssistConfig = Config(this)
    seichiAssistConfig.loadConfig()

    if (SeichiAssist.seichiAssistConfig.debugMode == 1) {
      //debugmode=1の時は最初からデバッグモードで鯖を起動
      logger.info("${RED}seichiassistをデバッグモードで起動します")
      logger.info("${RED}コンソールから/seichi debugmode")
      logger.info("${RED}を実行するといつでもONOFFを切り替えられます")
      DEBUG = true
    } else {
      //debugmode=0の時は/seichi debugmodeによる変更コマンドも使えない
      logger.info("${GREEN}seichiassistを通常モードで起動します")
      logger.info("${GREEN}デバッグモードを使用する場合は")
      logger.info("${GREEN}config.ymlの設定値を書き換えて再起動してください")
    }

    databaseGateway = DatabaseGateway.createInitializedInstance(
        seichiAssistConfig.url, seichiAssistConfig.db, seichiAssistConfig.id, seichiAssistConfig.pw
    )

    //mysqlからガチャデータ読み込み
    if (!databaseGateway.gachaDataManipulator.loadGachaData()) {
      logger.info("ガチャデータのロードに失敗しました")
      Bukkit.shutdown()
    }

    //mysqlからMineStack用ガチャデータ読み込み
    if (!databaseGateway.mineStackGachaDataManipulator.loadMineStackGachaData()) {
      logger.info("MineStack用ガチャデータのロードに失敗しました")
      Bukkit.shutdown()
    }

    MineStackObjectList.minestacklistgacha.addAll(creategachaminestacklist())

    MineStackObjectList.minestacklist = ArrayList()
    MineStackObjectList.minestacklist!!.addAll(MineStackObjectList.minestacklistmine)
    MineStackObjectList.minestacklist!!.addAll(MineStackObjectList.minestacklistdrop)
    MineStackObjectList.minestacklist!!.addAll(MineStackObjectList.minestacklistfarm)
    MineStackObjectList.minestacklist!!.addAll(MineStackObjectList.minestacklistbuild)
    MineStackObjectList.minestacklist!!.addAll(MineStackObjectList.minestacklistrs)
    MineStackObjectList.minestacklist!!.addAll(MineStackObjectList.minestacklistgacha)

    // コマンドの登録
    mapOf(
        "gacha" to GachaCommand(),
        "ef" to EffectCommand.executor,
        "seichihaste" to SeichiHasteCommand.executor,
        "seichiassist" to SeichiAssistCommand.executor,
        "openpocket" to OpenPocketCommand.executor,
        "lastquit" to LastQuitCommand.executor,
        "stick" to StickCommand.executor,
        "rmp" to RmpCommand.executor,
        "shareinv" to ShareInvCommand.executor,
        "mebius" to MebiusCommand.executor,
        "achievement" to AchievementCommand.executor,
        "halfguard" to HalfBlockProtectCommand.executor,
        "event" to EventCommand.executor,
        "contribute" to ContributeCommand.executor,
        "subhome" to SubHomeCommand.executor,
        "gtfever" to GiganticFeverCommand.executor,
        "minehead" to MineHeadCommand.executor,
        "x-transfer" to RegionOwnerTransferCommand.executor
    ).forEach { (commandName, executor) -> getCommand(commandName).executor = executor }

    //リスナーの登録
    listOf(
      PlayerJoinListener(),
      PlayerQuitListener(),
      PlayerClickListener(),
      PlayerChatEventListener(),
      PlayerBlockBreakListener(),
      PlayerInventoryListener(),
      EntityListener(),
      PlayerPickupItemListener(),
      PlayerDeathEventListener(),
      GachaItemListener(),
      MebiusListener(),
      RegionInventoryListener(),
      WorldRegenListener()
    ).forEach { server.pluginManager.registerEvents(it, this) }

    //正月イベント用
    NewYearsEvent(this)

    //Menu用Listener
    server.pluginManager.registerEvents(MenuHandler, this)

    //オンラインの全てのプレイヤーを処理
    for (p in server.onlinePlayers) {
      //プレイヤーデータを生成
      databaseGateway.playerDataManipulator.loadPlayerData(PlayerData(p))
    }

    //ランキングリストを最新情報に更新する
    if (!databaseGateway.playerDataManipulator.updateAllRankingList()) {
      logger.info("ランキングデータの作成に失敗しました")
      Bukkit.shutdown()
    }

    startRepeatedJobs()

    logger.info("SeichiAssist is Enabled!")
  }

  override fun onDisable() {
    cancelRepeatedJobs()

    //全てのエンティティを削除
    entitylist.forEach { it.remove() }

    //全てのスキルで破壊されるブロックを強制破壊
    for (b in allblocklist) b.type = Material.AIR

    //sqlコネクションチェック
    databaseGateway.ensureConnection()
    for (p in server.onlinePlayers) {
      //UUIDを取得
      val uuid = p.uniqueId
      //プレイヤーデータ取得
      val playerdata = playermap[uuid]
      //念のためエラー分岐
      if (playerdata == null) {
        p.sendMessage(RED.toString() + "playerdataの保存に失敗しました。管理者に報告してください")
        server.consoleSender.sendMessage(RED.toString() + "SeichiAssist[Ondisable処理]でエラー発生")
        logger.warning(Util.getName(p) + "のplayerdataの保存失敗。開発者に報告してください")
        continue
      }
      //quit時とondisable時、プレイヤーデータを最新の状態に更新
      playerdata.updateonQuit(p)

      PlayerDataSaveTask(playerdata, true, true).run()
    }

    if (databaseGateway.disconnect() == Fail) {
      logger.info("データベース切断に失敗しました")
    }

    logger.info("SeichiAssist is Disabled!")
  }

  private fun startRepeatedJobs() {
    repeatedJobCoroutine = CoroutineScope(Schedulers.sync).launch {
      launch { HalfHourRankingRoutine.launch() }
      launch { PlayerDataPeriodicRecalculation.launch() }
      launch { PlayerDataBackupTask.launch() }
    }
  }

  private fun cancelRepeatedJobs() {
    repeatedJobCoroutine?.cancel()
  }

  fun restartRepeatedJobs() {
    cancelRepeatedJobs()
    startRepeatedJobs()
  }

  companion object {
    lateinit var instance: SeichiAssist

    //デバッグフラグ(デバッグモード使用時はここで変更するのではなくconfig.ymlの設定値を変更すること！)
    var DEBUG = false

    //ガチャシステムのメンテナンスフラグ
    var gachamente = false

    val SEICHIWORLDNAME = "world_sw"
    val DEBUGWORLDNAME = "world"

    // TODO staticであるべきではない
    lateinit var databaseGateway: DatabaseGateway
    lateinit var seichiAssistConfig: Config

    //Gachadataに依存するデータリスト
    val gachadatalist: List<GachaPrize> = ArrayList()

    //(minestackに格納する)Gachadataに依存するデータリスト
    var msgachadatalist: List<MineStackGachaData> = ArrayList()

    //Playerdataに依存するデータリスト
    val playermap = HashMap<UUID, PlayerData>()

    //総採掘量ランキング表示用データリスト
    val ranklist: MutableList<RankData> = ArrayList()

    //プレイ時間ランキング表示用データリスト
    val ranklist_playtick: MutableList<RankData> = ArrayList()

    //投票ポイント表示用データリスト
    val ranklist_p_vote: MutableList<RankData> = ArrayList()

    //マナ妖精表示用のデータリスト
    val ranklist_p_apple: MutableList<RankData> = ArrayList()

    //プレミアムエフェクトポイント表示用データリスト
    val ranklist_premiumeffectpoint: MutableList<RankData> = ArrayList()

    //総採掘量表示用
    var allplayerbreakblockint: Long = 0

    var allplayergiveapplelong: Long = 0

    //プラグインで出すエンティティの保存
    val entitylist: MutableList<Entity> = ArrayList()

    //プレイヤーがスキルで破壊するブロックリスト
    val allblocklist: MutableList<Block> = ArrayList()

    //スキル破壊ブロック分のcoreprotectログ保存処理を除外するワールドリスト(coreprotectログデータ肥大化の軽減が目的)
    //スキル自体はメインワールドと各整地ワールドのみ(world_SWで始まるワールドのみ)で発動する(ここの設定は無視する)
    val ignoreWorldlist = ImmutableListFactory.of(
        "world_SW", "world_SW_2", "world_SW_3", "world_SW_nether", "world_SW_the_end"
    )

    //保護を掛けて整地するワールドのリスト
    val rgSeichiWorldlist = ImmutableListFactory.of(
        "world_SW_2"
    )

    //整地ワールドのリスト(保護の有無は問わない)
    val seichiWorldList = ImmutableListFactory.of(
        "world_SW", "world_SW_2", "world_SW_3", "world_SW_nether", "world_SW_the_end"
    )

    private fun creategachaminestacklist(): List<MineStackObj> {
      val minestacklist = ArrayList<MineStackObj>()
      for (i in msgachadatalist.indices) {
        val g = msgachadatalist[i]
        if (g.itemStack.type != Material.EXP_BOTTLE) { //経験値瓶だけはすでにリストにあるので除外
          minestacklist.add(MineStackObj(g.objName, g.level, g.itemStack, true, i, MineStackObjectCategory.GACHA_PRIZES))
        }
      }
      return minestacklist
    }
  }


}


