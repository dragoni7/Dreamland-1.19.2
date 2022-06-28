package com.github.dragoni7.dreamland.core.event;

import com.github.dragoni7.dreamland.client.particles.TarBubbleParticle;
import com.github.dragoni7.dreamland.client.particles.WhitePollenParticle;
import com.github.dragoni7.dreamland.client.render.*;
import com.github.dragoni7.dreamland.common.items.LarvaSymbioteArmorItem;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.github.dragoni7.dreamland.core.registry.DreamlandParticles;
import com.github.dragoni7.dreamland.core.registry.DreamlandTiles;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class DreamlandClientEventHandler {

	
	public static void init(IEventBus modBus) {
		
		modBus.addListener(DreamlandClientEventHandler::registerEntityRenders);
		modBus.addListener(DreamlandClientEventHandler::registerArmorRenders);
		modBus.addListener(DreamlandClientEventHandler::registerBlockColors);
		modBus.addListener(DreamlandClientEventHandler::setupClient);
		modBus.addListener(DreamlandClientEventHandler::registerParticles);
	}
	
	private static void setupClient(final FMLClientSetupEvent event) {
		event.enqueueWork(()-> {
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.BUMBLE_BLOCK.block().get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.HIVE_JELLY_CLUSTER.block().get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.INFESTED_HIVE_JELLY_CLUSTER.block().get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.CLAY_SOIL_GRASS.block().get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.DUSK_ICE.block().get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.HIVE_MEMBRANE.block().get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.CAVE_SLIME.block().get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.CAVE_SLIME_PLANT.get(), RenderType.cutout());	
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.HIVE_GROWTH.block().get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.JELLY_SPLOTCH.get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.TAR_SPROUTS.block().get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.TAR_BARK_LEAVES.block().get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.PLUM_BIRCH_LEAVES.block().get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.FLOWERING_GRASS.block().get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandWoodSets.PLUM_BIRCH.door().block().get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(DreamlandWoodSets.PLUM_BIRCH.ladder().block().get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.OPALINE_MARIGOLD.block().get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.PINK_CRAB_GRASS.block().get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.FLOWERING_UNDERGROWTH.block().get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.OPAL_DIFFUSER_BLOCK.block().get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.PLUM_BIRCH_SHRUB.block().get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandWoodSets.TAR_BARK.door().block().get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(DreamlandWoodSets.TAR_BARK.ladder().block().get(), RenderType.cutoutMipped());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.PLUM_BIRCH_SAPLING.block().get(), RenderType.cutout());
			ItemBlockRenderTypes.setRenderLayer(DreamlandBlocks.TAR_BARK_SAPLING.block().get(), RenderType.cutout());
			
			ItemBlockRenderTypes.setRenderLayer(DreamlandFluids.TAR_BLOCK.get(), RenderType.solid());
			
			ItemBlockRenderTypes.setRenderLayer(DreamlandFluids.TAR_FLUID.get(), RenderType.solid());
			ItemBlockRenderTypes.setRenderLayer(DreamlandFluids.TAR_FLOWING.get(), RenderType.solid());
			
		});
	}
	
	private static void registerEntityRenders(final EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(DreamlandEntities.BUMBLE_BEAST.get(), BumbleBeastRender::new);
		event.registerEntityRenderer(DreamlandEntities.LARVA.get(), LarvaRender::new);
		event.registerEntityRenderer(DreamlandEntities.THROWN_HIVE_JELLY.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(DreamlandEntities.OOZE.get(), OozeRender::new);
		event.registerEntityRenderer(DreamlandEntities.OPAL_SHELL.get(), OpalShellRender::new);
		event.registerEntityRenderer(DreamlandEntities.TAR_BALL.get(), TarBallRender::new);
		event.registerBlockEntityRenderer(DreamlandTiles.ANCIENT_EGG.get(), AncientEggRender::new);
	}
	
	private static void registerArmorRenders(final EntityRenderersEvent.AddLayers event) {
		GeoArmorRenderer.registerArmorRenderer(LarvaSymbioteArmorItem.class, new LarvaSymbioteRenderer());
	}
	
	private static void registerBlockColors(final ColorHandlerEvent.Block event) {
		final BlockColors blockColors = event.getBlockColors();
		blockColors.register((state, world, pos, tintIndex) -> BiomeColors.getAverageGrassColor(world, pos), DreamlandBlocks.CLAY_SOIL_GRASS.block().get());
	}
	
	@SuppressWarnings("resource")
	private static void registerParticles(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particleEngine.register(DreamlandParticles.TAR_BUBBLE.get(), TarBubbleParticle.Provider::new);
		Minecraft.getInstance().particleEngine.register(DreamlandParticles.WHITE_POLLEN.get(), WhitePollenParticle.Provider::new);
	}
}
