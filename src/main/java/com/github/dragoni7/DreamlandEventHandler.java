package com.github.dragoni7;


import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class DreamlandEventHandler {

	public static void subscribeModEvents(IEventBus modBus) {
		
			modBus.addListener(DreamlandEventHandler::addAttributes);
			
		}
		
		public static void addAttributes(final EntityAttributeCreationEvent event) {
		}
		public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
		}
}
