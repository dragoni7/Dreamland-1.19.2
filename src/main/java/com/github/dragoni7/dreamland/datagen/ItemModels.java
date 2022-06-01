package com.github.dragoni7.dreamland.datagen;

import com.github.dragoni7.dreamland.core.WoodSet;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

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
		createBlockItemModel(DreamlandItems.TAR_BARK_LEAVES.get(), "block/tar_bark_leaves1");
		
		createBlockItemModel(DreamlandItems.PLUM_BIRCH_LEAVES.get(), "block/plum_birch_leaves1");
		createBlockItemModel(DreamlandItems.MINERAL_DIRT.get(), "block/mineral_dirt");
		createBlockItemModel(DreamlandItems.FLOWERING_UNDERGROWTH.get(), "block/flowering_undergrowth");
		
		createSingleTextureModel(DreamlandItems.HIVE_JELLY_ITEM.get(), "item/hive_jelly");
		createSingleTextureModel(DreamlandItems.CAVE_SLIME.get(), "block/cave_slime");
		createSingleTextureModel(DreamlandItems.HIVE_GROWTH.get(), "block/hive_growth_cross");
		createSingleTextureModel(DreamlandItems.TAR_SPROUTS.get(), "block/tar_sprouts");
		createSingleTextureModel(DreamlandItems.OPALINE_MARIGOLD.get(), "block/opaline_marigold");
		createSingleTextureModel(DreamlandItems.PINK_CRAB_GRASS.get(), "block/pink_crab_grass");
		
		registerWoodSet(DreamlandWoodSets.PLUM_BIRCH);
		registerWoodSet(DreamlandWoodSets.TAR_BARK);
	}
	
	private void registerWoodSet(WoodSet set) {
		String path = "block/" + set.getSetName();
		createBlockItemModel(set.getLogItem(), path + "_log");
		createBlockItemModel(set.getStrippedLogItem(), path + "_stripped_log");
		createBlockItemModel(set.getWoodItem(), path + "_wood");
		createBlockItemModel(set.getPlankItem(), path + "_planks");
		createBlockItemModel(set.getStairItem(), path + "_stairs");
		createBlockItemModel(set.getSlabItem(), path + "_slab");
		createBlockItemModel(set.getFenceItem(), path + "_fence_side");
		createBlockItemModel(set.getFenceGateItem(), path + "_fence_gate");
		createSingleTextureModel(set.getDoorItem(), "item/" + set.getSetName() + "_door");
		createBlockItemModel(set.getTrapDoorItem(), path + "_trapdoor_bottom");
		createBlockItemModel(set.getButtonItem(), path + "_button");
		createBlockItemModel(set.getPressurePlateItem(), path + "_pressure_plate");
	}
	
	private void createSingleTextureModel(Item item, String path) {
		singleTexture(item.getRegistryName().getPath(), new ResourceLocation("item/handheld"),
				"layer0", DreamlandLoc.createLoc(path));
	}
	
	private void createBlockItemModel(Item item, String path) {
		
		withExistingParent(item.getRegistryName().getPath(), DreamlandLoc.createLoc(path));
	}

}

