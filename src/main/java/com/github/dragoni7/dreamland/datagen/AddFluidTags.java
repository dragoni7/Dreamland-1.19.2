package com.github.dragoni7.dreamland.datagen;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.core.DreamlandFluids;

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
		
		tag(FluidTags.WATER)
		.add(DreamlandFluids.TAR_FLUID.get())
		.add(DreamlandFluids.TAR_FLOWING.get());
	}
	
	@Override
	public String getName() {
		return "Dreamland Fluid Tags";
	}

}
