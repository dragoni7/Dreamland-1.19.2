package com.github.dragoni7.dreamland.client.render;

import com.github.dragoni7.dreamland.client.model.AncientEggModel;
import com.github.dragoni7.dreamland.common.blocks.tiles.AncientEggTile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class AncientEggRender extends GeoBlockRenderer<AncientEggTile> {

	public AncientEggRender(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		super(rendererDispatcherIn, new AncientEggModel());
	}
	
	@Override
	public RenderType getRenderType(AncientEggTile animatable, float partialTicks, PoseStack stack,
			MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.entityCutout(getTextureLocation(animatable));
	}

}
