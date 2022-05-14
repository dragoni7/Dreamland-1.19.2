package com.github.dragoni7.dreamland.datagen;

import java.util.ArrayList;

import com.github.dragoni7.dreamland.core.DreamlandBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider{

	public BlockStates(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
		super(gen, modid, exFileHelper);
		
	}

	@Override
	protected void registerStatesAndModels() {
		
		ArrayList<Block> simpleBlocks = new ArrayList<Block>();
		simpleBlocks.add(DreamlandBlocks.CLAY_SOIL.get());
		simpleBlocks.add(DreamlandBlocks.DARK_QUARTZITE.get());
		simpleBlocks.add(DreamlandBlocks.POROUS_STONE.get());
		simpleBlocks.add(DreamlandBlocks.ROOTED_POROUS_STONE.get());
		simpleBlocks.add(DreamlandBlocks.DUSK_ICE.get());
		simpleBlocks.add(DreamlandBlocks.TOXIC_ROCK.get());
		simpleBlocks.add(DreamlandBlocks.HIVE_MEMBRANE.get());
		simpleBlocks.add(DreamlandBlocks.HIVE_IRON.get());
		simpleBlocks.add(DreamlandBlocks.HIVE_COPPER.get());
		simpleBlocks.add(DreamlandBlocks.HIVE_REDSTONE.get());
		simpleBlocks.add(DreamlandBlocks.HIVE_GOLD.get());
		simpleBlocks.add(DreamlandBlocks.HIVE_LAPIS.get());
		simpleBlocks.add(DreamlandBlocks.HIVE_DIAMOND.get());
		simpleBlocks.add(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.get());
		simpleBlocks.add(DreamlandBlocks.DRIED_TAR.get());
		simpleBlocks.add(DreamlandBlocks.TAR_SOIL.get());
		simpleBlocks.add(DreamlandBlocks.DROUGHT_SOIL.get());

		for(Block element : simpleBlocks) {
			simpleBlock(element);
		}

		
	}
}