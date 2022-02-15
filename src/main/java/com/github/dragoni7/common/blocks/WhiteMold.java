package com.github.dragoni7.common.blocks;

import java.util.Random;

import com.github.dragoni7.registry.DreamlandParticles;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WhiteMold extends CarpetBlock{

	public WhiteMold(Properties p_152915_) {
		super(p_152915_);
	}
	
	public void animateTick(BlockState state, Level level, BlockPos pos, Random p_54903_) {
	      super.animateTick(state, level, pos, p_54903_);
	      if (p_54903_.nextInt(10) == 0) {
	         level.addParticle(ParticleTypes.MYCELIUM, (double)pos.getX() + p_54903_.nextDouble(), (double)pos.getY() + 1.1D, (double)pos.getZ() + p_54903_.nextDouble(), 0.0D, 0.0D, 0.0D);
	      }
	}
}
