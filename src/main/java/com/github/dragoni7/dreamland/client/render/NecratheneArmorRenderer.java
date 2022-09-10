package com.github.dragoni7.dreamland.client.render;

import com.github.dragoni7.dreamland.client.model.NecratheneArmorModel;
import com.github.dragoni7.dreamland.common.items.NecratheneArmorItem;

import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class NecratheneArmorRenderer extends GeoArmorRenderer<NecratheneArmorItem> {

	public NecratheneArmorRenderer() {
		super(new NecratheneArmorModel());
		
		this.headBone = "helmet";
		this.bodyBone = "chestplate";
		this.rightArmBone = "rightArmArmor";
		this.leftArmBone = "leftArmArmor";
		this.rightLegBone = "leftLegArmor";
		this.leftLegBone = "rightLegArmor";
		this.rightBootBone = "leftBootArmor";
		this.leftBootBone = "rightBootArmor";
	}

}
