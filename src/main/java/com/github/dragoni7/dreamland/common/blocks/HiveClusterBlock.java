package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.ToIntFunction;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
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
	
	public static ToIntFunction<BlockState> emission(int lightLevel) {
	      return (light) -> {
		         return lightLevel;
		      };
		   }
}
