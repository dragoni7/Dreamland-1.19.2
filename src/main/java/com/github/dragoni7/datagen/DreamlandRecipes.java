package com.github.dragoni7.datagen;

import java.util.function.Consumer;

import com.github.dragoni7.Dreamland;
import com.github.dragoni7.registry.DreamlandItems;

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
		  
		  createOreSmeltingRecipe(consumer, DreamlandItems.HIVE_COPPER.get(), Items.COPPER_INGOT, "hive_copper_to_ingot");
		  createOreSmeltingRecipe(consumer, DreamlandItems.HIVE_IRON.get(), Items.IRON_INGOT, "hive_iron_to_ingot");
		  createOreSmeltingRecipe(consumer, DreamlandItems.HIVE_REDSTONE.get(), Items.REDSTONE, "hive_redstone_to_gem");
		  createOreSmeltingRecipe(consumer, DreamlandItems.HIVE_LAPIS.get(), Items.LAPIS_LAZULI, "hive_lapis_to_gem");
		  createOreSmeltingRecipe(consumer, DreamlandItems.HIVE_GOLD.get(), Items.GOLD_INGOT, "hive_gold_to_ingot");
		  createOreSmeltingRecipe(consumer, DreamlandItems.HIVE_DIAMOND.get(), Items.DIAMOND, "hive_diamond_to_gem");
	}
	
	private void createOreSmeltingRecipe(Consumer<FinishedRecipe> consumer,Item input, Item output, String name) {
		  SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), 
				  output, 1.0F, 100) 
		  .unlockedBy("has_ore", has(input))
		  .save(consumer, name);
	}

}
