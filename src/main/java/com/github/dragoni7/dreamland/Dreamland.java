package com.github.dragoni7.dreamland;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.dragoni7.dreamland.common.world.DreamlandRegion;
import com.github.dragoni7.dreamland.common.world.DreamlandSurfaceRules;
import com.github.dragoni7.dreamland.core.event.DreamlandClientEventHandler;
import com.github.dragoni7.dreamland.core.event.DreamlandEventHandler;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandEffects;
import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.github.dragoni7.dreamland.network.DreamlandNetworking;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.WoodType;
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
        DreamlandFluids.FLUIDS.register(modBus);
        DreamlandItems.ITEMS.register(modBus);
        DreamlandWoodSets.init();
        DreamlandEntities.TILES.register(modBus);
        DreamlandEntities.CONTAINERS.register(modBus);
        DreamlandEffects.MOB_EFFECTS.register(modBus);
        DreamlandEventHandler.init(modBus, forgeBus);
        modBus.addListener(this::commonSetup);
        
        if(FMLEnvironment.dist == Dist.CLIENT) {
    		DreamlandClientEventHandler.init(modBus);
    	}
        
    }
    
    private void commonSetup(FMLCommonSetupEvent event) {
    	event.enqueueWork( ()-> {
    		DreamlandNetworking.registerMessages();
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Dreamland.MODID, DreamlandSurfaceRules.OVERWORLD_SURFACE_RULES);
    		Regions.register(new DreamlandRegion(DreamlandLoc.createLoc("dreamland_region"), RegionType.OVERWORLD, 2));
    	});
    }
    
    
    public static final CreativeModeTab DreamlandTab = (new CreativeModeTab("dreamland")  {
    		@Override
    		public ItemStack makeIcon() {
    			return new ItemStack(DreamlandBlocks.HIVE_BLOCK.get());
    		}
    	});

   
}
