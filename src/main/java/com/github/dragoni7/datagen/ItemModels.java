package com.github.dragoni7.datagen;

import com.github.dragoni7.Dreamland;
import com.github.dragoni7.registry.DreamlandItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModels extends ItemModelProvider{

	public ItemModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
		super(generator, modid, existingFileHelper);
		
	}

	@Override
	protected void registerModels() {

		withExistingParent(DreamlandItems.CLAY_SOIL.get().getRegistryName().getPath(), new ResourceLocation(Dreamland.MODID, "block/clay_soil"));
		withExistingParent(DreamlandItems.DARK_QUARTZITE.get().getRegistryName().getPath(), new ResourceLocation(Dreamland.MODID, "block/dark_quartzite"));
		withExistingParent(DreamlandItems.SOLID_TAR.get().getRegistryName().getPath(), new ResourceLocation(Dreamland.MODID, "block/solid_tar"));
		withExistingParent(DreamlandItems.POROUS_STONE.get().getRegistryName().getPath(), new ResourceLocation(Dreamland.MODID, "block/porous_stone"));
		withExistingParent(DreamlandItems.ROOTED_POROUS_STONE.get().getRegistryName().getPath(), new ResourceLocation(Dreamland.MODID, "block/rooted_porous_stone"));
		withExistingParent(DreamlandItems.DUSK_ICE.get().getRegistryName().getPath(), new ResourceLocation(Dreamland.MODID, "block/dusk_ice"));
		withExistingParent(DreamlandItems.TOXIC_ROCK.get().getRegistryName().getPath(), new ResourceLocation(Dreamland.MODID, "block/toxic_rock"));
		
	}

}

