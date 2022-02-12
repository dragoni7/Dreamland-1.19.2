package com.github.dragoni7;

import com.github.dragoni7.client.ClientModEventSubscriber;
import com.github.dragoni7.core.ModEventSubscriber;
import com.github.dragoni7.registry.DreamlandBlocks;
import com.github.dragoni7.registry.DreamlandFeatures;
import com.github.dragoni7.registry.DreamlandItems;
import com.github.dragoni7.worldgen.DreamlandBiomeProvider;

import terrablender.api.BiomeProviders;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import software.bernie.geckolib3.GeckoLib;
import net.minecraftforge.api.distmarker.Dist;

@Mod(Dreamland.MODID)
public class Dreamland
{
	
	public static final String MODID = "dreamland";

    public Dreamland() {

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        
        GeckoLib.initialize();
        
        forgeBus.register(this);
        DreamlandBlocks.BLOCKS.register(modBus);
        DreamlandItems.ITEMS.register(modBus);
        ModEventSubscriber.subscribeModEvents(modBus, forgeBus);
        
        modBus.addListener(this::setup);
        
        if(FMLEnvironment.dist == Dist.CLIENT) {
    		ClientModEventSubscriber.subscribeClientEvents(modBus, forgeBus);
    	}

    }
    
    private void setup(FMLCommonSetupEvent event) {
    	event.enqueueWork( ()-> {
    		BiomeProviders.register(new DreamlandBiomeProvider(new ResourceLocation(MODID, "biome_provider"), 4));
    		DreamlandFeatures.init();	
    	});
    }
    
    
    public static final CreativeModeTab DreamlandTab = (new CreativeModeTab("dreamland")  {
    		@Override
    		public ItemStack makeIcon() {
    			return new ItemStack(DreamlandBlocks.HIVE_JELLY.get());
    		}
    	});

   
}
