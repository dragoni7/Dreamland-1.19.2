package com.github.dragoni7.dreamland.data;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.github.dragoni7.dreamland.util.WoodSet;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AddItemTags extends ItemTagsProvider {
	
	public AddItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
		super(generator, blockTags, Dreamland.MODID, helper);
	}

	@Override
	protected void addTags() {
		
		tag(DreamlandItemTags.MIDASHROOM_CONSUMABLES)
		.add(DreamlandBlocks.GOLD_BEARING_QUARTZITE.item().get())
		.add(DreamlandBlocks.GOLD_CLUSTER.item().get())
		.add(DreamlandBlocks.BUDDING_GOLD.item().get())
		.add(DreamlandBlocks.HIVE_GOLD.item().get())
		.add(Items.GOLD_BLOCK).add(Items.GOLD_ORE).add(Items.GOLD_INGOT).add(Items.GOLDEN_APPLE).add(Items.GOLDEN_AXE).add(Items.GOLDEN_BOOTS).add(Items.GOLDEN_CARROT).add(Items.GOLDEN_CHESTPLATE).add(Items.GOLDEN_HELMET).add(Items.GOLDEN_HOE).add(Items.GOLDEN_HORSE_ARMOR).add(Items.GOLDEN_LEGGINGS).add(Items.GOLDEN_PICKAXE).add(Items.GOLDEN_SHOVEL).add(Items.GOLDEN_SWORD).add(Items.DEEPSLATE_GOLD_ORE).add(Items.NETHER_GOLD_ORE).add(Items.RAW_GOLD).add(Items.RAW_GOLD_BLOCK);
		
		tag(ItemTags.DIRT)
		//.add(DreamlandBlocks.CLAY_SOIL.item().get())
		//.add(DreamlandBlocks.CLAY_SOIL_GRASS.item().get())
		.add(DreamlandBlocks.DROUGHT_SOIL.item().get())
		.add(DreamlandBlocks.MINERAL_DIRT.item().get())
		.add(DreamlandBlocks.FLOWERING_GRASS.item().get());
		
		tag(Tags.Items.MUSHROOMS)
		.add(DreamlandBlocks.SMALL_GOLDEN_CAP.item().get());
		
		tag(ItemTags.LEAVES)
		.add(DreamlandBlocks.TAR_BARK_LEAVES.item().get())
		.add(DreamlandBlocks.PLUM_BIRCH_LEAVES.item().get());
		
		tag(ItemTags.SAPLINGS)
		.add(DreamlandBlocks.TAR_BARK_SAPLING.item().get())
		.add(DreamlandBlocks.PLUM_BIRCH_SAPLING.item().get());
		
		tag(ItemTags.FLOWERS)
		.add(DreamlandBlocks.OPALINE_MARIGOLD.item().get())
		.add(DreamlandBlocks.FLOWERING_UNDERGROWTH.item().get());
		tag(ItemTags.SMALL_FLOWERS)
		.add(DreamlandBlocks.OPALINE_MARIGOLD.item().get())
		.add(DreamlandBlocks.FLOWERING_UNDERGROWTH.item().get());
		
		tag(ItemTags.STAIRS)
		.add(DreamlandBlocks.KUNZITE_BRICK_STAIRS.item().get())
		.add(DreamlandBlocks.COBBLED_KUNZITE_STAIRS.item().get())
		.add(DreamlandBlocks.TAR_MUD_BRICK_STAIRS.item().get())
		.add(DreamlandBlocks.OPAL_STAIRS.item().get())
		.add(DreamlandBlocks.PRECIOUS_OPAL_STAIRS.item().get());
		
		tag(ItemTags.SLABS)
		.add(DreamlandBlocks.KUNZITE_BRICK_SLAB.item().get())
		.add(DreamlandBlocks.COBBLED_KUNZITE_SLAB.item().get())
		.add(DreamlandBlocks.TAR_MUD_BRICK_SLAB.item().get())
		.add(DreamlandBlocks.OPAL_SLAB.item().get())
		.add(DreamlandBlocks.PRECIOUS_OPAL_SLAB.item().get());
		
		tag(ItemTags.WALLS)
		.add(DreamlandBlocks.KUNZITE_BRICK_WALL.item().get())
		.add(DreamlandBlocks.COBBLED_KUNZITE_WALL.item().get())
		.add(DreamlandBlocks.TAR_MUD_BRICK_WALL.item().get())
		.add(DreamlandBlocks.OPAL_WALL.item().get())
		.add(DreamlandBlocks.PRECIOUS_OPAL_WALL.item().get());
		
		tag(Tags.Items.GEMS)
		.add(DreamlandBlocks.KUNZITE_POINT.item().get())
		.add(DreamlandItems.OPAL.get())
		.add(DreamlandItems.PRECIOUS_OPAL.get());
		
		tag(DreamlandItemTags.OPAL)
		.add(DreamlandItems.OPAL.get());
		
		tag(DreamlandItemTags.PRECIOUS_OPAL)
		.add(DreamlandItems.PRECIOUS_OPAL.get());
		
		addWoodSetTags(DreamlandWoodSets.PLUM_BIRCH);
		addWoodSetTags(DreamlandWoodSets.TAR_BARK);
		
		tag(DreamlandItemTags.KUNZITE_ORES_ITEM)
		.add(DreamlandBlocks.KUNZITE_COPPER_ORE.item().get())
		.add(DreamlandBlocks.KUNZITE_IRON_ORE.item().get())
		.add(DreamlandBlocks.KUNZITE_REDSTONE_ORE.item().get())
		.add(DreamlandBlocks.KUNZITE_LAPIS_ORE.item().get())
		.add(DreamlandBlocks.KUNZITE_DIAMOND_ORE.item().get())
		.add(DreamlandBlocks.KUNZITE_EMERALD_ORE.item().get());

		tag(DreamlandItemTags.HIVE_ORES_ITEM)
			.add(DreamlandBlocks.HIVE_COPPER.item().get())
			.add(DreamlandBlocks.HIVE_DIAMOND.item().get())
			.add(DreamlandBlocks.HIVE_GOLD.item().get())
			.add(DreamlandBlocks.HIVE_IRON.item().get())
			.add(DreamlandBlocks.HIVE_LAPIS.item().get())
			.add(DreamlandBlocks.HIVE_REDSTONE.item().get())
			.add(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.item().get());
		
		addCopperOreItemTags(DreamlandBlocks.KUNZITE_COPPER_ORE.item().get());
		addIronOreItemTags(DreamlandBlocks.KUNZITE_IRON_ORE.item().get());
		addEmeraldOreItemTags(DreamlandBlocks.KUNZITE_EMERALD_ORE.item().get());
		addRedstoneOreItemTags(DreamlandBlocks.KUNZITE_REDSTONE_ORE.item().get());
		addLapisOreItemTags(DreamlandBlocks.KUNZITE_LAPIS_ORE.item().get());
		addDiamondOreItemTags(DreamlandBlocks.KUNZITE_DIAMOND_ORE.item().get());
		
		addCopperOreItemTags(DreamlandBlocks.HIVE_COPPER.item().get());
		addIronOreItemTags(DreamlandBlocks.HIVE_IRON.item().get());
		addGoldOreItemTags(DreamlandBlocks.HIVE_GOLD.item().get());
		addRedstoneOreItemTags(DreamlandBlocks.HIVE_REDSTONE.item().get());
		addLapisOreItemTags(DreamlandBlocks.HIVE_LAPIS.item().get());
		addDiamondOreItemTags(DreamlandBlocks.HIVE_DIAMOND.item().get());
	}
	
	private void addWoodSetTags(WoodSet set) {
		tag(ItemTags.LOGS).add(set.log().item().get());
		tag(ItemTags.OVERWORLD_NATURAL_LOGS).add(set.log().item().get());
		tag(ItemTags.LOGS_THAT_BURN).add(set.log().item().get());
		tag(ItemTags.WOODEN_BUTTONS).add(set.button().item().get());
		tag(ItemTags.WOODEN_DOORS).add(set.door().item().get());
		tag(ItemTags.WOODEN_FENCES).add(set.fence().item().get());
		tag(ItemTags.WOODEN_PRESSURE_PLATES).add(set.pressurePlate().item().get());
		tag(ItemTags.WOODEN_SLABS).add(set.slab().item().get());
		tag(ItemTags.WOODEN_STAIRS).add(set.stair().item().get());
		tag(ItemTags.WOODEN_TRAPDOORS).add(set.trapDoor().item().get());
		tag(ItemTags.FENCES).add(set.fence().item().get());
		tag(ItemTags.PLANKS).add(set.plank().item().get());
		tag(ItemTags.COMPLETES_FIND_TREE_TUTORIAL).add(set.log().item().get());
		
		tag(set.getlogItemTag())
		.add(set.log().item().get())
		.add(set.strippedLog().item().get())
		.add(set.wood().item().get());
		
	}
	
	private void addCopperOreItemTags(Item item) {
		tag(Tags.Items.ORES).add(item);
		tag(ItemTags.COPPER_ORES).add(item);
		tag(Tags.Items.ORES_COPPER).add(item);
	}
	
	private void addIronOreItemTags(Item item) {
		tag(Tags.Items.ORES).add(item);
		tag(ItemTags.IRON_ORES).add(item);
		tag(Tags.Items.ORES_IRON).add(item);

	}
	
	private void addGoldOreItemTags(Item item) {
		tag(Tags.Items.ORES).add(item);
		tag(ItemTags.GOLD_ORES).add(item);
		tag(Tags.Items.ORES_GOLD).add(item);

	}
	
	private void addRedstoneOreItemTags(Item item) {
		tag(Tags.Items.ORES).add(item);
		tag(ItemTags.REDSTONE_ORES).add(item);
		tag(Tags.Items.ORES_REDSTONE).add(item);

	}
	
	private void addLapisOreItemTags(Item item) {
		tag(Tags.Items.ORES).add(item);
		tag(ItemTags.LAPIS_ORES).add(item);
		tag(Tags.Items.ORES_LAPIS).add(item);

	}
	
	private void addEmeraldOreItemTags(Item item) {
		tag(Tags.Items.ORES).add(item);
		tag(ItemTags.EMERALD_ORES).add(item);
		tag(Tags.Items.ORES_EMERALD).add(item);

	}
	
	private void addDiamondOreItemTags(Item item) {
		tag(Tags.Items.ORES).add(item);
		tag(ItemTags.DIAMOND_ORES).add(item);
		tag(Tags.Items.ORES_DIAMOND).add(item);

	}
	
	@Override
	public String getName() {
		return "Dreamland Item Tags";
	}
}
