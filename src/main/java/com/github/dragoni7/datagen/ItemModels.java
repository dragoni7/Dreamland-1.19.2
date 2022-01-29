package com.github.dragoni7.datagen;

import com.github.dragoni7.Dreamland;
import com.github.dragoni7.registry.DreamlandItems;

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
		
		createBlockItemModel(DreamlandItems.HIVE_BLOCK,"block/hive_block1");
		createBlockItemModel(DreamlandItems.CLAY_SOIL,"block/clay_soil");
		createBlockItemModel(DreamlandItems.DARK_QUARTZITE,"block/dark_quartzite");
		createBlockItemModel(DreamlandItems.SOLID_TAR,"block/solid_tar");
		createBlockItemModel(DreamlandItems.POROUS_STONE,"block/porous_stone");
		createBlockItemModel(DreamlandItems.ROOTED_POROUS_STONE,"block/rooted_porous_stone");
		createBlockItemModel(DreamlandItems.DUSK_ICE,"block/dusk_ice");
		createBlockItemModel(DreamlandItems.TOXIC_ROCK,"block/toxic_rock");
		createBlockItemModel(DreamlandItems.MITE_JELLY, "block/mite_jelly");
		createBlockItemModel(DreamlandItems.HIVE_SLUDGE, "block/hive_sludge");
		
		singleTexture(DreamlandItems.HIVE_JELLY_ITEM.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"),
				"layer0", new ResourceLocation(Dreamland.MODID, "item/jelly"));
	}
	
	private void createBlockItemModel(RegistryObject<Item> item, String Path) {
		
		withExistingParent(item.get().getRegistryName().getPath(), new ResourceLocation(Dreamland.MODID, Path));
	}

}

