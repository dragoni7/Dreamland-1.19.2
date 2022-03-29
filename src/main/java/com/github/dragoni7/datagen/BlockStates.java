package com.github.dragoni7.datagen;

import java.util.List;

import com.github.dragoni7.common.blocks.DreamlandBlocks;

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
		
		List<Block> simpleBlocks = List.of(DreamlandBlocks.CLAY_SOIL.get(),
										   DreamlandBlocks.DARK_QUARTZITE.get(),
										   DreamlandBlocks.SOLID_TAR.get(),
										   DreamlandBlocks.POROUS_STONE.get(),
										   DreamlandBlocks.ROOTED_POROUS_STONE.get(),
										   DreamlandBlocks.DUSK_ICE.get(),
										   DreamlandBlocks.TOXIC_ROCK.get(),
										   DreamlandBlocks.HIVE_SLUDGE.get(),
										   DreamlandBlocks.HIVE_IRON.get(),
										   DreamlandBlocks.HIVE_COPPER.get(),
										   DreamlandBlocks.HIVE_GOLD.get(),
										   DreamlandBlocks.HIVE_REDSTONE.get(),
										   DreamlandBlocks.HIVE_LAPIS.get(),
										   DreamlandBlocks.HIVE_DIAMOND.get(),
										   DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.get()
										   );

		for(Block element : simpleBlocks) {
			simpleBlock(element);
		}

		
	}
}