package com.github.dragoni7.dreamland.data;

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
		
		basicBlockTable(DreamlandBlocks.KUNZITE_STONE.block().get(), DreamlandBlocks.COBBLED_KUNZITE_STONE.item().get(), "kunzite");
		basicBlockTable(DreamlandBlocks.COBBLED_KUNZITE_STONE.block().get(), "cobbled_kunzite");
		basicBlockTable(DreamlandBlocks.KUNZITE_BRICKS.block().get(), "kunzite_bricks");
		basicBlockTable(DreamlandBlocks.KUNZITE_BRICK_SLAB.block().get(), "kunzite_brick_slab");
		basicBlockTable(DreamlandBlocks.KUNZITE_BRICK_STAIRS.block().get(), "kunzite_brick_stairs");
		basicBlockTable(DreamlandBlocks.KUNZITE_BRICK_WALL.block().get(), "kunzite_brick_wall");
		basicBlockTable(DreamlandBlocks.COBBLED_KUNZITE_SLAB.block().get(), "cobbled_kunzite_slab");
		basicBlockTable(DreamlandBlocks.COBBLED_KUNZITE_STAIRS.block().get(), "cobbled_kunzite_stairs");
		basicBlockTable(DreamlandBlocks.COBBLED_KUNZITE_WALL.block().get(), "cobbled_kunzite_wall");
		basicBlockTable(DreamlandBlocks.KUNZITE_TILE.block().get(), "kunzite_tile");
		basicBlockTable(DreamlandBlocks.CHISELED_KUNZITE.block().get(), "chiseled_kunzite");
		basicBlockTable(DreamlandBlocks.KUNZITE_POINT.block().get(), "kunzite_point");
		basicBlockTable(DreamlandBlocks.KUNZITE_POINT_BLOCK.block().get(), "kunzite_point_block");
		basicBlockTable(DreamlandBlocks.KUNZITE_BARS.block().get(), "kunzite_bars");
		basicBlockTable(DreamlandBlocks.SMALL_GOLDEN_CAP.block().get(), "small_golden_cap");
		basicBlockTable(DreamlandBlocks.GOLDEN_MOSS_BLOCK.block().get(), "golden_moss_block");
		basicBlockTable(DreamlandBlocks.GOLDEN_MOSS_CARPET.block().get(), "golden_moss_carpet");
		basicBlockTable(DreamlandBlocks.MIDASHROOM.block().get(), "midashroom");
		basicBlockTable(DreamlandBlocks.GOLDEN_CAP.block().get(), DreamlandBlocks.SMALL_GOLDEN_CAP.item().get(), "golden_cap");
		shearableVegetationTable(DreamlandBlocks.GOLD_FRONDS.block().get(), "gold_fronds");
		silkTouchTable(DreamlandBlocks.GOLD_BEARING_QUARTZITE.block().get(), Items.GOLD_NUGGET, "gold_bearing_quartzite", 2, 6);
		oreTable(DreamlandBlocks.GOLD_CLUSTER.block().get(), Items.RAW_GOLD, "gold_cluster");
		delicateBlockTable(DreamlandBlocks.SMALL_GOLD_CLUSTER.block().get(), "small_gold_cluster");
		delicateBlockTable(DreamlandBlocks.MEDIUM_GOLD_CLUSTER.block().get(), "medium_gold_cluster");
		delicateBlockTable(DreamlandBlocks.LARGE_GOLD_CLUSTER.block().get(), "large_gold_cluster");
		oreTable(DreamlandBlocks.KUNZITE_COPPER_ORE.block().get(), Items.RAW_COPPER, "kunzite_copper");
		oreTable(DreamlandBlocks.KUNZITE_EMERALD_ORE.block().get(), Items.EMERALD, "kunzite_emerald");
		oreTable(DreamlandBlocks.KUNZITE_DIAMOND_ORE.block().get(), Items.DIAMOND, "kunzite_diamond");
		oreTable(DreamlandBlocks.KUNZITE_IRON_ORE.block().get(), Items.RAW_IRON,"kunzite_iron");
		gemTable(DreamlandBlocks.KUNZITE_LAPIS_ORE.block().get(), Items.LAPIS_LAZULI, "kunzite_lapis");
		gemTable(DreamlandBlocks.KUNZITE_REDSTONE_ORE.block().get(), Items.REDSTONE, "kunzite_redstone");
		
		basicBlockTable(DreamlandBlocks.BUMBLE_BLOCK.block().get(), "bumble_block");
		basicBlockTable(DreamlandBlocks.HIVE_BLOCK.block().get(), "hive_block");
		basicBlockTable(DreamlandBlocks.HIVE_GROWTH.block().get(), "hive_growth");
		basicBlockTable(DreamlandBlocks.CAVE_SLIME.block().get(), "cave_slime");
		basicBlockTable(DreamlandBlocks.HIVE_WEAVER.block().get(), "hive_weaver");
		silkTouchTable(DreamlandBlocks.HIVE_JELLY_CLUSTER.block().get(), DreamlandItems.HIVE_JELLY_ITEM.get(), "hive_jelly_cluster", 2, 3);
		silkTouchTable(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.block().get(), DreamlandItems.HIVE_JELLY_ITEM.get(), "hive_block_with_jelly", 1, 1);
		oreTable(DreamlandBlocks.HIVE_COPPER.block().get(), Items.RAW_COPPER, "hive_copper");
		oreTable(DreamlandBlocks.HIVE_DIAMOND.block().get(), Items.DIAMOND, "hive_diamond");
		oreTable(DreamlandBlocks.HIVE_GOLD.block().get(), Items.RAW_GOLD, "hive_gold");
		oreTable(DreamlandBlocks.HIVE_IRON.block().get(), Items.RAW_IRON,"hive_iron");
		gemTable(DreamlandBlocks.HIVE_LAPIS.block().get(), Items.LAPIS_LAZULI, "hive_lapis");
		gemTable(DreamlandBlocks.HIVE_REDSTONE.block().get(), Items.REDSTONE, "hive_redstone");
		
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
		silkTouchTable(DreamlandBlocks.FOSSILIZED_EGG.block().get(), DreamlandBlocks.ANCIENT_EGG.item().get(), "fossilized_egg", 1, 1);
		basicBlockTable(DreamlandBlocks.OOZE_BLOCK.block().get(), "ooze_block");
		
		basicBlockTable(DreamlandBlocks.MINERAL_DIRT.block().get(), "mineral_dirt");
		grassBlockTable(DreamlandBlocks.FLOWERING_GRASS.block().get(), DreamlandBlocks.MINERAL_DIRT.item().get(), "flowering_grass");
		basicBlockTable(DreamlandBlocks.OPALINE_MARIGOLD.block().get(), "opaline_marigold");
		shearableVegetationTable(DreamlandBlocks.PINK_CRAB_GRASS.block().get(), "pink_crab_grass");
		shearableVegetationTable(DreamlandBlocks.FLOWERING_UNDERGROWTH.block().get(), "flowering_undergrowth");
		shearableVegetationTable(DreamlandBlocks.PLUM_BIRCH_LEAVES.block().get(), "plum_birch_leaves");
		basicBlockTable(DreamlandBlocks.PLUM_BIRCH_SHRUB.block().get(), "plum_birch_shrub");
		basicBlockTable(DreamlandBlocks.PLUM_BIRCH_SAPLING.block().get(), "plum_birch_sapling");
		basicBlockTable(DreamlandBlocks.OPAL_DIFFUSER_BLOCK.block().get(), "opal_diffuser");
		basicBlockTable(DreamlandBlocks.OPAL_BLOCK.block().get(), "opal_block");
		basicBlockTable(DreamlandBlocks.PRECIOUS_OPAL_BLOCK.block().get(), "precious_opal_block");
		basicBlockTable(DreamlandBlocks.OPAL_TILE.block().get(), "opal_tile");
		basicBlockTable(DreamlandBlocks.OPAL_SLAB.block().get(), "opal_slab");
		basicBlockTable(DreamlandBlocks.OPAL_STAIRS.block().get(), "opal_stairs");
		basicBlockTable(DreamlandBlocks.OPAL_WALL.block().get(), "opal_wall");
		basicBlockTable(DreamlandBlocks.PRECIOUS_OPAL_TILE.block().get(), "precious_opal_tile");
		basicBlockTable(DreamlandBlocks.PRECIOUS_OPAL_SLAB.block().get(), "precious_opal_slab");
		basicBlockTable(DreamlandBlocks.PRECIOUS_OPAL_STAIRS.block().get(), "precious_opal_stairs");
		basicBlockTable(DreamlandBlocks.PRECIOUS_OPAL_WALL.block().get(), "precious_opal_wall");
		basicBlockTable(DreamlandBlocks.JEWELED_DEEPSLATE.block().get(), "jeweled_deepslate");
		silkTouchTable(DreamlandBlocks.OPAL_CLUSTER.block().get(), DreamlandItems.OPAL.get(), "opal_cluster", 1, 3);
		delicateBlockTable(DreamlandBlocks.PRECIOUS_OPAL_LAMP.block().get(), "precious_opal_lamp");
		
		basicBlockTable(DreamlandBlocks.WHITE_MOLD.block().get(), "white_mold");
		basicBlockTable(DreamlandBlocks.WHITE_MOLD_CARPET.block().get(), "white_mold_carpet");
		basicBlockTable(DreamlandBlocks.POROUS_STONE.block().get(), "porous_stone");
		basicBlockTable(DreamlandBlocks.OVERGROWN_POROUS_STONE.block().get(), "overgrown_porous_stone");
		basicBlockTable(DreamlandBlocks.PETRIFIED_VEGETATION.block().get(), "strand_stone");
		basicBlockTable(DreamlandBlocks.PURE_STONE.block().get(), "toxic_stone");
		basicBlockTable(DreamlandBlocks.BLACK_MOLD.block().get(), "black_mold");
		basicBlockTable(DreamlandBlocks.BLACK_MOLD_CARPET.block().get(), "black_mold");
		basicBlockTable(DreamlandBlocks.TOXIC_VEGETATION.block().get(), "toxic_vegetation");
		basicBlockTable(DreamlandBlocks.DECAYED_VEGETATION.block().get(), "decayed_vegetation");
		basicBlockTable(DreamlandBlocks.GLOWING_MOLD_WOOD.block().get(), "glowing_mold_wood");
		basicBlockTable(DreamlandBlocks.SPORE_NODE.block().get(), "spore_node");
		grassBlockTable(DreamlandBlocks.TOXIC_GRASS.block().get(), DreamlandBlocks.TOXIC_DIRT.item().get(), "toxic_grass");
		basicBlockTable(DreamlandBlocks.TOXIC_DIRT.block().get(), "toxic_dirt");
		basicBlockTable(DreamlandBlocks.PURIFIED_DUST.block().get(), "purified_dust");
		shearableVegetationTable(DreamlandBlocks.SPORE_PUFF.block().get(), "spore_puff");
		shearableVegetationTable(DreamlandBlocks.LARGE_SPORE_PUFF.block().get(), "large_spore_puff");
		shearableVegetationTable(DreamlandBlocks.SPONGE_PUFF.block().get(), "sponge_puff");
		shearableVegetationTable(DreamlandBlocks.SHELF_VEGETATION.block().get(), "shelf_vegetation");
		shearableVegetationTable(DreamlandBlocks.GLOW_FRONDS.block().get(), "glow_fronds");
		
		createWoodSetTable(DreamlandWoodSets.TAR_BARK);
		createWoodSetTable(DreamlandWoodSets.PLUM_BIRCH);
		createWoodSetTable(DreamlandWoodSets.MOLD_WOOD);
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
		basicBlockTable(set.strippedLog().block().get(), "stripped_" + name + "_log");
		basicBlockTable(set.trapDoor().block().get(), name + "_trap_door");
		basicBlockTable(set.wood().block().get(), name + "_wood");
		basicBlockTable(set.strippedWood().block().get(), "stripped_" + name + "_wood");
	}

	private void basicBlockTable(Block block, String name) {
		lootTables.put(block, createSimpleBlockTable(name, block));
	}
	
	private void basicBlockTable(Block block1, Block block2, String name) {
		lootTables.put(block1, createSimpleBlockTable(name, block2));
	}
	
	private void basicBlockTable(Block block, Item item, String name) {
		lootTables.put(block, createSimpleItemTable(name, item));
	}
	
	private void delicateBlockTable(Block block, String name) {
		lootTables.put(block, createDelicateBlockTable(name, block));
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
