package com.github.dragoni7.datagen;

import com.github.dragoni7.Dreamland;
import com.github.dragoni7.registry.DreamlandBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DreamlandBlockTags extends BlockTagsProvider{

	public DreamlandBlockTags(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, Dreamland.MODID, helper);
		
	}
	@Override
	protected void addTags() {
		
		tag(BlockTags.DIRT)
		.add(DreamlandBlocks.CLAY_SOIL.get())
		.add(DreamlandBlocks.CLAY_SOIL_GRASS.get());
		
		tag(Tags.Blocks.STONE)
		.add(DreamlandBlocks.DARK_QUARTZITE.get());
		
		tag(BlockTags.ICE)
		.add(DreamlandBlocks.DUSK_ICE.get());
		
		tag(BlockTags.MINEABLE_WITH_SHOVEL)
		.add(DreamlandBlocks.CLAY_SOIL.get());
		
		tag(BlockTags.MINEABLE_WITH_PICKAXE)
		.add(DreamlandBlocks.DARK_QUARTZITE.get());
		
	}
	
	@Override
	public String getName() {
		return "Dreamland Tags";
	}
}

