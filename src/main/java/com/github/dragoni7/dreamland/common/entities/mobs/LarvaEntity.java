package com.github.dragoni7.dreamland.common.entities.mobs;

import java.util.UUID;

import com.github.dragoni7.dreamland.core.registry.DreamlandEffects;
import com.github.dragoni7.dreamland.core.registry.DreamlandSoundEvents;
import com.github.dragoni7.dreamland.util.RollBoolean;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class LarvaEntity extends Monster implements IAnimatable, NeutralMob {
	
	private AnimationFactory factory = new AnimationFactory(this);
	private UUID persistentAngerTarget;
	private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(LarvaEntity.class, EntityDataSerializers.BYTE);
	private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME = SynchedEntityData.defineId(LarvaEntity.class, EntityDataSerializers.INT);
	private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(3, 5);
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if(event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.larva.walk", true));
		}
		
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.larva.idle", true));
		return PlayState.CONTINUE;
	}
	
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<LarvaEntity>(this, "LarvaController", 0, this::predicate));
	}

	public LarvaEntity(EntityType<? extends LarvaEntity> entityType, Level worldIn) {
		super(entityType, worldIn);
		this.moveControl = new MoveControl(this);
		this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -1.0F);
	    this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
	    this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 16.0F);
	    this.setPathfindingMalus(BlockPathTypes.COCOA, -1.0F);
	    this.setPathfindingMalus(BlockPathTypes.FENCE, -1.0F);
	}
	
	protected void defineSynchedData() {
	      super.defineSynchedData();
	      this.entityData.define(DATA_REMAINING_ANGER_TIME, 0);
	      this.entityData.define(DATA_FLAGS_ID, (byte)0);
	   }
	
	public static AttributeSupplier.Builder customAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 8.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.35D)
				.add(Attributes.ATTACK_DAMAGE, 1.5D)
				.add(Attributes.JUMP_STRENGTH, 2.0D)
				.add(Attributes.FOLLOW_RANGE, 48.0D);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new LarvaEntity.LarvaAttackGoal(this));
		this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0F));
		this.goalSelector.addGoal(4, new FloatGoal(this));
		this.goalSelector.addGoal(5, new LeapAtTargetGoal(this, 0.4F));
		
		
		this.targetSelector.addGoal(1, (new LarvaEntity.LarvaHurtByOtherGoal(this)).setAlertOthers(new Class[0]));
		this.targetSelector.addGoal(2, (new LarvaEntity.LarvaBecomeAngryTargetGoal(this)));
		this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal<>(this, true));
	}
	
	protected PathNavigation createNavigation(Level level) {
	      return new WallClimberNavigation(this, level);
	   }
	
	public void tick() {
		super.tick();
	      if (!this.level.isClientSide) {
	         this.setClimbing(this.horizontalCollision);
	      }

	   }
	
	public void addAdditionalSaveData(CompoundTag tag) {
		this.addPersistentAngerSaveData(tag);
	}
	
	public void readAdditionalSaveData(CompoundTag tag) {
		this.readPersistentAngerSaveData(this.level, tag);
	}
	
	protected void customServerAiStep() {
		if (!this.level.isClientSide) {
	         this.updatePersistentAnger((ServerLevel)this.level, false);
	      }
	}
	
	public static boolean checkLarvaSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor serverLevel, MobSpawnType spawnType, BlockPos pos, RandomSource rand) {
		if (serverLevel.getDifficulty() != Difficulty.PEACEFUL) {
			return true;
		}
		
		return false;
		
	   }
	
	public boolean checkSpawnRules(LevelAccessor level, MobSpawnType spawnReason) {
		RandomSource rand = getRandom();
		
        if (spawnReason == MobSpawnType.SPAWNER) {
        	return true;
        }
        
        return RollBoolean.roll(2, rand);
    }
	
	protected void playStepSound() {
		this.playSound(SoundEvents.SPIDER_STEP, 1.0F, 1.5F);
	}
	
	public boolean onClimbable() {
	      return this.isClimbing();
	   }
	
	protected SoundEvent getAmbientSound() {
		return DreamlandSoundEvents.LARVA_AMBIENT.get();
	}
	
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return DreamlandSoundEvents.LARVA_HIT.get();
	}
	
	protected SoundEvent getDeathSound() {
		return DreamlandSoundEvents.LARVA_DIE.get();
	}
	
	@Override
	protected float getStandingEyeHeight(Pose pose, EntityDimensions entityDimensions) {
	      return 0.5F;
	   }
	
	@Override
	public boolean isInvulnerableTo(DamageSource source) {
		return source == DamageSource.IN_WALL || source == DamageSource.FALLING_BLOCK || super.isInvulnerableTo(source);
	}
	
	public boolean causeFallDamage(float p_148750_, float p_148751_, DamageSource p_148752_) {
	      return false;
	   }

	protected void checkFallDamage(double p_27754_, boolean p_27755_, BlockState p_27756_, BlockPos p_27757_) {
	   }
	
	@Override
	public MobType getMobType() {
		return MobType.ARTHROPOD;
	}
	
	public boolean isClimbing() {
	      return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
	   }
	
	public void setClimbing(boolean p_33820_) {
	      byte b0 = this.entityData.get(DATA_FLAGS_ID);
	      if (p_33820_) {
	         b0 = (byte)(b0 | 1);
	      } else {
	         b0 = (byte)(b0 & -2);
	      }

	      this.entityData.set(DATA_FLAGS_ID, b0);
	   }

	@Override
	public int getRemainingPersistentAngerTime() {
		return this.entityData.get(DATA_REMAINING_ANGER_TIME);
	}

	@Override
	public void setRemainingPersistentAngerTime(int p_21673_) {
		this.entityData.set(DATA_REMAINING_ANGER_TIME, p_21673_);
	}

	@Override
	public UUID getPersistentAngerTarget() {
		return this.persistentAngerTarget;
	}

	@Override
	public void setPersistentAngerTarget(UUID p_21672_) {
		this.persistentAngerTarget = p_21672_;
	}

	@Override
	public void startPersistentAngerTimer() {
		this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
	
	public boolean requiresUpdateEveryTick() {
        return true;
     }
	
	static class LarvaBecomeAngryTargetGoal extends NearestAttackableTargetGoal<LivingEntity> {

		LarvaBecomeAngryTargetGoal(LarvaEntity larvaEntity) {
			super(larvaEntity, LivingEntity.class, 10, false, false, larvaEntity::isAngryAt);
		}
		
		public boolean canUse() {
			return this.larvaCanTarget() && super.canUse();
		}
		
		public boolean canContinueToUse() {
			boolean flag = this.larvaCanTarget();
			if (flag && this.mob.getTarget() != null) {
	            return super.canContinueToUse();
	         } else {
	            this.targetMob = null;
	            return false;
	         }	
		}
		
		private boolean larvaCanTarget() {
			LarvaEntity larvaEntity = (LarvaEntity)this.mob;
			return larvaEntity.isAngry();
		}
	}
	
	 class LarvaAttackGoal extends MeleeAttackGoal {

		public LarvaAttackGoal(LarvaEntity larvaEntity) {
			super(larvaEntity, 1.4D, true);
		}
		
		public boolean canUse() {
	         return super.canUse() && !this.mob.isVehicle() && LarvaEntity.this.isAngry();
	      }
		
		public boolean canContinueToUse() {
	         return super.canContinueToUse() && !this.mob.isVehicle() && LarvaEntity.this.isAngry();
	      }
		
		protected double getAttackReachSqr(LivingEntity entity) {
	         return (double)(4.0F + entity.getBbWidth());
	      } 
	}
	 
	 class LarvaHurtByOtherGoal extends HurtByTargetGoal {
		 
		 LarvaHurtByOtherGoal(LarvaEntity larva) {
	         super(larva);
	      }
		 
		 public boolean canContinueToUse() {
	         return LarvaEntity.this.isAngry() && super.canContinueToUse();
	      }
		 
		 protected void alertOther(Mob mob, LivingEntity entity) {
	    	 int i = 1;
	    	 MobEffect antagonized = DreamlandEffects.ANTAGONIZED.get();
	    	 
	    	 if (entity.hasEffect(antagonized)) {
	    		 i++;
	    	 }
	    	 
	         entity.addEffect(new MobEffectInstance(antagonized, 200, i));
	      }
	   }
}
