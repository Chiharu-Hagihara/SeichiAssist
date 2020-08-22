package com.github.unchama.seichiassist.mebius.bukkit.codec

import com.github.unchama.seichiassist.mebius.domain.property.MebiusLevel
import org.bukkit.Material
import org.scalatest.wordspec.AnyWordSpec

class BukkitMebiusAppearanceMaterialCodecSpec extends AnyWordSpec {

  import BukkitMebiusAppearanceMaterialCodec._

  "Appearance Codec" should {
    "return some non-air material for all levels" in {
      (1 until MebiusLevel.max.value)
        .map(MebiusLevel.apply)
        .foreach { mebiusLevel =>
          assert(appearanceMaterialAt(mebiusLevel) != Material.AIR)
        }
    }
  }

}
