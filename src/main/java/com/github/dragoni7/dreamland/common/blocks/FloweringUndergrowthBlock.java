package com.github.dragoni7.dreamland.common.blocks;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;

public class FloweringUndergrowthBlock extends DreamlandSpreadingGrassBlock {

	public FloweringUndergrowthBlock(Properties blockProperties) {
		super(blockProperties, () -> DreamlandBlocks.MINERAL_DIRT.get());
	}

}
