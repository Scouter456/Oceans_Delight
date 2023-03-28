package com.scouter.oceansdelight.items;

import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class ODFoods {

    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes
    public static final FoodProperties TENTACLES = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, BRIEF_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties CUT_TENTACLES = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.1F)
            .build();

    public static final FoodProperties SQUID_RINGS = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.5F)
            .build();

    public static final FoodProperties TENTACLE_ON_A_STICK = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.3F)
            .build();

    public static final FoodProperties BAKED_TENTACLE_ON_A_STICK = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(0.6F)
            .build();

    public static final FoodProperties GUARDIAN_TAIL = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.2F)
            .build();

    public static final FoodProperties COOKED_GUARDIAN_TAIL = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(0.4F)
            .build();

    public static final FoodProperties BOWL_OF_GUARDIAN_SOUP = new FoodProperties.Builder()
            .nutrition(15)
            .saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0F)
            .build();
    public static final FoodProperties ELDER_GUARDIAN_SLAB = new FoodProperties.Builder()
            .nutrition(9)
            .saturationMod(0.4F)
            .build();

    public static final FoodProperties ELDER_GUARDIAN_SLICE = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3000, 0), 0.5F)
            .build();

    public static final FoodProperties COOKED_ELDER_GUARDIAN_SLICE = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.3F)
            .fast()
            .build();
    public static final FoodProperties ELDER_GUARDIAN_ROLL = new FoodProperties.Builder()
            .nutrition(7)
            .saturationMod(0.6F)
            .build();

    public static final FoodProperties CABBAGE_WRAPPED_ELDER_GUARDIAN = new FoodProperties.Builder()
            .nutrition(15)
            .saturationMod(1F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), BRIEF_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties BRAISED_SEA_PICKLE = new FoodProperties.Builder()
            .nutrition(8)
            .saturationMod(0.5F)
            .build();

    public static final FoodProperties FUGU_SLICE = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.1F)
            .fast()
            .build();

    public static final FoodProperties FUGU_ROLL = new FoodProperties.Builder()
            .nutrition(7)
            .saturationMod(0.6F)
            .build();
}


