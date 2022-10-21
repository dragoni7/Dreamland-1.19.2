package com.github.dragoni7.dreamland.common.blocks;

import com.github.dragoni7.dreamland.Config;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.github.dragoni7.dreamland.data.DreamlandBlockTags;
import com.github.dragoni7.dreamland.util.RollBoolean;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MoldBlock extends Block {
	
	protected static final VoxelShape SHAPE = Shapes.or(Block.box(0.0D, 0.0D, 0.0D, 16D, 16D, 16D), Block.box(8D, 16D, 0.5D, 8D, 19D, 15.5D), Block.box(8D, 16D, 0.5D, 8D, 19D, 15.5D), Block.box(8D, -3D, 0.5D, 8D, 0D, 15.5D), Block.box(8D, -3D, 0.5D, 8D, 0D, 15.5D), Block.box(-2.5D, 8D, 0.5D, 0.5D, 8D, 15.5D), Block.box(-3D, 0.5D, 8D, 0D, 15.5D, 8D), Block.box(15.5D, 0.5D, 8D, 18.5D, 15.5D, 8D), Block.box(15.5D, 8D, 0.5D, 18.5D, 8D, 15.5D), Block.box(0.5D, 8D, 16D, 15.5D, 8D, 19D), Block.box(8D, 0.5D, 16D, 8D, 15.5D, 19D), Block.box(8D, 0.5D, -3D, 8D, 15.5D, 0D), Block.box(0.5D, 8D, -3D, 15.5D, 8D, 0D));

	public MoldBlock(Properties properties) {
		super(properties);
	}
	
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (Config.MOLD_SPREAD.get()) {
			if (RollBoolean.roll(400, random)) {
				for (int x = 0; x <= 1; x++) {
					for (int y = -1; y <= 1; y++) {
						for (int z = 0; z <= 1; z++) {
							BlockPos targetPos = pos.offset(x, y, z);
							BlockState target = level.getBlockState(targetPos);
							if (target.is(DreamlandBlockTags.MOLD_SPREADABLES) && !target.is(DreamlandBlockTags.TOXIC_JUNGLE_GROUND_BLOCKS) && !target.is(DreamlandWoodSets.MOLD_WOOD.log().block().get()) && !target.is(DreamlandWoodSets.MOLD_WOOD.wood().block().get())) {
								level.destroyBlock(targetPos, false);
								level.setBlock(targetPos, state, 3);
								if (RollBoolean.roll(14, random) && level.getBlockState(targetPos.above()).isAir()) {
									level.setBlock(targetPos.above(), DreamlandBlocks.SPORE_NODE.block().get().defaultBlockState().setValue(SporeNodeBlock.getFaceProperty(Direction.UP), Boolean.valueOf(false)).setValue(SporeNodeBlock.getFaceProperty(Direction.DOWN), Boolean.valueOf(true)).setValue(SporeNodeBlock.getFaceProperty(Direction.NORTH), Boolean.valueOf(false)).setValue(SporeNodeBlock.getFaceProperty(Direction.SOUTH), Boolean.valueOf(false)).setValue(SporeNodeBlock.getFaceProperty(Direction.EAST), Boolean.valueOf(false)).setValue(SporeNodeBlock.getFaceProperty(Direction.WEST), Boolean.valueOf(false)), 3);
								}
							}
						}
					}
				}
			}
		}
	}
	
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
	    return SHAPE;
	}
	
	public float getShadeBrightness(BlockState state, BlockGetter getter, BlockPos pos) {
	    return 0.2F;
	}
	
	public boolean skipRendering(BlockState state1, BlockState state2, Direction direction) {
		if (state2.getBlock() instanceof MoldBlock) {
			return true;
		}
		
	    return false;
	}
}
