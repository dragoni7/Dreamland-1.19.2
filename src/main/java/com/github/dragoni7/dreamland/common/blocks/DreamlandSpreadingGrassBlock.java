package com.github.dragoni7.dreamland.common.blocks;

import java.util.Random;
import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LayerLightEngine;

public abstract class DreamlandSpreadingGrassBlock extends Block implements BonemealableBlock {
	
	private Supplier<Block> dirt;

	public DreamlandSpreadingGrassBlock(Properties blockProperties, Supplier<Block> spreadableBlock) {
		super(blockProperties);
		this.dirt = spreadableBlock;
	}

	@Override
	public boolean isValidBonemealTarget(BlockGetter getter, BlockPos blockpos, BlockState state, boolean b) {
		return getter.getBlockState(blockpos.above()).isAir();
	}

	@Override
	public boolean isBonemealSuccess(Level level, Random rand, BlockPos blockpos, BlockState state) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel serverLevel, Random rand, BlockPos pos, BlockState state) {
		  
	}
	
	private static boolean canBeGrass(BlockState state, LevelReader level, BlockPos pos) {
	      BlockPos blockpos = pos.above();
	      BlockState blockstate = level.getBlockState(blockpos);
	      
	      if (blockstate.getFluidState().getAmount() == 8) {
	         return false;
	      } else {
	         int i = LayerLightEngine.getLightBlockInto(level, state, pos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(level, blockpos));
	         return i < level.getMaxLightLevel();
	      }
	   }
	
	private static boolean canPropagate(BlockState state, LevelReader level, BlockPos pos) {
	      BlockPos blockpos = pos.above();
	      return canBeGrass(state, level, pos) && !level.getFluidState(blockpos).is(FluidTags.WATER);
	   }
	
	@SuppressWarnings("deprecation")
	public void randomTick(BlockState state, ServerLevel serverLevel, BlockPos pos, Random rand) {
	      if (!canBeGrass(state, serverLevel, pos)) {
	         if (!serverLevel.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
	         serverLevel.setBlockAndUpdate(pos, dirt.get().defaultBlockState());
	      } else {
	         if (!serverLevel.isAreaLoaded(pos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
	         if (serverLevel.getMaxLocalRawBrightness(pos.above()) >= 9) {
	            BlockState blockstate = this.defaultBlockState();

	            for(int i = 0; i < 4; ++i) {
	               BlockPos blockpos = pos.offset(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
	               if (serverLevel.getBlockState(blockpos).is(dirt.get()) && canPropagate(blockstate, serverLevel, blockpos)) {
	            	   serverLevel.setBlockAndUpdate(blockpos, blockstate);
	               }
	            }
	         }

	      }
	   }

}
