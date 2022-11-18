package com.github.dragoni7.dreamland.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OpalClusterBlock extends Block {
	
	protected static final VoxelShape SHAPE = Shapes.or(Block.box(10.0D, 0.0D, 4.0D, 13.0D, 4.0D, 7.0D), Block.box(10.0D, 0.0D, 9.0D, 13.0D, 6.0D, 12.0D), Block.box(4, 0, 8, 6, 7, 10), Block.box(5, 0, 11, 8, 2, 14), Block.box(4, 0, 4, 7, 5, 7), Block.box(6, 0, 6, 11, 9, 11));
	private int counter = 0;
	
	public OpalClusterBlock(Properties properties) {
		super(properties);
	}
	
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
	    return SHAPE;
	}
	
	public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
		return false;
	}
	
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
		if (counter % 60 == 0) {
			level.addParticle(ParticleTypes.ELECTRIC_SPARK, pos.getX() + rand.nextDouble(), pos.getY() + 0.75D, pos.getZ() + rand.nextDouble(), 0.0D, 0.0D, 0.0D);
		}
		counter++;
	}

}
