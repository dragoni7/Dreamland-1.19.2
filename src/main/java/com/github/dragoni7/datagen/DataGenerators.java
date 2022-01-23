package com.github.dragoni7.datagen;

import com.github.dragoni7.Dreamland;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		
		DataGenerator generator = event.getGenerator();
		
		DreamlandBlockTags blockTags = new DreamlandBlockTags(event.getGenerator(), event.getExistingFileHelper());
        event.getGenerator().addProvider(blockTags);
		
		if(event.includeClient()) {
			generator.addProvider(new BlockStates(generator, Dreamland.MODID, event.getExistingFileHelper()));
			generator.addProvider(new ItemModels(generator, Dreamland.MODID, event.getExistingFileHelper()));
			
		}
		
		
        
	}

}
