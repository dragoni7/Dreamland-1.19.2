package com.github.dragoni7.dreamland.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LargeSporePuffBlock extends MoldVegetationBlock {
	
	protected static final VoxelShape LARGE_SPORE_PUFF_SHAPE = Shapes.or(Block.box(6.0D, 0.0D, 11.0D, 7.0D, 17.0D, 12.0D), Block.box(11.0D, 0.0D, 5.0D, 12.0D, 19.0D, 16.0D), Block.box(3.0D, 0.0D, 3.0D, 4.0D, 18.0D, 4.0D), Block.box(1.5D, 18.0D, 1.5D, 5.5D, 22, 5.5D), Block.box(4.44389D, 17D, 9.54458D, 8.44389D, 21.0D, 13.54458D), Block.box(9.44389D, 19.0D, 3.54458D, 13.44389D, 23.0D, 7.54458D));

	public LargeSporePuffBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
	    return LARGE_SPORE_PUFF_SHAPE;
	}
	
	public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
		return false;
	}

}
