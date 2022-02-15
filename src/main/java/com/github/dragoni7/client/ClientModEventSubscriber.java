package com.github.dragoni7.client;

import com.github.dragoni7.client.particle.WhiteMoldParticle;
import com.github.dragoni7.registry.DreamlandBlocks;
import com.github.dragoni7.registry.DreamlandParticles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.ParticleUtils;
import net.minecraft.client.renderer.BiomeColors;

public class ClientModEventSubscriber {

	
	public static void subscribeClientEvents(IEventBus modBus, IEventBus forgeBus) {
		
		modBus.addListener(ClientModEventSubscriber::registerEntityRenders);
		modBus.addListener(ClientModEventSubscriber::registerBlockColors);
		modBus.addListener(ClientModEventSubscriber::setupClient);
		modBus.addListener(ClientModEventSubscriber::registerParticleFactory);
	}
	
	public static void registerEntityRenders(final EntityRenderersEvent.RegisterRenderers event) {	
	}
	
	public static void setupClient(FMLClientSetupEvent event) {
		event.enqueueWork(()-> {
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.BUMBLE_BLOCK.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.HIVE_JELLY.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.CLAY_SOIL_GRASS.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.DUSK_ICE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.CAVE_SLIME.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.CAVE_SLIME_PLANT.get(), RenderType.translucent());	
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.WHITE_MOLD.get(), RenderType.cutout());
		});
	}
	
	public static void registerBlockColors(final ColorHandlerEvent.Block event) {
		final BlockColors blockColors = event.getBlockColors();
		blockColors.register((state, world, pos, tintIndex) -> BiomeColors.getAverageGrassColor(world, pos), DreamlandBlocks.CLAY_SOIL_GRASS.get());
	}
	
	@SuppressWarnings("resource")
	public static void registerParticleFactory(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particleEngine.register(DreamlandParticles.WHITE_MOLD_PARTICLE.get(), WhiteMoldParticle.Factory::new);
	}
}
