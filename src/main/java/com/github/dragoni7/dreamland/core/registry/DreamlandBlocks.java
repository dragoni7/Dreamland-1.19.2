package com.github.dragoni7.dreamland.core.registry;

import java.util.function.Supplier;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.blocks.CaveSlime;
import com.github.dragoni7.dreamland.common.blocks.CaveSlimePlant;
import com.github.dragoni7.dreamland.common.blocks.ClaySoil;
import com.github.dragoni7.dreamland.common.blocks.ClaySoilGrass;
import com.github.dragoni7.dreamland.common.blocks.DarkQuartzite;
import com.github.dragoni7.dreamland.common.blocks.DreamlandSapling;
import com.github.dragoni7.dreamland.common.blocks.DuskIce;
import com.github.dragoni7.dreamland.common.blocks.EmissiveHiveBlock;
import com.github.dragoni7.dreamland.common.blocks.FloweringUndergrowthBlock;
import com.github.dragoni7.dreamland.common.blocks.GroundPlant;
import com.github.dragoni7.dreamland.common.blocks.HiveBlock;
import com.github.dragoni7.dreamland.common.blocks.HiveCluster;
import com.github.dragoni7.dreamland.common.blocks.HiveGrowth;
import com.github.dragoni7.dreamland.common.blocks.HiveMembrane;
import com.github.dragoni7.dreamland.common.blocks.HiveMembraneCore;
import com.github.dragoni7.dreamland.common.blocks.InfestedHiveCluster;
import com.github.dragoni7.dreamland.common.blocks.JellySplotch;
import com.github.dragoni7.dreamland.common.blocks.LarvaAngerableBlock;
import com.github.dragoni7.dreamland.common.blocks.TarSprouts;
import com.github.dragoni7.dreamland.common.blocks.UndergrowthBlock;
import com.github.dragoni7.dreamland.core.BlockItemSet;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.MudBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DreamlandBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Dreamland.MODID);
	
	public static final BlockItemSet BUMBLE_BLOCK = new BlockItemSet("bumble_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.YELLOW_WOOL)));
	
	public static final BlockItemSet DARK_QUARTZITE = new BlockItemSet("dark_quartzite", () -> new DarkQuartzite(BlockBehaviour.Properties.copy(Blocks.STONE)));
	
	public static final BlockItemSet CLAY_SOIL = new BlockItemSet("clay_soil", () -> new ClaySoil(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundType.ROOTED_DIRT)));
	
	public static final BlockItemSet CLAY_SOIL_GRASS = new BlockItemSet("clay_soil_grass", () -> new ClaySoilGrass((BlockBehaviour.Properties.of(Material.GRASS).randomTicks().strength(0.6F).sound(SoundType.GRASS))));
	
	public static final BlockItemSet DUSK_ICE = new BlockItemSet("dusk_ice", 
			() -> new DuskIce(BlockBehaviour.Properties
					.of(Material.ICE)
					.strength(0.5F)
					.sound(SoundType.GLASS)
					.randomTicks()
					.noOcclusion()
					.friction(0.98F)
					.hasPostProcess(DreamlandBlocks::always)
					.emissiveRendering(DreamlandBlocks::always)
					));
	
	public static final BlockItemSet HIVE_BLOCK = new BlockItemSet("hive_block", 
			() -> new HiveBlock(BlockBehaviour.Properties
					.of(Material.STONE, MaterialColor.COLOR_PURPLE)
					.requiresCorrectToolForDrops()
					.strength(1.5F, 6.0F)
					.sound(DreamlandSoundTypes.HIVE_BLOCK)
					));
	
	public static final BlockItemSet CAVE_SLIME = new BlockItemSet("cave_slime", 
			() -> new CaveSlime(BlockBehaviour.Properties
					.of(Material.PLANT, MaterialColor.COLOR_CYAN)
					.sound(SoundType.HONEY_BLOCK)
					.noCollission()
					.instabreak()
					.randomTicks()
					.lightLevel(CaveSlimePlant.emission(5))
					));
	
	public static final RegistryObject<Block> CAVE_SLIME_PLANT = BLOCKS.register("cave_slime_plant", 
			() -> new CaveSlimePlant(BlockBehaviour.Properties
					.of(Material.PLANT, MaterialColor.COLOR_CYAN)
					.sound(SoundType.HONEY_BLOCK)
					.noCollission()
					.instabreak()
					.lightLevel(CaveSlimePlant.emission(5))
					));
	
	public static final BlockItemSet HIVE_JELLY_CLUSTER = new BlockItemSet("hive_jelly_cluster",
			() -> new HiveCluster(BlockBehaviour.Properties
					.of(Material.CLAY, MaterialColor.COLOR_CYAN)
					.strength(1.5F, 6.0F)
					.requiresCorrectToolForDrops()
					.sound(SoundType.SLIME_BLOCK)
					.noOcclusion()
					.lightLevel(HiveCluster.emission(5))
					));
	
	public static final BlockItemSet INFESTED_HIVE_JELLY_CLUSTER = new BlockItemSet("infested_hive_jelly_cluster",
			() -> new InfestedHiveCluster(BlockBehaviour.Properties
					.of(Material.CLAY, MaterialColor.COLOR_CYAN)
					.strength(1.5F, 6.0F)
					.requiresCorrectToolForDrops()
					.sound(SoundType.SLIME_BLOCK)
					.noOcclusion()
					.randomTicks()
					.lightLevel(InfestedHiveCluster.emission(5))
					));
	
	public static final BlockItemSet HIVE_MEMBRANE = new BlockItemSet("hive_membrane",
			() -> new HiveMembrane(BlockBehaviour.Properties
					.of(Material.SPONGE, MaterialColor.COLOR_CYAN)
					.strength(-1.0F, 3600000.0F)
					.noLootTable()
					.sound(SoundType.SLIME_BLOCK)
					.noOcclusion()
					.randomTicks()
					.hasPostProcess(DreamlandBlocks::always)
					.emissiveRendering(DreamlandBlocks::always)
					.lightLevel((p_152684_) -> {return 1;})
					));
	
	public static final BlockItemSet HIVE_MEMBRANE_CORE = new BlockItemSet("hive_membrane_core",
			() -> new HiveMembraneCore(BlockBehaviour.Properties
					.of(Material.SPONGE, MaterialColor.COLOR_CYAN)
					.strength(1.5F, 6.0F)
					.requiresCorrectToolForDrops()
					.sound(DreamlandSoundTypes.HIVE_BLOCK)
					.noOcclusion()));
	
	public static final BlockItemSet HIVE_BLOCK_WITH_JELLY = new BlockItemSet("hive_block_with_jelly",
			() -> new EmissiveHiveBlock(BlockBehaviour.Properties
					.of(Material.SPONGE)
					.strength(1.5F, 6.0F)
					.requiresCorrectToolForDrops()
					.sound(DreamlandSoundTypes.HIVE_BLOCK)
					.lightLevel(EmissiveHiveBlock.emission(6))
					));
	
	public static final BlockItemSet HIVE_GROWTH = new BlockItemSet("hive_growth",
			() -> new HiveGrowth(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_RED).noOcclusion().sound(SoundType.MOSS_CARPET).instabreak()
					));
	
	public static final RegistryObject<Block> JELLY_SPLOTCH = BLOCKS.register("jelly_splotch",
			() -> new JellySplotch(BlockBehaviour.Properties
					.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_CYAN)
					.strength(0.2F)
					.noCollission()
					.sound(SoundType.HONEY_BLOCK)
					.lightLevel(JellySplotch.emission(7))
					));
	
	public static final BlockItemSet HIVE_IRON = createHiveOre("hive_iron");
	public static final BlockItemSet HIVE_GOLD = createHiveOre("hive_gold");
	public static final BlockItemSet HIVE_REDSTONE = createHiveOre("hive_redstone");
	public static final BlockItemSet HIVE_DIAMOND = createHiveOre("hive_diamond");
	public static final BlockItemSet HIVE_COPPER = createHiveOre("hive_copper");
	public static final BlockItemSet HIVE_LAPIS = createHiveOre("hive_lapis");
	
	public static final BlockItemSet DRIED_TAR = new BlockItemSet("dried_tar",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));
	
	public static final BlockItemSet TAR_SOIL = new BlockItemSet("tar_soil",
			() -> new MudBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundType.MUD).color(MaterialColor.COLOR_PURPLE)));
	
	public static final BlockItemSet DROUGHT_SOIL = createDirtBlock("drought_soil");
	
	public static final BlockItemSet TAR_BARK_SAPLING = createSaplingBlock("tar_bark_sapling", DreamlandFeatures.TAR_BARK_TREE_FEATURE);
	
	public static final BlockItemSet TAR_SPROUTS = new BlockItemSet("tar_sprouts",
			() -> new TarSprouts(BlockBehaviour.Properties.copy(Blocks.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
	
	public static final BlockItemSet TAR_BARK_LEAVES = createLeavesBlock("tar_bark_leaves", MaterialColor.COLOR_LIGHT_GREEN);
	
	public static final BlockItemSet PLUM_BIRCH_LEAVES = createLeavesBlock("plum_birch_leaves", MaterialColor.COLOR_BLUE);
	
	public static final BlockItemSet MINERAL_DIRT = createDirtBlock("mineral_dirt");
	
	public static final BlockItemSet FLOWERING_GRASS = new BlockItemSet("flowering_grass",
			() -> new FloweringUndergrowthBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).color(MaterialColor.COLOR_PINK)));
	
	public static final BlockItemSet OPALINE_MARIGOLD = new BlockItemSet("opaline_marigold",
			() -> new FlowerBlock(MobEffects.LUCK, 5, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
	
	public static final BlockItemSet PINK_CRAB_GRASS = new BlockItemSet("pink_crab_grass",
			() -> new GroundPlant(BlockBehaviour.Properties.copy(Blocks.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
	
	public static final BlockItemSet FLOWERING_UNDERGROWTH = new BlockItemSet("flowering_undergrowth",
			() -> new UndergrowthBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).offsetType(BlockBehaviour.OffsetType.NONE)));
	
	public static final BlockItemSet PLUM_BIRCH_SAPLING = createSaplingBlock("plum_birch_sapling", DreamlandFeatures.PLUM_BIRCH_TREE_FEATURE);
	
	private static BlockItemSet createSaplingBlock(String name, Feature<NoneFeatureConfiguration> tree) {
		return new BlockItemSet(name, () -> new DreamlandSapling(tree, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	}
	
	private static BlockItemSet createLeavesBlock(String name, MaterialColor color) {
		return new BlockItemSet(name, () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, color).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)));
	}
	
	private static BlockItemSet createDirtBlock(String name) {
		return new BlockItemSet(name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
	}
	
	private static BlockItemSet createHiveOre(String name) {
		return new BlockItemSet(name,
				() -> new LarvaAngerableBlock(BlockBehaviour.Properties
						.of(Material.STONE)
						.strength(3.0F, 3.0F)
						.sound(DreamlandSoundTypes.HIVE_BLOCK)
						.requiresCorrectToolForDrops()
						));
	}
	
	private static boolean always(BlockState state, BlockGetter getter, BlockPos pos) {
	      return true;
	   }
}
