package com.github.dragoni7.datagen;

import com.github.dragoni7.Dreamland;
import com.github.dragoni7.common.blocks.DreamlandBlocks;
import com.github.dragoni7.common.items.DreamlandItems;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class DreamlandLanguageProvider extends LanguageProvider {

	public DreamlandLanguageProvider(DataGenerator gen, String locale) {
		super(gen, Dreamland.MODID, locale);
	}

	@Override
	protected void addTranslations() {
		add("itemGroup." + Dreamland.DreamlandTab, "Dreamland");
		
		add(DreamlandBlocks.HIVE_BLOCK.get(), "Hive Block");
		add(DreamlandBlocks.HIVE_COPPER.get(), "Hive Copper Ore");
		add(DreamlandBlocks.HIVE_DIAMOND.get(), "Hive Diamond Ore");
		add(DreamlandBlocks.HIVE_GOLD.get(), "Hive Gold Ore");
		add(DreamlandBlocks.HIVE_IRON.get(), "Hive Iron Ore");
		add(DreamlandBlocks.HIVE_LAPIS.get(), "Hive Lapis Ore");
		add(DreamlandBlocks.HIVE_REDSTONE.get(), "Hive Redstone Ore");
		add(DreamlandBlocks.HIVE_MEMBRANE.get(), "Hive Membrane");
		add(DreamlandBlocks.HIVE_JELLY.get(), "Hive Jelly");
		add(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.get(), "Hive Block With Jelly");
		
		add(DreamlandBlocks.BUMBLE_BLOCK.get(), "Bumble Block");
		add(DreamlandBlocks.CAVE_SLIME.get(), "Hive Slime");
		add(DreamlandBlocks.CAVE_SLIME_PLANT.get(), "Hive Slime Plant");
		add(DreamlandBlocks.HIVE_GROWTH.get(), "Hive Growth");
		
		add(DreamlandItems.HIVE_JELLY_ITEM.get(), "Jelly");
		
	}

}
