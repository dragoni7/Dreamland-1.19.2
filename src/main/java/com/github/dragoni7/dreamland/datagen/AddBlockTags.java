package com.github.dragoni7.dreamland.datagen;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.blocks.DreamlandBlockTags;
import com.github.dragoni7.dreamland.setup.DreamlandBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
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
		.add(DreamlandBlocks.DROUGHT_SOIL.get());
		
		tag(Tags.Blocks.STONE)
		.add(DreamlandBlocks.DARK_QUARTZITE.get());
		
		tag(BlockTags.ICE)
		.add(DreamlandBlocks.DUSK_ICE.get());
		
		tag(BlockTags.REPLACEABLE_PLANTS)
		.add(DreamlandBlocks.HIVE_GROWTH.get());
		
		tag(BlockTags.SAPLINGS)
		.add(DreamlandBlocks.JOSHUA_SAPLING.get());
		
		tag(BlockTags.MINEABLE_WITH_SHOVEL)
		.add(DreamlandBlocks.CLAY_SOIL.get())
		.add(DreamlandBlocks.HIVE_JELLY_CLUSTER.get())
		.add(DreamlandBlocks.INFESTED_HIVE_JELLY_CLUSTER.get())
		.add(DreamlandBlocks.HIVE_MEMBRANE.get());
		
		tag(BlockTags.MINEABLE_WITH_PICKAXE)
		.add(DreamlandBlocks.DARK_QUARTZITE.get())
		.add(DreamlandBlocks.HIVE_BLOCK.get())
		.add(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.get())
		.add(DreamlandBlocks.POROUS_STONE.get())
		.add(DreamlandBlocks.ROOTED_POROUS_STONE.get());
		
		tag(BlockTags.NEEDS_STONE_TOOL)
		.add(DreamlandBlocks.HIVE_BLOCK.get())
		.add(DreamlandBlocks.HIVE_JELLY_CLUSTER.get())
		.add(DreamlandBlocks.INFESTED_HIVE_JELLY_CLUSTER.get())
		.add(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.get())
		.add(DreamlandBlocks.HIVE_MEMBRANE.get());
	
		tag(DreamlandBlockTags.HIVE_ORES_REPLACEABLE)
		.add(DreamlandBlocks.HIVE_BLOCK.get());
		
		tag(DreamlandBlockTags.GARDEN_SURFACE_REPLACEABLE)
		.add(Blocks.GRASS_BLOCK)
		.add(Blocks.STONE)
		.add(Blocks.MOSS_BLOCK);
		
		
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

