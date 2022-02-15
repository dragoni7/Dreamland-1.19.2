package com.github.dragoni7;

import java.util.Collection;
import java.util.function.Supplier;

import com.github.dragoni7.client.ClientModEventSubscriber;
import com.github.dragoni7.common.world.biome.DreamlandBiomeProvider;
import com.github.dragoni7.common.world.feature.FeaturePlacements;
import com.github.dragoni7.core.ModEventSubscriber;
import com.github.dragoni7.registry.DreamlandBlocks;
import com.github.dragoni7.registry.DreamlandFeatures;
import com.github.dragoni7.registry.ConfiguredDreamlandFeatures;
import com.github.dragoni7.registry.DreamlandBiomes;
import com.github.dragoni7.registry.DreamlandItems;
import com.github.dragoni7.registry.DreamlandParticles;
import com.github.dragoni7.util.RegistryObject;

import terrablender.api.BiomeProviders;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.IForgeRegistryEntry;
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
        DreamlandParticles.PARTICLE_TYPES.register(modBus);
        DreamlandBlocks.BLOCKS.register(modBus);
        DreamlandItems.ITEMS.register(modBus);
        DLregister(Feature.class, modBus, ()-> DreamlandFeatures.init());
        DLregister(Biome.class, modBus, () -> DreamlandBiomes.init());
        ModEventSubscriber.subscribeModEvents(modBus, forgeBus);
        modBus.addListener(this::setup);
        
        if(FMLEnvironment.dist == Dist.CLIENT) {
    		ClientModEventSubscriber.subscribeClientEvents(modBus, forgeBus);
    	}

    }
    
 // Credits to potionstudios, BYG.
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private <T extends IForgeRegistryEntry<T>> void DLregister(Class c, IEventBus eventBus, Supplier<Collection<RegistryObject<T>>> registryObjectsSupplier) {
    	eventBus.addGenericListener(c, (RegistryEvent.Register<T> event) -> {
    		Collection<RegistryObject<T>> registryObjects = registryObjectsSupplier.get();
    		for(RegistryObject<T> registryObject : registryObjects) {
    			registryObject.object().setRegistryName(new ResourceLocation(Dreamland.MODID, registryObject.name()));
    			event.getRegistry().register(registryObject.object());
    		}
    	});
    }
    
    private void setup(FMLCommonSetupEvent event) {
    	event.enqueueWork( ()-> {
    		BiomeProviders.register(new DreamlandBiomeProvider(new ResourceLocation(MODID, "biome_provider"), 4));
    		ConfiguredDreamlandFeatures.init();
    		FeaturePlacements.init();
    	});
    }
    
    
    public static final CreativeModeTab DreamlandTab = (new CreativeModeTab("dreamland")  {
    		@Override
    		public ItemStack makeIcon() {
    			return new ItemStack(DreamlandBlocks.HIVE_JELLY.get());
    		}
    	});

   
}
