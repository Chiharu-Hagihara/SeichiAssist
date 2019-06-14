package com.github.unchama.seichiassist

import com.github.unchama.seichiassist.minestack.MineStackObj
import com.github.unchama.seichiassist.minestack.objects.*
import com.github.unchama.seichiassist.util.StaticGachaPrizeFactory
import com.github.unchama.util.collection.ImmutableListFactory
import org.bukkit.Material

import java.util.ArrayList

object MineStackObjectList {
  // 採掘可能ブロック
  val minestacklistmine = listOf(
      MineStackMineObj("coal_ore", "石炭鉱石", 1, Material.COAL_ORE, 0),
      MineStackMineObj("coal", "石炭", 1, Material.COAL, 0),
      MineStackMineObj("coal_block", "石炭ブロック", 1, Material.COAL_BLOCK, 0),
      MineStackMineObj("coal_1", "木炭", 1, Material.COAL, 1),
      MineStackMineObj("iron_ore", "鉄鉱石", 1, Material.IRON_ORE, 0),
      MineStackMineObj("iron_ingot", "鉄インゴット", 1, Material.IRON_INGOT, 0),
      MineStackMineObj("iron_block", "鉄ブロック", 1, Material.IRON_BLOCK, 0),
      MineStackMineObj("quartz_ore", "ネザー水晶鉱石", 1, Material.QUARTZ_ORE, 0),
      MineStackMineObj("quartz", "ネザー水晶", 1, Material.QUARTZ, 0),
      MineStackMineObj("gold_ore", "金鉱石", 1, Material.GOLD_ORE, 0),
      MineStackMineObj("gold_ingot", "金インゴット", 1, Material.GOLD_INGOT, 0),
      MineStackMineObj("gold_block", "金ブロック", 1, Material.GOLD_BLOCK, 0),
      MineStackMineObj("redstone_ore", "レッドストーン鉱石", 1, Material.REDSTONE_ORE, 0),
      MineStackMineObj("lapis_ore", "ラピスラズリ鉱石", 1, Material.LAPIS_ORE, 0),
      MineStackMineObj("lapis_lazuli", "ラピスラズリ", 1, Material.INK_SACK, 4),
      MineStackMineObj("lapis_block", "ラピスラズリブロック", 1, Material.LAPIS_BLOCK, 0),
      MineStackMineObj("diamond_ore", "ダイヤモンド鉱石", 1, Material.DIAMOND_ORE, 0),
      MineStackMineObj("diamond", "ダイヤモンド", 1, Material.DIAMOND, 0),
      MineStackMineObj("diamond_block", "ダイヤモンドブロック", 1, Material.DIAMOND_BLOCK, 0),
      MineStackMineObj("emerald_ore", "エメラルド鉱石", 1, Material.EMERALD_ORE, 0),
      MineStackMineObj("emerald", "エメラルド", 1, Material.EMERALD, 0),
      MineStackMineObj("emerald_block", "エメラルドブロック", 1, Material.EMERALD_BLOCK, 0)
  )

  // モンスター+動物ドロップ
  val minestacklistdrop = listOf(
      MineStackDropObj("ender_pearl", "エンダーパール", 1, Material.ENDER_PEARL, 0),
      MineStackDropObj("ender_eye", "エンダーアイ", 1, Material.EYE_OF_ENDER, 0),
      MineStackDropObj("slime_ball", "スライムボール", 1, Material.SLIME_BALL, 0),
      MineStackDropObj("slime", "スライムブロック", 1, Material.SLIME_BLOCK, 0),
      MineStackDropObj("rotten_flesh", "腐った肉", 1, Material.ROTTEN_FLESH, 0),
      MineStackDropObj("bone", "骨", 1, Material.BONE, 0),
      MineStackDropObj("sulphur", "火薬", 1, Material.SULPHUR, 0),
      MineStackDropObj("arrow", "矢", 1, Material.ARROW, 0),
      MineStackDropObj("spider_eye", "蜘蛛の目", 1, Material.SPIDER_EYE, 0),
      MineStackDropObj("string", "糸", 1, Material.STRING, 0),
      MineStackDropObj("name_tag", "名札", 1, Material.NAME_TAG, 0),
      MineStackDropObj("lead", "リード", 1, Material.LEASH, 0),
      MineStackDropObj("glass_bottle", "ガラス瓶", 1, Material.GLASS_BOTTLE, 0),
      MineStackDropObj("gold_nugget", "金塊", 1, Material.GOLD_NUGGET, 0),
      MineStackDropObj("blaze_rod", "ブレイズロッド", 1, Material.BLAZE_ROD, 0),
      MineStackDropObj("blaze_powder", "ブレイズパウダー", 1, Material.BLAZE_POWDER, 0),
      MineStackDropObj("ghast_tear", "ガストの涙", 1, Material.GHAST_TEAR, 0),
      MineStackDropObj("magma_cream", "マグマクリーム", 1, Material.MAGMA_CREAM, 0),
      MineStackDropObj("prismarine_shard", "プリズマリンの欠片", 1, Material.PRISMARINE_SHARD, 0),
      MineStackDropObj("prismarine_crystals", "プリズマリンクリスタル", 1, Material.PRISMARINE_CRYSTALS, 0),
      MineStackDropObj("feather", "羽", 1, Material.FEATHER, 0),
      MineStackDropObj("leather", "革", 1, Material.LEATHER, 0),
      MineStackDropObj("rabbit_hide", "ウサギの皮", 1, Material.RABBIT_HIDE, 0),
      MineStackDropObj("rabbit_foot", "ウサギの足", 1, Material.RABBIT_FOOT, 0),
      MineStackDropObj("dragon_egg", "エンドラの卵", 1, Material.DRAGON_EGG, 0),
      MineStackDropObj("shulker_shell", "シュルカーの殻", 1, Material.SHULKER_SHELL, 0),
      MineStackDropObj("totem_of_undying", "不死のトーテム", 1, Material.TOTEM, 0),
      MineStackDropObj("dragon_head", "エンダードラゴンの頭", 1, Material.SKULL_ITEM, 5),
      MineStackDropObj("wither_skeleton_skull", "ウィザースケルトンの頭", 1, Material.SKULL_ITEM, 1)
  )

