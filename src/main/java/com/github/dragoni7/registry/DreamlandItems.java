package com.github.dragoni7.registry;

import com.github.dragoni7.Dreamland;
import com.github.dragoni7.common.items.BaseBlockItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DreamlandItems{
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Dreamland.MODID);
	
	//Block Items
	public static final RegistryObject<Item> BUMBLE_BLOCK = ITEMS.register("bumble_block", 
			() -> new BaseBlockItem(DreamlandBlocks.BUMBLE_BLOCK.get(), new Item.Properties().tab(Dreamland.DreamWorldTab)));
	
	public static final RegistryObject<Item> DARK_QUARTZITE = ITEMS.register("dark_quartzite", 
			() -> new BaseBlockItem(DreamlandBlocks.DARK_QUARTZITE.get(), new Item.Properties().tab(Dreamland.DreamWorldTab)));
	
	public static final RegistryObject<Item> CLAY_SOIL = ITEMS.register("clay_soil", 
			() -> new BaseBlockItem(DreamlandBlocks.CLAY_SOIL.get(), new Item.Properties().tab(Dreamland.DreamWorldTab)));
	
	public static final RegistryObject<Item> CLAY_SOIL_GRASS = ITEMS.register("clay_soil_grass", 
			() -> new BaseBlockItem(DreamlandBlocks.CLAY_SOIL_GRASS.get(), new Item.Properties().tab(Dreamland.DreamWorldTab)));

	public static final RegistryObject<Item> SOLID_TAR = ITEMS.register("solid_tar", 
			() -> new BaseBlockItem(DreamlandBlocks.SOLID_TAR.get(), new Item.Properties().tab(Dreamland.DreamWorldTab)));

	public static final RegistryObject<Item> POROUS_STONE = ITEMS.register("porous_stone", 
			() -> new BaseBlockItem(DreamlandBlocks.POROUS_STONE.get(), new Item.Properties().tab(Dreamland.DreamWorldTab)));
	
	public static final RegistryObject<Item> ROOTED_POROUS_STONE = ITEMS.register("rooted_porous_stone", 
			() -> new BaseBlockItem(DreamlandBlocks.ROOTED_POROUS_STONE.get(), new Item.Properties().tab(Dreamland.DreamWorldTab)));
	
	public static final RegistryObject<Item> DUSK_ICE = ITEMS.register("dusk_ice", 
			() -> new BaseBlockItem(DreamlandBlocks.DUSK_ICE.get(), new Item.Properties().tab(Dreamland.DreamWorldTab)));
	
	public static final RegistryObject<Item> CAVE_SLIME = ITEMS.register("cave_slime", 
			() -> new BaseBlockItem(DreamlandBlocks.CAVE_SLIME.get(), new Item.Properties().tab(Dreamland.DreamWorldTab)));
	
	public static final RegistryObject<Item> CAVE_SLIME_PLANT = ITEMS.register("cave_slime_plant", 
			() -> new BaseBlockItem(DreamlandBlocks.CAVE_SLIME_PLANT.get(), new Item.Properties().tab(Dreamland.DreamWorldTab)));
	
	public static final RegistryObject<Item> TOXIC_ROCK = ITEMS.register("toxic_rock", 
			() -> new BaseBlockItem(DreamlandBlocks.TOXIC_ROCK.get(), new Item.Properties().tab(Dreamland.DreamWorldTab)));
	

}