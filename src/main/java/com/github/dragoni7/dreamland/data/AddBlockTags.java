package com.github.dragoni7.dreamland.data;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.github.dragoni7.dreamland.util.WoodSet;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AddBlockTags extends BlockTagsProvider {

	public AddBlockTags(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, Dreamland.MODID, helper);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addTags() {
		
		tag(BlockTags.DIRT)
		.add(DreamlandBlocks.GOLDEN_MOSS_BLOCK.block().get())
		.add(DreamlandBlocks.DROUGHT_SOIL.block().get())
		.add(DreamlandBlocks.MINERAL_DIRT.block().get())
		.add(DreamlandBlocks.TOXIC_DIRT.block().get())
		.add(DreamlandBlocks.TOXIC_GRASS.block().get())
		.add(DreamlandBlocks.FLOWERING_GRASS.block().get());
		
		tag(BlockTags.MUSHROOM_GROW_BLOCK)
		.add(DreamlandBlocks.TOXIC_GRASS.block().get())
		.add(DreamlandBlocks.TOXIC_DIRT.block().get())
		.add(DreamlandBlocks.WHITE_MOLD.block().get())
		.add(DreamlandBlocks.BLACK_MOLD.block().get());
		
		tag(BlockTags.ANIMALS_SPAWNABLE_ON)
		.add(DreamlandBlocks.TOXIC_GRASS.block().get())
		.add(DreamlandBlocks.FLOWERING_GRASS.block().get());
		
		tag(Tags.Blocks.STONE)
		.add(DreamlandBlocks.POROUS_STONE.block().get())
		.add(DreamlandBlocks.OVERGROWN_POROUS_STONE.block().get())
		.add(DreamlandBlocks.PURE_STONE.block().get())
		.add(DreamlandBlocks.KUNZITE_STONE.block().get());
		
		tag(Tags.Blocks.COBBLESTONE)
		.add(DreamlandBlocks.COBBLED_KUNZITE_STONE.block().get());
		
		tag(BlockTags.LEAVES)
		.add(DreamlandBlocks.TAR_BARK_LEAVES.block().get())
		.add(DreamlandBlocks.PLUM_BIRCH_LEAVES.block().get());
		
		tag(BlockTags.ICE)
		.add(DreamlandBlocks.DAWN_ICE.block().get());
		
		tag(BlockTags.REPLACEABLE_PLANTS)
		.add(DreamlandBlocks.GOLD_FRONDS.block().get())
		.add(DreamlandBlocks.HIVE_GROWTH.block().get())
		.add(DreamlandBlocks.TAR_SPROUTS.block().get())
		.add(DreamlandBlocks.PINK_CRAB_GRASS.block().get())
		.add(DreamlandBlocks.FLOWERING_UNDERGROWTH.block().get())
		.add(DreamlandBlocks.SPONGE_PUFF.block().get())
		.add(DreamlandBlocks.SPORE_PUFF.block().get())
		.add(DreamlandBlocks.SHELF_VEGETATION.block().get())
		.add(DreamlandBlocks.GLOW_FRONDS.block().get())
		.add(DreamlandBlocks.PLUM_BIRCH_SHRUB.block().get());
		
		tag(BlockTags.SAPLINGS)
		.add(DreamlandBlocks.TAR_BARK_SAPLING.block().get())
		.add(DreamlandBlocks.PLUM_BIRCH_SAPLING.block().get());
		
		tag(BlockTags.FLOWERS)
		.add(DreamlandBlocks.OPALINE_MARIGOLD.block().get())
		.add(DreamlandBlocks.FLOWERING_UNDERGROWTH.block().get());
		tag(BlockTags.SMALL_FLOWERS)
		.add(DreamlandBlocks.OPALINE_MARIGOLD.block().get())
		.add(DreamlandBlocks.FLOWERING_UNDERGROWTH.block().get());
		
		tag(BlockTags.MINEABLE_WITH_SHOVEL)
		.add(DreamlandBlocks.TOXIC_DIRT.block().get())
		.add(DreamlandBlocks.TOXIC_GRASS.block().get())
		.add(DreamlandBlocks.WHITE_MOLD.block().get())
		.add(DreamlandBlocks.BLACK_MOLD.block().get())
		.add(DreamlandBlocks.HIVE_JELLY_CLUSTER.block().get())
		.add(DreamlandBlocks.INFESTED_HIVE_JELLY_CLUSTER.block().get())
		.add(DreamlandBlocks.TAR_MUD.block().get())
		.add(DreamlandBlocks.PACKED_TAR_MUD.block().get())
		.add(DreamlandBlocks.DROUGHT_SOIL.block().get())
		.add(DreamlandBlocks.MINERAL_DIRT.block().get())
		.add(DreamlandBlocks.FLOWERING_GRASS.block().get());
		
		tag(BlockTags.MINEABLE_WITH_PICKAXE)
		.add(DreamlandBlocks.POROUS_STONE.block().get())
		.add(DreamlandBlocks.OVERGROWN_POROUS_STONE.block().get())
		.add(DreamlandBlocks.PURE_STONE.block().get())
		.add(DreamlandBlocks.NECRATHENE_ORE.block().get())
		.add(DreamlandBlocks.PURITY_ORE.block().get())
		.add(DreamlandBlocks.KUNZITE_STONE.block().get())
		.add(DreamlandBlocks.COBBLED_KUNZITE_STONE.block().get())
		.add(DreamlandBlocks.KUNZITE_BRICKS.block().get())
		.add(DreamlandBlocks.KUNZITE_BRICK_SLAB.block().get())
		.add(DreamlandBlocks.KUNZITE_BRICK_STAIRS.block().get())
		.add(DreamlandBlocks.KUNZITE_BRICK_WALL.block().get())
		.add(DreamlandBlocks.COBBLED_KUNZITE_SLAB.block().get())
		.add(DreamlandBlocks.COBBLED_KUNZITE_STAIRS.block().get())
		.add(DreamlandBlocks.COBBLED_KUNZITE_WALL.block().get())
		.add(DreamlandBlocks.KUNZITE_TILE.block().get())
		.add(DreamlandBlocks.CHISELED_KUNZITE.block().get())
		.add(DreamlandBlocks.KUNZITE_BRICK_SLAB.block().get())
		.add(DreamlandBlocks.KUNZITE_BRICK_STAIRS.block().get())
		.add(DreamlandBlocks.KUNZITE_BRICK_WALL.block().get())
		.add(DreamlandBlocks.KUNZITE_POINT.block().get())
		.add(DreamlandBlocks.KUNZITE_POINT_BLOCK.block().get())
		.add(DreamlandBlocks.KUNZITE_BARS.block().get())
		.add(DreamlandBlocks.GOLD_BEARING_QUARTZITE.block().get())
		.add(DreamlandBlocks.GOLD_CLUSTER.block().get())
		.add(DreamlandBlocks.SMALL_GOLD_CLUSTER.block().get())
		.add(DreamlandBlocks.MEDIUM_GOLD_CLUSTER.block().get())
		.add(DreamlandBlocks.LARGE_GOLD_CLUSTER.block().get())
		.add(DreamlandBlocks.BUDDING_GOLD.block().get())
		.add(DreamlandBlocks.HIVE_BLOCK.block().get())
		.add(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.block().get())
		.add(DreamlandBlocks.HIVE_WEAVER.block().get())
		.add(DreamlandBlocks.DRIED_TAR.block().get())
		.add(DreamlandBlocks.TAR_MUD_BRICKS.block().get())
		.add(DreamlandBlocks.TAR_MUD_BRICK_SLAB.block().get())
		.add(DreamlandBlocks.TAR_MUD_BRICK_STAIRS.block().get())
		.add(DreamlandBlocks.TAR_MUD_BRICK_WALL.block().get())
		.add(DreamlandBlocks.FOSSILIZED_EGG.block().get())
		.add(DreamlandBlocks.OPAL_DIFFUSER_BLOCK.block().get())
		.add(DreamlandBlocks.OPAL_CLUSTER.block().get())
		.add(DreamlandBlocks.OPAL_BLOCK.block().get())
		.add(DreamlandBlocks.PRECIOUS_OPAL_BLOCK.block().get())
		.add(DreamlandBlocks.OPAL_TILE.block().get())
		.add(DreamlandBlocks.OPAL_SLAB.block().get())
		.add(DreamlandBlocks.OPAL_STAIRS.block().get())
		.add(DreamlandBlocks.OPAL_WALL.block().get())
		.add(DreamlandBlocks.PRECIOUS_OPAL_TILE.block().get())
		.add(DreamlandBlocks.PRECIOUS_OPAL_SLAB.block().get())
		.add(DreamlandBlocks.PRECIOUS_OPAL_STAIRS.block().get())
		.add(DreamlandBlocks.PRECIOUS_OPAL_WALL.block().get())
		.add(DreamlandBlocks.JEWELED_DEEPSLATE.block().get());
		
		tag(BlockTags.MINEABLE_WITH_AXE)
		.add(DreamlandBlocks.PETRIFIED_VEGETATION.block().get())
		.add(DreamlandBlocks.DECAYED_VEGETATION.block().get())
		.add(DreamlandBlocks.TOXIC_VEGETATION.block().get())
		.add(DreamlandBlocks.GLOWING_MOLD_WOOD.block().get())
		.add(DreamlandBlocks.GOLDEN_CAP.block().get())
		.add(DreamlandBlocks.MIDASHROOM.block().get());
		
		tag(BlockTags.NEEDS_STONE_TOOL)
		.add(DreamlandBlocks.PETRIFIED_VEGETATION.block().get())
		.add(DreamlandBlocks.DECAYED_VEGETATION.block().get())
		.add(DreamlandBlocks.KUNZITE_STONE.block().get())
		.add(DreamlandBlocks.COBBLED_KUNZITE_STONE.block().get())
		.add(DreamlandBlocks.KUNZITE_BRICKS.block().get())
		.add(DreamlandBlocks.KUNZITE_BRICK_SLAB.block().get())
		.add(DreamlandBlocks.KUNZITE_BRICK_STAIRS.block().get())
		.add(DreamlandBlocks.KUNZITE_BRICK_WALL.block().get())
		.add(DreamlandBlocks.COBBLED_KUNZITE_SLAB.block().get())
		.add(DreamlandBlocks.COBBLED_KUNZITE_STAIRS.block().get())
		.add(DreamlandBlocks.COBBLED_KUNZITE_WALL.block().get())
		.add(DreamlandBlocks.KUNZITE_TILE.block().get())
		.add(DreamlandBlocks.CHISELED_KUNZITE.block().get())
		.add(DreamlandBlocks.HIVE_BLOCK.block().get())
		.add(DreamlandBlocks.HIVE_JELLY_CLUSTER.block().get())
		.add(DreamlandBlocks.INFESTED_HIVE_JELLY_CLUSTER.block().get())
		.add(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.block().get())
		.add(DreamlandBlocks.OPAL_DIFFUSER_BLOCK.block().get())
		.add(DreamlandBlocks.OPAL_CLUSTER.block().get())
		.add(DreamlandBlocks.OPAL_BLOCK.block().get())
		.add(DreamlandBlocks.OPAL_TILE.block().get())
		.add(DreamlandBlocks.OPAL_SLAB.block().get())
		.add(DreamlandBlocks.OPAL_STAIRS.block().get())
		.add(DreamlandBlocks.OPAL_WALL.block().get())
		.add(DreamlandBlocks.PRECIOUS_OPAL_TILE.block().get())
		.add(DreamlandBlocks.PRECIOUS_OPAL_SLAB.block().get())
		.add(DreamlandBlocks.PRECIOUS_OPAL_STAIRS.block().get())
		.add(DreamlandBlocks.PRECIOUS_OPAL_WALL.block().get())
		.add(DreamlandBlocks.JEWELED_DEEPSLATE.block().get())
		.add(DreamlandBlocks.MIDASHROOM.block().get());
		
		tag(BlockTags.NEEDS_IRON_TOOL)
		.add(DreamlandBlocks.PURE_STONE.block().get())
		.add(DreamlandBlocks.PURITY_ORE.block().get())
		.add(DreamlandBlocks.KUNZITE_POINT.block().get())
		.add(DreamlandBlocks.KUNZITE_POINT_BLOCK.block().get())
		.add(DreamlandBlocks.KUNZITE_BARS.block().get())
		.add(DreamlandBlocks.GOLD_BEARING_QUARTZITE.block().get())
		.add(DreamlandBlocks.BUDDING_GOLD.block().get())
		.add(DreamlandBlocks.GOLD_CLUSTER.block().get())
		.add(DreamlandBlocks.SMALL_GOLD_CLUSTER.block().get())
		.add(DreamlandBlocks.MEDIUM_GOLD_CLUSTER.block().get())
		.add(DreamlandBlocks.LARGE_GOLD_CLUSTER.block().get())
		.add(DreamlandBlocks.FOSSILIZED_EGG.block().get());
		
		tag(BlockTags.NEEDS_DIAMOND_TOOL)
		.add(DreamlandBlocks.NECRATHENE_ORE.block().get())
		.add(DreamlandBlocks.HIVE_WEAVER.block().get())
		.add(DreamlandBlocks.PRECIOUS_OPAL_BLOCK.block().get());
		
		tag(DreamlandBlockTags.KUNZITE_ORES_REPLACEABLE)
		.add(DreamlandBlocks.KUNZITE_STONE.block().get());
	
		tag(DreamlandBlockTags.HIVE_ORES_REPLACEABLE)
		.add(DreamlandBlocks.HIVE_BLOCK.block().get());
		
		tag(DreamlandBlockTags.FOSSILIZED_EGG_REPLACEABLE)
		.add(DreamlandBlocks.TAR_MUD.block().get())
		.add(DreamlandBlocks.DRIED_TAR.block().get());
		
		tag(BlockTags.STONE_ORE_REPLACEABLES)
		.add(DreamlandBlocks.POROUS_STONE.block().get())
		.add(DreamlandBlocks.PETRIFIED_VEGETATION.block().get())
		.add(DreamlandBlocks.KUNZITE_STONE.block().get())
		.add(DreamlandBlocks.TAR_MUD.block().get());
		
		tag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
		.add(DreamlandBlocks.PURE_STONE.block().get());
		
		tag(BlockTags.FEATURES_CANNOT_REPLACE)
		.add(DreamlandBlocks.HIVE_MEMBRANE.block().get())
		.add(DreamlandBlocks.HIVE_WEAVER.block().get());
		
		tag(BlockTags.SCULK_REPLACEABLE)
		.add(DreamlandBlocks.KUNZITE_STONE.block().get())
		.add(DreamlandBlocks.HIVE_BLOCK.block().get())
		.add(DreamlandBlocks.TAR_MUD.block().get())
		.add(DreamlandBlocks.MINERAL_DIRT.block().get())
		.add(DreamlandBlocks.DROUGHT_SOIL.block().get())
		.add(DreamlandBlocks.DRIED_TAR.block().get());
		
		tag(BlockTags.AZALEA_GROWS_ON)
		.add(DreamlandBlocks.FLOWERING_GRASS.block().get());
		
		tag(BlockTags.BAMBOO_PLANTABLE_ON)
		.add(DreamlandBlocks.FLOWERING_GRASS.block().get())
		.add(DreamlandBlocks.GOLDEN_MOSS_BLOCK.block().get());
		
		tag(BlockTags.AZALEA_ROOT_REPLACEABLE)
		.add(DreamlandBlocks.FLOWERING_GRASS.block().get())
		.add(DreamlandBlocks.MINERAL_DIRT.block().get())
		.add(DreamlandBlocks.TAR_MUD.block().get())
		.add(DreamlandBlocks.HIVE_BLOCK.block().get());
		
		tag(BlockTags.DEAD_BUSH_MAY_PLACE_ON)
		.add(DreamlandBlocks.DROUGHT_SOIL.block().get());
		
		tag(BlockTags.GEODE_INVALID_BLOCKS)
		.add(DreamlandBlocks.HIVE_MEMBRANE.block().get())
		.add(DreamlandBlocks.HIVE_WEAVER.block().get());
		
		tag(BlockTags.INFINIBURN_OVERWORLD)
		.add(DreamlandBlocks.TAR_MUD.block().get())
		.add(DreamlandBlocks.PACKED_TAR_MUD.block().get());
		
		tag(BlockTags.WITHER_IMMUNE)
		.add(DreamlandBlocks.HIVE_MEMBRANE.block().get());
		
		tag(BlockTags.STAIRS)
		.add(DreamlandBlocks.KUNZITE_BRICK_STAIRS.block().get())
		.add(DreamlandBlocks.TAR_MUD_BRICK_STAIRS.block().get())
		.add(DreamlandBlocks.OPAL_STAIRS.block().get())
		.add(DreamlandBlocks.PRECIOUS_OPAL_STAIRS.block().get());
		
		tag(BlockTags.SLABS)
		.add(DreamlandBlocks.KUNZITE_BRICK_SLAB.block().get())
		.add(DreamlandBlocks.TAR_MUD_BRICK_SLAB.block().get())
		.add(DreamlandBlocks.OPAL_SLAB.block().get())
		.add(DreamlandBlocks.PRECIOUS_OPAL_SLAB.block().get());
		
		tag(BlockTags.WALLS)
		.add(DreamlandBlocks.KUNZITE_BRICK_WALL.block().get())
		.add(DreamlandBlocks.TAR_MUD_BRICK_WALL.block().get())
		.add(DreamlandBlocks.OPAL_WALL.block().get())
		.add(DreamlandBlocks.PRECIOUS_OPAL_WALL.block().get());
		
		tag(DreamlandBlockTags.STORAGE_BLOCKS_OPAL).add(DreamlandBlocks.OPAL_BLOCK.block().get());
		tag(DreamlandBlockTags.STORAGE_BLOCKS_PRECIOUS_OPAL).add(DreamlandBlocks.PRECIOUS_OPAL_BLOCK.block().get());
		
		tag(Tags.Blocks.STORAGE_BLOCKS).addTags(DreamlandBlockTags.STORAGE_BLOCKS_OPAL, DreamlandBlockTags.STORAGE_BLOCKS_PRECIOUS_OPAL);
		
		tag(DreamlandBlockTags.TOXIC_JUNGLE_GROUND_BLOCKS)
		.add(DreamlandBlocks.WHITE_MOLD.block().get())
		.add(DreamlandBlocks.TOXIC_DIRT.block().get())
		.add(DreamlandBlocks.TOXIC_GRASS.block().get())
		.add(DreamlandBlocks.BLACK_MOLD.block().get());
		
		tag(DreamlandBlockTags.NECRATHENE_REPLACEABLE)
		.add(DreamlandBlocks.POROUS_STONE.block().get())
		.add(DreamlandBlocks.OVERGROWN_POROUS_STONE.block().get())
		.add(DreamlandBlocks.PETRIFIED_VEGETATION.block().get());
		
		tag(DreamlandBlockTags.PURITY_REPLACEABLE)
		.add(DreamlandBlocks.PURE_STONE.block().get());
		
		tag(DreamlandBlockTags.MOLD_SPREADABLES)
		.addTag(BlockTags.DIRT)
		.addTag(BlockTags.CROPS)
		.addTag(BlockTags.LEAVES);
		
		tag(Tags.Blocks.ORES)
		.add(DreamlandBlocks.PURITY_ORE.block().get())
		.add(DreamlandBlocks.NECRATHENE_ORE.block().get());
		
		tag(DreamlandBlockTags.ORES_NECRATHENE)
		.add(DreamlandBlocks.NECRATHENE_ORE.block().get());
		
		tag(DreamlandBlockTags.ORES_PURITY)
		.add(DreamlandBlocks.PURITY_ORE.block().get());
		
		tag(DreamlandWoodSets.MOLD_WOOD.getlogBlockTag())
		.add(DreamlandBlocks.GLOWING_MOLD_WOOD.block().get());
		
		tag(DreamlandBlockTags.PURIFIABLE_BLOCKS)
		.add(DreamlandBlocks.BLACK_MOLD.block().get())
		.add(DreamlandBlocks.WHITE_MOLD.block().get())
		.add(DreamlandBlocks.SPORE_NODE.block().get())
		.add(Blocks.SCULK)
		.add(Blocks.SCULK_VEIN);
		
		addWoodSetTags(DreamlandWoodSets.PLUM_BIRCH);
		addWoodSetTags(DreamlandWoodSets.TAR_BARK);
		addWoodSetTags(DreamlandWoodSets.MOLD_WOOD);
		
		addCopperOreTags(DreamlandBlocks.KUNZITE_COPPER_ORE.block().get());
		addIronOreTags(DreamlandBlocks.KUNZITE_IRON_ORE.block().get());
		addEmeraldOreTags(DreamlandBlocks.KUNZITE_EMERALD_ORE.block().get());
		addRedstoneOreTags(DreamlandBlocks.KUNZITE_REDSTONE_ORE.block().get());
		addLapisOreTags(DreamlandBlocks.KUNZITE_LAPIS_ORE.block().get());
		addDiamondOreTags(DreamlandBlocks.KUNZITE_DIAMOND_ORE.block().get());
		
		addCopperOreTags(DreamlandBlocks.HIVE_COPPER.block().get());
		addIronOreTags(DreamlandBlocks.HIVE_IRON.block().get());
		addGoldOreTags(DreamlandBlocks.HIVE_GOLD.block().get());
		addRedstoneOreTags(DreamlandBlocks.HIVE_REDSTONE.block().get());
		addLapisOreTags(DreamlandBlocks.HIVE_LAPIS.block().get());
		addDiamondOreTags(DreamlandBlocks.HIVE_DIAMOND.block().get());
		
		
	}
	
	private void addWoodSetTags(WoodSet set) {
		tag(BlockTags.LOGS).add(set.log().block().get());
		tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(set.log().block().get());
		tag(BlockTags.LOGS_THAT_BURN).add(set.log().block().get());
		tag(BlockTags.WOODEN_BUTTONS).add(set.button().block().get());
		tag(BlockTags.WOODEN_DOORS).add(set.door().block().get());
		tag(BlockTags.WOODEN_FENCES).add(set.fence().block().get());
		tag(BlockTags.WOODEN_PRESSURE_PLATES).add(set.pressurePlate().block().get());
		tag(BlockTags.WOODEN_SLABS).add(set.slab().block().get());
		tag(BlockTags.WOODEN_STAIRS).add(set.stair().block().get());
		tag(BlockTags.WOODEN_TRAPDOORS).add(set.trapDoor().block().get());
		tag(BlockTags.FENCES).add(set.fence().block().get());
		tag(BlockTags.FENCE_GATES).add(set.fenceGate().block().get());
		tag(BlockTags.PLANKS).add(set.plank().block().get());
		tag(BlockTags.CLIMBABLE).add(set.ladder().block().get());
		tag(BlockTags.COMPLETES_FIND_TREE_TUTORIAL).add(set.log().block().get());
		
		tag(set.getlogBlockTag())
		.add(set.wood().block().get())
		.add(set.strippedLog().block().get())
		.add(set.strippedWood().block().get())
		.add(set.log().block().get());
		
		tag(BlockTags.MINEABLE_WITH_AXE)
		.add(set.button().block().get())
		.add(set.door().block().get())
		.add(set.fence().block().get())
		.add(set.fenceGate().block().get())
		.add(set.ladder().block().get())
		.add(set.log().block().get())
		.add(set.plank().block().get())
		.add(set.pressurePlate().block().get())
		.add(set.slab().block().get())
		.add(set.stair().block().get())
		.add(set.strippedLog().block().get())
		.add(set.trapDoor().block().get())
		.add(set.wood().block().get())
		.add(set.strippedWood().block().get());
		
		tag(BlockTags.SCULK_REPLACEABLE)
		.add(set.log().block().get())
		.add(set.plank().block().get())
		.add(set.slab().block().get())
		.add(set.stair().block().get());
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
	
	private void addEmeraldOreTags(Block block) {
		tag(Tags.Blocks.ORES).add(block);
		tag(BlockTags.EMERALD_ORES).add(block);
		tag(Tags.Blocks.ORES_EMERALD).add(block);
		
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
		tag(BlockTags.NEEDS_IRON_TOOL).add(block);
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

