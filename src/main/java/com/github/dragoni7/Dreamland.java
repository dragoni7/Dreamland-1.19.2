package com.github.dragoni7;

import com.github.dragoni7.client.ClientModEventSubscriber;
import com.github.dragoni7.core.ModEventSubscriber;
import com.github.dragoni7.registry.DreamlandBlocks;
import com.github.dragoni7.registry.DreamlandFeatures;
import com.github.dragoni7.registry.DreamlandItems;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.api.distmarker.Dist;




@Mod(Dreamland.MODID)
public class Dreamland
{
	
	public static final String MODID = "dreamland";

    public Dreamland() {

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        
        forgeBus.register(this);
        DreamlandBlocks.BLOCKS.register(modBus);
        DreamlandItems.ITEMS.register(modBus);
        //DreamLandBiomes.BIOMES.register(modBus);
        ModEventSubscriber.subscribeModEvents(modBus, forgeBus);
        
        modBus.addListener(this::setup);
        
        if(FMLEnvironment.dist == Dist.CLIENT) {
    		ClientModEventSubscriber.subscribeClientEvents(modBus, forgeBus);
    	}

    }
    
    private void setup(FMLCommonSetupEvent event) {
    	event.enqueueWork( ()-> {
    		DreamlandFeatures.init();
    		
    	});
    }
    
    
    public static final CreativeModeTab DreamWorldTab = (new CreativeModeTab("dreamworld")  {
    	
    		@Override
    		public ItemStack makeIcon() {
    			return new ItemStack(DreamlandBlocks.BUMBLE_BLOCK.get());
    		
    		}
    	});

   
}
