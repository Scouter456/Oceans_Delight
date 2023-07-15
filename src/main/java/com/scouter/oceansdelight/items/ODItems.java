package com.scouter.oceansdelight.items;


import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.blocks.ODBlocks;
import com.scouter.oceansdelight.setup.Registration;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ODItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OceansDelight.MODID);

    //From Blocks

    public static final RegistryObject<Item> TENTACLES = ITEMS.register("tentacles", () -> new Item(new Item.Properties()
            .food(ODFoods.TENTACLES)));

    public static final RegistryObject<Item> CUT_TENTACLES = ITEMS.register("cut_tentacles", () -> new Item(new Item.Properties()
            .food(ODFoods.CUT_TENTACLES)));

    public static final RegistryObject<Item> SQUID_RINGS = ITEMS.register("squid_rings", () -> new Item(new Item.Properties()
            .food(ODFoods.SQUID_RINGS)));

    public static final RegistryObject<Item> TENTACLE_ON_A_STICK = ITEMS.register("tentacle_on_a_stick", () -> new Item(new Item.Properties()
            .food(ODFoods.TENTACLE_ON_A_STICK)));

    public static final RegistryObject<Item> BAKED_TENTACLE_ON_A_STICK = ITEMS.register("baked_tentacle_on_a_stick", () -> new Item(new Item.Properties()
            .food(ODFoods.BAKED_TENTACLE_ON_A_STICK)));

    public static final RegistryObject<Item> GUARDIAN = ITEMS.register("guardian", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GUARDIAN_SOUP = fromBlock(ODBlocks.GUARDIAN_SOUP);
    public static final RegistryObject<Item> GUARDIAN_TAIL = ITEMS.register("guardian_tail", () -> new Item(new Item.Properties()
            .food(ODFoods.GUARDIAN_TAIL)));

    public static final RegistryObject<Item> COOKED_GUARDIAN_TAIL = ITEMS.register("cooked_guardian_tail", () -> new Item(new Item.Properties()
            .food(ODFoods.COOKED_GUARDIAN_TAIL)));


    public static final RegistryObject<Item> BOWL_OF_GUARDIAN_SOUP = ITEMS.register("bowl_of_guardian_soup", () -> new Item(new Item.Properties().craftRemainder(Items.BOWL)
            .food(ODFoods.BOWL_OF_GUARDIAN_SOUP)));

    public static final RegistryObject<Item> ELDER_GUARDIAN_SLAB = ITEMS.register("elder_guardian_slab", () -> new Item(new Item.Properties()
            .food(ODFoods.ELDER_GUARDIAN_SLAB)));

    public static final RegistryObject<Item> ELDER_GUARDIAN_SLICE = ITEMS.register("elder_guardian_slice", () -> new Item(new Item.Properties()
            .food(ODFoods.ELDER_GUARDIAN_SLICE)));

    public static final RegistryObject<Item> COOKED_ELDER_GUARDIAN_SLICE = ITEMS.register("cooked_elder_guardian_slice", () -> new Item(new Item.Properties()
            .food(ODFoods.COOKED_ELDER_GUARDIAN_SLICE)));

    public static final RegistryObject<Item> ELDER_GUARDIAN_ROLL = ITEMS.register("elder_guardian_roll", () -> new Item(new Item.Properties()
            .food(ODFoods.ELDER_GUARDIAN_ROLL)));

    public static final RegistryObject<Item> CABBAGE_WRAPPED_ELDER_GUARDIAN = ITEMS.register("cabbage_wrapped_elder_guardian", () -> new Item(new Item.Properties()
            .food(ODFoods.CABBAGE_WRAPPED_ELDER_GUARDIAN)));

    public static final RegistryObject<Item> FUGU_SLICE = ITEMS.register("fugu_slice", () -> new Item(new Item.Properties()
            .food(ODFoods.FUGU_SLICE)));

    public static final RegistryObject<Item> FUGU_ROLL = ITEMS.register("fugu_roll", () -> new Item(new Item.Properties()
            .food(ODFoods.FUGU_ROLL)));

    public static final RegistryObject<Item> BRAISED_SEA_PICKLE = ITEMS.register("braised_sea_pickle", () -> new Item(new Item.Properties()
            .food(ODFoods.BRAISED_SEA_PICKLE)));



    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
