package com.github.dragoni7.registry;

import com.github.dragoni7.util.TagFactory;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.tags.TagKey;

public class DreamlandCustomTags {

	//Block Tags
	public static final TagKey<Block> HIVE_ORES_REPLACEABLE = TagFactory.createBlockTag("hive_ores_replaceable");
	
	//Item Tags
	public static final TagKey<Item> HIVE_ORES_ITEM = TagFactory.createItemTag("hive_ores");	
}
