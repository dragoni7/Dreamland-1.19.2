package com.github.dragoni7.dreamland.client.models;

import com.github.dragoni7.dreamland.common.blocks.hivecocoon.HiveCocoonTile;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HiveCocoonModel extends AnimatedGeoModel<HiveCocoonTile>{
	
	@Override
	public ResourceLocation getAnimationFileLocation(HiveCocoonTile animatable) {
		return DreamlandLoc.createLoc("animations/hive_cocoon.anim.json");
	}

	@Override
	public ResourceLocation getModelLocation(HiveCocoonTile animatable) {
		return DreamlandLoc.createLoc("geo/hive_cocoon.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(HiveCocoonTile entity) {
		return DreamlandLoc.createLoc("textures/block/hive_cocoon.png");
	}
}
