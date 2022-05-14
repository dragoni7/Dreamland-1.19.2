package com.github.dragoni7.dreamland.common.blocks.hivecocoon;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.core.DreamlandEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
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

public class HiveCocoonTile extends RandomizableContainerBlockEntity implements IAnimatable {
	
	private final AnimationFactory factory = new AnimationFactory(this);
	private ItemStackHandler itemHandler = createHandler();
	private int open = 0;
	private NonNullList<ItemStack> itemStacks = NonNullList.withSize(9, ItemStack.EMPTY);
	private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
	
	private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (open == 1) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.hive_cocoon.open", false).addAnimation("animation.hold_open", true));
			return PlayState.CONTINUE;
		}
		if (open == 2) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.hive_cocoon.close", false).addAnimation("animation.hold_closed", true));
			return PlayState.CONTINUE;
		}
		
		return PlayState.CONTINUE;
	}

	public HiveCocoonTile(BlockPos pos, BlockState state) {
		super(DreamlandEntities.HIVE_COCOON_TILE.get(), pos, state);
	}
	
	public void setOpenAnimate(int value) {
		open = value;
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
			Dreamland.LOGGER.atDebug().log("loading " + itemHandler.getStackInSlot(0).toString() + " as " + tag.getCompound("inv").getAsString());
		}
		super.load(tag);
		Dreamland.LOGGER.atDebug().log("itemStack contents: " + itemStacks.get(0));
	}
	
	public void loadFromTag(CompoundTag tag) {
	}
	
	@Override
	public void saveAdditional(CompoundTag tag) {
		tag.put("inv", itemHandler.serializeNBT());
		Dreamland.LOGGER.atDebug().log("saving " + itemHandler.getStackInSlot(0).toString() + " as " + itemHandler.serializeNBT().getAsString());
		this.itemStacks.set(0, itemHandler.getStackInSlot(0));
		Dreamland.LOGGER.atDebug().log("itemStack contents: " + itemStacks.get(0));
	}
	
	private ItemStackHandler createHandler() {
		return new ItemStackHandler(9) {
			
			@Override
			protected void onContentsChanged(int slot) {
				setChanged();
				Dreamland.LOGGER.atDebug().log(" contents changed ");
			}
			
			@Override
			protected void onLoad()
		    {
				Dreamland.LOGGER.atDebug().log(" called onLoad() ");
				Dreamland.LOGGER.atDebug().log(" current stack contents: " + itemStacks.get(0));
				
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

	@Override
	public int getContainerSize() {
		return 9;
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		NonNullList<ItemStack> temp = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		for (int i = 0; i < 9; i++) {
			temp.set(i, itemHandler.getStackInSlot(i));
		}
		return temp;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> items) {
		this.itemStacks = items;
	}

	@Override
	protected Component getDefaultName() {
		return null;
	}

	@Override
	protected AbstractContainerMenu createMenu(int p_58627_, Inventory p_58628_) {
		return null;
	}

}
