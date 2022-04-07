package com.github.dragoni7.common.blocks;

import java.util.function.ToIntFunction;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class CaveSlimePlant extends GrowingPlantBodyBlock implements CaveVines{

	public CaveSlimePlant(BlockBehaviour.Properties p_53886_) {
		super(p_53886_, Direction.DOWN , SHAPE, false);
	}

	@Override
	protected GrowingPlantHeadBlock getHeadBlock() {
		return (GrowingPlantHeadBlock)DreamlandBlocks.CAVE_SLIME.get();
	}
	
	public boolean skipRendering(BlockState p_53972_, BlockState p_53973_, Direction p_53974_) {
	      return p_53973_.is(this) ? true : super.skipRendering(p_53972_, p_53973_, p_53974_);
	   }
	
	public static ToIntFunction<BlockState> emission(int p_181223_) {
	      return (p_181221_) -> {
	         return p_181223_;
	      };
	   }

}
