package com.github.dragoni7.dreamland.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OozeBlock extends HalfTransparentBlock {
	
	protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

	public OozeBlock(Properties properties) {
		super(properties);
	}
	
	public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
	   return false;
	}
	
	public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
	   return SHAPE;
	}

	public VoxelShape getBlockSupportShape(BlockState state, BlockGetter getter, BlockPos pos) {
	  return Shapes.block();
	}

	public VoxelShape getVisualShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
	   return Shapes.block();
	}
	
	public float getShadeBrightness(BlockState state, BlockGetter getter, BlockPos pos) {
		return 0.2F;
	}
	
	public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float damage) {
		entity.causeFallDamage(damage, 0.0F, DamageSource.FALL);
	}
	
	public void stepOn(Level p_154573_, BlockPos p_154574_, BlockState p_154575_, Entity p_154576_) {
	      double d0 = Math.abs(p_154576_.getDeltaMovement().y);
	      if (d0 < 0.1D && !p_154576_.isSteppingCarefully()) {
	         double d1 = 0.4D + d0 * 0.1D;
	         p_154576_.setDeltaMovement(p_154576_.getDeltaMovement().multiply(d1, 1.0D, d1));
	      }

	      super.stepOn(p_154573_, p_154574_, p_154575_, p_154576_);
	}
}
