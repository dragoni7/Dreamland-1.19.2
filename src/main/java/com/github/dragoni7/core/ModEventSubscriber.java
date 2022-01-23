package com.github.dragoni7.core;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModEventSubscriber {

	public static void subscribeModEvents(IEventBus modBus, IEventBus forgeBus) {
		
			modBus.addListener(ModEventSubscriber::addAttributes);
		}
		public static void addAttributes(final EntityAttributeCreationEvent event) {
			
		}
		public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
		
		}
}
