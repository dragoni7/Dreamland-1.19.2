package com.github.dragoni7.dreamland.common.blocks.tiles;

import com.github.dragoni7.dreamland.core.registry.DreamlandTiles;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class AncientEggTile extends BlockEntity implements IAnimatable {

	private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
	
	private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ancient_egg.idle", EDefaultLoopTypes.LOOP));
		return PlayState.CONTINUE;
	}
	
	public AncientEggTile(BlockPos pos, BlockState state) {
		super(DreamlandTiles.ANCIENT_EGG.get(), pos, state);
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<AncientEggTile>(this, "AncientEggController", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

}
