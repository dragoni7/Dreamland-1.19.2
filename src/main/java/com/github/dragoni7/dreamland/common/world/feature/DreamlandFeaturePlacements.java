package com.github.dragoni7.dreamland.common.world.feature;

import java.util.ArrayList;
import java.util.List;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.heightproviders.VeryBiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.SurfaceRelativeThresholdFilter;

public class DreamlandFeaturePlacements {
	
private static final ArrayList<ResourceKey<PlacedFeature>> KEYS = new ArrayList<ResourceKey<PlacedFeature>>();
	
	// KEYS
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_COMB_CEILING_KEY = createPlacedFeatureKey("hive_comb_ceiling");
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_COMB_KEY = createPlacedFeatureKey("hive_comb");
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_STRAND_KEY = createPlacedFeatureKey("hive_strand");
	public static final ResourceKey<PlacedFeature> PLACED_CAVE_SLIME_KEY = createPlacedFeatureKey("cave_slime");
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_JELLY_CLUSTER_KEY = createPlacedFeatureKey("hive_jelly_cluster");
	public static final ResourceKey<PlacedFeature> PLACED_INFESTED_HIVE_JELLY_CLUSTER_KEY = createPlacedFeatureKey("infested_hive_jelly_cluster");
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_GROWTH_KEY = createPlacedFeatureKey("hive_growth");
	public static final ResourceKey<PlacedFeature> PLACED_FILLED_HIVE_BLOCK_KEY = createPlacedFeatureKey("filled_hive_block");
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_IRON_UPPER_KEY = createPlacedFeatureKey("hive_iron_upper");
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_IRON_MIDDLE_KEY = createPlacedFeatureKey("hive_iron_middle");
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_GOLD_KEY = createPlacedFeatureKey("hive_gold");
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_GOLD_LOWER_KEY = createPlacedFeatureKey("hive_gold_lower");
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_REDSTONE_KEY = createPlacedFeatureKey("hive_redstone");
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_REDSTONE_LOWER_KEY = createPlacedFeatureKey("hive_redstone_lower");
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_DIAMOND_KEY = createPlacedFeatureKey("hive_diamond");
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_DIAMOND_LARGE_KEY = createPlacedFeatureKey("hive_diamond_large");
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_LAPIS_KEY = createPlacedFeatureKey("hive_lapis");
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_COPPER_KEY = createPlacedFeatureKey("hive_copper");
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_COPPER_LARGE_KEY = createPlacedFeatureKey("hive_copper_large");
	public static final ResourceKey<PlacedFeature> PLACED_TAR_DELTA_KEY = createPlacedFeatureKey("tar_delta");
	public static final ResourceKey<PlacedFeature> PLACED_TAR_BARK_TREE_KEY = createPlacedFeatureKey("tar_bark_tree");
	public static final ResourceKey<PlacedFeature> PLACED_BORDERED_DROUGHT_DISK_KEY = createPlacedFeatureKey("bordered_drought_disk");
	public static final ResourceKey<PlacedFeature> PLACED_DROUGHT_VEGETATION_KEY = createPlacedFeatureKey("drought_vegetation");
	public static final ResourceKey<PlacedFeature> PLACED_TAR_SPROUTS_KEY = createPlacedFeatureKey("tar_sprouts");
	public static final ResourceKey<PlacedFeature> PLACED_TAR_SKELETON_KEY =  createPlacedFeatureKey("tar_skeleton");
	public static final ResourceKey<PlacedFeature> PLACED_TAR_BONE_KEY = createPlacedFeatureKey("tar_bone");
	public static final ResourceKey<PlacedFeature> PLACED_TAR_SOIL_ORE_KEY = createPlacedFeatureKey("tar_soil_ore");
	public static final ResourceKey<PlacedFeature> PLACED_FOSSILIZED_EGG_KEY = createPlacedFeatureKey("fossilized_egg");
	public static final ResourceKey<PlacedFeature> PLACED_TAR_HILL_KEY = createPlacedFeatureKey("tar_hill");
	public static final ResourceKey<PlacedFeature> PLACED_DROUGHT_SOIL_HILL = createPlacedFeatureKey("drought_soil_hill");
	public static final ResourceKey<PlacedFeature> PLACED_LAKE_TAR_UNDERGROUND = createPlacedFeatureKey("lake_tar_underground");
	public static final ResourceKey<PlacedFeature> PLACED_SPRING_TAR = createPlacedFeatureKey("spring_tar");
	public static final ResourceKey<PlacedFeature> PLACED_PLUM_BIRCH_TREE_KEY = createPlacedFeatureKey("plum_birch_tree");
	public static final ResourceKey<PlacedFeature> PLACED_PLUM_BIRCH_LAKE_KEY = createPlacedFeatureKey("plum_birch_lake");
	public static final ResourceKey<PlacedFeature> PLACED_JEWELED_FOREST_VEGETATION_KEY = createPlacedFeatureKey("jeweled_forest_vegetation");
	public static final ResourceKey<PlacedFeature> PLACED_FLOWERING_UNDERGROWTH_KEY = createPlacedFeatureKey("flowering_undergrowth");
	public static final ResourceKey<PlacedFeature> PLACED_CALCITE_ROCK_KEY = createPlacedFeatureKey("calcite_rock");
	public static final ResourceKey<PlacedFeature> PLACED_HIVE_CAVE_KEY = createPlacedFeatureKey("hive_cave");
	public static final ResourceKey<PlacedFeature> PLACED_OPAL_CLUSTER_KEY = createPlacedFeatureKey("opal_cluster");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_POINTS_EAST_KEY = createPlacedFeatureKey("placed_kunzite_points_east");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_POINTS_NORTH_KEY = createPlacedFeatureKey("placed_kunzite_points_north");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_POINTS_PATCH_DOWN_KEY = createPlacedFeatureKey("kunzite_points_patch_down");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_POINTS_PATCH_UP_KEY = createPlacedFeatureKey("kunzite_points_patch_up");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_POINTS_SOUTH_KEY = createPlacedFeatureKey("placed_kunzite_points_south");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_POINTS_WEST_KEY = createPlacedFeatureKey("placed_kunzite_points_west");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_IRON_UPPER_KEY = createPlacedFeatureKey("kunzite_iron_upper_ore");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_IRON_MIDDLE_KEY = createPlacedFeatureKey("kunzite_iron_middle_ore");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_IRON_SMALL_KEY = createPlacedFeatureKey("kunzite_iron_small_ore");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_EMERALD_KEY = createPlacedFeatureKey("kunzite_emerald_ore");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_REDSTONE_KEY = createPlacedFeatureKey("kunzite_redstone_ore");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_REDSTONE_LOWER_KEY = createPlacedFeatureKey("kunzite_redstone_lower_ore");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_DIAMOND_KEY = createPlacedFeatureKey("kunzite_diamond_ore");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_DIAMOND_LARGE_KEY = createPlacedFeatureKey("kunzite_diamond_large_ore");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_LAPIS_KEY = createPlacedFeatureKey("kunzite_lapis_ore");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_COPPER_KEY = createPlacedFeatureKey("kunzite_copper_ore");
	public static final ResourceKey<PlacedFeature> PLACED_KUNZITE_COPPER_LARGE_KEY = createPlacedFeatureKey("kunzite_copper_large_ore");
	public static final ResourceKey<PlacedFeature> PLACED_OPULENT_DEPTHS_VEGETATION_KEY = createPlacedFeatureKey("opulent_depths_vegetation");
	public static final ResourceKey<PlacedFeature> PLACED_GOLD_GEODE_KEY = createPlacedFeatureKey("gold_geode");
	
