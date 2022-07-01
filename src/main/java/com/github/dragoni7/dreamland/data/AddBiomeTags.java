package com.github.dragoni7.dreamland.data;

import org.jetbrains.annotations.Nullable;

import com.github.dragoni7.dreamland.Dreamland;
import com.github.dragoni7.dreamland.common.world.biome.BiomeKeys;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class AddBiomeTags extends BiomeTagsProvider {

	public AddBiomeTags(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
		super(generator, Dreamland.MODID, existingFileHelper);
	}
	
	@Override
	protected void addTags() {
		tag(BiomeTags.IS_FOREST).add(BiomeKeys.JEWELED_FOREST);
		tag(BiomeTags.SPAWNS_WARM_VARIANT_FROGS).add(BiomeKeys.TAR_DELTAS);
		tag(Tags.Biomes.IS_DRY_OVERWORLD).add(BiomeKeys.TAR_DELTAS);
		tag(Tags.Biomes.IS_HOT_OVERWORLD).add(BiomeKeys.TAR_DELTAS);
		tag(Tags.Biomes.IS_SPOOKY).add(BiomeKeys.HIVE);
		tag(Tags.Biomes.IS_UNDERGROUND).add(BiomeKeys.HIVE);
		tag(Tags.Biomes.IS_DENSE_OVERWORLD).add(BiomeKeys.JEWELED_FOREST);
	}

}
