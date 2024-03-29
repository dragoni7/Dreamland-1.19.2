package com.github.dragoni7.dreamland.core.event;


import java.util.List;

import com.github.dragoni7.dreamland.Config;
import com.github.dragoni7.dreamland.common.entities.mobs.BumbleBeastEntity;
import com.github.dragoni7.dreamland.common.entities.mobs.LarvaEntity;
import com.github.dragoni7.dreamland.common.entities.mobs.OozeEntity;
import com.github.dragoni7.dreamland.common.entities.mobs.OpalShellEntity;
import com.github.dragoni7.dreamland.common.world.biome.BiomeKeys;
import com.github.dragoni7.dreamland.core.registry.DreamlandEffects;
import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;
import com.github.dragoni7.dreamland.data.DreamlandItemTags;
import com.github.dragoni7.dreamland.network.Networking;
import com.github.dragoni7.dreamland.network.PacketApplyTarred;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class DreamlandEventHandler {

	public static void init(IEventBus modBus, IEventBus forgeBus) {
		
		modBus.addListener(DreamlandEventHandler::addAttributes);
		forgeBus.addListener(DreamlandEventHandler::updateTarredEffect);
		forgeBus.addListener(DreamlandEventHandler::updateTarredEffectPlayer);
		forgeBus.addListener(DreamlandEventHandler::setLarvaTarget);
		forgeBus.addListener(DreamlandEventHandler::entityHitLarvaSymbiote);
		forgeBus.addListener(DreamlandEventHandler::onLarvaAttacked);
		forgeBus.addListener(DreamlandEventHandler::toxicJunglePreventHeal);
		forgeBus.addListener(DreamlandEventHandler::necratheneArmorDamageReduction);
	}
		
	public static void addAttributes(EntityAttributeCreationEvent event) {
		
		SpawnPlacements.register(DreamlandEntities.BUMBLE_BEAST.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BumbleBeastEntity::checkBumbleBeastSpawnRules);
		SpawnPlacements.register(DreamlandEntities.LARVA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, LarvaEntity::checkLarvaSpawnRules);
		SpawnPlacements.register(DreamlandEntities.OOZE.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, OozeEntity::checkOozeSpawnRules);
		SpawnPlacements.register(DreamlandEntities.OPAL_SHELL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, OpalShellEntity::checkOpalShellSpawnRules);
		event.put(DreamlandEntities.BUMBLE_BEAST.get(), BumbleBeastEntity.customAttributes().build());
		event.put(DreamlandEntities.LARVA.get(), LarvaEntity.customAttributes().build());
		event.put(DreamlandEntities.OOZE.get(), OozeEntity.customAttributes().build());
		event.put(DreamlandEntities.OPAL_SHELL.get(), OpalShellEntity.customAttributes().build());
	}
	
	public static void updateTarredEffect(LivingEvent.LivingTickEvent event) {
		LivingEntity entity = event.getEntity();
		if (entity.isInFluidType(DreamlandFluids.TAR_FLUID_TYPE.get())) {
			Vec3 motion = entity.getDeltaMovement();
			if (motion.x != 0 || motion.z != 0) {
				if (entity instanceof Player) {
					return;
				} else if (entity.isAlive() && entity.getLevel().isClientSide()) {
					Networking.sendToServer(new PacketApplyTarred(entity.getId()));
				}
			}
		}
	}
	
	public static void updateTarredEffectPlayer(PlayerTickEvent event) {
		Player player = event.player;
		if (player.isInFluidType(DreamlandFluids.TAR_FLUID_TYPE.get())) {
			Vec3 motion = player.getDeltaMovement();
			if (motion.x != 0 || motion.z != 0) {
				if (event.side.isClient()) {
					Networking.sendToServer(new PacketApplyTarred(player.getId()));
				}
			}
		}
	}
	
	public static void onLarvaAttacked(LivingHurtEvent event) {
		LivingEntity target = event.getEntity();
		Entity attacker = event.getSource().getEntity();
		
		if (attacker instanceof LivingEntity && target instanceof LarvaEntity && !(attacker instanceof LarvaEntity)) {
			((LivingEntity) attacker).addEffect(new MobEffectInstance(DreamlandEffects.ANTAGONIZED.get(), Config.ANTAGONIZED_DURATION.get()));
		}
	}
	
	public static void setLarvaTarget(LivingTickEvent event) {
		int i = 20;
		if (i == 20) {
			LivingEntity entity = event.getEntity();
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
			
			i = 0;
		}
		
		i++;
	}
	
	public static void entityHitLarvaSymbiote(LivingHurtEvent event) {
		LivingEntity target = event.getEntity();
		Entity attacker = event.getSource().getEntity();
		
		if (target.getItemBySlot(EquipmentSlot.HEAD).is(DreamlandItems.LARVA_HELMET.get())) {
			if (attacker instanceof LivingEntity && !(attacker instanceof LarvaEntity)) {
				((LivingEntity) attacker).addEffect(new MobEffectInstance(DreamlandEffects.ANTAGONIZED.get(), Config.ANTAGONIZED_DURATION.get()));
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
	
	public static void necratheneArmorDamageReduction(LivingHurtEvent event) {
		LivingEntity entity = event.getEntity();
		if (entity.getItemBySlot(EquipmentSlot.HEAD).is(DreamlandItems.NECRATHENE_BREATHER_HELMET.get()) && entity.getItemBySlot(EquipmentSlot.CHEST).is(DreamlandItems.NECRATHENE_CHESTPLATE.get()) && entity.getItemBySlot(EquipmentSlot.LEGS).is(DreamlandItems.NECRATHENE_LEGGINGS.get()) && entity.getItemBySlot(EquipmentSlot.FEET).is(DreamlandItems.NECRATHENE_BOOTS.get())) {
			if (entity.getHealth() <= event.getAmount()) {
				if (entity instanceof Player) {
					int foodLevel = ((Player) entity).getFoodData().getFoodLevel();
					if (foodLevel > 0) {
						((Player)entity).causeFoodExhaustion(20.0F);
						event.setCanceled(true);
					}
				}
			}
		}
	}
	
	public static void toxicJunglePreventHeal(LivingHealEvent event) {
		LivingEntity entity = event.getEntity();
		if (entity instanceof Player) {
			ItemStack helmet = entity.getItemBySlot(EquipmentSlot.HEAD).copy();
			if (!helmet.is(DreamlandItemTags.PREVENTS_DECAY)) {
				BlockPos pos = entity.blockPosition();
				if (entity.getLevel().getBiome(pos).is(BiomeKeys.TOXIC_JUNGLE) && pos.getY() > 0) {
					entity.addEffect((new MobEffectInstance(DreamlandEffects.DECAY.get(), 100)));
					event.setCanceled(true);
				}
			}
		}
	}
}
