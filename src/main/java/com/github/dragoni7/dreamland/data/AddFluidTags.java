package com.github.dragoni7.dreamland.data;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AddFluidTags extends FluidTagsProvider {

	public AddFluidTags(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, Dreamland.MODID, helper);
	}
	
	@Override
	protected void addTags() {
		tag(DreamlandFluidTags.TAR).add(DreamlandFluids.TAR_FLUID.get());
	}
	
	@Override
	public String getName() {
		return "Dreamland Fluid Tags";
	}

}
