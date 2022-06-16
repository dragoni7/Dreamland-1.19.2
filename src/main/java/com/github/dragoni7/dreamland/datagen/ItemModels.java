package com.github.dragoni7.dreamland.datagen;

import com.github.dragoni7.dreamland.core.WoodSet;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.github.dragoni7.dreamland.util.DreamlandLoc;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ItemModels extends ItemModelProvider {

	public ItemModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
		super(generator, modid, existingFileHelper);
		
	}

	@Override
	protected void registerModels() {
		
		blockItemModel(DreamlandBlocks.HIVE_BLOCK.item(),"block/hive_block1");
		blockItemModel(DreamlandBlocks.CLAY_SOIL.item(),"block/clay_soil");
		blockItemModel(DreamlandBlocks.DARK_QUARTZITE.item(),"block/dark_quartzite");
		blockItemModel(DreamlandBlocks.DUSK_ICE.item(),"block/dusk_ice");
		blockItemModel(DreamlandBlocks.HIVE_JELLY_CLUSTER.item(), "block/hive_jelly_cluster");
		blockItemModel(DreamlandBlocks.HIVE_MEMBRANE.item(), "block/hive_membrane_connected");
		blockItemModel(DreamlandBlocks.HIVE_WEAVER.item(), "block/hive_weaver");
		blockItemModel(DreamlandBlocks.HIVE_IRON.item(), "block/hive_iron");
		blockItemModel(DreamlandBlocks.HIVE_COPPER.item(), "block/hive_copper");
		blockItemModel(DreamlandBlocks.HIVE_GOLD.item(), "block/hive_gold");
		blockItemModel(DreamlandBlocks.HIVE_REDSTONE.item(), "block/hive_redstone");
		blockItemModel(DreamlandBlocks.HIVE_LAPIS.item(), "block/hive_lapis");
		blockItemModel(DreamlandBlocks.HIVE_DIAMOND.item(), "block/hive_diamond");
		blockItemModel(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.item(), "block/hive_block_with_jelly");
		
		blockItemModel(DreamlandBlocks.DRIED_TAR.item(), "block/dried_tar");
		blockItemModel(DreamlandBlocks.TAR_MUD.item(), "block/tar_mud");
		blockItemModel(DreamlandBlocks.PACKED_TAR_MUD.item(), "block/packed_tar_mud");
		blockItemModel(DreamlandBlocks.TAR_MUD_BRICKS.item(), "block/tar_mud_bricks");
		blockItemModel(DreamlandBlocks.TAR_MUD_BRICK_SLAB.item(), "block/tar_mud_brick_slab");
		blockItemModel(DreamlandBlocks.TAR_MUD_BRICK_STAIRS.item(), "block/tar_mud_brick_stairs");
		blockItemModel(DreamlandBlocks.TAR_MUD_BRICK_WALL.item(), "block/tar_mud_brick_wall_side_tall");
		wallInventory("tar_mud_brick_wall", DreamlandLoc.createLoc("block/tar_mud_bricks"));
		blockItemModel(DreamlandBlocks.DROUGHT_SOIL.item(), "block/drought_soil");
		blockItemModel(DreamlandBlocks.TAR_BARK_LEAVES.item(), "block/tar_bark_leaves1");
		
		blockItemModel(DreamlandBlocks.PLUM_BIRCH_LEAVES.item(), "block/plum_birch_leaves1");
		blockItemModel(DreamlandBlocks.MINERAL_DIRT.item(), "block/mineral_dirt");
		blockItemModel(DreamlandBlocks.FLOWERING_GRASS.item(), "block/flowering_grass");
		blockItemModel(DreamlandBlocks.FLOWERING_UNDERGROWTH.item(), "block/flowering_undergrowth");
		
		singleTextureItemModel(DreamlandItems.HIVE_JELLY_ITEM, "item/hive_jelly");
		singleTextureItemModel(DreamlandBlocks.CAVE_SLIME.item(), "block/cave_slime");
		singleTextureItemModel(DreamlandBlocks.HIVE_GROWTH.item(), "block/hive_growth_cross");
		singleTextureItemModel(DreamlandBlocks.TAR_SPROUTS.item(), "block/tar_sprouts");
		singleTextureItemModel(DreamlandBlocks.OPALINE_MARIGOLD.item(), "block/opaline_marigold");
		singleTextureItemModel(DreamlandBlocks.PINK_CRAB_GRASS.item(), "block/pink_crab_grass");
		singleTextureItemModel(DreamlandBlocks.PLUM_BIRCH_SAPLING.item(), "item/plum_birch_sapling");
		singleTextureItemModel(DreamlandBlocks.TAR_BARK_SAPLING.item(), "item/tar_bark_sapling");
		singleTextureItemModel(DreamlandBlocks.ANCIENT_EGG.item(), "item/ancient_egg");
		singleTextureItemModel(DreamlandItems.TAR_BUCKET, "item/tar_bucket");
		spawnEggItemModel(DreamlandItems.SPAWN_EGG_LARVA);
		spawnEggItemModel(DreamlandItems.SPAWN_EGG_OOZE);
		
		registerWoodSet(DreamlandWoodSets.PLUM_BIRCH);
		registerWoodSet(DreamlandWoodSets.TAR_BARK);
	}
	
	private void registerWoodSet(WoodSet set) {
		String path = "block/" + set.getSetName();
		blockItemModel(set.getLogItem(), path + "_log");
		blockItemModel(set.getStrippedLogItem(), path + "_stripped_log");
		blockItemModel(set.getWoodItem(), path + "_wood");
		blockItemModel(set.getPlankItem(), path + "_planks");
		blockItemModel(set.getStairItem(), path + "_stairs");
		blockItemModel(set.getSlabItem(), path + "_slab");
		blockItemModel(set.getFenceGateItem(), path + "_fence_gate");
		fenceInventory(set.getSetName() + "_fence", DreamlandLoc.createLoc(path + "_planks"));
		singleTextureItemModel(set.getLadderItem(), "block/" + set.getSetName() + "_ladder");
		singleTextureItemModel(set.getDoorItem(), "item/" + set.getSetName() + "_door");
		blockItemModel(set.getTrapDoorItem(), path + "_trapdoor_bottom");
		buttonInventory(set.getSetName() + "_button", DreamlandLoc.createLoc(path + "_planks"));
		pressurePlate(set.getSetName() + "_pressure_plate", DreamlandLoc.createLoc(path + "_planks"));
	}
	
	private void singleTextureItemModel(RegistryObject<Item> item, String path) {
		singleTexture(item.getId().getPath(), new ResourceLocation("item/handheld"),
				"layer0", DreamlandLoc.createLoc(path));
	}
	
	private void blockItemModel(RegistryObject<Item> item, String path) {
		
		withExistingParent(item.getId().getPath(), DreamlandLoc.createLoc(path));
	}
	
	private void spawnEggItemModel(RegistryObject<Item> item) {
		withExistingParent(item.getId().getPath(), "item/template_spawn_egg");
	}

}

