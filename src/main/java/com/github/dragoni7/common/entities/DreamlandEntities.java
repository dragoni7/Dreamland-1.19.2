package com.github.dragoni7.common.entities;

import java.util.List;

import org.apache.commons.compress.utils.Lists;

import com.github.dragoni7.Dreamland;
import com.github.dragoni7.util.DreamlandLoc;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DreamlandEntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Dreamland.MODID);
	public static final List<Item> SPAWN_EGGS = Lists.newArrayList();
	
	public static final RegistryObject<EntityType<LarvaEntity>> LARVA = ENTITY_TYPES.register("larva", 
			() -> EntityType.Builder.<LarvaEntity>of(LarvaEntity::new, MobCategory.CREATURE)
			.sized(0.7F, 0.4F)
			.clientTrackingRange(10)
			.build(DreamlandLoc.createLoc("larva").toString()));
	
	public static final RegistryObject<EntityType<ThrownHiveJelly>> THROWN_HIVE_JELLY = ENTITY_TYPES.register("thrown_hive_jelly", 
			() -> EntityType.Builder.<ThrownHiveJelly>of(ThrownHiveJelly::new, MobCategory.MISC)
			.sized(0.25F, 0.25F)
			.clientTrackingRange(4)
			.updateInterval(10)
			.build(DreamlandLoc.createLoc("thrown_hive_jelly").toString()));
}
