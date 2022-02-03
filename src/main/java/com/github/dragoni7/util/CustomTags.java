package com.github.dragoni7.util;

import com.github.dragoni7.Dreamland;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;

public class CustomTags {
	
	public static class Blocks {
		
		public static final Tags.IOptionalNamedTag<Block> HIVE_ORES_REPLACEABLE = createTag("hive_ores_replaceable");
		
		private static Tags.IOptionalNamedTag<Block> createTag(String name) {
			
			return BlockTags.createOptional(new ResourceLocation(Dreamland.MODID, name));
		}
		
		private static Tags.IOptionalNamedTag<Block> createForgeTag(String name) {
			
			return BlockTags.createOptional(new ResourceLocation("forge", name));
		}
	}
	
	public static class Items {
		
		public static final Tags.IOptionalNamedTag<Item> TEST = createForgeTag("ingots/test");
		
		private static Tags.IOptionalNamedTag<Item> createTag(String name) {
			
			return ItemTags.createOptional(new ResourceLocation(Dreamland.MODID, name));
		}
		
		private static Tags.IOptionalNamedTag<Item> createForgeTag(String name) {
			
			return ItemTags.createOptional(new ResourceLocation("forge", name));
		}
	}
	
	

}
