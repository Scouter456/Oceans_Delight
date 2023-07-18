package com.scouter.oceansdelight.items;


import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.blocks.ODBlocks;
import com.scouter.oceansdelight.setup.Registration;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.scouter.oceansdelight.OceansDelight.prefix;


public class ODItems {
    public static final Logger LOGGER = LoggerFactory.getLogger("oceansdelight");
    


    public static final Item TENTACLES = registerItem("tentacles",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.TENTACLES)));

    public static final Item CUT_TENTACLES = registerItem("cut_tentacles",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.CUT_TENTACLES)));

    public static final Item SQUID_RINGS = registerItem("squid_rings",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.SQUID_RINGS)));

    public static final Item TENTACLE_ON_A_STICK = registerItem("tentacle_on_a_stick",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.TENTACLE_ON_A_STICK)));

    public static final Item BAKED_TENTACLE_ON_A_STICK = registerItem("baked_tentacle_on_a_stick",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.BAKED_TENTACLE_ON_A_STICK)));

    public static final Item GUARDIAN = registerItem("guardian",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)));
    public static final Item BOWL_OF_GUARDIAN_SOUP = registerItem("bowl_of_guardian_soup",  new Item(new FabricItemSettings().group(Registration.defaultBuilder).craftRemainder(Items.BOWL)
            .food(ODFoods.BOWL_OF_GUARDIAN_SOUP)));
    public static final Item GUARDIAN_SOUP = registerBlockItem(ODBlocks.GUARDIAN_SOUP);
    public static final Item GUARDIAN_TAIL = registerItem("guardian_tail",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.GUARDIAN_TAIL)));

    public static final Item COOKED_GUARDIAN_TAIL = registerItem("cooked_guardian_tail",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.COOKED_GUARDIAN_TAIL)));




    public static final Item ELDER_GUARDIAN_SLAB = registerItem("elder_guardian_slab",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.ELDER_GUARDIAN_SLAB)));

    public static final Item ELDER_GUARDIAN_SLICE = registerItem("elder_guardian_slice",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.ELDER_GUARDIAN_SLICE)));

    public static final Item COOKED_ELDER_GUARDIAN_SLICE = registerItem("cooked_elder_guardian_slice",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.COOKED_ELDER_GUARDIAN_SLICE)));

    public static final Item ELDER_GUARDIAN_ROLL = registerItem("elder_guardian_roll",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.ELDER_GUARDIAN_ROLL)));

    public static final Item CABBAGE_WRAPPED_ELDER_GUARDIAN = registerItem("cabbage_wrapped_elder_guardian",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.CABBAGE_WRAPPED_ELDER_GUARDIAN)));

    public static final Item FUGU_SLICE = registerItem("fugu_slice",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.FUGU_SLICE)));

    public static final Item FUGU_ROLL = registerItem("fugu_roll",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.FUGU_ROLL)));

    public static final Item BRAISED_SEA_PICKLE = registerItem("braised_sea_pickle",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.BRAISED_SEA_PICKLE)));

    public static final Item STUFFED_COD = registerItem("stuffed_cod", new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.STUFFED_COD)));

    public static final Item COOKED_STUFFED_COD = registerItem("cooked_stuffed_cod", new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.COOKED_STUFFED_COD)));

    public static final Item HONEY_FRIED_KELP = registerItem("honey_fried_kelp",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.HONEY_FRIED_KELP)));

    public static final Item SEAGRASS_SALAD = registerItem("seagrass_salad",  new Item(new FabricItemSettings().group(Registration.defaultBuilder)
            .food(ODFoods.SEAGRASS_SALAD)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, prefix(name), item);
    }

    private static Item registerBlockItem(Block block){
        return Registry.register(Registry.ITEM, prefix(block.getDescriptionId().replace("block.oceansdelight.", "").toString()),
                new BlockItem(block, new FabricItemSettings().group(Registration.defaultBuilder).fireproof()));
    }
    public static void ITEMS(){
        LOGGER.info("Registering Items for " + OceansDelight.MODID);
    }
}
