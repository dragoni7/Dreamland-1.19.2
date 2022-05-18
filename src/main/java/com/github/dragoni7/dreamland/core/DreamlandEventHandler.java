package com.github.dragoni7.dreamland.core;


import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.entities.mobs.LarvaEntity;
import com.github.dragoni7.dreamland.core.registry.DreamlandEffects;
import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class DreamlandEventHandler {

	public static void subscribeModEvents(IEventBus modBus, IEventBus forgeBus) {
		
		modBus.addListener(DreamlandEventHandler::addAttributes);
		forgeBus.addListener(DreamlandEventHandler::onPlayerTick);
	}
		
	public static void addAttributes(final EntityAttributeCreationEvent event) {
		event.put(DreamlandEntities.LARVA.get(), LarvaEntity.customAttributes().build());
	}
	
	public static void onPlayerTick(LivingEvent.LivingUpdateEvent event) {
		LivingEntity entity = event.getEntityLiving();
		MobEffect tarred = DreamlandEffects.TARRED.get();
		
		if (entity.level.getFluidState(entity.blockPosition()).is(DreamlandFluids.TAR_FLUID.get())) {
			Vec3 motion = entity.getDeltaMovement();
			
			if (motion.x != 0 || motion.z != 0) {
				
				if (entity.hasEffect(tarred)) {
					entity.removeEffect(tarred);
				}
				
				entity.addEffect(new MobEffectInstance(tarred, 600));
			}
		}
	}
}
