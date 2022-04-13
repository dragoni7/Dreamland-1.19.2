package com.github.dragoni7.dreamland.client.render;

import com.github.dragoni7.dreamland.common.entities.mobs.LarvaEntity;
import com.github.dragoni7.dreamland.util.DreamlandLoc;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class LarvaEyesFeatureRenderer extends GeoLayerRenderer<LarvaEntity> {
	
	private final LarvaEyesEntityRenderer larvaEyesEntityRenderer;
	
	private ResourceLocation larvaLayer = DreamlandLoc.createLoc("textures/entity/larva_layer.png");

	public LarvaEyesFeatureRenderer(IGeoRenderer<LarvaEntity> entityRendererIn, LarvaEyesEntityRenderer larvaEyesEntityRenderer) {
		super(entityRendererIn);
		this.larvaEyesEntityRenderer = larvaEyesEntityRenderer;
	}

	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn,
			LarvaEntity larvaEntity, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch) {
		larvaEyesEntityRenderer.render(getEntityModel().getModel(getEntityModel().getModelLocation(larvaEntity)),
				larvaEntity, partialTicks, RenderType.eyes(larvaLayer), matrixStackIn, bufferIn, bufferIn.getBuffer(RenderType.eyes(larvaLayer)), 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	}

}