  // 採掘で入手可能な農業系ブロック
  val minestacklistfarm = listOf(
      MineStackFarmObj("seeds", "種", 1, Material.SEEDS, 0),
      MineStackFarmObj("apple", "リンゴ", 1, Material.APPLE, 0),
      MineStackFarmObj("long_grass1", "草", 1, Material.LONG_GRASS, 1),
      MineStackFarmObj("long_grass2", "シダ", 1, Material.LONG_GRASS, 2),
      MineStackFarmObj("dead_bush", "枯れ木", 1, Material.DEAD_BUSH, 0),
      MineStackFarmObj("cactus", "サボテン", 1, Material.CACTUS, 0),
      MineStackFarmObj("vine", "ツタ", 1, Material.VINE, 0),
      MineStackFarmObj("water_lily", "スイレンの葉", 1, Material.WATER_LILY, 0),
      MineStackFarmObj("yellow_flower", "タンポポ", 1, Material.YELLOW_FLOWER, 0),
      MineStackFarmObj("red_rose0", "ポピー", 1, Material.RED_ROSE, 0),
      MineStackFarmObj("red_rose1", "ヒスイラン", 1, Material.RED_ROSE, 1),
      MineStackFarmObj("red_rose2", "アリウム", 1, Material.RED_ROSE, 2),
      MineStackFarmObj("red_rose3", "ヒナソウ", 1, Material.RED_ROSE, 3),
      MineStackFarmObj("red_rose4", "赤色のチューリップ", 1, Material.RED_ROSE, 4),
      MineStackFarmObj("red_rose5", "橙色のチューリップ", 1, Material.RED_ROSE, 5),
      MineStackFarmObj("red_rose6", "白色のチューリップ", 1, Material.RED_ROSE, 6),
      MineStackFarmObj("red_rose7", "桃色のチューリップ", 1, Material.RED_ROSE, 7),
      MineStackFarmObj("red_rose8", "フランスギク", 1, Material.RED_ROSE, 8),
      MineStackFarmObj("leaves", "オークの葉", 1, Material.LEAVES, 0),
      MineStackFarmObj("leaves1", "マツの葉", 1, Material.LEAVES, 1),
      MineStackFarmObj("leaves2", "シラカバの葉", 1, Material.LEAVES, 2),
      MineStackFarmObj("leaves3", "ジャングルの葉", 1, Material.LEAVES, 3),
      MineStackFarmObj("leaves_2", "アカシアの葉", 1, Material.LEAVES_2, 0),
      MineStackFarmObj("leaves_21", "ダークオークの葉", 1, Material.LEAVES_2, 1),
      MineStackFarmObj("double_plant0", "ヒマワリ", 1, Material.DOUBLE_PLANT, 0),
      MineStackFarmObj("double_plant1", "ライラック", 1, Material.DOUBLE_PLANT, 1),
      MineStackFarmObj("double_plant2", "高い草", 1, Material.DOUBLE_PLANT, 2),
      MineStackFarmObj("double_plant3", "大きなシダ", 1, Material.DOUBLE_PLANT, 3),
      MineStackFarmObj("double_plant4", "バラの低木", 1, Material.DOUBLE_PLANT, 4),
      MineStackFarmObj("double_plant5", "ボタン", 1, Material.DOUBLE_PLANT, 5),
      MineStackFarmObj("sugar_cane", "サトウキビ", 1, Material.SUGAR_CANE, 0),
      MineStackFarmObj("pumpkin", "カボチャ", 1, Material.PUMPKIN, 0),
      MineStackFarmObj("ink_sack3", "カカオ豆", 1, Material.INK_SACK, 3),
      MineStackFarmObj("huge_mushroom_1", "キノコ", 1, Material.HUGE_MUSHROOM_1, 0),
      MineStackFarmObj("huge_mushroom_2", "キノコ", 1, Material.HUGE_MUSHROOM_2, 0),
      MineStackFarmObj("melon", "スイカ", 1, Material.MELON, 0),
      MineStackFarmObj("melon_block", "スイカ", 1, Material.MELON_BLOCK, 0),
      MineStackFarmObj("brown_mushroom", "キノコ", 1, Material.BROWN_MUSHROOM, 0),
      MineStackFarmObj("red_mushroom", "キノコ", 1, Material.RED_MUSHROOM, 0),
      MineStackFarmObj("sapling", "オークの苗木", 1, Material.SAPLING, 0),
      MineStackFarmObj("sapling1", "マツの苗木", 1, Material.SAPLING, 1),
      MineStackFarmObj("sapling2", "シラカバの苗木", 1, Material.SAPLING, 2),
      MineStackFarmObj("sapling3", "ジャングルの苗木", 1, Material.SAPLING, 3),
      MineStackFarmObj("sapling4", "アカシアの苗木", 1, Material.SAPLING, 4),
      MineStackFarmObj("sapling5", "ダークオークの苗木", 1, Material.SAPLING, 5),
      MineStackFarmObj("beetroot", "ビートルート", 1, Material.BEETROOT, 0),
      MineStackFarmObj("beetroot_seeds", "ビートルートの種", 1, Material.BEETROOT_SEEDS, 0),
      MineStackFarmObj("carrot_item", "ニンジン", 1, Material.CARROT_ITEM, 0),
      MineStackFarmObj("potato_item", "ジャガイモ", 1, Material.POTATO_ITEM, 0),
      MineStackFarmObj("poisonous_potato", "青くなったジャガイモ", 1, Material.POISONOUS_POTATO, 0),
      MineStackFarmObj("wheat", "小麦", 1, Material.WHEAT, 0),
      MineStackFarmObj("pumpkin_seeds", "カボチャの種", 1, Material.PUMPKIN_SEEDS, 0),
      MineStackFarmObj("melon_seeds", "スイカの種", 1, Material.MELON_SEEDS, 0),
      MineStackFarmObj("nether_stalk", "ネザーウォート", 1, Material.NETHER_STALK, 0),
      MineStackFarmObj("chorus_fruit", "コーラスフルーツ", 1, Material.CHORUS_FRUIT, 0),
      MineStackFarmObj("chorus_flower", "コーラスフラワー", 1, Material.CHORUS_FLOWER, 0),
      MineStackFarmObj("egg", "卵", 1, Material.EGG, 0),
      MineStackFarmObj("pork", "生の豚肉", 1, Material.PORK, 0),
      MineStackFarmObj("cooked_porkchop", "焼き豚", 1, Material.GRILLED_PORK, 0),
      MineStackFarmObj("raw_chicken", "生の鶏肉", 1, Material.RAW_CHICKEN, 0),
      MineStackFarmObj("cooked_chicken", "焼き鳥", 1, Material.COOKED_CHICKEN, 0),
      MineStackFarmObj("mutton", "生の羊肉", 1, Material.MUTTON, 0),
      MineStackFarmObj("cooked_mutton", "焼いた羊肉", 1, Material.COOKED_MUTTON, 0),
      MineStackFarmObj("raw_beef", "生の牛肉", 1, Material.RAW_BEEF, 0),
      MineStackFarmObj("cooked_beaf", "ステーキ", 1, Material.COOKED_BEEF, 0),
      MineStackFarmObj("rabbit", "生の兎肉", 1, Material.RABBIT, 0),
      MineStackFarmObj("cooked_rabbit", "焼き兎肉", 1, Material.COOKED_RABBIT, 0),
      MineStackFarmObj("raw_fish0", "生魚", 1, Material.RAW_FISH, 0),
      MineStackFarmObj("cooked_fish0", "焼き魚", 1, Material.COOKED_FISH, 0),
      MineStackFarmObj("raw_fish1", "生鮭", 1, Material.RAW_FISH, 1),
      MineStackFarmObj("cooked_fish1", "焼き鮭", 1, Material.COOKED_FISH, 1),
      MineStackFarmObj("raw_fish2", "クマノミ", 1, Material.RAW_FISH, 2),
      MineStackFarmObj("raw_fish3", "フグ", 1, Material.RAW_FISH, 3),
      MineStackFarmObj("bread", "パン", 1, Material.BREAD, 0),
      MineStackFarmObj("sugar", "砂糖", 1, Material.SUGAR, 0),
      MineStackFarmObj("baked_potato", "ベイクドポテト", 1, Material.BAKED_POTATO, 0),
      MineStackFarmObj("cake", "ケーキ", 1, Material.CAKE, 0),
      MineStackFarmObj("mushroom_stew", "キノコシチュー", 1, Material.MUSHROOM_SOUP, 0),
      MineStackFarmObj("rabbit_stew", "ウサギシチュー", 1, Material.RABBIT_STEW, 0),
      MineStackFarmObj("beetroot_soup", "ビートルートスープ", 1, Material.BEETROOT_SOUP, 0),
      MineStackFarmObj("bowl", "ボウル", 1, Material.BOWL, 0)
  )

