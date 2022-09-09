package com.github.dragoni7.dreamland.client.render;

import com.github.dragoni7.dreamland.client.model.NecratheneBreatherArmorModel;
import com.github.dragoni7.dreamland.common.items.NecratheneBreatherArmorItem;

import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class NecratheneBreatherRenderer extends GeoArmorRenderer<NecratheneBreatherArmorItem> {

	public NecratheneBreatherRenderer() {
		super(new NecratheneBreatherArmorModel());
		
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
