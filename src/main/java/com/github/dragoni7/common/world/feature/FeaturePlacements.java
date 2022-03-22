package com.github.dragoni7.common.world.feature;

import java.util.List;

import com.github.dragoni7.Dreamland;
import com.github.dragoni7.registry.ConfiguredDreamlandFeatures;
import com.github.dragoni7.util.DreamlandLoc;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
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
	
	public static final Holder<PlacedFeature> PLACED_CAVE_SLIME = PlacementUtils.register("placed_cave_slime", ConfiguredDreamlandFeatures.CAVE_SLIME, CountPlacement.of(UniformInt.of(60, 256)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_HIVE_SLUDGE = PlacementUtils.register("placed_hive_sludge", ConfiguredDreamlandFeatures.HIVE_SLUDGE_PATCH, CountPlacement.of(UniformInt.of(10, 25)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_HIVE_PILLAR = PlacementUtils.register("placed_hive_pillar", ConfiguredDreamlandFeatures.HIVE_PILLAR, CountPlacement.of(UniformInt.of(48, 96)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	public static final Holder<PlacedFeature> PLACED_HIVE_JELLY = PlacementUtils.register("placed_hive_jelly", ConfiguredDreamlandFeatures.HIVE_JELLY, CountPlacement.of(UniformInt.of(0, 47)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	public static final Holder<PlacedFeature> PLACED_WHITE_MOLD = PlacementUtils.register("placed_white_mold", ConfiguredDreamlandFeatures.MOLD_PATCH, CountPlacement.of(UniformInt.of(10, 47)), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top()), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
	
	public static final Holder<PlacedFeature> HIVE_IRON_UPPER = PlacementUtils.register("hive_iron_upper", ConfiguredDreamlandFeatures.HIVE_IRON, (commonOrePlacement(90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384)))));
	public static final Holder<PlacedFeature> HIVE_IRON_MIDDLE = PlacementUtils.register("hive_iron_middle", ConfiguredDreamlandFeatures.HIVE_IRON, (commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)))));
	public static final Holder<PlacedFeature> HIVE_ORE_GOLD = PlacementUtils.register("hive_gold", ConfiguredDreamlandFeatures.HIVE_GOLD, (commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
	public static final Holder<PlacedFeature> HIVE_ORE_GOLD_LOWER = PlacementUtils.register("hive_gold_lower", ConfiguredDreamlandFeatures.HIVE_GOLD, (orePlacement(CountPlacement.of(UniformInt.of(0, 1)), HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48)))));
	public static final Holder<PlacedFeature> HIVE_REDSTONE = PlacementUtils.register("hive_redstone", ConfiguredDreamlandFeatures.HIVE_REDSTONE, (commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15)))));
	public static final Holder<PlacedFeature> HIVE_REDSTONE_LOWER = PlacementUtils.register("hive_redstone_lower", ConfiguredDreamlandFeatures.HIVE_REDSTONE, (commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-32), VerticalAnchor.aboveBottom(32)))));
	public static final Holder<PlacedFeature> HIVE_DIAMOND = PlacementUtils.register("hive_diamond", ConfiguredDreamlandFeatures.HIVE_DIAMOND, (commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
	public static final Holder<PlacedFeature> HIVE_DIAMOND_LARGE = PlacementUtils.register("hive_diamond_large", ConfiguredDreamlandFeatures.HIVE_DIAMOND_LARGE, (rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
	public static final Holder<PlacedFeature> HIVE_LAPIS = PlacementUtils.register("hive_lapis", ConfiguredDreamlandFeatures.HIVE_LAPIS, (commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32)))));
	public static final Holder<PlacedFeature> HIVE_COPPER = PlacementUtils.register("hive_copper", ConfiguredDreamlandFeatures.HIVE_COPPER, (commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
	public static final Holder<PlacedFeature> HIVE_COPPER_LARGE = PlacementUtils.register("hive_copper_large", ConfiguredDreamlandFeatures.HIVE_COPPER_LARGE, (commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
	
	
	   private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		      return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
		   }
	   
	   private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		      return orePlacement(CountPlacement.of(p_195344_), p_195345_);
		   }
	   
	   private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
		      return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
		   }
	   
	   private static void registerPlacedFeatures(String path, PlacedFeature feature) {
		   Registry.register(BuiltinRegistries.PLACED_FEATURE, DreamlandLoc.newLoc(path), feature);
	   }
	   
	   public static void init() {
		   registerPlacedFeatures("placed_cave_slime", PLACED_CAVE_SLIME);
		   registerPlacedFeatures("placed_hive_sludge", PLACED_HIVE_SLUDGE);
		   registerPlacedFeatures("placed_hive_pillar", PLACED_HIVE_PILLAR);
		   registerPlacedFeatures("placed_hive_jelly", PLACED_HIVE_JELLY);
		   registerPlacedFeatures("placed_white_mold", PLACED_WHITE_MOLD);
		   
		   registerPlacedFeatures("hive_iron_upper", HIVE_IRON_UPPER);
		   registerPlacedFeatures("hive_iron_middle", HIVE_IRON_MIDDLE);
		   registerPlacedFeatures("hive_iron_middle", HIVE_IRON_MIDDLE);
		   registerPlacedFeatures("hive_gold", HIVE_ORE_GOLD);
		   registerPlacedFeatures("hive_gold_lower", HIVE_ORE_GOLD_LOWER);
		   registerPlacedFeatures("hive_redstone", HIVE_REDSTONE);
		   registerPlacedFeatures("hive_redstone_lower", HIVE_REDSTONE_LOWER);
		   registerPlacedFeatures("hive_diamond", HIVE_DIAMOND);
		   registerPlacedFeatures("hive_diamond_large", HIVE_DIAMOND_LARGE);
		   registerPlacedFeatures("hive_lapis", HIVE_LAPIS);
		   registerPlacedFeatures("hive_copper", HIVE_COPPER);
		   registerPlacedFeatures("hive_copper_large", HIVE_COPPER_LARGE);
	   }
}
