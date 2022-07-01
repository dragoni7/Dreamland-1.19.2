package com.github.dragoni7.dreamland.data;

import java.util.function.Consumer;

import com.github.dragoni7.dreamland.core.registry.DreamlandBlocks;
import com.github.dragoni7.dreamland.core.registry.DreamlandItems;
import com.github.dragoni7.dreamland.core.registry.DreamlandWoodSets;
import com.github.dragoni7.dreamland.util.WoodSet;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class DreamlandRecipes extends RecipeProvider{

	public DreamlandRecipes(DataGenerator genIn) {
		super(genIn);
	}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		
		  ShapedRecipeBuilder.shaped(DreamlandBlocks.OPAL_DIFFUSER_BLOCK.block().get())
		  .pattern(" # ")
		  .pattern("ggg")
		  .pattern("ddd")
		  .define('d', Tags.Items.COBBLESTONE_DEEPSLATE)
		  .define('g', Tags.Items.INGOTS_GOLD)
		  .define('#', DreamlandItems.PRECIOUS_OPAL.get())
		  .group("dreamland").unlockedBy("precious_opal", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandItems.PRECIOUS_OPAL.get())).save(consumer);
		  
		  ShapedRecipeBuilder.shaped(DreamlandBlocks.OPAL_BLOCK.block().get())
		  .pattern("###")
		  .pattern("###")
		  .pattern("###")
		  .define('#', DreamlandItems.OPAL.get())
		  .group("dreamland").unlockedBy("opal", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandItems.OPAL.get())).save(consumer);
		  
		  ShapelessRecipeBuilder.shapeless(DreamlandItems.OPAL.get(), 9)
		  .requires(DreamlandBlocks.OPAL_BLOCK.item().get())
		  .group("dreamland").unlockedBy("opal_block", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandBlocks.OPAL_BLOCK.item().get())).save(consumer);
		  
		  ShapedRecipeBuilder.shaped(DreamlandBlocks.PRECIOUS_OPAL_BLOCK.block().get())
		  .pattern("###")
		  .pattern("###")
		  .pattern("###")
		  .define('#', DreamlandItems.PRECIOUS_OPAL.get())
		  .group("dreamland").unlockedBy("precious_opal", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandItems.PRECIOUS_OPAL.get())).save(consumer);
		  
		  ShapelessRecipeBuilder.shapeless(DreamlandItems.PRECIOUS_OPAL.get(), 9)
		  .requires(DreamlandBlocks.PRECIOUS_OPAL_BLOCK.item().get())
		  .group("dreamland").unlockedBy("precious_opal_block", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandBlocks.PRECIOUS_OPAL_BLOCK.item().get())).save(consumer);
		  
		  ShapelessRecipeBuilder.shapeless(DreamlandBlocks.PACKED_TAR_MUD.block().get())
		  .requires(Tags.Items.CROPS_WHEAT)
		  .requires(DreamlandBlocks.TAR_MUD.item().get())
		  .group("dreamland").unlockedBy("tar_mud", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandBlocks.TAR_MUD.item().get())).save(consumer);
		  
		  ShapedRecipeBuilder.shaped(DreamlandBlocks.TAR_MUD_BRICKS.block().get(), 4)
		  .pattern("## ")
		  .pattern("## ")
		  .define('#', DreamlandBlocks.PACKED_TAR_MUD.item().get())
		  .group("dreamland").unlockedBy("packed_tar_mud", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandBlocks.PACKED_TAR_MUD.item().get())).save(consumer);
		  
		  ShapelessRecipeBuilder.shapeless(DreamlandBlocks.JEWELED_DEEPSLATE.item().get())
		  .requires(DreamlandItems.PRECIOUS_OPAL.get())
		  .requires(DreamlandItems.OPAL.get(), 2)
		  .requires(Items.CHISELED_DEEPSLATE)
		  .group("dreamland").unlockedBy("precious_opal", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandItems.PRECIOUS_OPAL.get())).save(consumer);
		  
		  ShapedRecipeBuilder.shaped(DreamlandBlocks.OPAL_TILE.block().get(), 4)
		  .pattern("## ")
		  .pattern("## ")
		  .define('#', DreamlandBlocks.OPAL_BLOCK.item().get())
		  .group("dreamland").unlockedBy("opal", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandItems.OPAL.get())).save(consumer);
		  
		  ShapedRecipeBuilder.shaped(DreamlandBlocks.PRECIOUS_OPAL_TILE.block().get(), 4)
		  .pattern("## ")
		  .pattern("## ")
		  .define('#', DreamlandBlocks.PRECIOUS_OPAL_BLOCK.item().get())
		  .group("dreamland").unlockedBy("precious_opal", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandItems.PRECIOUS_OPAL.get())).save(consumer);
		  
		  slabBuilder(DreamlandBlocks.OPAL_SLAB.item().get(),
				  Ingredient.of(DreamlandBlocks.OPAL_TILE.item().get())).group("dreamland").unlockedBy("opal_tile", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandBlocks.OPAL_TILE.item().get())).save(consumer);
		  stairBuilder(DreamlandBlocks.OPAL_STAIRS.item().get(),
				  Ingredient.of(DreamlandBlocks.OPAL_TILE.item().get())).group("dreamland").unlockedBy("opal_tile", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandBlocks.OPAL_TILE.item().get())).save(consumer);
		  wallBuilder(DreamlandBlocks.OPAL_WALL.item().get(),
				  Ingredient.of(DreamlandBlocks.OPAL_TILE.item().get())).group("dreamland").unlockedBy("opal_tile", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandBlocks.OPAL_TILE.item().get())).save(consumer);
		  slabBuilder(DreamlandBlocks.PRECIOUS_OPAL_SLAB.item().get(),
				  Ingredient.of(DreamlandBlocks.OPAL_TILE.item().get())).group("dreamland").unlockedBy("precious_opal_tile", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandBlocks.PRECIOUS_OPAL_TILE.item().get())).save(consumer);
		  stairBuilder(DreamlandBlocks.PRECIOUS_OPAL_STAIRS.item().get(),
				  Ingredient.of(DreamlandBlocks.OPAL_TILE.item().get())).group("dreamland").unlockedBy("precious_opal_tile", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandBlocks.PRECIOUS_OPAL_TILE.item().get())).save(consumer);
		  wallBuilder(DreamlandBlocks.PRECIOUS_OPAL_WALL.item().get(),
				  Ingredient.of(DreamlandBlocks.OPAL_TILE.item().get())).group("dreamland").unlockedBy("precious_opal_tile", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandBlocks.PRECIOUS_OPAL_TILE.item().get())).save(consumer);
		  
		  slabBuilder(DreamlandBlocks.TAR_MUD_BRICK_SLAB.item().get(),
				  Ingredient.of(DreamlandBlocks.TAR_MUD_BRICKS.item().get())).group("dreamland").unlockedBy("tar_mud_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandBlocks.TAR_MUD_BRICKS.item().get())).save(consumer);
		  stairBuilder(DreamlandBlocks.TAR_MUD_BRICK_STAIRS.item().get(),
				  Ingredient.of(DreamlandBlocks.TAR_MUD_BRICKS.item().get())).group("dreamland").unlockedBy("tar_mud_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandBlocks.TAR_MUD_BRICKS.item().get())).save(consumer);
		  wallBuilder(DreamlandBlocks.TAR_MUD_BRICK_WALL.item().get(),
				  Ingredient.of(DreamlandBlocks.TAR_MUD_BRICKS.item().get())).group("dreamland").unlockedBy("tar_mud_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(DreamlandBlocks.TAR_MUD_BRICKS.item().get())).save(consumer);
		  
		  stonecutterResultFromBase(consumer, DreamlandBlocks.TAR_MUD_BRICK_SLAB.item().get(), DreamlandBlocks.TAR_MUD_BRICKS.item().get(), 2);
		  stonecutterResultFromBase(consumer, DreamlandBlocks.TAR_MUD_BRICK_STAIRS.item().get(), DreamlandBlocks.TAR_MUD_BRICKS.item().get());
		  stonecutterResultFromBase(consumer, DreamlandBlocks.TAR_MUD_BRICK_WALL.item().get(), DreamlandBlocks.TAR_MUD_BRICKS.item().get());
		  
		  createWoodSetRecipes(consumer, DreamlandWoodSets.PLUM_BIRCH);
		  createWoodSetRecipes(consumer, DreamlandWoodSets.TAR_BARK);
		  
		  createOreSmeltingRecipe(consumer, DreamlandBlocks.HIVE_COPPER.item().get(), Items.COPPER_INGOT, 0.7F, 200, "hive_copper_to_ingot");
		  createOreSmeltingRecipe(consumer, DreamlandBlocks.HIVE_IRON.item().get(), Items.IRON_INGOT, 0.7F, 200, "hive_iron_to_ingot");
		  createOreSmeltingRecipe(consumer, DreamlandBlocks.HIVE_REDSTONE.item().get(), Items.REDSTONE, 0.7F, 200, "hive_redstone_to_gem");
		  createOreSmeltingRecipe(consumer, DreamlandBlocks.HIVE_LAPIS.item().get(), Items.LAPIS_LAZULI, 0.2F, 200, "hive_lapis_to_gem");
		  createOreSmeltingRecipe(consumer, DreamlandBlocks.HIVE_GOLD.item().get(), Items.GOLD_INGOT, 1.0F, 200, "hive_gold_to_ingot");
		  createOreSmeltingRecipe(consumer, DreamlandBlocks.HIVE_DIAMOND.item().get(), Items.DIAMOND, 1.0F, 200, "hive_diamond_to_gem");
	}
	
	private void createWoodSetRecipes(Consumer<FinishedRecipe> consumer, WoodSet set) {
		String name = set.getSetName();
		
		ShapelessRecipeBuilder.shapeless(set.plank().item().get(), 4)
		  .requires(set.getlogItemTag())
		  .group("dreamland").unlockedBy(name + "_log", InventoryChangeTrigger.TriggerInstance.hasItems(set.log().item().get())).save(consumer);
		
		ShapedRecipeBuilder.shaped(set.strippedWood().item().get(), 3)
		  .pattern("## ")
		  .pattern("## ")
		  .define('#', set.strippedLog().item().get())
		  .group("dreamland").unlockedBy(name + "_stripped_log", InventoryChangeTrigger.TriggerInstance.hasItems(set.strippedLog().item().get())).save(consumer);
		  
		ShapedRecipeBuilder.shaped(set.wood().item().get(), 3)
		  .pattern("## ")
		  .pattern("## ")
		  .define('#', set.log().item().get())
		  .group("dreamland").unlockedBy(name + "_log", InventoryChangeTrigger.TriggerInstance.hasItems(set.log().item().get())).save(consumer);
		
		ShapedRecipeBuilder.shaped(set.ladder().item().get(), 4)
		  .pattern("# #")
		  .pattern("#s#")
		  .pattern("# #")
		  .define('#', Items.STICK)
		  .define('s', set.slab().item().get())
		  .group("dreamland").unlockedBy(name + "_slab", InventoryChangeTrigger.TriggerInstance.hasItems(set.slab().item().get())).save(consumer);
		  
		slabBuilder(set.slab().item().get(), 
				Ingredient.of(set.plank().item().get())).group("dreamland").unlockedBy(name + "_slab", InventoryChangeTrigger.TriggerInstance.hasItems(set.plank().item().get())).save(consumer);
		
		stairBuilder(set.stair().item().get(), 
				Ingredient.of(set.plank().item().get())).group("dreamland").unlockedBy(name + "_stair", InventoryChangeTrigger.TriggerInstance.hasItems(set.plank().item().get())).save(consumer);
		
		fenceBuilder(set.fence().item().get(), 
				Ingredient.of(set.plank().item().get())).group("dreamland").unlockedBy(name + "_fence", InventoryChangeTrigger.TriggerInstance.hasItems(set.plank().item().get())).save(consumer);
		
		buttonBuilder(set.button().item().get(), 
				Ingredient.of(set.plank().item().get())).group("dreamland").unlockedBy(name + "_button", InventoryChangeTrigger.TriggerInstance.hasItems(set.plank().item().get())).save(consumer);
		
		pressurePlateBuilder(set.pressurePlate().item().get(), 
				Ingredient.of(set.plank().item().get())).group("dreamland").unlockedBy(name + "_pressure_plate", InventoryChangeTrigger.TriggerInstance.hasItems(set.plank().item().get())).save(consumer);
		
		doorBuilder(set.door().item().get(), 
				Ingredient.of(set.plank().item().get())).group("dreamland").unlockedBy(name + "_door", InventoryChangeTrigger.TriggerInstance.hasItems(set.plank().item().get())).save(consumer);
		
		trapdoorBuilder(set.trapDoor().item().get(), 
				Ingredient.of(set.plank().item().get())).group("dreamland").unlockedBy(name + "_trap_door", InventoryChangeTrigger.TriggerInstance.hasItems(set.plank().item().get())).save(consumer);
		
		fenceGateBuilder(set.fenceGate().item().get(), 
				Ingredient.of(set.plank().item().get())).group("dreamland").unlockedBy(name + "_fence_gate", InventoryChangeTrigger.TriggerInstance.hasItems(set.plank().item().get())).save(consumer);
	}
	
	private void createOreSmeltingRecipe(Consumer<FinishedRecipe> consumer,Item input, Item output, float xp, int time, String name) {
		  SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), 
				  output, xp, time) 
		  .unlockedBy("has_ore", has(input))
		  .save(consumer, name);
		  SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), 
				  output, xp, time/2)
		  .unlockedBy("has_ore", has(input))
		  .save(consumer, name + "_blasting");
	}

}
