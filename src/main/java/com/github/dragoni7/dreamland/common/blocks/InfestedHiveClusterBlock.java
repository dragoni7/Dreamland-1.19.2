package com.github.dragoni7.dreamland.common.blocks;


import com.github.dragoni7.dreamland.common.entities.mobs.LarvaEntity;
import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.state.BlockState;

public class InfestedHiveClusterBlock extends HiveClusterBlock {

	public InfestedHiveClusterBlock(Properties properties) {
		super(properties);
	}
	
	@SuppressWarnings("deprecation")
	public void spawnAfterBreak(BlockState state, ServerLevel serverLevel, BlockPos pos, ItemStack itemStack, boolean value) {
		super.spawnAfterBreak(state, serverLevel, pos, itemStack, value);
			if (serverLevel.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS) && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, itemStack) == 0 && !serverLevel.isClientSide) {
		         LarvaEntity larva = DreamlandEntities.LARVA.get().create(serverLevel);
		         larva.moveTo((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, 0.0F, 0.0F);
				 serverLevel.addFreshEntity(larva);
		      }
	}
}
