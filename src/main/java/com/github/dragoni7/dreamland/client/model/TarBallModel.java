package com.github.dragoni7.dreamland.client.model;

import com.github.dragoni7.dreamland.common.entities.projectiles.TarBall;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TarBallModel extends AnimatedGeoModel<TarBall> {

	@Override
	public ResourceLocation getAnimationResource(TarBall animatable) {
		return DreamlandLoc.createLoc("animations/tar_ball.anim.json");
	}

	@Override
	public ResourceLocation getModelResource(TarBall object) {
		return DreamlandLoc.createLoc("geo/tar_ball.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TarBall object) {
		return DreamlandLoc.createLoc("textures/entity/tar_ball.png");
	}

}
