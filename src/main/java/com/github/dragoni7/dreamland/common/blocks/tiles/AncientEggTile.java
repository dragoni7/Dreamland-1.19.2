package com.github.dragoni7.dreamland.common.blocks.tiles;

import com.github.dragoni7.dreamland.core.registry.DreamlandTiles;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class AncientEggTile extends BlockEntity implements IAnimatable {

	private final AnimationFactory factory = new AnimationFactory(this);
	
	@SuppressWarnings({"rawtypes"})
	private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		AnimationController controller = event.getController();
		controller.setAnimation(new AnimationBuilder().addAnimation("animation.ancient_egg.idle", true));
		return PlayState.CONTINUE;
	}
	
	public AncientEggTile(BlockPos pos, BlockState state) {
		super(DreamlandTiles.ANCIENT_EGG.get(), pos, state);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

}
