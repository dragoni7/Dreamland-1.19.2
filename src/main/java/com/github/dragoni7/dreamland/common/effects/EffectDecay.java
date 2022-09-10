package com.github.dragoni7.dreamland.common.effects;

import com.github.dragoni7.dreamland.core.registry.DreamlandEffects;
import com.github.dragoni7.dreamland.data.DreamlandItemTags;
import com.github.dragoni7.dreamland.util.RollBoolean;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class EffectDecay extends MobEffect {
	public EffectDecay() {
		super(MobEffectCategory.HARMFUL, 0X5bb392);
	}
	
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ItemStack helmet = entity.getItemBySlot(EquipmentSlot.HEAD).copy();
		if (!helmet.is(DreamlandItemTags.PREVENTS_DECAY)) {
			if (RollBoolean.roll(75, entity.getRandom())) {
				entity.hurt(DamageSource.WITHER, 1.0F);
			}
			if (entity instanceof Player) {
				((Player)entity).causeFoodExhaustion(0.5F * (float)(amplifier + 1));
			} 
		}
		else {
			entity.removeEffect(DreamlandEffects.DECAY.get());
		}
	}
	
	public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    public String getDescriptionId() {
        return "drealmand.effect.decay";
    }

}
