package com.scouter.oceansdelight.datagen;

import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.items.ODItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.concurrent.CompletableFuture;

import static com.scouter.oceansdelight.OceansDelight.prefix;
import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;

public class RecipeGenerator extends RecipeProvider implements IConditionBuilder {
    public RecipeGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(pOutput, lookupProvider);
    }

    public static final int FAST_COOKING = 100;        // 5 seconds
    public static final int NORMAL_COOKING = 200;    // 10 seconds
    public static final int SLOW_COOKING = 400;        // 20 seconds

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ODItems.TENTACLE_ON_A_STICK.get(), 1)
                .requires(Items.STICK)
                .requires(ODItems.TENTACLES.get())
                .unlockedBy("has_tentacles", has(ODItems.TENTACLES.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,ODItems.CABBAGE_WRAPPED_ELDER_GUARDIAN.get(), 1)
                .requires(CommonTags.FOODS_CABBAGE)
                .requires(CommonTags.CROPS_ONION)
                .requires(CommonTags.CROPS_TOMATO)
                .requires(ODItems.COOKED_ELDER_GUARDIAN_SLICE.get())
                .unlockedBy("has_cooked_elder_guardian_slice", has(ODItems.COOKED_ELDER_GUARDIAN_SLICE.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,ODItems.STUFFED_COD.get(), 1)
                .requires(Items.KELP)
                .requires(CommonTags.CROPS_ONION)
                .requires(CommonTags.CROPS_TOMATO)
                .requires(Items.BROWN_MUSHROOM)
                .requires(ModItems.ROPE.get())
                .requires(Items.COD)
                .unlockedBy("has_kelp", has(Items.KELP))
                .unlockedBy("has_cod", has(Items.COD))
                .unlockedBy("has_onion", has(CommonTags.CROPS_ONION))
                .unlockedBy("has_brown_mushroom", has(Items.BROWN_MUSHROOM))
                .unlockedBy("has_rope", has(ModItems.ROPE.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,ODItems.SEAGRASS_SALAD.get(), 1)
                .requires(Items.SEAGRASS)
                .requires(Items.BOWL)
                .unlockedBy("has_seagrass", has(Items.SEAGRASS))
                .unlockedBy("has_bowl", has(Items.BOWL))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,ODItems.STUFFED_SQUID.get(), 1)
                .requires(ODItems.TENTACLES)
                .requires(ModItems.RICE.get())
                .requires(Items.KELP)
                .unlockedBy("has_tentacle", has(ODItems.TENTACLES.get()))
                .unlockedBy("has_rice", has(ModItems.RICE.get()))
                .unlockedBy("has_kelp", has(Items.KELP))
                .save(pRecipeOutput);


        farmersDelightRecipes(pRecipeOutput);
        cookMeals(pRecipeOutput);
        cuttingAnimalItems(pRecipeOutput);
        smeltingRecipes(pRecipeOutput);
    }

    private void farmersDelightRecipes(RecipeOutput consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,ODItems.ELDER_GUARDIAN_ROLL.get())
                        .requires(ODItems.ELDER_GUARDIAN_SLICE.get(), 2)
                        .requires(ModItems.COOKED_RICE.get())
                        .unlockedBy("has_elder_guardian_slice", hasItems(ODItems.ELDER_GUARDIAN_SLICE.get()))
                .save(consumer, prefix("food/elder_guardian_roll"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,ODItems.FUGU_ROLL.get())
                        .requires(ODItems.FUGU_SLICE.get(), 2)
                        .requires(ModItems.COOKED_RICE.get())
                        .unlockedBy("has_fugu_slice", hasItems(ODItems.FUGU_SLICE.get()))
                .save(consumer,prefix("food/fugu_roll"));
    }

    private void cookMeals(RecipeOutput consumer) {
        CookingPotRecipeBuilder.cookingPotRecipe(ODItems.SQUID_RINGS.get(), 1, NORMAL_COOKING, 0.35F, Items.BOWL)
                        .addIngredient(ODItems.CUT_TENTACLES.get())
                        .addIngredient(CommonTags.FOODS_DOUGH)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(
                        consumer,prefix("cooking/squid_rings")
                );

        CookingPotRecipeBuilder.cookingPotRecipe(ODItems.HONEY_FRIED_KELP.get(), 1, NORMAL_COOKING, 0.35F)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.DRIED_KELP)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(
                        consumer,prefix("cooking/honey_fried_kelp")
                );

        CookingPotRecipeBuilder.cookingPotRecipe(ODItems.BRAISED_SEA_PICKLE.get(), 1, NORMAL_COOKING, 0.35F, Items.BOWL)
                        .addIngredient(Items.SEA_PICKLE)
                        .addIngredient(Items.BROWN_MUSHROOM)
                        .addIngredient(Items.BROWN_MUSHROOM)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(
                        consumer, prefix("cooking/braised_sea_pickle")
                );

        CookingPotRecipeBuilder.cookingPotRecipe(ODItems.GUARDIAN_SOUP.get(), 1, NORMAL_COOKING, 0.35F, Items.BOWL)
                        .addIngredient(ODItems.GUARDIAN.get())
                        .addIngredient(CommonTags.CROPS_ONION)
                        .addIngredient(Tags.Items.EGGS)
                        .addIngredient(Tags.Items.EGGS)
                        .addIngredient(CommonTags.CROPS_TOMATO)
                        .addIngredient(CommonTags.CROPS_TOMATO)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(
                        consumer,prefix("cooking/guardian_soup")
                );

        CookingPotRecipeBuilder.cookingPotRecipe(ODItems.KELP_ENCRUSTED_COD.get(), 1, NORMAL_COOKING, 0.35F)
                .addIngredient(ModItems.COD_SLICE.get())
                .addIngredient(Tags.Items.EGGS)
                .addIngredient(Items.KELP)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(
                        consumer,prefix("cooking/kelp_encrusted_cod")
                );



    }

    private void cuttingAnimalItems(RecipeOutput consumer) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.PUFFERFISH), Ingredient.of(CommonTags.TOOLS_KNIFE), ODItems.FUGU_SLICE.get(), 6)
                        .addResult(Items.BONE_MEAL).build(
                                consumer , prefix("cutting/pufferfish"
                ));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ODItems.TENTACLES.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), ODItems.CUT_TENTACLES.get(), 3)
                .build(consumer, prefix("cutting/tentacles"));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ODItems.GUARDIAN.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), ODItems.GUARDIAN_TAIL.get(), 1)
                        .addResult(Items.BONE_MEAL).build(consumer, prefix("cutting/guardian"));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ODItems.ELDER_GUARDIAN_SLAB.get()), Ingredient.of(CommonTags.TOOLS_KNIFE), ODItems.ELDER_GUARDIAN_SLICE.get(), 9)
                        .addResult(Items.BONE_MEAL).build(consumer, prefix("cutting/elder_guardian_slab"));
    }

    private void smeltingRecipes(RecipeOutput consumer) {
        foodSmeltingRecipes("cooked_guardian_tail", ODItems.GUARDIAN_TAIL.get(), ODItems.COOKED_GUARDIAN_TAIL.get(), 0.45F, consumer);
        foodSmeltingRecipes("cooked_elder_guardian_slice", ODItems.ELDER_GUARDIAN_SLICE.get(), ODItems.COOKED_ELDER_GUARDIAN_SLICE.get(), 0.65F, consumer);
        foodSmeltingRecipes("baked_tentacle_on_a_stick", ODItems.TENTACLE_ON_A_STICK.get(), ODItems.BAKED_TENTACLE_ON_A_STICK.get(), 0.35F, consumer);
        foodSmeltingRecipes("cooked_stuffed_cod", ODItems.STUFFED_COD.get(), ODItems.COOKED_STUFFED_COD.get(), 0.35F, consumer);
        foodSmeltingRecipes("cooked_stuffed_squid", ODItems.STUFFED_SQUID.get(), ODItems.COOKED_STUFFED_SQUID.get(), 0.35F, consumer);

    }

    private static void foodSmeltingRecipes(String name, ItemLike ingredient, ItemLike result, float experience, RecipeOutput output) {
        String namePrefix = ResourceLocation.fromNamespaceAndPath(OceansDelight.MODID, name).toString();
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 200)
                .unlockedBy(name, InventoryChangeTrigger.TriggerInstance.hasItems(ingredient))
                .save(output);
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 600)
                .unlockedBy(name, InventoryChangeTrigger.TriggerInstance.hasItems(ingredient))
                .save(output, namePrefix + "_from_campfire_cooking");
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 100)
                .unlockedBy(name, InventoryChangeTrigger.TriggerInstance.hasItems(ingredient))
                .save(output, namePrefix + "_from_smoking");
    }


}
