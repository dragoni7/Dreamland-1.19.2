package com.github.dragoni7.dreamland.core;


import com.github.dragoni7.dreamland.common.entities.mobs.LarvaEntity;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class DreamlandEventHandler {

	public static void subscribeModEvents(IEventBus modBus) {
		
		modBus.addListener(DreamlandEventHandler::addAttributes);
	}
		
	public static void addAttributes(final EntityAttributeCreationEvent event) {
		event.put(DreamlandEntities.LARVA.get(), LarvaEntity.customAttributes().build());
	}
}
