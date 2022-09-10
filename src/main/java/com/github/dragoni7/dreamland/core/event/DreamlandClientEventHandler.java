package com.github.dragoni7.dreamland.core.event;

import com.github.dragoni7.dreamland.client.particles.GoldGlitterParticle;
import com.github.dragoni7.dreamland.client.particles.MidashroomSporesParticle;
import com.github.dragoni7.dreamland.client.particles.MoldSporesParticle;
import com.github.dragoni7.dreamland.client.particles.TarBubbleParticle;
import com.github.dragoni7.dreamland.client.particles.WhitePollenParticle;
import com.github.dragoni7.dreamland.client.render.*;
import com.github.dragoni7.dreamland.common.items.BreatherHelmetArmorItem;
import com.github.dragoni7.dreamland.common.items.LarvaSymbioteArmorItem;
import com.github.dragoni7.dreamland.common.items.NecratheneArmorItem;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.github.dragoni7.dreamland.core.registry.DreamlandParticles;
import com.github.dragoni7.dreamland.core.registry.DreamlandTiles;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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
		GeoArmorRenderer.registerArmorRenderer(BreatherHelmetArmorItem.class, new BreatherHelmetRenderer());
		GeoArmorRenderer.registerArmorRenderer(NecratheneArmorItem.class, new NecratheneArmorRenderer());
	}
	
	private static void registerBlockColors(final RegisterColorHandlersEvent.Block event) {
		final BlockColors blockColors = event.getBlockColors();
		blockColors.register((state, world, pos, tintIndex) -> BiomeColors.getAverageGrassColor(world, pos), DreamlandBlocks.TOXIC_GRASS.block().get());
	}
	
	private static void registerParticles(RegisterParticleProvidersEvent event) {
		event.register(DreamlandParticles.TAR_BUBBLE.get(), TarBubbleParticle.Provider::new);
		event.register(DreamlandParticles.WHITE_POLLEN.get(), WhitePollenParticle.Provider::new);
		event.register(DreamlandParticles.GOLD_GLITTER.get(), GoldGlitterParticle.Provider::new);
		event.register(DreamlandParticles.MIDASHROOM_SPORES.get(), MidashroomSporesParticle.Provider::new);
		event.register(DreamlandParticles.MOLD_SPORES.get(), MoldSporesParticle.Provider::new);
	}
}
