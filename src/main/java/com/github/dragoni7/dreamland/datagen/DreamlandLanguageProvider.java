package com.github.dragoni7.dreamland.datagen;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.core.WoodSet;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class DreamlandLanguageProvider extends LanguageProvider {

	public DreamlandLanguageProvider(DataGenerator gen, String locale) {
		super(gen, Dreamland.MODID, locale);
	}

	@Override
	protected void addTranslations() {
		add("itemGroup." + Dreamland.MODID, "Dreamland");
		
		// Block
		add(DreamlandBlocks.BUMBLE_BLOCK.block().get(), "Bumble Block");
		
		add(DreamlandBlocks.HIVE_BLOCK.block().get(), "Hive Block");
		add(DreamlandBlocks.HIVE_COPPER.block().get(), "Hive Copper Ore");
		add(DreamlandBlocks.HIVE_DIAMOND.block().get(), "Hive Diamond Ore");
		add(DreamlandBlocks.HIVE_GOLD.block().get(), "Hive Gold Ore");
		add(DreamlandBlocks.HIVE_IRON.block().get(), "Hive Iron Ore");
		add(DreamlandBlocks.HIVE_LAPIS.block().get(), "Hive Lapis Ore");
		add(DreamlandBlocks.HIVE_REDSTONE.block().get(), "Hive Redstone Ore");
		add(DreamlandBlocks.HIVE_MEMBRANE.block().get(), "Hive Membrane");
		add(DreamlandBlocks.HIVE_WEAVER.block().get(), "Hive Weaver");
		add(DreamlandBlocks.HIVE_JELLY_CLUSTER.block().get(), "Hive Jelly Cluster");
		add(DreamlandBlocks.INFESTED_HIVE_JELLY_CLUSTER.block().get(), "Hive Jelly Cluster");
		add(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.block().get(), "Hive Block With Jelly");
		add(DreamlandBlocks.CAVE_SLIME.block().get(), "Hive Slime");
		add(DreamlandBlocks.CAVE_SLIME_PLANT.get(), "Hive Slime Plant");
		add(DreamlandBlocks.HIVE_GROWTH.block().get(), "Hive Growth");
		add(DreamlandBlocks.JELLY_SPLOTCH.get(), "Jelly Splotch");
		
		add(DreamlandBlocks.DRIED_TAR.block().get(), "Dried Tar");
		add(DreamlandBlocks.TAR_MUD.block().get(), "Tar Mud");
		add(DreamlandBlocks.DROUGHT_SOIL.block().get(), "Drought Soil");
		add(DreamlandFluids.TAR_BLOCK.get(), "Tar");
		add(DreamlandBlocks.TAR_BARK_SAPLING.block().get(), "Tar Bark Sapling");
		add(DreamlandBlocks.TAR_SPROUTS.block().get(), "Tar Sprouts");
		add(DreamlandBlocks.TAR_BARK_LEAVES.block().get(), "Tar Bark Leaves");
		translateWoodSet(DreamlandWoodSets.TAR_BARK, "Tar Bark");
		
		add(DreamlandBlocks.MINERAL_DIRT.block().get(), "Mineral Dirt");
		add(DreamlandBlocks.FLOWERING_GRASS.block().get(), "Flowering Undergrowth");
		add(DreamlandBlocks.PLUM_BIRCH_LEAVES.block().get(), "Plum Birch Leaves");
		add(DreamlandBlocks.PINK_CRAB_GRASS.block().get(), "Pink Crab Grass");
		add(DreamlandBlocks.OPALINE_MARIGOLD.block().get(), "Opaline Marigold");
		add(DreamlandBlocks.PLUM_BIRCH_SAPLING.block().get(), "Plum Birch Sapling");
		translateWoodSet(DreamlandWoodSets.PLUM_BIRCH, "Plum Birch");
		
		// Items
		add(DreamlandItems.HIVE_JELLY_ITEM.get(), "Hive Jelly");
		add(DreamlandItems.TAR_BUCKET.get(), "Bucket of Tar");
		
		// Entities
		add(DreamlandEntities.LARVA.get(), "Larva");
		add(DreamlandEntities.THROWN_HIVE_JELLY.get(), "Thrown Hive Jelly");
		add(DreamlandEntities.OOZE.get(), "Ooze");
		add(DreamlandEntities.TAR_BALL.get(), "Tar Ball");
		
	}
	
	private void translateWoodSet(WoodSet set, String name) {
		add(set.getButtonItem().get(), name + " Button");
		add(set.getDoor().get(), name + " Door");
		add(set.getFenceGate().get(), name + " Fence Gate");
		add(set.getFence().get(), name + " Fence");
		add(set.getLadder().get(), name + " Ladder");
		add(set.getLog().get(), name + " Log");
		add(set.getPlank().get(), name + " Planks");
		add(set.getPressurePlate().get(), name + " Pressure Plate");
		add(set.getSlab().get(), name + " Slab");
		add(set.getStair().get(), name + " Stairs");
		add(set.getStrippedLog().get(), "Stripped" + name + " Log");
		add(set.getTrapDoor().get(), name + " Trap Door");
		add(set.getWood().get(), name + " Wood");
	}

}
