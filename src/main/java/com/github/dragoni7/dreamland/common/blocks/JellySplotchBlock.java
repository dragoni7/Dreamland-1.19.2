package com.github.dragoni7.dreamland.common.blocks;

import java.util.function.ToIntFunction;

import com.github.dragoni7.dreamland.core.registry.DreamlandItems;

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
	private final MultifaceSpreader spreader = new MultifaceSpreader(this);
	
	public JellySplotchBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	public static ToIntFunction<BlockState> emission(int lightLevel) {
	      return (light) -> {
	         return MultifaceBlock.hasAnyFace(light) ? lightLevel : 0;
	      };
	   }
	
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
	      super.createBlockStateDefinition(state);
	      state.add(WATERLOGGED);
	   }
	
	public BlockState updateShape(BlockState state1, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos1, BlockPos pos2) {
	      if (state1.getValue(WATERLOGGED)) {
	         level.scheduleTick(pos1, Fluids.WATER, Fluids.WATER.getTickDelay(level));
	      }

	      return super.updateShape(state1, direction, state2, level, pos1, pos2);
	   }
	
	public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
	    return !context.getItemInHand().is(DreamlandItems.HIVE_JELLY_ITEM.get()) || super.canBeReplaced(state, context);
	 }
	
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
	      return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	   }

	   public boolean propagatesSkylightDown(BlockState state, BlockGetter blockGetter, BlockPos pos) {
	      return state.getFluidState().isEmpty();
	   }

	@Override
	public MultifaceSpreader getSpreader() {
		return this.spreader;
	}

}
