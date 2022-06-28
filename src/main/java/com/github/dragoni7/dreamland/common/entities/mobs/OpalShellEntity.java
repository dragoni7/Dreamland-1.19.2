package com.github.dragoni7.dreamland.common.entities.mobs;

import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.github.dragoni7.dreamland.util.RollBoolean;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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

public class OpalShellEntity extends Animal implements IAnimatable {
	
	private AnimationFactory factory = new AnimationFactory(this);
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		
		if(event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.opal_shell.walk", true));
		}
		
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.opal_shell.idle", true));
		
		return PlayState.CONTINUE;
	}
	
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<OpalShellEntity>(this, "OpalShellController", 0, this::predicate));
	}
	

	public OpalShellEntity(EntityType<? extends OpalShellEntity> entityType, Level worldIn) {
		super(entityType, worldIn);
		this.moveControl = new MoveControl(this);
		this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -1.0F);
	    this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
	    this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 16.0F);
	    this.setPathfindingMalus(BlockPathTypes.FENCE, -1.0F);
	}
	
	public static AttributeSupplier.Builder customAttributes() {
	      return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, (double)0.2F);
	}
	
	protected void registerGoals() {
	      this.goalSelector.addGoal(0, new FloatGoal(this));
	      this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
	      this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
	      this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.APPLE), false));
	      this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
	      this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
	      this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
	      this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
	}
	
	public static boolean checkOpalShellSpawnRules(EntityType<? extends Animal> entityType, ServerLevelAccessor serverLevel, MobSpawnType spawnType, BlockPos pos, RandomSource rand) {
		if (serverLevel.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && serverLevel.getRawBrightness(pos, 0) > 8) {
			return true;
		}
		
		return false;
	   }
	
	public boolean checkSpawnRules(LevelAccessor level, MobSpawnType spawnReason) {
        return true;
    }
	
	protected void playStepSound(BlockPos p_28301_, BlockState p_28302_) {
	      this.playSound(SoundEvents.COW_STEP, 0.15F, 0.6F);
	}

	protected float getSoundVolume() {
	      return 0.4F;
	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	}

	@Override
	public OpalShellEntity getBreedOffspring(ServerLevel level, AgeableMob mob) {
	      return DreamlandEntities.OPAL_SHELL.get().create(level);
	}   
	
	protected float getStandingEyeHeight(Pose pose, EntityDimensions dimension) {
	      return this.isBaby() ? dimension.height * 0.95F : 0.5F;
	}
}
