package com.github.dragoni7.dreamland.datagen;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;

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
		basicBlockTable(DreamlandBlocks.HIVE_MEMBRANE.get(), "hive_membrane");
		
		oreTable(DreamlandBlocks.HIVE_COPPER.get(), Items.RAW_COPPER, "hive_copper");
		oreTable(DreamlandBlocks.HIVE_DIAMOND.get(), Items.DIAMOND, "hive_diamond");
		oreTable(DreamlandBlocks.HIVE_GOLD.get(), Items.RAW_GOLD, "hive_gold");
		oreTable(DreamlandBlocks.HIVE_IRON.get(), Items.RAW_IRON,"hive_iron");
		gemTable(DreamlandBlocks.HIVE_LAPIS.get(), Items.LAPIS_LAZULI, "hive_lapis");
		gemTable(DreamlandBlocks.HIVE_REDSTONE.get(), Items.REDSTONE, "hive_redstone");
		
		silkTouchTable(DreamlandBlocks.HIVE_JELLY_CLUSTER.get(), DreamlandItems.HIVE_JELLY_ITEM.get(), "hive_jelly_cluster", 2, 3);
		silkTouchTable(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.get(), DreamlandItems.HIVE_JELLY_ITEM.get(), "hive_block_with_jelly", 1, 1);
	}

	private void basicBlockTable(Block block, String name) {
		lootTables.put(block, createSimpleTable(name, block));
	}
	private void oreTable(Block block, Item item, String name) {
		lootTables.put(block, createSilkTouchTable(name, block, item, 1, 1));
	}
	private void gemTable(Block block, Item item, String name) {
		lootTables.put(block, createSilkTouchTable(name, block, item, 4, 9));
	}
	private void silkTouchTable(Block block, Item item, String name, int min, int max) {
		lootTables.put(block, createSilkTouchTable(name, block, item, min, max));
	}
}