  // 建築系ブロック
  val minestacklistbuild = listOf(
      MineStackBuildObj("log", "オークの原木", 1, Material.LOG, 0),
      MineStackBuildObj("wood", "オークの木材", 1, Material.WOOD, 0),
      MineStackBuildObj("wood_step0", "オークの木材ハーフブロック", 1, Material.WOOD_STEP, 0),
      MineStackBuildObj("oak_stairs", "オークの木の階段", 1, Material.WOOD_STAIRS, 0),
      MineStackBuildObj("fence", "オークのフェンス", 1, Material.FENCE, 0),
      MineStackBuildObj("log1", "マツの原木", 1, Material.LOG, 1),
      MineStackBuildObj("wood_1", "マツの木材", 1, Material.WOOD, 1),
      MineStackBuildObj("wood_step1", "マツの木材ハーフブロック", 1, Material.WOOD_STEP, 1),
      MineStackBuildObj("spruce_stairs", "マツの木の階段", 1, Material.SPRUCE_WOOD_STAIRS, 0),
      MineStackBuildObj("spruce_fence", "マツのフェンス", 1, Material.SPRUCE_FENCE, 0),
      MineStackBuildObj("log2", "シラカバの原木", 1, Material.LOG, 2),
      MineStackBuildObj("wood_2", "シラカバの木材", 1, Material.WOOD, 2),
      MineStackBuildObj("wood_step2", "シラカバの木材ハーフブロック", 1, Material.WOOD_STEP, 2),
      MineStackBuildObj("birch_stairs", "シラカバの木の階段", 1, Material.BIRCH_WOOD_STAIRS, 0),
      MineStackBuildObj("birch_fence", "シラカバのフェンス", 1, Material.BIRCH_FENCE, 0),
      MineStackBuildObj("log3", "ジャングルの原木", 1, Material.LOG, 3),
      MineStackBuildObj("wood_3", "ジャングルの木材", 1, Material.WOOD, 3),
      MineStackBuildObj("wood_step3", "ジャングルの木材ハーフブロック", 1, Material.WOOD_STEP, 3),
      MineStackBuildObj("jungle_stairs", "ジャングルの木の階段", 1, Material.JUNGLE_WOOD_STAIRS, 0),
      MineStackBuildObj("jungle_fence", "ジャングルのフェンス", 1, Material.JUNGLE_FENCE, 0),
      MineStackBuildObj("log_2", "アカシアの原木", 1, Material.LOG_2, 0),
      MineStackBuildObj("wood_4", "アカシアの木材", 1, Material.WOOD, 4),
      MineStackBuildObj("wood_step4", "アカシアの木材ハーフブロック", 1, Material.WOOD_STEP, 4),
      MineStackBuildObj("acacia_stairs", "アカシアの木の階段", 1, Material.ACACIA_STAIRS, 0),
      MineStackBuildObj("acacia_fence", "アカシアのフェンス", 1, Material.ACACIA_FENCE, 0),
      MineStackBuildObj("log_21", "ダークオークの原木", 1, Material.LOG_2, 1),
      MineStackBuildObj("wood_5", "ダークオークの木材", 1, Material.WOOD, 5),
      MineStackBuildObj("wood_step5", "ダークオークの木材ハーフブロック", 1, Material.WOOD_STEP, 5),
      MineStackBuildObj("dark_oak_stairs", "ダークオークの木の階段", 1, Material.DARK_OAK_STAIRS, 0),
      MineStackBuildObj("dark_oak_fence", "ダークオークのフェンス", 1, Material.DARK_OAK_FENCE, 0),
      MineStackBuildObj("cobblestone", "丸石", 1, Material.COBBLESTONE, 0),
      MineStackBuildObj("step3", "丸石ハーフブロック", 1, Material.STEP, 3),
      MineStackBuildObj("stone_stairs", "丸石の階段", 1, Material.COBBLESTONE_STAIRS, 0),
      MineStackBuildObj("cobblestone_wall_0", "丸石の壁", 1, Material.COBBLE_WALL, 0),
      MineStackBuildObj("mossy_cobblestone", "苔石", 1, Material.MOSSY_COBBLESTONE, 0),
      MineStackBuildObj("cobblestone_wall_1", "苔石の壁", 1, Material.COBBLE_WALL, 1),
      MineStackBuildObj("stone", "石", 1, Material.STONE, 0),
      MineStackBuildObj("step0", "石ハーフブロック", 1, Material.STEP, 0),
      MineStackBuildObj("smooth_brick0", "石レンガ", 1, Material.SMOOTH_BRICK, 0),
      MineStackBuildObj("step5", "石レンガハーフブロック", 1, Material.STEP, 5),
      MineStackBuildObj("smooth_stairs", "石レンガの階段", 1, Material.SMOOTH_STAIRS, 0),
      MineStackBuildObj("smooth_brick3", "模様入り石レンガ", 1, Material.SMOOTH_BRICK, 3),
      MineStackBuildObj("smooth_brick1", "苔石レンガ", 1, Material.SMOOTH_BRICK, 1),
      MineStackBuildObj("smooth_brick2", "ひびの入った石レンガ", 1, Material.SMOOTH_BRICK, 2),
      MineStackBuildObj("sand", "砂", 1, Material.SAND, 0),
      MineStackBuildObj("sandstone", "砂岩", 1, Material.SANDSTONE, 0),
      MineStackBuildObj("step1", "砂岩ハーフブロック", 1, Material.STEP, 1),
      MineStackBuildObj("standstone_stairs", "砂岩の階段", 1, Material.SANDSTONE_STAIRS, 0),
      MineStackBuildObj("sandstone1", "模様入りの砂岩", 1, Material.SANDSTONE, 1),
      MineStackBuildObj("sandstone2", "なめらかな砂岩", 1, Material.SANDSTONE, 2),
      MineStackBuildObj("red_sand", "赤い砂", 1, Material.SAND, 1),
      MineStackBuildObj("red_sandstone", "赤い砂岩", 1, Material.RED_SANDSTONE, 0),
      MineStackBuildObj("stone_slab20", "赤い砂岩ハーフブロック", 1, Material.STONE_SLAB2, 0),
      MineStackBuildObj("red_sandstone_stairs", "赤い砂岩の階段", 1, Material.RED_SANDSTONE_STAIRS, 0),
      MineStackBuildObj("red_sandstone1", "模様入りの赤い砂岩", 1, Material.RED_SANDSTONE, 1),
      MineStackBuildObj("red_sandstone2", "なめらかな赤い砂岩", 1, Material.RED_SANDSTONE, 2),
      MineStackBuildObj("clay_ball", "粘土", 1, Material.CLAY_BALL, 0),
      MineStackBuildObj("clay", "粘土(ブロック)", 1, Material.CLAY, 0),
      MineStackBuildObj("brick_item", "レンガ", 1, Material.CLAY_BRICK, 0),
      MineStackBuildObj("brick", "レンガ(ブロック)", 1, Material.BRICK, 0),
      MineStackBuildObj("step4", "レンガハーフブロック", 1, Material.STEP, 4),
      MineStackBuildObj("brick_stairs", "レンガの階段", 1, Material.BRICK_STAIRS, 0),
      MineStackBuildObj("quartz_block", "ネザー水晶ブロック", 1, Material.QUARTZ_BLOCK, 0),
      MineStackBuildObj("step7", "ネザー水晶ハーフブロック", 1, Material.STEP, 7),
      MineStackBuildObj("quartz_stairs", "ネザー水晶の階段", 1, Material.QUARTZ_STAIRS, 0),
      MineStackBuildObj("quartz_block1", "模様入りネザー水晶ブロック", 1, Material.QUARTZ_BLOCK, 1),
      MineStackBuildObj("quartz_block2", "柱状ネザー水晶ブロック", 1, Material.QUARTZ_BLOCK, 2),
      MineStackBuildObj("netherrack", "ネザーラック", 1, Material.NETHERRACK, 0),
      MineStackBuildObj("nether_brick_item", "ネザーレンガ", 1, Material.NETHER_BRICK_ITEM, 0),
      MineStackBuildObj("nether_brick", "ネザーレンガ(ブロック)", 1, Material.NETHER_BRICK, 0),
      MineStackBuildObj("step6", "ネザーレンガハーフブロック", 1, Material.STEP, 6),
      MineStackBuildObj("nether_brick_stairs", "ネザーレンガの階段", 1, Material.NETHER_BRICK_STAIRS, 0),
      MineStackBuildObj("nether_brick_fence", "ネザーレンガのフェンス", 1, Material.NETHER_FENCE, 0),
      MineStackBuildObj("red_nether_brick", "赤いネザーレンガ", 1, Material.RED_NETHER_BRICK, 0),
      MineStackBuildObj("nether_wart_block", "ネザ－ウォートブロック", 1, Material.NETHER_WART_BLOCK, 0),
      MineStackBuildObj("ender_stone", "エンドストーン", 1, Material.ENDER_STONE, 0),
      MineStackBuildObj("end_bricks", "エンドストーンレンガ", 1, Material.END_BRICKS, 0),
      MineStackBuildObj("purpur_block", "プルパーブロック", 1, Material.PURPUR_BLOCK, 0),
      MineStackBuildObj("purpur_pillar", "柱状プルパーブロック", 1, Material.PURPUR_PILLAR, 0),
      MineStackBuildObj("purpur_slab", "プルパーハーフブロック", 1, Material.PURPUR_SLAB, 0),
      MineStackBuildObj("purpur_stairs", "プルパーの階段", 1, Material.PURPUR_STAIRS, 0),
      MineStackBuildObj("prismarine0", "プリズマリン", 1, Material.PRISMARINE, 0),
      MineStackBuildObj("prismarine1", "プリズマリンレンガ", 1, Material.PRISMARINE, 1),
      MineStackBuildObj("prismarine2", "ダークプリズマリン", 1, Material.PRISMARINE, 2),
      MineStackBuildObj("sea_lantern", "シーランタン", 1, Material.SEA_LANTERN, 0),
      MineStackBuildObj("granite", "花崗岩", 1, Material.STONE, 1),
      MineStackBuildObj("polished_granite", "磨かれた花崗岩", 1, Material.STONE, 2),
      MineStackBuildObj("diorite", "閃緑岩", 1, Material.STONE, 3),
      MineStackBuildObj("polished_diorite", "磨かれた閃緑岩", 1, Material.STONE, 4),
      MineStackBuildObj("andesite", "安山岩", 1, Material.STONE, 5),
      MineStackBuildObj("polished_andesite", "磨かれた安山岩", 1, Material.STONE, 6),
      MineStackBuildObj("dirt", "土", 1, Material.DIRT, 0),
      MineStackBuildObj("grass", "草ブロック", 1, Material.GRASS, 0),
      MineStackBuildObj("gravel", "砂利", 1, Material.GRAVEL, 0),
      MineStackBuildObj("flint", "火打石", 1, Material.FLINT, 0),
      MineStackBuildObj("flint_and_steel", "火打石と打ち金", 1, Material.FLINT_AND_STEEL, 0),
      MineStackBuildObj("dirt1", "粗い土", 1, Material.DIRT, 1),
      MineStackBuildObj("dirt2", "ポドゾル", 1, Material.DIRT, 2),
      MineStackBuildObj("snow_block", "雪", 1, Material.SNOW_BLOCK, 0),
      MineStackBuildObj("snow_layer", "雪タイル", 1, Material.SNOW, 0),
      MineStackBuildObj("snow_ball", "雪玉", 1, Material.SNOW_BALL, 0),
      MineStackBuildObj("ice", "氷", 1, Material.ICE, 0),
      MineStackBuildObj("packed_ice", "氷塊", 1, Material.PACKED_ICE, 0),
      MineStackBuildObj("mycel", "菌糸", 1, Material.MYCEL, 0),
      MineStackBuildObj("bone_block", "骨ブロック", 1, Material.BONE_BLOCK, 0),
      MineStackBuildObj("sponge", "スポンジ", 1, Material.SPONGE, 0),
      MineStackBuildObj("wet_sponge", "濡れたスポンジ", 1, Material.SPONGE, 1),
      MineStackBuildObj("soul_sand", "ソウルサンド", 1, Material.SOUL_SAND, 0),
      MineStackBuildObj("magma", "マグマブロック", 1, Material.MAGMA, 0),
      MineStackBuildObj("obsidian", "黒曜石", 1, Material.OBSIDIAN, 0),
      MineStackBuildObj("glowstone_dust", "グロウストーンダスト", 1, Material.GLOWSTONE_DUST, 0),
      MineStackBuildObj("glowstone", "グロウストーン", 1, Material.GLOWSTONE, 0),
      MineStackBuildObj("torch", "松明", 1, Material.TORCH, 0),
      MineStackBuildObj("jack_o_lantern", "ジャック・オ・ランタン", 1, Material.JACK_O_LANTERN, 0),
      MineStackBuildObj("end_rod", "エンドロッド", 1, Material.END_ROD, 0),
      MineStackBuildObj("bucket", "バケツ", 1, Material.BUCKET, 0),
      MineStackBuildObj("water_bucket", "水入りバケツ", 1, Material.WATER_BUCKET, 0),
      MineStackBuildObj("lava_bucket", "溶岩入りバケツ", 1, Material.LAVA_BUCKET, 0),
      MineStackBuildObj("milk_bucket", "牛乳", 1, Material.MILK_BUCKET, 0),
      MineStackBuildObj("web", "クモの巣", 1, Material.WEB, 0),
      MineStackBuildObj("rails", "レール", 1, Material.RAILS, 0),
      MineStackBuildObj("furnace", "かまど", 1, Material.FURNACE, 0),
      MineStackBuildObj("chest", "チェスト", 1, Material.CHEST, 0),
      MineStackBuildObj("bed", "ベッド", 1, Material.BED, 0),
      MineStackBuildObj("book", "本", 1, Material.BOOK, 0),
      MineStackBuildObj("bookshelf", "本棚", 1, Material.BOOKSHELF, 0),
      MineStackBuildObj("iron_bars", "鉄格子", 1, Material.IRON_FENCE, 0),
      MineStackBuildObj("anvil", "金床", 1, Material.ANVIL, 0),
      MineStackBuildObj("cauldron", "大釜", 1, Material.CAULDRON_ITEM, 0),
      MineStackBuildObj("brewing_stand", "醸造台", 1, Material.BREWING_STAND_ITEM, 0),
      MineStackBuildObj("flower_pot", "植木鉢", 1, Material.FLOWER_POT_ITEM, 0),
      MineStackBuildObj("hay_block", "干し草の俵", 1, Material.HAY_BLOCK, 0),
      MineStackBuildObj("ladder", "はしご", 1, Material.LADDER, 0),
      MineStackBuildObj("sign", "看板", 1, Material.SIGN, 0),
      MineStackBuildObj("item_frame", "額縁", 1, Material.ITEM_FRAME, 0),
      MineStackBuildObj("painting", "絵画", 1, Material.PAINTING, 0),
      MineStackBuildObj("beacon", "ビーコン", 1, Material.BEACON, 0),
      MineStackBuildObj("armor_stand", "アーマースタンド", 1, Material.ARMOR_STAND, 0),
      MineStackBuildObj("end_crystal", "エンドクリスタル", 1, Material.END_CRYSTAL, 0),
      MineStackBuildObj("enchanting_table", "エンチャントテーブル", 1, Material.ENCHANTMENT_TABLE, 0),
      MineStackBuildObj("jukebox", "ジュークボックス", 1, Material.JUKEBOX, 0),
      MineStackBuildObj("hard_clay", "テラコッタ", 1, Material.HARD_CLAY, 0),
      MineStackBuildObj("stained_clay", "白色のテラコッタ", 1, Material.STAINED_CLAY, 0),
      MineStackBuildObj("stained_clay1", "橙色のテラコッタ", 1, Material.STAINED_CLAY, 1),
      MineStackBuildObj("stained_clay2", "赤紫色のテラコッタ", 1, Material.STAINED_CLAY, 2),
      MineStackBuildObj("stained_clay3", "空色のテラコッタ", 1, Material.STAINED_CLAY, 3),
      MineStackBuildObj("stained_clay4", "黄色のテラコッタ", 1, Material.STAINED_CLAY, 4),
      MineStackBuildObj("stained_clay5", "黄緑色のテラコッタ", 1, Material.STAINED_CLAY, 5),
      MineStackBuildObj("stained_clay6", "桃色のテラコッタ", 1, Material.STAINED_CLAY, 6),
      MineStackBuildObj("stained_clay7", "灰色のテラコッタ", 1, Material.STAINED_CLAY, 7),
      MineStackBuildObj("stained_clay8", "薄灰色のテラコッタ", 1, Material.STAINED_CLAY, 8),
      MineStackBuildObj("stained_clay9", "水色のテラコッタ", 1, Material.STAINED_CLAY, 9),
      MineStackBuildObj("stained_clay10", "紫色のテラコッタ", 1, Material.STAINED_CLAY, 10),
      MineStackBuildObj("stained_clay11", "青色のテラコッタ", 1, Material.STAINED_CLAY, 11),
      MineStackBuildObj("stained_clay12", "茶色のテラコッタ", 1, Material.STAINED_CLAY, 12),
      MineStackBuildObj("stained_clay13", "緑色のテラコッタ", 1, Material.STAINED_CLAY, 13),
      MineStackBuildObj("stained_clay14", "赤色のテラコッタ", 1, Material.STAINED_CLAY, 14),
      MineStackBuildObj("stained_clay15", "黒色のテラコッタ", 1, Material.STAINED_CLAY, 15),
      MineStackBuildObj("concrete", "白色のコンクリート", 1, Material.CONCRETE, 0),
      MineStackBuildObj("concrete1", "橙色のコンクリート", 1, Material.CONCRETE, 1),
      MineStackBuildObj("concrete2", "赤紫色のコンクリート", 1, Material.CONCRETE, 2),
      MineStackBuildObj("concrete3", "空色のコンクリート", 1, Material.CONCRETE, 3),
      MineStackBuildObj("concrete4", "黄色のコンクリート", 1, Material.CONCRETE, 4),
      MineStackBuildObj("concrete5", "黄緑色のコンクリート", 1, Material.CONCRETE, 5),
      MineStackBuildObj("concrete6", "桃色のコンクリート", 1, Material.CONCRETE, 6),
      MineStackBuildObj("concrete7", "灰色のコンクリート", 1, Material.CONCRETE, 7),
      MineStackBuildObj("concrete8", "薄灰色のコンクリート", 1, Material.CONCRETE, 8),
      MineStackBuildObj("concrete9", "水色のコンクリート", 1, Material.CONCRETE, 9),
      MineStackBuildObj("concrete10", "紫色のコンクリート", 1, Material.CONCRETE, 10),
      MineStackBuildObj("concrete11", "青色のコンクリート", 1, Material.CONCRETE, 11),
      MineStackBuildObj("concrete12", "茶色のコンクリート", 1, Material.CONCRETE, 12),
      MineStackBuildObj("concrete13", "緑色のコンクリート", 1, Material.CONCRETE, 13),
      MineStackBuildObj("concrete14", "赤色のコンクリート", 1, Material.CONCRETE, 14),
      MineStackBuildObj("concrete15", "黒色のコンクリート", 1, Material.CONCRETE, 15),
      MineStackBuildObj("concrete_powder", "白色のコンクリートパウダー", 1, Material.CONCRETE_POWDER, 0),
      MineStackBuildObj("concrete_powder1", "橙色のコンクリートパウダー", 1, Material.CONCRETE_POWDER, 1),
      MineStackBuildObj("concrete_powder2", "赤紫色のコンクリートパウダー", 1, Material.CONCRETE_POWDER, 2),
      MineStackBuildObj("concrete_powder3", "空色のコンクリートパウダー", 1, Material.CONCRETE_POWDER, 3),
      MineStackBuildObj("concrete_powder4", "黄色のコンクリートパウダー", 1, Material.CONCRETE_POWDER, 4),
      MineStackBuildObj("concrete_powder5", "黄緑色のコンクリートパウダー", 1, Material.CONCRETE_POWDER, 5),
      MineStackBuildObj("concrete_powder6", "桃色のコンクリートパウダー", 1, Material.CONCRETE_POWDER, 6),
      MineStackBuildObj("concrete_powder7", "灰色のコンクリートパウダー", 1, Material.CONCRETE_POWDER, 7),
      MineStackBuildObj("concrete_powder8", "薄灰色のコンクリートパウダー", 1, Material.CONCRETE_POWDER, 8),
      MineStackBuildObj("concrete_powder9", "水色のコンクリートパウダー", 1, Material.CONCRETE_POWDER, 9),
      MineStackBuildObj("concrete_powder10", "紫色のコンクリートパウダー", 1, Material.CONCRETE_POWDER, 10),
      MineStackBuildObj("concrete_powder11", "青色のコンクリートパウダー", 1, Material.CONCRETE_POWDER, 11),
      MineStackBuildObj("concrete_powder12", "茶色のコンクリートパウダー", 1, Material.CONCRETE_POWDER, 12),
      MineStackBuildObj("concrete_powder13", "緑色のコンクリートパウダー", 1, Material.CONCRETE_POWDER, 13),
      MineStackBuildObj("concrete_powder14", "赤色のコンクリートパウダー", 1, Material.CONCRETE_POWDER, 14),
      MineStackBuildObj("concrete_powder15", "黒色のコンクリートパウダー", 1, Material.CONCRETE_POWDER, 15),
      MineStackBuildObj("white_glazed_terracotta", "白色の彩釉テラコッタ", 1, Material.WHITE_GLAZED_TERRACOTTA, 0),
      MineStackBuildObj("orange_glazed_terracotta", "橙色の彩釉テラコッタ", 1, Material.ORANGE_GLAZED_TERRACOTTA, 0),
      MineStackBuildObj("magenta_glazed_terracotta", "赤紫色の彩釉テラコッタ", 1, Material.MAGENTA_GLAZED_TERRACOTTA, 0),
      MineStackBuildObj("light_blue_glazed_terracotta", "空色の彩釉テラコッタ", 1, Material.LIGHT_BLUE_GLAZED_TERRACOTTA, 0),
      MineStackBuildObj("yellow_glazed_terracotta", "黄色の彩釉テラコッタ", 1, Material.YELLOW_GLAZED_TERRACOTTA, 0),
      MineStackBuildObj("lime_glazed_terracotta", "黄緑色の彩釉テラコッタ", 1, Material.LIME_GLAZED_TERRACOTTA, 0),
      MineStackBuildObj("pink_glazed_terracotta", "桃色の彩釉テラコッタ", 1, Material.PINK_GLAZED_TERRACOTTA, 0),
      MineStackBuildObj("gray_glazed_terracotta", "灰色の彩釉テラコッタ", 1, Material.GRAY_GLAZED_TERRACOTTA, 0),
      MineStackBuildObj("silver_glazed_terracotta", "薄灰色の彩釉テラコッタ", 1, Material.SILVER_GLAZED_TERRACOTTA, 0),
      MineStackBuildObj("cyan_glazed_terracotta", "青緑色の彩釉テラコッタ", 1, Material.CYAN_GLAZED_TERRACOTTA, 0),
      MineStackBuildObj("purple_glazed_terracotta", "紫色の彩釉テラコッタ", 1, Material.PURPLE_GLAZED_TERRACOTTA, 0),
      MineStackBuildObj("blue_glazed_terracotta", "青色の彩釉テラコッタ", 1, Material.BLUE_GLAZED_TERRACOTTA, 0),
      MineStackBuildObj("brown_glazed_terracotta", "茶色の彩釉テラコッタ", 1, Material.BROWN_GLAZED_TERRACOTTA, 0),
      MineStackBuildObj("green_glazed_terracotta", "緑色の彩釉テラコッタ", 1, Material.GREEN_GLAZED_TERRACOTTA, 0),
      MineStackBuildObj("red_glazed_terracotta", "赤色の彩釉テラコッタ", 1, Material.RED_GLAZED_TERRACOTTA, 0),
      MineStackBuildObj("black_glazed_terracotta", "黒色の彩釉テラコッタ", 1, Material.BLACK_GLAZED_TERRACOTTA, 0),
      MineStackBuildObj("wool_0", "羊毛", 1, Material.WOOL, 0),
      MineStackBuildObj("wool_1", "橙色の羊毛", 1, Material.WOOL, 1),
      MineStackBuildObj("wool_2", "赤紫色の羊毛", 1, Material.WOOL, 2),
      MineStackBuildObj("wool_3", "空色の羊毛", 1, Material.WOOL, 3),
      MineStackBuildObj("wool_4", "黄色の羊毛", 1, Material.WOOL, 4),
      MineStackBuildObj("wool_5", "黄緑色の羊毛", 1, Material.WOOL, 5),
      MineStackBuildObj("wool_6", "桃色の羊毛", 1, Material.WOOL, 6),
      MineStackBuildObj("wool_7", "灰色の羊毛", 1, Material.WOOL, 7),
      MineStackBuildObj("wool_8", "薄灰色の羊毛", 1, Material.WOOL, 8),
      MineStackBuildObj("wool_9", "水色の羊毛", 1, Material.WOOL, 9),
      MineStackBuildObj("wool_10", "紫色の羊毛", 1, Material.WOOL, 10),
      MineStackBuildObj("wool_11", "青色の羊毛", 1, Material.WOOL, 11),
      MineStackBuildObj("wool_12", "茶色の羊毛", 1, Material.WOOL, 12),
      MineStackBuildObj("wool_13", "緑色の羊毛", 1, Material.WOOL, 13),
      MineStackBuildObj("wool_14", "赤色の羊毛", 1, Material.WOOL, 14),
      MineStackBuildObj("wool_15", "黒色の羊毛", 1, Material.WOOL, 15),
      MineStackBuildObj("carpet_0", "カーペット", 1, Material.CARPET, 0),
      MineStackBuildObj("carpet_1", "橙色のカーペット", 1, Material.CARPET, 1),
      MineStackBuildObj("carpet_2", "赤紫色のカーペット", 1, Material.CARPET, 2),
      MineStackBuildObj("carpet_3", "空色のカーペット", 1, Material.CARPET, 3),
      MineStackBuildObj("carpet_4", "黄色のカーペット", 1, Material.CARPET, 4),
      MineStackBuildObj("carpet_5", "黄緑色のカーペット", 1, Material.CARPET, 5),
      MineStackBuildObj("carpet_6", "桃色のカーペット", 1, Material.CARPET, 6),
      MineStackBuildObj("carpet_7", "灰色のカーペット", 1, Material.CARPET, 7),
      MineStackBuildObj("carpet_8", "薄灰色のカーペット", 1, Material.CARPET, 8),
      MineStackBuildObj("carpet_9", "水色のカーペット", 1, Material.CARPET, 9),
      MineStackBuildObj("carpet_10", "紫色のカーペット", 1, Material.CARPET, 10),
      MineStackBuildObj("carpet_11", "青色のカーペット", 1, Material.CARPET, 11),
      MineStackBuildObj("carpet_12", "茶色のカーペット", 1, Material.CARPET, 12),
      MineStackBuildObj("carpet_13", "緑色のカーペット", 1, Material.CARPET, 13),
      MineStackBuildObj("carpet_14", "赤色のカーペット", 1, Material.CARPET, 14),
      MineStackBuildObj("carpet_15", "黒色のカーペット", 1, Material.CARPET, 15),
      MineStackBuildObj("glass", "ガラス", 1, Material.GLASS, 0),
      MineStackBuildObj("stained_glass_0", "白色の色付きガラス", 1, Material.STAINED_GLASS, 0),
      MineStackBuildObj("stained_glass_1", "橙色の色付きガラス", 1, Material.STAINED_GLASS, 1),
      MineStackBuildObj("stained_glass_2", "赤紫色の色付きガラス", 1, Material.STAINED_GLASS, 2),
      MineStackBuildObj("stained_glass_3", "空色の色付きガラス", 1, Material.STAINED_GLASS, 3),
      MineStackBuildObj("stained_glass_4", "黄色の色付きガラス", 1, Material.STAINED_GLASS, 4),
      MineStackBuildObj("stained_glass_5", "黄緑色の色付きガラス", 1, Material.STAINED_GLASS, 5),
      MineStackBuildObj("stained_glass_6", "桃色の色付きガラス", 1, Material.STAINED_GLASS, 6),
      MineStackBuildObj("stained_glass_7", "灰色の色付きガラス", 1, Material.STAINED_GLASS, 7),
      MineStackBuildObj("stained_glass_8", "薄灰色の色付きガラス", 1, Material.STAINED_GLASS, 8),
      MineStackBuildObj("stained_glass_9", "水色の色付きガラス", 1, Material.STAINED_GLASS, 9),
      MineStackBuildObj("stained_glass_10", "紫色の色付きガラス", 1, Material.STAINED_GLASS, 10),
      MineStackBuildObj("stained_glass_11", "青色の色付きガラス", 1, Material.STAINED_GLASS, 11),
      MineStackBuildObj("stained_glass_12", "茶色の色付きガラス", 1, Material.STAINED_GLASS, 12),
      MineStackBuildObj("stained_glass_13", "緑色の色付きガラス", 1, Material.STAINED_GLASS, 13),
      MineStackBuildObj("stained_glass_14", "赤色の色付きガラス", 1, Material.STAINED_GLASS, 14),
      MineStackBuildObj("stained_glass_15", "黒色の色付きガラス", 1, Material.STAINED_GLASS, 15),
      MineStackBuildObj("glass_panel", "板ガラス", 1, Material.THIN_GLASS, 0),
      MineStackBuildObj("glass_panel_0", "白色の色付きガラス板", 1, Material.STAINED_GLASS_PANE, 0),
      MineStackBuildObj("glass_panel_1", "橙色の色付きガラス板", 1, Material.STAINED_GLASS_PANE, 1),
      MineStackBuildObj("glass_panel_2", "赤紫色の色付きガラス板", 1, Material.STAINED_GLASS_PANE, 2),
      MineStackBuildObj("glass_panel_3", "空色の色付きガラス板", 1, Material.STAINED_GLASS_PANE, 3),
      MineStackBuildObj("glass_panel_4", "黄色の色付きガラス板", 1, Material.STAINED_GLASS_PANE, 4),
      MineStackBuildObj("glass_panel_5", "黄緑色の色付きガラス板", 1, Material.STAINED_GLASS_PANE, 5),
      MineStackBuildObj("glass_panel_6", "桃色の色付きガラス板", 1, Material.STAINED_GLASS_PANE, 6),
      MineStackBuildObj("glass_panel_7", "灰色の色付きガラス板", 1, Material.STAINED_GLASS_PANE, 7),
      MineStackBuildObj("glass_panel_8", "薄灰色の色付きガラス板", 1, Material.STAINED_GLASS_PANE, 8),
      MineStackBuildObj("glass_panel_9", "水色の色付きガラス板", 1, Material.STAINED_GLASS_PANE, 9),
      MineStackBuildObj("glass_panel_10", "紫色の色付きガラス板", 1, Material.STAINED_GLASS_PANE, 10),
      MineStackBuildObj("glass_panel_11", "青色の色付きガラス板", 1, Material.STAINED_GLASS_PANE, 11),
      MineStackBuildObj("glass_panel_12", "茶色の色付きガラス板", 1, Material.STAINED_GLASS_PANE, 12),
      MineStackBuildObj("glass_panel_13", "緑色の色付きガラス板", 1, Material.STAINED_GLASS_PANE, 13),
      MineStackBuildObj("glass_panel_14", "赤色の色付きガラス板", 1, Material.STAINED_GLASS_PANE, 14),
      MineStackBuildObj("glass_panel_15", "黒色の色付きガラス板", 1, Material.STAINED_GLASS_PANE, 15),
      MineStackBuildObj("dye_1", "赤色の染料", 1, Material.INK_SACK, 1),
      MineStackBuildObj("dye_2", "緑色の染料", 1, Material.INK_SACK, 2),
      MineStackBuildObj("dye_5", "紫色の染料", 1, Material.INK_SACK, 5),
      MineStackBuildObj("dye_6", "水色の染料", 1, Material.INK_SACK, 6),
      MineStackBuildObj("dye_7", "薄灰色の染料", 1, Material.INK_SACK, 7),
      MineStackBuildObj("dye_8", "灰色の染料", 1, Material.INK_SACK, 8),
      MineStackBuildObj("dye_9", "桃色の染料", 1, Material.INK_SACK, 9),
      MineStackBuildObj("dye_10", "黄緑色の染料", 1, Material.INK_SACK, 10),
      MineStackBuildObj("dye_11", "黄色の染料", 1, Material.INK_SACK, 11),
      MineStackBuildObj("dye_12", "空色の染料", 1, Material.INK_SACK, 12),
      MineStackBuildObj("dye_13", "赤紫色の染料", 1, Material.INK_SACK, 13),
      MineStackBuildObj("dye_14", "橙色の染料", 1, Material.INK_SACK, 14),
      MineStackBuildObj("dye_15", "骨粉", 1, Material.INK_SACK, 15),
      MineStackBuildObj("ink_sack0", "イカスミ", 1, Material.INK_SACK, 0)
  )

