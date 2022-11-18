package com.github.dragoni7.dreamland.client.render;

import com.github.dragoni7.dreamland.common.entities.mobs.BumbleBeastEntity;
import com.github.dragoni7.dreamland.util.DreamlandLoc;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class BumbleBeastEyeFeatureRenderer extends GeoLayerRenderer<BumbleBeastEntity> {
	private final BumbleBeastEyeEntityRenderer bumbleBeastEyeRenderer;
	private ResourceLocation bumbleBeastAngryLayer = DreamlandLoc.createLoc("textures/entity/bumble_beast_angry_layer.png");

	public BumbleBeastEyeFeatureRenderer(IGeoRenderer<BumbleBeastEntity> entityRendererIn, BumbleBeastEyeEntityRenderer eyesEntityRenderer) {
		super(entityRendererIn);
		this.bumbleBeastEyeRenderer = eyesEntityRenderer;
	}

	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, BumbleBeastEntity bumbleBeastEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {		
		if (bumbleBeastEntity.isAngry()) {
			bumbleBeastEyeRenderer.render(getEntityModel().getModel(getEntityModel().getModelResource(bumbleBeastEntity)),
					bumbleBeastEntity, partialTicks, RenderType.eyes(bumbleBeastAngryLayer), matrixStackIn, bufferIn, bufferIn.getBuffer(RenderType.eyes(bumbleBeastAngryLayer)), 15728640, OverlayTexture.RED_OVERLAY_V, 1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
