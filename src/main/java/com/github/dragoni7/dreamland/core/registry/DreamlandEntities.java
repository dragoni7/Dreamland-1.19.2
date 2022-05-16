package com.github.dragoni7.dreamland.core.registry;


import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.blocks.hivecocoon.HiveCocoonContainer;
import com.github.dragoni7.dreamland.common.blocks.hivecocoon.HiveCocoonTile;
import com.github.dragoni7.dreamland.common.entities.mobs.LarvaEntity;
import com.github.dragoni7.dreamland.common.entities.projectiles.ThrownHiveJelly;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DreamlandEntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Dreamland.MODID);
	public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Dreamland.MODID);
	public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Dreamland.MODID);
	
	// MOBS
	public static final RegistryObject<EntityType<LarvaEntity>> LARVA = ENTITY_TYPES.register("larva", 
			() -> EntityType.Builder.<LarvaEntity>of(LarvaEntity::new, MobCategory.MONSTER)
			.sized(0.7F, 0.4F)
			.clientTrackingRange(10)
			.build(DreamlandLoc.createLoc("larva").toString()));
	
	public static final RegistryObject<EntityType<ThrownHiveJelly>> THROWN_HIVE_JELLY = ENTITY_TYPES.register("thrown_hive_jelly", 
			() -> EntityType.Builder.<ThrownHiveJelly>of(ThrownHiveJelly::new, MobCategory.MISC)
			.sized(0.25F, 0.25F)
			.clientTrackingRange(4)
			.updateInterval(10)
			.build(DreamlandLoc.createLoc("thrown_hive_jelly").toString()));
	
	// TILES
	public static final RegistryObject<BlockEntityType<HiveCocoonTile>> HIVE_COCOON_TILE = TILES
			.register("hive_cocoon", () -> BlockEntityType.Builder
					.of(HiveCocoonTile::new, DreamlandBlocks.HIVE_COCOON.get()).build(null));
	
	// CONTAINERS
	public static final RegistryObject<MenuType<HiveCocoonContainer>> HIVE_COCOON_CONTAINER = CONTAINERS.register("hive_cocoon", 
			() -> IForgeMenuType.create((windowId, inv, data) -> {
				BlockPos pos = data.readBlockPos();
				Level world = inv.player.getCommandSenderWorld();
				return new HiveCocoonContainer(windowId, world, pos, inv, inv.player);
			}));
}
