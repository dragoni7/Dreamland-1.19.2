package com.github.dragoni7.dreamland.common.entities.projectiles;

import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class TarBall extends AbstractHurtingProjectile implements IAnimatable {

	private AnimationFactory factory = new AnimationFactory(this);
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.tar_ball.idle", true));
		return PlayState.CONTINUE;
	}

	public TarBall(EntityType<? extends AbstractHurtingProjectile> type, Level level) {
		super(type, level);
	}
	
	public TarBall(LivingEntity owner, Level level) {
		super(DreamlandEntities.TAR_BALL.get(), level);
	}
	
	@Override
	protected ParticleOptions getTrailParticle() {
	      return ParticleTypes.SMOKE;
	   }

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<TarBall>(this, "TarBall Controller", 0, this::predicate));
		
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

}
