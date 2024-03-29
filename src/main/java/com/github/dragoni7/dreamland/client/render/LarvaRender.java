package com.github.dragoni7.dreamland.client.render;

import com.github.dragoni7.dreamland.client.model.LarvaModel;
import com.github.dragoni7.dreamland.common.entities.mobs.LarvaEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class LarvaRender extends GeoEntityRenderer<LarvaEntity> {

	public LarvaRender(Context renderManager) {
		super(renderManager, new LarvaModel());
		this.addLayer(new LarvaEyesFeatureRenderer(this, new LarvaEyesEntityRenderer(renderManager, new LarvaModel())));
	}
	
	@Override
	public RenderType getRenderType(LarvaEntity animatable, float partialTicks, PoseStack stack,
			MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			ResourceLocation texureLocation) {
		return RenderType.entityCutout(getTextureLocation(animatable));
	}
	
	@Override
	protected float getDeathMaxRotation(LarvaEntity entityLivingBaseIn) {
		return 0.0F;
	}

}
