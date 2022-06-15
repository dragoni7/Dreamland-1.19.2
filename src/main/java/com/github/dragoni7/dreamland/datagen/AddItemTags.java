package com.github.dragoni7.dreamland.datagen;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.items.DreamlandItemTags;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AddItemTags extends ItemTagsProvider {
	
	public AddItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
		super(generator, blockTags, Dreamland.MODID, helper);
	}

	@Override
	protected void addTags() {

		tag(DreamlandItemTags.HIVE_ORES_ITEM)
			.add(DreamlandBlocks.HIVE_COPPER.item().get())
			.add(DreamlandBlocks.HIVE_DIAMOND.item().get())
			.add(DreamlandBlocks.HIVE_GOLD.item().get())
			.add(DreamlandBlocks.HIVE_IRON.item().get())
			.add(DreamlandBlocks.HIVE_LAPIS.item().get())
			.add(DreamlandBlocks.HIVE_REDSTONE.item().get());
		
		addCopperOreItemTags(DreamlandBlocks.HIVE_COPPER.item().get());
		addIronOreItemTags(DreamlandBlocks.HIVE_IRON.item().get());
		addGoldOreItemTags(DreamlandBlocks.HIVE_GOLD.item().get());
		addRedstoneOreItemTags(DreamlandBlocks.HIVE_REDSTONE.item().get());
		addLapisOreItemTags(DreamlandBlocks.HIVE_LAPIS.item().get());
		addDiamondOreItemTags(DreamlandBlocks.HIVE_DIAMOND.item().get());
	}
	
	private void addCopperOreItemTags(Item item) {
		tag(Tags.Items.ORES).add(item);
		tag(ItemTags.COPPER_ORES).add(item);
		tag(Tags.Items.ORES_COPPER).add(item);
	}
	
	private void addIronOreItemTags(Item item) {
		tag(Tags.Items.ORES).add(item);
		tag(ItemTags.IRON_ORES).add(item);
		tag(Tags.Items.ORES_IRON).add(item);

	}
	
	private void addGoldOreItemTags(Item item) {
		tag(Tags.Items.ORES).add(item);
		tag(ItemTags.GOLD_ORES).add(item);
		tag(Tags.Items.ORES_GOLD).add(item);

	}
	
	private void addRedstoneOreItemTags(Item item) {
		tag(Tags.Items.ORES).add(item);
		tag(ItemTags.REDSTONE_ORES).add(item);
		tag(Tags.Items.ORES_REDSTONE).add(item);

	}
	
	private void addLapisOreItemTags(Item item) {
		tag(Tags.Items.ORES).add(item);
		tag(ItemTags.LAPIS_ORES).add(item);
		tag(Tags.Items.ORES_LAPIS).add(item);

	}
	
	private void addDiamondOreItemTags(Item item) {
		tag(Tags.Items.ORES).add(item);
		tag(ItemTags.DIAMOND_ORES).add(item);
		tag(Tags.Items.ORES_DIAMOND).add(item);

	}
	
	@Override
	public String getName() {
		return "Dreamland Item Tags";
	}
}
