package com.github.dragoni7.util;

import com.github.dragoni7.Dreamland;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class CustomTagUtil {
	
	public static class Blocks {
		
		public static Tags.IOptionalNamedTag<Block> createTag(String name) {
			
			return BlockTags.createOptional(new ResourceLocation(Dreamland.MODID, name));
		}
		
		public static Tags.IOptionalNamedTag<Block> createForgeTag(String name) {
			
			return BlockTags.createOptional(new ResourceLocation("forge", name));
		}
	}
	
	public static class Items {
		
		public static Tags.IOptionalNamedTag<Item> createTag(String name) {
			
			return ItemTags.createOptional(new ResourceLocation(Dreamland.MODID, name));
		}
		
		public static Tags.IOptionalNamedTag<Item> createForgeTag(String name) {
			
			return ItemTags.createOptional(new ResourceLocation("forge", name));
		}
	}
	
	

}
