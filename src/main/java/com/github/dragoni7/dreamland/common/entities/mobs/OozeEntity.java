package com.github.dragoni7.dreamland.common.entities.mobs;

import com.github.dragoni7.dreamland.common.entities.projectiles.TarBall;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.github.dragoni7.dreamland.util.RollBoolean;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class OozeEntity extends Monster implements IAnimatable {
	
	private AnimationFactory factory = new AnimationFactory(this);
	private static final EntityDataAccessor<Boolean> DATA_OOZE_IS_CHARGING = SynchedEntityData.defineId(OozeEntity.class, EntityDataSerializers.BOOLEAN);
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.ooze.idle", true));
		return PlayState.CONTINUE;
	}

	public OozeEntity(EntityType<? extends OozeEntity> entityType, Level level) {
		super(entityType, level);
	}
	
	public static AttributeSupplier.Builder customAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 20.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.0D)
				.add(Attributes.FOLLOW_RANGE, 48.0D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 10.0D);
	}
	
	public boolean isOozeCharging() {
	      return this.entityData.get(DATA_OOZE_IS_CHARGING);
	   }
	
	public void setOozeCharging(boolean charging) {
	      this.entityData.set(DATA_OOZE_IS_CHARGING, charging);
	   }
	
	protected void defineSynchedData() {
	      super.defineSynchedData();
	      this.entityData.define(DATA_OOZE_IS_CHARGING, false);
	   }

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<OozeEntity>(this, "OozeController", 0, this::predicate));
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(2, new OozeShootTarGoal(this));
		
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}
	
	protected float getStandingEyeHeight(Pose pose, EntityDimensions entityDimensions) {
	      return 3.0F;
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
	
	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}
	
	public static boolean checkOozeSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor serverLevel, MobSpawnType spawnType, BlockPos pos, RandomSource rand) {
		if (serverLevel.getDifficulty() != Difficulty.PEACEFUL) {
			if (serverLevel.getBlockState(pos.below()).is(DreamlandFluids.TAR_BLOCK.get())) {
				return true;
			}
		}
		
		return false;
		
	   }
	
	public boolean checkSpawnRules(LevelAccessor level, MobSpawnType spawnReason) {
		RandomSource rand = getRandom();
		
        if (spawnReason == MobSpawnType.SPAWNER) {
        	return true;
        }
        
        return RollBoolean.roll(4, rand);
    }
	
	protected SoundEvent getAmbientSound() {
		return SoundEvents.SLIME_SQUISH;
	}
	
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.SLIME_HURT;
	}
	
	protected SoundEvent getDeathSound() {
		return SoundEvents.SLIME_DEATH;
	}
	
	static class OozeShootTarGoal extends Goal {
		
		private final OozeEntity ooze;
		public int chargeTime;
		
		public OozeShootTarGoal(OozeEntity ooze) {
			this.ooze = ooze;
		}
		
		public void start() {
	       this.chargeTime = 0;
	    }

	    public void stop() {
	       this.ooze.setOozeCharging(false);
	    }

	    public boolean requiresUpdateEveryTick() {
	       return true;
	    }
	      
		public boolean canUse() {
			return this.ooze.getTarget() != null;
		}
		
		public void tick() {
			LivingEntity livingentity = this.ooze.getTarget();
			
			if (livingentity != null) {
				this.ooze.getLookControl().setLookAt(livingentity);
				if (livingentity.distanceToSqr(this.ooze) < 2048.0D && this.ooze.hasLineOfSight(livingentity)) {
					Level level = this.ooze.level;
					++this.chargeTime;
					if (this.chargeTime == 40) {
						level.levelEvent((Player)null, 1018, this.ooze.blockPosition(), 0);
					}
					
					if (this.chargeTime == 60) {
						Vec3 vec3 = this.ooze.getViewVector(1.0F);
						double d2 = livingentity.getX() - (this.ooze.getX() + vec3.x);
						double d3 = livingentity.getY(0.5D) - (0.5D + this.ooze.getY(0.5));
						double d4 = livingentity.getZ() - (this.ooze.getZ() + vec3.z);
						
						TarBall tarball = new TarBall(level, this.ooze, d2, d3, d4);
						tarball.setPos(this.ooze.getX() + vec3.x, this.ooze.getY(0.5D) + 0.5D, this.ooze.getZ() + vec3.z);
						level.addFreshEntity(tarball);
						this.chargeTime = -160;
					}
				} else if (this.chargeTime > 0) {
					--this.chargeTime;
				}
				
				this.ooze.setOozeCharging(this.chargeTime > 40);
			}
		}
		
	}
}
