package com.github.dragoni7.dreamland.client.render;

import com.github.dragoni7.dreamland.client.model.BumbleBeastModel;
import com.github.dragoni7.dreamland.common.entities.mobs.BumbleBeastEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BumbleBeastRender extends GeoEntityRenderer<BumbleBeastEntity> {

	public BumbleBeastRender(Context renderManager) {
		super(renderManager, new BumbleBeastModel());
	}
	
	@Override
	public RenderType getRenderType(BumbleBeastEntity animatable, float partialTicks, PoseStack stack,
			MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			ResourceLocation texureLocation) {
		return RenderType.entityCutoutNoCull(getTextureLocation(animatable));
	}
}
