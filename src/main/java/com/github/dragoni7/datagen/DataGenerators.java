package com.github.dragoni7.datagen;

import com.github.dragoni7.Dreamland;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
        
		if(event.includeServer()) {
			generator.addProvider(new DreamlandRecipes(generator));
			generator.addProvider(new LootTables(generator));
	        generator.addProvider(new AddBlockTags(generator, fileHelper));
	        //generator.addProvider(new AddItemTags(generator, null, fileHelper));
		}
		if(event.includeClient()) {
			generator.addProvider(new BlockStates(generator, Dreamland.MODID, fileHelper));
			generator.addProvider(new ItemModels(generator, Dreamland.MODID, fileHelper));
			generator.addProvider(new DreamlandLanguageProvider(generator,"en_us"));
			
		}
		
		
        
	}

}
