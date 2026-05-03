package com.scouter.oceansdelight.items;


import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.blocks.ODBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ODItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OceansDelight.MODID);

    //From Blocks

    public static final DeferredItem<Item> TENTACLES = ITEMS.register("tentacles", () -> new Item(new Item.Properties()
            .food(ODFoods.TENTACLES)));

    public static final DeferredItem<Item> CUT_TENTACLES = ITEMS.register("cut_tentacles", () -> new Item(new Item.Properties()
            .food(ODFoods.CUT_TENTACLES)));

    public static final DeferredItem<Item> SQUID_RINGS = ITEMS.register("squid_rings", () -> new Item(new Item.Properties()
            .food(ODFoods.SQUID_RINGS).craftRemainder(Items.BOWL)));

    public static final DeferredItem<Item> TENTACLE_ON_A_STICK = ITEMS.register("tentacle_on_a_stick", () -> new Item(new Item.Properties()
            .food(ODFoods.TENTACLE_ON_A_STICK)));

    public static final DeferredItem<Item> BAKED_TENTACLE_ON_A_STICK = ITEMS.register("baked_tentacle_on_a_stick", () -> new Item(new Item.Properties()
            .food(ODFoods.BAKED_TENTACLE_ON_A_STICK)));

    public static final DeferredItem<Item> STUFFED_SQUID = ITEMS.register("stuffed_squid", () -> new Item(new Item.Properties()
            .food(ODFoods.STUFFED_SQUID)));

    public static final DeferredItem<Item> COOKED_STUFFED_SQUID = ITEMS.register("cooked_stuffed_squid", () -> new Item(new Item.Properties()
            .food(ODFoods.COOKED_STUFFED_SQUID)));



    public static final DeferredItem<Item> GUARDIAN = ITEMS.register("guardian", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GUARDIAN_SOUP = fromBlock(ODBlocks.GUARDIAN_SOUP);
    public static final DeferredItem<Item> GUARDIAN_TAIL = ITEMS.register("guardian_tail", () -> new Item(new Item.Properties()
            .food(ODFoods.GUARDIAN_TAIL)));

    public static final DeferredItem<Item> COOKED_GUARDIAN_TAIL = ITEMS.register("cooked_guardian_tail", () -> new Item(new Item.Properties()
            .food(ODFoods.COOKED_GUARDIAN_TAIL)));


    public static final DeferredItem<Item> BOWL_OF_GUARDIAN_SOUP = ITEMS.register("bowl_of_guardian_soup", () -> new Item(new Item.Properties().craftRemainder(Items.BOWL)
            .food(ODFoods.BOWL_OF_GUARDIAN_SOUP).craftRemainder(Items.BOWL)));

    public static final DeferredItem<Item> ELDER_GUARDIAN_SLAB = ITEMS.register("elder_guardian_slab", () -> new Item(new Item.Properties()
            .food(ODFoods.ELDER_GUARDIAN_SLAB)));

    public static final DeferredItem<Item> ELDER_GUARDIAN_SLICE = ITEMS.register("elder_guardian_slice", () -> new Item(new Item.Properties()
            .food(ODFoods.ELDER_GUARDIAN_SLICE)));

    public static final DeferredItem<Item> COOKED_ELDER_GUARDIAN_SLICE = ITEMS.register("cooked_elder_guardian_slice", () -> new Item(new Item.Properties()
            .food(ODFoods.COOKED_ELDER_GUARDIAN_SLICE)));

    public static final DeferredItem<Item> ELDER_GUARDIAN_ROLL = ITEMS.register("elder_guardian_roll", () -> new Item(new Item.Properties()
            .food(ODFoods.ELDER_GUARDIAN_ROLL)));

    public static final DeferredItem<Item> CABBAGE_WRAPPED_ELDER_GUARDIAN = ITEMS.register("cabbage_wrapped_elder_guardian", () -> new Item(new Item.Properties()
            .food(ODFoods.CABBAGE_WRAPPED_ELDER_GUARDIAN)));

    public static final DeferredItem<Item> FUGU_SLICE = ITEMS.register("fugu_slice", () -> new Item(new Item.Properties()
            .food(ODFoods.FUGU_SLICE)));

    public static final DeferredItem<Item> FUGU_ROLL = ITEMS.register("fugu_roll", () -> new Item(new Item.Properties()
            .food(ODFoods.FUGU_ROLL)));

    public static final DeferredItem<Item> BRAISED_SEA_PICKLE = ITEMS.register("braised_sea_pickle", () -> new Item(new Item.Properties()
            .food(ODFoods.BRAISED_SEA_PICKLE).craftRemainder(Items.BOWL)));

    public static final DeferredItem<Item> STUFFED_COD = ITEMS.register("stuffed_cod", () -> new Item(new Item.Properties()
            .food(ODFoods.STUFFED_COD)));

    public static final DeferredItem<Item> KELP_ENCRUSTED_COD = ITEMS.register("kelp_encrusted_cod", () -> new Item(new Item.Properties()
            .food(ODFoods.KELP_CRUSTED_COD)));

    public static final DeferredItem<Item> COOKED_STUFFED_COD = ITEMS.register("cooked_stuffed_cod", () -> new Item(new Item.Properties()
            .food(ODFoods.COOKED_STUFFED_COD)));

    public static final DeferredItem<Item> HONEY_FRIED_KELP = ITEMS.register("honey_fried_kelp", () -> new Item(new Item.Properties()
            .food(ODFoods.HONEY_FRIED_KELP)));

    public static final DeferredItem<Item> SEAGRASS_SALAD = ITEMS.register("seagrass_salad", () -> new Item(new Item.Properties()
            .food(ODFoods.SEAGRASS_SALAD).craftRemainder(Items.BOWL)));

    public static <B extends Block> DeferredItem<Item> fromBlock(DeferredBlock<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
