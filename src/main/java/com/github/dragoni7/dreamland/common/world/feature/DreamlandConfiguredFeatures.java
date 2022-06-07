package com.github.dragoni7.dreamland.common.world.feature;

import java.util.ArrayList;
import java.util.List;

import com.github.dragoni7.dreamland.common.blocks.DreamlandBlockTags;
import com.github.dragoni7.dreamland.common.world.feature.configs.EllipsoidConfig;
import com.github.dragoni7.dreamland.common.world.feature.generation.SurfaceLake;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandFeatures;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DeltaFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class DreamlandConfiguredFeatures {
	
	public static final RuleTest HIVE_ORES_REPLACEABLE = new TagMatchTest(DreamlandBlockTags.HIVE_ORES_REPLACEABLE);
	
	public static final List<OreConfiguration.TargetBlockState> MOSS_GRASS_TARGET_LIST = List.of(OreConfiguration.target(new TagMatchTest(DreamlandBlockTags.GARDEN_SURFACE_REPLACEABLE), Blocks.MOSS_BLOCK.defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> FILLED_HIVE_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_IRON_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_IRON.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_COPPER_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_COPPER.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_GOLD_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_GOLD.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_REDSTONE_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_REDSTONE.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_LAPIS_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_LAPIS.get().defaultBlockState()));
	public static final List<OreConfiguration.TargetBlockState> HIVE_DIAMOND_TARGET_LIST = List.of(OreConfiguration.target(HIVE_ORES_REPLACEABLE, DreamlandBlocks.HIVE_DIAMOND.get().defaultBlockState()));
	
	private static final ArrayList<ResourceKey<ConfiguredFeature<?,?>>> KEYS = new ArrayList<ResourceKey<ConfiguredFeature<?,?>>>();
	
	// KEYS
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_CAVE_SLIME_KEY = createConfiguredFeatureKey("cave_slime");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_COMB_KEY = createConfiguredFeatureKey("hive_comb");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_STRAND_KEY = createConfiguredFeatureKey("hive_strand");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_JELLY_CLUSTER_KEY = createConfiguredFeatureKey("hive_jelly_cluster");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_INFESTED_HIVE_JELLY_CLUSTER_KEY = createConfiguredFeatureKey("infested_hive_jelly_cluster");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_GROWTH_KEY = createConfiguredFeatureKey("hive_growth");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_GROWTH_PATCH_KEY = createConfiguredFeatureKey("hive_growth_patch");
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
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_DROUGHT_DISK_KEY = createConfiguredFeatureKey("drought_disk");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_TAR_DELTA_KEY = createConfiguredFeatureKey("tar_delta");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_DROUGHT_VEGETATION_KEY =  createConfiguredFeatureKey("drought_vegetation");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_TAR_BARK_TREE_KEY = createConfiguredFeatureKey("tar_bark_tree");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_TAR_SPROUTS_KEY = createConfiguredFeatureKey("tar_sprouts");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_TAR_SKELETON_KEY = createConfiguredFeatureKey("tar_skeleton");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_TAR_BONE_KEY = createConfiguredFeatureKey("tar_bone");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_TAR_SOIL_ORE_KEY = createConfiguredFeatureKey("tar_soil_ore"); 
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_PLUM_BIRCH_TREE_KEY = createConfiguredFeatureKey("plum_birch_tree");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_PLUM_BIRCH_LAKE = createConfiguredFeatureKey("plum_birch_lake");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_JEWELED_FOREST_VEGETATION_KEY = createConfiguredFeatureKey("jeweled_forest_vegetation");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_CALCITE_ROCK_KEY = createConfiguredFeatureKey("calcite_rock");
	public static final ResourceKey<ConfiguredFeature<?,?>> CONFIGURED_HIVE_CAVE_KEY = createConfiguredFeatureKey("hive_cave");
	
	public static ArrayList<ResourceKey<ConfiguredFeature<?, ?>>> getKeys() {
		return KEYS;
	}
	
	// CONFIGURED FEATURES
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
													DreamlandBlocks.CAVE_SLIME.get()))),
							Direction.DOWN, 
							BlockPredicate.ONLY_IN_AIR_PREDICATE, 
							true));
	
	public static final Holder<ConfiguredFeature<BlockStateConfiguration,?>> HIVE_COMB = registerConfiguredFeature("hive_comb", DreamlandFeatures.HIVE_COMB, new BlockStateConfiguration(DreamlandBlocks.HIVE_MEMBRANE.get().defaultBlockState()));
	
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> HIVE_STRAND = registerConfiguredFeature("hive_strand", DreamlandFeatures.HIVE_STRAND, new NoneFeatureConfiguration());

	public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> HIVE_JELLY_CLUSTER = registerConfiguredFeature("hive_jelly_cluster", Feature.SIMPLE_BLOCK, (new SimpleBlockConfiguration(BlockStateProvider.simple(DreamlandBlocks.HIVE_JELLY_CLUSTER.get()))));
	
	public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> INFESTED_HIVE_JELLY_CLUSTER = registerConfiguredFeature("infested_hive_jelly_cluster", Feature.SIMPLE_BLOCK, (new SimpleBlockConfiguration(BlockStateProvider.simple(DreamlandBlocks.INFESTED_HIVE_JELLY_CLUSTER.get()))));
	
	public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> HIVE_GROWTH = registerConfiguredFeature("hive_growth", Feature.SIMPLE_BLOCK, (new SimpleBlockConfiguration(BlockStateProvider.simple(DreamlandBlocks.HIVE_GROWTH.get()))));
	
	public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> GROWTH_PATCH = registerConfiguredFeature("hive_growth_patch", Feature.VEGETATION_PATCH, (new VegetationPatchConfiguration(DreamlandBlockTags.HIVE_ORES_REPLACEABLE, BlockStateProvider.simple(DreamlandBlocks.HIVE_BLOCK.get()), PlacementUtils.inlinePlaced(HIVE_GROWTH), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.5F, UniformInt.of(1, 3), 0.3F)));
	
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> FILLED_HIVE_BLOCK = registerConfiguredFeature("filled_hive_block", Feature.ORE, new OreConfiguration(FILLED_HIVE_TARGET_LIST, 10));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_IRON = registerConfiguredFeature("hive_iron", Feature.ORE, new OreConfiguration(HIVE_IRON_TARGET_LIST, 9));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_GOLD = registerConfiguredFeature("hive_gold", Feature.ORE, new OreConfiguration(HIVE_GOLD_TARGET_LIST, 4, 0.5F));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_REDSTONE = registerConfiguredFeature("hive_redstone", Feature.ORE, new OreConfiguration(HIVE_REDSTONE_TARGET_LIST, 8));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_LAPIS = registerConfiguredFeature("hive_lapis", Feature.ORE, new OreConfiguration(HIVE_LAPIS_TARGET_LIST, 7));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_COPPER = registerConfiguredFeature("hive_copper", Feature.ORE, new OreConfiguration(HIVE_COPPER_TARGET_LIST, 10));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_COPPER_LARGE = registerConfiguredFeature("hive_copper_large", Feature.ORE, new OreConfiguration(HIVE_COPPER_TARGET_LIST, 20));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_DIAMOND = registerConfiguredFeature("hive_diamond", Feature.ORE, new OreConfiguration(HIVE_DIAMOND_TARGET_LIST, 4, 0.5F));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HIVE_DIAMOND_LARGE = registerConfiguredFeature("hive_diamond_large", Feature.ORE, new OreConfiguration(HIVE_DIAMOND_TARGET_LIST, 12, 0.7F));
	public static final Holder<ConfiguredFeature<EllipsoidConfig, ?>> HIVE_CAVE = registerConfiguredFeature("hive_cave", DreamlandFeatures.ELLIPSOID, new EllipsoidConfig(BlockStateProvider.simple(Blocks.CAVE_AIR), BlockStateProvider.simple(Blocks.CAVE_AIR), UniformInt.of(8, 16), UniformInt.of(16, 24), UniformInt.of(8, 16))); 
	
	public static final Holder<ConfiguredFeature<SurfaceLake.Configuration, ?>> DROUGHT_BORDERED_DISK = registerConfiguredFeature("bordered_drought_disk", DreamlandFeatures.SURFACE_LAKE, new SurfaceLake.Configuration(BlockStateProvider.simple(DreamlandBlocks.DROUGHT_SOIL.get().defaultBlockState()), BlockStateProvider.simple(DreamlandBlocks.DRIED_TAR.get().defaultBlockState())));
	public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DROUGHT_DISK = registerConfiguredFeature("drought_disk", Feature.DISK, new DiskConfiguration(DreamlandBlocks.DROUGHT_SOIL.get().defaultBlockState(), UniformInt.of(2, 5), 2, List.of(DreamlandBlocks.TAR_SOIL.get().defaultBlockState(), DreamlandBlocks.DRIED_TAR.get().defaultBlockState())));
	public static final Holder<ConfiguredFeature<DeltaFeatureConfiguration, ?>> TAR_DELTA = registerConfiguredFeature("tar_delta", Feature.DELTA_FEATURE, new DeltaFeatureConfiguration(DreamlandFluids.TAR_BLOCK.get().defaultBlockState(), DreamlandBlocks.DRIED_TAR.get().defaultBlockState(), UniformInt.of(3, 7), UniformInt.of(1, 4)));
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> DROUGHT_VEGETATION = registerConfiguredFeature("drought_vegetation", Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OXEYE_DAISY.defaultBlockState(), 10).add(Blocks.DEAD_BUSH.defaultBlockState(), 40).add(Blocks.GRASS.defaultBlockState(), 50))))));
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> TAR_BARK_TREE = registerConfiguredFeature("tar_bark_tree", DreamlandFeatures.TAR_BARK_TREE_FEATURE, new NoneFeatureConfiguration());
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TAR_SPROUTS = registerConfiguredFeature("tar_sprouts", Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(DreamlandBlocks.TAR_SPROUTS.get())))));
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> TAR_SKELETON = registerConfiguredFeature("tar_skeleton", DreamlandFeatures.TAR_SKELETON, new NoneFeatureConfiguration());
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> TAR_BONE = registerConfiguredFeature("tar_bone", DreamlandFeatures.TAR_BONE, new NoneFeatureConfiguration());
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> TAR_SOIL_ORE = registerConfiguredFeature("tar_soil_ore", Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, DreamlandBlocks.TAR_SOIL.get().defaultBlockState(), 64));
	
	
	public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> PLUM_BIRCH_TREE = registerConfiguredFeature("plum_birch_tree", DreamlandFeatures.PLUM_BIRCH_TREE_FEATURE, new NoneFeatureConfiguration());
	@SuppressWarnings("deprecation")
	public static final Holder<ConfiguredFeature<SurfaceLake.Configuration, ?>> PLUM_BIRCH_LAKE = registerConfiguredFeature("plum_birch_lake", DreamlandFeatures.SURFACE_LAKE, new SurfaceLake.Configuration(BlockStateProvider.simple(Blocks.WATER.defaultBlockState()), BlockStateProvider.simple(DreamlandBlocks.MINERAL_DIRT.get().defaultBlockState())));
	public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> JEWELED_FOREST_VEGETATION = registerConfiguredFeature("jeweled_forest_vegetation", Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 16, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(DreamlandBlocks.PINK_CRAB_GRASS.get().defaultBlockState(), 50).add(DreamlandBlocks.OPALINE_MARIGOLD.get().defaultBlockState(), 20).add(Blocks.ALLIUM.defaultBlockState(), 15).add(Blocks.GRASS.defaultBlockState(), 10).add(Blocks.LARGE_FERN.defaultBlockState(), 5))))));
	public static final Holder<ConfiguredFeature<EllipsoidConfig, ?>> CALCITE_ROCK = registerConfiguredFeature("calcite_rock", DreamlandFeatures.ELLIPSOID, new EllipsoidConfig(BlockStateProvider.simple(Blocks.CALCITE), BlockStateProvider.simple(Blocks.CALCITE), UniformInt.of(4, 6), UniformInt.of(6, 8), UniformInt.of(3, 6)));
	
	private static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> registerConfiguredFeature(String name, F feature, FC config) {
		return BuiltinRegistries.registerExact(BuiltinRegistries.CONFIGURED_FEATURE, DreamlandLoc.createLoc(name).toString(), new ConfiguredFeature<>(feature,config));
	}
	
	private static ResourceKey<ConfiguredFeature<?,?>> createConfiguredFeatureKey(String name) {
		ResourceKey<ConfiguredFeature<?,?>> key = ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, DreamlandLoc.createLoc(name));
		KEYS.add(key);
		return key;
	   }
}
