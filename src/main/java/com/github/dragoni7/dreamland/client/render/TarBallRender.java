package com.github.dragoni7.dreamland.client.render;

import com.github.dragoni7.dreamland.client.models.TarBallModel;
import com.github.dragoni7.dreamland.common.entities.projectiles.TarBall;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class TarBallRender extends GeoProjectilesRenderer<TarBall> {

	public TarBallRender(Context renderManager) {
		super(renderManager, new TarBallModel());
	}
	
	@Override
	public RenderType getRenderType(TarBall animatable, float partialTicks, PoseStack stack,
			MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, 
			ResourceLocation textureLocation) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
	
}
