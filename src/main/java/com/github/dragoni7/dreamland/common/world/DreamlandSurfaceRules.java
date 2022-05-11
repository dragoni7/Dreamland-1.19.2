package com.github.dragoni7.dreamland.common.world;

import com.github.dragoni7.dreamland.common.world.biome.BiomeKeys;
import com.github.dragoni7.dreamland.setup.DreamlandBlocks;

import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public class DreamlandSurfaceRules
{
	//Conditions
	private static final SurfaceRules.ConditionSource ABOVE_0 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(0), 5);
	private static final SurfaceRules.ConditionSource AT_OR_ABOVE_WATER = SurfaceRules.waterBlockCheck(-1, 0);
    
    private static final SurfaceRules.RuleSource GARDEN_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(AT_OR_ABOVE_WATER, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.GRASS_BLOCK.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(Blocks.DIRT.defaultBlockState())));
    private static final SurfaceRules.RuleSource GARDEN = SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.GARDEN), GARDEN_SURFACE);
    
    private static final SurfaceRules.RuleSource HIVE_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(ABOVE_0, SurfaceRules.state(DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState())));
    private static final SurfaceRules.RuleSource HIVE = SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.HIVE), HIVE_SURFACE);
    
    private static final SurfaceRules.RuleSource TAR_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(AT_OR_ABOVE_WATER, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(DreamlandBlocks.TAR_SOIL.get().defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(DreamlandBlocks.TAR_SOIL.get().defaultBlockState())));
    private static final SurfaceRules.RuleSource TARLANDS = SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.TARLANDS), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.steep(), SurfaceRules.state(DreamlandBlocks.DROUGHT_SOIL.get().defaultBlockState())), TAR_SURFACE));
    
    private static final SurfaceRules.RuleSource OVERWORLD = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(GARDEN, TARLANDS));
    
    private static final SurfaceRules.RuleSource OVERWORLD_UNDERGROUND = SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.abovePreliminarySurface()), HIVE);
    
    public static final SurfaceRules.RuleSource OVERWORLD_SURFACE_RULES = SurfaceRules.sequence(OVERWORLD, OVERWORLD_UNDERGROUND);
}