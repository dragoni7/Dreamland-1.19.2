package com.github.dragoni7.dreamland.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MoldBlock extends Block {
	
	protected static final VoxelShape SHAPE = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16D, 16D, 16D), Block.box(8D, 16D, 0.5D, 8D, 19D, 15.5D), Block.box(8D, 16D, 0.5D, 8D, 19D, 15.5D), Block.box(8D, -3D, 0.5D, 8D, 0D, 15.5D), Block.box(8D, -3D, 0.5D, 8D, 0D, 15.5D), Block.box(-2.5D, 8D, 0.5D, 0.5D, 8D, 15.5D), Block.box(-3D, 0.5D, 8D, 0D, 15.5D, 8D), Block.box(15.5D, 0.5D, 8D, 18.5D, 15.5D, 8D), Block.box(15.5D, 8D, 0.5D, 18.5D, 8D, 15.5D), Block.box(0.5D, 8D, 16D, 15.5D, 8D, 19D), Block.box(8D, 0.5D, 16D, 8D, 15.5D, 19D), Block.box(8D, 0.5D, -3D, 8D, 15.5D, 0D), Block.box(0.5D, 8D, -3D, 15.5D, 8D, 0D));

	public MoldBlock(Properties properties) {
		super(properties);
	}
	
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
	    return SHAPE;
	}
	
	public float getShadeBrightness(BlockState state, BlockGetter getter, BlockPos pos) {
	    return 0.2F;
	}
	
	public boolean skipRendering(BlockState state1, BlockState state2, Direction direction) {
		if (state2.getBlock() instanceof MoldBlock) {
			return true;
		}
		
	    return false;
	}
}
