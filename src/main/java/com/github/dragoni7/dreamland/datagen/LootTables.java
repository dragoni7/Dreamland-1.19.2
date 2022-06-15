package com.github.dragoni7.dreamland.datagen;

import com.github.dragoni7.dreamland.core.WoodSet;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;

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
		
		basicBlockTable(DreamlandBlocks.BUMBLE_BLOCK.block().get(), "bumble_block");
		basicBlockTable(DreamlandBlocks.HIVE_BLOCK.block().get(), "hive_block");
		basicBlockTable(DreamlandBlocks.HIVE_GROWTH.block().get(), "hive_growth");
		basicBlockTable(DreamlandBlocks.CAVE_SLIME.block().get(), "cave_slime");
		basicBlockTable(DreamlandBlocks.HIVE_MEMBRANE_CORE.block().get(), "hive_membrane_core");
		
		basicBlockTable(DreamlandBlocks.DRIED_TAR.block().get(), "dry_tar");
		basicBlockTable(DreamlandBlocks.TAR_SOIL.block().get(), "tar_soil");
		basicBlockTable(DreamlandBlocks.DROUGHT_SOIL.block().get(), "drought_soil");
		basicBlockTable(DreamlandBlocks.TAR_SPROUTS.block().get(), "tar_sprouts");
		
		basicBlockTable(DreamlandBlocks.MINERAL_DIRT.block().get(), "mineral_dirt");
		grassBlockTable(DreamlandBlocks.FLOWERING_GRASS.block().get(), DreamlandBlocks.MINERAL_DIRT.item().get(), "flowering_grass");
		basicBlockTable(DreamlandBlocks.OPALINE_MARIGOLD.block().get(), "opaline_marigold");
		basicBlockTable(DreamlandBlocks.PINK_CRAB_GRASS.block().get(), "pink_crab_grass");
		basicBlockTable(DreamlandBlocks.FLOWERING_UNDERGROWTH.block().get(), "flowering_undergrowth");
		
		createWoodSetTable(DreamlandWoodSets.TAR_BARK);
		createWoodSetTable(DreamlandWoodSets.PLUM_BIRCH);
		
		oreTable(DreamlandBlocks.HIVE_COPPER.block().get(), Items.RAW_COPPER, "hive_copper");
		oreTable(DreamlandBlocks.HIVE_DIAMOND.block().get(), Items.DIAMOND, "hive_diamond");
		oreTable(DreamlandBlocks.HIVE_GOLD.block().get(), Items.RAW_GOLD, "hive_gold");
		oreTable(DreamlandBlocks.HIVE_IRON.block().get(), Items.RAW_IRON,"hive_iron");
		gemTable(DreamlandBlocks.HIVE_LAPIS.block().get(), Items.LAPIS_LAZULI, "hive_lapis");
		gemTable(DreamlandBlocks.HIVE_REDSTONE.block().get(), Items.REDSTONE, "hive_redstone");
		
		silkTouchTable(DreamlandBlocks.HIVE_JELLY_CLUSTER.block().get(), DreamlandItems.HIVE_JELLY_ITEM.get(), "hive_jelly_cluster", 2, 3);
		silkTouchTable(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.block().get(), DreamlandItems.HIVE_JELLY_ITEM.get(), "hive_block_with_jelly", 1, 1);
	}
	
	private void createWoodSetTable(WoodSet set) {
		String name = set.getSetName();
		basicBlockTable(set.getButton().get(), name + "_button");
		basicBlockTable(set.getDoor().get(), name + "_door");
		basicBlockTable(set.getFence().get(), name + "_fence");
		basicBlockTable(set.getFenceGate().get(), name + "_fence_gate");
		basicBlockTable(set.getLadder().get(), name + "_ladder");
		basicBlockTable(set.getLog().get(), name + "_log");
		basicBlockTable(set.getPlank().get(), name + "_planks");
		basicBlockTable(set.getPressurePlate().get(), name + "_pressure_plate");
		basicBlockTable(set.getSlab().get(), name + "_slab");
		basicBlockTable(set.getStair().get(), name + "_stair");
		basicBlockTable(set.getStrippedLog().get(), name + "_stripped_log");
		basicBlockTable(set.getTrapDoor().get(), name + "_trap_door");
		basicBlockTable(set.getWood().get(), name + "_wood");
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
	
	private void grassBlockTable(Block block, Item item, String name) {
		lootTables.put(block, createGrassBlockTable(name, block, item));
	}
}
