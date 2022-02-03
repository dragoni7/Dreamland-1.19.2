package com.github.dragoni7.worldgen;

import com.github.dragoni7.registry.DreamlandBlocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class DreamlandSurfaceRules
{
	//Conditions
	private static final SurfaceRules.ConditionSource ABOVE_0 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(0), 0);
	private static final SurfaceRules.ConditionSource UNDER_0 = SurfaceRules.verticalGradient("dreamland:under0", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8));
	private static final SurfaceRules.ConditionSource AT_OR_ABOVE_WATER = SurfaceRules.waterBlockCheck(-1, 0);
	
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource DEEPSLATE = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("dreamland:under0", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), SurfaceRules.state(Blocks.DEEPSLATE.defaultBlockState())));
    private static final SurfaceRules.RuleSource BLUE_TERRACOTTA = makeStateRule(DreamlandBlocks.DARK_QUARTZITE.get());
    private static final SurfaceRules.RuleSource BEDROCK = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("dreamland:bedrock_layer", VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(5)), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())));
    
    private static final SurfaceRules.RuleSource DEFAULT = SurfaceRules.sequence(SurfaceRules.ifTrue(AT_OR_ABOVE_WATER, GRASS_BLOCK), DIRT);
    private static final SurfaceRules.RuleSource HIVE_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(ABOVE_0, SurfaceRules.state(DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState())), SurfaceRules.sequence(BEDROCK,DEEPSLATE));
    
    protected static SurfaceRules.RuleSource makeRules()
    {
        return SurfaceRules.sequence(
        		
            SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.HIVE), HIVE_SURFACE),
            SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.COLD_BLUE), BLUE_TERRACOTTA),

            // Default to a grass and dirt surface
            SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, DEFAULT)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }
}