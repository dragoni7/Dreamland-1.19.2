package com.github.dragoni7.dreamland.client.render;

import com.github.dragoni7.dreamland.client.model.OpalShellModel;
import com.github.dragoni7.dreamland.common.entities.mobs.OpalShellEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class OpalShellRender extends GeoEntityRenderer<OpalShellEntity> {

	public OpalShellRender(Context renderManager) {
		super(renderManager, new OpalShellModel());
	}
	
	@Override
	public RenderType getRenderType(OpalShellEntity animatable, float partialTicks, PoseStack stack,
			MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			ResourceLocation texureLocation) {
		return RenderType.entityCutout(getTextureLocation(animatable));
	}

}
