package com.github.dragoni7.dreamland.core.registry;

import java.util.function.Consumer;

import com.github.dragoni7.dreamland.Dreamland;
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
import net.minecraftforge.client.IFluidTypeRenderProperties;
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
	
	public static final RegistryObject<FluidType> TAR_FLUID_TYPE = FLUID_TYPES.register("tar_fluid",
			() -> new FluidType(FluidType.Properties.create().supportsBoating(false).canPushEntity(false).canExtinguish(false).fallDistanceModifier(0.5F).canHydrate(false).canDrown(true).canSwim(false).density(3000)
                    .viscosity(6000).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.STONE_PLACE).pathType(BlockPathTypes.LAVA))
			{
				@Override
				public boolean move(FluidState state, LivingEntity entity, Vec3 movementVector, double gravity)
			    {
					entity.setDeltaMovement(entity.getDeltaMovement().add(0, -0.10D, 0).multiply(0.5, 1, 0.5));
					return false;
			    }
				
				@Override
				public void initializeClient(Consumer<IFluidTypeRenderProperties> consumer) {
					consumer.accept(new IFluidTypeRenderProperties() {
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
	
	public static final RegistryObject<FlowingFluid> TAR_FLUID = FLUIDS.register("tar_fluid", 
			() -> new ForgeFlowingFluid.Source(tarFluidProperties()));
	
	public static final RegistryObject<Fluid> TAR_FLOWING = FLUIDS.register("tar_flowing", 
			() -> new ForgeFlowingFluid.Flowing(tarFluidProperties()));
	
	public static final RegistryObject<LiquidBlock> TAR_BLOCK = DreamlandBlocks.BLOCKS.register("tar",
			() -> new TarLiquidBlock(() -> TAR_FLUID.get(), BlockBehaviour.Properties.of(Material.LAVA).noCollission().strength(100F).noLootTable()));
	
}
