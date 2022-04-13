package com.github.dragoni7.dreamland.client.render;

import com.github.dragoni7.dreamland.client.models.HiveCocoonModel;
import com.github.dragoni7.dreamland.common.blocks.hivecocoon.HiveCocoonTile;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class HiveCocoonTileRenderer extends GeoBlockRenderer<HiveCocoonTile>{

	public HiveCocoonTileRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		super(rendererDispatcherIn, new HiveCocoonModel());
	}

}