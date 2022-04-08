package com.github.dragoni7.client.render;

import com.github.dragoni7.common.entities.LarvaEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class LarvaEyesEntityRenderer extends GeoEntityRenderer<LarvaEntity>{

	public LarvaEyesEntityRenderer(Context renderManager, AnimatedGeoModel<LarvaEntity> modelProvider) {
		super(renderManager, modelProvider);
	}

}
