package com.github.dragoni7.dreamland.client.model;

import com.github.dragoni7.dreamland.common.entities.mobs.OpalShellEntity;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OpalShellModel extends AnimatedGeoModel<OpalShellEntity> {

	@Override
	public ResourceLocation getAnimationResource(OpalShellEntity animatable) {
		return DreamlandLoc.createLoc("animations/opal_shell.anim.json");
	}

	@Override
	public ResourceLocation getModelResource(OpalShellEntity object) {
		return DreamlandLoc.createLoc("geo/opal_shell.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OpalShellEntity object) {
		return DreamlandLoc.createLoc("textures/entity/opal_shell.png");
	}

}
