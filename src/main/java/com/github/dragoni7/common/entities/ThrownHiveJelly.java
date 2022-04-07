package com.github.dragoni7.common.entities;

import com.github.dragoni7.common.blocks.DreamlandBlockTags;
import com.github.dragoni7.common.blocks.DreamlandBlocks;
import com.github.dragoni7.common.items.DreamlandItems;

import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

public class ThrownHiveJelly extends ThrowableItemProjectile {
	
	public ThrownHiveJelly(EntityType<? extends ThrownHiveJelly> type, Level level) {
		super(type, level);
	}
	
	public ThrownHiveJelly(Level level, LivingEntity player) {
		super(DreamlandEntities.THROWN_HIVE_JELLY.get(), player, level);
	}
	
	public ThrownHiveJelly(Level p_37476_, double p_37477_, double p_37478_, double p_37479_) {
	    super(DreamlandEntities.THROWN_HIVE_JELLY.get(), p_37477_, p_37478_, p_37479_, p_37476_);
	}
	
	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte p_37484_) {
	      if (p_37484_ == 3) {
	         double d0 = 0.08D;

	         for(int i = 0; i < 8; ++i) {
	            this.level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
	         }
	      }

	   }
	@Override
	protected void onHit(HitResult result) {
	      if (!this.level.isClientSide && result.getType() == HitResult.Type.BLOCK) {
	    	  
	    	 BlockState state = DreamlandBlocks.JELLY_SPLOTCH.get().defaultBlockState();
	    	 BlockHitResult blockHitResult = (BlockHitResult) result;
	    	 Direction direction = blockHitResult.getDirection();
	    	 BlockPos pos = blockHitResult.getBlockPos().relative(direction);
	    	 Boolean canPlace = false;
	    	 
	         if(this.level.isEmptyBlock(pos) || level.getBlockState(pos).getMaterial().isReplaceable()) {
	        	 if (direction == Direction.UP) {
	        		 state = state.setValue(BlockStateProperties.DOWN, Boolean.valueOf(true));
	        		 canPlace = true;
	        	 }
	        	 
	        	 if (direction == Direction.DOWN) {
	        		 state = state.setValue(BlockStateProperties.UP, Boolean.valueOf(true));
	        		 canPlace = true;
	        	 }
	        	 
	        	 if (direction == Direction.NORTH) {
	        		 state = state.setValue(BlockStateProperties.SOUTH, Boolean.valueOf(true));
	        		 canPlace = true;
	        	 }
	        	 
	        	 if (direction == Direction.SOUTH) {
	        		 state = state.setValue(BlockStateProperties.NORTH, Boolean.valueOf(true));
	        		 canPlace = true;
	        	 }
	        	 
	        	 if (direction == Direction.WEST) {
	        		 state = state.setValue(BlockStateProperties.EAST, Boolean.valueOf(true));
	        		 canPlace = true;
	        	 }
	        	 
	        	 if (direction == Direction.EAST) {
	        		 state = state.setValue(BlockStateProperties.WEST, Boolean.valueOf(true));
	        		 canPlace = true;
	        	 }
	        	 
	        	 if (canPlace && state.canSurvive(level, pos)) {
        			 this.level.setBlockAndUpdate(pos, state);
        		 }
	        	 else {
	        		 this.level.addFreshEntity(new ItemEntity(this.level, this.blockPosition().getX(), this.blockPosition().getY(), this.blockPosition().getZ(), new ItemStack(DreamlandItems.HIVE_JELLY_ITEM.get())));
	        	 }
	         }
	      }
	      else if (!this.level.isClientSide && result.getType() == HitResult.Type.ENTITY) {
	    	  EntityHitResult entityHitResult = (EntityHitResult) result;
	    	  Entity target = entityHitResult.getEntity();
	    	  BlockPos pos = target.blockPosition();
	    	  if(target.isAlive()) {
	    		  target.hurt(DamageSource.thrown(this, this.getOwner()), 0);
	    		  target.setGlowingTag(true);
	    	  }
	      }
	      
	      this.remove(RemovalReason.DISCARDED);
	}

	@Override
	protected Item getDefaultItem() {
		return DreamlandItems.HIVE_JELLY_ITEM.get();
	}

}
