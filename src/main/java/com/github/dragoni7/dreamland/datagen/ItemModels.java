package com.github.dragoni7.dreamland.datagen;

import com.github.dragoni7.dreamland.core.WoodSet;
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

public class ItemModels extends ItemModelProvider {

	public ItemModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
		super(generator, modid, existingFileHelper);
		
	}

	@Override
	protected void registerModels() {
		
		createBlockItemModel(DreamlandBlocks.HIVE_BLOCK.item(),"block/hive_block1");
		createBlockItemModel(DreamlandBlocks.CLAY_SOIL.item(),"block/clay_soil");
		createBlockItemModel(DreamlandBlocks.DARK_QUARTZITE.item(),"block/dark_quartzite");
		createBlockItemModel(DreamlandBlocks.DUSK_ICE.item(),"block/dusk_ice");
		createBlockItemModel(DreamlandBlocks.HIVE_JELLY_CLUSTER.item(), "block/hive_jelly_cluster");
		createBlockItemModel(DreamlandBlocks.HIVE_MEMBRANE.item(), "block/hive_membrane_connected");
		createBlockItemModel(DreamlandBlocks.HIVE_MEMBRANE_CORE.item(), "block/hive_membrane_core");
		createBlockItemModel(DreamlandBlocks.HIVE_IRON.item(), "block/hive_iron");
		createBlockItemModel(DreamlandBlocks.HIVE_COPPER.item(), "block/hive_copper");
		createBlockItemModel(DreamlandBlocks.HIVE_GOLD.item(), "block/hive_gold");
		createBlockItemModel(DreamlandBlocks.HIVE_REDSTONE.item(), "block/hive_redstone");
		createBlockItemModel(DreamlandBlocks.HIVE_LAPIS.item(), "block/hive_lapis");
		createBlockItemModel(DreamlandBlocks.HIVE_DIAMOND.item(), "block/hive_diamond");
		createBlockItemModel(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.item(), "block/hive_block_with_jelly");
		
		createBlockItemModel(DreamlandBlocks.DRIED_TAR.item(), "block/dried_tar");
		createBlockItemModel(DreamlandBlocks.TAR_SOIL.item(), "block/tar_soil");
		createBlockItemModel(DreamlandBlocks.DROUGHT_SOIL.item(), "block/drought_soil");
		createBlockItemModel(DreamlandBlocks.TAR_BARK_LEAVES.item(), "block/tar_bark_leaves1");
		
		createBlockItemModel(DreamlandBlocks.PLUM_BIRCH_LEAVES.item(), "block/plum_birch_leaves1");
		createBlockItemModel(DreamlandBlocks.MINERAL_DIRT.item(), "block/mineral_dirt");
		createBlockItemModel(DreamlandBlocks.FLOWERING_GRASS.item(), "block/flowering_grass");
		createBlockItemModel(DreamlandBlocks.FLOWERING_UNDERGROWTH.item(), "block/flowering_undergrowth");
		
		createSingleTextureModel(DreamlandItems.HIVE_JELLY_ITEM, "item/hive_jelly");
		createSingleTextureModel(DreamlandBlocks.CAVE_SLIME.item(), "block/cave_slime");
		createSingleTextureModel(DreamlandBlocks.HIVE_GROWTH.item(), "block/hive_growth_cross");
		createSingleTextureModel(DreamlandBlocks.TAR_SPROUTS.item(), "block/tar_sprouts");
		createSingleTextureModel(DreamlandBlocks.OPALINE_MARIGOLD.item(), "block/opaline_marigold");
		createSingleTextureModel(DreamlandBlocks.PINK_CRAB_GRASS.item(), "block/pink_crab_grass");
		
		
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

