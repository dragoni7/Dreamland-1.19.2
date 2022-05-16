package com.github.dragoni7.dreamland.common.blocks;

import java.util.List;
import java.util.Random;
import java.util.function.ToIntFunction;

import javax.annotation.Nullable;

import com.github.dragoni7.dreamland.common.entities.mobs.LarvaEntity;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class CaveSlime extends GrowingPlantHeadBlock implements CaveVines {

	public CaveSlime(BlockBehaviour.Properties p_53928_) {
		super(p_53928_, Direction.DOWN, SHAPE, false, 0.1D);
	}

	@Override
	protected int getBlocksToGrowWhenBonemealed(Random p_53959_) {
		return 1;
	}

	@Override
	protected boolean canGrowInto(BlockState p_53968_) {
		return p_53968_.isAir();
	}

	@Override
	protected Block getBodyBlock() {
		return DreamlandBlocks.CAVE_SLIME_PLANT.get();
	}
	
	/*public boolean skipRendering(BlockState p_53972_, BlockState p_53973_, Direction p_53974_) {
	      return p_53973_.is(this) ? true : super.skipRendering(p_53972_, p_53973_, p_53974_);
	   }*/
	
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
	
	public static ToIntFunction<BlockState> emission(int p_181223_) {
	      return (p_181221_) -> {
	         return p_181223_;
	      };
	   }

}
