package com.github.dragoni7.dreamland.datagen;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ItemModels extends ItemModelProvider{

	public ItemModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
		super(generator, modid, existingFileHelper);
		
	}

	@Override
	protected void registerModels() {
		
		createBlockItemModel(DreamlandItems.HIVE_BLOCK.get(),"block/hive_block1");
		createBlockItemModel(DreamlandItems.CLAY_SOIL.get(),"block/clay_soil");
		createBlockItemModel(DreamlandItems.DARK_QUARTZITE.get(),"block/dark_quartzite");
		createBlockItemModel(DreamlandItems.DUSK_ICE.get(),"block/dusk_ice");
		createBlockItemModel(DreamlandItems.HIVE_JELLY_CLUSTER.get(), "block/hive_jelly_cluster");
		createBlockItemModel(DreamlandItems.HIVE_MEMBRANE.get(), "block/hive_membrane");
		createBlockItemModel(DreamlandItems.HIVE_IRON.get(), "block/hive_iron");
		createBlockItemModel(DreamlandItems.HIVE_COPPER.get(), "block/hive_copper");
		createBlockItemModel(DreamlandItems.HIVE_GOLD.get(), "block/hive_gold");
		createBlockItemModel(DreamlandItems.HIVE_REDSTONE.get(), "block/hive_redstone");
		createBlockItemModel(DreamlandItems.HIVE_LAPIS.get(), "block/hive_lapis");
		createBlockItemModel(DreamlandItems.HIVE_DIAMOND.get(), "block/hive_diamond");
		createBlockItemModel(DreamlandItems.HIVE_BLOCK_WITH_JELLY.get(), "block/hive_block_with_jelly");
		createBlockItemModel(DreamlandItems.HIVE_COCOON.get(), "block/hive_cocoon");
		
		createBlockItemModel(DreamlandItems.DRIED_TAR.get(), "block/dried_tar");
		createBlockItemModel(DreamlandItems.TAR_SOIL.get(), "block/tar_soil");
		createBlockItemModel(DreamlandItems.DROUGHT_SOIL.get(), "block/drought_soil");
		createBlockItemModel(DreamlandItems.TAR_BARK_LOG.get(), "block/tar_bark_log");
		createBlockItemModel(DreamlandItems.TAR_BARK_LEAVES.get(), "block/tar_bark_leaves");
		createBlockItemModel(DreamlandItems.STRIPPED_TAR_BARK_LOG.get(), "block/stripped_tar_bark_log");
		
		createBlockItemModel(DreamlandWoodSets.PLUM_BIRCH.getLogItem(), "block/plum_birch_log");
		createBlockItemModel(DreamlandWoodSets.PLUM_BIRCH.getStrippedLogItem(), "block/stripped_plum_birch_log");
		createBlockItemModel(DreamlandWoodSets.PLUM_BIRCH.getPlankItem(), "block/plum_birch_planks");
		createBlockItemModel(DreamlandItems.PLUM_BIRCH_LEAVES.get(), "block/plum_birch_leaves");
		createBlockItemModel(DreamlandItems.MINERAL_DIRT.get(), "block/mineral_dirt");
		createBlockItemModel(DreamlandItems.FLOWERING_UNDERGROWTH.get(), "block/flowering_undergrowth");
		
		createSingleTextureModel(DreamlandItems.HIVE_JELLY_ITEM, "item/hive_jelly");
		createSingleTextureModel(DreamlandItems.CAVE_SLIME, "block/cave_slime");
		createSingleTextureModel(DreamlandItems.HIVE_GROWTH, "block/hive_growth_cross");
		createSingleTextureModel(DreamlandItems.TAR_SPROUTS, "block/tar_sprouts");
	}
	
	private void createSingleTextureModel(RegistryObject<Item> item, String path) {
		singleTexture(item.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"),
				"layer0", DreamlandLoc.createLoc(path));
	}
	
	private void createBlockItemModel(Item item, String path) {
		
		withExistingParent(item.getRegistryName().getPath(), DreamlandLoc.createLoc(path));
	}

}

