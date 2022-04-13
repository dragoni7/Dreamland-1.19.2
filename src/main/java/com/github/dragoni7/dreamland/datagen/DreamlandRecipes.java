package com.github.dragoni7.dreamland.datagen;

import java.util.function.Consumer;

import com.github.dragoni7.dreamland.setup.DreamlandItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class DreamlandRecipes extends RecipeProvider{

	public DreamlandRecipes(DataGenerator genIn) {
		super(genIn);
	}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		/*
		 * ShapedRecipeBuilder.shaped(Registration.FIRSTBLOCK.get()) .pattern("xxx")
		 * .pattern("x#x") .pattern("xxx") .define('x', Tags.Items.COBBLESTONE)
		 * .define('#', Tags.Items.DYES_RED) .group("mytutorial")
		 * .unlockedBy("cobblestone",
		 * InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.COBBLESTONE))
		 * .save(consumer);
		 */
		  
		  createOreSmeltingRecipe(consumer, DreamlandItems.HIVE_COPPER.get(), Items.COPPER_INGOT, 0.7F, 200, "hive_copper_to_ingot");
		  createOreSmeltingRecipe(consumer, DreamlandItems.HIVE_IRON.get(), Items.IRON_INGOT, 0.7F, 200, "hive_iron_to_ingot");
		  createOreSmeltingRecipe(consumer, DreamlandItems.HIVE_REDSTONE.get(), Items.REDSTONE, 0.7F, 200, "hive_redstone_to_gem");
		  createOreSmeltingRecipe(consumer, DreamlandItems.HIVE_LAPIS.get(), Items.LAPIS_LAZULI, 0.2F, 200, "hive_lapis_to_gem");
		  createOreSmeltingRecipe(consumer, DreamlandItems.HIVE_GOLD.get(), Items.GOLD_INGOT, 1.0F, 200, "hive_gold_to_ingot");
		  createOreSmeltingRecipe(consumer, DreamlandItems.HIVE_DIAMOND.get(), Items.DIAMOND, 1.0F, 200, "hive_diamond_to_gem");
	}
	
	private void createOreSmeltingRecipe(Consumer<FinishedRecipe> consumer,Item input, Item output, float xp, int time, String name) {
		  SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), 
				  output, xp, time) 
		  .unlockedBy("has_ore", has(input))
		  .save(consumer, name);
		  SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), 
				  output, xp, time/2)
		  .unlockedBy("has_ore", has(input))
		  .save(consumer,name + "_blasting");
	}

}
