package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.ToIntFunction;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class CaveSlimePlant extends GrowingPlantBodyBlock implements CaveVines {

	public CaveSlimePlant(BlockBehaviour.Properties p_53886_) {
		super(p_53886_, Direction.DOWN , SHAPE, false);
	}

	@Override
	protected GrowingPlantHeadBlock getHeadBlock() {
		return (GrowingPlantHeadBlock)DreamlandBlocks.CAVE_SLIME.block().get();
	}
	
	public static ToIntFunction<BlockState> emission(int p_181223_) {
	      return (p_181221_) -> {
	         return p_181223_;
	      };
	   }

}
