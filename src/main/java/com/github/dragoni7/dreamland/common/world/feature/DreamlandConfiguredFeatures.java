package com.github.dragoni7.dreamland.common.world.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.github.dragoni7.dreamland.common.blocks.KunzitePointBlock;
import com.github.dragoni7.dreamland.common.world.feature.configs.ConeConfig;
import com.github.dragoni7.dreamland.common.world.feature.configs.EllipsoidConfig;
import com.github.dragoni7.dreamland.common.world.feature.configs.HillConfig;
import com.github.dragoni7.dreamland.common.world.feature.configs.SphereConfig;
import com.github.dragoni7.dreamland.common.world.feature.generation.SurfaceLake;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandFeatures;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
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
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
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
import net.minecraft.world.level.levelgen.feature.configurations.MultifaceGrowthConfiguration;
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
	
	private static final ArrayList<ResourceKey<ConfiguredFeature<?,?>>> KEYS = new ArrayList<ResourceKey<ConfiguredFeature<?,?>>>();
	
	public static final RuleTest KUNZITE_ORES_REPLACEABLE = new TagMatchTest(DreamlandBlockTags.KUNZITE_ORES_REPLACEABLE);
	public static final RuleTest HIVE_ORES_REPLACEABLE = new TagMatchTest(DreamlandBlockTags.HIVE_ORES_REPLACEABLE);
	public static final RuleTest FOSSILIZED_EGG_REPLACEABLE = new TagMatchTest(DreamlandBlockTags.FOSSILIZED_EGG_REPLACEABLE);
	public static final RuleTest TOXIC_JUNGLE_GROUND = new TagMatchTest(DreamlandBlockTags.TOXIC_JUNGLE_GROUND_BLOCKS);
	
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
	public static final Holder<ConfiguredFeature<HillConfig, ?>> TAR_HILL = registerConfiguredFeature("tar_hill", DreamlandFeatures.NOISE_HILL, new HillConfig(BlockStateProvider.simple(DreamlandBlocks.DRIED_TAR.block().get()), BlockStateProvider.simple(DreamlandFluids.TAR_BLOCK.get()), UniformInt.of(7, 10), UniformInt.of(7, 24), UniformInt.of(7, 10), ConstantInt.of(1), ConstantFloat.of(0.1F)));
	public static final Holder<ConfiguredFeature<HillConfig, ?>> DROUGHT_SOIL_HILL = registerConfiguredFeature("drought_soil_hill", DreamlandFeatures.NOISE_HILL, new HillConfig(BlockStateProvider.simple(DreamlandBlocks.DRIED_TAR.block().get()), BlockStateProvider.simple(DreamlandBlocks.DROUGHT_SOIL.block().get()), UniformInt.of(7, 14), UniformInt.of(7, 24), UniformInt.of(7, 14), ConstantInt.of(1), ConstantFloat.of(0.1F)));
	
	@SuppressWarnings("deprecation")
	public static final Holder<ConfiguredFeature<LakeFeature.Configuration, ?>> LAKE_TAR = registerConfiguredFeature("lake_tar", Feature.LAKE, new LakeFeature.Configuration(BlockStateProvider.simple(DreamlandFluids.TAR_BLOCK.get()), BlockStateProvider.simple(Blocks.STONE.defaultBlockState())));
	public static final Holder<ConfiguredFeature<SpringConfiguration, ?>> SPRING_TAR = registerConfiguredFeature("spring_tar", Feature.SPRING, new SpringConfiguration(DreamlandFluids.TAR_FLUID.get().defaultFluidState(), true, 4, 1, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, Blocks.DEEPSLATE, Blocks.TUFF, Blocks.CALCITE, Blocks.DIRT)));
	
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> PLUM_BIRCH_TREE = registerConfiguredFeature("plum_birch_tree", DreamlandFeatures.PLUM_BIRCH_TREE_FEATURE, new NoneFeatureConfiguration());
	public static final Holder<ConfiguredFeature<SurfaceLake.Configuration, ?>> PLUM_BIRCH_LAKE = registerConfiguredFeature("plum_birch_lake", DreamlandFeatures.SURFACE_LAKE, new SurfaceLake.Configuration(BlockStateProvider.simple(Blocks.WATER.defaultBlockState()), BlockStateProvider.simple(DreamlandBlocks.MINERAL_DIRT.block().get().defaultBlockState())));
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> JEWELED_FOREST_VEGETATION = registerConfiguredFeature("jeweled_forest_vegetation", Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 16, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DreamlandBlocks.PINK_CRAB_GRASS.block().get().defaultBlockState(), 25).add(DreamlandBlocks.PLUM_BIRCH_SHRUB.block().get().defaultBlockState(), 25).add(DreamlandBlocks.OPALINE_MARIGOLD.block().get().defaultBlockState(), 20).add(Blocks.ALLIUM.defaultBlockState(), 15).add(Blocks.GRASS.defaultBlockState(), 10).add(Blocks.LARGE_FERN.defaultBlockState(), 5))))));
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FLOWERING_UNDERGROWTH = registerConfiguredFeature("flowering_undergrowth", Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DreamlandBlocks.FLOWERING_UNDERGROWTH.block().get())))));
	public static final Holder<ConfiguredFeature<EllipsoidConfig, ?>> CALCITE_ROCK = registerConfiguredFeature("calcite_rock", DreamlandFeatures.ELLIPSOID, new EllipsoidConfig(BlockStateProvider.simple(Blocks.CALCITE), BlockStateProvider.simple(Blocks.AMETHYST_BLOCK), UniformInt.of(4, 5), UniformInt.of(5, 7), UniformInt.of(3, 5)));
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> OPAL_CLUSTER = registerConfiguredFeature("opal_cluster", DreamlandFeatures.OPAL_CLUSTER, new NoneFeatureConfiguration());
	public static final Holder<ConfiguredFeature<ConeConfig, ?>> AMETHYST_ROCK = registerConfiguredFeature("amethyst_rock", DreamlandFeatures.NOISE_CONE, new ConeConfig(BlockStateProvider.simple(Blocks.CALCITE), BlockStateProvider.simple(Blocks.AMETHYST_BLOCK), UniformInt.of(5, 6), UniformInt.of(24, 25), ConstantFloat.of(0.1F)));
	
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
	
	public static final Holder<ConfiguredFeature<ConeConfig, ?>> POROUS_SPIRES = registerConfiguredFeature("porous_spires", DreamlandFeatures.NOISE_CONE, new ConeConfig(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DreamlandBlocks.OVERGROWN_POROUS_STONE.block().get().defaultBlockState(), 25).add(DreamlandBlocks.POROUS_STONE.block().get().defaultBlockState(), 75)), BlockStateProvider.simple(Blocks.AIR), UniformInt.of(8, 11), UniformInt.of(10, 13), UniformFloat.of(0.1F, 0.2F)));
	public static final Holder<ConfiguredFeature<SphereConfig, ?>> POROUS_SPHERE = registerConfiguredFeature("porous_sphere", DreamlandFeatures.NOISE_SPHERE, new SphereConfig(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DreamlandBlocks.OVERGROWN_POROUS_STONE.block().get().defaultBlockState(), 25).add(DreamlandBlocks.POROUS_STONE.block().get().defaultBlockState(), 75)), BlockStateProvider.simple(Blocks.AIR), UniformInt.of(26, 43), UniformInt.of(24, 32), UniformFloat.of(0.07F, 0.11F)));
	public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> MOLD_PUFF_TREE = registerConfiguredFeature("mold_puff_tree", DreamlandFeatures.MOLD_PUFF_TREE, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DreamlandBlocks.BLACK_MOLD.block().get().defaultBlockState(), 50).add(DreamlandBlocks.WHITE_MOLD.block().get().defaultBlockState(), 50))));
	public static final Holder<ConfiguredFeature<HillConfig, ?>> POROUS_HILL = registerConfiguredFeature("porous_hill", DreamlandFeatures.NOISE_HILL, new HillConfig(BlockStateProvider.simple(DreamlandBlocks.PETRIFIED_VEGETATION.block().get()), BlockStateProvider.simple(Blocks.MYCELIUM), UniformInt.of(7, 8), UniformInt.of(4, 5), UniformInt.of(7, 9), ConstantInt.of(1), ConstantFloat.of(0.1F)));
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TOXIC_JUNGLE_VEGETATION = registerConfiguredFeature("toxic_jungle_vegetation", Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 5, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DreamlandBlocks.SPONGE_PUFF.block().get().defaultBlockState(), 25).add(DreamlandBlocks.SPORE_PUFF.block().get().defaultBlockState(), 25).add(Blocks.BROWN_MUSHROOM.defaultBlockState(), 10).add(Blocks.TALL_GRASS.defaultBlockState(), 15).add(DreamlandBlocks.GLOW_FRONDS.block().get().defaultBlockState(), 15).add(Blocks.RED_MUSHROOM.defaultBlockState(), 10))))));
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> MOLD_CARPET = registerConfiguredFeature("mold_carpet", Feature.RANDOM_PATCH, new RandomPatchConfiguration(24, 8, 1, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DreamlandBlocks.WHITE_MOLD_CARPET.block().get().defaultBlockState(), 75).add(DreamlandBlocks.BLACK_MOLD_CARPET.block().get().defaultBlockState(), 25))))));
	public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> MOLD_GROWTH = registerConfiguredFeature("mold_growth", DreamlandFeatures.MOLD_GROWTH, new SimpleBlockConfiguration((new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DreamlandBlocks.BLACK_MOLD.block().get().defaultBlockState(), 50).add(DreamlandBlocks.WHITE_MOLD.block().get().defaultBlockState(), 50)))));
	public static final Holder<ConfiguredFeature<HillConfig, ?>> MOLD_WOOD_STUMP = registerConfiguredFeature("mold_wood_stump", DreamlandFeatures.NOISE_HILL, new HillConfig(BlockStateProvider.simple(DreamlandWoodSets.MOLD_WOOD.wood().block().get().defaultBlockState()), BlockStateProvider.simple(DreamlandWoodSets.MOLD_WOOD.strippedLog().block().get().defaultBlockState()), ConstantInt.of(7), UniformInt.of(6, 7), ConstantInt.of(7), ConstantInt.of(1), ConstantFloat.of(0.1F)));
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> MOLD_WOOD_ROOTS = registerConfiguredFeature("mold_wood_roots", DreamlandFeatures.MOLD_WOOD_ROOTS, new NoneFeatureConfiguration());
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> MOLD_WOOD_TREE = registerConfiguredFeature("mold_wood_tree", DreamlandFeatures.MOLD_WOOD_TREE, new NoneFeatureConfiguration());
	private static final MultifaceBlock GLOW_LICHEN_BLOCK = (MultifaceBlock)Blocks.GLOW_LICHEN;
	public static final Holder<ConfiguredFeature<MultifaceGrowthConfiguration, ?>> TOXIC_JUNGLE_GLOW_LICHEN = registerConfiguredFeature("toxic_jungle_glow_lichen", Feature.MULTIFACE_GROWTH, new MultifaceGrowthConfiguration(GLOW_LICHEN_BLOCK, 24, true, true, true, 0.6F, HolderSet.direct(Block::builtInRegistryHolder, DreamlandWoodSets.MOLD_WOOD.log().block().get(), DreamlandWoodSets.MOLD_WOOD.wood().block().get(), DreamlandBlocks.POROUS_STONE.block().get(), DreamlandBlocks.OVERGROWN_POROUS_STONE.block().get(), DreamlandBlocks.PETRIFIED_VEGETATION.block().get(), DreamlandBlocks.MOLDED_STONE.block().get())));
	private static final MultifaceBlock SHELF_VEGETATION_BLOCK = (MultifaceBlock)DreamlandBlocks.SHELF_VEGETATION.block().get();
	public static final Holder<ConfiguredFeature<MultifaceGrowthConfiguration, ?>> SHELF_VEGETATION = registerConfiguredFeature("shelf_vegetation", Feature.MULTIFACE_GROWTH, new MultifaceGrowthConfiguration(SHELF_VEGETATION_BLOCK, 24, true, true, true, 0.8F, HolderSet.direct(Block::builtInRegistryHolder, DreamlandWoodSets.MOLD_WOOD.log().block().get(), DreamlandWoodSets.MOLD_WOOD.wood().block().get(), DreamlandBlocks.POROUS_STONE.block().get(), DreamlandBlocks.OVERGROWN_POROUS_STONE.block().get(), DreamlandBlocks.PETRIFIED_VEGETATION.block().get())));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> TOXIC_VEGETATION = registerConfiguredFeature("toxic_vegetation", Feature.ORE, new OreConfiguration(TOXIC_JUNGLE_GROUND, DreamlandBlocks.TOXIC_VEGETATION.block().get().defaultBlockState(), 16));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> DECAYED_VEGETATION = registerConfiguredFeature("decayed_vegetation", Feature.ORE, new OreConfiguration(TOXIC_JUNGLE_GROUND, DreamlandBlocks.DECAYED_VEGETATION.block().get().defaultBlockState(), 8));
	
	private static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> registerConfiguredFeature(String name, F feature, FC config) {
		createKey(name);
		return BuiltinRegistries.registerExact(BuiltinRegistries.CONFIGURED_FEATURE, DreamlandLoc.createLoc(name).toString(), new ConfiguredFeature<>(feature,config));
	}
	
	private static void createKey(String name) {
		ResourceKey<ConfiguredFeature<?,?>> key = ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, DreamlandLoc.createLoc(name));
		KEYS.add(key);
	}
	
	public static ArrayList<ResourceKey<ConfiguredFeature<?, ?>>> getKeys() {
		return KEYS;
	}
}
