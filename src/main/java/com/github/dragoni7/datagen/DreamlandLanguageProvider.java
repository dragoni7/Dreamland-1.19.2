package com.github.dragoni7.datagen;

import com.github.dragoni7.Dreamland;
import com.github.dragoni7.registry.DreamlandBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class DreamlandLanguageProvider extends LanguageProvider{

	public DreamlandLanguageProvider(DataGenerator gen, String locale) {
		super(gen, Dreamland.MODID, locale);
	}

	@Override
	protected void addTranslations() {
		add("itemGroup." + Dreamland.DreamlandTab, "Dreamland");
		
		add(DreamlandBlocks.HIVE_BLOCK.get(), "Hive block");
		add(DreamlandBlocks.HIVE_COPPER.get(), "Hive copper ore");
		add(DreamlandBlocks.HIVE_DIAMOND.get(), "Hive diamond ore");
		add(DreamlandBlocks.HIVE_GOLD.get(), "Hive gold ore");
		add(DreamlandBlocks.HIVE_IRON.get(), "Hive iron ore");
		add(DreamlandBlocks.HIVE_LAPIS.get(), "Hive lapis ore");
		add(DreamlandBlocks.HIVE_REDSTONE.get(), "Hive redstone ore");
		add(DreamlandBlocks.HIVE_SLUDGE.get(), "Hive sludge");
		add(DreamlandBlocks.HIVE_JELLY.get(), "Hive jelly");
		
		add(DreamlandBlocks.BUMBLE_BLOCK.get(), "Bumble block");
		add(DreamlandBlocks.CAVE_SLIME.get(), "Cave slime");
		add(DreamlandBlocks.CAVE_SLIME_PLANT.get(), "Cave slime plant");
		add(DreamlandBlocks.WHITE_MOLD.get(), "White mold");
	}

}
