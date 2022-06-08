package com.github.dragoni7.dreamland.core.registry;

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
import com.github.dragoni7.dreamland.common.blocks.InfestedHiveCluster;
import com.github.dragoni7.dreamland.common.blocks.JellySplotch;
import com.github.dragoni7.dreamland.common.blocks.LarvaAngerableBlock;
import com.github.dragoni7.dreamland.common.blocks.TarSprouts;
import com.github.dragoni7.dreamland.common.blocks.UndergrowthBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TallGrassBlock;
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
	
	public static final RegistryObject<Block> BUMBLE_BLOCK = BLOCKS.register("bumble_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.YELLOW_WOOL)));
	
	public static final RegistryObject<Block> DARK_QUARTZITE = BLOCKS.register("dark_quartzite", () -> new DarkQuartzite(BlockBehaviour.Properties.copy(Blocks.STONE)));
	
	public static final RegistryObject<Block> CLAY_SOIL = BLOCKS.register("clay_soil", () -> new ClaySoil(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundType.ROOTED_DIRT)));
	
	public static final RegistryObject<Block> CLAY_SOIL_GRASS = BLOCKS.register("clay_soil_grass", () -> new ClaySoilGrass((BlockBehaviour.Properties.of(Material.GRASS).randomTicks().strength(0.6F).sound(SoundType.GRASS))));
	
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
					));
	
	public static final RegistryObject<Block> HIVE_BLOCK = BLOCKS.register("hive_block", 
			() -> new HiveBlock(BlockBehaviour.Properties
					.of(Material.STONE, MaterialColor.COLOR_PURPLE)
					.requiresCorrectToolForDrops()
					.strength(1.5F,6.0F)
					.sound(SoundType.NETHERRACK)
					.randomTicks()
					));
	
	public static final RegistryObject<Block> CAVE_SLIME = BLOCKS.register("cave_slime", 
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
	
	public static final RegistryObject<Block> HIVE_JELLY_CLUSTER = BLOCKS.register("hive_jelly_cluster",
			() -> new HiveCluster(BlockBehaviour.Properties
					.of(Material.CLAY, MaterialColor.COLOR_CYAN)
					.strength(1.5F, 6.0F)
					.requiresCorrectToolForDrops()
					.sound(SoundType.SLIME_BLOCK)
					.noOcclusion()
					.lightLevel(HiveCluster.emission(5))
					));
	
	public static final RegistryObject<Block> INFESTED_HIVE_JELLY_CLUSTER = BLOCKS.register("infested_hive_jelly_cluster",
			() -> new InfestedHiveCluster(BlockBehaviour.Properties
					.of(Material.CLAY, MaterialColor.COLOR_CYAN)
					.strength(1.5F, 6.0F)
					.requiresCorrectToolForDrops()
					.sound(SoundType.SLIME_BLOCK)
					.noOcclusion()
					.randomTicks()
					.lightLevel(InfestedHiveCluster.emission(5))
					));
	
	public static final RegistryObject<Block> HIVE_MEMBRANE = BLOCKS.register("hive_membrane",
			() -> new HiveMembrane(BlockBehaviour.Properties
					.of(Material.SPONGE, MaterialColor.COLOR_CYAN)
					.strength(1.5F, 6.0F)
					.requiresCorrectToolForDrops()
					.sound(SoundType.SLIME_BLOCK)
					.noOcclusion()
					.hasPostProcess(DreamlandBlocks::always)
					.emissiveRendering(DreamlandBlocks::always)
					.lightLevel((p_152684_) -> {return 1;})
					));
	
	public static final RegistryObject<Block> HIVE_BLOCK_WITH_JELLY = BLOCKS.register("hive_block_with_jelly",
			() -> new EmissiveHiveBlock(BlockBehaviour.Properties
					.of(Material.SPONGE)
					.strength(1.5F, 6.0F)
					.requiresCorrectToolForDrops()
					.sound(SoundType.SLIME_BLOCK)
					.lightLevel(EmissiveHiveBlock.emission(6))
					));
	
	public static final RegistryObject<Block> HIVE_GROWTH = BLOCKS.register("hive_growth",
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
	
	public static final RegistryObject<Block> HIVE_IRON = createHiveOre("hive_iron");
	public static final RegistryObject<Block> HIVE_GOLD = createHiveOre("hive_gold");
	public static final RegistryObject<Block> HIVE_REDSTONE = createHiveOre("hive_redstone");
	public static final RegistryObject<Block> HIVE_DIAMOND = createHiveOre("hive_diamond");
	public static final RegistryObject<Block> HIVE_COPPER = createHiveOre("hive_copper");
	public static final RegistryObject<Block> HIVE_LAPIS = createHiveOre("hive_lapis");
	
	public static final RegistryObject<Block> DRIED_TAR = BLOCKS.register("dried_tar",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE)));
	
	public static final RegistryObject<Block> TAR_SOIL = BLOCKS.register("tar_soil",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.SOUL_SOIL).sound(SoundType.ROOTED_DIRT)));
	
	public static final RegistryObject<Block> DROUGHT_SOIL = createDirtBlock("drought_soil");
	
	public static final RegistryObject<Block> TAR_BARK_SAPLING = createSaplingBlock("tar_bark_sapling", DreamlandFeatures.TAR_BARK_TREE_FEATURE);
	
	public static final RegistryObject<Block> TAR_SPROUTS = BLOCKS.register("tar_sprouts",
			() -> new TarSprouts(BlockBehaviour.Properties.copy(Blocks.GRASS)));
	
	public static final RegistryObject<Block> TAR_BARK_LEAVES = createLeavesBlock("tar_bark_leaves", MaterialColor.COLOR_LIGHT_GREEN);
	
	public static final RegistryObject<Block> PLUM_BIRCH_LEAVES = createLeavesBlock("plum_birch_leaves", MaterialColor.COLOR_BLUE);
	
	public static final RegistryObject<Block> MINERAL_DIRT = createDirtBlock("mineral_dirt");
	
	public static final RegistryObject<Block> FLOWERING_GRASS = BLOCKS.register("flowering_grass",
			() -> new FloweringUndergrowthBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).color(MaterialColor.COLOR_PINK)));
	
	public static final RegistryObject<Block> OPALINE_MARIGOLD = BLOCKS.register("opaline_marigold",
			() -> new FlowerBlock(MobEffects.LUCK, 5, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
	
	public static final RegistryObject<Block> PINK_CRAB_GRASS = BLOCKS.register("pink_crab_grass",
			() -> new GroundPlant(BlockBehaviour.Properties.copy(Blocks.GRASS)));
	
	public static final RegistryObject<Block> FLOWERING_UNDERGROWTH = BLOCKS.register("flowering_undergrowth",
			() -> new UndergrowthBlock(BlockBehaviour.Properties.copy(Blocks.GRASS)));
	
	public static final RegistryObject<Block> PLUM_BIRCH_SAPLING = createSaplingBlock("plum_birch_sapling", DreamlandFeatures.PLUM_BIRCH_TREE_FEATURE);
	
	private static RegistryObject<Block> createSaplingBlock(String name, Feature<NoneFeatureConfiguration> tree) {
		return BLOCKS.register(name, () -> new DreamlandSapling(tree, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	}
	
	private static RegistryObject<Block> createLeavesBlock(String name, MaterialColor color) {
		return BLOCKS.register(name, () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, color).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)));
	}
	
	private static RegistryObject<Block> createDirtBlock(String name) {
		return BLOCKS.register(name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
	}
	
	private static RegistryObject<Block> createHiveOre(String name) {
		return BLOCKS.register(name,
				() -> new LarvaAngerableBlock(BlockBehaviour.Properties
						.of(Material.STONE)
						.strength(3.0F, 3.0F)
						.sound(SoundType.NETHERRACK)
						.requiresCorrectToolForDrops()
						));
	}
	
	private static boolean always(BlockState state, BlockGetter getter, BlockPos pos) {
	      return true;
	   }
}
