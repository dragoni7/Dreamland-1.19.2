package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.ToIntFunction;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HiveClusterBlock extends LarvaAngerableBlock {
	
	protected static final VoxelShape SHAPE = Block.box(2.5D, 0.0D, 2.5D, 13.5D, 11.0D, 13.5D);

	public HiveClusterBlock(Properties properties) {
		super(properties);
	}
	
	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
	    return SHAPE;
	}
	
	public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
		  return false;
	}
	
	public boolean skipRendering(BlockState state1, BlockState state2, Direction direction) {
	      return state2.is(this) ? true : super.skipRendering(state1, state2, direction);
	}
	
	public static ToIntFunction<BlockState> emission(int lightLevel) {
	      return (light) -> { return lightLevel; };
	}
}
