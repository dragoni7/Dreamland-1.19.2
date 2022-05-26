package com.github.dragoni7.dreamland.common.entities.mobs;

import java.util.Random;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.github.dragoni7.dreamland.util.RollBoolean;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class OozeEntity extends Monster implements IAnimatable {
	
	private AnimationFactory factory = new AnimationFactory(this);
	
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
				.add(Attributes.ATTACK_DAMAGE, 1.5D)
				.add(Attributes.FOLLOW_RANGE, 48.0D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 10.0D);
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<OozeEntity>(this, "OozeController", 0, this::predicate));
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
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
	
	public static boolean checkOozeSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor serverLevel, MobSpawnType spawnType, BlockPos pos, Random rand) {
		if (serverLevel.getDifficulty() != Difficulty.PEACEFUL) {
			if (serverLevel.getBlockState(pos.below()).is(DreamlandFluids.TAR_BLOCK.get()) && !serverLevel.getFluidState(pos.below().below()).is(DreamlandFluids.TAR_FLUID.get())) {
				return true;
			}
		}
		
		return false;
		
	   }
	
	public boolean checkSpawnRules(LevelAccessor level, MobSpawnType spawnReason) {
		Random rand = getRandom();
		
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

}
