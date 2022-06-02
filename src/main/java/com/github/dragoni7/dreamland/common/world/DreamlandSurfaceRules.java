package com.github.dragoni7.dreamland.common.world;

import com.github.dragoni7.dreamland.common.world.biome.BiomeKeys;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class DreamlandSurfaceRules
{
	//Conditions
	private static final SurfaceRules.ConditionSource ABOVE_0 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(0), 5);
	private static final SurfaceRules.ConditionSource AT_OR_ABOVE_WATER = SurfaceRules.waterBlockCheck(-1, 0);
	
    private static final SurfaceRules.RuleSource HIVE_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(ABOVE_0, SurfaceRules.state(DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState())));
    private static final SurfaceRules.RuleSource HIVE = SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.HIVE), HIVE_SURFACE);
    
    private static final SurfaceRules.RuleSource TAR_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(AT_OR_ABOVE_WATER, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(DreamlandBlocks.TAR_SOIL.get().defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(DreamlandBlocks.TAR_SOIL.get().defaultBlockState())));
    private static final SurfaceRules.RuleSource TAR_DELTAS = SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.TAR_DELTAS), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.steep(), SurfaceRules.state(DreamlandBlocks.DROUGHT_SOIL.get().defaultBlockState())), TAR_SURFACE));
    
    private static final SurfaceRules.RuleSource JEWELED_FOREST_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(AT_OR_ABOVE_WATER, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(DreamlandBlocks.FLOWERING_UNDERGROWTH.get().defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(DreamlandBlocks.MINERAL_DIRT.get().defaultBlockState())));
    private static final SurfaceRules.RuleSource JEWELED_FOREST = SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.JEWELED_FOREST), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.steep(), SurfaceRules.state(Blocks.CALCITE.defaultBlockState())), JEWELED_FOREST_SURFACE));
    
    private static final SurfaceRules.RuleSource OVERWORLD = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(TAR_DELTAS, JEWELED_FOREST));
    
    private static final SurfaceRules.RuleSource OVERWORLD_UNDERGROUND = SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.abovePreliminarySurface()), HIVE);
    
    public static final SurfaceRules.RuleSource OVERWORLD_SURFACE_RULES = SurfaceRules.sequence(OVERWORLD, OVERWORLD_UNDERGROUND);
}