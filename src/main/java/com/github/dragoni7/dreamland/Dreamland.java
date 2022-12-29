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
import com.github.dragoni7.dreamland.core.registry.DreamlandFeatures;
import com.github.dragoni7.dreamland.core.registry.DreamlandFluids;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;
import com.github.dragoni7.dreamland.core.registry.DreamlandParticles;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
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
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib3.GeckoLib;
import net.minecraftforge.api.distmarker.Dist;

@Mod(Dreamland.MODID)
public class Dreamland
{
	public static final String MODID = "dreamland";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Dreamland.MODID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Dreamland.MODID);
	
    public Dreamland() {
    	
    	// register configs.
    	ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
    	ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
    	
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        
        GeckoLib.initialize();
        
        forgeBus.register(this);
        
        // register mod content.
        DreamlandWoodSets.init();
        DreamlandBlocks.init();
        DreamlandItems.init();
        BLOCKS.register(modBus);
        ITEMS.register(modBus);
        DreamlandFluids.FLUIDS.register(modBus);
        DreamlandEffects.MOB_EFFECTS.register(modBus);
        DreamlandEntities.ENTITY_TYPES.register(modBus);
        DreamlandFluids.FLUID_TYPES.register(modBus);
        DreamlandTiles.TILES.register(modBus);
        DreamlandSoundEvents.SOUND_EVENTS.register(modBus);
        DreamlandSoundTypes.init();
        DreamlandParticles.PARTICLES.register(modBus);
        
        modBus.addListener(this::commonSetup);
        DreamlandEventHandler.init(modBus, forgeBus);
        
        if(FMLEnvironment.dist == Dist.CLIENT) {
        	DreamlandClientEventHandler.init(modBus);
        }
    }
    
    private void commonSetup(FMLCommonSetupEvent event) {
    	
    	// Fluid interactions.
    	FluidInteractionRegistry.addInteraction(DreamlandFluids.TAR_FLUID_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(ForgeMod.LAVA_TYPE.get(), DreamlandBlocks.DRIED_TAR.block().get().defaultBlockState()));
    	FluidInteractionRegistry.addInteraction(DreamlandFluids.TAR_FLUID_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(ForgeMod.WATER_TYPE.get(), DreamlandBlocks.TAR_MUD.block().get().defaultBlockState()));
    	
    	event.enqueueWork( ()-> {
    		Networking.registerMessages();
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Dreamland.MODID, DreamlandSurfaceRules.OVERWORLD_SURFACE_RULES);
    		Regions.register(new DreamlandRegion(DreamlandLoc.createLoc("dreamland_region"), RegionType.OVERWORLD, Config.REGION_WEIGHT.get()));
    	});
    }
    
    public static final CreativeModeTab DreamlandTab = (new CreativeModeTab("dreamland")  {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(DreamlandItems.LARVA_HELMET.get());
		}
	});
}
