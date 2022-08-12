package com.github.dragoni7.dreamland.common.blocks;

import com.github.dragoni7.dreamland.Config;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandParticles;
import com.github.dragoni7.dreamland.data.DreamlandItemTags;
import com.github.dragoni7.dreamland.util.RollBoolean;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MidashroomBlock extends Block {
	
	public static final BooleanProperty IS_FERTILIZING = BlockStateProperties.CONDITIONAL;
	
	protected static final VoxelShape SHAPE = Shapes.or(Block.box(3, 0, 3, 13, 27, 13), Block.box(0, 0.25, 0, 16, 0.25, 16), Block.box(0, 27, 0, 16, 32, 16));
	
	public MidashroomBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(IS_FERTILIZING, Boolean.valueOf(false)));
	}
	
	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
	    return SHAPE;
	}
	
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
		if (state.getValue(IS_FERTILIZING) == Boolean.valueOf(true)) {
			for (int x = 0; x <= 2; x++) {
				for (int z = 0; z <= 2; z++) {
					spawnActiveParticles(level, pos.offset(x, 0.2, z));
					spawnActiveParticles(level, pos.offset(-x, 0.2, z));
					spawnActiveParticles(level, pos.offset(x, 0.2, -z));
					spawnActiveParticles(level, pos.offset(-x, 0.2, -z));
				}
			}
		}
	}
	
	public PushReaction getPistonPushReaction(BlockState state) {
	    return PushReaction.DESTROY;
	}
	
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (state.getValue(IS_FERTILIZING) == Boolean.valueOf(true)) {
			for(int x = -2; x <= 2; x++) {
				for (int z = -2; z <= 2; z++) {
					BlockPos currentPos = pos.offset(x, 0, z);
					BlockState target = level.getBlockState(currentPos);
					if (target.getBlock() instanceof BonemealableBlock) {
						BonemealableBlock bonemealable = (BonemealableBlock) target.getBlock();
						if (bonemealable.isValidBonemealTarget(level, currentPos, target, false)) {
							if (bonemealable.isBonemealSuccess(level, random, currentPos, target)) {
								if (RollBoolean.roll(Config.MIDASHROOM_GOLD_CONVERSION_CHANCE.get(), random)) {
									level.destroyBlock(currentPos, true);
									switch (random.nextIntBetweenInclusive(0, 3)) {
									case 0: {
										level.setBlock(currentPos, DreamlandBlocks.GOLD_CLUSTER.block().get().defaultBlockState(), 12);
									}
									case 1: {
										level.setBlock(currentPos, DreamlandBlocks.GOLDEN_MOSS_BLOCK.block().get().defaultBlockState(), 12);
									}
									case 2: {
										level.setBlock(currentPos, Blocks.RAW_GOLD_BLOCK.defaultBlockState(), 12);
									}
									case 3: {
										level.setBlock(currentPos, DreamlandBlocks.GOLD_FRONDS.block().get().defaultBlockState(), 12);
									}
									}
								}
								else {
									bonemealable.performBonemeal(level, random, currentPos, target);
								}
				             }
						}
					}
				}
			}
			level.setBlockAndUpdate(pos, state.setValue(IS_FERTILIZING, Boolean.valueOf(false)));
		}
	}
	
	private static void spawnActiveParticles(Level level, BlockPos pos) {
		ParticleOptions particleoptions = DreamlandParticles.MIDASHROOM_SPORES.get();
		RandomSource random = level.getRandom();
		int amount = random.nextInt(3);
	      for(int i = 0; i < 1 + amount; ++i) {
	          double d0 = random.nextGaussian() * 0.04D;
	          double d1 = random.nextGaussian() * 0.04D;
	          double d2 = random.nextGaussian() * 0.04D;
	          level.addParticle(particleoptions, pos.getX() + random.nextDouble(), pos.getY() + 1.0D + random.nextDouble(), pos.getZ() + random.nextDouble(), d0, d1, d2);
	       }
	   }
	
	@Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {
        if (!world.isClientSide && state.getValue(IS_FERTILIZING) == Boolean.valueOf(false)) {
        	ItemStack item = player.getItemInHand(hand).copy();
        	if (item.is(DreamlandItemTags.MIDASHROOM_CONSUMABLES)) {
        		item.shrink(1);
        		player.setItemInHand(hand, item);
        		world.setBlockAndUpdate(pos, state.setValue(IS_FERTILIZING, Boolean.valueOf(true)));
             }
        	return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
	
	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
	
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
	    builder.add(IS_FERTILIZING);
	}
}
