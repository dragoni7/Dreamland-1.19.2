package com.github.dragoni7.dreamland.client.render;

import com.github.dragoni7.dreamland.client.model.BreatherHelmetArmorModel;
import com.github.dragoni7.dreamland.common.items.BreatherHelmetArmorItem;

import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class BreatherHelmetRenderer extends GeoArmorRenderer<BreatherHelmetArmorItem> {

	public BreatherHelmetRenderer() {
		super(new BreatherHelmetArmorModel());
		
		this.headBone = "helmet";
		this.bodyBone = null;
		this.rightArmBone = null;
		this.leftArmBone = null;
		this.rightLegBone = null;
		this.leftLegBone = null;
		this.rightBootBone = null;
		this.leftBootBone = null;
	}

}
