package com.github.dragoni7.dreamland.client.models;

import com.github.dragoni7.dreamland.common.entities.projectiles.TarBall;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TarBallModel extends AnimatedGeoModel<TarBall> {

	@Override
	public ResourceLocation getAnimationFileLocation(TarBall animatable) {
		return DreamlandLoc.createLoc("animations/tar_ball.anim.json");
	}

	@Override
	public ResourceLocation getModelLocation(TarBall object) {
		return DreamlandLoc.createLoc("geo/tar_ball.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(TarBall object) {
		return DreamlandLoc.createLoc("textures/entity/tar_ball.png");
	}

}
