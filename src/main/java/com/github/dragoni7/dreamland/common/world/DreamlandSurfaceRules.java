package com.github.dragoni7.dreamland.common.world;

import com.github.dragoni7.dreamland.common.world.biome.BiomeKeys;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class DreamlandSurfaceRules
{
	private static final SurfaceRules.ConditionSource AT_OR_ABOVE_WATER = SurfaceRules.waterBlockCheck(-1, 0);
	
	private static final SurfaceRules.RuleSource RAW_GOLD_BANDS = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CAVE_CHEESE, -0.0025, 0.0125), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CAVE_CHEESE, -0.0025, 0.0025), SurfaceRules.state(Blocks.RAW_GOLD_BLOCK.defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CAVE_CHEESE, 0.0025, 0.0125), SurfaceRules.state(DreamlandBlocks.GOLD_BEARING_QUARTZITE.block().get().defaultBlockState())))));
	
	private static final SurfaceRules.RuleSource OPULENT_DEPTHS_SURFACE = SurfaceRules.sequence(SurfaceRules.state(DreamlandBlocks.KUNZITE_STONE.block().get().defaultBlockState()));
	private static final SurfaceRules.RuleSource OPULENT_DEPTHS = SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.MIDAS_CAVES), SurfaceRules.sequence(RAW_GOLD_BANDS, OPULENT_DEPTHS_SURFACE));
	
	private static final SurfaceRules.RuleSource HIVE_SURFACE = SurfaceRules.sequence(SurfaceRules.state(DreamlandBlocks.HIVE_BLOCK.block().get().defaultBlockState()));
	private static final SurfaceRules.RuleSource HIVE = SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.HIVE), HIVE_SURFACE);
    
    private static final SurfaceRules.RuleSource TAR_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(AT_OR_ABOVE_WATER, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(DreamlandBlocks.TAR_MUD.block().get().defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(DreamlandBlocks.TAR_MUD.block().get().defaultBlockState())));
    private static final SurfaceRules.RuleSource TAR_DELTAS = SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.TAR_DELTAS), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.steep(), SurfaceRules.state(DreamlandBlocks.DROUGHT_SOIL.block().get().defaultBlockState())), TAR_SURFACE));
    
    private static final SurfaceRules.RuleSource JEWELED_FOREST_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(AT_OR_ABOVE_WATER, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(DreamlandBlocks.FLOWERING_GRASS.block().get().defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(DreamlandBlocks.MINERAL_DIRT.block().get().defaultBlockState())));
    private static final SurfaceRules.RuleSource JEWELED_FOREST = SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.JEWELED_FOREST), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.steep(), SurfaceRules.state(Blocks.CALCITE.defaultBlockState())), JEWELED_FOREST_SURFACE));
    
    private static final SurfaceRules.RuleSource OVERWORLD = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(TAR_DELTAS, JEWELED_FOREST));
    
    private static final SurfaceRules.RuleSource OVERWORLD_UNDERGROUND = SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.abovePreliminarySurface()), SurfaceRules.sequence(HIVE, OPULENT_DEPTHS));
    
    public static final SurfaceRules.RuleSource OVERWORLD_SURFACE_RULES = SurfaceRules.sequence(OVERWORLD, OVERWORLD_UNDERGROUND);
}