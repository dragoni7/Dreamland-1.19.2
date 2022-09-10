package com.github.dragoni7.dreamland.data;

import com.github.dragoni7.dreamland.util.TagCreator;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class DreamlandItemTags {

	public static final TagKey<Item> HIVE_ORES_ITEM = TagCreator.dreamlandItemTag("hive_ores");
	public static final TagKey<Item> KUNZITE_ORES_ITEM = TagCreator.dreamlandItemTag("kunzite_ores");
	public static final TagKey<Item> OPAL = TagCreator.forgeItemTag("gems/opal");
	public static final TagKey<Item> PRECIOUS_OPAL = TagCreator.forgeItemTag("gems/precious_opal");
	public static final TagKey<Item> STORAGE_BLOCKS_OPAL = TagCreator.forgeItemTag("storage_blocks/opal");
	public static final TagKey<Item> STORAGE_BLOCKS_PRECIOUS_OPAL = TagCreator.forgeItemTag("storage_blocks/precious_opal");
	public static final TagKey<Item> PREVENTS_DECAY = TagCreator.dreamlandItemTag("prevents_decay");
	public static final TagKey<Item> INGOTS_NECRATHENE = TagCreator.forgeItemTag("ingots/necrathene");
	public static final TagKey<Item> NECRATHENE_ORE = TagCreator.forgeItemTag("ore/necrathene");
	public static final TagKey<Item> RAW_MATERIAL_NECRATHENE = TagCreator.forgeItemTag("raw_materials/necrathene");
	public static final TagKey<Item> PURITY_ORE = TagCreator.forgeItemTag("ore/purity");
	public static final TagKey<Item> CRYSTALIZED_PURITY = TagCreator.forgeItemTag("gems/purity");
	
	public static final TagKey<Item> MIDASHROOM_CONSUMABLES = TagCreator.dreamlandItemTag("midashroom_consumable");
}
