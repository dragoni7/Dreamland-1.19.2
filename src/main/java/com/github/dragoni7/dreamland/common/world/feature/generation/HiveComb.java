package com.github.dragoni7.dreamland.common.world.feature.generation;

import java.util.Random;

import com.github.dragoni7.dreamland.core.DreamlandBlocks;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;

public class HiveComb extends Feature<BlockStateConfiguration> {

	public HiveComb(Codec<BlockStateConfiguration> p_65786_) {
		super(p_65786_);
	}

	@Override
	public boolean place(FeaturePlaceContext<BlockStateConfiguration> context) {
		WorldGenLevel worldgenlevel = context.level();
		BlockPos blockpos = context.origin();
		Random random = context.random();
		BlockStateConfiguration blockstateconfig = context.config();
		BlockState altFilling = DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState();
		
		if(random.nextBoolean()) {
			altFilling = blockstateconfig.state;
		}
		
		for(int j = 0; j > -6; j--) {
			this.setBlock(worldgenlevel, blockpos.offset(0,j,0), altFilling);
			this.setBlock(worldgenlevel, blockpos.offset(0,j,1), altFilling);
			this.setBlock(worldgenlevel, blockpos.offset(1,j,1), altFilling);
			this.setBlock(worldgenlevel, blockpos.offset(1,j,0), altFilling);
			
		}
		
		for(int j = 1; j > -7; j--) {
			this.setBlock(worldgenlevel, blockpos.offset(0,j,-1), DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState());
			this.setBlock(worldgenlevel, blockpos.offset(1,j,-1), DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState());
			
			this.setBlock(worldgenlevel, blockpos.offset(0,j,2), DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState());
			this.setBlock(worldgenlevel, blockpos.offset(1,j,2), DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState());
			
			this.setBlock(worldgenlevel, blockpos.offset(-1,j,0), DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState());
			this.setBlock(worldgenlevel, blockpos.offset(-1,j,0), DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState());
			
			this.setBlock(worldgenlevel, blockpos.offset(2,j,0), DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState());
			this.setBlock(worldgenlevel, blockpos.offset(2,j,0), DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState());
			
			this.setBlock(worldgenlevel, blockpos.offset(2,j,1), DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState());
			this.setBlock(worldgenlevel, blockpos.offset(-1,j,1), DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState());
		}
		return true;
	}

}
