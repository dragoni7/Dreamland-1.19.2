package com.github.dragoni7.common.blocks;

import com.github.dragoni7.registry.DreamlandBlocks;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CaveSlimePlant extends GrowingPlantBodyBlock implements CaveVines{

	public CaveSlimePlant(BlockBehaviour.Properties p_53886_) {
		super(p_53886_, Direction.DOWN , SHAPE, false);
	}

	@Override
	protected GrowingPlantHeadBlock getHeadBlock() {
		return (GrowingPlantHeadBlock)DreamlandBlocks.CAVE_SLIME.get();
	}

}
