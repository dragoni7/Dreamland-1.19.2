package com.github.dragoni7.dreamland.common.entities.mobs;

import java.util.UUID;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.util.RollBoolean;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.PathfinderMob;
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
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class BumbleBeastEntity extends Animal implements IAnimatable, NeutralMob {
	
	private AnimationFactory factory = new AnimationFactory(this);
	private UUID persistentAngerTarget;
	private static final Item EXCHANGE_ITEM = Items.HONEY_BLOCK;
	private static final EntityDataAccessor<Boolean> HAS_HONEY = SynchedEntityData.defineId(BumbleBeastEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME = SynchedEntityData.defineId(BumbleBeastEntity.class, EntityDataSerializers.INT);
	private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
	private int counter = 0;
	private int honeyAmount = 0;
	
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
	    this.setPathfindingMalus(BlockPathTypes.LEAVES, -1.0F);
	}
	
	protected void defineSynchedData() {
	      super.defineSynchedData();
	      this.entityData.define(DATA_REMAINING_ANGER_TIME, 0);
	      this.entityData.define(HAS_HONEY, Boolean.valueOf(false));
	   }
	
	public static AttributeSupplier.Builder customAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 32.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.35D)
				.add(Attributes.ATTACK_DAMAGE, 3.0D)
				.add(Attributes.JUMP_STRENGTH, 2.0D)
				.add(Attributes.FOLLOW_RANGE, 48.0D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 2.0D)
				.add(Attributes.ARMOR, 3.0D);
	}
	
	@Override
	protected void registerGoals() {
		//this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(0, new BumbleBeastEntity.BumbleBeastAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0F));
		this.goalSelector.addGoal(4, new FloatGoal(this));
		this.goalSelector.addGoal(5, new LeapAtTargetGoal(this, 0.4F));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
	    this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
		this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal<>(this, true));
	}
	
	public void addAdditionalSaveData(CompoundTag tag) {
		this.addPersistentAngerSaveData(tag);
		tag.putBoolean("HasHoney", this.hasHoney());
	}
	
	public void readAdditionalSaveData(CompoundTag tag) {
		this.readPersistentAngerSaveData(this.level, tag);
		this.setHasHoney(tag.getBoolean("HasHoney"));
	}
	
	public boolean requiresUpdateEveryTick() {
        return true;
     }
	
	public void tick() {
		super.tick();
		if (counter == 6000 && honeyAmount < 3) {
			this.setHasHoney(true);
			honeyAmount++;
			counter = 0;
		}
		else if (counter < 6000) {
			counter++;
		}
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
	protected float getStandingEyeHeight(Pose pose, EntityDimensions entityDimensions) {
	      return 1.25F;
	}
	
	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		return null;
	}
	
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		
		if (this.hasHoney()) {
		      if (itemstack.is(Items.GLASS_BOTTLE) && !this.isBaby()) {
		         player.playSound(SoundEvents.BOTTLE_FILL, 1.0F, 1.0F);
		         ItemStack itemstack1 = ItemUtils.createFilledResult(itemstack, player, Items.HONEY_BOTTLE.getDefaultInstance());
		         player.setItemInHand(hand, itemstack1);
		         counter = 0;
		         honeyAmount--;
		         if (honeyAmount == 0) {
		        	 this.setHasHoney(false);
		         }
		         return InteractionResult.sidedSuccess(this.level.isClientSide);
		      } else {
		         return super.mobInteract(player, hand);
		      }
		}
		
		if (itemstack.is(EXCHANGE_ITEM)) {
			ItemStack returnStack = itemstack.copy();
			returnStack.setCount(itemstack.getCount() - 1);
			player.setItemInHand(hand, returnStack);
			Vec3 vec3 = this.position();
			double d0 = (double)Mth.randomBetween(this.random, -0.2F, 0.2F);
	        double d1 = (double)Mth.randomBetween(this.random, 0.3F, 0.7F);
	        double d2 = (double)Mth.randomBetween(this.random, -0.2F, 0.2F);
			ItemEntity itemEntity = new ItemEntity(this.level, vec3.x(), vec3.y(), vec3.z(), new ItemStack(DreamlandBlocks.BUMBLE_BLOCK.item().get()), d0, d1, d2);
			this.playSound(SoundEvents.CAT_EAT, 1.0F, 0.5F);
			this.level.addParticle(ParticleTypes.FALLING_HONEY, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
			this.level.addFreshEntity(itemEntity);
		}
		
		return super.mobInteract(player, hand);
	}
	
	public boolean hasHoney() {
		return this.entityData.get(HAS_HONEY).booleanValue();
	}
	
	public void setHasHoney(boolean value) {
		this.entityData.set(HAS_HONEY, Boolean.valueOf(value));
	}

	@Override
	public int getRemainingPersistentAngerTime() {
		return this.entityData.get(DATA_REMAINING_ANGER_TIME);
	}

	@Override
	public void setRemainingPersistentAngerTime(int time) {
		this.entityData.set(DATA_REMAINING_ANGER_TIME, time);
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
	
	class BumbleBeastAttackGoal extends MeleeAttackGoal {

		public BumbleBeastAttackGoal(BumbleBeastEntity entity, double speedMult, boolean mustSee) {
			super(entity, speedMult, mustSee);
		}
		
		protected double getAttackReachSqr(LivingEntity entity) {
	         return (double)(-2.0F + entity.getBbWidth());
	    } 
	}
}
