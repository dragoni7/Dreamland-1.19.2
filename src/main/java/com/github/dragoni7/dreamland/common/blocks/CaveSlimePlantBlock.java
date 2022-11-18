package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.ToIntFunction;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CaveSlimePlantBlock extends GrowingPlantBodyBlock implements CaveVines {
	
	public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

	public CaveSlimePlantBlock(BlockBehaviour.Properties properties) {
		super(properties, Direction.DOWN , SHAPE, false);
	}

	@Override
	protected GrowingPlantHeadBlock getHeadBlock() {
		return (GrowingPlantHeadBlock)DreamlandBlocks.CAVE_SLIME.block().get();
	}
	
	public static ToIntFunction<BlockState> emission(int lightLevel) {
		return (light) -> { return lightLevel; };
	}
}
