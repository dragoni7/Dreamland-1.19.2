package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.Supplier;

import com.github.dragoni7.dreamland.core.registry.DreamlandEffects;
import com.github.dragoni7.dreamland.core.registry.DreamlandParticles;
import com.github.dragoni7.dreamland.util.RollBoolean;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

public class TarLiquidBlock extends LiquidBlock {

	public TarLiquidBlock(Supplier<? extends FlowingFluid> fluid, Properties blockProperties) {
		super(fluid, blockProperties);
	}
	
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
		if (RollBoolean.roll(16, rand)) {
			level.addParticle(DreamlandParticles.TAR_BUBBLE.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), 0.0D, 0.0D, 0.0D);
		}
	}
}
