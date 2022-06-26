package com.github.dragoni7.dreamland.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class WoodSet {
	
	private String setName;
	
	private MaterialColor color;
	
	private BlockItemSet LOG;
	
	private BlockItemSet STRIPPED_LOG;
	
	private BlockItemSet WOOD;
	
	private BlockItemSet PLANK;
	
	private BlockItemSet SLAB;
	
	private BlockItemSet STAIR;
	
	private BlockItemSet FENCE;
	
	private BlockItemSet FENCE_GATE;
	
	private BlockItemSet DOOR;
	
	private BlockItemSet TRAPDOOR;
	
	private BlockItemSet BUTTON;
	
	private BlockItemSet PRESSURE_PLATE;
	
	private BlockItemSet LADDER;
	
	public WoodSet(String name, MaterialColor color) {
		this.setName = name;
		this.color = color;
		
		register();
	}
	
	private void register() {
		LOG = new BlockItemSet(setName + "_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0F)));
		STRIPPED_LOG = new BlockItemSet(setName + "_stripped_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0F)));
		WOOD = new BlockItemSet(setName + "_wood", ()-> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, color).sound(SoundType.WOOD).strength(2.0F, 3.0F)));
		PLANK = new BlockItemSet(setName + "_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, color).sound(SoundType.WOOD).strength(2.0F, 3.0F)));
		SLAB = new BlockItemSet(setName + "_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F)));
		STAIR = new BlockItemSet(setName + "_stairs", () -> new StairBlock(() -> PLANK.block().get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F).noOcclusion()));
		FENCE = new BlockItemSet(setName + "_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F)));
		FENCE_GATE = new BlockItemSet(setName + "_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F)));
		DOOR = new BlockItemSet(setName + "_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F).noOcclusion()));
		TRAPDOOR = new BlockItemSet(setName + "_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F).noOcclusion()));
		BUTTON = new BlockItemSet(setName + "_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
		PRESSURE_PLATE = new BlockItemSet(setName + "_pressure_plate", () -> new PressurePlateBlock(Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, color).noCollission().strength(0.5F).sound(SoundType.WOOD)));
		LADDER = new BlockItemSet(setName + "_ladder", () -> new LadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.WOOD).strength(2.0F, 3.0F).noOcclusion()));
	}

	public String getSetName() {
		return setName;
	}

	public BlockItemSet log() {
		return LOG;
	}

	public BlockItemSet strippedLog() {
		return STRIPPED_LOG;
	}
	
	public BlockItemSet plank() {
		return PLANK;
	}

	public BlockItemSet slab() {
		return SLAB;
	}

	public BlockItemSet stair() {
		return STAIR;
	}

	public BlockItemSet fence() {
		return FENCE;
	}

	public BlockItemSet fenceGate() {
		return FENCE_GATE;
	}

	public BlockItemSet door() {
		return DOOR;
	}

	public BlockItemSet trapDoor() {
		return TRAPDOOR;
	}

	public BlockItemSet button() {
		return BUTTON;
	}

	public BlockItemSet pressurePlate() {
		return PRESSURE_PLATE;
	}

	public BlockItemSet ladder() {
		return LADDER;
	}

	public BlockItemSet wood() {
		return WOOD;
	}
}
