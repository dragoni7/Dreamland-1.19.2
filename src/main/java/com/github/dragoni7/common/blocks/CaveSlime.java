package com.github.dragoni7.common.blocks;

import java.util.Random;
import java.util.function.ToIntFunction;

import com.github.dragoni7.registry.DreamlandBlocks;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class CaveSlime extends GrowingPlantHeadBlock implements CaveVines{

	public CaveSlime(BlockBehaviour.Properties p_53928_) {
		super(p_53928_, Direction.DOWN, SHAPE, false, 0.1D);
	}

	@Override
	protected int getBlocksToGrowWhenBonemealed(Random p_53959_) {
		return 1;
	}

	@Override
	protected boolean canGrowInto(BlockState p_53968_) {
		return p_53968_.isAir();
	}

	@Override
	protected Block getBodyBlock() {
		return DreamlandBlocks.CAVE_SLIME_PLANT.get();
	}
	
	public static ToIntFunction<BlockState> emission(int p_181223_) {
	      return (p_181221_) -> {
	         return p_181223_;
	      };
	   }

}
