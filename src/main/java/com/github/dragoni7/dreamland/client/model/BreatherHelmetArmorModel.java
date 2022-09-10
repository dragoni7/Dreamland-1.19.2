package com.github.dragoni7.dreamland.client.model;

import com.github.dragoni7.dreamland.common.items.BreatherHelmetArmorItem;
import com.github.dragoni7.dreamland.common.items.LarvaSymbioteArmorItem;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BreatherHelmetArmorModel extends AnimatedGeoModel<BreatherHelmetArmorItem> {

	@Override
	public ResourceLocation getAnimationResource(BreatherHelmetArmorItem animatable) {
		return DreamlandLoc.createLoc("animations/breather.anim.json");
	}

	@Override
	public ResourceLocation getModelResource(BreatherHelmetArmorItem object) {
		return DreamlandLoc.createLoc("geo/breather.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BreatherHelmetArmorItem object) {
		return DreamlandLoc.createLoc("textures/model/armor/breather.png");
	}

}
