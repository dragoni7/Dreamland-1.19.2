package com.github.dragoni7.dreamland.common.blocks.hivecocoon;

import com.github.dragoni7.dreamland.network.DreamlandNetworking;
import com.github.dragoni7.dreamland.network.PacketHiveCocoonAnimate;
import com.github.dragoni7.dreamland.setup.DreamlandBlocks;
import com.github.dragoni7.dreamland.setup.DreamlandEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class HiveCocoonContainer extends AbstractContainerMenu {
	
	private HiveCocoonTile tileEntity;
	private Player playerEntity;
	private IItemHandler playerInventory;
	
	public HiveCocoonContainer(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player) {
		super(DreamlandEntities.HIVE_COCOON_CONTAINER.get(), windowId);
		tileEntity = (HiveCocoonTile) world.getBlockEntity(pos);
		this.playerEntity = player;
		this.playerInventory = new InvWrapper(playerInventory);
		
		
		if (tileEntity != null) {
			tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
				int index = 0;
				int verAmount = 17;
				for (int i = 0; i < 3; i++) {
					int horAmount = 62;
					for(int j = 0; j < 3; j++) {
						addSlot(new SlotItemHandler(h, index, horAmount, verAmount));
						horAmount += 18;
						index++;
					}
					verAmount += 18;
				}
				
			});
		}
		
		layoutPlayerInventorySlots(8,84);
	}

	@Override
	public boolean stillValid(Player p_38874_) {
		return stillValid(ContainerLevelAccess.create(tileEntity.getLevel(), tileEntity.getBlockPos()), playerEntity, DreamlandBlocks.HIVE_COCOON.get());
	}
	
	@Override
	public ItemStack quickMoveStack(Player player, int index) {
	      ItemStack itemstack = ItemStack.EMPTY;
	      Slot slot = this.slots.get(index);
	      if (slot != null && slot.hasItem()) {
	         ItemStack itemstack1 = slot.getItem();
	         itemstack = itemstack1.copy();
	         if (index < 9) {
	            if (!this.moveItemStackTo(itemstack1, 9, 45, true)) {
	               return ItemStack.EMPTY;
	            }
	         } else if (!this.moveItemStackTo(itemstack1, 0, 9, false)) {
	            return ItemStack.EMPTY;
	         }

	         if (itemstack1.isEmpty()) {
	            slot.set(ItemStack.EMPTY);
	         } else {
	            slot.setChanged();
	         }

	         if (itemstack1.getCount() == itemstack.getCount()) {
	            return ItemStack.EMPTY;
	         }

	         slot.onTake(player, itemstack1);
	      }

	      return itemstack;
	   }
	
	private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
		for (int i = 0; i < amount ; i++) {
			addSlot(new SlotItemHandler(handler, index, x, y));
			x += dx;
			index++;
		}
		
		return index;
	}
	
	private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
		for (int j = 0; j < verAmount; j++) {
			index = addSlotRange(handler, index, x, y, horAmount, dx);
			y += dy;
		}
		return index;
	}
	
	private void layoutPlayerInventorySlots(int leftCol, int topRow) {
		// Player Inventory
		addSlotBox(playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);
		
		// Hotbar
		topRow += 58;
		addSlotRange(playerInventory, 0, leftCol, topRow, 9, 18);
	}
	
	public void removed(Player player) {
	      super.removed(player);
	      DreamlandNetworking.sendToNearby(this.tileEntity.getLevel(), this.tileEntity.getBlockPos(), new PacketHiveCocoonAnimate(this.tileEntity.getBlockPos(), 2));
	   }

}
