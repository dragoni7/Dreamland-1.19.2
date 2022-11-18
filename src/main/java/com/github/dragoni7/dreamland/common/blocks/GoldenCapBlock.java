package com.github.dragoni7.dreamland.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GoldenCapBlock extends BushBlock {
	
	protected static final VoxelShape SHAPE = Shapes.or(Block.box(5.5D, 0.0D, 5.5D, 10.5D, 13.0D, 10.5D), Block.box(3.0D, 13.0D, 3.0D, 13.0D, 18.0D, 13.0D));

	public GoldenCapBlock(Properties properties) {
		super(properties);
	}
	
	public PushReaction getPistonPushReaction(BlockState state) {
	    return PushReaction.DESTROY;
	}
	
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

}
