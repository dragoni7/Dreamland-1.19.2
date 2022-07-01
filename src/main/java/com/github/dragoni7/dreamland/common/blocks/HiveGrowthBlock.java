package com.github.dragoni7.dreamland.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.state.BlockState;

public class HiveGrowthBlock extends CarpetBlock {

	public HiveGrowthBlock(Properties properties) {
		super(properties);
	}
	
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
	      super.animateTick(state, level, pos, rand);
	      if (rand.nextInt(10) == 0) {
	         level.addParticle(ParticleTypes.MYCELIUM, (double)pos.getX() + rand.nextDouble(), (double)pos.getY() + 1.1D, (double)pos.getZ() + rand.nextDouble(), 0.0D, 0.0D, 0.0D);
	      }
	}
	
	@SuppressWarnings("deprecation")
	public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
	    return super.canBeReplaced(state, context);
	}
}
