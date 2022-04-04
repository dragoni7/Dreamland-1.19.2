package com.github.dragoni7.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HiveJelly extends Item {

	public HiveJelly(Properties p_41383_) {
		super(p_41383_);
	}
	
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		
		ItemStack itemstack = player.getItemInHand(hand);
		
		if(player.isShiftKeyDown()) {
		      level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
		      if (!level.isClientSide) {
		         Snowball snowball = new Snowball(level, player);
		         snowball.setItem(itemstack);
		         snowball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
		         level.addFreshEntity(snowball);
		      }

		      player.awardStat(Stats.ITEM_USED.get(this));
		      if (!player.getAbilities().instabuild) {
		         itemstack.shrink(1);
		      }

		      return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
		}
		
		else {
			return InteractionResultHolder.fail(itemstack);
		}
	}

}
