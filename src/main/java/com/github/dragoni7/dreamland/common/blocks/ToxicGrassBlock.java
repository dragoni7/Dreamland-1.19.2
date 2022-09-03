package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.Supplier;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;

import net.minecraft.world.level.block.Block;

public class ToxicGrassBlock extends DreamlandSpreadingGrassBlock {

	public ToxicGrassBlock(Properties blockProperties) {
		super(blockProperties, () -> DreamlandBlocks.TOXIC_DIRT.block().get());
	}

}
