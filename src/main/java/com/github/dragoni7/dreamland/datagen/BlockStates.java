package com.github.dragoni7.dreamland.datagen;

import java.util.ArrayList;

import com.github.dragoni7.dreamland.core.WoodSet;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;

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
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider{

	public BlockStates(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
		super(gen, modid, exFileHelper);
		
	}

	@Override
	protected void registerStatesAndModels() {
		
		ArrayList<Block> simpleBlocks = new ArrayList<Block>();
		simpleBlocks.add(DreamlandBlocks.CLAY_SOIL.block().get());
		simpleBlocks.add(DreamlandBlocks.DARK_QUARTZITE.block().get());
		simpleBlocks.add(DreamlandBlocks.DUSK_ICE.block().get());
		simpleBlocks.add(DreamlandBlocks.HIVE_IRON.block().get());
		simpleBlocks.add(DreamlandBlocks.HIVE_COPPER.block().get());
		simpleBlocks.add(DreamlandBlocks.HIVE_REDSTONE.block().get());
		simpleBlocks.add(DreamlandBlocks.HIVE_GOLD.block().get());
		simpleBlocks.add(DreamlandBlocks.HIVE_LAPIS.block().get());
		simpleBlocks.add(DreamlandBlocks.HIVE_DIAMOND.block().get());
		simpleBlocks.add(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.block().get());
		simpleBlocks.add(DreamlandBlocks.DRIED_TAR.block().get());
		simpleBlocks.add(DreamlandBlocks.TAR_SOIL.block().get());
		simpleBlocks.add(DreamlandBlocks.DROUGHT_SOIL.block().get());
		simpleBlocks.add(DreamlandBlocks.MINERAL_DIRT.block().get());

		for(Block element : simpleBlocks) {
			simpleBlock(element);
		}
		
		registerWoodSet(DreamlandWoodSets.PLUM_BIRCH);
		registerWoodSet(DreamlandWoodSets.TAR_BARK);
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
		ModelFile bottomLeft = models().withExistingParent("door/" + setName + "_bottom_left", "block/door_" + "bottom_left").texture("bottom", doorBottom).texture("top", doorTop);
		ModelFile bottomRight = models().withExistingParent("door/" + setName + "_bottom_right", "block/door_" + "bottom_right").texture("bottom", doorBottom).texture("top", doorTop);
		ModelFile topLeft = models().withExistingParent("door/" + setName + "_top_left", "block/door_" + "top_left").texture("bottom", doorBottom).texture("top", doorTop);
		ModelFile topRight = models().withExistingParent("door/" + setName + "_top_right", "block/door_" + "top_right").texture("bottom", doorBottom).texture("top", doorTop);
		
		axisBlock((RotatedPillarBlock) set.getLog().get(), logSide, logTop);
		axisBlock((RotatedPillarBlock) set.getStrippedLog().get(), strippedLogSide, strippedLogTop);
		axisBlock((RotatedPillarBlock) set.getWood().get(), logSide, logSide);
		simpleBlock(set.getPlank().get());
		slabBlock((SlabBlock) set.getSlab().get(), plankTxt, plankTxt, plankTxt, plankTxt);
		stairsBlock((StairBlock) set.getStair().get(), plankTxt, plankTxt, plankTxt);
		fenceBlock((FenceBlock) set.getFence().get(), plankTxt);
		fenceGateBlock((FenceGateBlock) set.getFenceGate().get(), plankTxt);
		doorBlock((DoorBlock) set.getDoor().get(), bottomLeft, bottomRight, topLeft, topRight);
		trapdoorBlock((TrapDoorBlock) set.getTrapDoor().get(), trapDoorTxt, true);
		buttonBlock((ButtonBlock) set.getButton().get(), plankTxt);
		pressurePlateBlock((PressurePlateBlock) set.getPressurePlate().get(), plankTxt);
	}
	
	private BlockModelBuilder doorModel(String name, String type, ResourceLocation bottom, ResourceLocation top) {
		return models().withExistingParent(name, "block/door_" + type).texture("bottom", bottom).texture("top", top);
	}
}