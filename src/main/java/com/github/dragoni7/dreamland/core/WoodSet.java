package com.github.dragoni7.dreamland.core;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
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
import net.minecraftforge.registries.RegistryObject;

public class WoodSet {
	
	private String setName;
	
	private MaterialColor color;
	
	private RegistryObject<Block> LOG;
	
	private RegistryObject<Block> STRIPPED_LOG;
	
	private RegistryObject<Block> WOOD;
	
	private RegistryObject<Block> PLANK;
	
	private RegistryObject<Block> SLAB;
	
	private RegistryObject<Block> STAIR;
	
	private RegistryObject<Block> FENCE;
	
	private RegistryObject<Block> FENCE_GATE;
	
	private RegistryObject<Block> DOOR;
	
	private RegistryObject<Block> TRAPDOOR;
	
	private RegistryObject<Block> BUTTON;
	
	private RegistryObject<Block> PRESSURE_PLATE;
	
	private RegistryObject<Block> LADDER;	
	
	private RegistryObject<Item> LOG_ITEM;
	
	private RegistryObject<Item> STRIPPED_LOG_ITEM;
	
	private RegistryObject<Item> WOOD_ITEM;
	
	private RegistryObject<Item> PLANK_ITEM;
	
	private RegistryObject<Item> SLAB_ITEM;
	
	private RegistryObject<Item> STAIR_ITEM;
	
	private RegistryObject<Item> FENCE_ITEM;
	
	private RegistryObject<Item> FENCE_GATE_ITEM;
	
	private RegistryObject<Item> DOOR_ITEM;
	
	private RegistryObject<Item> TRAPDOOR_ITEM;
	
	private RegistryObject<Item> BUTTON_ITEM;
	
	private RegistryObject<Item> PRESSURE_PLATE_ITEM;
	
	private RegistryObject<Item> LADDER_ITEM;
	
	public WoodSet(String name, MaterialColor color) {
		this.setName = name;
		this.color = color;
		
		registerBlocks();
		registerItems();
		
	}
	
	private void registerBlocks() {
		LOG = DreamlandBlocks.BLOCKS.register(setName + "_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0F)));
		STRIPPED_LOG = DreamlandBlocks.BLOCKS.register(setName + "_stripped_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0F)));
		WOOD = DreamlandBlocks.BLOCKS.register(setName + "_wood", ()-> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, color).sound(SoundType.WOOD).strength(2.0F, 3.0F)));
		PLANK = DreamlandBlocks.BLOCKS.register(setName + "_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, color).sound(SoundType.WOOD).strength(2.0F, 3.0F)));
		SLAB = DreamlandBlocks.BLOCKS.register(setName + "_slab", () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F)));
		STAIR = DreamlandBlocks.BLOCKS.register(setName + "_stairs", () -> new StairBlock(() -> PLANK.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F).noOcclusion()));
		FENCE = DreamlandBlocks.BLOCKS.register(setName + "_fence", () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F)));
		FENCE_GATE = DreamlandBlocks.BLOCKS.register(setName + "_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F)));
		DOOR = DreamlandBlocks.BLOCKS.register(setName + "_door", () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F).noOcclusion()));
		TRAPDOOR = DreamlandBlocks.BLOCKS.register(setName + "_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F).noOcclusion()));
		BUTTON = DreamlandBlocks.BLOCKS.register(setName + "_button", () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD)));
		PRESSURE_PLATE = DreamlandBlocks.BLOCKS.register(setName + "_pressure_plate", () -> new PressurePlateBlock(Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, color).noCollission().strength(0.5F).sound(SoundType.WOOD)));
		LADDER = DreamlandBlocks.BLOCKS.register(setName + "_ladder", () -> new LadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.WOOD).strength(2.0F, 3.0F).noOcclusion()));
	}
	
	private void registerItems() {
		LOG_ITEM = registerBlockItem(setName + "_log", LOG);
		STRIPPED_LOG_ITEM = registerBlockItem(setName + "_stripped_log", STRIPPED_LOG);
		WOOD_ITEM = registerBlockItem(setName + "_wood", WOOD);
		PLANK_ITEM = registerBlockItem(setName + "_planks", PLANK);
		SLAB_ITEM = registerBlockItem(setName + "_slab", SLAB);
		STAIR_ITEM = registerBlockItem(setName + "_stairs", STAIR);
		FENCE_ITEM = registerBlockItem(setName + "_fence", FENCE);
		FENCE_GATE_ITEM = registerBlockItem(setName + "_fence_gate", FENCE_GATE);
		DOOR_ITEM = registerBlockItem(setName + "_door", DOOR);
		TRAPDOOR_ITEM = registerBlockItem(setName + "_trapdoor", TRAPDOOR);
		BUTTON_ITEM = registerBlockItem(setName + "_button", BUTTON);
		PRESSURE_PLATE_ITEM = registerBlockItem(setName + "_pressure_plate", PRESSURE_PLATE);
		LADDER_ITEM = registerBlockItem(setName + "_ladder", LADDER);
		
	}
	
	private static RegistryObject<Item> registerBlockItem(String name, RegistryObject<Block> block) {
		
		return DreamlandItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(Dreamland.DreamlandTab)));
		
	}

	public String getSetName() {
		return setName;
	}

	public RegistryObject<Block> getLog() {
		return LOG;
	}

	public RegistryObject<Block> getStrippedLog() {
		return STRIPPED_LOG;
	}
	
	public RegistryObject<Block> getPlank() {
		return PLANK;
	}

	public RegistryObject<Block> getSlab() {
		return SLAB;
	}

	public RegistryObject<Block> getStair() {
		return STAIR;
	}

	public RegistryObject<Block> getFence() {
		return FENCE;
	}

	public RegistryObject<Block> getFenceGate() {
		return FENCE_GATE;
	}

	public RegistryObject<Block> getDoor() {
		return DOOR;
	}

	public RegistryObject<Block> getTrapDoor() {
		return TRAPDOOR;
	}

	public RegistryObject<Block> getButton() {
		return BUTTON;
	}

	public RegistryObject<Block> getPressurePlate() {
		return PRESSURE_PLATE;
	}

	public RegistryObject<Block> getLadder() {
		return LADDER;
	}

	public RegistryObject<Block> getWood() {
		return WOOD;
	}

	public RegistryObject<Item> getLogItem() {
		return LOG_ITEM;
	}

	public RegistryObject<Item> getStrippedLogItem() {
		return STRIPPED_LOG_ITEM;
	}

	public RegistryObject<Item> getWoodItem() {
		return WOOD_ITEM;
	}

	public RegistryObject<Item> getPlankItem() {
		return PLANK_ITEM;
	}

	public RegistryObject<Item> getSlabItem() {
		return SLAB_ITEM;
	}

	public RegistryObject<Item> getStairItem() {
		return STAIR_ITEM;
	}

	public RegistryObject<Item> getFenceItem() {
		return FENCE_ITEM;
	}

	public RegistryObject<Item> getFenceGateItem() {
		return FENCE_GATE_ITEM;
	}

	public RegistryObject<Item> getDoorItem() {
		return DOOR_ITEM;
	}

	public RegistryObject<Item> getTrapDoorItem() {
		return TRAPDOOR_ITEM;
	}

	public RegistryObject<Item> getButtonItem() {
		return BUTTON_ITEM;
	}

	public RegistryObject<Item> getPressurePlateItem() {
		return PRESSURE_PLATE_ITEM;
	}

	public RegistryObject<Item> getLadderItem() {
		return LADDER_ITEM;
	}	
}
