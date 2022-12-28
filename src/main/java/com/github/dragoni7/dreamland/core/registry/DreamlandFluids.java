package com.github.dragoni7.dreamland.core.registry;

import java.util.function.Consumer;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.blocks.FrostWaterLiquidBlock;
import com.github.dragoni7.dreamland.common.blocks.TarLiquidBlock;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DreamlandFluids {
	
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Dreamland.MODID);
	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Dreamland.MODID);
	
	private static ForgeFlowingFluid.Properties tarFluidProperties() {
		return new ForgeFlowingFluid.Properties(TAR_FLUID_TYPE, TAR_FLUID, TAR_FLOWING).block(TAR_BLOCK).bucket(DreamlandItems.TAR_BUCKET);
	}
	
	private static ForgeFlowingFluid.Properties frostWaterProperties() {
		return new ForgeFlowingFluid.Properties(FROST_WATER_TYPE, FROST_WATER_FLUID, FROST_WATER_FLOWING).block(FROST_WATER_BLOCK).bucket(DreamlandItems.FROST_WATER_BUCKET);
	}
	
	public static final RegistryObject<FluidType> TAR_FLUID_TYPE = FLUID_TYPES.register("tar_fluid",
			() -> new FluidType(FluidType.Properties.create().supportsBoating(false).canPushEntity(false).canExtinguish(false).fallDistanceModifier(0.5F).canHydrate(false).canDrown(true).canSwim(false).density(3000)
                    .viscosity(6000).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.STONE_PLACE).pathType(BlockPathTypes.LAVA))
			{
				@Override
				public boolean move(FluidState state, LivingEntity entity, Vec3 movementVector, double gravity)
			    {
					Vec3 motion = entity.getDeltaMovement();
					
					if (motion.y > 0.0D && entity.hasEffect(DreamlandEffects.TARRED.get())) {
						entity.setDeltaMovement(motion.multiply(0.5D, 0.7D, 0.5D)); // entity ascends slower
					} else if (motion.y < 0.0D) {
						entity.setDeltaMovement(motion.multiply(0.5D, 0.9D, 0.5D)); // entity sinks slower
					} else {
						entity.setDeltaMovement(motion.multiply(0.5D, 1.0D, 0.5D)); // entity moves slower on xz axis
					}
					
					return false;
			    }
				
				@Override
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() { 
						private static final ResourceLocation STILL = DreamlandLoc.createLoc("block/tar_still"),
						FLOW = DreamlandLoc.createLoc("block/tar_flow"),
						OVERLAY = DreamlandLoc.createLoc("block/tar");
						
						@Override
						public ResourceLocation getStillTexture() {
							return STILL;
						}
						
						@Override
                        public ResourceLocation getFlowingTexture()
                        {
                            return FLOW;
                        }

                        @Override
                        public ResourceLocation getOverlayTexture()
                        {
                            return OVERLAY;
                        }
					});
				}
			});
	
	public static final RegistryObject<FluidType> FROST_WATER_TYPE = FLUID_TYPES.register("frost_water_fluid",
			() -> new FluidType(FluidType.Properties.create().supportsBoating(true).canPushEntity(true).canExtinguish(true).canHydrate(false).canDrown(true).canSwim(true)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.BUCKET_EMPTY).pathType(BlockPathTypes.LAVA))
			{
				
				@Override
				public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
					consumer.accept(new IClientFluidTypeExtensions() { 
						private static final ResourceLocation STILL = DreamlandLoc.createLoc("block/frost_water_still"),
						FLOW = DreamlandLoc.createLoc("block/frost_water_flow"),
						OVERLAY = DreamlandLoc.createLoc("block/frost_water");
						
						@Override
						public ResourceLocation getStillTexture() {
							return STILL;
						}
						
						@Override
                        public ResourceLocation getFlowingTexture()
                        {
                            return FLOW;
                        }

                        @Override
                        public ResourceLocation getOverlayTexture()
                        {
                            return OVERLAY;
                        }
					});
				}
			});
	
	public static final RegistryObject<FlowingFluid> TAR_FLUID = FLUIDS.register("tar_fluid", 
			() -> new ForgeFlowingFluid.Source(tarFluidProperties()));
	
	public static final RegistryObject<Fluid> TAR_FLOWING = FLUIDS.register("tar_flowing", 
			() -> new ForgeFlowingFluid.Flowing(tarFluidProperties()));
	
	public static final RegistryObject<LiquidBlock> TAR_BLOCK = Dreamland.BLOCKS.register("tar",
			() -> new TarLiquidBlock(() -> TAR_FLUID.get(), BlockBehaviour.Properties.of(Material.LAVA).noCollission().strength(100F).noLootTable()));
	
	public static final RegistryObject<FlowingFluid> FROST_WATER_FLUID = FLUIDS.register("frost_water", 
			() -> new ForgeFlowingFluid.Source(frostWaterProperties()));
	
	public static final RegistryObject<Fluid> FROST_WATER_FLOWING = FLUIDS.register("frost_water_flowing", 
			() -> new ForgeFlowingFluid.Flowing(frostWaterProperties()));
	
	public static final RegistryObject<LiquidBlock> FROST_WATER_BLOCK = Dreamland.BLOCKS.register("frost_water",
			() -> new FrostWaterLiquidBlock(() -> FROST_WATER_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100F).noLootTable()));
	
}
