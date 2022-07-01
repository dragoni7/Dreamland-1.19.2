package com.github.dragoni7.dreamland.util;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
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
import com.github.dragoni7.dreamland.common.blocks.StrippablePillarBlock;

public class WoodSet {
	
	private String setName;
	
	private final TagKey<Item> logItemTag;
	
	private final TagKey<Block> logBlockTag;
	
	private MaterialColor color;
	
	private BlockItemSet log;
	
	private BlockItemSet stripped_log;
	
	private BlockItemSet wood;
	
	private BlockItemSet stripped_wood;
	
	private BlockItemSet plank;
	
	private BlockItemSet slab;
	
	private BlockItemSet stairs;
	
	private BlockItemSet fence;
	
	private BlockItemSet fence_gate;
	
	private BlockItemSet door;
	
	private BlockItemSet trapdoor;
	
	private BlockItemSet button;
	
	private BlockItemSet pressure_plate;
	
	private BlockItemSet ladder;
	
	public WoodSet(String name, MaterialColor color) {
		this.setName = name;
		this.color = color;
		
		this.logItemTag = TagCreator.dreamlandItemTag(setName + "_logs");
		this.logBlockTag = TagCreator.dreamlandBlockTag(setName + "_logs");
		
		register();
		
		
	}
	
	private void register() {
		stripped_log = new BlockItemSet(setName + "_stripped_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0F)));
		log = new BlockItemSet(setName + "_log", () -> new StrippablePillarBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0F), () -> stripped_log.block().get()));
		wood = new BlockItemSet(setName + "_wood", ()-> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, color).sound(SoundType.WOOD).strength(2.0F, 3.0F)));
		stripped_wood = new BlockItemSet(setName + "_stripped_wood", ()-> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, color).sound(SoundType.WOOD).strength(2.0F, 3.0F)));
		plank = new BlockItemSet(setName + "_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, color).sound(SoundType.WOOD).strength(2.0F, 3.0F)));
		slab = new BlockItemSet(setName + "_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F)));
		stairs = new BlockItemSet(setName + "_stairs", () -> new StairBlock(() -> plank.block().get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F).noOcclusion()));
		fence = new BlockItemSet(setName + "_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F)));
		fence_gate = new BlockItemSet(setName + "_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F)));
		door = new BlockItemSet(setName + "_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F).noOcclusion()));
		trapdoor = new BlockItemSet(setName + "_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F).noOcclusion()));
		button = new BlockItemSet(setName + "_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
		pressure_plate = new BlockItemSet(setName + "_pressure_plate", () -> new PressurePlateBlock(Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, color).noCollission().strength(0.5F).sound(SoundType.WOOD)));
		ladder = new BlockItemSet(setName + "_ladder", () -> new LadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.WOOD).strength(2.0F, 3.0F).noOcclusion()));
	}

	public String getSetName() {
		return setName;
	}
	
	public TagKey<Item> getlogItemTag() {
		return logItemTag;
	}
	
	public TagKey<Block> getlogBlockTag() {
		return logBlockTag;
	}

	public BlockItemSet log() {
		return log;
	}

	public BlockItemSet strippedLog() {
		return stripped_log;
	}
	
	public BlockItemSet plank() {
		return plank;
	}

	public BlockItemSet slab() {
		return slab;
	}

	public BlockItemSet stair() {
		return stairs;
	}

	public BlockItemSet fence() {
		return fence;
	}

	public BlockItemSet fenceGate() {
		return fence_gate;
	}

	public BlockItemSet door() {
		return door;
	}

	public BlockItemSet trapDoor() {
		return trapdoor;
	}

	public BlockItemSet button() {
		return button;
	}

	public BlockItemSet pressurePlate() {
		return pressure_plate;
	}

	public BlockItemSet ladder() {
		return ladder;
	}

	public BlockItemSet wood() {
		return wood;
	}
	
	public BlockItemSet strippedWood() {
		return stripped_wood;
	}
}