	public static ArrayList<ResourceKey<PlacedFeature>> getKeys() {
		return KEYS;
	}
	
	// PLACED FEATURES
	public static final Holder<PlacedFeature> PLACED_HIVE_COMB_CEILING = registerPlacedFeature("hive_comb_ceiling", DreamlandConfiguredFeatures.HIVE_COMB, CountPlacement.of(UniformInt.of(90, 256)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_HIVE_COMB = registerPlacedFeature("hive_comb", DreamlandConfiguredFeatures.HIVE_COMB, CountPlacement.of(UniformInt.of(80, 256)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_HIVE_STRAND = registerPlacedFeature("hive_strand", DreamlandConfiguredFeatures.HIVE_STRAND, CountPlacement.of(UniformInt.of(90, 96)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_CAVE_SLIME = registerPlacedFeature("cave_slime", DreamlandConfiguredFeatures.CAVE_SLIME, CountPlacement.of(UniformInt.of(90, 256)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome());
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	public static final Holder<PlacedFeature> PLACED_HIVE_JELLY_CLUSTER = registerPlacedFeature("hive_jelly_cluster", DreamlandConfiguredFeatures.HIVE_JELLY_CLUSTER, CountPlacement.of(UniformInt.of(1, 47)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_INFESTED_HIVE_JELLY_CLUSTER = registerPlacedFeature("infested_hive_jelly_cluster", DreamlandConfiguredFeatures.INFESTED_HIVE_JELLY_CLUSTER, CountPlacement.of(UniformInt.of(0, 47)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_HIVE_GROWTH = registerPlacedFeature("hive_growth", DreamlandConfiguredFeatures.HIVE_GROWTH, CountPlacement.of(UniformInt.of(16, 96)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(DreamlandBlocks.HIVE_BLOCK.block().get()), 12), BiomeFilter.biome());
	
	public static final Holder<PlacedFeature> PLACED_FILLED_HIVE_BLOCK = registerPlacedFeature("filled_hive_block", DreamlandConfiguredFeatures.FILLED_HIVE_BLOCK, (commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()))));
	public static final Holder<PlacedFeature> HIVE_IRON_UPPER = registerPlacedFeature("hive_iron_upper", DreamlandConfiguredFeatures.HIVE_IRON, commonOrePlacement(90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384))));
	public static final Holder<PlacedFeature> HIVE_IRON_MIDDLE = registerPlacedFeature("hive_iron_middle", DreamlandConfiguredFeatures.HIVE_IRON, (commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)))));
	public static final Holder<PlacedFeature> HIVE_ORE_GOLD = registerPlacedFeature("hive_gold", DreamlandConfiguredFeatures.HIVE_GOLD, (commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
	public static final Holder<PlacedFeature> HIVE_ORE_GOLD_LOWER = registerPlacedFeature("hive_gold_lower", DreamlandConfiguredFeatures.HIVE_GOLD, (orePlacement(CountPlacement.of(UniformInt.of(0, 1)), HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48)))));
	public static final Holder<PlacedFeature> HIVE_REDSTONE = registerPlacedFeature("hive_redstone", DreamlandConfiguredFeatures.HIVE_REDSTONE, (commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15)))));
	public static final Holder<PlacedFeature> HIVE_REDSTONE_LOWER = registerPlacedFeature("hive_redstone_lower", DreamlandConfiguredFeatures.HIVE_REDSTONE, (commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32)))));
	public static final Holder<PlacedFeature> HIVE_DIAMOND = registerPlacedFeature("hive_diamond", DreamlandConfiguredFeatures.HIVE_DIAMOND, (commonOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
	public static final Holder<PlacedFeature> HIVE_DIAMOND_LARGE = registerPlacedFeature("hive_diamond_large", DreamlandConfiguredFeatures.HIVE_DIAMOND_LARGE, (rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
	public static final Holder<PlacedFeature> HIVE_LAPIS = registerPlacedFeature("hive_lapis", DreamlandConfiguredFeatures.HIVE_LAPIS, (commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32)))));
	public static final Holder<PlacedFeature> HIVE_COPPER = registerPlacedFeature("hive_copper", DreamlandConfiguredFeatures.HIVE_COPPER, (commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
	public static final Holder<PlacedFeature> HIVE_COPPER_LARGE = registerPlacedFeature("hive_copper_large", DreamlandConfiguredFeatures.HIVE_COPPER_LARGE, (commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
	public static final Holder<PlacedFeature> HIVE_CAVE = registerPlacedFeature("hive_cave", DreamlandConfiguredFeatures.HIVE_CAVE, RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()), BiomeFilter.biome());
	
	public static final Holder<PlacedFeature> DROUGHT_BORDERED_DISK_SURFACE = registerPlacedFeature("bordered_drought_disk", DreamlandConfiguredFeatures.DROUGHT_BORDERED_DISK, CountPlacement.of(UniformInt.of(0, 48)), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_TAR_DELTA = registerPlacedFeature("tar_delta", DreamlandConfiguredFeatures.TAR_DELTA, CountPlacement.of(UniformInt.of(0, 96)), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_DROUGHT_VEGETATION = registerPlacedFeature("drought_vegetation", DreamlandConfiguredFeatures.DROUGHT_VEGETATION, CountPlacement.of(UniformInt.of(54, 256)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(55), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_TAR_BARK_TREE = registerPlacedFeature("tar_bark_tree", DreamlandConfiguredFeatures.TAR_BARK_TREE, CountPlacement.of(UniformInt.of(0, 16)), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_TAR_SPROUTS = registerPlacedFeature("tar_sprouts", DreamlandConfiguredFeatures.TAR_SPROUTS, CountPlacement.of(UniformInt.of(24, 96)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(55), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(List.of(DreamlandBlocks.TAR_MUD.block().get())), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_TAR_SKELETON = registerPlacedFeature("tar_skeleton", DreamlandConfiguredFeatures.TAR_SKELETON, RarityFilter.onAverageOnceEvery(27), PlacementUtils.HEIGHTMAP, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(List.of(DreamlandBlocks.TAR_MUD.block().get())), 12), BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_TAR_BONE = registerPlacedFeature("tar_bone", DreamlandConfiguredFeatures.TAR_BONE, RarityFilter.onAverageOnceEvery(9), PlacementUtils.HEIGHTMAP, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(List.of(DreamlandBlocks.TAR_MUD.block().get())), 12), BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_TAR_SOIL_ORE = registerPlacedFeature("tar_soil_ore", DreamlandConfiguredFeatures.TAR_SOIL_ORE, commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160))));
	public static final Holder<PlacedFeature> LAKE_TAR_UNDERGROUND = registerPlacedFeature("lake_tar_underground", DreamlandConfiguredFeatures.LAKE_TAR, RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.top())), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.allOf(BlockPredicate.not(BlockPredicate.ONLY_IN_AIR_PREDICATE), BlockPredicate.insideWorld(new BlockPos(0, -5, 0))), 32), SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -5), BiomeFilter.biome());
	public static final Holder<PlacedFeature> SPRING_TAR = registerPlacedFeature("spring_tar", DreamlandConfiguredFeatures.SPRING_TAR, CountPlacement.of(25), InSquarePlacement.spread(), HeightRangePlacement.of(VeryBiasedToBottomHeight.of(VerticalAnchor.bottom(), VerticalAnchor.belowTop(8), 8)), BiomeFilter.biome());
	public static final Holder<PlacedFeature> FOSSILIZED_EGG = registerPlacedFeature("fossilized_egg", DreamlandConfiguredFeatures.FOSSILIZED_EGG, CountPlacement.of(25), InSquarePlacement.spread(), HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top())), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(DreamlandBlocks.TAR_MUD.block().get()), 12), BiomeFilter.biome());
	public static final Holder<PlacedFeature> TAR_HILL = registerPlacedFeature("tar_hill", DreamlandConfiguredFeatures.TAR_HILL, RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.aboveBottom(50), VerticalAnchor.belowTop(67))), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.not(BlockPredicate.matchesBlocks(DreamlandBlocks.DROUGHT_SOIL.block().get())), 12), RandomOffsetPlacement.vertical(UniformInt.of(-5, -1)),BiomeFilter.biome());
	public static final Holder<PlacedFeature> DROUGHT_SOIL_HILL = registerPlacedFeature("drought_soil_hill", DreamlandConfiguredFeatures.DROUGHT_SOIL_HILL, RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.aboveBottom(50), VerticalAnchor.belowTop(70))), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.not(BlockPredicate.matchesBlocks(DreamlandBlocks.DROUGHT_SOIL.block().get())), 12), RandomOffsetPlacement.vertical(UniformInt.of(-5, -1)),BiomeFilter.biome());
	
	public static final Holder<PlacedFeature> PLACED_PLUM_BIRCH_TREE = registerPlacedFeature("plum_birch_tree", DreamlandConfiguredFeatures.PLUM_BIRCH_TREE, CountPlacement.of(UniformInt.of(0, 24)), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_PLUM_BIRCH_LAKE = registerPlacedFeature("plum_birch_lake", DreamlandConfiguredFeatures.PLUM_BIRCH_LAKE, RarityFilter.onAverageOnceEvery(25), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_JEWELED_FOREST_VEGETATION = registerPlacedFeature("jeweled_forest_vegetation", DreamlandConfiguredFeatures.JEWELED_FOREST_VEGETATION, CountPlacement.of(UniformInt.of(16, 96)), HeightRangePlacement.uniform(VerticalAnchor.absolute(50), VerticalAnchor.top()), InSquarePlacement.spread(), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(List.of(DreamlandBlocks.FLOWERING_GRASS.block().get())), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_FLOWERING_UNDERGROWTH = registerPlacedFeature("flowering_undergrowth", DreamlandConfiguredFeatures.FLOWERING_UNDERGROWTH, CountPlacement.of(UniformInt.of(64, 96)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(50), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.matchesBlocks(List.of(DreamlandBlocks.FLOWERING_GRASS.block().get(), Blocks.GRASS_BLOCK)), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_CALCITE_ROCK = registerPlacedFeature("calcite_rock", DreamlandConfiguredFeatures.CALCITE_ROCK, RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, RandomOffsetPlacement.vertical(UniformInt.of(-14, -8)), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_OPAL_CLUSTER = registerPlacedFeature("opal_cluster", DreamlandConfiguredFeatures.OPAL_CLUSTER, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), BiomeFilter.biome());
	
	public static final Holder<PlacedFeature> KUNZITE_POINTS_EAST = registerPlacedFeature("placed_kunzite_points_east", DreamlandConfiguredFeatures.KUNZITE_POINTS_EAST, CountPlacement.of(UniformInt.of(16, 32)), InSquarePlacement.spread(), PlacementUtils.filteredByBlockSurvival(DreamlandBlocks.KUNZITE_POINT.block().get()), BiomeFilter.biome());
	public static final Holder<PlacedFeature> KUNZITE_POINTS_NORTH = registerPlacedFeature("placed_kunzite_points_north", DreamlandConfiguredFeatures.KUNZITE_POINTS_NORTH, CountPlacement.of(UniformInt.of(16, 32)), InSquarePlacement.spread(), PlacementUtils.filteredByBlockSurvival(DreamlandBlocks.KUNZITE_POINT.block().get()), BiomeFilter.biome());
	public static final Holder<PlacedFeature> KUNZITE_POINTS_PATCH_DOWN = registerPlacedFeature("kunzite_points_patch_down", DreamlandConfiguredFeatures.KUNZITE_POINTS_PATCH_DOWN, CountPlacement.of(UniformInt.of(16, 32)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome());
	public static final Holder<PlacedFeature> KUNZITE_POINTS_PATCH_UP = registerPlacedFeature("kunzite_points_patch_up", DreamlandConfiguredFeatures.KUNZITE_POINTS_PATCH_UP, CountPlacement.of(UniformInt.of(4, 16)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final Holder<PlacedFeature> KUNZITE_POINTS_SOUTH = registerPlacedFeature("placed_kunzite_points_south", DreamlandConfiguredFeatures.KUNZITE_POINTS_SOUTH, CountPlacement.of(UniformInt.of(16, 32)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, PlacementUtils.filteredByBlockSurvival(DreamlandBlocks.KUNZITE_POINT.block().get()), BiomeFilter.biome());
	public static final Holder<PlacedFeature> KUNZITE_POINTS_WEST = registerPlacedFeature("placed_kunzite_points_west", DreamlandConfiguredFeatures.KUNZITE_POINTS_WEST, CountPlacement.of(UniformInt.of(16, 32)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, PlacementUtils.filteredByBlockSurvival(DreamlandBlocks.KUNZITE_POINT.block().get()), BiomeFilter.biome());
	public static final Holder<PlacedFeature> KUNZITE_IRON_UPPER = registerPlacedFeature("kunzite_iron_upper_ore", DreamlandConfiguredFeatures.KUNZITE_IRON, commonOrePlacement(90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384))));
	public static final Holder<PlacedFeature> KUNZITE_IRON_MIDDLE = registerPlacedFeature("kunzite_iron_middle_ore", DreamlandConfiguredFeatures.KUNZITE_IRON, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
	public static final Holder<PlacedFeature> KUNZITE_IRON_SMALL = registerPlacedFeature("kunzite_iron_small_ore", DreamlandConfiguredFeatures.KUNZITE_IRON_SMALL, commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(72))));
	public static final Holder<PlacedFeature> KUNZITE_EMERALD = registerPlacedFeature("kunzite_emerald_ore", DreamlandConfiguredFeatures.KUNZITE_EMERALD, commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))));
	public static final Holder<PlacedFeature> KUNZITE_REDSTONE = registerPlacedFeature("kunzite_redstone_ore", DreamlandConfiguredFeatures.KUNZITE_REDSTONE, commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))));
	public static final Holder<PlacedFeature> KUNZITE_REDSTONE_LOWER = registerPlacedFeature("kunzite_redstone_lower_ore", DreamlandConfiguredFeatures.KUNZITE_REDSTONE, (commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32)))));
	public static final Holder<PlacedFeature> KUNZITE_DIAMOND = registerPlacedFeature("kunzite_diamond_ore", DreamlandConfiguredFeatures.KUNZITE_DIAMOND, commonOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
	public static final Holder<PlacedFeature> KUNZITE_DIAMOND_LARGE = registerPlacedFeature("kunzite_diamond_large_ore", DreamlandConfiguredFeatures.KUNZITE_DIAMOND_LARGE, (rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
	public static final Holder<PlacedFeature> KUNZITE_LAPIS = registerPlacedFeature("kunzite_lapis_ore", DreamlandConfiguredFeatures.KUNZITE_LAPIS, commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32))));
	public static final Holder<PlacedFeature> KUNZITE_COPPER = registerPlacedFeature("kunzite_copper_ore", DreamlandConfiguredFeatures.KUNZITE_COPPER, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
	public static final Holder<PlacedFeature> KUNZITE_COPPER_LARGE = registerPlacedFeature("kunzite_copper_large_ore", DreamlandConfiguredFeatures.KUNZITE_COPPER_LARGE, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
	public static final Holder<PlacedFeature> OPULENT_DEPTHS_VEGETATION = registerPlacedFeature("opulent_depths_vegetation", DreamlandConfiguredFeatures.GOLDEN_MOSS_PATCH, CountPlacement.of(100), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final Holder<PlacedFeature> GOLD_GEODE = registerPlacedFeature("gold_geode", DreamlandConfiguredFeatures.GOLD_GEODE, RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(35)), BiomeFilter.biome());
	
	private static List<PlacementModifier> orePlacement(PlacementModifier palcementModifiers, PlacementModifier p_195348_) {
		      return List.of(palcementModifiers, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
		   }
	   
	   private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier palcementModifiers) {
		      return orePlacement(CountPlacement.of(count), palcementModifiers);
		   }
	   
	   private static List<PlacementModifier> rareOrePlacement(int count, PlacementModifier palcementModifiers) {
		      return orePlacement(RarityFilter.onAverageOnceEvery(count), palcementModifiers);
		   }
	   
	   private static <FC extends FeatureConfiguration> Holder<PlacedFeature> registerPlacedFeature(String name, Holder<ConfiguredFeature<FC,?>> feature, List<PlacementModifier> placementModifiers) {
		   return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, DreamlandLoc.createLoc(name), new PlacedFeature(Holder.hackyErase(feature), List.copyOf(placementModifiers)));
	   }
	   
	   private static <FC extends FeatureConfiguration> Holder<PlacedFeature> registerPlacedFeature(String name, Holder<ConfiguredFeature<FC,?>> feature, PlacementModifier... placementModifiers) {
		   return registerPlacedFeature(name, feature, List.of(placementModifiers));
	   }
	   
	   private static ResourceKey<PlacedFeature> createPlacedFeatureKey(String name) {
		   ResourceKey<PlacedFeature> key = ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, DreamlandLoc.createLoc(name));
		   KEYS.add(key);
		   return key;
	   }
}
