package com.github.dragoni7.dreamland.client.render;

import com.github.dragoni7.dreamland.common.entities.mobs.BumbleBeastEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BumbleBeastEyeEntityRenderer extends GeoEntityRenderer<BumbleBeastEntity> {
	public BumbleBeastEyeEntityRenderer(Context renderManager, AnimatedGeoModel<BumbleBeastEntity> modelProvider) {
		super(renderManager, modelProvider);
	}
}
