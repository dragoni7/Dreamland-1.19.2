package com.github.dragoni7.dreamland.core.registry;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.blocks.*;
import com.github.dragoni7.dreamland.util.BlockItemSet;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.RedStoneOreBlock;
import net.minecraft.world.level.block.MossBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.MudBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DreamlandBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Dreamland.MODID);
	
		/*public static final BlockItemSet DUSK_ICE = new BlockItemSet("dusk_ice", 
				() -> new DuskIceBlock(BlockBehaviour.Properties
						.of(Material.ICE)
						.strength(0.5F)
						.sound(SoundType.GLASS)
						.randomTicks()
						.noOcclusion()
						.friction(0.98F)
						.hasPostProcess(DreamlandBlocks::always)
						.emissiveRendering(DreamlandBlocks::always)
						)); */
	
	// --------------Midas Caves Blocks--------------
	
	public static final BlockItemSet KUNZITE_STONE = new BlockItemSet("kunzite", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).color(MaterialColor.COLOR_PINK)));
	public static final BlockItemSet COBBLED_KUNZITE_STONE = new BlockItemSet("cobbled_kunzite_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).color(MaterialColor.COLOR_PINK)));
	public static final BlockItemSet KUNZITE_POINT = new BlockItemSet("kunzite_point", () -> new KunzitePointBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).color(MaterialColor.COLOR_PINK).noOcclusion().dynamicShape().hasPostProcess(DreamlandBlocks::always).emissiveRendering(DreamlandBlocks::always).lightLevel((light) -> {return 4;})));
	public static final BlockItemSet KUNZITE_COPPER_ORE = new BlockItemSet("kunzite_copper_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_COPPER_ORE)));
	public static final BlockItemSet KUNZITE_IRON_ORE = new BlockItemSet("kunzite_iron_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)));
	public static final BlockItemSet KUNZITE_LAPIS_ORE = new BlockItemSet("kunzite_lapis_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_LAPIS_ORE)));
	public static final BlockItemSet KUNZITE_REDSTONE_ORE = new BlockItemSet("kunzite_redstone_ore", () -> new RedStoneOreBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_REDSTONE_ORE)));
	public static final BlockItemSet KUNZITE_EMERALD_ORE = new BlockItemSet("kunzite_emerald_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_EMERALD_ORE)));
	public static final BlockItemSet KUNZITE_DIAMOND_ORE = new BlockItemSet("kunzite_diamond_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));
	public static final BlockItemSet GOLD_BEARING_QUARTZITE = new BlockItemSet("gold_bearing_quartzite", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE)));
	public static final BlockItemSet MIDASHROOM = new BlockItemSet("midashroom", () -> new MidashroomBlock(BlockBehaviour.Properties.of(Material.PLANT).color(MaterialColor.GOLD).sound(SoundType.SHROOMLIGHT).strength(2.0F).randomTicks().noOcclusion().hasPostProcess(DreamlandBlocks::always).emissiveRendering(DreamlandBlocks::always)));
	public static final BlockItemSet GOLD_FRONDS = new BlockItemSet("gold_fronds", () -> new GroundPlantBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).color(MaterialColor.GOLD).offsetType(BlockBehaviour.OffsetType.XZ)));
	public static final BlockItemSet GOLDEN_MOSS_CARPET = new BlockItemSet("golden_moss_carpet", () -> new CarpetBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GOLD).strength(0.1F).sound(SoundType.MOSS_CARPET)));
	public static final BlockItemSet GOLDEN_MOSS_BLOCK = new BlockItemSet("golden_moss_block", () -> new MossBlock(BlockBehaviour.Properties.copy(DreamlandBlocks.GOLDEN_MOSS_CARPET.block().get())));	
	public static final BlockItemSet SMALL_GOLDEN_CAP = new BlockItemSet("small_golden_cap", () -> new SmallGoldenCapBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM).color(MaterialColor.GOLD).lightLevel(SmallGoldenCapBlock.emission(1))));
	public static final BlockItemSet GOLDEN_CAP = new BlockItemSet("golden_cap", () -> new GoldenCapBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM_BLOCK).color(MaterialColor.GOLD).strength(0.5F).lightLevel((light) -> {return 3;}).hasPostProcess(DreamlandBlocks::always).emissiveRendering(DreamlandBlocks::always).noOcclusion()));
	public static final BlockItemSet BUDDING_GOLD = new BlockItemSet("budding_gold", () -> new BuddingGoldBlock(BlockBehaviour.Properties.of(Material.STONE).randomTicks().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE).noLootTable()));
	public static final BlockItemSet GOLD_CLUSTER = new BlockItemSet("gold_cluster", () -> new GoldClusterBlock(7, 2, BlockBehaviour.Properties.of(Material.METAL).noOcclusion().sound(SoundType.NETHER_GOLD_ORE).strength(1.5F).lightLevel((light) -> {return 5;})));
	public static final BlockItemSet LARGE_GOLD_CLUSTER = new BlockItemSet("large_gold_cluster", () -> new GoldClusterBlock(5, 2, BlockBehaviour.Properties.copy(GOLD_CLUSTER.block().get()).lightLevel((light) -> {return 4;})));
	public static final BlockItemSet MEDIUM_GOLD_CLUSTER = new BlockItemSet("medium_gold_cluster", () -> new GoldClusterBlock(4, 2, BlockBehaviour.Properties.copy(GOLD_CLUSTER.block().get()).lightLevel((light) -> {return 2;})));	
	public static final BlockItemSet SMALL_GOLD_CLUSTER = new BlockItemSet("small_gold_cluster", () -> new GoldClusterBlock(3, 4, BlockBehaviour.Properties.copy(GOLD_CLUSTER.block().get()).lightLevel((light) -> {return 1;})));	
	public static final BlockItemSet KUNZITE_POINT_BLOCK = new BlockItemSet("kunzite_point_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).color(MaterialColor.COLOR_PINK).hasPostProcess(DreamlandBlocks::always).emissiveRendering(DreamlandBlocks::always).lightLevel((light) -> {return 4;})));	
	public static final BlockItemSet KUNZITE_BARS = new BlockItemSet("kunzite_bars", () -> new IronBarsBlock(BlockBehaviour.Properties.copy(KUNZITE_POINT_BLOCK.block().get()).noOcclusion()));	
	public static final BlockItemSet KUNZITE_BRICKS = new BlockItemSet("kunzite_bricks", () -> new Block(BlockBehaviour.Properties.copy(KUNZITE_STONE.block().get()).sound(SoundType.DEEPSLATE_BRICKS)));	
	public static final BlockItemSet KUNZITE_BRICK_STAIRS = new BlockItemSet("kunzite_brick_stairs", () -> new StairBlock(KUNZITE_BRICKS.block().get().defaultBlockState(), BlockBehaviour.Properties.copy(KUNZITE_BRICKS.block().get())));	
	public static final BlockItemSet KUNZITE_BRICK_SLAB = new BlockItemSet("kunzite_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(KUNZITE_BRICKS.block().get())));	
	public static final BlockItemSet KUNZITE_BRICK_WALL = new BlockItemSet("kunzite_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(KUNZITE_BRICKS.block().get())));	
	public static final BlockItemSet COBBLED_KUNZITE_SLAB = new BlockItemSet("cobbled_kunzite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(COBBLED_KUNZITE_STONE.block().get())));	
	public static final BlockItemSet COBBLED_KUNZITE_STAIRS = new BlockItemSet("cobbled_kunzite_stairs", () -> new StairBlock(COBBLED_KUNZITE_STONE.block().get().defaultBlockState(), BlockBehaviour.Properties.copy(COBBLED_KUNZITE_STONE.block().get())));	
	public static final BlockItemSet COBBLED_KUNZITE_WALL = new BlockItemSet("cobbled_kunzite_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(COBBLED_KUNZITE_STONE.block().get())));	
	public static final BlockItemSet CHISELED_KUNZITE = new BlockItemSet("chiseled_kunzite", () -> new Block(BlockBehaviour.Properties.copy(KUNZITE_BRICKS.block().get())));	
	public static final BlockItemSet KUNZITE_TILE = new BlockItemSet("kunzite_tile", () -> new Block(BlockBehaviour.Properties.copy(KUNZITE_BRICKS.block().get())));
	
	// --------------Hive Blocks--------------
	
	public static final BlockItemSet HIVE_BLOCK = new BlockItemSet("hive_block", 
			() -> new HiveBlock(BlockBehaviour.Properties
					.of(Material.STONE, MaterialColor.COLOR_PURPLE)
					.requiresCorrectToolForDrops()
					.strength(1.5F, 6.0F)
					.sound(DreamlandSoundTypes.HIVE_BLOCK)
					));
	
	public static final BlockItemSet CAVE_SLIME = new BlockItemSet("cave_slime", 
			() -> new CaveSlimeBlock(BlockBehaviour.Properties
					.of(Material.PLANT, MaterialColor.COLOR_CYAN)
					.sound(SoundType.HONEY_BLOCK)
					.noCollission()
					.instabreak()
					.randomTicks()
					.lightLevel(CaveSlimePlantBlock.emission(5))
					));
	
	public static final RegistryObject<Block> CAVE_SLIME_PLANT = BLOCKS.register("cave_slime_plant", 
			() -> new CaveSlimePlantBlock(BlockBehaviour.Properties
					.of(Material.PLANT, MaterialColor.COLOR_CYAN)
					.sound(SoundType.HONEY_BLOCK)
					.noCollission()
					.instabreak()
					.lightLevel(CaveSlimePlantBlock.emission(5))
					));
	
	public static final BlockItemSet HIVE_JELLY_CLUSTER = new BlockItemSet("hive_jelly_cluster",
			() -> new HiveClusterBlock(BlockBehaviour.Properties
					.of(Material.CLAY, MaterialColor.COLOR_CYAN)
					.strength(1.5F, 6.0F)
					.requiresCorrectToolForDrops()
					.sound(DreamlandSoundTypes.HIVE_JELLY)
					.noOcclusion()
					.lightLevel(HiveClusterBlock.emission(5))
					));
	
	public static final BlockItemSet INFESTED_HIVE_JELLY_CLUSTER = new BlockItemSet("infested_hive_jelly_cluster",
			() -> new InfestedHiveClusterBlock(BlockBehaviour.Properties
					.of(Material.CLAY, MaterialColor.COLOR_CYAN)
					.strength(1.5F, 6.0F)
					.requiresCorrectToolForDrops()
					.sound(DreamlandSoundTypes.HIVE_JELLY)
					.noOcclusion()
					.randomTicks()
					.lightLevel(InfestedHiveClusterBlock.emission(5))
					));
	
	public static final BlockItemSet HIVE_MEMBRANE = new BlockItemSet("hive_membrane",
			() -> new HiveMembraneBlock(BlockBehaviour.Properties
					.of(Material.SPONGE, MaterialColor.COLOR_CYAN)
					.strength(-1.0F, 3600000.0F)
					.noLootTable()
					.sound(DreamlandSoundTypes.HIVE_JELLY)
					.noOcclusion()
					.randomTicks()
					.noLootTable()
					.hasPostProcess(DreamlandBlocks::always)
					.emissiveRendering(DreamlandBlocks::always)
					.lightLevel((light) -> {return 2;})
					));
	
	public static final BlockItemSet HIVE_WEAVER = new BlockItemSet("hive_weaver",
			() -> new HiveWeaverBlock(BlockBehaviour.Properties
					.of(Material.SPONGE, MaterialColor.COLOR_CYAN)
					.strength(1.5F, 6.0F)
					.requiresCorrectToolForDrops()
					.sound(DreamlandSoundTypes.HIVE_BLOCK)
					.noOcclusion()));
	
	public static final BlockItemSet HIVE_BLOCK_WITH_JELLY = new BlockItemSet("hive_block_with_jelly",
			() -> new EmissiveHiveBlock(BlockBehaviour.Properties
					.of(Material.SPONGE)
					.strength(1.5F, 6.0F)
					.requiresCorrectToolForDrops()
					.sound(DreamlandSoundTypes.HIVE_BLOCK)
					.lightLevel(EmissiveHiveBlock.emission(6))
					));
	
	public static final BlockItemSet HIVE_GROWTH = new BlockItemSet("hive_growth", () -> new HiveGrowthBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_RED).noOcclusion().sound(SoundType.NETHER_SPROUTS).instabreak()));
	
	public static final RegistryObject<Block> JELLY_SPLOTCH = BLOCKS.register("jelly_splotch",
			() -> new JellySplotchBlock(BlockBehaviour.Properties
					.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_CYAN)
					.strength(0.2F)
					.noCollission()
					.sound(DreamlandSoundTypes.HIVE_JELLY)
					.noLootTable()
					.lightLevel(JellySplotchBlock.emission(7))
					));
	
	public static final BlockItemSet HIVE_IRON = createHiveOre("hive_iron");
	public static final BlockItemSet HIVE_GOLD = createHiveOre("hive_gold");
	public static final BlockItemSet HIVE_REDSTONE = createHiveOre("hive_redstone");
	public static final BlockItemSet HIVE_DIAMOND = createHiveOre("hive_diamond");
	public static final BlockItemSet HIVE_COPPER = createHiveOre("hive_copper");
	public static final BlockItemSet HIVE_LAPIS = createHiveOre("hive_lapis");
	
	// --------------Tar Deltas Blocks--------------
	
	public static final BlockItemSet DRIED_TAR = new BlockItemSet("dried_tar", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));	
	public static final BlockItemSet TAR_MUD = new BlockItemSet("tar_mud", () -> new MudBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).color(MaterialColor.TERRACOTTA_PURPLE).sound(DreamlandSoundTypes.TAR_MUD).isValidSpawn(DreamlandBlocks::always).isRedstoneConductor(DreamlandBlocks::always).isViewBlocking(DreamlandBlocks::always).isSuffocating(DreamlandBlocks::always).sound(SoundType.MUD)));	
	public static final BlockItemSet PACKED_TAR_MUD = new BlockItemSet("packed_tar_mud", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).strength(1.0F, 3.0F).sound(DreamlandSoundTypes.PACKED_TAR_MUD)));	
	public static final BlockItemSet TAR_MUD_BRICKS = new BlockItemSet("tar_mud_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PURPLE).requiresCorrectToolForDrops().strength(1.5F, 3.0F).sound(DreamlandSoundTypes.TAR_MUD_BRICKS)));	
	@SuppressWarnings("deprecation")
	public static final BlockItemSet TAR_MUD_BRICK_STAIRS = new BlockItemSet("tar_mud_brick_stairs", () -> new StairBlock(DreamlandBlocks.TAR_MUD_BRICKS.block().get().defaultBlockState(), BlockBehaviour.Properties.copy(DreamlandBlocks.TAR_MUD_BRICKS.block().get())));
	public static final BlockItemSet TAR_MUD_BRICK_SLAB = new BlockItemSet("tar_mud_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PURPLE).requiresCorrectToolForDrops().strength(1.5F, 3.0F).sound(SoundType.MUD_BRICKS)));	
	public static final BlockItemSet TAR_MUD_BRICK_WALL = new BlockItemSet("tar_mud_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(DreamlandBlocks.TAR_MUD_BRICKS.block().get())));	
	public static final BlockItemSet DROUGHT_SOIL = createDirtBlock("drought_soil");	
	public static final BlockItemSet TAR_BARK_SAPLING = createSaplingBlock("tar_bark_sapling", DreamlandFeatures.TAR_BARK_TREE_FEATURE);	
	public static final BlockItemSet TAR_SPROUTS = new BlockItemSet("tar_sprouts", () -> new TarSproutsBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));	
	public static final BlockItemSet FOSSILIZED_EGG = new BlockItemSet("fossilized_egg", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(DreamlandBlocks.TAR_MUD.block().get()).strength(3.0F, 3.0F).sound(SoundType.STONE)));
	public static final BlockItemSet ANCIENT_EGG = new BlockItemSet("ancient_egg", () -> new Block(BlockBehaviour.Properties.of(Material.EGG).color(MaterialColor.COLOR_BROWN).sound(SoundType.FUNGUS).strength(3.0F, 3.0F).noLootTable().noOcclusion()));	
	public static final BlockItemSet OOZE_BLOCK = new BlockItemSet("ooze_block", () -> new OozeBlock(BlockBehaviour.Properties.of(Material.CLAY, MaterialColor.COLOR_PURPLE).sound(SoundType.SLIME_BLOCK).noOcclusion().friction(0.8f).strength(0.5f)));	
	public static final BlockItemSet TAR_BARK_LEAVES = createLeavesBlock("tar_bark_leaves", MaterialColor.COLOR_LIGHT_GREEN);
	
	// --------------Jeweled Forest Blocks--------------
	
	public static final BlockItemSet BUMBLE_BLOCK = new BlockItemSet("bumble_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.YELLOW_WOOL).sound(DreamlandSoundTypes.BUMBLE_BLOCK).noOcclusion()));
	public static final BlockItemSet PLUM_BIRCH_LEAVES = createLeavesBlock("plum_birch_leaves", MaterialColor.COLOR_BLUE);	
	public static final BlockItemSet MINERAL_DIRT = createDirtBlock("mineral_dirt");	
	public static final BlockItemSet FLOWERING_GRASS = new BlockItemSet("flowering_grass", () -> new FloweringUndergrowthBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).color(MaterialColor.COLOR_PINK)));	
	public static final BlockItemSet OPALINE_MARIGOLD = new BlockItemSet("opaline_marigold", () -> new FlowerBlock(MobEffects.LUCK, 5, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));	
	public static final BlockItemSet PINK_CRAB_GRASS = new BlockItemSet("pink_crab_grass", () -> new GroundPlantBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));	
	public static final BlockItemSet FLOWERING_UNDERGROWTH = new BlockItemSet("flowering_undergrowth", () -> new UndergrowthBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).offsetType(BlockBehaviour.OffsetType.NONE)));	
	public static final BlockItemSet PLUM_BIRCH_SHRUB = new BlockItemSet("plum_birch_shrub", () -> new VioletShrubBlock(BlockBehaviour.Properties.copy(Blocks.FLOWERING_AZALEA)));
	public static final BlockItemSet OPAL_DIFFUSER_BLOCK = new BlockItemSet("opal_diffuser", () -> new OpalDiffuserBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE_TILES).requiresCorrectToolForDrops().strength(0.5F).noOcclusion()));
	public static final BlockItemSet OPAL_CLUSTER = new BlockItemSet("opal_cluster", () -> new OpalClusterBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 3.0F).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion()));
	public static final BlockItemSet OPAL_BLOCK = new BlockItemSet("opal_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK)));
	public static final BlockItemSet PRECIOUS_OPAL_BLOCK = new BlockItemSet("precious_opal_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));
	public static final BlockItemSet OPAL_TILE = new BlockItemSet("opal_tile", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
	public static final BlockItemSet OPAL_SLAB = new BlockItemSet("opal_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));
	public static final BlockItemSet OPAL_STAIRS = new BlockItemSet("opal_stairs", () -> new StairBlock(() -> DreamlandBlocks.OPAL_TILE.block().get().defaultBlockState(), BlockBehaviour.Properties.copy(DreamlandBlocks.OPAL_TILE.block().get())));
	public static final BlockItemSet OPAL_WALL = new BlockItemSet("opal_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));
	public static final BlockItemSet PRECIOUS_OPAL_TILE = new BlockItemSet("precious_opal_tile", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
	public static final BlockItemSet PRECIOUS_OPAL_LAMP = new BlockItemSet("precious_opal_lamp", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SEA_LANTERN).color(MaterialColor.COLOR_PURPLE)));
	public static final BlockItemSet PRECIOUS_OPAL_SLAB = new BlockItemSet("precious_opal_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));
	public static final BlockItemSet PRECIOUS_OPAL_STAIRS = new BlockItemSet("precious_opal_stairs", () -> new StairBlock(() -> DreamlandBlocks.OPAL_TILE.block().get().defaultBlockState(), BlockBehaviour.Properties.copy(DreamlandBlocks.PRECIOUS_OPAL_TILE.block().get())));
	public static final BlockItemSet PRECIOUS_OPAL_WALL = new BlockItemSet("precious_opal_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));
	public static final BlockItemSet JEWELED_DEEPSLATE = new BlockItemSet("jeweled_deepslate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE)));
	public static final BlockItemSet PLUM_BIRCH_SAPLING = createSaplingBlock("plum_birch_sapling", DreamlandFeatures.PLUM_BIRCH_TREE_FEATURE);
	
	// --------------Toxic Jungle Blocks--------------
	
	public static final BlockItemSet WHITE_MOLD = new BlockItemSet("white_mold", () -> new MoldBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_LIGHT_BLUE).sound(SoundType.MOSS).strength(0.1F).noOcclusion().isViewBlocking(DreamlandBlocks::always).randomTicks()));
	public static final BlockItemSet WHITE_MOLD_CARPET = new BlockItemSet("white_mold_carpet", () -> new CarpetBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_LIGHT_BLUE).strength(0.1F).sound(SoundType.MOSS_CARPET)));
	public static final BlockItemSet BLACK_MOLD = new BlockItemSet("black_mold", () -> new MoldBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.COLOR_BLACK).sound(SoundType.MOSS).strength(0.3F).noOcclusion().isViewBlocking(DreamlandBlocks::always).randomTicks()));
	public static final BlockItemSet BLACK_MOLD_CARPET = new BlockItemSet("black_mold_carpet", () -> new CarpetBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BLACK).strength(0.2F).sound(SoundType.MOSS_CARPET)));
	public static final BlockItemSet POROUS_STONE = new BlockItemSet("porous_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(1.2F, 5.2F)));
	public static final BlockItemSet OVERGROWN_POROUS_STONE = new BlockItemSet("overgrown_porous_stone", () -> new Block(BlockBehaviour.Properties.copy(POROUS_STONE.block().get())));
	public static final BlockItemSet MOLDED_STONE = new BlockItemSet("molded_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).color(MaterialColor.COLOR_GREEN).sound(SoundType.TUFF)));
	public static final BlockItemSet PETRIFIED_VEGETATION = new BlockItemSet("petrified_vegetation", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).color(MaterialColor.COLOR_LIGHT_GREEN)));
	public static final BlockItemSet SPORE_PUFF = new BlockItemSet("spore_puff", () -> new MoldVegetationBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
	public static final BlockItemSet SPONGE_PUFF = new BlockItemSet("sponge_puff", () -> new MoldVegetationBlock(BlockBehaviour.Properties.copy(SPORE_PUFF.block().get()).sound(SoundType.NETHER_SPROUTS)));
	public static final BlockItemSet TOXIC_DIRT = createDirtBlock("toxic_dirt");
	public static final BlockItemSet TOXIC_GRASS = new BlockItemSet("toxic_grass", () -> new ToxicGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));
	public static final BlockItemSet TOXIC_VEGETATION = new BlockItemSet("toxic_vegetation", () -> new Block(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).strength(0.2F).sound(SoundType.AZALEA_LEAVES)));
	public static final BlockItemSet DECAYED_VEGETATION = new BlockItemSet("decayed_vegetation", () -> new Block(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.COLOR_GREEN).strength(1.5F, 1.0F).sound(SoundType.HARD_CROP)));
	public static final BlockItemSet SHELF_VEGETATION = new BlockItemSet("shelf_vegetation", () -> new ShelfVegetationBlock(BlockBehaviour.Properties.copy(Blocks.GLOW_LICHEN)));
	public static final BlockItemSet GLOWING_MOLD_WOOD = new BlockItemSet("glowing_mold_wood", () -> new EmissiveRotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GREEN).sound(SoundType.WOOD).strength(2.0F, 3.0F).lightLevel(EmissiveRotatedPillarBlock.emission(8)))))));
	public static final BlockItemSet GLOW_FRONDS = new BlockItemSet("glow_fronds", () -> new MoldVegetationBlock(BlockBehaviour.Properties.copy(SPORE_PUFF.block().get()).lightLevel((light) -> {return 8;}).hasPostProcess(DreamlandBlocks::always).emissiveRendering(DreamlandBlocks::always)))));
	public static final BlockItemSet LARGE_SPORE_PUFF = new BlockItemSet("large_spore_puff", () -> new LargeSporePuffBlock(BlockBehaviour.Properties.copy(SPORE_PUFF.block().get()).noOcclusion()));
	public static final BlockItemSet SPORE_NODE = new BlockItemSet("spore_node", () -> new SporeNodeBlock(BlockBehaviour.Properties.of(Material.WEB, MaterialColor.COLOR_LIGHT_BLUE).sound(SoundType.WOOL).strength(1.5F, 1.0F).noOcclusion().randomTicks()));
	
	private static BlockItemSet createSaplingBlock(String name, Feature<NoneFeatureConfiguration> tree) {
		return new BlockItemSet(name, () -> new DreamlandSaplingBlock(tree, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	}
	
	private static BlockItemSet createLeavesBlock(String name, MaterialColor color) {
		return new BlockItemSet(name, () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, color).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)));
	}
	
	private static BlockItemSet createDirtBlock(String name) {
		return new BlockItemSet(name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
	}
	
	private static BlockItemSet createHiveOre(String name) {
		return new BlockItemSet(name,
				() -> new LarvaAngerableBlock(BlockBehaviour.Properties
						.of(Material.STONE)
						.strength(3.0F, 3.0F)
						.sound(DreamlandSoundTypes.HIVE_BLOCK)
						.requiresCorrectToolForDrops()
						));
	}
	
	private static boolean always(BlockState state, BlockGetter getter, BlockPos pos) {
	    return true;
	 }
	
	private static Boolean always(BlockState sate, BlockGetter getter, BlockPos pos, EntityType<?> type) {
	    return (boolean)true;
	 }
}
