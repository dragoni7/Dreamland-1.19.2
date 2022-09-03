package com.github.dragoni7.dreamland.client.model;

import com.github.dragoni7.dreamland.common.entities.mobs.OpalShellEntity;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class OpalShellModel extends AnimatedGeoModel<OpalShellEntity> {

	@Override
	public ResourceLocation getAnimationResource(OpalShellEntity animatable) {
		return DreamlandLoc.createLoc("animations/opal_shell.anim.json");
	}

	@Override
	public ResourceLocation getModelResource(OpalShellEntity object) {
		
		if (object.isBaby()) {
			return DreamlandLoc.createLoc("geo/opal_shell_baby.geo.json");
		}
		return DreamlandLoc.createLoc("geo/opal_shell.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OpalShellEntity object) {
		
		switch (object.getOpalAmount()) {
			case 0: {
				return DreamlandLoc.createLoc("textures/entity/opal_shell_0.png");
			}
			case 1: {
				return DreamlandLoc.createLoc("textures/entity/opal_shell_1.png");
			}
			case 2: {
				return DreamlandLoc.createLoc("textures/entity/opal_shell_2.png");
			}
			case 3: {
				return DreamlandLoc.createLoc("textures/entity/opal_shell_3.png");
			}
			case 4: {
				return DreamlandLoc.createLoc("textures/entity/opal_shell_4.png");
			}
			default: {
				return DreamlandLoc.createLoc("textures/entity/opal_shell_0.png");
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setLivingAnimations(OpalShellEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("head");

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationY((extraData.netHeadYaw) * ((float) Math.PI / 360F));
	}

}
