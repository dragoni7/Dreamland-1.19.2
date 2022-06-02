package com.github.dragoni7.dreamland.datagen;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.blocks.DreamlandBlockTags;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AddBlockTags extends BlockTagsProvider{

	public AddBlockTags(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, Dreamland.MODID, helper);
		
	}
	
	@Override
	protected void addTags() {
		
		tag(BlockTags.DIRT)
		.add(DreamlandBlocks.CLAY_SOIL.get())
		.add(DreamlandBlocks.CLAY_SOIL_GRASS.get())
		.add(DreamlandBlocks.DROUGHT_SOIL.get())
		.add(DreamlandBlocks.MINERAL_DIRT.get())
		.add(DreamlandBlocks.FLOWERING_UNDERGROWTH.get());
		
		tag(Tags.Blocks.STONE)
		.add(DreamlandBlocks.DARK_QUARTZITE.get());
		
		tag(BlockTags.LOGS)
		.add(DreamlandWoodSets.TAR_BARK.getLog())
		.add(DreamlandWoodSets.PLUM_BIRCH.getLog());
		
		tag(BlockTags.PLANKS)
		.add(DreamlandWoodSets.PLUM_BIRCH.getPlank());
		
		tag(BlockTags.LEAVES)
		.add(DreamlandBlocks.TAR_BARK_LEAVES.get())
		.add(DreamlandBlocks.PLUM_BIRCH_LEAVES.get());
		
		tag(BlockTags.ICE)
		.add(DreamlandBlocks.DUSK_ICE.get());
		
		tag(BlockTags.REPLACEABLE_PLANTS)
		.add(DreamlandBlocks.HIVE_GROWTH.get())
		.add(DreamlandBlocks.TAR_SPROUTS.get())
		.add(DreamlandBlocks.PINK_CRAB_GRASS.get());
		
		tag(BlockTags.SAPLINGS)
		.add(DreamlandBlocks.TAR_BARK_SAPLING.get())
		.add(DreamlandBlocks.PLUM_BIRCH_SAPLING.get());
		
		tag(BlockTags.FLOWERS)
		.add(DreamlandBlocks.OPALINE_MARIGOLD.get());
		tag(BlockTags.SMALL_FLOWERS)
		.add(DreamlandBlocks.OPALINE_MARIGOLD.get());
		
		tag(BlockTags.MINEABLE_WITH_AXE)
		.add(DreamlandWoodSets.TAR_BARK.getLog())
		.add(DreamlandWoodSets.TAR_BARK.getStrippedLog())
		.add(DreamlandWoodSets.TAR_BARK.getPlank())
		.add(DreamlandWoodSets.PLUM_BIRCH.getLog())
		.add(DreamlandWoodSets.PLUM_BIRCH.getPlank())
		.add(DreamlandWoodSets.PLUM_BIRCH.getStrippedLog());
		
		tag(BlockTags.MINEABLE_WITH_SHOVEL)
		.add(DreamlandBlocks.CLAY_SOIL.get())
		.add(DreamlandBlocks.HIVE_JELLY_CLUSTER.get())
		.add(DreamlandBlocks.INFESTED_HIVE_JELLY_CLUSTER.get())
		.add(DreamlandBlocks.HIVE_MEMBRANE.get())
		.add(DreamlandBlocks.MINERAL_DIRT.get())
		.add(DreamlandBlocks.FLOWERING_UNDERGROWTH.get());
		
		tag(BlockTags.MINEABLE_WITH_PICKAXE)
		.add(DreamlandBlocks.DARK_QUARTZITE.get())
		.add(DreamlandBlocks.HIVE_BLOCK.get())
		.add(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.get());
		
		tag(BlockTags.NEEDS_STONE_TOOL)
		.add(DreamlandBlocks.HIVE_BLOCK.get())
		.add(DreamlandBlocks.HIVE_JELLY_CLUSTER.get())
		.add(DreamlandBlocks.INFESTED_HIVE_JELLY_CLUSTER.get())
		.add(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.get())
		.add(DreamlandBlocks.HIVE_MEMBRANE.get());
	
		tag(DreamlandBlockTags.HIVE_ORES_REPLACEABLE)
		.add(DreamlandBlocks.HIVE_BLOCK.get());
		
		addCopperOreTags(DreamlandBlocks.HIVE_COPPER.get());
		addIronOreTags(DreamlandBlocks.HIVE_IRON.get());
		addGoldOreTags(DreamlandBlocks.HIVE_GOLD.get());
		addRedstoneOreTags(DreamlandBlocks.HIVE_REDSTONE.get());
		addLapisOreTags(DreamlandBlocks.HIVE_LAPIS.get());
		addDiamondOreTags(DreamlandBlocks.HIVE_DIAMOND.get());
		
		
	}
	
	private void addCopperOreTags(Block block) {
		tag(Tags.Blocks.ORES).add(block);
		tag(BlockTags.COPPER_ORES).add(block);
		tag(Tags.Blocks.ORES_COPPER).add(block);
		
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
		tag(BlockTags.NEEDS_STONE_TOOL).add(block);
	}
	
	private void addIronOreTags(Block block) {
		tag(Tags.Blocks.ORES).add(block);
		tag(BlockTags.IRON_ORES).add(block);
		tag(Tags.Blocks.ORES_IRON).add(block);
		
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
		tag(BlockTags.NEEDS_STONE_TOOL).add(block);
	}
	
	private void addGoldOreTags(Block block) {
		tag(Tags.Blocks.ORES).add(block);
		tag(BlockTags.GOLD_ORES).add(block);
		tag(Tags.Blocks.ORES_GOLD).add(block);
		
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
		tag(BlockTags.NEEDS_IRON_TOOL).add(block);
	}
	
	private void addRedstoneOreTags(Block block) {
		tag(Tags.Blocks.ORES).add(block);
		tag(BlockTags.REDSTONE_ORES).add(block);
		tag(Tags.Blocks.ORES_REDSTONE).add(block);
		
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
		tag(BlockTags.NEEDS_IRON_TOOL).add(block);
	}
	
	private void addLapisOreTags(Block block) {
		tag(Tags.Blocks.ORES).add(block);
		tag(BlockTags.LAPIS_ORES).add(block);
		tag(Tags.Blocks.ORES_LAPIS).add(block);
		
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
		tag(BlockTags.NEEDS_STONE_TOOL).add(block);
	}
	
	private void addDiamondOreTags(Block block) {
		tag(Tags.Blocks.ORES).add(block);
		tag(BlockTags.DIAMOND_ORES).add(block);
		tag(Tags.Blocks.ORES_DIAMOND).add(block);
		
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
		tag(BlockTags.NEEDS_IRON_TOOL).add(block);
	}
	
	@Override
	public String getName() {
		return "Dreamland Block Tags";
	}
}

