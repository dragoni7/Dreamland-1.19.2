package com.github.dragoni7.dreamland.core.registry;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.blocks.TarLiquidBlock;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DreamlandFluids {
	public static final ResourceLocation TAR_STILL_RL = DreamlandLoc.createLoc("block/tar_still");
	public static final ResourceLocation TAR_FLOWING_RL = DreamlandLoc.createLoc("block/tar_flow");
	public static final ResourceLocation TAR_OVERLAY_RL = DreamlandLoc.createLoc("block/tar");
	
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Dreamland.MODID);
	
	public static final RegistryObject<FlowingFluid> TAR_FLUID = FLUIDS.register("tar_fluid", 
			() -> new ForgeFlowingFluid.Source(DreamlandFluids.TAR_PROPERTIES));
	
	public static final RegistryObject<FlowingFluid> TAR_FLOWING = FLUIDS.register("tar_flowing", 
			() -> new ForgeFlowingFluid.Flowing(DreamlandFluids.TAR_PROPERTIES));
	
	public static final ForgeFlowingFluid.Properties TAR_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> TAR_FLUID.get(), () -> TAR_FLOWING.get(), FluidAttributes.builder(TAR_STILL_RL, TAR_FLOWING_RL)
			.density(30).luminosity(0).viscosity(10).sound(SoundEvents.LAVA_POP).overlay(TAR_OVERLAY_RL))
			.slopeFindDistance(2).levelDecreasePerBlock(2)
			.block(() -> DreamlandFluids.TAR_BLOCK.get()).bucket(() -> DreamlandItems.TAR_BUCKET.get());
	
	public static final RegistryObject<LiquidBlock> TAR_BLOCK = DreamlandBlocks.BLOCKS.register("tar",
			() -> new TarLiquidBlock(() -> DreamlandFluids.TAR_FLUID.get(),BlockBehaviour.Properties.of(Material.LAVA)
					.noCollission().strength(100f).noDrops()));
}
