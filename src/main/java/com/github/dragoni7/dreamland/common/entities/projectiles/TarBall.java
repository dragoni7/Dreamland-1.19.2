package com.github.dragoni7.dreamland.common.entities.projectiles;

import com.github.dragoni7.dreamland.common.entities.mobs.OozeEntity;
import com.github.dragoni7.dreamland.core.registry.DreamlandEffects;
import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;
import com.github.dragoni7.dreamland.core.registry.DreamlandParticles;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
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

	public TarBall(EntityType<? extends TarBall> type, Level level) {
		super(type, level);
	}
	
	public TarBall(Level level, LivingEntity entity, double x, double y, double z) {
		super(DreamlandEntities.TAR_BALL.get(), entity, x, y, z, level);
	}
	
	public TarBall(LivingEntity owner, Level level) {
		super(DreamlandEntities.TAR_BALL.get(), level);
	}
	
	protected void onHitEntity(EntityHitResult hitResult) {
	      super.onHitEntity(hitResult);
	      if (!this.level.isClientSide) {
	         Entity entity = hitResult.getEntity();
	         Entity owner = this.getOwner();
	         
	         if (!(entity instanceof OozeEntity)) {
	        	 if (owner instanceof LivingEntity) {
	 	        	entity.hurt(DamageSource.indirectMobAttack(this, (LivingEntity) owner), 2.0F);
	 	            this.doEnchantDamageEffects((LivingEntity)owner, entity);
	 	         }
	 	         
	 	         if (entity instanceof LivingEntity) {
	 	        	 ((LivingEntity) entity).addEffect(new MobEffectInstance(DreamlandEffects.TARRED.get(), 40));
	 	         } 
	         }

	      }
	   }
	
	@Override
	protected ParticleOptions getTrailParticle() {
	      return DreamlandParticles.TAR_BUBBLE.get();
	}
	
	@Override
	protected float getInertia() {
	      return 0.95F;
	}
	
	@Override
	protected boolean shouldBurn() {
	      return false;
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
