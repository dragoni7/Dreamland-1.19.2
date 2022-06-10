package com.github.dragoni7.dreamland.common.effects;

import java.util.List;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.entities.mobs.LarvaEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

public class EffectAntagonized extends MobEffect {
	
	private int pulse = 20;
	
	public EffectAntagonized() {
		super(MobEffectCategory.HARMFUL, 0X77baa9);
	}
	
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		if (pulse == 20) {
			BlockPos pos = entity.blockPosition();
			Level level = entity.getLevel();
			List<LarvaEntity> list = level.getEntitiesOfClass(LarvaEntity.class, (new AABB(pos)).inflate(16.0D * amplifier, 10.0D * amplifier, 16.0D * amplifier));
			if (!list.isEmpty()) {
		         for(LarvaEntity larva : list) {
		        	 larva.setTarget(entity);
		         }
		      }
			
			pulse = 0;
		}
		
		pulse++;
	}
	
	public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration > 0;
    }

    public String getDescriptionId() {
        return "drealmand.effect.antagonized";
    }

}
