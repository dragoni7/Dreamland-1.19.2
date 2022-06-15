package com.github.dragoni7.dreamland.common.world.feature.generation;

import java.util.Random;

import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.util.RollBoolean;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class HiveComb extends Feature<BlockStateConfiguration> {
	
	private static final int SIZE = 4;

	public HiveComb(Codec<BlockStateConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
		WorldGenLevel worldgenlevel = context.level();
		BlockPos blockpos = context.origin();
		RandomSource random = context.random();
		BlockStateConfiguration blockstateconfig = context.config();
		FeatureBuilder combBuilder = new FeatureBuilder();
		BlockState combBlock = DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState();
		BlockState altFilling = DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState();
		
		if (RollBoolean.roll(9, random)) {
			altFilling = blockstateconfig.state;
		}
		
		for(int i = 0; i > -SIZE+1; i--) {
			
			combBuilder.addInput(worldgenlevel, altFilling, blockpos.offset(0, i, 0), true);
			combBuilder.addInput(worldgenlevel, altFilling, blockpos.offset(0, i, 1), true);
			combBuilder.addInput(worldgenlevel, altFilling, blockpos.offset(1, i, 1), true);
			combBuilder.addInput(worldgenlevel, altFilling, blockpos.offset(1, i, 0), true);
			
		}
		
		for(int j = 1; j > -SIZE; j--) {
			
			combBuilder.addInput(worldgenlevel, combBlock, blockpos.offset(0, j, -1), true);
			combBuilder.addInput(worldgenlevel, combBlock, blockpos.offset(1, j, -1), true);
			
			combBuilder.addInput(worldgenlevel, combBlock, blockpos.offset(0, j, 2), true);
			combBuilder.addInput(worldgenlevel, combBlock, blockpos.offset(1, j, 2), true);
			
			combBuilder.addInput(worldgenlevel, combBlock, blockpos.offset(-1, j,0), true);
			combBuilder.addInput(worldgenlevel, combBlock, blockpos.offset(-1, j,0), true);
			
			combBuilder.addInput(worldgenlevel, combBlock, blockpos.offset(2, j, 0), true);
			combBuilder.addInput(worldgenlevel, combBlock, blockpos.offset(2, j, 0), true);
			
			combBuilder.addInput(worldgenlevel, combBlock, blockpos.offset(2, j, 1), true);
			combBuilder.addInput(worldgenlevel, combBlock, blockpos.offset(-1, j, 1), true);
		}
		
		combBuilder.build(worldgenlevel);
		return true;
	}

}
