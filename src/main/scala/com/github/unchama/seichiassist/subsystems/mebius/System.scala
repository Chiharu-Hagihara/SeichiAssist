package com.github.unchama.seichiassist.subsystems.mebius

import cats.effect.{IO, SyncEffect, SyncIO, Timer}
import com.github.unchama.concurrent.RepeatingTaskContext
import com.github.unchama.datarepository.bukkit.player.JoinToQuitPlayerDataRepository
import com.github.unchama.generic.effect.unsafe.EffectEnvironment
import com.github.unchama.minecraft.actions.MinecraftServerThreadShift
import com.github.unchama.seichiassist.meta.subsystem.Subsystem
import com.github.unchama.seichiassist.subsystems.mebius.bukkit.PropertyModificationBukkitMessages
import com.github.unchama.seichiassist.subsystems.mebius.bukkit.command.MebiusCommandExecutorProvider
import com.github.unchama.seichiassist.subsystems.mebius.bukkit.gateway.BukkitMebiusSpeechGateway
import com.github.unchama.seichiassist.subsystems.mebius.bukkit.listeners._
import com.github.unchama.seichiassist.subsystems.mebius.bukkit.repository.{PeriodicMebiusSpeechRoutineFiberRepository, SpeechServiceRepository}
import com.github.unchama.seichiassist.subsystems.mebius.domain.message.PropertyModificationMessages
import com.github.unchama.seichiassist.subsystems.mebius.domain.speech.{MebiusSpeechBlockageState, MebiusSpeechGateway}
import com.github.unchama.seichiassist.subsystems.mebius.service.MebiusSpeechService
import com.github.unchama.seichiassist.subsystems.seasonalevents.api.SeasonalEventsAPI
import com.github.unchama.util.RandomEffect
import org.bukkit.entity.Player

import scala.util.Random

object System {
  def wired[
    F[_],
    G[_] : SeasonalEventsAPI : SyncEffect
  ](implicit effectEnvironment: EffectEnvironment,
    timer: Timer[IO],
    repeatingTaskContext: RepeatingTaskContext,
    bukkitSyncIOShift: MinecraftServerThreadShift[IO]): Subsystem[F] = {

    implicit val messages: PropertyModificationMessages = PropertyModificationBukkitMessages
    implicit val gatewayProvider: Player => MebiusSpeechGateway[SyncIO] = new BukkitMebiusSpeechGateway(_)
    implicit val getFreshSpeechBlockageState: SyncIO[MebiusSpeechBlockageState[SyncIO]] = SyncIO(new MebiusSpeechBlockageState[SyncIO])
    implicit val gatewayRepository: JoinToQuitPlayerDataRepository[MebiusSpeechService[SyncIO]] = new SpeechServiceRepository[SyncIO]

    val seasonalEventsAPI = SeasonalEventsAPI[G]
    import seasonalEventsAPI.christmasEventsAPI

    implicit val randomEffect: RandomEffect[G] = RandomEffect.createFromRandom(Random)

    val speechRoutineFiberRepository = new PeriodicMebiusSpeechRoutineFiberRepository()

    val listeners = Seq(
      new MebiusDropTrialListener[G],
      new MebiusInteractionResponder,
      new MebiusLevelUpTrialListener,
      new MebiusPlayerJoinGreeter[IO],
      new MebiusRenamePreventionListener,
      gatewayRepository, speechRoutineFiberRepository
    )

    val commands = Map(
      "mebius" -> new MebiusCommandExecutorProvider().executor
    )

    Subsystem(listeners, Nil, commands)
  }
}