  // レッドストーン系ブロック
  val minestacklistrs = listOf(
      MineStackRsObj("redstone", "レッドストーン", 1, Material.REDSTONE, 0),
      MineStackRsObj("stone_button", "石のボタン", 1, Material.STONE_BUTTON, 0),
      MineStackRsObj("wood_button", "木のボタン", 1, Material.WOOD_BUTTON, 0),
      MineStackRsObj("stone_plate", "石の感圧版", 1, Material.STONE_PLATE, 0),
      MineStackRsObj("wood_plate", "木の感圧版", 1, Material.WOOD_PLATE, 0),
      MineStackRsObj("fence_gate", "オークのフェンスゲート", 1, Material.FENCE_GATE, 0),
      MineStackRsObj("spruce_fence_gate", "マツのフェンスゲート", 1, Material.SPRUCE_FENCE_GATE, 0),
      MineStackRsObj("birch_fence_gate", "シラカバのフェンスゲート", 1, Material.BIRCH_FENCE_GATE, 0),
      MineStackRsObj("jungle_fence_gate", "ジャングルのフェンスゲート", 1, Material.JUNGLE_FENCE_GATE, 0),
      MineStackRsObj("dark_oak_fence_gate", "ダークオークのフェンスゲート", 1, Material.DARK_OAK_FENCE_GATE, 0),
      MineStackRsObj("acacia_fence_gate", "アカシアのフェンスゲート", 1, Material.ACACIA_FENCE_GATE, 0),
      MineStackRsObj("redstone_block", "レッドストーンブロック", 1, Material.REDSTONE_BLOCK, 0),
      MineStackRsObj("lever", "レバー", 1, Material.LEVER, 0),
      MineStackRsObj("redstone_torch_on", "レッドストーントーチ", 1, Material.REDSTONE_TORCH_ON, 0),
      MineStackRsObj("trap_door", "木のトラップドア", 1, Material.TRAP_DOOR, 0),
      MineStackRsObj("stone_button", "鉄のトラップドア", 1, Material.IRON_TRAPDOOR, 0),
      MineStackRsObj("gold_plate", "重量感圧版 (軽) ", 1, Material.GOLD_PLATE, 0),
      MineStackRsObj("iron_plate", "重量感圧版 (重) ", 1, Material.IRON_PLATE, 0),
      MineStackRsObj("wood_door", "オークのドア", 1, Material.WOOD_DOOR, 0),
      MineStackRsObj("spruce_door_item", "マツのドア", 1, Material.SPRUCE_DOOR_ITEM, 0),
      MineStackRsObj("birch_door_item", "シラカバのドア", 1, Material.BIRCH_DOOR_ITEM, 0),
      MineStackRsObj("jungle_door_item", "ジャングルのドア", 1, Material.JUNGLE_DOOR_ITEM, 0),
      MineStackRsObj("acacia_door_item", "アカシアのドア", 1, Material.ACACIA_DOOR_ITEM, 0),
      MineStackRsObj("dark_oak_door_item", "ダークオークのドア", 1, Material.DARK_OAK_DOOR_ITEM, 0),
      MineStackRsObj("note_block", "音符ブロック", 1, Material.NOTE_BLOCK, 0),
      MineStackRsObj("redstone_lamp_off", "レッドストーンランプ", 1, Material.REDSTONE_LAMP_OFF, 0),
      MineStackRsObj("tripwire_hook", "トリップワイヤーフック", 1, Material.TRIPWIRE_HOOK, 0),
      MineStackRsObj("dropper", "ドロッパー", 1, Material.DROPPER, 0),
      MineStackRsObj("piston_sticky_base", "粘着ピストン", 1, Material.PISTON_STICKY_BASE, 0),
      MineStackRsObj("piston_base", "ピストン", 1, Material.PISTON_BASE, 0),
      MineStackRsObj("tnt", "TNT", 1, Material.TNT, 0),
      MineStackRsObj("trapped_chest", "トラップチェスト", 1, Material.TRAPPED_CHEST, 0),
      MineStackRsObj("daylight_detector", "日照センサー", 1, Material.DAYLIGHT_DETECTOR, 0),
      MineStackRsObj("iron_door", "鉄のドア", 1, Material.IRON_DOOR, 0),
      MineStackRsObj("diode", "レッドストーンリピーター", 1, Material.DIODE, 0),
      MineStackRsObj("dispenser", "ディスペンサー", 1, Material.DISPENSER, 0),
      MineStackRsObj("hopper", "ホッパー", 1, Material.HOPPER, 0),
      MineStackRsObj("redstone_comparator", "レッドストーンコンパレーター", 1, Material.REDSTONE_COMPARATOR, 0),
      MineStackRsObj("powered_rail", "パワードレール", 1, Material.POWERED_RAIL, 0),
      MineStackRsObj("detector_rail", "ディテクターレール", 1, Material.DETECTOR_RAIL, 0),
      MineStackRsObj("activator_rail", "アクティベーターレール", 1, Material.ACTIVATOR_RAIL, 0),
      MineStackRsObj("boat", "オークのボート", 1, Material.BOAT, 0),
      MineStackRsObj("spruce_boat", "マツのボート", 1, Material.BOAT_SPRUCE, 0),
      MineStackRsObj("birch_boat", "シラカバのボート", 1, Material.BOAT_BIRCH, 0),
      MineStackRsObj("jungle_boat", "ジャングルのボート", 1, Material.BOAT_JUNGLE, 0),
      MineStackRsObj("acacia_boat", "アカシアのボート", 1, Material.BOAT_ACACIA, 0),
      MineStackRsObj("dark_oak_boat", "ダークオークのボート", 1, Material.BOAT_DARK_OAK, 0),
      MineStackRsObj("saddle", "サドル", 1, Material.SADDLE, 0),
      MineStackRsObj("minecart", "トロッコ", 1, Material.MINECART, 0),
      MineStackRsObj("chest_minecart", "チェスト付きトロッコ", 1, Material.STORAGE_MINECART, 0),
      MineStackRsObj("furnace_minecart", "かまど付きトロッコ", 1, Material.POWERED_MINECART, 0),
      MineStackRsObj("hopper_minecart", "ホッパー付きトロッコ", 1, Material.HOPPER_MINECART, 0),
      MineStackRsObj("iron_horse_armor", "鉄の馬鎧", 1, Material.IRON_BARDING, 0),
      MineStackRsObj("golden_horse_armor", "金の馬鎧", 1, Material.GOLD_BARDING, 0),
      MineStackRsObj("diamond_horse_armor", "ダイヤの馬鎧", 1, Material.DIAMOND_BARDING, 0),
      MineStackRsObj("record_13", "レコード", 1, Material.GOLD_RECORD, 0),
      MineStackRsObj("record_cat", "レコード", 1, Material.GREEN_RECORD, 0),
      MineStackRsObj("record_blocks", "レコード", 1, Material.RECORD_3, 0),
      MineStackRsObj("record_chirp", "レコード", 1, Material.RECORD_4, 0),
      MineStackRsObj("record_far", "レコード", 1, Material.RECORD_5, 0),
      MineStackRsObj("record_mall", "レコード", 1, Material.RECORD_6, 0),
      MineStackRsObj("record_mellohi", "レコード", 1, Material.RECORD_7, 0),
      MineStackRsObj("record_stal", "レコード", 1, Material.RECORD_8, 0),
      MineStackRsObj("record_strad", "レコード", 1, Material.RECORD_9, 0),
      MineStackRsObj("record_ward", "レコード", 1, Material.RECORD_10, 0),
      MineStackRsObj("record_11", "レコード", 1, Material.RECORD_11, 0),
      MineStackRsObj("record_wait", "レコード", 1, Material.RECORD_12, 0)
  )

  var minestacklist: MutableList<MineStackObj>? = null

  // ガチャ系アイテム
  // これは後に変更されるのでミュータブルでないといけない
  var minestacklistgacha: MutableList<MineStackObj> = mutableListOf(
      MineStackGachaObj("gachaimo", StaticGachaPrizeFactory.getGachaRingoName(), 1, Material.GOLDEN_APPLE, 0, StaticGachaPrizeFactory.getGachaRingoLore()),
      MineStackGachaObj("exp_bottle", "エンチャントの瓶", 1, Material.EXP_BOTTLE, 0)
  )
}
