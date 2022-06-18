package com.github.dragoni7.dreamland;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.dragoni7.dreamland.common.world.DreamlandRegion;
import com.github.dragoni7.dreamland.common.world.DreamlandSurfaceRules;
import com.github.dragoni7.dreamland.core.Config;
import com.github.dragoni7.dreamland.core.event.DreamlandClientEventHandler;
import com.github.dragoni7.dreamland.core.event.DreamlandEventHandler;
import com.github.dragoni7.dreamland.core.registry.DreamlandBiomes;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandEffects;
import com.github.dragoni7.dreamland.core.registry.DreamlandEntities;
import com.github.dragoni7.dreamland.core.registry.DreamlandFeatures;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;
import com.github.dragoni7.dreamland.core.registry.DreamlandSoundEvents;
import com.github.dragoni7.dreamland.core.registry.DreamlandSoundTypes;
import com.github.dragoni7.dreamland.core.registry.DreamlandTiles;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.github.dragoni7.dreamland.network.Networking;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib3.GeckoLib;
import net.minecraftforge.api.distmarker.Dist;

@Mod(Dreamland.MODID)
public class Dreamland
{
	
	public static final String MODID = "dreamland";
	
	public static final Logger LOGGER = LogManager.getLogger();
	
    public Dreamland() {
    	
    	ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
    	
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        
        GeckoLib.initialize();
        
        forgeBus.register(this);

        DreamlandSoundEvents.SOUND_EVENTS.register(modBus);
        DreamlandSoundTypes.init();
        DreamlandEntities.ENTITY_TYPES.register(modBus);
        DreamlandBlocks.BLOCKS.register(modBus);
        DreamlandTiles.TILES.register(modBus);
        DreamlandFluids.FLUID_TYPES.register(modBus);
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
    	
    	FluidInteractionRegistry.addInteraction(DreamlandFluids.TAR_FLUID_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(ForgeMod.LAVA_TYPE.get(), DreamlandBlocks.DRIED_TAR.block().get().defaultBlockState()));
    	FluidInteractionRegistry.addInteraction(DreamlandFluids.TAR_FLUID_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(ForgeMod.WATER_TYPE.get(), DreamlandBlocks.TAR_MUD.block().get().defaultBlockState()));
    	
    	event.enqueueWork( ()-> {
    		
    		ForgeRegistries.FLUIDS.forEach(fluid -> 
    		LOGGER.info("Fluid {} has FluidType {}", ForgeRegistries.FLUIDS.getKey(fluid), ForgeRegistries.FLUID_TYPES.get().getKey(fluid.getFluidType()))
    		);
    		
    		Networking.registerMessages();
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Dreamland.MODID, DreamlandSurfaceRules.OVERWORLD_SURFACE_RULES);
    		Regions.register(new DreamlandRegion(DreamlandLoc.createLoc("dreamland_region"), RegionType.OVERWORLD, Config.REGION_WEIGHT.get()));
    	});
    }
    
    
    public static final CreativeModeTab DreamlandTab = (new CreativeModeTab("dreamland")  {
    		@Override
    		public ItemStack makeIcon() {
    			return new ItemStack(DreamlandBlocks.HIVE_BLOCK.block().get());
    		}
    	});

   
}
