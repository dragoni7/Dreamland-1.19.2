package com.github.dragoni7.dreamland.common.world.feature;

import java.util.ArrayList;
import java.util.List;

import com.github.dragoni7.dreamland.common.blocks.KunzitePointBlock;
import com.github.dragoni7.dreamland.common.world.feature.configs.EllipsoidConfig;
import com.github.dragoni7.dreamland.common.world.feature.generation.SurfaceLake;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandFeatures;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.github.dragoni7.dreamland.data.DreamlandBlockTags;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DeltaFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SpringConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class DreamlandConfiguredFeatures {
	
	public static final RuleTest KUNZITE_ORES_REPLACEABLE = new TagMatchTest(DreamlandBlockTags.KUNZITE_ORES_REPLACEABLE);
	public static final RuleTest HIVE_ORES_REPLACEABLE = new TagMatchTest(DreamlandBlockTags.HIVE_ORES_REPLACEABLE);
	public static final RuleTest FOSSILIZED_EGG_REPLACEABLE = new TagMatchTest(DreamlandBlockTags.FOSSILIZED_EGG_REPLACEABLE);
	
	public static final List<OreConfiguration.TargetBlockState> KUNZITE_COPPER_TARGET_LIST = List.of(OreConfiguration.target(KUNZITE_ORES_REPLACEABLE, DreamlandBlocks.KUNZITE_COPPER_ORE.block().get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> KUNZITE_IRON_TARGET_LIST = List.of(OreConfiguration.target(KUNZITE_ORES_REPLACEABLE, DreamlandBlocks.KUNZITE_IRON_ORE.block().get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> KUNZITE_REDSTONE_TARGET_LIST = List.of(OreConfiguration.target(KUNZITE_ORES_REPLACEABLE, DreamlandBlocks.KUNZITE_REDSTONE_ORE.block().get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> KUNZITE_LAPIS_TARGET_LIST = List.of(OreConfiguration.target(KUNZITE_ORES_REPLACEABLE, DreamlandBlocks.KUNZITE_LAPIS_ORE.block().get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> KUNZITE_EMERALD_TARGET_LIST = List.of(OreConfiguration.target(KUNZITE_ORES_REPLACEABLE, DreamlandBlocks.KUNZITE_EMERALD_ORE.block().get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> KUNZITE_DIAMOND_TARGET_LIST = List.of(OreConfiguration.target(KUNZITE_ORES_REPLACEABLE, DreamlandBlocks.KUNZITE_DIAMOND_ORE.block().get().defaultBlockState()));
	
	public static final List<OreConfiguration.TargetBlockState> FILLED_HIVE_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.block().get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_IRON_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_IRON.block().get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_COPPER_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_COPPER.block().get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_GOLD_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_GOLD.block().get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_REDSTONE_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_REDSTONE.block().get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_LAPIS_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_LAPIS.block().get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_DIAMOND_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_DIAMOND.block().get().defaultBlockState()));
	
	private static final ArrayList<ResourceKey<ConfiguredFeature<?,?>>> KEYS = new ArrayList<ResourceKey<ConfiguredFeature<?,?>>>();
	
	// KEYS
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_CAVE_SLIME_KEY = createConfiguredFeatureKey("cave_slime");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_COMB_KEY = createConfiguredFeatureKey("hive_comb");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_STRAND_KEY = createConfiguredFeatureKey("hive_strand");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_JELLY_CLUSTER_KEY = createConfiguredFeatureKey("hive_jelly_cluster");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_INFESTED_HIVE_JELLY_CLUSTER_KEY = createConfiguredFeatureKey("infested_hive_jelly_cluster");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_GROWTH_KEY = createConfiguredFeatureKey("hive_growth");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_FILLED_HIVE_BLOCK_KEY = createConfiguredFeatureKey("filled_hive_block");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_IRON_KEY = createConfiguredFeatureKey("hive_iron");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_GOLD_KEY = createConfiguredFeatureKey("hive_gold");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_REDSTONE_KEY = createConfiguredFeatureKey("hive_redstone");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_LAPIS_KEY = createConfiguredFeatureKey("hive_lapis");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_COPPER_KEY = createConfiguredFeatureKey("hive_copper");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_COPPER_LARGE_KEY = createConfiguredFeatureKey("hive_copper_large");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_DIAMOND_KEY = createConfiguredFeatureKey("hive_diamond");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_DIAMOND_LARGE_KEY = createConfiguredFeatureKey("hive_diamond_large");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_BORDERED_DROUGHT_DISK_KEY = createConfiguredFeatureKey("bordered_drought_disk");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_TAR_DELTA_KEY = createConfiguredFeatureKey("tar_delta");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_DROUGHT_VEGETATION_KEY =  createConfiguredFeatureKey("drought_vegetation");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_TAR_BARK_TREE_KEY = createConfiguredFeatureKey("tar_bark_tree");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_TAR_SPROUTS_KEY = createConfiguredFeatureKey("tar_sprouts");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_TAR_SKELETON_KEY = createConfiguredFeatureKey("tar_skeleton");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_TAR_BONE_KEY = createConfiguredFeatureKey("tar_bone");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_TAR_SOIL_ORE_KEY = createConfiguredFeatureKey("tar_soil_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_LAKE_TAR_KEY = createConfiguredFeatureKey("lake_tar");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_FOSSILIZED_EGG_KEY = createConfiguredFeatureKey("fossilized_egg");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_SPRING_TAR_KEY = createConfiguredFeatureKey("spring_tar");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_PLUM_BIRCH_TREE_KEY = createConfiguredFeatureKey("plum_birch_tree");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_PLUM_BIRCH_LAKE = createConfiguredFeatureKey("plum_birch_lake");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_JEWELED_FOREST_VEGETATION_KEY = createConfiguredFeatureKey("jeweled_forest_vegetation");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_FLOWERING_UNDERGROWTH_KEY = createConfiguredFeatureKey("flowering_undergrowth");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_CALCITE_ROCK_KEY = createConfiguredFeatureKey("calcite_rock");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_CAVE_KEY = createConfiguredFeatureKey("hive_cave");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_OPAL_CLUSTER_KEY = createConfiguredFeatureKey("opal_cluster");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_POINTS_DOWN_KEY = createConfiguredFeatureKey("kunzite_points_down");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_POINTS_EAST_KEY = createConfiguredFeatureKey("kunzite_points_east");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_POINTS_NORTH_KEY = createConfiguredFeatureKey("kunzite_points_north");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_POINTS_PATCH_DOWN = createConfiguredFeatureKey("kunzite_points_patch_down");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_POINTS_PATCH_UP = createConfiguredFeatureKey("kunzite_points_patch_up");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_POINTS_SOUTH_KEY = createConfiguredFeatureKey("kunzite_points_south");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_POINTS_UP_KEY = createConfiguredFeatureKey("kunzite_points_up");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_POINTS_WEST_KEY = createConfiguredFeatureKey("kunzite_points_west");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_IRON_KEY = createConfiguredFeatureKey("kunzite_iron_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_IRON_SMALL_KEY = createConfiguredFeatureKey("kunzite_iron_small_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_EMERALD_KEY = createConfiguredFeatureKey("kunzite_emerald_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_REDSTONE_KEY = createConfiguredFeatureKey("kunzite_redstone_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_LAPIS_KEY = createConfiguredFeatureKey("kunzite_lapis_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_COPPER_KEY = createConfiguredFeatureKey("kunzite_copper_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_COPPER_LARGE_KEY = createConfiguredFeatureKey("kunzite_copper_large_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_DIAMOND_KEY = createConfiguredFeatureKey("kunzite_diamond_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_KUNZITE_DIAMOND_LARGE_KEY = createConfiguredFeatureKey("kunzite_diamond_large_ore");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_GOLDEN_MOSS_VEGETATION_KEY = createConfiguredFeatureKey("golden_moss_vegetation");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_GOLDEN_MOSS_PATCH_KEY = createConfiguredFeatureKey("golden_moss_patch");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_GOLDEN_CAP_KEY = createConfiguredFeatureKey("golden_cap");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_GOLD_GEODE_KEY = createConfiguredFeatureKey("gold_geode");
	
	public static ArrayList<ResourceKey<ConfiguredFeature<?, ?>>> getKeys() {
		return KEYS;
	}
	
	public static final Holder<ConfiguredFeature<BlockColumnConfiguration, ?>> CAVE_SLIME = registerConfiguredFeature("cave_slime", 
			Feature.BLOCK_COLUMN,
					new BlockColumnConfiguration(
							List.of(BlockColumnConfiguration.layer(
									new WeightedListInt(
											SimpleWeightedRandomList.<IntProvider>builder()
											.add(UniformInt.of(0, 19), 2)
											.add(UniformInt.of(0, 2), 3)
											.add(UniformInt.of(0, 6), 10)
											.build()), 
									BlockStateProvider.simple(
											DreamlandBlocks.CAVE_SLIME_PLANT.get())),
									BlockColumnConfiguration.layer(
											ConstantInt.of(1), 
											BlockStateProvider.simple(
													DreamlandBlocks.CAVE_SLIME.block().get()))),
							Direction.DOWN, 
							BlockPredicate.ONLY_IN_AIR_PREDICATE, 
							true));
	
	public static final Holder<ConfiguredFeature<BlockStateConfiguration,?>> HIVE_COMB = registerConfiguredFeature("hive_comb", DreamlandFeatures.HIVE_COMB, new BlockStateConfiguration(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.block().get().defaultBlockState()));
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> HIVE_STRAND = registerConfiguredFeature("hive_strand", DreamlandFeatures.HIVE_STRAND, new NoneFeatureConfiguration());
	public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> HIVE_JELLY_CLUSTER = registerConfiguredFeature("hive_jelly_cluster", Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DreamlandBlocks.HIVE_JELLY_CLUSTER.block().get())));
	public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> INFESTED_HIVE_JELLY_CLUSTER = registerConfiguredFeature("infested_hive_jelly_cluster", Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DreamlandBlocks.INFESTED_HIVE_JELLY_CLUSTER.block().get())));
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> HIVE_GROWTH = registerConfiguredFeature("hive_growth", DreamlandFeatures.HIVE_GROWTH_LAYER, new NoneFeatureConfiguration());
	
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> FILLED_HIVE_BLOCK = registerConfiguredFeature("filled_hive_block", Feature.ORE, new OreConfiguration(FILLED_HIVE_TARGET_LIST, 10));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_IRON = registerConfiguredFeature("hive_iron", Feature.ORE, new OreConfiguration(HIVE_IRON_TARGET_LIST, 9));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_GOLD = registerConfiguredFeature("hive_gold", Feature.ORE, new OreConfiguration(HIVE_GOLD_TARGET_LIST, 4, 0.5F));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_REDSTONE = registerConfiguredFeature("hive_redstone", Feature.ORE, new OreConfiguration(HIVE_REDSTONE_TARGET_LIST, 8));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_LAPIS = registerConfiguredFeature("hive_lapis", Feature.ORE, new OreConfiguration(HIVE_LAPIS_TARGET_LIST, 7));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_COPPER = registerConfiguredFeature("hive_copper", Feature.ORE, new OreConfiguration(HIVE_COPPER_TARGET_LIST, 10));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_COPPER_LARGE = registerConfiguredFeature("hive_copper_large", Feature.ORE, new OreConfiguration(HIVE_COPPER_TARGET_LIST, 20));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_DIAMOND = registerConfiguredFeature("hive_diamond", Feature.ORE, new OreConfiguration(HIVE_DIAMOND_TARGET_LIST, 4, 0.5F));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_DIAMOND_LARGE = registerConfiguredFeature("hive_diamond_large", Feature.ORE, new OreConfiguration(HIVE_DIAMOND_TARGET_LIST, 12, 0.7F));
	public static final Holder<ConfiguredFeature<EllipsoidConfig, ?>> HIVE_CAVE = registerConfiguredFeature("hive_cave", DreamlandFeatures.ELLIPSOID, new EllipsoidConfig(BlockStateProvider.simple(Blocks.CAVE_AIR), BlockStateProvider.simple(Blocks.CAVE_AIR), UniformInt.of(4, 16), UniformInt.of(2, 8), UniformInt.of(2, 12))); 
	
	public static final Holder<ConfiguredFeature<SurfaceLake.Configuration, ?>> DROUGHT_BORDERED_DISK = registerConfiguredFeature("bordered_drought_disk", DreamlandFeatures.SURFACE_LAKE, new SurfaceLake.Configuration(BlockStateProvider.simple(DreamlandBlocks.DROUGHT_SOIL.block().get().defaultBlockState()), BlockStateProvider.simple(DreamlandBlocks.DRIED_TAR.block().get().defaultBlockState())));
	public static final Holder<ConfiguredFeature<DeltaFeatureConfiguration, ?>> TAR_DELTA = registerConfiguredFeature("tar_delta", Feature.DELTA_FEATURE, new DeltaFeatureConfiguration(DreamlandFluids.TAR_BLOCK.get().defaultBlockState(), DreamlandBlocks.DRIED_TAR.block().get().defaultBlockState(), UniformInt.of(3, 7), UniformInt.of(1, 4)));
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> DROUGHT_VEGETATION = registerConfiguredFeature("drought_vegetation", Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OXEYE_DAISY.defaultBlockState(), 10).add(Blocks.DEAD_BUSH.defaultBlockState(), 40).add(Blocks.GRASS.defaultBlockState(), 50))))));
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> TAR_BARK_TREE = registerConfiguredFeature("tar_bark_tree", DreamlandFeatures.TAR_BARK_TREE_FEATURE, new NoneFeatureConfiguration());
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TAR_SPROUTS = registerConfiguredFeature("tar_sprouts", Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DreamlandBlocks.TAR_SPROUTS.block().get())))));
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> TAR_SKELETON = registerConfiguredFeature("tar_skeleton", DreamlandFeatures.TAR_SKELETON, new NoneFeatureConfiguration());
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> TAR_BONE = registerConfiguredFeature("tar_bone", DreamlandFeatures.TAR_BONE, new NoneFeatureConfiguration());
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> TAR_SOIL_ORE = registerConfiguredFeature("tar_soil_ore", Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, DreamlandBlocks.TAR_MUD.block().get().defaultBlockState(), 64));
	public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> FOSSILIZED_EGG = registerConfiguredFeature("fossilized_egg", Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DreamlandBlocks.FOSSILIZED_EGG.block().get())));
	
	@SuppressWarnings("deprecation")
	public static final Holder<ConfiguredFeature<LakeFeature.Configuration, ?>> LAKE_TAR = registerConfiguredFeature("lake_tar", Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(DreamlandFluids.TAR_BLOCK.get()), BlockStateProvider.simple(Blocks.STONE.defaultBlockState())));
	public static final Holder<ConfiguredFeature<SpringConfiguration, ?>> SPRING_TAR = registerConfiguredFeature("spring_tar", Feature.SPRING, new SpringConfiguration(DreamlandFluids.TAR_FLUID.get().defaultFluidState(), true, 4, 1, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.DEEPSLATE, Blocks.TUFF, Blocks.CALCITE, Blocks.DIRT)));
	
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> PLUM_BIRCH_TREE = registerConfiguredFeature("plum_birch_tree", DreamlandFeatures.PLUM_BIRCH_TREE_FEATURE, new NoneFeatureConfiguration());
	public static final Holder<ConfiguredFeature<SurfaceLake.Configuration, ?>> PLUM_BIRCH_LAKE = registerConfiguredFeature("plum_birch_lake", DreamlandFeatures.SURFACE_LAKE, new SurfaceLake.Configuration(BlockStateProvider.simple(Blocks.WATER.defaultBlockState()), BlockStateProvider.simple(DreamlandBlocks.MINERAL_DIRT.block().get().defaultBlockState())));
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> JEWELED_FOREST_VEGETATION = registerConfiguredFeature("jeweled_forest_vegetation", Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 16, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DreamlandBlocks.PINK_CRAB_GRASS.block().get().defaultBlockState(), 25).add(DreamlandBlocks.PLUM_BIRCH_SHRUB.block().get().defaultBlockState(), 25).add(DreamlandBlocks.OPALINE_MARIGOLD.block().get().defaultBlockState(), 20).add(Blocks.ALLIUM.defaultBlockState(), 15).add(Blocks.GRASS.defaultBlockState(), 10).add(Blocks.LARGE_FERN.defaultBlockState(), 5))))));
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FLOWERING_UNDERGROWTH = registerConfiguredFeature("flowering_undergrowth", Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DreamlandBlocks.FLOWERING_UNDERGROWTH.block().get())))));
	public static final Holder<ConfiguredFeature<EllipsoidConfig, ?>> CALCITE_ROCK = registerConfiguredFeature("calcite_rock", DreamlandFeatures.ELLIPSOID, new EllipsoidConfig(BlockStateProvider.simple(Blocks.CALCITE), BlockStateProvider.simple(Blocks.AMETHYST_BLOCK), UniformInt.of(4, 5), UniformInt.of(5, 7), UniformInt.of(3, 5)));
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> OPAL_CLUSTER = registerConfiguredFeature("opal_cluster", DreamlandFeatures.OPAL_CLUSTER, new NoneFeatureConfiguration());
	
	public static final Holder<ConfiguredFeature<BlockColumnConfiguration, ?>> KUNZITE_POINTS_UP = registerConfiguredFeature("kunzite_points_up", Feature.BLOCK_COLUMN, new BlockColumnConfiguration(List.of(BlockColumnConfiguration.layer(UniformInt.of(0, 7), BlockStateProvider.simple(DreamlandBlocks.KUNZITE_POINT.block().get().defaultBlockState().setValue(KunzitePointBlock.FACING, Direction.UP)))), Direction.UP, BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, true));
	public static final Holder<ConfiguredFeature<BlockColumnConfiguration, ?>> KUNZITE_POINTS_DOWN = registerConfiguredFeature("kunzite_points_down", Feature.BLOCK_COLUMN, new BlockColumnConfiguration(List.of(BlockColumnConfiguration.layer(UniformInt.of(0, 5), BlockStateProvider.simple(DreamlandBlocks.KUNZITE_POINT.block().get().defaultBlockState().setValue(KunzitePointBlock.FACING, Direction.DOWN)))), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, true));
	public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> KUNZITE_POINTS_PATCH_UP = registerConfiguredFeature("kunzite_points_patch_up", Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DreamlandBlockTags.KUNZITE_ORES_REPLACEABLE, BlockStateProvider.simple(DreamlandBlocks.KUNZITE_STONE.block().get()), PlacementUtils.inlinePlaced(KUNZITE_POINTS_UP), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.4F, UniformInt.of(1, 3), 0.3F));
	public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> KUNZITE_POINTS_PATCH_DOWN = registerConfiguredFeature("kunzite_points_patch_down", Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DreamlandBlockTags.KUNZITE_ORES_REPLACEABLE, BlockStateProvider.simple(DreamlandBlocks.KUNZITE_STONE.block().get()), PlacementUtils.inlinePlaced(KUNZITE_POINTS_DOWN), CaveSurface.CEILING, UniformInt.of(1, 2), 0.0F, 35, 0.35F, UniformInt.of(2, 4), 0.3F));
	public static final Holder<ConfiguredFeature<BlockColumnConfiguration, ?>> KUNZITE_POINTS_NORTH = registerConfiguredFeature("kunzite_points_north", Feature.BLOCK_COLUMN, new BlockColumnConfiguration(List.of(BlockColumnConfiguration.layer(UniformInt.of(1, 4), BlockStateProvider.simple(DreamlandBlocks.KUNZITE_POINT.block().get().defaultBlockState().setValue(KunzitePointBlock.FACING, Direction.NORTH)))), Direction.NORTH, BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, true));
	public static final Holder<ConfiguredFeature<BlockColumnConfiguration, ?>> KUNZITE_POINTS_SOUTH = registerConfiguredFeature("kunzite_points_south", Feature.BLOCK_COLUMN, new BlockColumnConfiguration(List.of(BlockColumnConfiguration.layer(UniformInt.of(1, 4), BlockStateProvider.simple(DreamlandBlocks.KUNZITE_POINT.block().get().defaultBlockState().setValue(KunzitePointBlock.FACING, Direction.SOUTH)))), Direction.SOUTH, BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, true));
	public static final Holder<ConfiguredFeature<BlockColumnConfiguration, ?>> KUNZITE_POINTS_EAST = registerConfiguredFeature("kunzite_points_east", Feature.BLOCK_COLUMN, new BlockColumnConfiguration(List.of(BlockColumnConfiguration.layer(UniformInt.of(1, 4), BlockStateProvider.simple(DreamlandBlocks.KUNZITE_POINT.block().get().defaultBlockState().setValue(KunzitePointBlock.FACING, Direction.EAST)))), Direction.EAST, BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, true));
	public static final Holder<ConfiguredFeature<BlockColumnConfiguration, ?>> KUNZITE_POINTS_WEST = registerConfiguredFeature("kunzite_points_west", Feature.BLOCK_COLUMN, new BlockColumnConfiguration(List.of(BlockColumnConfiguration.layer(UniformInt.of(1, 4), BlockStateProvider.simple(DreamlandBlocks.KUNZITE_POINT.block().get().defaultBlockState().setValue(KunzitePointBlock.FACING, Direction.WEST)))), Direction.WEST, BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, true));
	
	
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> KUNZITE_IRON = registerConfiguredFeature("kunzite_iron_ore", Feature.ORE, new OreConfiguration(KUNZITE_IRON_TARGET_LIST, 9));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> KUNZITE_IRON_SMALL = registerConfiguredFeature("kunzite_iron_small_ore", Feature.ORE, new OreConfiguration(KUNZITE_IRON_TARGET_LIST, 4));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> KUNZITE_EMERALD = registerConfiguredFeature("kunzite_emerald_ore", Feature.ORE, new OreConfiguration(KUNZITE_EMERALD_TARGET_LIST, 3));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> KUNZITE_REDSTONE = registerConfiguredFeature("kunzite_redstone_ore", Feature.ORE, new OreConfiguration(KUNZITE_REDSTONE_TARGET_LIST, 8));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> KUNZITE_LAPIS = registerConfiguredFeature("kunzite_lapis_ore", Feature.ORE, new OreConfiguration(KUNZITE_LAPIS_TARGET_LIST, 7));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> KUNZITE_COPPER = registerConfiguredFeature("kunzite_copper_ore", Feature.ORE, new OreConfiguration(KUNZITE_COPPER_TARGET_LIST, 10));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> KUNZITE_COPPER_LARGE = registerConfiguredFeature("kunzite_copper_large_ore", Feature.ORE, new OreConfiguration(KUNZITE_COPPER_TARGET_LIST, 20));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> KUNZITE_DIAMOND = registerConfiguredFeature("kunzite_diamond_ore", Feature.ORE, new OreConfiguration(KUNZITE_DIAMOND_TARGET_LIST, 4, 0.5F));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> KUNZITE_DIAMOND_LARGE = registerConfiguredFeature("kunzite_diamond_large_ore", Feature.ORE, new OreConfiguration(KUNZITE_DIAMOND_TARGET_LIST, 12, 0.7F));	
	public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> GOLDEN_MOSS_VEGETATION = registerConfiguredFeature("golden_moss_vegetation", Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DreamlandBlocks.GOLDEN_MOSS_CARPET.block().get().defaultBlockState(), 25).add(DreamlandBlocks.GOLD_FRONDS.block().get().defaultBlockState(), 25).add(Blocks.GRASS.defaultBlockState(), 25).add(DreamlandBlocks.GOLDEN_CAP.block().get().defaultBlockState(), 9).add(DreamlandBlocks.MIDASHROOM.block().get().defaultBlockState(), 1).add(DreamlandBlocks.SMALL_GOLDEN_CAP.block().get().defaultBlockState(), 15))));
	public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> GOLDEN_MOSS_PATCH = registerConfiguredFeature("golden_moss_patch", Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(DreamlandBlockTags.KUNZITE_ORES_REPLACEABLE, BlockStateProvider.simple(DreamlandBlocks.GOLDEN_MOSS_BLOCK.block().get()), PlacementUtils.inlinePlaced(GOLDEN_MOSS_VEGETATION), CaveSurface.FLOOR, ConstantInt.of(1), 0.2F, 5, 0.8F, UniformInt.of(4, 7), 0.3F));
	public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> GOLDEN_CAP = registerConfiguredFeature("golden_cap", Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DreamlandBlocks.GOLDEN_CAP.block().get().defaultBlockState(), 95).add(DreamlandBlocks.MIDASHROOM.block().get().defaultBlockState(), 5))));
	public static final Holder<ConfiguredFeature<GeodeConfiguration, ?>> GOLD_GEODE = registerConfiguredFeature("gold_geode", Feature.GEODE, new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR), BlockStateProvider.simple(DreamlandBlocks.GOLD_BEARING_QUARTZITE.block().get()), BlockStateProvider.simple(DreamlandBlocks.BUDDING_GOLD.block().get()), BlockStateProvider.simple(Blocks.SMOOTH_QUARTZ), BlockStateProvider.simple(Blocks.SMOOTH_BASALT), List.of(DreamlandBlocks.SMALL_GOLD_CLUSTER.block().get().defaultBlockState(), DreamlandBlocks.MEDIUM_GOLD_CLUSTER.block().get().defaultBlockState(), DreamlandBlocks.LARGE_GOLD_CLUSTER.block().get().defaultBlockState(), DreamlandBlocks.GOLD_CLUSTER.block().get().defaultBlockState()), BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 5.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05D, 1));
	
	
	private static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> registerConfiguredFeature(String name, F feature, FC config) {
		return BuiltinRegistries.registerExact(BuiltinRegistries.CONFIGURED_FEATURE, DreamlandLoc.createLoc(name).toString(), new ConfiguredFeature<>(feature,config));
	}
	
	private static ResourceKey<ConfiguredFeature<?,?>> createConfiguredFeatureKey(String name) {
		ResourceKey<ConfiguredFeature<?,?>> key = ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, DreamlandLoc.createLoc(name));
		KEYS.add(key);
		return key;
	}
}
