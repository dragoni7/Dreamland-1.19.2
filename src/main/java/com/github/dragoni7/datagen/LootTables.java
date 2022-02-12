package com.github.dragoni7.datagen;

import com.github.dragoni7.registry.DreamlandBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class LootTables extends BaseLootTableProvider {
	
	public LootTables(DataGenerator dataGeneratorIn) {
		super(dataGeneratorIn);
	}
	
	@Override
	protected void addTables() {
		basicBlockTable(DreamlandBlocks.HIVE_BLOCK.get(), "hive_block");
		basicBlockTable(DreamlandBlocks.BUMBLE_BLOCK.get(), "bumble_block");
		
		oreTable(DreamlandBlocks.HIVE_COPPER.get(), Items.RAW_COPPER, "hive_copper");
		oreTable(DreamlandBlocks.HIVE_DIAMOND.get(), Items.DIAMOND, "hive_diamond");
		oreTable(DreamlandBlocks.HIVE_GOLD.get(), Items.RAW_GOLD, "hive_gold");
		oreTable(DreamlandBlocks.HIVE_IRON.get(), Items.RAW_IRON,"hive_iron");
		oreTable(DreamlandBlocks.HIVE_LAPIS.get(), Items.LAPIS_LAZULI, "hive_lapis");
		oreTable(DreamlandBlocks.HIVE_REDSTONE.get(), Items.REDSTONE, "hive_redstone");
	}

	private void basicBlockTable(Block block, String name) {
		lootTables.put(block, createSimpleTable(name, block));
	}
	private void oreTable(Block block, Item item, String name) {
		lootTables.put(block, createSilkTouchTable(name, block, item, 1, 3));
	}
}
