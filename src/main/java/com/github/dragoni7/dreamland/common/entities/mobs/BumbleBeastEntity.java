package com.github.dragoni7.dreamland.common.entities.mobs;

import java.util.UUID;

import com.github.dragoni7.dreamland.util.RollBoolean;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class BumbleBeastEntity extends PathfinderMob implements IAnimatable, NeutralMob {
	
	private AnimationFactory factory = new AnimationFactory(this);
	private UUID persistentAngerTarget;
	private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(LarvaEntity.class, EntityDataSerializers.BYTE);
	private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME = SynchedEntityData.defineId(LarvaEntity.class, EntityDataSerializers.INT);
	private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(8, 16);
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		
		if(event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bumble_beast.walk", true));
			return PlayState.CONTINUE;
		}
		
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bumble_beast.idle", true));
		
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<BumbleBeastEntity>(this, "BumbleBeastController", 0, this::predicate));
	}
	
	public BumbleBeastEntity(EntityType<? extends BumbleBeastEntity> entityType, Level worldIn) {
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
				.add(Attributes.MAX_HEALTH, 32.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.35D)
				.add(Attributes.ATTACK_DAMAGE, 3.0D)
				.add(Attributes.JUMP_STRENGTH, 1.0D)
				.add(Attributes.FOLLOW_RANGE, 48.0D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 2.0D)
				.add(Attributes.ARMOR, 3.0D);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0F));
		this.goalSelector.addGoal(4, new FloatGoal(this));
		this.goalSelector.addGoal(5, new LeapAtTargetGoal(this, 0.4F));
		
		this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal<>(this, true));
	}
	
	public void addAdditionalSaveData(CompoundTag tag) {
		this.addPersistentAngerSaveData(tag);
	}
	
	public void readAdditionalSaveData(CompoundTag tag) {
		this.readPersistentAngerSaveData(this.level, tag);
	}
	
	public static boolean checkBumbleBeastSpawnRules(EntityType<? extends PathfinderMob> entityType, ServerLevelAccessor serverLevel, MobSpawnType spawnType, BlockPos pos, RandomSource rand) {
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
		this.playSound(SoundEvents.SPIDER_STEP, 1.0F, 0.6F);
	}
	
	protected SoundEvent getAmbientSound() {
		return SoundEvents.BEEHIVE_WORK;
	}
	
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.BEE_HURT;
	}
	
	protected SoundEvent getDeathSound() {
		return SoundEvents.BEE_DEATH;
	}
	
	@Override
	public MobType getMobType() {
		return MobType.ARTHROPOD;
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
	public void setPersistentAngerTarget(UUID id) {
		this.persistentAngerTarget = id;
	}

	@Override
	public void startPersistentAngerTimer() {
		this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	}

}
