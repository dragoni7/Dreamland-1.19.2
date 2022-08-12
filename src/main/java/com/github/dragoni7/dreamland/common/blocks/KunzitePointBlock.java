package com.github.dragoni7.dreamland.common.blocks;

import javax.annotation.Nullable;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class KunzitePointBlock extends Block implements SimpleWaterloggedBlock {
	
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	public static final BooleanProperty PILLAR = BlockStateProperties.CONDITIONAL;
	
	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 13.0D, 15.0D, 13.0D);

	public KunzitePointBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(FACING, Direction.UP).setValue(PILLAR, Boolean.valueOf(false)));
	}
	
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
	    return SHAPE;
	}
	
	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
	
	@Override
	public VoxelShape getOcclusionShape(BlockState state, BlockGetter getter, BlockPos pos) {
	    return Shapes.empty();
	}
	
	public boolean canSurvive(BlockState state, LevelReader levelReader, BlockPos pos) {
	      Direction direction = state.getValue(FACING);
	      BlockPos blockpos = pos.relative(direction.getOpposite());
	      BlockState target = levelReader.getBlockState(blockpos);
	      
	      if (target.is(DreamlandBlocks.KUNZITE_POINT.block().get())) {
	    	  return direction == target.getValue(FACING);
	      }
	      
	      return target.isFaceSturdy(levelReader, blockpos, direction);
	}
	
	public BlockState updateShape(BlockState state1, Direction direction, BlockState state2, LevelAccessor accessor, BlockPos pos1, BlockPos pos2) {
		
		if (state1.getValue(WATERLOGGED)) {
			accessor.scheduleTick(pos1, Fluids.WATER, Fluids.WATER.getTickDelay(accessor));
	      }
		
		if (state2.is(DreamlandBlocks.KUNZITE_POINT.block().get()) && direction == state1.getValue(FACING)) {
			return state1.getValue(FACING) == state2.getValue(FACING) ? state1.setValue(PILLAR, true) : super.updateShape(state1, direction, state2, accessor, pos1, pos2);
		}
		else if (direction == state1.getValue(FACING)) {
			return state1.setValue(PILLAR, false);
		}
		
		return direction == state1.getValue(FACING).getOpposite() && !state1.canSurvive(accessor, pos1) ? Blocks.AIR.defaultBlockState() : super.updateShape(state1, direction, state2, accessor, pos1, pos2);
	}
	
	@Nullable
	 public BlockState getStateForPlacement(BlockPlaceContext context) {
	    LevelAccessor levelaccessor = context.getLevel();
	    BlockPos blockpos = context.getClickedPos();
	    Direction facing = context.getClickedFace();
	    	
	    return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER)).setValue(FACING, facing).setValue(PILLAR, false);
	}
	
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
	    return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	 }
	
	public boolean propagatesSkylightDown(BlockState state, BlockGetter blockGetter, BlockPos pos) {
	    return state.getFluidState().isEmpty();
	 }
	
	public BlockState rotate(BlockState state, Rotation rotation) {
	    return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
	 }

	 public BlockState mirror(BlockState state, Mirror mirror) {
	    return state.rotate(mirror.getRotation(state.getValue(FACING)));
	 }
	 
	 public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType pathType) {
	    return false;
	 }
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
	    builder.add(PILLAR, WATERLOGGED, FACING);
	}
	
	public PushReaction getPistonPushReaction(BlockState state) {
	      return PushReaction.DESTROY;
	   }
}
