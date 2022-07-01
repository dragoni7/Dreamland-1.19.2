package com.github.dragoni7.dreamland.common.entities.mobs;

import com.github.dragoni7.dreamland.Config;
import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;
import com.github.dragoni7.dreamland.util.RollBoolean;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class OpalShellEntity extends Animal implements IAnimatable {
	
	private AnimationFactory factory = new AnimationFactory(this);
	private static final EntityDataAccessor<Integer> OPAL_AMOUNT = SynchedEntityData.defineId(OpalShellEntity.class, EntityDataSerializers.INT);
	private int counter = 0;
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		
		if(event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.opal_shell.walk", true));
			return PlayState.CONTINUE;
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
	    this.setPathfindingMalus(BlockPathTypes.FENCE, -1.0F);
	}
	
	protected void defineSynchedData() {
	      super.defineSynchedData();
	      this.entityData.define(OPAL_AMOUNT, 0);
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
	
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putInt("OpalAmount", this.getOpalAmount());
		tag.putInt("counter", counter);
	}
	
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		this.setOpalAmount(tag.getInt("OpalAmount"));
		if (tag.contains("counter")) {
			this.counter = tag.getInt("counter");
		}
	}
	
	public boolean requiresUpdateEveryTick() {
        return true;
    }
	
	public void tick() {
		super.tick();
		int currentAmount = this.getOpalAmount();
		if (currentAmount < 4) {
			if (counter == 2400) {
				counter = 0;
				this.setOpalAmount(++currentAmount);
			}
			else if (counter < 2400) {
				counter++;
			}
		}
	}
	
	public static boolean checkOpalShellSpawnRules(EntityType<? extends Animal> entityType, ServerLevelAccessor serverLevel, MobSpawnType spawnType, BlockPos pos, RandomSource rand) {
		return serverLevel.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && serverLevel.getRawBrightness(pos, 0) > 8;
	}
	
	public boolean checkSpawnRules(LevelAccessor level, MobSpawnType spawnReason) {
        return RollBoolean.roll(Config.OPAL_SHELL_EXTRA_ROLL.get(), random);
    }
	
	protected void playStepSound(BlockPos pos, BlockState state) {
	    this.playSound(SoundEvents.COW_STEP, 0.15F, 0.6F);
	}

	protected float getSoundVolume() {
	    return 0.4F;
	}
	
	public boolean isFood(ItemStack stack) {
	    return stack.is(Items.APPLE);
	}
	
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		int currentAmount = this.getOpalAmount();
		if (currentAmount > 0) {
			ItemStack itemstack = player.getItemInHand(hand);
			
			if (itemstack.is(Tags.Items.SHEARS) && !this.isBaby()) {
				player.playSound(SoundEvents.METAL_BREAK);
				this.setOpalAmount(--currentAmount);
				counter = 0;
				
				Vec3 vec3 = this.position();
				double d0 = (double)Mth.randomBetween(this.random, -0.2F, 0.2F);
		        double d1 = (double)Mth.randomBetween(this.random, 0.3F, 0.5F);
		        double d2 = (double)Mth.randomBetween(this.random, -0.2F, 0.2F);
		        ItemStack opal = new ItemStack(DreamlandItems.OPAL.get());
		        
		        if (RollBoolean.roll(8, random)) {
		        	opal = new ItemStack(DreamlandItems.PRECIOUS_OPAL.get());
		        }
		        
				ItemEntity itemEntity = new ItemEntity(this.level, vec3.x(), vec3.y(), vec3.z(), opal, d0, d1, d2);
				this.level.addParticle(ParticleTypes.ELECTRIC_SPARK, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
				this.level.addFreshEntity(itemEntity);
				
				return InteractionResult.sidedSuccess(this.level.isClientSide);
			}
			else {
				return super.mobInteract(player, hand);
			}
		}
		return super.mobInteract(player, hand);
	}
	
	
	public int getOpalAmount() {
		return this.entityData.get(OPAL_AMOUNT);
	}

	
	public void setOpalAmount(int amount) {
		this.entityData.set(OPAL_AMOUNT, amount);
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
