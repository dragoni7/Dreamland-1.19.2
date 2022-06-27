package com.github.dragoni7.dreamland.core.event;


import java.util.List;

import com.github.dragoni7.dreamland.common.entities.mobs.BumbleBeastEntity;
import com.github.dragoni7.dreamland.common.entities.mobs.LarvaEntity;
import com.github.dragoni7.dreamland.common.entities.mobs.OozeEntity;
import com.github.dragoni7.dreamland.core.registry.DreamlandEffects;
import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;
import com.github.dragoni7.dreamland.network.Networking;
import com.github.dragoni7.dreamland.network.PacketApplyTarred;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class DreamlandEventHandler {

	public static void init(IEventBus modBus, IEventBus forgeBus) {
		
		modBus.addListener(DreamlandEventHandler::addAttributes);
		forgeBus.addListener(DreamlandEventHandler::updateTarredEffect);
		forgeBus.addListener(DreamlandEventHandler::setLarvaTarget);
		forgeBus.addListener(DreamlandEventHandler::entityHitLarvaSymbiote);
		forgeBus.addListener(DreamlandEventHandler::onLarvaAttacked);
	}
		
	public static void addAttributes(EntityAttributeCreationEvent event) {
		
		SpawnPlacements.register(DreamlandEntities.BUMBLE_BEAST.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BumbleBeastEntity::checkBumbleBeastSpawnRules);
		SpawnPlacements.register(DreamlandEntities.LARVA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, LarvaEntity::checkLarvaSpawnRules);
		SpawnPlacements.register(DreamlandEntities.OOZE.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, OozeEntity::checkOozeSpawnRules);
		event.put(DreamlandEntities.BUMBLE_BEAST.get(), BumbleBeastEntity.customAttributes().build());
		event.put(DreamlandEntities.LARVA.get(), LarvaEntity.customAttributes().build());
		event.put(DreamlandEntities.OOZE.get(), OozeEntity.customAttributes().build());
	}
	
	public static void updateTarredEffect(LivingEvent.LivingUpdateEvent event) {
		LivingEntity entity = event.getEntityLiving();
		if (entity.isInFluidType(DreamlandFluids.TAR_FLUID_TYPE.get())) {
			Vec3 motion = entity.getDeltaMovement();
			MobEffect tarred = DreamlandEffects.TARRED.get();
			
			if (motion.x != 0 || motion.z != 0) {
				
				entity.addEffect(new MobEffectInstance(tarred, 600));
				Networking.sendToServer(new PacketApplyTarred(entity.getId()));
			}
		}
	}
	
	public static void onLarvaAttacked(LivingHurtEvent event) {
		LivingEntity target = event.getEntityLiving();
		Entity attacker = event.getSource().getEntity();
		
		if (attacker instanceof LivingEntity && target instanceof LarvaEntity && !(attacker instanceof LarvaEntity)) {
			((LivingEntity) attacker).addEffect(new MobEffectInstance(DreamlandEffects.ANTAGONIZED.get(), 200));
		}
	}
	
	public static void setLarvaTarget(LivingEvent.LivingUpdateEvent event) {
		int interval = 20;
		if (interval == 20) {
			LivingEntity entity = event.getEntityLiving();
			BlockPos pos = entity.blockPosition();
			Level level = entity.getLevel();
			if (!level.isClientSide && entity != null) {
				if (entity.hasEffect(DreamlandEffects.ANTAGONIZED.get())) {
					List<LarvaEntity> list = level.getEntitiesOfClass(LarvaEntity.class, (new AABB(pos)).inflate(16.0D, 10.0D, 16.0D));
					if (!list.isEmpty()) {
				         for(LarvaEntity larva : list) {
				        	 larva.setTarget(entity);
				         }
				      }
				}
			}
			
			interval = 0;
		}
		
		interval++;
	}
	
	public static void entityHitLarvaSymbiote(LivingHurtEvent event) {
		LivingEntity target = event.getEntityLiving();
		Entity attacker = event.getSource().getEntity();
		
		if (target.getItemBySlot(EquipmentSlot.HEAD).is(DreamlandItems.LARVA_HELMET.get())) {
			if (attacker instanceof LivingEntity && !(attacker instanceof LarvaEntity)) {
				((LivingEntity) attacker).addEffect(new MobEffectInstance(DreamlandEffects.ANTAGONIZED.get(), 200));
				Level level = target.level;
				if (!level.isClientSide()) {
					final LarvaEntity larva = DreamlandEntities.LARVA.get().create(level);
					
					if (!(level.getEntitiesOfClass(LarvaEntity.class, (new AABB(target.blockPosition())).inflate(16.0D, 10.0D, 16.0D)).size() > 3))
					{
						larva.setPos(target.position());
						level.addFreshEntity(larva);
					}
				}
			}
		}
		
	}
}
