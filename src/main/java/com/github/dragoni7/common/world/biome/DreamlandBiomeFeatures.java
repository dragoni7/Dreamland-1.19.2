package com.github.dragoni7.common.world.biome;

import com.github.dragoni7.common.world.feature.DreamlandPlacedFeature;

import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class DreamlandBiomeFeatures {

	public static void addHiveOres(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandPlacedFeature.HIVE_IRON_UPPER);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandPlacedFeature.HIVE_IRON_MIDDLE);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandPlacedFeature.HIVE_COPPER);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandPlacedFeature.HIVE_COPPER_LARGE);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandPlacedFeature.HIVE_REDSTONE);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandPlacedFeature.HIVE_REDSTONE_LOWER);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandPlacedFeature.HIVE_ORE_GOLD);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandPlacedFeature.HIVE_ORE_GOLD_LOWER);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandPlacedFeature.HIVE_LAPIS);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandPlacedFeature.HIVE_DIAMOND);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandPlacedFeature.HIVE_DIAMOND_LARGE);
	}
	
	public static void hiveBiomeFeatures(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandPlacedFeature.PLACED_CAVE_SLIME);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandPlacedFeature.PLACED_HIVE_SLUDGE);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandPlacedFeature.PLACED_HIVE_JELLY);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandPlacedFeature.PLACED_WHITE_MOLD);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DreamlandPlacedFeature.PLACED_HIVE_PILLAR);
	}
}
