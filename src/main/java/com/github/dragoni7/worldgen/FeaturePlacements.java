package com.github.dragoni7.worldgen;

import java.util.List;

import com.github.dragoni7.registry.DreamlandFeatures;

import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ClampedNormalInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class FeaturePlacements {
	
	public static final PlacedFeature PLACED_CAVE_SLIME = PlacementUtils.register("placed_cave_slime", DreamlandFeatures.CAVE_SLIME.placed(CountPlacement.of(UniformInt.of(0, 188)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome()));
	public static final PlacedFeature PLACED_HIVE_SLUDGE = PlacementUtils.register("placed_hive_sludge", DreamlandFeatures.HIVE_SLUDGE.placed(CountPlacement.of(UniformInt.of(0, 188)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome()));
	public static final PlacedFeature PLACED_HIVE_JELLY = PlacementUtils.register("placed_hive_jelly", DreamlandFeatures.HIVE_JELLY.placed(CountPlacement.of(UniformInt.of(0, 47)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome()));
	public static final PlacedFeature PlACED_WHITE_MOLD = PlacementUtils.register("placed_white_mold", DreamlandFeatures.WHITE_MOLD.placed(CountPlacement.of(125), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome()));
	
	public static final PlacedFeature HIVE_IRON_UPPER = PlacementUtils.register("hive_iron_upper", DreamlandFeatures.HIVE_IRON.placed(commonOrePlacement(90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384)))));
	public static final PlacedFeature HIVE_IRON_MIDDLE = PlacementUtils.register("hive_iron_middle", DreamlandFeatures.HIVE_IRON.placed(commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)))));
	public static final PlacedFeature HIVE_ORE_GOLD = PlacementUtils.register("hive_gold", DreamlandFeatures.HIVE_GOLD.placed(commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
	public static final PlacedFeature HIVE_ORE_GOLD_LOWER = PlacementUtils.register("hive_gold_lower", DreamlandFeatures.HIVE_GOLD.placed(orePlacement(CountPlacement.of(UniformInt.of(0, 1)), HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48)))));
	public static final PlacedFeature HIVE_REDSTONE = PlacementUtils.register("hive_redstone", DreamlandFeatures.HIVE_REDSTONE.placed(commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15)))));
	public static final PlacedFeature HIVE_REDSTONE_LOWER = PlacementUtils.register("hive_redstone_lower", DreamlandFeatures.HIVE_REDSTONE.placed(commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32)))));
	public static final PlacedFeature HIVE_DIAMOND = PlacementUtils.register("hive_diamond", DreamlandFeatures.HIVE_DIAMOND.placed(commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
	public static final PlacedFeature HIVE_DIAMOND_LARGE = PlacementUtils.register("hive_diamond_large", DreamlandFeatures.HIVE_DIAMOND_LARGE.placed(rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
	public static final PlacedFeature HIVE_LAPIS = PlacementUtils.register("hive_lapis", DreamlandFeatures.HIVE_LAPIS.placed(commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32)))));
	public static final PlacedFeature HIVE_COPPER = PlacementUtils.register("hive_copper", DreamlandFeatures.HIVE_COPPER.placed(commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
	public static final PlacedFeature HIVE_COPPER_LARGE = PlacementUtils.register("hive_copper_large", DreamlandFeatures.HIVE_COPPER_LARGE.placed(commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
	
	
	   private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		      return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
		   }
	   
	   private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		      return orePlacement(CountPlacement.of(p_195344_), p_195345_);
		   }
	   
	   private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
		      return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
		   }
}
