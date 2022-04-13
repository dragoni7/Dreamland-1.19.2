package com.github.dragoni7.dreamland.common.blocks;

import java.util.List;

import javax.annotation.Nullable;

import com.github.dragoni7.dreamland.common.entities.mobs.LarvaEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class HiveMembrane extends HalfTransparentBlock {

	public HiveMembrane(Properties p_53970_) {
		super(p_53970_);
	}

	public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity p_49588_, ItemStack p_49589_) {
	      super.playerDestroy(level, player, pos, state, p_49588_, p_49589_);
	      this.angerNearbyLarva(level, pos);
	   }
	
	private void angerNearbyLarva(Level level, BlockPos pos) {
	      List<LarvaEntity> list = level.getEntitiesOfClass(LarvaEntity.class, (new AABB(pos)).inflate(8.0D, 6.0D, 8.0D));
	      if (!list.isEmpty()) {
	         List<Player> list1 = level.getEntitiesOfClass(Player.class, (new AABB(pos)).inflate(8.0D, 6.0D, 8.0D));
	         if (list1.isEmpty()) return;
	         int i = list1.size();

	         for(LarvaEntity larva : list) {
	            if (larva.getTarget() == null) {
	               larva.setTarget(list1.get(level.random.nextInt(i)));
	            }
	         }
	      }

	   }
}
