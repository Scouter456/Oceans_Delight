package com.scouter.oceansdelight.datagen;

import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.items.ODItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.function.Consumer;

import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;

public class RecipeGenerator extends RecipeProvider implements IConditionBuilder {
    public RecipeGenerator(DataGenerator pGenerator) {
        super(pGenerator);
    }

    public static final int FAST_COOKING = 100;        // 5 seconds
    public static final int NORMAL_COOKING = 200;    // 10 seconds
    public static final int SLOW_COOKING = 400;        // 20 seconds

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ODItems.TENTACLE_ON_A_STICK.get(), 1)
                .requires(Items.STICK)
                .requires(ODItems.TENTACLES.get())
                .unlockedBy("has_tentacles", has(ODItems.TENTACLES.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ODItems.CABBAGE_WRAPPED_ELDER_GUARDIAN.get(), 1)
                .requires(ForgeTags.SALAD_INGREDIENTS_CABBAGE)
                .requires(ForgeTags.CROPS_ONION)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ODItems.COOKED_ELDER_GUARDIAN_SLICE.get())
                .unlockedBy("has_cooked_elder_guardian_slice", has(ODItems.COOKED_ELDER_GUARDIAN_SLICE.get()))
                .save(consumer);
        farmersDelightRecipes(consumer);
        cookMeals(consumer);
        cuttingAnimalItems(consumer);
        smeltingRecipes(consumer);
    }

    private void farmersDelightRecipes(Consumer<FinishedRecipe> consumer) {
        wrap(ShapelessRecipeBuilder.shapeless(ODItems.ELDER_GUARDIAN_ROLL.get())
                        .requires(ODItems.ELDER_GUARDIAN_SLICE.get(), 2)
                        .requires(ModItems.COOKED_RICE.get())
                        .unlockedBy("has_elder_guardian_slice", hasItems(ODItems.ELDER_GUARDIAN_SLICE.get()))
                , "food/elder_guardian_roll", consumer);
        wrap(ShapelessRecipeBuilder.shapeless(ODItems.FUGU_ROLL.get())
                        .requires(ODItems.FUGU_SLICE.get(), 2)
                        .requires(ModItems.COOKED_RICE.get())
                        .unlockedBy("has_fugu_slice", hasItems(ODItems.FUGU_SLICE.get()))
                , "food/fugu_roll", consumer);
    }

    private void cookMeals(Consumer<FinishedRecipe> consumer) {
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(ODItems.SQUID_RINGS.get(), 1, NORMAL_COOKING, 0.35F, Items.BOWL)
                        .addIngredient(ODItems.CUT_TENTACLES.get())
                        .addIngredient(ForgeTags.DOUGH)

                , "cooking/squid_rings", consumer);

        wrap(CookingPotRecipeBuilder.cookingPotRecipe(ODItems.BRAISED_SEA_PICKLE.get(), 1, NORMAL_COOKING, 0.35F, Items.BOWL)
                        .addIngredient(Items.SEA_PICKLE)
                        .addIngredient(Items.BROWN_MUSHROOM)
                        .addIngredient(Items.BROWN_MUSHROOM)
                , "cooking/braised_sea_pickle", consumer);

        wrap(CookingPotRecipeBuilder.cookingPotRecipe(ODItems.GUARDIAN_SOUP.get(), 1, NORMAL_COOKING, 0.35F, Items.BOWL)
                        .addIngredient(ODItems.GUARDIAN.get())
                        .addIngredient(ForgeTags.CROPS_ONION)
                        .addIngredient(ForgeTags.EGGS)
                        .addIngredient(ForgeTags.EGGS)
                        .addIngredient(ForgeTags.CROPS_TOMATO)
                        .addIngredient(ForgeTags.CROPS_TOMATO)

                , "cooking/guardian_soup", consumer);
    }

    private void cuttingAnimalItems(Consumer<FinishedRecipe> consumer) {
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.PUFFERFISH), Ingredient.of(ForgeTags.TOOLS_KNIVES), ODItems.FUGU_SLICE.get(), 6)
                        .addResult(Items.BONE_MEAL)
                , "cutting/pufferfish", consumer);

        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ODItems.TENTACLES.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), ODItems.CUT_TENTACLES.get(), 3)
                , "cutting/tentacles", consumer);
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ODItems.GUARDIAN.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), ODItems.GUARDIAN_TAIL.get(), 1)
                        .addResult(Items.BONE_MEAL)
                , "cutting/guardian", consumer);
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ODItems.ELDER_GUARDIAN_SLAB.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES), ODItems.ELDER_GUARDIAN_SLICE.get(), 9)
                        .addResult(Items.BONE_MEAL)
                , "cutting/elder_guardian_slab", consumer);
    }

    private void smeltingRecipes(Consumer<FinishedRecipe> consumer) {
        foodSmeltingRecipes("cooked_guardian_tail", ODItems.GUARDIAN_TAIL.get(), ODItems.COOKED_GUARDIAN_TAIL.get(), 0.45F, consumer);
        foodSmeltingRecipes("cooked_elder_guardian_slice", ODItems.ELDER_GUARDIAN_SLICE.get(), ODItems.COOKED_ELDER_GUARDIAN_SLICE.get(), 0.65F, consumer);
        foodSmeltingRecipes("baked_tentacle_on_a_stick", ODItems.TENTACLE_ON_A_STICK.get(), ODItems.BAKED_TENTACLE_ON_A_STICK.get(), 0.35F, consumer);

    }

    private void foodSmeltingRecipes(String name, ItemLike ingredient, ItemLike result, float experience, Consumer<FinishedRecipe> consumer) {
        String namePrefix = new ResourceLocation(FarmersDelight.MODID, name).toString();
        wrap(SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient),
                                result, experience, 200)
                        .unlockedBy(name, hasItems(ingredient))
                , name, consumer);
        wrap(SimpleCookingRecipeBuilder.cooking(Ingredient.of(ingredient),
                                result, experience, 600, RecipeSerializer.CAMPFIRE_COOKING_RECIPE)
                        .unlockedBy(name, hasItems(ingredient))
                , name + "_from_campfire_cooking", consumer);
        wrap(SimpleCookingRecipeBuilder.cooking(Ingredient.of(ingredient),
                                result, experience, 100, RecipeSerializer.SMOKING_RECIPE)
                        .unlockedBy(name, hasItems(ingredient))
                , name + "_from_smoking", consumer);
    }

    private void wrap(CuttingBoardRecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        wrap(builder, OceansDelight.MODID, name, consumer, modLoaded("farmersdelight"));
    }

    private void wrap(CuttingBoardRecipeBuilder builder, String modid, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        ResourceLocation loc = new ResourceLocation(modid, name);
        ConditionalRecipe.Builder cond;
        if (conds.length > 1) {
            cond = ConditionalRecipe.builder().addCondition(and(conds));
        } else if (conds.length == 1) {
            cond = ConditionalRecipe.builder().addCondition(conds[0]);
        } else {
            cond = ConditionalRecipe.builder();
        }
        FinishedRecipe[] recipe = new FinishedRecipe[1];
        builder.build(f -> recipe[0] = f, loc);
        cond.addRecipe(recipe[0])
                .build(consumer, loc);
    }

    private void wrap(CookingPotRecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        wrap(builder, OceansDelight.MODID, name, consumer, modLoaded("farmersdelight"));
    }

    private void wrap(CookingPotRecipeBuilder builder, String modid, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        ResourceLocation loc = new ResourceLocation(modid, name);
        ConditionalRecipe.Builder cond;
        if (conds.length > 1) {
            cond = ConditionalRecipe.builder().addCondition(and(conds));
        } else if (conds.length == 1) {
            cond = ConditionalRecipe.builder().addCondition(conds[0]);
        } else {
            cond = ConditionalRecipe.builder();
        }
        FinishedRecipe[] recipe = new FinishedRecipe[1];
        builder.build(f -> recipe[0] = f, loc);
        cond.addRecipe(recipe[0])
                .build(consumer, loc);
    }

    private void wrap(RecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        wrap(builder, OceansDelight.MODID, name, consumer, modLoaded("farmersdelight"));
    }

    private void wrap(RecipeBuilder builder, String modid, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        ResourceLocation loc = new ResourceLocation(modid, name);
        ConditionalRecipe.Builder cond;
        if (conds.length > 1) {
            cond = ConditionalRecipe.builder().addCondition(and(conds));
        } else if (conds.length == 1) {
            cond = ConditionalRecipe.builder().addCondition(conds[0]);
        } else {
            cond = ConditionalRecipe.builder();
        }
        FinishedRecipe[] recipe = new FinishedRecipe[1];
        builder.save(f -> recipe[0] = f, loc);
        cond.addRecipe(recipe[0])
                .generateAdvancement()
                .build(consumer, loc);
    }
}
