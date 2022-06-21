package com.github.dragoni7.dreamland.common.blocks;

import java.util.Random;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;

public class ClaySoilBlock extends Block implements BonemealableBlock{

	public ClaySoilBlock(Properties p_49795_) {
		super(p_49795_);
	}
	
	@Override
	public boolean isValidBonemealTarget(BlockGetter p_55002_, BlockPos p_55003_, BlockState p_55004_, boolean p_55005_) {
	      if (!p_55002_.getBlockState(p_55003_.above()).propagatesSkylightDown(p_55002_, p_55003_)) {
	         return false;
	      } else {
	         for(BlockPos blockpos : BlockPos.betweenClosed(p_55003_.offset(-1, -1, -1), p_55003_.offset(1, 1, 1))) {
	            if (p_55002_.getBlockState(blockpos).is(DreamlandBlocks.CLAY_SOIL_GRASS.block().get())) {
	               return true;
	            }
	         }

	         return false;
	      }
	   }

		@Override
	   public boolean isBonemealSuccess(Level p_55007_, RandomSource p_55008_, BlockPos p_55009_, BlockState p_55010_) {
	      return true;
	   }

		@Override
	   public void performBonemeal(ServerLevel p_54997_, RandomSource p_54998_, BlockPos p_54999_, BlockState p_55000_) {
	      boolean flag1 = false;

	      for(BlockPos blockpos : BlockPos.betweenClosed(p_54999_.offset(-1, -1, -1), p_54999_.offset(1, 1, 1))) {
	         BlockState blockstate = p_54997_.getBlockState(blockpos);
	         if (blockstate.is(DreamlandBlocks.CLAY_SOIL_GRASS.block().get())) {
	            flag1 = true;
	         }
	         if (flag1) {
	            break;
	         }
	      }

	      if (flag1) {
	         p_54997_.setBlock(p_54999_, DreamlandBlocks.CLAY_SOIL_GRASS.block().get().defaultBlockState(), 3);
	      }

	   }

}