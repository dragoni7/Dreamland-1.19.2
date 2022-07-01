package com.github.dragoni7.dreamland.common.blocks.tiles;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.dragoni7.dreamland.core.registry.DreamlandTiles;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class OpalDiffuserTile extends BlockEntity {
	
	private ItemStackHandler itemHandler = createHandler();
	private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
	
	private boolean isDiffusing = false;
	private int duration;
	private int counter;
	private int color;

	public OpalDiffuserTile(BlockPos pos, BlockState state) {
		super(DreamlandTiles.OPAL_DIFFUSER.get(), pos, state);
	}
	
	public void tickServer() {
		ItemStack stack = itemHandler.getStackInSlot(0).copy();
		
		if (stack.getItem() == Items.POTION) {
			color = PotionUtils.getColor(stack);
			List<MobEffectInstance> effects = PotionUtils.getMobEffects(stack);
			BlockPos pos = this.getBlockPos();
			
			if (!isDiffusing) {
				Item.getId(stack.getItem());
				for (MobEffectInstance effect : effects) {
					if (effect.getDuration() > duration) {
						duration = effect.getDuration();
					}
				}
				
				setDiffusing(true);
				counter = 0;
			}
			else {
				if (counter <= duration) {
					if(counter % 40 == 0) { 
						List<LivingEntity> entities = this.level.getEntitiesOfClass(LivingEntity.class, new AABB(pos).inflate(5));
						if (!entities.isEmpty() && !effects.isEmpty()) {
							for (LivingEntity entity : entities) {
								for (MobEffectInstance effect : effects) {
									MobEffectInstance effectToApply = new MobEffectInstance(effect);
									Boolean hasEffect = entity.hasEffect(effectToApply.getEffect());
									if (!hasEffect) {
										entity.addEffect(effectToApply);
									}
								}
							}
						}
					}
					counter++;
				}
				else {
					itemHandler.extractItem(0, 1, false);
					setDiffusing(false);
					counter = 0;
					duration = 0;
					setChanged();
				}
			}
		}
	}
	
	private void setDiffusing(boolean value) {
		if (value == false) {
			color = 0;
		}
		
		isDiffusing = value;
		BlockState blockstate = this.level.getBlockState(worldPosition);
		this.level.setBlock(worldPosition, blockstate.setValue(BlockStateProperties.CONDITIONAL, value), Block.UPDATE_ALL);
		this.level.sendBlockUpdated(worldPosition, blockstate, blockstate, Block.UPDATE_CLIENTS);
	}
	
	public int getColor() {
		return color;
	}
	
	@Override
    public void setRemoved() {
        super.setRemoved();
        handler.invalidate();
    }
	
	@Override
    public void load(CompoundTag tag) {
        if (tag.contains("inv")) {
            itemHandler.deserializeNBT(tag.getCompound("inv"));
        }
        
        isDiffusing = tag.getBoolean("isDiffusing");
        duration = tag.getInt("duration");
        counter = tag.getInt("counter");
        color = tag.getInt("color");
        
        super.load(tag);
    }
	
	@Override
    public void saveAdditional(CompoundTag tag) {
        tag.put("inv", itemHandler.serializeNBT());
        tag.putBoolean("isDiffusing", isDiffusing);
        tag.putInt("duration", duration);
        tag.putInt("counter", counter);
        tag.putInt("color", color);
    }
	
	@Override
	public CompoundTag getUpdateTag() {
		CompoundTag tag = super.getUpdateTag();
		tag.putInt("color", color);
		return tag;
	}
	
	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}
	
	private ItemStackHandler createHandler() {
        return new ItemStackHandler(1) {

            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return stack.getItem() == Items.POTION;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (stack.getItem() != Items.POTION) {
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }
        };
    } 
	
	@Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }
}
