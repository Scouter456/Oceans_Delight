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

    public static final RegistryObject<Item> TENTACLES = ITEMS.register("tentacles", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.TENTACLES)));

    public static final RegistryObject<Item> CUT_TENTACLES = ITEMS.register("cut_tentacles", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.CUT_TENTACLES)));

    public static final RegistryObject<Item> SQUID_RINGS = ITEMS.register("squid_rings", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.SQUID_RINGS)));

    public static final RegistryObject<Item> TENTACLE_ON_A_STICK = ITEMS.register("tentacle_on_a_stick", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.TENTACLE_ON_A_STICK)));

    public static final RegistryObject<Item> BAKED_TENTACLE_ON_A_STICK = ITEMS.register("baked_tentacle_on_a_stick", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.BAKED_TENTACLE_ON_A_STICK)));

    public static final RegistryObject<Item> GUARDIAN = ITEMS.register("guardian", () -> new Item(Registration.defaultBuilder()));
    public static final RegistryObject<Item> GUARDIAN_SOUP = fromBlock(ODBlocks.GUARDIAN_SOUP);
    public static final RegistryObject<Item> GUARDIAN_TAIL = ITEMS.register("guardian_tail", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.GUARDIAN_TAIL)));

    public static final RegistryObject<Item> COOKED_GUARDIAN_TAIL = ITEMS.register("cooked_guardian_tail", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.COOKED_GUARDIAN_TAIL)));


    public static final RegistryObject<Item> BOWL_OF_GUARDIAN_SOUP = ITEMS.register("bowl_of_guardian_soup", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.BOWL_OF_GUARDIAN_SOUP).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> ELDER_GUARDIAN_SLAB = ITEMS.register("elder_guardian_slab", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.ELDER_GUARDIAN_SLAB)));

    public static final RegistryObject<Item> ELDER_GUARDIAN_SLICE = ITEMS.register("elder_guardian_slice", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.ELDER_GUARDIAN_SLICE)));

    public static final RegistryObject<Item> COOKED_ELDER_GUARDIAN_SLICE = ITEMS.register("cooked_elder_guardian_slice", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.COOKED_ELDER_GUARDIAN_SLICE)));

    public static final RegistryObject<Item> ELDER_GUARDIAN_ROLL = ITEMS.register("elder_guardian_roll", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.ELDER_GUARDIAN_ROLL)));

    public static final RegistryObject<Item> CABBAGE_WRAPPED_ELDER_GUARDIAN = ITEMS.register("cabbage_wrapped_elder_guardian", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.CABBAGE_WRAPPED_ELDER_GUARDIAN)));

    public static final RegistryObject<Item> FUGU_SLICE = ITEMS.register("fugu_slice", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.FUGU_SLICE)));

    public static final RegistryObject<Item> FUGU_ROLL = ITEMS.register("fugu_roll", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.FUGU_ROLL)));

    public static final RegistryObject<Item> BRAISED_SEA_PICKLE = ITEMS.register("braised_sea_pickle", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.BRAISED_SEA_PICKLE)));

    public static final RegistryObject<Item> STUFFED_COD = ITEMS.register("stuffed_cod", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.STUFFED_COD)));

    public static final RegistryObject<Item> COOKED_STUFFED_COD = ITEMS.register("cooked_stuffed_cod", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.COOKED_STUFFED_COD)));

    public static final RegistryObject<Item> HONEY_FRIED_KELP = ITEMS.register("honey_fried_kelp", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.HONEY_FRIED_KELP)));

    public static final RegistryObject<Item> SEAGRASS_SALAD = ITEMS.register("seagrass_salad", () -> new Item(Registration.defaultBuilder()
            .food(ODFoods.SEAGRASS_SALAD)));
    public static CreativeModeTab creativeTab = new CreativeModeTab("oceansdelight") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(GUARDIAN_SOUP.get());
        }
    };


    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), Registration.defaultBuilder()));
    }
}
