package com.github.dragoni7.dreamland.common.world.biome;

import com.github.dragoni7.dreamland.common.world.feature.DreamlandFeaturePlacements;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
public class DreamlandBiomeFeatures {

	public static void addHiveOres(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.PLACED_FILLED_HIVE_BLOCK);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.HIVE_IRON_UPPER);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.HIVE_IRON_MIDDLE);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.HIVE_COPPER);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.HIVE_COPPER_LARGE);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.HIVE_REDSTONE);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.HIVE_REDSTONE_LOWER);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.HIVE_ORE_GOLD);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.HIVE_ORE_GOLD_LOWER);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.HIVE_LAPIS);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.HIVE_DIAMOND);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.HIVE_DIAMOND_LARGE);
	}
	
	public static void midascavesBiomeFeatures(BiomeGenerationSettings.Builder builder) {
		BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
        
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.KUNZITE_COPPER);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.KUNZITE_COPPER_LARGE);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.KUNZITE_DIAMOND);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.KUNZITE_DIAMOND_LARGE);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.KUNZITE_EMERALD);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.KUNZITE_IRON_MIDDLE);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.KUNZITE_IRON_SMALL);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.KUNZITE_IRON_UPPER);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.KUNZITE_LAPIS);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.KUNZITE_REDSTONE);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.KUNZITE_REDSTONE_LOWER);
		
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.OPULENT_DEPTHS_VEGETATION);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DreamlandFeaturePlacements.KUNZITE_POINTS_PATCH_UP);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DreamlandFeaturePlacements.KUNZITE_POINTS_PATCH_DOWN);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.KUNZITE_POINTS_NORTH);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.KUNZITE_POINTS_SOUTH);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.KUNZITE_POINTS_EAST);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.KUNZITE_POINTS_WEST);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DreamlandFeaturePlacements.GOLD_GEODE);
	}
	
	public static void hiveBiomeFeatures(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DreamlandFeaturePlacements.PLACED_HIVE_COMB);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.PLACED_HIVE_STRAND);
		builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, DreamlandFeaturePlacements.HIVE_CAVE);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.PLACED_CAVE_SLIME);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.PLACED_HIVE_JELLY_CLUSTER);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.PLACED_INFESTED_HIVE_JELLY_CLUSTER);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.PLACED_HIVE_GROWTH);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OrePlacements.ORE_ANDESITE_UPPER);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OrePlacements.ORE_DIORITE_UPPER);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OrePlacements.ORE_GRANITE_UPPER);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OrePlacements.ORE_DIRT);
	}
	
	public static void tardeltasBiomeFeatures(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.LAKES, DreamlandFeaturePlacements.PLACED_TAR_DELTA);
		builder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, DreamlandFeaturePlacements.PLACED_TAR_SKELETON);
		builder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, DreamlandFeaturePlacements.PLACED_TAR_BONE);
		builder.addFeature(GenerationStep.Decoration.LAKES, DreamlandFeaturePlacements.DROUGHT_BORDERED_DISK_SURFACE);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.PLACED_DROUGHT_VEGETATION);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.PLACED_TAR_SPROUTS);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.PLACED_TAR_BARK_TREE);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.PLACED_TAR_SOIL_ORE);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.FOSSILIZED_EGG);
		builder.addFeature(GenerationStep.Decoration.LAKES, DreamlandFeaturePlacements.LAKE_TAR_UNDERGROUND);
		builder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, DreamlandFeaturePlacements.SPRING_TAR);
		builder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, DreamlandFeaturePlacements.TAR_HILL);
		builder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, DreamlandFeaturePlacements.DROUGHT_SOIL_HILL);
	}
	
	public static void jeweledForestBiomeFeatures(BiomeGenerationSettings.Builder builder) {
		//builder.addFeature(GenerationStep.Decoration.LAKES, DreamlandFeaturePlacements.PLACED_PLUM_BIRCH_LAKE);
		builder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, DreamlandFeaturePlacements.PLACED_CALCITE_ROCK);
		builder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, DreamlandFeaturePlacements.PLACED_AMETHYST_ROCK);
		
		builder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, DreamlandFeaturePlacements.PLACED_OPAL_CLUSTER);
		builder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, DreamlandFeaturePlacements.PLACED_PLUM_BIRCH_TREE);
		builder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, DreamlandFeaturePlacements.PLACED_JEWELED_FOREST_VEGETATION);
		builder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, DreamlandFeaturePlacements.PLACED_FLOWERING_UNDERGROWTH);
	}
	
	public static void toxicJungleBiomeFeatures(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.RAW_GENERATION, DreamlandFeaturePlacements.POROUS_SPIRES);
		builder.addFeature(GenerationStep.Decoration.RAW_GENERATION, DreamlandFeaturePlacements.POROUS_SPHERE);
		builder.addFeature(GenerationStep.Decoration.RAW_GENERATION, DreamlandFeaturePlacements.POROUS_HILL);
		builder.addFeature(GenerationStep.Decoration.RAW_GENERATION, DreamlandFeaturePlacements.MOLD_WOOD_ROOTS);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.TOXIC_VEGETATION);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandFeaturePlacements.DECAYED_VEGETATION);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DreamlandFeaturePlacements.MOLD_CARPET_UNDERGROUND);
		builder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, DreamlandFeaturePlacements.MOLD_GROWTH);
		builder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, DreamlandFeaturePlacements.MOLD_WOOD_STUMP);
		builder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, DreamlandFeaturePlacements.MOLD_WOOD_TREE);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.MOLD_PUFF_TREE);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.TOXIC_JUNGLE_VEGETATION);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.MOLD_CARPET_DIRT);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.MOLD_CARPET_STONE);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.TOXIC_JUNGLE_GLOW_LICHEN);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandFeaturePlacements.SHELF_VEGETATION);
	}
}
