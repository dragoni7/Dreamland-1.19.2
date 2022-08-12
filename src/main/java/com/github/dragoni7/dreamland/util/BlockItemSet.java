package com.github.dragoni7.dreamland.util;

import java.util.function.Supplier;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class BlockItemSet {
	
	private RegistryObject<Block> block;
	private RegistryObject<Item> item;
	
	public BlockItemSet(String name, Supplier<? extends Block> block) {
		this.block = DreamlandBlocks.BLOCKS.register(name, block);
		item = DreamlandItems.ITEMS.register(name, () -> new BlockItem(this.block.get(), new Item.Properties().tab(Dreamland.DreamlandTab)));
	}

	public RegistryObject<Block> block() {
		return block;
	}
	
	public RegistryObject<Item> item() {
		return item;
	}

}
