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
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider{

	public BlockStates(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
		super(gen, modid, exFileHelper);
		
	}

	@Override
	protected void registerStatesAndModels() {
		
		ArrayList<Block> simpleBlocks = new ArrayList<Block>();
		simpleBlocks.add(DreamlandBlocks.CLAY_SOIL.get());
		simpleBlocks.add(DreamlandBlocks.DARK_QUARTZITE.get());
		simpleBlocks.add(DreamlandBlocks.DUSK_ICE.get());
		simpleBlocks.add(DreamlandBlocks.HIVE_MEMBRANE.get());
		simpleBlocks.add(DreamlandBlocks.HIVE_IRON.get());
		simpleBlocks.add(DreamlandBlocks.HIVE_COPPER.get());
		simpleBlocks.add(DreamlandBlocks.HIVE_REDSTONE.get());
		simpleBlocks.add(DreamlandBlocks.HIVE_GOLD.get());
		simpleBlocks.add(DreamlandBlocks.HIVE_LAPIS.get());
		simpleBlocks.add(DreamlandBlocks.HIVE_DIAMOND.get());
		simpleBlocks.add(DreamlandBlocks.HIVE_BLOCK_WITH_JELLY.get());
		simpleBlocks.add(DreamlandBlocks.DRIED_TAR.get());
		simpleBlocks.add(DreamlandBlocks.TAR_SOIL.get());
		simpleBlocks.add(DreamlandBlocks.DROUGHT_SOIL.get());
		simpleBlocks.add(DreamlandBlocks.MINERAL_DIRT.get());

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
		//ResourceLocation doorBottom = modLoc("block/" + setName + "_door_bottom");
		ResourceLocation ladderTxt = modLoc("block/" + setName + "_ladder");
		
		axisBlock((RotatedPillarBlock) set.getLog().get(), logSide, logTop);
		axisBlock((RotatedPillarBlock) set.getStrippedLog().get(), strippedLogSide, strippedLogTop);
		axisBlock((RotatedPillarBlock) set.getWood().get(), logSide, logSide);
		simpleBlock(set.getPlank().get());
		slabBlock((SlabBlock) set.getSlab().get(), plankTxt, plankTxt, plankTxt, plankTxt);
		stairsBlock((StairBlock) set.getStair().get(), plankTxt, plankTxt, plankTxt);
		fenceBlock((FenceBlock) set.getFence().get(), plankTxt);
		fenceGateBlock((FenceGateBlock) set.getFenceGate().get(), plankTxt);
		//doorBlock((DoorBlock) set.getDoor().get(), doorBottom, doorTop);
		trapdoorBlock((TrapDoorBlock) set.getTrapDoor().get(), trapDoorTxt, true);
		buttonBlock((ButtonBlock) set.getButton().get(), plankTxt);
		pressurePlateBlock((PressurePlateBlock) set.getPressurePlate().get(), plankTxt);
	}
}