package com.scouter.oceansdelight.items;


import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.blocks.ODBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.scouter.oceansdelight.OceansDelight.prefix;


public class ODItems {
    public static final Logger LOGGER = LoggerFactory.getLogger("oceansdelight");
    


    public static final Item TENTACLES = registerItem("tentacles",  new Item(new Item.Properties()
            .food(ODFoods.TENTACLES)));

    public static final Item CUT_TENTACLES = registerItem("cut_tentacles",  new Item(new Item.Properties()
            .food(ODFoods.CUT_TENTACLES)));

    public static final Item SQUID_RINGS = registerItem("squid_rings",  new Item(new Item.Properties()
            .food(ODFoods.SQUID_RINGS).craftRemainder(Items.BOWL)));

    public static final Item TENTACLE_ON_A_STICK = registerItem("tentacle_on_a_stick",  new Item(new Item.Properties()
            .food(ODFoods.TENTACLE_ON_A_STICK)));

    public static final Item BAKED_TENTACLE_ON_A_STICK = registerItem("baked_tentacle_on_a_stick",  new Item(new Item.Properties()
            .food(ODFoods.BAKED_TENTACLE_ON_A_STICK)));

    public static final Item STUFFED_SQUID = registerItem("stuffed_squid",  new Item(new Item.Properties()
            .food(ODFoods.STUFFED_SQUID)));

    public static final Item COOKED_STUFFED_SQUID = registerItem("cooked_stuffed_squid",  new Item(new Item.Properties()
            .food(ODFoods.COOKED_STUFFED_SQUID)));

    public static final Item GUARDIAN = registerItem("guardian",  new Item(new Item.Properties()));
    public static final Item BOWL_OF_GUARDIAN_SOUP = registerItem("bowl_of_guardian_soup",  new Item(new Item.Properties().craftRemainder(Items.BOWL)
            .food(ODFoods.BOWL_OF_GUARDIAN_SOUP).craftRemainder(Items.BOWL)));
    public static final Item GUARDIAN_SOUP = registerBlockItem(ODBlocks.GUARDIAN_SOUP);
    public static final Item GUARDIAN_TAIL = registerItem("guardian_tail",  new Item(new Item.Properties()
            .food(ODFoods.GUARDIAN_TAIL)));

    public static final Item COOKED_GUARDIAN_TAIL = registerItem("cooked_guardian_tail",  new Item(new Item.Properties()
            .food(ODFoods.COOKED_GUARDIAN_TAIL)));

    public static final Item ELDER_GUARDIAN_SLAB = registerItem("elder_guardian_slab",  new Item(new Item.Properties()
            .food(ODFoods.ELDER_GUARDIAN_SLAB)));

    public static final Item ELDER_GUARDIAN_SLICE = registerItem("elder_guardian_slice",  new Item(new Item.Properties()
            .food(ODFoods.ELDER_GUARDIAN_SLICE)));

    public static final Item COOKED_ELDER_GUARDIAN_SLICE = registerItem("cooked_elder_guardian_slice",  new Item(new Item.Properties()
            .food(ODFoods.COOKED_ELDER_GUARDIAN_SLICE)));

    public static final Item ELDER_GUARDIAN_ROLL = registerItem("elder_guardian_roll",  new Item(new Item.Properties()
            .food(ODFoods.ELDER_GUARDIAN_ROLL)));

    public static final Item CABBAGE_WRAPPED_ELDER_GUARDIAN = registerItem("cabbage_wrapped_elder_guardian",  new Item(new Item.Properties()
            .food(ODFoods.CABBAGE_WRAPPED_ELDER_GUARDIAN)));

    public static final Item FUGU_SLICE = registerItem("fugu_slice",  new Item(new Item.Properties()
            .food(ODFoods.FUGU_SLICE)));

    public static final Item FUGU_ROLL = registerItem("fugu_roll",  new Item(new Item.Properties()
            .food(ODFoods.FUGU_ROLL)));

    public static final Item BRAISED_SEA_PICKLE = registerItem("braised_sea_pickle",  new Item(new Item.Properties()
            .food(ODFoods.BRAISED_SEA_PICKLE).craftRemainder(Items.BOWL)));

    public static final Item STUFFED_COD = registerItem("stuffed_cod", new Item(new Item.Properties()
            .food(ODFoods.STUFFED_COD)));

    public static final Item KELP_ENCRUSTED_COD = registerItem("kelp_encrusted_cod", new Item(new Item.Properties()
            .food(ODFoods.KELP_CRUSTED_COD)));

    public static final Item COOKED_STUFFED_COD = registerItem("cooked_stuffed_cod", new Item(new Item.Properties()
            .food(ODFoods.COOKED_STUFFED_COD)));

    public static final Item HONEY_FRIED_KELP = registerItem("honey_fried_kelp",  new Item(new Item.Properties()
            .food(ODFoods.HONEY_FRIED_KELP)));

    public static final Item SEAGRASS_SALAD = registerItem("seagrass_salad",  new Item(new Item.Properties()
            .food(ODFoods.SEAGRASS_SALAD).craftRemainder(Items.BOWL)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, prefix(name), item);
    }

    private static Item registerBlockItem(Block block){
        return Registry.register(BuiltInRegistries.ITEM, prefix(block.getDescriptionId().replace("block.oceansdelight.", "").toString()),
                new BlockItem(block, new Item.Properties()));
    }
    public static void ITEMS(){
        LOGGER.info("Registering Items for " + OceansDelight.MODID);
    }
}
