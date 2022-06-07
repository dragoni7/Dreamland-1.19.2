package com.github.dragoni7.dreamland.core.event;


import com.github.dragoni7.dreamland.common.entities.mobs.LarvaEntity;
import com.github.dragoni7.dreamland.common.entities.mobs.OozeEntity;
import com.github.dragoni7.dreamland.core.registry.DreamlandEffects;
import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.github.dragoni7.dreamland.network.Networking;
import com.github.dragoni7.dreamland.network.PacketApplyTarred;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class DreamlandEventHandler {

	public static void init(IEventBus modBus, IEventBus forgeBus) {
		
		modBus.addListener(DreamlandEventHandler::addAttributes);
		forgeBus.addListener(DreamlandEventHandler::onLivingUpdate);
	}
		
	public static void addAttributes(EntityAttributeCreationEvent event) {
		
		SpawnPlacements.register(DreamlandEntities.OOZE.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, OozeEntity::checkOozeSpawnRules);
		event.put(DreamlandEntities.LARVA.get(), LarvaEntity.customAttributes().build());
		event.put(DreamlandEntities.OOZE.get(), OozeEntity.customAttributes().build());
	}
	
	public static void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
		LivingEntity entity = event.getEntityLiving();
		MobEffect tarred = DreamlandEffects.TARRED.get();
		
		if (entity.level.getFluidState(entity.blockPosition()).is(DreamlandFluids.TAR_FLUID.get()) || entity.level.getFluidState(entity.blockPosition()).is(DreamlandFluids.TAR_FLOWING.get())) {
			Vec3 motion = entity.getDeltaMovement();
			
			if (motion.x != 0 || motion.z != 0) {
				
				if (!entity.hasEffect(tarred)) {
					entity.addEffect(new MobEffectInstance(tarred, 600));
					Networking.sendToServer(new PacketApplyTarred(entity.getId()));
				}
			}
		}
	}
}
