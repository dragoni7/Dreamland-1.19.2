package com.github.dragoni7.dreamland.common.world.feature.generation;

import java.util.Random;

import com.github.dragoni7.dreamland.core.DreamlandBlocks;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class HiveStrand extends Feature<NoneFeatureConfiguration> {
	
	private static final int MAXSIZE = 60;
	
	public HiveStrand(Codec<NoneFeatureConfiguration> p_65786_) {
		super(p_65786_);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		
		WorldGenLevel worldgenlevel = context.level();
		BlockPos blockpos = context.origin();
		Random random = context.random();
		FeatureBuilder strandBuilder = new FeatureBuilder();
		boolean fill = (random.nextInt(11) < 1);
		
		switch(random.nextInt(6)) {
		case 0: return growXZPos(worldgenlevel, strandBuilder, blockpos, fill, random);
		case 1: return growXZNeg(worldgenlevel, strandBuilder, blockpos, fill, random);
		case 2: return growXPos(worldgenlevel, strandBuilder, blockpos, fill, random);
		case 3: return growXNeg(worldgenlevel, strandBuilder, blockpos, fill, random);
		case 4: return growZPos(worldgenlevel, strandBuilder, blockpos, fill, random);
		case 6: return growZNeg(worldgenlevel, strandBuilder, blockpos, fill, random);
		default: return false;
		}
		
	}
	
	private boolean buildStrand(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, boolean fill, int i, int j, int k) {
		BlockState strandBlock = DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState();
		BlockState fillBlock = DreamlandBlocks.HIVE_MEMBRANE.get().defaultBlockState();
		int height = j-2;
		boolean status = true;
		
		builder.addInput(worldgenlevel, strandBlock, blockpos.offset(i,j,k));
		status = builder.addInput(worldgenlevel, strandBlock, blockpos.offset(i,j+1,k));
		builder.addInput(worldgenlevel, strandBlock, blockpos.offset(i,j-1,k));
		
		if(fill) {
			while(blockpos.offset(i,height,k).getY() < MAXSIZE && blockpos.offset(i,height,k).getY() > worldgenlevel.getMinBuildHeight()) {
				
				builder.addInput(worldgenlevel, fillBlock, blockpos.offset(i,height,k));
				height--;
			}
		}
		
		if (!status) {
			if(fill) {
				height = j-2;
				while(blockpos.offset(i,height,k).getY() < 60 && blockpos.offset(i,height,k).getY() > worldgenlevel.getMinBuildHeight()) {
					
					builder.addInput(worldgenlevel, strandBlock, blockpos.offset(i,height,k));
					height--;
				}
			}
			return status;
		}
		
		return status;
	}
	
	private boolean growXZPos(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, boolean fill, Random random) {
		for(int i = 0, j = 0, k = 0; j < MAXSIZE; i++, j+=random.nextInt(1,3), k++) {
			if(!buildStrand(worldgenlevel, builder, blockpos, fill, i, j, k)) {
				builder.build(worldgenlevel);
				return true;
			}
		}
		return false;
	}
	
	private boolean growXZNeg(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, boolean fill, Random random) {
		for(int i = 0, j = 0, k = 0; j <= MAXSIZE; i--, j+=random.nextInt(1, 3), k--) {
			if(!buildStrand(worldgenlevel, builder, blockpos, fill, i, j, k)) {
				builder.build(worldgenlevel);
				return true;
			}
		}
		return false;
	}
	
	private boolean growXPos(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, boolean fill, Random random) {
		for(int i = 0, j = 0, k = 0; j <= MAXSIZE; i++, j+=random.nextInt(1, 3)) {
			if(!buildStrand(worldgenlevel, builder, blockpos, fill, i, j, k)) {
				builder.build(worldgenlevel);
				return true;
			}
		}
		return false;
	}
	
	private boolean growXNeg(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, boolean fill, Random random) {
		for(int i = 0, j = 0, k = 0; j <= MAXSIZE; i--, j+=random.nextInt(1, 3)) {
			if(!buildStrand(worldgenlevel, builder, blockpos, fill, i, j, k)) {
				builder.build(worldgenlevel);
				return true;
			}
		}
		return false;
	}
	
	private boolean growZPos(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, boolean fill, Random random) {
		for(int i = 0, j = 0, k = 0; j <= MAXSIZE; j+=random.nextInt(1, 3), k++) {
			if(!buildStrand(worldgenlevel, builder, blockpos, fill, i, j, k)) {
				builder.build(worldgenlevel);
				return true;
			}
		}
		return false;
	}
	
	private boolean growZNeg(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, boolean fill, Random random) {
		for(int i = 0, j = 0, k = 0; j <= MAXSIZE; j+=random.nextInt(1, 3), k--) {
			if(!buildStrand(worldgenlevel, builder, blockpos, fill, i, j, k)) {
				builder.build(worldgenlevel);
				return true;
			}
		}
		return false;
	}

}
