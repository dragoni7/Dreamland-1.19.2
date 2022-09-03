package com.github.dragoni7.dreamland.common.blocks;

import javax.annotation.Nullable;

import com.github.dragoni7.dreamland.common.blocks.tiles.OpalDiffuserTile;
import com.mojang.math.Vector3f;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.ItemHandlerHelper;

public class OpalDiffuserBlock extends Block implements EntityBlock {
	
	protected static final VoxelShape SHAPE = Shapes.or(Block.box(3.0D, 0.0D, 3.0D, 13.0D, 2.0D, 13.0D), Block.box(4, 2, 4, 12, 3, 12), Block.box(5, 3, 5, 11, 8, 11));
	
	public static final BooleanProperty IS_DIFFUSING = BlockStateProperties.CONDITIONAL;

	public OpalDiffuserBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(IS_DIFFUSING, Boolean.valueOf(false)));
	}
	
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
	    return SHAPE;
	}
	
	public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
		return false;
	}
	
	public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) {
		if (state.getValue(BlockStateProperties.CONDITIONAL)) {
			BlockEntity tile = level.getBlockEntity(pos);
			int color = 0;
			if (tile instanceof OpalDiffuserTile) {
				color = ((OpalDiffuserTile) tile).getColor();
			}
			
			if (color > 0) {
				float b = color % 256;
				float g = ((color - b)/256) % 256;
				float r = ((color - b) / Mth.square(256)) - g/256;
				
				level.addParticle(new DustParticleOptions(new Vector3f(r/255.0F, g/255.0F, b/255.0F), 1.0F), (double)pos.getX() + 0.5D, (double)pos.getY() + 0.75D + rand.nextDouble(), (double)pos.getZ() + 0.5D, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new OpalDiffuserTile(pos, state);
	}
	
	@Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (level.isClientSide()) {
            return null;
        }
        return (level1, blockPos, blockState, t) -> {
            if (t instanceof OpalDiffuserTile tile) {
                tile.tickServer();
            }
        };
    }
	
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {
        if (!world.isClientSide && state.getValue(BlockStateProperties.CONDITIONAL) == Boolean.valueOf(false)) {
            BlockEntity tileEntity = world.getBlockEntity(pos);
            if (tileEntity instanceof OpalDiffuserTile) {
            	ItemStack item = player.getItemInHand(hand);
            	if (item.is(Items.POTION)) {
            		tileEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(h -> {
                		player.setItemInHand(hand, ItemHandlerHelper.insertItem(h, item, false));
                	});
                 }
            }
            return InteractionResult.SUCCESS;
        }
        
        return InteractionResult.PASS;
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(IS_DIFFUSING);
    }
}
