package com.github.dragoni7.worldgen;

import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class DreamlandBiomeFeatures {

	public static void addHiveOres(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeaturePlacements.HIVE_IRON_UPPER);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeaturePlacements.HIVE_IRON_MIDDLE);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeaturePlacements.HIVE_COPPER);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeaturePlacements.HIVE_COPPER_LARGE);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeaturePlacements.HIVE_REDSTONE);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeaturePlacements.HIVE_REDSTONE_LOWER);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeaturePlacements.HIVE_ORE_GOLD);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeaturePlacements.HIVE_ORE_GOLD_LOWER);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeaturePlacements.HIVE_LAPIS);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeaturePlacements.HIVE_DIAMOND);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, FeaturePlacements.HIVE_DIAMOND_LARGE);
	}
	
	public static void hiveBiomeFeatures(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, FeaturePlacements.PLACED_CAVE_SLIME);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, FeaturePlacements.PLACED_HIVE_SLUDGE);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, FeaturePlacements.PLACED_HIVE_JELLY);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, FeaturePlacements.PlACED_WHITE_MOLD);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, FeaturePlacements.PLACED_HIVE_PILLAR);
	}
}
