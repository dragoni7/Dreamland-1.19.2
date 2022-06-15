package com.github.dragoni7.dreamland.common.blocks;

import java.util.ArrayList;

import javax.annotation.Nullable;

import com.github.dragoni7.dreamland.common.items.HiveJelly;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class HiveMembraneCore extends LarvaAngerableBlock {
	
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final IntegerProperty LEVEL = BlockStateProperties.AGE_7;
	public static final int MAX_LEVEL = 7;
	
	public HiveMembraneCore(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HiveMembraneCore.LEVEL, Integer.valueOf(0)));
	}
	
	public BlockState getStateForPlacement(BlockPlaceContext context) {
	      return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(LEVEL, Integer.valueOf(0));
	   }
	
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		ItemStack item = player.getItemInHand(hand);
		
		if (!item.isEmpty() && item.getItem() instanceof HiveJelly && getLevel(state) < MAX_LEVEL) {
			int i = getLevel(state) + 1;
			
			if (!level.isClientSide) {
				item.setCount(item.getCount() - 1);
				level.setBlockAndUpdate(pos, state.setValue(LEVEL, i));
				buildMembrane(state, level, pos);
				level.playSound((Player)null, pos, SoundEvents.HONEYCOMB_WAX_ON, SoundSource.BLOCKS, 1.0F, 1.0F);
			}
			
			if (level.isClientSide && i < MAX_LEVEL) {
	    		  spawnSuccessParticles(state, level, pos);
	    	}
			
			return InteractionResult.SUCCESS;
		}
		
		return InteractionResult.CONSUME;
		
	   }
	
	private void buildMembrane(BlockState state, Level level, BlockPos pos) {
		int radius = getLevel(state) + 1;
		Direction direction = state.getValue(HorizontalDirectionalBlock.FACING);
		BlockState membrane = DreamlandBlocks.HIVE_MEMBRANE.block().get().defaultBlockState();
		BlockPos membranePos;
		
		Boolean xSearch = direction == Direction.NORTH || direction == Direction.SOUTH;
		
		for (int i = -radius; i <= radius; i++) {
			for (int y = -radius; y <= radius; y++) {
				
				if (xSearch) {
					membranePos = pos.offset(i, y, 0);
				}
				else {
					membranePos = pos.offset(0, y, i);
				}
				
				boolean canPlace = pos.distToCenterSqr(pos.getX(), pos.getY(), pos.getZ()) <= radius;
				if (canPlace && level.isEmptyBlock(membranePos)) {
					level.setBlock(membranePos, membrane, 3);
				}
			}
		}
	}
	
	public IntegerProperty getLevelProperty() {
	      return LEVEL;
	   }
	
	protected int getLevel(BlockState state) {
		return state.getValue(this.getLevelProperty());
	}
	
	private static void spawnSuccessParticles(BlockState state, Level level, BlockPos pos) {
		ParticleOptions particleoptions = ParticleTypes.HEART;
		RandomSource random = level.getRandom();
	      for(int i = 0; i < 4; ++i) {
	          double d0 = random.nextGaussian() * 0.02D;
	          double d1 = random.nextGaussian() * 0.02D;
	          double d2 = random.nextGaussian() * 0.02D;
	          level.addParticle(particleoptions, pos.getX() + random.nextDouble(), pos.getY() + 0.5D + + random.nextDouble(), pos.getZ() + 1.2D, d0, d1, d2);
	       }
	   }
	
	public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
		super.playerDestroy(level, player, pos, state, blockEntity, itemStack);
		BlockState disconnect = DreamlandBlocks.HIVE_MEMBRANE.block().get().defaultBlockState().setValue(HiveMembrane.CONNECTED,  Boolean.valueOf(false));
		ArrayList<BlockPos> membranes = searchBlocks(state, pos, level);
		if (membranes != null) {
			for (BlockPos membranePos : membranes) {
				level.setBlockAndUpdate(membranePos, disconnect);
			}
		}
	}
	
	public BlockState rotate(BlockState state, Rotation rotation) {
	      return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
	   }

	   public BlockState mirror(BlockState state, Mirror mirror) {
	      return state.rotate(mirror.getRotation(state.getValue(FACING)));
	   }
	
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
	      builder.add(FACING).add(LEVEL);
	   }
	
	private ArrayList<BlockPos> searchBlocks(BlockState state, BlockPos pos, Level level) {
		Direction direction = state.getValue(HorizontalDirectionalBlock.FACING);
		BlockPos checkPos = pos;
		int radius = getLevel(state)+1;
		ArrayList<BlockPos> matches = new ArrayList<BlockPos>();
		Boolean xSearch = direction == Direction.NORTH || direction == Direction.SOUTH;
		
		for (int i = -radius; i <= MAX_LEVEL; i++) {
			for (int y = -radius; y <= MAX_LEVEL; y++) {
				
				if (xSearch) {
					checkPos = pos.offset(i, y, 0);
				}
				else {
					checkPos = pos.offset(0, y, i);
				}
				
				if (level.getBlockState(checkPos).is(DreamlandBlocks.HIVE_MEMBRANE.block().get())) {
					matches.add(checkPos);
				}
			}
		}
		return matches;
	}
}
