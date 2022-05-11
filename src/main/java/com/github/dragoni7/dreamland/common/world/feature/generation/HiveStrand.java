package com.github.dragoni7.dreamland.common.world.feature.generation;

import java.util.Random;

import com.github.dragoni7.dreamland.core.DreamlandBlocks;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class HiveStrand extends Feature<NoneFeatureConfiguration>{

	public HiveStrand(Codec<NoneFeatureConfiguration> p_65786_) {
		super(p_65786_);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> p_159749_) {
		WorldGenLevel worldgenlevel = p_159749_.level();
		BlockPos blockpos = p_159749_.origin();
		Random random = p_159749_.random();
		boolean fill = (random.nextInt(11) < 1);
		switch(random.nextInt(6)) {
		case 0: return growXZPos(worldgenlevel, blockpos, fill, random, p_159749_);
		case 1: return growXZNeg(worldgenlevel, blockpos, fill, random, p_159749_);
		case 2: return growXPos(worldgenlevel, blockpos, fill, random, p_159749_);
		case 3: return growXNeg(worldgenlevel, blockpos, fill, random, p_159749_);
		case 4: return growZPos(worldgenlevel, blockpos, fill, random, p_159749_);
		case 6: return growZNeg(worldgenlevel, blockpos, fill, random, p_159749_);
		default: return false;
		}
		
	}
	
	private boolean buildStrand(BlockState blockstate, WorldGenLevel worldgenlevel, BlockPos blockpos, boolean fill, int i, int j, int k) {
		blockstate = worldgenlevel.getBlockState(blockpos.offset(i,j,k));
		int height = j-2;
		if((blockstate.isAir() || blockstate.is(Blocks.WATER)) && !(blockpos.offset(i,j,k).getY() > 60)) {
			this.setBlock(worldgenlevel, blockpos.offset(i,j,k), DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState());
			this.setBlock(worldgenlevel, blockpos.offset(i,j+1,k), DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState());
			this.setBlock(worldgenlevel, blockpos.offset(i,j-1,k), DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState());
			if(fill) {
				while((worldgenlevel.getBlockState(blockpos.offset(i,height,k)).isAir() || worldgenlevel.getBlockState(blockpos.offset(i,height,k)).is(Blocks.WATER)) && blockpos.offset(i,height,k).getY() < 60 && blockpos.offset(i,height,k).getY() > worldgenlevel.getMinBuildHeight()) {
					this.setBlock(worldgenlevel, blockpos.offset(i,height,k), DreamlandBlocks.HIVE_MEMBRANE.get().defaultBlockState());
					height--;
				}
			}
			
		}
		else {
			if(fill) {
				height = j-2;
				while((worldgenlevel.getBlockState(blockpos.offset(i,height,k)).isAir() || worldgenlevel.getBlockState(blockpos.offset(i,height,k)).is(Blocks.WATER)) && blockpos.offset(i,height,k).getY() < 60 && blockpos.offset(i,height,k).getY() > worldgenlevel.getMinBuildHeight()) {
					this.setBlock(worldgenlevel, blockpos.offset(i,height,k), DreamlandBlocks.HIVE_BLOCK.get().defaultBlockState());
					height--;
				}
			}
			return false;
		}
		
		return true;
	}
	
	private boolean growXZPos(WorldGenLevel worldgenlevel, BlockPos blockpos, boolean fill, Random random, FeaturePlaceContext<NoneFeatureConfiguration> p_159749_) {
		BlockState blockstate = worldgenlevel.getBlockState(blockpos);
		for(int i = 0, j = 0, k = 0; j < worldgenlevel.getMaxBuildHeight(); i++, j+=random.nextInt(1,3), k++) {
			if(!buildStrand(blockstate, worldgenlevel, blockpos, fill, i, j, k)) {
				break;
			}
		}
		return true;
	}
	
	private boolean growXZNeg(WorldGenLevel worldgenlevel, BlockPos blockpos, boolean fill, Random random, FeaturePlaceContext<NoneFeatureConfiguration> p_159749_) {
		BlockState blockstate = worldgenlevel.getBlockState(blockpos);
		for(int i = 0, j = 0, k = 0; j < worldgenlevel.getMaxBuildHeight(); i--, j+=random.nextInt(1, 3), k--) {
			if(!buildStrand(blockstate, worldgenlevel, blockpos, fill, i, j, k)) {
				break;
			}
		}
		return true;
	}
	
	private boolean growXPos(WorldGenLevel worldgenlevel, BlockPos blockpos, boolean fill, Random random, FeaturePlaceContext<NoneFeatureConfiguration> p_159749_) {
		BlockState blockstate = worldgenlevel.getBlockState(blockpos);
		for(int i = 0, j = 0, k = 0; j < worldgenlevel.getMaxBuildHeight(); i++, j+=random.nextInt(1, 3)) {
			if(!buildStrand(blockstate, worldgenlevel, blockpos, fill, i, j, k)) {
				break;
			}
		}
		return true;
	}
	
	private boolean growXNeg(WorldGenLevel worldgenlevel, BlockPos blockpos, boolean fill, Random random, FeaturePlaceContext<NoneFeatureConfiguration> p_159749_) {
		BlockState blockstate = worldgenlevel.getBlockState(blockpos);
		for(int i = 0, j = 0, k = 0; j < worldgenlevel.getMaxBuildHeight(); i--, j+=random.nextInt(1, 3)) {
			if(!buildStrand(blockstate, worldgenlevel, blockpos, fill, i, j, k)) {
				break;
			}
		}
		return true;
	}
	
	private boolean growZPos(WorldGenLevel worldgenlevel, BlockPos blockpos, boolean fill, Random random, FeaturePlaceContext<NoneFeatureConfiguration> p_159749_) {
		BlockState blockstate = worldgenlevel.getBlockState(blockpos);
		for(int i = 0, j = 0, k = 0; j < worldgenlevel.getMaxBuildHeight(); j+=random.nextInt(1, 3), k++) {
			if(!buildStrand(blockstate, worldgenlevel, blockpos, fill, i, j, k)) {
				break;
			}
		}
		return true;
	}
	
	private boolean growZNeg(WorldGenLevel worldgenlevel, BlockPos blockpos, boolean fill, Random random, FeaturePlaceContext<NoneFeatureConfiguration> p_159749_) {
		BlockState blockstate = worldgenlevel.getBlockState(blockpos);
		for(int i = 0, j = 0, k = 0; j < worldgenlevel.getMaxBuildHeight(); j+=random.nextInt(1, 3), k--) {
			if(!buildStrand(blockstate, worldgenlevel, blockpos, fill, i, j, k)) {
				break;
			}
		}
		return true;
	}

}
