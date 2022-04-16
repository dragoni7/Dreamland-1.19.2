package com.github.dragoni7.dreamland.common.blocks.hivecocoon;

import com.github.dragoni7.dreamland.common.blocks.LarvaAngerableBlock;
import com.github.dragoni7.dreamland.network.DreamlandNetworking;
import com.github.dragoni7.dreamland.network.PacketHiveCocoonAnimate;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

public class HiveCocoon extends LarvaAngerableBlock implements EntityBlock {
	
	public HiveCocoon(Properties properties) {
		super(properties);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new HiveCocoonTile(pos, state);
	}
	
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
		if (level.isClientSide()) {
			return null;
		}
		
		return (level1, blockPos, blockState, t) -> {
			if (t instanceof HiveCocoonTile tile) {
				tile.tickServer();
			}
		};
	}
	
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {
		if (!level.isClientSide()) {
			BlockEntity tileEntity = level.getBlockEntity(pos);
			if (tileEntity instanceof HiveCocoonTile) {
				MenuProvider containerProvider = new MenuProvider() {
					
					@Override
					public Component getDisplayName() {
						return new TranslatableComponent("screen.dreamland.hive_cocoon");
					}
					
					@Override
					public AbstractContainerMenu createMenu(int i, Inventory playerInventory, Player playerEntity) {
						return new HiveCocoonContainer(i, level, pos, playerInventory, playerEntity);
					}
				};
				DreamlandNetworking.sendToNearby(level, pos, new PacketHiveCocoonAnimate(pos, 1));
				NetworkHooks.openGui((ServerPlayer) player, containerProvider, tileEntity.getBlockPos());
				
			} else {
				throw new IllegalStateException("Our named container provider is missing!");
			}
		}
		return InteractionResult.SUCCESS;
	}
	
	@Override
	public void onRemove(BlockState p_49076_, Level p_49077_, BlockPos p_49078_, BlockState p_49079_, boolean p_49080_) {
	      if (!p_49076_.is(p_49079_.getBlock())) {
	         BlockEntity blockentity = p_49077_.getBlockEntity(p_49078_);
	         if (blockentity instanceof Container) {
	            Containers.dropContents(p_49077_, p_49078_, (Container)blockentity);
	            p_49077_.updateNeighbourForOutputSignal(p_49078_, this);
	         }

	         super.onRemove(p_49076_, p_49077_, p_49078_, p_49079_, p_49080_);
	      }
	   }
	
	
	@Override
	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.ENTITYBLOCK_ANIMATED;
	}

	
}
