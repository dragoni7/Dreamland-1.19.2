package com.github.dragoni7.dreamland.data;

import java.util.ArrayList;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.github.dragoni7.dreamland.util.WoodSet;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DreamlandBlockStates extends BlockStateProvider{

	public DreamlandBlockStates(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
		super(gen, modid, exFileHelper);
		
	}

	@Override
	protected void registerStatesAndModels() {
		
		ArrayList<Block> simpleBlocks = new ArrayList<Block>();
		//simpleBlocks.add(DreamlandBlocks.CLAY_SOIL.block().get());
		simpleBlocks.add(DreamlandBlocks.KUNZITE_STONE.block().get());
		simpleBlocks.add(DreamlandBlocks.COBBLED_KUNZITE_STONE.block().get());
		simpleBlocks.add(DreamlandBlocks.KUNZITE_BRICKS.block().get());
		simpleBlocks.add(DreamlandBlocks.KUNZITE_TILE.block().get());
		simpleBlocks.add(DreamlandBlocks.CHISELED_KUNZITE.block().get());
		simpleBlocks.add(DreamlandBlocks.KUNZITE_COPPER_ORE.block().get());
		simpleBlocks.add(DreamlandBlocks.KUNZITE_IRON_ORE.block().get());
		simpleBlocks.add(DreamlandBlocks.KUNZITE_REDSTONE_ORE.block().get());
		simpleBlocks.add(DreamlandBlocks.KUNZITE_LAPIS_ORE.block().get());
		simpleBlocks.add(DreamlandBlocks.KUNZITE_EMERALD_ORE.block().get());
		simpleBlocks.add(DreamlandBlocks.KUNZITE_DIAMOND_ORE.block().get());
		simpleBlocks.add(DreamlandBlocks.GOLD_BEARING_QUARTZITE.block().get());
		//simpleBlocks.add(DreamlandBlocks.DUSK_ICE.block().get());
		simpleBlocks.add(DreamlandBlocks.HIVE_IRON.block().get());
		simpleBlocks.add(DreamlandBlocks.HIVE_COPPER.block().get());
		simpleBlocks.add(DreamlandBlocks.HIVE_REDSTONE.block().get());
		simpleBlocks.add(DreamlandBlocks.HIVE_GOLD.block().get());
		simpleBlocks.add(DreamlandBlocks.HIVE_LAPIS.block().get());
		simpleBlocks.add(DreamlandBlocks.HIVE_DIAMOND.block().get());
		simpleBlocks.add(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.block().get());
		simpleBlocks.add(DreamlandBlocks.DRIED_TAR.block().get());
		simpleBlocks.add(DreamlandBlocks.TAR_MUD.block().get());
		simpleBlocks.add(DreamlandBlocks.PACKED_TAR_MUD.block().get());
		simpleBlocks.add(DreamlandBlocks.TAR_MUD_BRICKS.block().get());
		simpleBlocks.add(DreamlandBlocks.DROUGHT_SOIL.block().get());
		simpleBlocks.add(DreamlandBlocks.MINERAL_DIRT.block().get());
		simpleBlocks.add(DreamlandBlocks.OPAL_BLOCK.block().get());
		simpleBlocks.add(DreamlandBlocks.PRECIOUS_OPAL_BLOCK.block().get());
		simpleBlocks.add(DreamlandBlocks.OPAL_TILE.block().get());
		simpleBlocks.add(DreamlandBlocks.PRECIOUS_OPAL_TILE.block().get());
		simpleBlocks.add(DreamlandBlocks.PRECIOUS_OPAL_LAMP.block().get());
		simpleBlocks.add(DreamlandBlocks.JEWELED_DEEPSLATE.block().get());
		simpleBlocks.add(DreamlandBlocks.POROUS_STONE.block().get());
		simpleBlocks.add(DreamlandBlocks.OVERGROWN_POROUS_STONE.block().get());
		simpleBlocks.add(DreamlandBlocks.MOLDED_STONE.block().get());
		simpleBlocks.add(DreamlandBlocks.PETRIFIED_VEGETATION.block().get());
		simpleBlocks.add(DreamlandBlocks.TOXIC_DIRT.block().get());
		simpleBlocks.add(DreamlandBlocks.TOXIC_VEGETATION.block().get());
		simpleBlocks.add(DreamlandBlocks.DECAYED_VEGETATION.block().get());
		simpleBlocks.add(DreamlandBlocks.GLOWING_MOLD_WOOD.block().get());

		for(Block element : simpleBlocks) {
			simpleBlock(element);
		}
		
		ResourceLocation fossilizedEggTopTxt = modLoc("block/tar_mud");
		ResourceLocation fossilizedEggSideTxt = modLoc("block/fossilized_egg");
		axisBlock((RotatedPillarBlock) DreamlandBlocks.FOSSILIZED_EGG.block().get(), fossilizedEggSideTxt, fossilizedEggTopTxt);
		
		ResourceLocation opalTileTxt = modLoc("block/opal_tile");
		slabBlock((SlabBlock) DreamlandBlocks.OPAL_SLAB.block().get(), opalTileTxt, opalTileTxt, opalTileTxt, opalTileTxt);
		stairsBlock((StairBlock) DreamlandBlocks.OPAL_STAIRS.block().get(), opalTileTxt, opalTileTxt, opalTileTxt);
		wallBlock((WallBlock) DreamlandBlocks.OPAL_WALL.block().get(), opalTileTxt);
		
		ResourceLocation preciousOpalTileTxt = modLoc("block/precious_opal_tile");
		slabBlock((SlabBlock) DreamlandBlocks.PRECIOUS_OPAL_SLAB.block().get(), preciousOpalTileTxt, preciousOpalTileTxt, preciousOpalTileTxt, preciousOpalTileTxt);
		stairsBlock((StairBlock) DreamlandBlocks.PRECIOUS_OPAL_STAIRS.block().get(), preciousOpalTileTxt, preciousOpalTileTxt, preciousOpalTileTxt);
		wallBlock((WallBlock) DreamlandBlocks.PRECIOUS_OPAL_WALL.block().get(), preciousOpalTileTxt);
		
		ResourceLocation tarMudBrickTxt = modLoc("block/tar_mud_bricks");
		slabBlock((SlabBlock) DreamlandBlocks.TAR_MUD_BRICK_SLAB.block().get(), tarMudBrickTxt, tarMudBrickTxt, tarMudBrickTxt, tarMudBrickTxt);
		stairsBlock((StairBlock) DreamlandBlocks.TAR_MUD_BRICK_STAIRS.block().get(), tarMudBrickTxt, tarMudBrickTxt, tarMudBrickTxt);
		wallBlock((WallBlock) DreamlandBlocks.TAR_MUD_BRICK_WALL.block().get(), tarMudBrickTxt);
		
		ResourceLocation kunziteBricksTxt = modLoc("block/kunzite_bricks");
		slabBlock((SlabBlock) DreamlandBlocks.KUNZITE_BRICK_SLAB.block().get(), kunziteBricksTxt, kunziteBricksTxt, kunziteBricksTxt, kunziteBricksTxt);
		stairsBlock((StairBlock) DreamlandBlocks.KUNZITE_BRICK_STAIRS.block().get(), kunziteBricksTxt, kunziteBricksTxt, kunziteBricksTxt);
		wallBlock((WallBlock) DreamlandBlocks.KUNZITE_BRICK_WALL.block().get(), kunziteBricksTxt);
		
		ResourceLocation cobbledKunziteTxt = modLoc("block/cobbled_kunzite_stone");
		slabBlock((SlabBlock) DreamlandBlocks.COBBLED_KUNZITE_SLAB.block().get(), cobbledKunziteTxt, cobbledKunziteTxt, cobbledKunziteTxt, cobbledKunziteTxt);
		stairsBlock((StairBlock) DreamlandBlocks.COBBLED_KUNZITE_STAIRS.block().get(), cobbledKunziteTxt, cobbledKunziteTxt, cobbledKunziteTxt);
		wallBlock((WallBlock) DreamlandBlocks.COBBLED_KUNZITE_WALL.block().get(), cobbledKunziteTxt);
		
		ResourceLocation kunzitePointBlockTop = modLoc("block/kunzite_point_block_top");
		ResourceLocation kunzitePointBlockSide = modLoc("block/kunzite_point_block");
		axisBlock((RotatedPillarBlock) DreamlandBlocks.KUNZITE_POINT_BLOCK.block().get(), kunzitePointBlockSide, kunzitePointBlockTop);
		
		ResourceLocation glowingMoldLogTop = modLoc("block/mold_wood_log_top");
		ResourceLocation glowingMoldLogSide = modLoc("block/glowing_mold_wood");
		axisBlock((RotatedPillarBlock) DreamlandBlocks.GLOWING_MOLD_LOG.block().get(), glowingMoldLogSide, glowingMoldLogTop);
		
		registerWoodSet(DreamlandWoodSets.PLUM_BIRCH);
		registerWoodSet(DreamlandWoodSets.TAR_BARK);
		registerWoodSet(DreamlandWoodSets.MOLD_WOOD);
	}
	
	private void registerWoodSet(WoodSet set) {
		String setName = set.getSetName();
		ResourceLocation logTop = modLoc("block/" + setName + "_log_top");
		ResourceLocation logSide = modLoc("block/" + setName + "_log");
		ResourceLocation strippedLogTop = modLoc("block/stripped_" + setName + "_log_top");
		ResourceLocation strippedLogSide = modLoc("block/stripped_" + setName + "_log");
		ResourceLocation plankTxt = modLoc("block/" + setName + "_planks");
		ResourceLocation trapDoorTxt = modLoc("block/" + setName + "_trapdoor");
		ResourceLocation doorTop = modLoc("block/" + setName + "_door_top");
		ResourceLocation doorBottom = modLoc("block/" + setName + "_door_bottom");
		ModelFile bottomLeft = models().withExistingParent("door/" + setName + "_bottom_left", "block/door_" + "bottom_left").texture("bottom", doorBottom).texture("top", doorTop).renderType("cutout_mipped");
		ModelFile bottomLeftOpen = models().withExistingParent("door/" + setName + "_bottom_left_open", "block/door_" + "bottom_left_open").texture("bottom", doorBottom).texture("top", doorTop).renderType("cutout_mipped");
		ModelFile bottomRight = models().withExistingParent("door/" + setName + "_bottom_right", "block/door_" + "bottom_right").texture("bottom", doorBottom).texture("top", doorTop).renderType("cutout_mipped");
		ModelFile bottomRightOpen = models().withExistingParent("door/" + setName + "_bottom_right_open", "block/door_" + "bottom_right_open").texture("bottom", doorBottom).texture("top", doorTop).renderType("cutout_mipped");
		ModelFile topLeft = models().withExistingParent("door/" + setName + "_top_left", "block/door_" + "top_left").texture("bottom", doorBottom).texture("top", doorTop).renderType("cutout_mipped");
		ModelFile topLeftOpen = models().withExistingParent("door/" + setName + "_top_left_open", "block/door_" + "top_left_open").texture("bottom", doorBottom).texture("top", doorTop).renderType("cutout_mipped");
		ModelFile topRight = models().withExistingParent("door/" + setName + "_top_right", "block/door_" + "top_right").texture("bottom", doorBottom).texture("top", doorTop).renderType("cutout_mipped");
		ModelFile topRightOpen = models().withExistingParent("door/" + setName + "_top_right_open", "block/door_" + "top_right_open").texture("bottom", doorBottom).texture("top", doorTop).renderType("cutout_mipped");
		
		axisBlock((RotatedPillarBlock) set.log().block().get(), logSide, logTop);
		axisBlock((RotatedPillarBlock) set.strippedLog().block().get(), strippedLogSide, strippedLogTop);
		axisBlock((RotatedPillarBlock) set.wood().block().get(), logSide, logSide);
		axisBlock((RotatedPillarBlock) set.strippedWood().block().get(), strippedLogSide, strippedLogSide);
		simpleBlock(set.plank().block().get());
		slabBlock((SlabBlock) set.slab().block().get(), plankTxt, plankTxt, plankTxt, plankTxt);
		stairsBlock((StairBlock) set.stair().block().get(), plankTxt, plankTxt, plankTxt);
		fenceBlock((FenceBlock) set.fence().block().get(), plankTxt);
		fenceGateBlock((FenceGateBlock) set.fenceGate().block().get(), plankTxt);
		doorBlock((DoorBlock) set.door().block().get(), bottomLeft, bottomLeftOpen, bottomRight, bottomRightOpen, topLeft, topLeftOpen, topRight, topRightOpen);
		trapdoorBlock((TrapDoorBlock) set.trapDoor().block().get(), trapDoorTxt, true);
		buttonBlock((ButtonBlock) set.button().block().get(), plankTxt);
		pressurePlateBlock((PressurePlateBlock) set.pressurePlate().block().get(), plankTxt);
	}
}