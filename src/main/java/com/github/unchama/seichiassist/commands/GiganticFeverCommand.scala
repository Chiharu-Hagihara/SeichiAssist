package com.github.unchama.seichiassist.commands

import com.github.unchama.contextualexecutor.builder.ContextualExecutorBuilder
import com.github.unchama.seichiassist.util.Util
import com.github.unchama.targetedeffect.EmptyEffect
import org.bukkit.Difficulty

object GiganticFeverCommand {
  private val worldsToToggleDifficulty = ManagedWorld.seichiWorlds.map { it.name }

  val executor = ContextualExecutorBuilder.beginConfiguration()
      .execution {
        val config = SeichiAssist.seichiAssistConfig

        Util.sendEveryMessage(s"${ChatColor.AQUA}フィーバー！この時間MOBたちは踊りに出かけてるぞ！今が整地時だ！")
        Util.sendEveryMessage(s"${ChatColor.AQUA}(${config.giganticFeverDisplayTime}間)")

        Util.setDifficulty(worldsToToggleDifficulty, Difficulty.PEACEFUL)

        delay(config.giganticFeverMinutes * 60L * 1000L)

        Util.setDifficulty(worldsToToggleDifficulty, Difficulty.HARD)
        Util.sendEveryMessage(s"${ChatColor.AQUA}フィーバー終了！MOBたちは戻ってきたぞ！")

        EmptyEffect
      }
      .build()
      .asNonBlockingTabExecutor()
}
