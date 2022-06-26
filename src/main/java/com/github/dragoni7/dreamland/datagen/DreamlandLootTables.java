package com.github.dragoni7.dreamland.datagen;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.github.dragoni7.dreamland.util.WoodSet;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class DreamlandLootTables extends BaseLootTableProvider {
	
	public DreamlandLootTables(DataGenerator dataGeneratorIn) {
		super(dataGeneratorIn);
	}
	
	@Override
	protected void addTables() {
		
		basicBlockTable(DreamlandBlocks.BUMBLE_BLOCK.block().get(), "bumble_block");
		basicBlockTable(DreamlandBlocks.HIVE_BLOCK.block().get(), "hive_block");
		basicBlockTable(DreamlandBlocks.HIVE_GROWTH.block().get(), "hive_growth");
		basicBlockTable(DreamlandBlocks.CAVE_SLIME.block().get(), "cave_slime");
		basicBlockTable(DreamlandBlocks.HIVE_WEAVER.block().get(), "hive_weaver");
		
		basicBlockTable(DreamlandBlocks.DRIED_TAR.block().get(), "dry_tar");
		basicBlockTable(DreamlandBlocks.TAR_MUD.block().get(), "tar_mud");
		basicBlockTable(DreamlandBlocks.PACKED_TAR_MUD.block().get(), "packed_tar_mud");
		basicBlockTable(DreamlandBlocks.TAR_MUD_BRICKS.block().get(), "tar_mud_bricks");
		basicBlockTable(DreamlandBlocks.TAR_MUD_BRICK_SLAB.block().get(), "tar_mud_brick_slab");
		basicBlockTable(DreamlandBlocks.TAR_MUD_BRICK_STAIRS.block().get(), "tar_mud_brick_stairs");
		basicBlockTable(DreamlandBlocks.TAR_MUD_BRICK_WALL.block().get(), "tar_mud_brick_wall");
		shearableVegetationTable(DreamlandBlocks.TAR_BARK_LEAVES.block().get(), "tar_bark_leaves");
		basicBlockTable(DreamlandBlocks.DROUGHT_SOIL.block().get(), "drought_soil");
		basicBlockTable(DreamlandBlocks.TAR_BARK_SAPLING.block().get(), "tar_bark_sapling");
		shearableVegetationTable(DreamlandBlocks.TAR_SPROUTS.block().get(), "tar_sprouts");
		
		basicBlockTable(DreamlandBlocks.MINERAL_DIRT.block().get(), "mineral_dirt");
		grassBlockTable(DreamlandBlocks.FLOWERING_GRASS.block().get(), DreamlandBlocks.MINERAL_DIRT.item().get(), "flowering_grass");
		basicBlockTable(DreamlandBlocks.OPALINE_MARIGOLD.block().get(), "opaline_marigold");
		shearableVegetationTable(DreamlandBlocks.PINK_CRAB_GRASS.block().get(), "pink_crab_grass");
		shearableVegetationTable(DreamlandBlocks.FLOWERING_UNDERGROWTH.block().get(), "flowering_undergrowth");
		shearableVegetationTable(DreamlandBlocks.PLUM_BIRCH_LEAVES.block().get(), "plum_birch_leaves");
		basicBlockTable(DreamlandBlocks.PLUM_BIRCH_SHRUB.block().get(), "plum_birch_shrub");
		basicBlockTable(DreamlandBlocks.PLUM_BIRCH_SAPLING.block().get(), "plum_birch_sapling");
		basicBlockTable(DreamlandBlocks.OPAL_DIFFUSER_BLOCK.block().get(), "opal_diffuser");
		
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
		silkTouchTable(DreamlandBlocks.FOSSILIZED_EGG.block().get(), DreamlandBlocks.ANCIENT_EGG.item().get(), "fossilized_egg", 1, 1);
		silkTouchTable(DreamlandBlocks.OPAL_CLUSTER.block().get(), DreamlandItems.OPAL.get(), "opal_cluster", 1, 3);
	}
	
	private void createWoodSetTable(WoodSet set) {
		String name = set.getSetName();
		basicBlockTable(set.button().block().get(), name + "_button");
		basicBlockTable(set.door().block().get(), name + "_door");
		basicBlockTable(set.fence().block().get(), name + "_fence");
		basicBlockTable(set.fenceGate().block().get(), name + "_fence_gate");
		basicBlockTable(set.ladder().block().get(), name + "_ladder");
		basicBlockTable(set.log().block().get(), name + "_log");
		basicBlockTable(set.plank().block().get(), name + "_planks");
		basicBlockTable(set.pressurePlate().block().get(), name + "_pressure_plate");
		basicBlockTable(set.slab().block().get(), name + "_slab");
		basicBlockTable(set.stair().block().get(), name + "_stair");
		basicBlockTable(set.strippedLog().block().get(), name + "_stripped_log");
		basicBlockTable(set.trapDoor().block().get(), name + "_trap_door");
		basicBlockTable(set.wood().block().get(), name + "_wood");
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
	
	private void shearableVegetationTable(Block block, String name) {
		lootTables.put(block, createShearableVegetationBlockTable(name, block));
	}
}
