package com.github.dragoni7.registry;

import com.github.dragoni7.util.CustomTagUtil.*;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class DreamlandCustomTags {

	//Block Tags
	public static final Tags.IOptionalNamedTag<Block> HIVE_ORES_REPLACEABLE = Blocks.createTag("hive_ores_replaceable");
	
	//Item Tags
	public static final Tags.IOptionalNamedTag<Item> HIVE_ORES_ITEM = Items.createTag("hive_ores");
}
