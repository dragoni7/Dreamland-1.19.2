package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.ToIntFunction;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;

import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CaveSlimeBlock extends GrowingPlantHeadBlock implements CaveVines {
	
	public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 15.0D, 12.0D);

	public CaveSlimeBlock(BlockBehaviour.Properties properties) {
		super(properties, Direction.DOWN, SHAPE, false, 0.1D);
	}

	@Override
	protected int getBlocksToGrowWhenBonemealed(RandomSource p_53959_) {
		return 1;
	}

	@Override
	protected boolean canGrowInto(BlockState state) {
		return state.isAir();
	}

	@Override
	protected Block getBodyBlock() {
		return DreamlandBlocks.CAVE_SLIME_PLANT.get();
	}
	
	public static ToIntFunction<BlockState> emission(int lightLevel) {
		return (light) -> { return lightLevel; };
	}
}
