package com.github.dragoni7.dreamland.common.blocks;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;

public class BuddingGoldBlock extends Block {
	
	public static final int GROWTH_CHANCE = 5;
	private static final Direction[] DIRECTIONS = Direction.values();

	public BuddingGoldBlock(Properties properties) {
		super(properties);
	}
	
	public PushReaction getPistonPushReaction(BlockState state) {
	    return PushReaction.DESTROY;
	}
	
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
	      if (random.nextInt(5) == 0) {
	         Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
	         BlockPos blockpos = pos.relative(direction);
	         BlockState blockstate = level.getBlockState(blockpos);
	         Block block = null;
	         if (canClusterGrowAtState(blockstate)) {
	            block = DreamlandBlocks.SMALL_GOLD_CLUSTER.block().get();
	         } else if (blockstate.is(DreamlandBlocks.SMALL_GOLD_CLUSTER.block().get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
	            block = DreamlandBlocks.MEDIUM_GOLD_CLUSTER.block().get();
	         } else if (blockstate.is(DreamlandBlocks.MEDIUM_GOLD_CLUSTER.block().get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
	            block = DreamlandBlocks.LARGE_GOLD_CLUSTER.block().get();
	         } else if (blockstate.is(DreamlandBlocks.LARGE_GOLD_CLUSTER.block().get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
	            block = DreamlandBlocks.GOLD_CLUSTER.block().get();
	         }

	         if (block != null) {
	            BlockState blockstate1 = block.defaultBlockState().setValue(GoldClusterBlock.FACING, direction).setValue(GoldClusterBlock.WATERLOGGED, Boolean.valueOf(blockstate.getFluidState().getType() == Fluids.WATER));
	            level.setBlockAndUpdate(blockpos, blockstate1);
	         }

	      }
	   }
	
	public static boolean canClusterGrowAtState(BlockState state) {
	    return state.isAir() || state.is(Blocks.WATER) && state.getFluidState().getAmount() == 8;
	 }
}
