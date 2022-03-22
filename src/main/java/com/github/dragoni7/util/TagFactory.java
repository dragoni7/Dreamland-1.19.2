package com.github.dragoni7.util;


import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.tags.TagKey;

public class TagFactory {
	
	public static TagKey<Block> createBlockTag(String name) {
		
		return TagKey.create(Registry.BLOCK_REGISTRY, DreamlandLoc.newLoc(name));
	}
	
	public static TagKey<Block> createForgeBlockTag(String name) {
		
		return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("forge", name));
	}

	
	public static TagKey<Item> createItemTag(String name) {
		
		return TagKey.create(Registry.ITEM_REGISTRY, DreamlandLoc.newLoc(name));
	}
	
	public static TagKey<Item> createForgeItemTag(String name) {
		
		return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", name));
	}
}
