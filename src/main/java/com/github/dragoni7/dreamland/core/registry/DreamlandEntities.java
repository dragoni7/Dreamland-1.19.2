package com.github.dragoni7.dreamland.core.registry;


import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.entities.mobs.BumbleBeastEntity;
import com.github.dragoni7.dreamland.common.entities.mobs.LarvaEntity;
import com.github.dragoni7.dreamland.common.entities.mobs.OozeEntity;
import com.github.dragoni7.dreamland.common.entities.projectiles.TarBall;
import com.github.dragoni7.dreamland.common.entities.projectiles.ThrownHiveJelly;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DreamlandEntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Dreamland.MODID);
	public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Dreamland.MODID);
	public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Dreamland.MODID);
	
	// MOBS
	public static final RegistryObject<EntityType<BumbleBeastEntity>> BUMBLE_BEAST = ENTITY_TYPES.register("bumble_beast",
			() -> EntityType.Builder.<BumbleBeastEntity>of(BumbleBeastEntity::new, MobCategory.CREATURE)
			.sized(2.0F, 4.5F)
			.clientTrackingRange(10)
			.build(DreamlandLoc.createLoc("bumble_beast").toString()));
	
	public static final RegistryObject<EntityType<LarvaEntity>> LARVA = ENTITY_TYPES.register("larva", 
			() -> EntityType.Builder.<LarvaEntity>of(LarvaEntity::new, MobCategory.MONSTER)
			.sized(0.7F, 0.4F)
			.clientTrackingRange(10)
			.build(DreamlandLoc.createLoc("larva").toString()));
	
	public static final RegistryObject<EntityType<OozeEntity>> OOZE = ENTITY_TYPES.register("ooze",
			() -> EntityType.Builder.<OozeEntity>of(OozeEntity::new, MobCategory.MONSTER)
			.sized(1.0F, 3.50F)
			.clientTrackingRange(10)
			.build(DreamlandLoc.createLoc("ooze").toString()));
	
	public static final RegistryObject<EntityType<TarBall>> TAR_BALL = ENTITY_TYPES.register("tar_ball",
			() -> EntityType.Builder.<TarBall>of(TarBall::new, MobCategory.MISC)
			.sized(0.25F, 0.25F)
			.clientTrackingRange(4)
			.updateInterval(10)
			.build(DreamlandLoc.createLoc("tar_ball").toString()));
	
	public static final RegistryObject<EntityType<ThrownHiveJelly>> THROWN_HIVE_JELLY = ENTITY_TYPES.register("thrown_hive_jelly", 
			() -> EntityType.Builder.<ThrownHiveJelly>of(ThrownHiveJelly::new, MobCategory.MISC)
			.sized(0.25F, 0.25F)
			.clientTrackingRange(4)
			.updateInterval(10)
			.build(DreamlandLoc.createLoc("thrown_hive_jelly").toString()));
	
	// TILES
	
	// CONTAINERS
}
