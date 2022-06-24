package com.github.dragoni7.dreamland.core.registry;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.blocks.tiles.AncientEggTile;
import com.github.dragoni7.dreamland.common.blocks.tiles.OpalDiffuserTile;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DreamlandTiles {

	public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Dreamland.MODID);
	
	public static final RegistryObject<BlockEntityType<AncientEggTile>> ANCIENT_EGG = TILES.register("ancient_egg_tile",
			() -> BlockEntityType.Builder.of(AncientEggTile::new, DreamlandBlocks.ANCIENT_EGG.block().get()).build(null));
	
	public static final RegistryObject<BlockEntityType<OpalDiffuserTile>> OPAL_DIFFUSER = TILES.register("opal_diffuser",
			() -> BlockEntityType.Builder.of(OpalDiffuserTile::new, DreamlandBlocks.OPAL_DIFFUSER_BLOCK.block().get()).build(null));
}
