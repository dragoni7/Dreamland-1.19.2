package com.github.dragoni7.dreamland.common.blocks;

import javax.annotation.Nullable;

import com.github.dragoni7.dreamland.core.registry.DreamlandEffects;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LarvaAngerableBlock extends Block {

	public LarvaAngerableBlock(Properties properties) {
		super(properties);
	}
	
	public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
	      super.playerDestroy(level, player, pos, state, blockEntity, itemStack);
	      int i = 1;
	      MobEffect antagonized = DreamlandEffects.ANTAGONIZED.get();
	      
	      if (player.hasEffect(antagonized)) {
	    	  i++;
	      }
	      
	      player.addEffect(new MobEffectInstance(DreamlandEffects.ANTAGONIZED.get(), 200, i));
	   }
}
