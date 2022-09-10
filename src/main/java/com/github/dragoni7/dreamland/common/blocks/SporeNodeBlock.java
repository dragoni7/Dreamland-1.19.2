package com.github.dragoni7.dreamland.common.blocks;

import java.util.List;
import java.util.Map;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandEffects;
import com.github.dragoni7.dreamland.core.registry.DreamlandParticles;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.github.dragoni7.dreamland.data.DreamlandBlockTags;
import com.github.dragoni7.dreamland.data.DreamlandItemTags;
import com.github.dragoni7.dreamland.network.Networking;
import com.github.dragoni7.dreamland.network.PacketUpateSporeNode;
import com.github.dragoni7.dreamland.util.RollBoolean;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SporeNodeBlock extends MultifaceBlock {
	public static final BooleanProperty IS_SPORING = BlockStateProperties.CONDITIONAL;
	private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private final MultifaceSpreader spreader = new MultifaceSpreader(this);
	
	private static final VoxelShape UP_AABB = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape DOWN_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	private static final VoxelShape WEST_AABB = Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
	private static final VoxelShape EAST_AABB = Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
	private static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
	private static final Map<Direction, VoxelShape> SHAPE_BY_DIRECTION = Util.make(Maps.newEnumMap(Direction.class), (map) -> {
	      map.put(Direction.NORTH, NORTH_AABB);
	      map.put(Direction.EAST, EAST_AABB);
	      map.put(Direction.SOUTH, SOUTH_AABB);
	      map.put(Direction.WEST, WEST_AABB);
	      map.put(Direction.UP, UP_AABB);
	      map.put(Direction.DOWN, DOWN_AABB);
	   });
	private final ImmutableMap<BlockState, VoxelShape> shapesCache;

	public SporeNodeBlock(Properties properties) {
		super(properties);
		shapesCache = this.getShapeForEachState(SporeNodeBlock::calculateMultifaceShape);
		this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)));
		this.registerDefaultState(this.defaultBlockState().setValue(IS_SPORING, Boolean.valueOf(false)));
	}
	
	public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
		return false;
	}
	
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
		if (state.getValue(WATERLOGGED).booleanValue() == false && state.getValue(IS_SPORING) == Boolean.valueOf(true)) {
			if (state.getValue(getFaceProperty(Direction.DOWN)).booleanValue() == true && level.getBlockState(pos.above()).isAir()) {
				for (int i = 0; i < 3; i++) {
					level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), 1.0D, 1.0D, 1.0D);
					level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), 1.0D, 1.0D, -1.0D);
					level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), -1.0D, 1.0D, 1.0D);
					level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), -1.0D, 1.0D, -1.0D);
					level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), 0.0D, 1.0D, 0.0D);
				}
			}
			else if (state.getValue(getFaceProperty(Direction.UP)).booleanValue() == true && level.getBlockState(pos.below()).isAir()) {
				for (int i = 0; i < 3; i++) {
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() - 0.25D, pos.getZ() + rand.nextDouble(), 1.0D, -1.0D, 1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() - 0.25D, pos.getZ() + rand.nextDouble(), 1.0D, -1.0D, -1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() - 0.25D, pos.getZ() + rand.nextDouble(), -1.0D, -1.0D, 1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() - 0.25D, pos.getZ() + rand.nextDouble(), -1.0D, -1.0D, -1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() - 0.25D, pos.getZ() + rand.nextDouble(), 0.0D, -1.0D, 0.0D);
				}
			}
			else if (state.getValue(getFaceProperty(Direction.NORTH)).booleanValue() == true && level.getBlockState(pos.south()).isAir()) {
				for (int i = 0; i < 3; i++) {
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), 1.0D, 1.0D, 1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), 1.0D, -1.0D, 1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), -1.0D, 1.0D, 1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), -1.0D, -1.0D, 1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), 0.0D, 0.0D, 1.0D);
				}
			}
			else if (state.getValue(getFaceProperty(Direction.SOUTH)).booleanValue() == true && level.getBlockState(pos.north()).isAir()) {
				for (int i = 0; i < 3; i++) {
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), 1.0D, 1.0D, -1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), 1.0D, -1.0D, -1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), -1.0D, 1.0D, -1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), -1.0D, -1.0D, -1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), 0.0D, 0.0D, -1.0D);
				}
			}
			else if (state.getValue(getFaceProperty(Direction.WEST)).booleanValue() == true && level.getBlockState(pos.east()).isAir()) {
				for (int i = 0; i < 3; i++) {
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), 1.0D, 1.0D, 1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), 1.0D, 1.0D, -1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), 1.0D, -1.0D, 1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), 1.0D, -1.0D, -1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), 1.0D, 0.0D, 0.0D);
				}
			}
			else if (state.getValue(getFaceProperty(Direction.EAST)).booleanValue() == true && level.getBlockState(pos.west()).isAir()) {
				for (int i = 0; i < 4; i++) {
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), -1.0D, 1.0D, 1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), -1.0D, 1.0D, -1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), -1.0D, -1.0D, 1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), -1.0D, -1.0D, -1.0D);
				level.addParticle(DreamlandParticles.MOLD_SPORES.get(), pos.getX() + rand.nextDouble(), pos.getY() + 1.0D, pos.getZ() + rand.nextDouble(), -1.0D, 0.0D, 0.0D);				
				}
			}
			else {
				return;
			}
			level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.LAVA_POP, SoundSource.BLOCKS, 0.5F, 0.025F, false);
			Networking.sendToServer(new PacketUpateSporeNode(pos));
		}
	}
	
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (state.getValue(IS_SPORING) == Boolean.valueOf(false)) {
			level.setBlockAndUpdate(pos, state.setValue(IS_SPORING, Boolean.valueOf(true)));
			List<LivingEntity> list = level.getEntitiesOfClass(LivingEntity.class, (new AABB(pos)).inflate(1.0D, 1.0D, 1.0D));
			if (!list.isEmpty()) {
		         for(LivingEntity entity : list) {
		        	 ItemStack helmet = entity.getItemBySlot(EquipmentSlot.HEAD).copy();
		        	 if (!helmet.is(DreamlandItemTags.PREVENTS_DECAY)) {
		        		 entity.addEffect((new MobEffectInstance(DreamlandEffects.DECAY.get(), 200)));
		 			}
		         }
		      }
			
			for (int x = -2; x <= 2; x++) {
				for (int z = -2; z <= 2; z++) {
					if (x != 0 && z != 0) {
						if (RollBoolean.roll(6, random)) {
							BlockPos currentPos = pos.offset(x, -1, z);
							BlockState target = level.getBlockState(currentPos);
							if (target.is(DreamlandBlockTags.MOLD_SPREADABLES) && !target.is(DreamlandBlockTags.TOXIC_JUNGLE_GROUND_BLOCKS) && !target.is(DreamlandWoodSets.MOLD_WOOD.log().block().get()) && !target.is(DreamlandWoodSets.MOLD_WOOD.wood().block().get())) {
								level.destroyBlock(currentPos, false);
								level.setBlock(currentPos, DreamlandBlocks.WHITE_MOLD.block().get().defaultBlockState(), 3);
							}
						}
					}
				}
			}
		}
	}
	
	public void updateSporing(ServerLevel level, BlockPos pos, BlockState state) {
		this.defaultBlockState();
		level.setBlockAndUpdate(pos, state.setValue(IS_SPORING, Boolean.valueOf(false)));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
	     return this.shapesCache.get(state);
	}
	
	private static VoxelShape calculateMultifaceShape(BlockState p_153959_) {
	      VoxelShape voxelshape = Shapes.empty();

	      for(Direction direction : DIRECTIONS) {
	         if (hasFace(p_153959_, direction)) {
	            voxelshape = Shapes.or(voxelshape, SHAPE_BY_DIRECTION.get(direction));
	         }
	      }

	      return voxelshape.isEmpty() ? Shapes.block() : voxelshape;
	}
	
	public BlockState updateShape(BlockState state1, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos1, BlockPos pos2) {
	      if (state1.getValue(WATERLOGGED)) {
	         level.scheduleTick(pos1, Fluids.WATER, Fluids.WATER.getTickDelay(level));
	      }

	    return super.updateShape(state1, direction, state2, level, pos1, pos2);
	}
	
	public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
	    return false;
	}
	
	public FluidState getFluidState(BlockState state) {
	    return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	 public boolean propagatesSkylightDown(BlockState state, BlockGetter blockGetter, BlockPos pos) {
	    return state.getFluidState().isEmpty();
	}
	 
	 protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
	      super.createBlockStateDefinition(builder);
	      builder.add(WATERLOGGED).add(IS_SPORING);
	}

	@Override
	public MultifaceSpreader getSpreader() {
		return this.spreader;
	}

}
