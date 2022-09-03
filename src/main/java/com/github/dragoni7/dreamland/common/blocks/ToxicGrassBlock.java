package com.github.dragoni7.dreamland.common.blocks;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;

public class ToxicGrassBlock extends DreamlandSpreadingGrassBlock {

	public ToxicGrassBlock(Properties blockProperties) {
		super(blockProperties, () -> DreamlandBlocks.TOXIC_DIRT.block().get());
	}

}
