package com.github.dragoni7.registry;

import com.github.dragoni7.Dreamland;
import com.github.dragoni7.common.items.*;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DreamlandItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Dreamland.MODID);
		
	//Block Items
	public static final RegistryObject<Item> BUMBLE_BLOCK = registerBlockItem("bumble_block", DreamlandBlocks.BUMBLE_BLOCK);
	
	public static final RegistryObject<Item> DARK_QUARTZITE = registerBlockItem("dark_quartzite", DreamlandBlocks.DARK_QUARTZITE);
	
	public static final RegistryObject<Item> CLAY_SOIL = registerBlockItem("clay_soil", DreamlandBlocks.CLAY_SOIL);
	
	public static final RegistryObject<Item> CLAY_SOIL_GRASS = registerBlockItem("clay_soil_grass", DreamlandBlocks.CLAY_SOIL_GRASS);

	public static final RegistryObject<Item> SOLID_TAR = registerBlockItem("solid_tar", DreamlandBlocks.SOLID_TAR);

	public static final RegistryObject<Item> POROUS_STONE = registerBlockItem("porous_stone", DreamlandBlocks.POROUS_STONE);
	
	public static final RegistryObject<Item> ROOTED_POROUS_STONE = registerBlockItem("rooted_porous_stone", DreamlandBlocks.ROOTED_POROUS_STONE);
	
	public static final RegistryObject<Item> DUSK_ICE = registerBlockItem("dusk_ice", DreamlandBlocks.DUSK_ICE);
	
	public static final RegistryObject<Item> CAVE_SLIME = registerBlockItem("cave_slime", DreamlandBlocks.CAVE_SLIME);
	
	public static final RegistryObject<Item> TOXIC_ROCK = registerBlockItem("toxic_rock", DreamlandBlocks.TOXIC_ROCK);
	
	public static final RegistryObject<Item> HIVE_BLOCK = registerBlockItem("hive_block", DreamlandBlocks.HIVE_BLOCK);
	
	public static final RegistryObject<Item> HIVE_JELLY = registerBlockItem("hive_jelly", DreamlandBlocks.HIVE_JELLY);
	
	public static final RegistryObject<Item> HIVE_SLUDGE = registerBlockItem("hive_sludge", DreamlandBlocks.HIVE_SLUDGE);
	
	public static final RegistryObject<Item> HIVE_BLOCK_WITH_JELLY = registerBlockItem("hive_block_with_jelly", DreamlandBlocks.HIVE_BLOCK_WITH_JELLY);
	
	public static final RegistryObject<Item> WHITE_MOLD = registerBlockItem("white_mold", DreamlandBlocks.WHITE_MOLD);
	
	public static final RegistryObject<Item> HIVE_IRON = registerBlockItem("hive_iron", DreamlandBlocks.HIVE_IRON);
	public static final RegistryObject<Item> HIVE_GOLD = registerBlockItem("hive_gold", DreamlandBlocks.HIVE_GOLD);
	public static final RegistryObject<Item> HIVE_COPPER = registerBlockItem("hive_copper", DreamlandBlocks.HIVE_COPPER);
	public static final RegistryObject<Item> HIVE_REDSTONE = registerBlockItem("hive_redstone", DreamlandBlocks.HIVE_REDSTONE);
	public static final RegistryObject<Item> HIVE_LAPIS = registerBlockItem("hive_lapis", DreamlandBlocks.HIVE_LAPIS);
	public static final RegistryObject<Item> HIVE_DIAMOND = registerBlockItem("hive_diamond", DreamlandBlocks.HIVE_DIAMOND);
	
	//Items
	
	public static final RegistryObject<Item> HIVE_JELLY_ITEM = registerBasicItem("jelly");
	
	
	
	
	private static RegistryObject<Item> registerBlockItem(String name, RegistryObject<Block> block) {
		
		return ITEMS.register(name,() -> new BaseBlockItem(block.get(), new Item.Properties().tab(Dreamland.DreamlandTab)));
		
	}
	
	private static RegistryObject<Item> registerBasicItem(String name) {
		
		return ITEMS.register(name, () -> new BaseItem(new Item.Properties().tab(Dreamland.DreamlandTab)));
	}
	

}