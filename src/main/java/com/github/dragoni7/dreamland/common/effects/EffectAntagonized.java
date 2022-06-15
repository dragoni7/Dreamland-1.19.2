package com.github.dragoni7.dreamland.common.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class EffectAntagonized extends MobEffect {
	
	public EffectAntagonized() {
		super(MobEffectCategory.HARMFUL, 0X77baa9);
	}
	
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		
	}
	
	public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration > 0;
    }

    public String getDescriptionId() {
        return "drealmand.effect.antagonized";
    }

}
