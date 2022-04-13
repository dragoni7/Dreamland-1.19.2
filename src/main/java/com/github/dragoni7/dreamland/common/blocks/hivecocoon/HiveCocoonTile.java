package com.github.dragoni7.dreamland.common.blocks.hivecocoon;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.dragoni7.dreamland.setup.DreamlandEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class HiveCocoonTile extends BlockEntity implements IAnimatable {
	
	private final AnimationFactory factory = new AnimationFactory(this);
	private ItemStackHandler itemHandler = createHandler();
	
	private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
	
	@SuppressWarnings("unchecked")
	private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		event.getController().transitionLengthTicks = 0;
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.hive_cocoon.open", false));
		return PlayState.CONTINUE;
	}

	public HiveCocoonTile(BlockPos pos, BlockState state) {
		super(DreamlandEntities.HIVE_COCOON_TILE.get(), pos, state);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
	}
	
	@Override
	public void setRemoved() {
		super.setRemoved();
		handler.invalidate();
	}
	
	public void tickServer() {
		setChanged();
	}
	
	@Override
	public void load(CompoundTag tag) {
		if (tag.contains("inv")) {
			itemHandler.deserializeNBT(tag.getCompound("inv"));
		}
		
		super.load(tag);
	}
	
	@Override
	public void saveAdditional(CompoundTag tag) {
		tag.put("inv", itemHandler.serializeNBT());
	}
	
	private ItemStackHandler createHandler() {
		return new ItemStackHandler(1) {
			
			@Override
			protected void onContentsChanged(int slot) {
				setChanged();
			}
		};
	}
	
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return handler.cast();
		}
		
		return super.getCapability(cap, side);
	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	}

}
