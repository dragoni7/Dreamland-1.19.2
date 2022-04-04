package com.github.dragoni7;


import com.github.dragoni7.common.entities.DreamlandEntities;
import com.github.dragoni7.common.entities.LarvaEntity;

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
