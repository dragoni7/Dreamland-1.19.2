package com.github.dragoni7.dreamland.common.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.Vec3;

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
		
		Vec3 motion = entity.getDeltaMovement();
		
		if (motion.y > 0.0D) {
			entity.setDeltaMovement(motion.multiply(1.0D, -0.9D, 1.0D));
		}
	}
	
	public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration > 0;
    }

    public String getDescriptionId() {
        return "drealmand.effect.tarred";
    }

}
