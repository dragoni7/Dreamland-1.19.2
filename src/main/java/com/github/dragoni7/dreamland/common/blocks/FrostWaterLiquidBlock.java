package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.Supplier;

import com.github.dragoni7.dreamland.util.RollBoolean;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;

public class FrostWaterLiquidBlock extends LiquidBlock {
	public FrostWaterLiquidBlock(Supplier<? extends FlowingFluid> fluid, Properties blockProperties) {
		super(fluid, blockProperties);
	}
	
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
		if (RollBoolean.roll(6, rand)) {
			level.addParticle(ParticleTypes.SNOWFLAKE, pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), 0.0D, 0.0D, 0.0D);
		}
	}
}
