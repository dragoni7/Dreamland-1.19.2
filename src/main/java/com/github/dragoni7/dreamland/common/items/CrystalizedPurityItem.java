package com.github.dragoni7.dreamland.common.items;

import com.github.dragoni7.dreamland.data.DreamlandBlockTags;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CrystalizedPurityItem extends Item {

	public CrystalizedPurityItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		BlockPos pos;
		Boolean used = false;
	      if (!level.isClientSide) {
	    	  for (int x = -3; x < 3; x++) {
	    		  for (int z = -3; z < 3; z++) {
	    			  pos = player.blockPosition().offset(x, 0, z);
	    			  if (level.getBlockState(pos).is(DreamlandBlockTags.PURIFIABLE_BLOCKS)) {
	    				  level.destroyBlock(pos, false);
	    				  used = true;
	    			  }
	    		  }
	    	  }
	      }
	      
	      if (used) {
	    	  level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
	    	  player.awardStat(Stats.ITEM_USED.get(this));
		      if (!player.getAbilities().instabuild) {
		         itemstack.shrink(1);
			      return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
		      } 
	      }
	      
	      return InteractionResultHolder.fail(itemstack);
	}

}
