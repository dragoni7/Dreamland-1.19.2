package com.github.dragoni7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.dragoni7.client.DreamlandClientEventHandler;
import com.github.dragoni7.common.blocks.DreamlandBlocks;
import com.github.dragoni7.common.entities.DreamlandEntities;
import com.github.dragoni7.common.items.DreamlandItems;
import com.github.dragoni7.common.world.DreamlandRegion;
import com.github.dragoni7.common.world.DreamlandSurfaceRules;
import com.github.dragoni7.util.DreamlandLoc;

import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
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
	
	public static final Logger LOGGER = LogManager.getLogger();

    public Dreamland() {

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        
        GeckoLib.initialize();
        
        forgeBus.register(this);
        
        DreamlandEntities.ENTITY_TYPES.register(modBus);
        DreamlandBlocks.BLOCKS.register(modBus);
        DreamlandItems.ITEMS.register(modBus);
        DreamlandEventHandler.subscribeModEvents(modBus);
        modBus.addListener(this::commonSetup);
        
        if(FMLEnvironment.dist == Dist.CLIENT) {
    		DreamlandClientEventHandler.subscribeClientEvents(modBus, forgeBus);
    	}
        
    }
    
    private void commonSetup(FMLCommonSetupEvent event) {
    	event.enqueueWork( ()-> {
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Dreamland.MODID, DreamlandSurfaceRules.OVERWORLD_SURFACE_RULES);
    		Regions.register(new DreamlandRegion(DreamlandLoc.createLoc("dreamland_region"), RegionType.OVERWORLD, 4));
    	});
    }
    
    
    public static final CreativeModeTab DreamlandTab = (new CreativeModeTab("dreamland")  {
    		@Override
    		public ItemStack makeIcon() {
    			return new ItemStack(DreamlandBlocks.HIVE_JELLY_CLUSTER.get());
    		}
    	});

   
}
