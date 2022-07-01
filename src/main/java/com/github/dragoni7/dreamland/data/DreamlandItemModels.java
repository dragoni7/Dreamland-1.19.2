package com.github.dragoni7.dreamland.data;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.github.dragoni7.dreamland.util.DreamlandLoc;
import com.github.dragoni7.dreamland.util.WoodSet;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class DreamlandItemModels extends ItemModelProvider {

	public DreamlandItemModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
		super(generator, modid, existingFileHelper);
		
	}

	@Override
	protected void registerModels() {
		
		blockItemModel(DreamlandBlocks.HIVE_BLOCK.item(),"block/hive_block1");
		//blockItemModel(DreamlandBlocks.CLAY_SOIL.item(),"block/clay_soil");
		//blockItemModel(DreamlandBlocks.DARK_QUARTZITE.item(),"block/dark_quartzite");
		//blockItemModel(DreamlandBlocks.DUSK_ICE.item(),"block/dusk_ice");
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
		blockItemModel(DreamlandBlocks.FOSSILIZED_EGG.item(), "block/fossilized_egg");
		wallInventory("tar_mud_brick_wall", DreamlandLoc.createLoc("block/tar_mud_bricks"));
		blockItemModel(DreamlandBlocks.DROUGHT_SOIL.item(), "block/drought_soil");
		blockItemModel(DreamlandBlocks.TAR_BARK_LEAVES.item(), "block/tar_bark_leaves1");
		
		blockItemModel(DreamlandBlocks.PLUM_BIRCH_LEAVES.item(), "block/plum_birch_leaves1");
		blockItemModel(DreamlandBlocks.MINERAL_DIRT.item(), "block/mineral_dirt");
		blockItemModel(DreamlandBlocks.FLOWERING_GRASS.item(), "block/flowering_grass");
		blockItemModel(DreamlandBlocks.FLOWERING_UNDERGROWTH.item(), "block/flowering_undergrowth");
		blockItemModel(DreamlandBlocks.PLUM_BIRCH_SHRUB.item(), "block/plum_birch_shrub");
		blockItemModel(DreamlandBlocks.OPAL_DIFFUSER_BLOCK.item(), "block/opal_diffuser");
		blockItemModel(DreamlandBlocks.OPAL_CLUSTER.item(), "block/opal_cluster");
		blockItemModel(DreamlandBlocks.OPAL_BLOCK.item(), "block/opal_block");
		blockItemModel(DreamlandBlocks.PRECIOUS_OPAL_BLOCK.item(), "block/precious_opal_block");
		blockItemModel(DreamlandBlocks.OPAL_TILE.item(), "block/opal_tile");
		blockItemModel(DreamlandBlocks.PRECIOUS_OPAL_TILE.item(), "block/precious_opal_tile");
		blockItemModel(DreamlandBlocks.OPAL_SLAB.item(), "block/opal_slab");
		blockItemModel(DreamlandBlocks.OPAL_STAIRS.item(), "block/opal_stairs");
		wallInventory("opal_wall", DreamlandLoc.createLoc("block/opal_tile"));
		blockItemModel(DreamlandBlocks.PRECIOUS_OPAL_SLAB.item(), "block/precious_opal_slab");
		blockItemModel(DreamlandBlocks.PRECIOUS_OPAL_STAIRS.item(), "block/precious_opal_stairs");
		wallInventory("precious_opal_wall", DreamlandLoc.createLoc("block/precious_opal_tile"));
		blockItemModel(DreamlandBlocks.JEWELED_DEEPSLATE.item(), "block/jeweled_deepslate");
		
		singleTextureItemModel(DreamlandItems.HIVE_JELLY_ITEM, "item/hive_jelly");
		singleTextureItemModel(DreamlandItems.JELLY_BOWL_ITEM, "item/bowl_of_jelly");
		singleTextureItemModel(DreamlandBlocks.CAVE_SLIME.item(), "block/cave_slime");
		singleTextureItemModel(DreamlandBlocks.HIVE_GROWTH.item(), "block/hive_growth_cross");
		singleTextureItemModel(DreamlandItems.LARVA_HELMET, "item/larva_symbiote_helmet");
		singleTextureItemModel(DreamlandBlocks.TAR_SPROUTS.item(), "block/tar_sprouts");
		singleTextureItemModel(DreamlandBlocks.OPALINE_MARIGOLD.item(), "block/opaline_marigold");
		singleTextureItemModel(DreamlandBlocks.PINK_CRAB_GRASS.item(), "block/pink_crab_grass");
		singleTextureItemModel(DreamlandBlocks.PLUM_BIRCH_SAPLING.item(), "item/plum_birch_sapling");
		singleTextureItemModel(DreamlandItems.OPAL, "item/opal");
		singleTextureItemModel(DreamlandItems.PRECIOUS_OPAL, "item/precious_opal");
		singleTextureItemModel(DreamlandBlocks.TAR_BARK_SAPLING.item(), "item/tar_bark_sapling");
		singleTextureItemModel(DreamlandBlocks.ANCIENT_EGG.item(), "item/ancient_egg");
		singleTextureItemModel(DreamlandItems.TAR_BUCKET, "item/tar_bucket");
		spawnEggItemModel(DreamlandItems.SPAWN_EGG_LARVA);
		spawnEggItemModel(DreamlandItems.SPAWN_EGG_OOZE);
		spawnEggItemModel(DreamlandItems.SPAWN_EGG_BUMBLE_BEAST);
		spawnEggItemModel(DreamlandItems.SPAWN_EGG_OPAL_SHELL);
		
		registerWoodSet(DreamlandWoodSets.PLUM_BIRCH);
		registerWoodSet(DreamlandWoodSets.TAR_BARK);
	}
	
	private void registerWoodSet(WoodSet set) {
		String path = "block/" + set.getSetName();
		blockItemModel(set.log().item(), path + "_log");
		blockItemModel(set.strippedLog().item(), path + "_stripped_log");
		blockItemModel(set.wood().item(), path + "_wood");
		blockItemModel(set.strippedWood().item(), path + "_stripped_wood");
		blockItemModel(set.plank().item(), path + "_planks");
		blockItemModel(set.stair().item(), path + "_stairs");
		blockItemModel(set.slab().item(), path + "_slab");
		blockItemModel(set.fenceGate().item(), path + "_fence_gate");
		fenceInventory(set.getSetName() + "_fence", DreamlandLoc.createLoc(path + "_planks"));
		singleTextureItemModel(set.ladder().item(), "block/" + set.getSetName() + "_ladder");
		singleTextureItemModel(set.door().item(), "item/" + set.getSetName() + "_door");
		blockItemModel(set.trapDoor().item(), path + "_trapdoor_bottom");
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

