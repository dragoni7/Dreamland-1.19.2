package com.github.dragoni7.dreamland.common.world.feature.generation;

import com.github.dragoni7.dreamland.common.blocks.HiveWeaverBlock;
import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.util.RollBoolean;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class HiveStrand extends Feature<NoneFeatureConfiguration> {
	
	private static final int MAXSIZE = 60;
	
	public HiveStrand(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		
		WorldGenLevel worldgenlevel = context.level();
		BlockPos blockpos = context.origin();
		RandomSource random = context.random();
		FeatureBuilder strandBuilder = new FeatureBuilder();
		boolean fill = RollBoolean.roll(9, random);
		
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
	
	private boolean buildStrand(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, RandomSource rand, int i, int j, int k) {
		return buildStrand(worldgenlevel, builder, blockpos, rand, null, false, i, j, k);
	}
	
	private boolean buildStrand(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, RandomSource rand, Direction direction, boolean fill, int i, int j, int k) {
		BlockState strandBlock = DreamlandBlocks.HIVE_BLOCK.block().get().defaultBlockState();
		BlockState fillBlock = DreamlandBlocks.HIVE_MEMBRANE.block().get().defaultBlockState();
		BlockState core = DreamlandBlocks.HIVE_WEAVER.block().get().defaultBlockState().setValue(HiveWeaverBlock.LEVEL, Integer.valueOf(HiveWeaverBlock.MAX_LEVEL));
		int height = j - 2;
		BlockPos fillPos = blockpos.offset(i, height, k);
		boolean status = true;
		int offsetxz = rand.nextInt(0, 2);
		int offsety = rand.nextInt(0, 2);
		
		builder.addInput(worldgenlevel, strandBlock, blockpos.offset(i,j,k));
		status = builder.addInput(worldgenlevel, strandBlock, blockpos.offset(i,j+1,k));
		builder.addInput(worldgenlevel, strandBlock, blockpos.offset(i,j-1,k));
		
		if(fill) {
			if (j == 1 || j == 2) {
				builder.addInput(worldgenlevel, core.setValue(HorizontalDirectionalBlock.FACING, direction).setValue(HiveWeaverBlock.LEVEL, Integer.valueOf(6)), blockpos.offset(i,j,k), true);
			}
			
			while(fillPos.getY() < MAXSIZE && fillPos.getY() > worldgenlevel.getMinBuildHeight()) {
				fillPos = blockpos.offset(i, height, k);
				
				if (!worldgenlevel.isEmptyBlock(fillPos) && fillPos.getY() < blockpos.getY()) {
					break;
				}
				if (direction.equals(Direction.NORTH)) {
					if (placeCore(i, height)) {
						if (offsetxz != 0 || offsety != 0) {
							builder.addInput(worldgenlevel, fillBlock, fillPos);
						}
						builder.addInput(worldgenlevel, core.setValue(HorizontalDirectionalBlock.FACING, direction), fillPos.offset(offsetxz, offsety, 0), true);
						offsetxz = rand.nextInt(0, 2);
						offsety = rand.nextInt(0, 2);
					}
					else {
						builder.addInput(worldgenlevel, fillBlock, fillPos);
					}
				}
				else if (direction.equals(Direction.WEST)) {
					if (placeCore(k, height)) {
						if (offsetxz != 0 || offsety != 0) {
							builder.addInput(worldgenlevel, fillBlock, fillPos);
						}
						builder.addInput(worldgenlevel, core.setValue(HorizontalDirectionalBlock.FACING, direction), fillPos.offset(0, offsety, offsetxz), true);
						offsetxz = rand.nextInt(0, 2);
						offsety = rand.nextInt(0, 2);
					}
					else {
						builder.addInput(worldgenlevel, fillBlock, fillPos);
					}
				}
				else {
					builder.addInput(worldgenlevel, fillBlock, fillPos);
				}
				
				height--;
			}
		}
		
		if (!status) {
			if(fill) {
				
				height = j-2;
				fillPos = blockpos.offset(i, height, k);
				builder.addInput(worldgenlevel, core.setValue(HorizontalDirectionalBlock.FACING, direction).setValue(HiveWeaverBlock.LEVEL, Integer.valueOf(6)), fillPos, true);
				height--;
				
				while(fillPos.getY() < MAXSIZE && fillPos.getY() > worldgenlevel.getMinBuildHeight()) {
					
					fillPos = blockpos.offset(i, height, k);
					
					if (!worldgenlevel.isEmptyBlock(fillPos) && fillPos.getY() < blockpos.getY()) {
						builder.addInput(worldgenlevel, core.setValue(HorizontalDirectionalBlock.FACING, direction).setValue(HiveWeaverBlock.LEVEL, Integer.valueOf(6)), fillPos.above(rand.nextInt(4, 6)), true);
						break;
					}
					builder.addInput(worldgenlevel, strandBlock, fillPos);
					height--;
				}
			}
			return status;
		}
		return status;
	}
	
	private boolean placeCore(int i, int y) {
		return y % 6 == 0 && i % 3 == 0;
	}
	
	private boolean growXZPos(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, boolean fill, RandomSource random) {
		for(int i = 0, j = 0, k = 0; j < MAXSIZE; i++, j+=random.nextInt(1,3), k++) {
			if(!buildStrand(worldgenlevel, builder, blockpos, random, i, j, k)) {
				builder.build(worldgenlevel);
				return true;
			}
		}
		return false;
	}
	
	private boolean growXZNeg(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, boolean fill, RandomSource random) {
		for(int i = 0, j = 0, k = 0; j <= MAXSIZE; i--, j+=random.nextInt(1, 3), k--) {
			if(!buildStrand(worldgenlevel, builder, blockpos, random, i, j, k)) {
				builder.build(worldgenlevel);
				return true;
			}
		}
		return false;
	}
	
	private boolean growXPos(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, boolean fill, RandomSource random) {
		for(int i = 0, j = 0, k = 0; j <= MAXSIZE; i++, j+=random.nextInt(1, 3)) {
			if(!buildStrand(worldgenlevel, builder, blockpos, random, Direction.NORTH, fill, i, j, k)) {
				builder.build(worldgenlevel);
				return true;
			}
		}
		return false;
	}
	
	private boolean growXNeg(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, boolean fill, RandomSource random) {
		for(int i = 0, j = 0, k = 0; j <= MAXSIZE; i--, j+=random.nextInt(1, 3)) {
			if(!buildStrand(worldgenlevel, builder, blockpos, random, Direction.NORTH, fill, i, j, k)) {
				builder.build(worldgenlevel);
				return true;
			}
		}
		return false;
	}
	
	private boolean growZPos(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, boolean fill, RandomSource random) {
		for(int i = 0, j = 0, k = 0; j <= MAXSIZE; j+=random.nextInt(1, 3), k++) {
			if(!buildStrand(worldgenlevel, builder, blockpos, random, Direction.WEST, fill, i, j, k)) {
				builder.build(worldgenlevel);
				return true;
			}
		}
		return false;
	}
	
	private boolean growZNeg(WorldGenLevel worldgenlevel, FeatureBuilder builder, BlockPos blockpos, boolean fill, RandomSource random) {
		for(int i = 0, j = 0, k = 0; j <= MAXSIZE; j+=random.nextInt(1, 3), k--) {
			if(!buildStrand(worldgenlevel, builder, blockpos, random, Direction.WEST, fill, i, j, k)) {
				builder.build(worldgenlevel);
				return true;
			}
		}
		return false;
	}

}
