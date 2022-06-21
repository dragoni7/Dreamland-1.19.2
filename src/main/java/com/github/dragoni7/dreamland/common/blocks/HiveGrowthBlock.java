package com.github.dragoni7.dreamland.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.state.BlockState;

public class HiveGrowthBlock extends CarpetBlock {

	public HiveGrowthBlock(Properties p_152915_) {
		super(p_152915_);
	}
	
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource p_54903_) {
	      super.animateTick(state, level, pos, p_54903_);
	      if (p_54903_.nextInt(10) == 0) {
	         level.addParticle(ParticleTypes.MYCELIUM, (double)pos.getX() + p_54903_.nextDouble(), (double)pos.getY() + 1.1D, (double)pos.getZ() + p_54903_.nextDouble(), 0.0D, 0.0D, 0.0D);
	      }
	}
	
	@SuppressWarnings("deprecation")
	public boolean canBeReplaced(BlockState p_153299_, BlockPlaceContext p_153300_) {
	      return super.canBeReplaced(p_153299_, p_153300_);
	   }
}
