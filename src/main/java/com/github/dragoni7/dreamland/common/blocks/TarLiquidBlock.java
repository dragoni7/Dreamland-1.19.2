package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.Supplier;

import com.github.dragoni7.dreamland.core.registry.DreamlandEffects;

import net.minecraft.core.BlockPos;
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

	public void stepOn(Level level, BlockPos blockPos, BlockState state, Entity entity) {
		if (!level.isClientSide()) {
			if (entity instanceof LivingEntity) {
		         ((LivingEntity) entity).addEffect(new MobEffectInstance(DreamlandEffects.TARRED.get(), 600, 1));
		      }
		}
	}
}
