package com.github.dragoni7.dreamland.common.world.feature.generation;

import com.github.dragoni7.dreamland.common.world.feature.util.FeatureBuilder;
import com.github.dragoni7.dreamland.common.world.feature.util.OpenSimplex2S;
import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.util.RollBoolean;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class OpalCluster extends Feature<NoneFeatureConfiguration> {
	
	private static final BlockState CALCITE = Blocks.CALCITE.defaultBlockState();
	private static final BlockState BASE = Blocks.SMOOTH_BASALT.defaultBlockState();

	public OpalCluster(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel worldgenlevel = context.level();
		BlockPos origin = context.origin();
		RandomSource rand = context.random();
		boolean status = false;
		FeatureBuilder builder = new FeatureBuilder();
		BlockState state = DreamlandBlocks.OPAL_CLUSTER.block().get().defaultBlockState();
		
		if (RollBoolean.roll(5, rand)) {
			state = Blocks.BUDDING_AMETHYST.defaultBlockState();
		}
		
		int xRadius = rand.nextIntBetweenInclusive(1, 2);
		int yRadius = rand.nextIntBetweenInclusive(2, 4);
		int zRadius = rand.nextIntBetweenInclusive(1, 2);
		
		float noise = OpenSimplex2S.noise3_ImproveXY(worldgenlevel.getSeed(), origin.north().getX(), origin.north().getY(), origin.north().getZ());
		
		status = builder.addInput(worldgenlevel, BASE, origin, true);
		status = builder.addInput(worldgenlevel, BASE, origin.north(), true);
		
		if (noise > 0) {
			status = builder.addInput(worldgenlevel, BASE, origin.north().east(), true);
		}
		else {
			status = builder.addInput(worldgenlevel, BASE, origin.south().west(), true);
		}
		
		noise = OpenSimplex2S.noise3_ImproveXY(worldgenlevel.getSeed(), origin.south().getX(), origin.south().getY(), origin.south().getZ());
		
		status = builder.addInput(worldgenlevel, BASE, origin.south(), true);
		
		if (noise > 0) {
			status = builder.addInput(worldgenlevel, BASE, origin.south().east(), true);
		}
		else {
			status = builder.addInput(worldgenlevel, BASE, origin.south().west(), true);
		}
		
		status = builder.addInput(worldgenlevel, BASE, origin.east(), true);
		status = builder.addInput(worldgenlevel, BASE, origin.west(), true);
		
		status = builder.addInput(worldgenlevel, state, origin.above(yRadius + 1), true);
		
		origin = origin.above();
		
		for (int x = -xRadius; x < xRadius; x++) {
			for (int y = 0; y < yRadius; y++) {
				for (int z = -zRadius; z < zRadius; z++) {
					
					BlockPos pos = origin.offset(x, y, z);
					double distance = Mth.square((double)x/xRadius) + Mth.square((double)y/yRadius) + Mth.square((double)z/zRadius);
					noise = OpenSimplex2S.noise3_ImproveXY(worldgenlevel.getSeed(), x, y, z);
					BlockState state1;
					
					if ((distance < 1 && distance > 0.8) && noise < 0) {
						state1 = state;
					} 
					else if (distance < 1 + Mth.nextDouble(rand, 0.1, 0.3)) {
						state1 = CALCITE;
					}
					else {
						continue;
					}
					
					if (!worldgenlevel.getBlockState(pos).is(BlockTags.FEATURES_CANNOT_REPLACE)) {
						status = builder.addInput(worldgenlevel, state1, pos, true);
					}
				}
			}
		}
		
		builder.build(worldgenlevel);
		return status;
	}

}
