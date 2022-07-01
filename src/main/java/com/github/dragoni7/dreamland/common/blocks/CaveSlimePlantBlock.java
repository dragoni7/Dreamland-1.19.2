package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.ToIntFunction;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class CaveSlimePlantBlock extends GrowingPlantBodyBlock implements CaveVines {

	public CaveSlimePlantBlock(BlockBehaviour.Properties properties) {
		super(properties, Direction.DOWN , SHAPE, false);
	}

	@Override
	protected GrowingPlantHeadBlock getHeadBlock() {
		return (GrowingPlantHeadBlock)DreamlandBlocks.CAVE_SLIME.block().get();
	}
	
	public static ToIntFunction<BlockState> emission(int lightLevel) {
	      return (light) -> {
	         return lightLevel;
	      };
	   }

}
