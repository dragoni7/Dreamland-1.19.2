package com.github.dragoni7.dreamland.common.world;

import com.github.dragoni7.dreamland.common.world.biome.BiomeKeys;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class DreamlandSurfaceRules
{
	private static final SurfaceRules.ConditionSource AT_OR_ABOVE_WATER = SurfaceRules.waterBlockCheck(-1, 0);
	
	private static final SurfaceRules.RuleSource RAW_GOLD_BANDS = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CAVE_CHEESE, -0.0025, 0.0125), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CAVE_CHEESE, -0.0025, 0.0025), SurfaceRules.state(Blocks.RAW_GOLD_BLOCK.defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CAVE_CHEESE, 0.0025, 0.0125), SurfaceRules.state(DreamlandBlocks.GOLD_BEARING_QUARTZITE.block().get().defaultBlockState())))));
	private static final SurfaceRules.RuleSource MIDAS_CAVES = SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.MIDAS_CAVES), SurfaceRules.sequence( 
    		SurfaceRules.ifTrue(SurfaceRules.verticalGradient("dreamland:bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())),
    		SurfaceRules.ifTrue(SurfaceRules.verticalGradient("dreamland:kunzite_stone", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), SurfaceRules.state(DreamlandBlocks.KUNZITE_STONE.block().get().defaultBlockState())),
    		RAW_GOLD_BANDS
    		));

	private static final SurfaceRules.RuleSource HIVE_SURFACE = SurfaceRules.sequence(SurfaceRules.state(DreamlandBlocks.HIVE_BLOCK.block().get().defaultBlockState()));
	private static final SurfaceRules.RuleSource HIVE = SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.HIVE), HIVE_SURFACE);
    
    private static final SurfaceRules.RuleSource TAR_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(AT_OR_ABOVE_WATER, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(DreamlandBlocks.TAR_MUD.block().get().defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(DreamlandBlocks.TAR_MUD.block().get().defaultBlockState())));
    private static final SurfaceRules.RuleSource TAR_DELTAS = SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.TAR_DELTAS), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.steep(), SurfaceRules.state(DreamlandBlocks.DROUGHT_SOIL.block().get().defaultBlockState())), TAR_SURFACE));
    
    private static final SurfaceRules.RuleSource JEWELED_FOREST_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(AT_OR_ABOVE_WATER, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(DreamlandBlocks.FLOWERING_GRASS.block().get().defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(DreamlandBlocks.MINERAL_DIRT.block().get().defaultBlockState())));
    private static final SurfaceRules.RuleSource JEWELED_FOREST = SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.JEWELED_FOREST), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.steep(), SurfaceRules.state(Blocks.CALCITE.defaultBlockState())), JEWELED_FOREST_SURFACE));
    
    private static final SurfaceRules.RuleSource BLACK_MOLD_PATCHES = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CALCITE, 0.6, 1.0), SurfaceRules.state(DreamlandBlocks.BLACK_MOLD.block().get().defaultBlockState())));
    private static final SurfaceRules.RuleSource WHITE_MOLD_PATCHES = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CALCITE, -0.7, 0.1), SurfaceRules.state(DreamlandBlocks.WHITE_MOLD.block().get().defaultBlockState())));
    private static final SurfaceRules.RuleSource TOXIC_JUNGLE_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(AT_OR_ABOVE_WATER, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(DreamlandBlocks.TOXIC_GRASS.block().get().defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(DreamlandBlocks.TOXIC_DIRT.block().get().defaultBlockState())));
    private static final SurfaceRules.RuleSource TOXIC_JUNGLE_CAVES = SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.abovePreliminarySurface()), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 3, CaveSurface.FLOOR), SurfaceRules.state(DreamlandBlocks.WHITE_MOLD.block().get().defaultBlockState())));
    private static final SurfaceRules.RuleSource TOXIC_JUNGLE = SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.TOXIC_JUNGLE), SurfaceRules.sequence( 
    		SurfaceRules.ifTrue(SurfaceRules.verticalGradient("dreamland:bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())),
    		SurfaceRules.ifTrue(SurfaceRules.verticalGradient("dreamland:pure_stone", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), SurfaceRules.state(DreamlandBlocks.PURE_STONE.block().get().defaultBlockState())),
    		SurfaceRules.ifTrue(SurfaceRules.steep(), SurfaceRules.state(DreamlandBlocks.PETRIFIED_VEGETATION.block().get().defaultBlockState())),
    		WHITE_MOLD_PATCHES,
    		BLACK_MOLD_PATCHES,
    		TOXIC_JUNGLE_CAVES,
    		TOXIC_JUNGLE_SURFACE,
    		SurfaceRules.state(DreamlandBlocks.PETRIFIED_VEGETATION.block().get().defaultBlockState())
    		));
    
    private static final SurfaceRules.RuleSource DAWNIC_FROSTFIELD_SURFACE = SurfaceRules.sequence(SurfaceRules.ifTrue(AT_OR_ABOVE_WATER, SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.state(Blocks.SNOW_BLOCK.defaultBlockState()))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.state(DreamlandBlocks.FROST.block().get().defaultBlockState())));
    private static final SurfaceRules.RuleSource DAWNIC_FROSTFIELD_CAVES = SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.abovePreliminarySurface()), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 3, CaveSurface.FLOOR), SurfaceRules.state(DreamlandBlocks.FROST.block().get().defaultBlockState())));
    private static final SurfaceRules.RuleSource ICE_BANDS = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CAVE_CHEESE, -0.025, 0.0125), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CAVE_CHEESE, -0.025, 0.0), SurfaceRules.state(Blocks.BLUE_ICE.defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CAVE_CHEESE, 0.0, 0.0125), SurfaceRules.state(DreamlandBlocks.DAWN_ICE.block().get().defaultBlockState())))));
    
    private static final SurfaceRules.RuleSource DAWNIC_FROSTFIELD = SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeKeys.DAWNIC_FROSTFIELD), SurfaceRules.sequence( 
    		SurfaceRules.ifTrue(SurfaceRules.verticalGradient("dreamland:bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())),
    		SurfaceRules.ifTrue(SurfaceRules.verticalGradient("dreamland:permafrost", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), SurfaceRules.state(DreamlandBlocks.PERMAFROST.block().get().defaultBlockState())),
    		SurfaceRules.ifTrue(SurfaceRules.steep(), SurfaceRules.state(DreamlandBlocks.FROSTSTONE.block().get().defaultBlockState())),
    		ICE_BANDS,
    		DAWNIC_FROSTFIELD_CAVES,
    		DAWNIC_FROSTFIELD_SURFACE,
    		SurfaceRules.state(DreamlandBlocks.FROSTSTONE.block().get().defaultBlockState())
    		));
    
    private static final SurfaceRules.RuleSource OVERWORLD_UNDERGROUND = SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.abovePreliminarySurface()), SurfaceRules.sequence(HIVE, MIDAS_CAVES));
    private static final SurfaceRules.RuleSource OVERWORLD = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(TAR_DELTAS, JEWELED_FOREST));
    
    public static final SurfaceRules.RuleSource OVERWORLD_SURFACE_RULES = SurfaceRules.sequence(OVERWORLD, OVERWORLD_UNDERGROUND, TOXIC_JUNGLE, DAWNIC_FROSTFIELD);
}