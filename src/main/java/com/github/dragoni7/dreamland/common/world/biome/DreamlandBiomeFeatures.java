package com.github.dragoni7.dreamland.common.world.biome;

import com.github.dragoni7.dreamland.common.world.feature.DreamlandPlacedFeature;

import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
public class DreamlandBiomeFeatures {

	public static void addHiveOres(BiomeGenerationSettings.Builder builder) {
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DreamlandPlacedFeature.PLACED_FILLED_HIVE_BLOCK);
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
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DreamlandPlacedFeature.PLACED_HIVE_COMB);
		builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, DreamlandPlacedFeature.PLACED_HIVE_STRAND);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandPlacedFeature.PLACED_CAVE_SLIME);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandPlacedFeature.PLACED_HIVE_JELLY_CLUSTER);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandPlacedFeature.PLACED_INFESTED_HIVE_JELLY_CLUSTER);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DreamlandPlacedFeature.PLACED_HIVE_GROWTH);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OrePlacements.ORE_ANDESITE_UPPER);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OrePlacements.ORE_DIORITE_UPPER);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OrePlacements.ORE_GRANITE_UPPER);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, OrePlacements.ORE_DIRT);
	}
}
