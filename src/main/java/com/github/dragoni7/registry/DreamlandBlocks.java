package com.github.dragoni7.registry;

import com.github.dragoni7.Dreamland;
import com.github.dragoni7.common.blocks.*;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;


public class DreamlandBlocks {

	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Dreamland.MODID);
	
	public static final RegistryObject<Block> BUMBLE_BLOCK = BLOCKS.register("bumble_block", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
	
	public static final RegistryObject<Block> DARK_QUARTZITE = BLOCKS.register("dark_quartzite", () -> new DarkQuartzite(BlockBehaviour.Properties.copy(Blocks.STONE)));
	
	public static final RegistryObject<Block> CLAY_SOIL = BLOCKS.register("clay_soil", () -> new ClaySoil(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundType.ROOTED_DIRT)));
	
	public static final RegistryObject<Block> CLAY_SOIL_GRASS = BLOCKS.register("clay_soil_grass", () -> new ClaySoilGrass(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));
	
	public static final RegistryObject<Block> POROUS_STONE = BLOCKS.register("porous_stone", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
	
	public static final RegistryObject<Block> ROOTED_POROUS_STONE = BLOCKS.register("rooted_porous_stone", () -> new BaseBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
	
	public static final RegistryObject<Block> DUSK_ICE = BLOCKS.register("dusk_ice", 
			() -> new DuskIce(BlockBehaviour.Properties
					.of(Material.ICE)
					.strength(0.5F)
					.sound(SoundType.GLASS)
					.randomTicks()
					.noOcclusion()
					.friction(0.98F)
					.hasPostProcess(DreamlandBlocks::always)
					.emissiveRendering(DreamlandBlocks::always)
					.lightLevel((p_152684_) -> {return 1;})
					));
	
	public static final RegistryObject<Block> SOLID_TAR = BLOCKS.register("solid_tar", 
			() -> new BaseBlock(BlockBehaviour.Properties
					.of(Material.CLAY)
					.strength(2.0F,6.0F)
					.sound(SoundType.CALCITE)
					));
	
	public static final RegistryObject<Block> TOXIC_ROCK = BLOCKS.register("toxic_rock", 
			() -> new BaseBlock(BlockBehaviour.Properties
					.of(Material.STONE)
					.strength(2.0F,6.0F)
					.sound(SoundType.CALCITE)
					));
	
	public static final RegistryObject<Block> HIVE_BLOCK = BLOCKS.register("hive_block", 
			() -> new BaseBlock(BlockBehaviour.Properties
					.of(Material.STONE)
					.strength(2.0F,6.0F)
					.sound(SoundType.NETHERRACK)
					));
	
	public static final RegistryObject<Block> CAVE_SLIME = BLOCKS.register("cave_slime", 
			() -> new CaveSlime(BlockBehaviour.Properties
					.of(Material.PLANT)
					.strength(2.0F,6.0F)
					.sound(SoundType.HONEY_BLOCK)
					.noCollission()
					.lightLevel(CaveSlimePlant.emission(5))
					));
	
	public static final RegistryObject<Block> CAVE_SLIME_PLANT = BLOCKS.register("cave_slime_plant", 
			() -> new CaveSlimePlant(BlockBehaviour.Properties
					.of(Material.PLANT)
					.strength(2.0F,6.0F)
					.sound(SoundType.HONEY_BLOCK)
					.noCollission()
					.lightLevel(CaveSlimePlant.emission(5))
					));
	
	public static final RegistryObject<Block> HIVE_JELLY = BLOCKS.register("hive_jelly",
			() -> new EmissiveBlock(BlockBehaviour.Properties
					.of(Material.SPONGE)
					.strength(2.0F,6.0F)
					.sound(SoundType.SLIME_BLOCK)
					.noOcclusion()
					.lightLevel(EmissiveBlock.emission(7))
					));
	
	public static final RegistryObject<Block> HIVE_SLUDGE = BLOCKS.register("hive_sludge",
			() -> new EmissiveBlock(BlockBehaviour.Properties
					.of(Material.SPONGE)
					.strength(2.0F, 6.0F)
					.sound(SoundType.SLIME_BLOCK)
					.lightLevel(EmissiveBlock.emission(5))
					));
	
	public static final RegistryObject<Block> HIVE_IRON = createHiveOre("hive_iron");
	public static final RegistryObject<Block> HIVE_GOLD = createHiveOre("hive_gold");
	public static final RegistryObject<Block> HIVE_REDSTONE = createHiveOre("hive_redstone");
	public static final RegistryObject<Block> HIVE_DIAMOND = createHiveOre("hive_diamond");
	public static final RegistryObject<Block> HIVE_COPPER = createHiveOre("hive_copper");
	public static final RegistryObject<Block> HIVE_LAPIS = createHiveOre("hive_lapis");
	
	private static RegistryObject<Block> createHiveOre(String name) {
		return BLOCKS.register(name,
				() -> new BaseBlock(BlockBehaviour.Properties
						.of(Material.STONE)
						.strength(3.0F,3.0F)
						.sound(SoundType.NETHERRACK)
						.requiresCorrectToolForDrops()
						));
	}
	
	private static boolean always(BlockState state, BlockGetter getter, BlockPos pos) {
	      return true;
	   }
}
