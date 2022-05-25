package com.github.dragoni7.dreamland.client.render;

import com.github.dragoni7.dreamland.client.models.OozeModel;
import com.github.dragoni7.dreamland.common.entities.mobs.OozeEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class OozeRender extends GeoEntityRenderer<OozeEntity> {

	public OozeRender(Context renderManager) {
		super(renderManager, new OozeModel());
	}
	
	@Override
	public RenderType getRenderType(OozeEntity animatable, float partialTicks, PoseStack stack,
			MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			ResourceLocation texureLocation) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
