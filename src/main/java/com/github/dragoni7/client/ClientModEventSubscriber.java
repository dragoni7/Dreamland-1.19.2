package com.github.dragoni7.client;

import com.github.dragoni7.registry.DreamlandBlocks;

import net.minecraft.client.color.block.BlockColors;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.BiomeColors;

public class ClientModEventSubscriber {

	
	public static void subscribeClientEvents(IEventBus modBus, IEventBus forgeBus) {
		
		modBus.addListener(ClientModEventSubscriber::registerEntityRenders);
		modBus.addListener(ClientModEventSubscriber::registerBlockColors);
		modBus.addListener(ClientModEventSubscriber::setupClient);
		
	}
	
	public static void registerEntityRenders(final EntityRenderersEvent.RegisterRenderers event) {
		
	}
	
	public static void setupClient(FMLClientSetupEvent event) {
		event.enqueueWork(()-> {
			
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.BUMBLE_BLOCK.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.CLAY_SOIL_GRASS.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.DUSK_ICE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.CAVE_SLIME.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.CAVE_SLIME_PLANT.get(), RenderType.translucent());
		
			
		});
		
	}
	
	public static void registerBlockColors(final ColorHandlerEvent.Block event) {
		final BlockColors blockColors = event.getBlockColors();
		blockColors.register((state, world, pos, tintIndex) -> BiomeColors.getAverageGrassColor(world, pos), DreamlandBlocks.CLAY_SOIL_GRASS.get());
		
	}
	
	
}
