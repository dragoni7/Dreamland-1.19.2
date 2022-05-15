package com.github.dragoni7.dreamland.common.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.github.dragoni7.dreamland.common.entities.mobs.LarvaEntity;
import com.github.dragoni7.dreamland.core.DreamlandBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class HiveGrowth extends CarpetBlock {

	public HiveGrowth(Properties p_152915_) {
		super(p_152915_);
	}
	
	public void animateTick(BlockState state, Level level, BlockPos pos, Random p_54903_) {
	      super.animateTick(state, level, pos, p_54903_);
	      if (p_54903_.nextInt(10) == 0) {
	         level.addParticle(ParticleTypes.MYCELIUM, (double)pos.getX() + p_54903_.nextDouble(), (double)pos.getY() + 1.1D, (double)pos.getZ() + p_54903_.nextDouble(), 0.0D, 0.0D, 0.0D);
	      }
	}
	
	@SuppressWarnings("deprecation")
	public boolean canBeReplaced(BlockState p_153299_, BlockPlaceContext p_153300_) {
	      return super.canBeReplaced(p_153299_, p_153300_);
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
