package com.github.dragoni7.datagen;

import com.github.dragoni7.registry.DreamlandBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider{

	public BlockStates(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
		super(gen, modid, exFileHelper);
		
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(DreamlandBlocks.CLAY_SOIL.get());
		simpleBlock(DreamlandBlocks.DARK_QUARTZITE.get());
		simpleBlock(DreamlandBlocks.SOLID_TAR.get());
		simpleBlock(DreamlandBlocks.POROUS_STONE.get());
		simpleBlock(DreamlandBlocks.ROOTED_POROUS_STONE.get());
		simpleBlock(DreamlandBlocks.DUSK_ICE.get());
		simpleBlock(DreamlandBlocks.TOXIC_ROCK.get());
		simpleBlock(DreamlandBlocks.HIVE_BLOCK.get());
		
		

		
	}
}