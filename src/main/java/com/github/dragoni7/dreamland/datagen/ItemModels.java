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
import net.minecraftforge.registries.RegistryObject;

public class ItemModels extends ItemModelProvider {

	public ItemModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
		super(generator, modid, existingFileHelper);
		
	}

	@Override
	protected void registerModels() {
		
		createBlockItemModel(DreamlandItems.HIVE_BLOCK,"block/hive_block1");
		createBlockItemModel(DreamlandItems.CLAY_SOIL,"block/clay_soil");
		createBlockItemModel(DreamlandItems.DARK_QUARTZITE,"block/dark_quartzite");
		createBlockItemModel(DreamlandItems.DUSK_ICE,"block/dusk_ice");
		createBlockItemModel(DreamlandItems.HIVE_JELLY_CLUSTER, "block/hive_jelly_cluster");
		createBlockItemModel(DreamlandItems.HIVE_MEMBRANE, "block/hive_membrane_connected");
		createBlockItemModel(DreamlandItems.HIVE_MEMBRANE_CORE, "block/hive_membrane_core");
		createBlockItemModel(DreamlandItems.HIVE_IRON, "block/hive_iron");
		createBlockItemModel(DreamlandItems.HIVE_COPPER, "block/hive_copper");
		createBlockItemModel(DreamlandItems.HIVE_GOLD, "block/hive_gold");
		createBlockItemModel(DreamlandItems.HIVE_REDSTONE, "block/hive_redstone");
		createBlockItemModel(DreamlandItems.HIVE_LAPIS, "block/hive_lapis");
		createBlockItemModel(DreamlandItems.HIVE_DIAMOND, "block/hive_diamond");
		createBlockItemModel(DreamlandItems.HIVE_BLOCK_WITH_JELLY, "block/hive_block_with_jelly");
		
		createBlockItemModel(DreamlandItems.DRIED_TAR, "block/dried_tar");
		createBlockItemModel(DreamlandItems.TAR_SOIL, "block/tar_soil");
		createBlockItemModel(DreamlandItems.DROUGHT_SOIL, "block/drought_soil");
		createBlockItemModel(DreamlandItems.TAR_BARK_LEAVES, "block/tar_bark_leaves1");
		
		createBlockItemModel(DreamlandItems.PLUM_BIRCH_LEAVES, "block/plum_birch_leaves1");
		createBlockItemModel(DreamlandItems.MINERAL_DIRT, "block/mineral_dirt");
		createBlockItemModel(DreamlandItems.FLOWERING_GRASS, "block/flowering_grass");		
		createBlockItemModel(DreamlandItems.FLOWERING_UNDERGROWTH, "block/flowering_undergrowth");
		
		createSingleTextureModel(DreamlandItems.HIVE_JELLY_ITEM, "item/hive_jelly");
		createSingleTextureModel(DreamlandItems.CAVE_SLIME, "block/cave_slime");
		createSingleTextureModel(DreamlandItems.HIVE_GROWTH, "block/hive_growth_cross");
		createSingleTextureModel(DreamlandItems.TAR_SPROUTS, "block/tar_sprouts");
		createSingleTextureModel(DreamlandItems.OPALINE_MARIGOLD, "block/opaline_marigold");
		createSingleTextureModel(DreamlandItems.PINK_CRAB_GRASS, "block/pink_crab_grass");
		
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
		createSingleTextureModel(set.getLadderItem(), "block/" + set.getSetName() + "_ladder");
		createSingleTextureModel(set.getDoorItem(), "item/" + set.getSetName() + "_door");
		createBlockItemModel(set.getTrapDoorItem(), path + "_trapdoor_bottom");
		createBlockItemModel(set.getButtonItem(), path + "_button");
		createBlockItemModel(set.getPressurePlateItem(), path + "_pressure_plate");
	}
	
	private void createSingleTextureModel(RegistryObject<Item> item, String path) {
		singleTexture(item.getId().getPath(), new ResourceLocation("item/handheld"),
				"layer0", DreamlandLoc.createLoc(path));
	}
	
	private void createBlockItemModel(RegistryObject<Item> item, String path) {
		
		withExistingParent(item.getId().getPath(), DreamlandLoc.createLoc(path));
	}

}

