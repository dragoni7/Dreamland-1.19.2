package com.github.dragoni7.dreamland.client.render;

import com.github.dragoni7.dreamland.client.model.LarvaSymbioteArmorModel;
import com.github.dragoni7.dreamland.common.items.LarvaSymbioteArmorItem;

import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class LarvaSymbioteRenderer extends GeoArmorRenderer<LarvaSymbioteArmorItem> {

	public LarvaSymbioteRenderer() {
		super(new LarvaSymbioteArmorModel());
		
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
