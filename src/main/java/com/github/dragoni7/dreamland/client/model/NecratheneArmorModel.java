package com.github.dragoni7.dreamland.client.model;

import com.github.dragoni7.dreamland.common.items.NecratheneArmorItem;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NecratheneArmorModel extends AnimatedGeoModel<NecratheneArmorItem> {

	@Override
	public ResourceLocation getAnimationResource(NecratheneArmorItem animatable) {
		return DreamlandLoc.createLoc("animations/breather.anim.json");
	}

	@Override
	public ResourceLocation getModelResource(NecratheneArmorItem object) {
		return DreamlandLoc.createLoc("geo/necrathene_armor.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(NecratheneArmorItem object) {
		return DreamlandLoc.createLoc("textures/model/armor/necrathene_armor.png");
	}
}
