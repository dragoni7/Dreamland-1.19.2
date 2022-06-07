package com.github.dragoni7.dreamland.core.event;

import com.github.dragoni7.dreamland.client.render.*;
import com.github.dragoni7.dreamland.common.entities.projectiles.TarBall;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class DreamlandClientEventHandler {

	
	public static void init(IEventBus modBus) {
		
		modBus.addListener(DreamlandClientEventHandler::registerEntityRenders);
		modBus.addListener(DreamlandClientEventHandler::registerBlockColors);
		modBus.addListener(DreamlandClientEventHandler::setupClient);
	}
	
	private static void setupClient(final FMLClientSetupEvent event) {
		
		
		event.enqueueWork(()-> {
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.BUMBLE_BLOCK.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.HIVE_JELLY_CLUSTER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.INFESTED_HIVE_JELLY_CLUSTER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.CLAY_SOIL_GRASS.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.DUSK_ICE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.HIVE_MEMBRANE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.CAVE_SLIME.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.CAVE_SLIME_PLANT.get(), RenderType.cutout());	
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.HIVE_GROWTH.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.JELLY_SPLOTCH.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.TAR_SPROUTS.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.TAR_BARK_LEAVES.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.PLUM_BIRCH_LEAVES.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.FLOWERING_UNDERGROWTH.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandWoodSets.PLUM_BIRCH.getDoor(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.OPALINE_MARIGOLD.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.PINK_CRAB_GRASS.get(), RenderType.cutout());
			
			ItemBlockRenderTypes.setRenderLayer(DreamlandFluids.TAR_BLOCK.get(), RenderType.solid());
			ItemBlockRenderTypes.setRenderLayer(DreamlandFluids.TAR_FLUID.get(), RenderType.solid());
			ItemBlockRenderTypes.setRenderLayer(DreamlandFluids.TAR_FLOWING.get(), RenderType.solid());
			
		});
	}
	
	private static void registerEntityRenders(final EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(DreamlandEntities.LARVA.get(), LarvaRender::new);
		event.registerEntityRenderer(DreamlandEntities.THROWN_HIVE_JELLY.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(DreamlandEntities.OOZE.get(), OozeRender::new);
		event.registerEntityRenderer(DreamlandEntities.TAR_BALL.get(), TarBallRender::new);
	}
	
	private static void registerBlockColors(final ColorHandlerEvent.Block event) {
		final BlockColors blockColors = event.getBlockColors();
		blockColors.register((state, world, pos, tintIndex) -> BiomeColors.getAverageGrassColor(world, pos), DreamlandBlocks.CLAY_SOIL_GRASS.get());
	}
}
