package com.github.dragoni7.dreamland.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;

public class TagCreator {
	
	public static TagKey<Block> dreamlandBlockTag(String name) {
		return BlockTags.create(DreamlandLoc.createLoc(name));
	}
	
	public static TagKey<Block> forgeBlockTag(String name) {
		return BlockTags.create(new ResourceLocation("forge", name));
	}

	
	public static TagKey<Item> dreamlandItemTag(String name) {
		return ItemTags.create(DreamlandLoc.createLoc(name));
	}
	
	public static TagKey<Item> forgeItemTag(String name) {
		return ItemTags.create(new ResourceLocation("forge", name));
	}
	
	public static TagKey<Fluid> dreamlandFluidTag(String name) {
		return FluidTags.create(DreamlandLoc.createLoc(name));
	}
	
	public static TagKey<Fluid> forgeFluidTag(String name) {
		return FluidTags.create(new ResourceLocation("forge", name));
	}
}
