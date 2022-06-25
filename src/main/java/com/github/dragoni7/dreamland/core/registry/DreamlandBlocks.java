package com.github.dragoni7.dreamland.core.registry;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.blocks.CaveSlimeBlock;
import com.github.dragoni7.dreamland.common.blocks.CaveSlimePlantBlock;
import com.github.dragoni7.dreamland.common.blocks.ClaySoilBlock;
import com.github.dragoni7.dreamland.common.blocks.ClaySoilGrassBlock;
import com.github.dragoni7.dreamland.common.blocks.DarkQuartziteBlock;
import com.github.dragoni7.dreamland.common.blocks.DreamlandSaplingBlock;
import com.github.dragoni7.dreamland.common.blocks.DuskIceBlock;
import com.github.dragoni7.dreamland.common.blocks.EmissiveHiveBlock;
import com.github.dragoni7.dreamland.common.blocks.FloweringUndergrowthBlock;
import com.github.dragoni7.dreamland.common.blocks.GroundPlantBlock;
import com.github.dragoni7.dreamland.common.blocks.HiveBlock;
import com.github.dragoni7.dreamland.common.blocks.HiveClusterBlock;
import com.github.dragoni7.dreamland.common.blocks.HiveGrowthBlock;
import com.github.dragoni7.dreamland.common.blocks.HiveMembraneBlock;
import com.github.dragoni7.dreamland.common.blocks.HiveWeaverBlock;
import com.github.dragoni7.dreamland.common.blocks.InfestedHiveClusterBlock;
import com.github.dragoni7.dreamland.common.blocks.JellySplotchBlock;
import com.github.dragoni7.dreamland.common.blocks.LarvaAngerableBlock;
import com.github.dragoni7.dreamland.common.blocks.OpalClusterBlock;
import com.github.dragoni7.dreamland.common.blocks.OpalDiffuserBlock;
import com.github.dragoni7.dreamland.common.blocks.TarSproutsBlock;
import com.github.dragoni7.dreamland.common.blocks.UndergrowthBlock;
import com.github.dragoni7.dreamland.common.blocks.VioletShrubBlock;
import com.github.dragoni7.dreamland.util.BlockItemSet;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.MudBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
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
	
	public static final BlockItemSet BUMBLE_BLOCK = new BlockItemSet("bumble_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.YELLOW_WOOL)));
	
	public static final BlockItemSet DARK_QUARTZITE = new BlockItemSet("dark_quartzite", () -> new DarkQuartziteBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
	
	public static final BlockItemSet CLAY_SOIL = new BlockItemSet("clay_soil", () -> new ClaySoilBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundType.ROOTED_DIRT)));
	
	public static final BlockItemSet CLAY_SOIL_GRASS = new BlockItemSet("clay_soil_grass", () -> new ClaySoilGrassBlock((BlockBehaviour.Properties.of(Material.GRASS).randomTicks().strength(0.6F).sound(SoundType.GRASS))));
	
	public static final BlockItemSet DUSK_ICE = new BlockItemSet("dusk_ice", 
			() -> new DuskIceBlock(BlockBehaviour.Properties
					.of(Material.ICE)
					.strength(0.5F)
					.sound(SoundType.GLASS)
					.randomTicks()
					.noOcclusion()
					.friction(0.98F)
					.hasPostProcess(DreamlandBlocks::always)
					.emissiveRendering(DreamlandBlocks::always)
					));
	
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
					.noLootTable()
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
					.lightLevel((p_152684_) -> {return 1;})
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
	
	public static final BlockItemSet HIVE_GROWTH = new BlockItemSet("hive_growth",
			() -> new HiveGrowthBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_RED).noOcclusion().sound(SoundType.MOSS_CARPET).instabreak()
					));
	
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
	
	public static final BlockItemSet DRIED_TAR = new BlockItemSet("dried_tar",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));
	
	public static final BlockItemSet TAR_MUD = new BlockItemSet("tar_mud",
			() -> new MudBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).color(MaterialColor.TERRACOTTA_PURPLE).sound(DreamlandSoundTypes.TAR_MUD).isValidSpawn(DreamlandBlocks::always).isRedstoneConductor(DreamlandBlocks::always).isViewBlocking(DreamlandBlocks::always).isSuffocating(DreamlandBlocks::always).sound(SoundType.MUD)));
	
	public static final BlockItemSet PACKED_TAR_MUD = new BlockItemSet("packed_tar_mud",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).strength(1.0F, 3.0F).sound(DreamlandSoundTypes.PACKED_TAR_MUD)));
	
	public static final BlockItemSet TAR_MUD_BRICKS = new BlockItemSet("tar_mud_bricks",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PURPLE).requiresCorrectToolForDrops().strength(1.5F, 3.0F).sound(DreamlandSoundTypes.TAR_MUD_BRICKS)));
	
	@SuppressWarnings("deprecation")
	public static final BlockItemSet TAR_MUD_BRICK_STAIRS = new BlockItemSet("tar_mud_brick_stairs",
			() -> new StairBlock(DreamlandBlocks.TAR_MUD_BRICKS.block().get().defaultBlockState(), BlockBehaviour.Properties.copy(DreamlandBlocks.TAR_MUD_BRICKS.block().get())));
	
	public static final BlockItemSet TAR_MUD_BRICK_SLAB = new BlockItemSet("tar_mud_brick_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PURPLE).requiresCorrectToolForDrops().strength(1.5F, 3.0F).sound(SoundType.MUD_BRICKS)));
	
	public static final BlockItemSet TAR_MUD_BRICK_WALL = new BlockItemSet("tar_mud_brick_wall",
			() -> new WallBlock(BlockBehaviour.Properties.copy(DreamlandBlocks.TAR_MUD_BRICKS.block().get())));
	
	public static final BlockItemSet DROUGHT_SOIL = createDirtBlock("drought_soil");
	
	public static final BlockItemSet TAR_BARK_SAPLING = createSaplingBlock("tar_bark_sapling", DreamlandFeatures.TAR_BARK_TREE_FEATURE);
	
	public static final BlockItemSet TAR_SPROUTS = new BlockItemSet("tar_sprouts",
			() -> new TarSproutsBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
	
	public static final BlockItemSet FOSSILIZED_EGG = new BlockItemSet("fossilized_egg",
			() -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(DreamlandBlocks.TAR_MUD.block().get()).strength(3.0F, 3.0F).sound(SoundType.STONE)));
	
	public static final BlockItemSet ANCIENT_EGG = new BlockItemSet("ancient_egg",
			() -> new Block(BlockBehaviour.Properties.of(Material.EGG).color(MaterialColor.COLOR_BROWN).sound(SoundType.FUNGUS).strength(3.0F, 3.0F).noLootTable().noOcclusion()));
	
	public static final BlockItemSet TAR_BARK_LEAVES = createLeavesBlock("tar_bark_leaves", MaterialColor.COLOR_LIGHT_GREEN);
	
	public static final BlockItemSet PLUM_BIRCH_LEAVES = createLeavesBlock("plum_birch_leaves", MaterialColor.COLOR_BLUE);
	
	public static final BlockItemSet MINERAL_DIRT = createDirtBlock("mineral_dirt");
	
	public static final BlockItemSet FLOWERING_GRASS = new BlockItemSet("flowering_grass",
			() -> new FloweringUndergrowthBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).color(MaterialColor.COLOR_PINK)));
	
	public static final BlockItemSet OPALINE_MARIGOLD = new BlockItemSet("opaline_marigold",
			() -> new FlowerBlock(MobEffects.LUCK, 5, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
	
	public static final BlockItemSet PINK_CRAB_GRASS = new BlockItemSet("pink_crab_grass",
			() -> new GroundPlantBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
	
	public static final BlockItemSet FLOWERING_UNDERGROWTH = new BlockItemSet("flowering_undergrowth",
			() -> new UndergrowthBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).offsetType(BlockBehaviour.OffsetType.NONE)));
	
	public static final BlockItemSet PLUM_BIRCH_SHRUB = new BlockItemSet("plum_birch_shrub",
			() -> new VioletShrubBlock(BlockBehaviour.Properties.copy(Blocks.FLOWERING_AZALEA)));
	
	public static final BlockItemSet OPAL_DIFFUSER_BLOCK = new BlockItemSet("opal_diffuser",
			() -> new OpalDiffuserBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE_TILES).requiresCorrectToolForDrops().strength(0.5F).noOcclusion()));
	
	public static final BlockItemSet OPAL_CLUSTER = new BlockItemSet("opal_cluster",
			() -> new OpalClusterBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 3.0F).sound(SoundType.STONE).requiresCorrectToolForDrops().noOcclusion()));
	
	public static final BlockItemSet PLUM_BIRCH_SAPLING = createSaplingBlock("plum_birch_sapling", DreamlandFeatures.PLUM_BIRCH_TREE_FEATURE);
	
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
