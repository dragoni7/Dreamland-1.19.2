package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.ToIntFunction;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class JellySplotchBlock extends MultifaceBlock implements SimpleWaterloggedBlock {
	private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	public JellySplotchBlock(BlockBehaviour.Properties p_153822_) {
		super(p_153822_);
		this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	public static ToIntFunction<BlockState> emission(int p_181223_) {
	      return (p_181221_) -> {
	         return MultifaceBlock.hasAnyFace(p_181221_) ? p_181223_ : 0;
	      };
	   }
	
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_153309_) {
	      super.createBlockStateDefinition(p_153309_);
	      p_153309_.add(WATERLOGGED);
	   }
	
	public BlockState updateShape(BlockState p_153302_, Direction p_153303_, BlockState p_153304_, LevelAccessor p_153305_, BlockPos p_153306_, BlockPos p_153307_) {
	      if (p_153302_.getValue(WATERLOGGED)) {
	         p_153305_.scheduleTick(p_153306_, Fluids.WATER, Fluids.WATER.getTickDelay(p_153305_));
	      }

	      return super.updateShape(p_153302_, p_153303_, p_153304_, p_153305_, p_153306_, p_153307_);
	   }
	
	public boolean canBeReplaced(BlockState p_153299_, BlockPlaceContext p_153300_) {
	      return super.canBeReplaced(p_153299_, p_153300_);
	   }
	
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState p_153311_) {
	      return p_153311_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_153311_);
	   }

	   public boolean propagatesSkylightDown(BlockState p_181225_, BlockGetter p_181226_, BlockPos p_181227_) {
	      return p_181225_.getFluidState().isEmpty();
	   }

	@Override
	public MultifaceSpreader getSpreader() {
		return null;
	}

}
