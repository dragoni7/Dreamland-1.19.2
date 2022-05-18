package com.github.dragoni7.dreamland.common.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectTarred extends MobEffect {

	public EffectTarred() {
		super(MobEffectCategory.NEUTRAL, 0X41267a);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.35F, AttributeModifier.Operation.MULTIPLY_BASE);
	}
	
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		
		if (entity.isOnFire()) {
			entity.setSecondsOnFire(600);
		}
		entity.setJumping(false);
		entity.setDeltaMovement(entity.getDeltaMovement().add(0, -0.1D, 0));
	}
	
	public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration > 0;
    }

    public String getDescriptionId() {
        return "drealmand.effect.tarred";
    }

}
