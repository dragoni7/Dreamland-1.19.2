package com.github.dragoni7.dreamland.data;

import com.github.dragoni7.dreamland.util.TagCreator;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class DreamlandBlockTags {

	public static final TagKey<Block> HIVE_ORES_REPLACEABLE = TagCreator.dreamlandBlockTag("hive_ores_replaceable");
	public static final TagKey<Block> KUNZITE_ORES_REPLACEABLE = TagCreator.dreamlandBlockTag("kunzite_ores_replaceable");
	public static final TagKey<Block> FOSSILIZED_EGG_REPLACEABLE = TagCreator.dreamlandBlockTag("fossilized_egg_replaceable");
	public static final TagKey<Block> STORAGE_BLOCKS_OPAL = TagCreator.forgeBlockTag("storage_blocks/opal");
	public static final TagKey<Block> STORAGE_BLOCKS_PRECIOUS_OPAL = TagCreator.forgeBlockTag("storage_blocks/precious_opal");
	public static final TagKey<Block> TOXIC_JUNGLE_GROUND_BLOCKS = TagCreator.forgeBlockTag("toxic_jungle_ground_blocks");
	public static final TagKey<Block> MOLD_SPREADABLES = TagCreator.dreamlandBlockTag("mold_spreadables");
}
