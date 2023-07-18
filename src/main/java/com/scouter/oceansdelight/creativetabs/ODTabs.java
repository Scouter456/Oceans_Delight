package com.scouter.oceansdelight.creativetabs;

import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.items.ODItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ODTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OceansDelight.MODID);

    private static final CreativeModeTab FOODS = new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 9)
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup.oceansdelight"))
            .icon(() -> new ItemStack(ODItems.GUARDIAN_SOUP.get()))
            .displayItems((d, entries) -> {
                entries.accept(ODItems.TENTACLES.get());
                entries.accept(ODItems.CUT_TENTACLES.get());
                entries.accept(ODItems.SQUID_RINGS.get());
                entries.accept(ODItems.TENTACLE_ON_A_STICK.get());
                entries.accept(ODItems.BAKED_TENTACLE_ON_A_STICK.get());
                entries.accept(ODItems.GUARDIAN.get());
                entries.accept(ODItems.GUARDIAN_SOUP.get());
                entries.accept(ODItems.GUARDIAN_TAIL.get());
                entries.accept(ODItems.COOKED_GUARDIAN_TAIL.get());
                entries.accept(ODItems.BOWL_OF_GUARDIAN_SOUP.get());
                entries.accept(ODItems.ELDER_GUARDIAN_SLAB.get());
                entries.accept(ODItems.ELDER_GUARDIAN_SLICE.get());
                entries.accept(ODItems.COOKED_ELDER_GUARDIAN_SLICE.get());
                entries.accept(ODItems.ELDER_GUARDIAN_ROLL.get());
                entries.accept(ODItems.CABBAGE_WRAPPED_ELDER_GUARDIAN.get());
                entries.accept(ODItems.FUGU_SLICE.get());
                entries.accept(ODItems.FUGU_ROLL.get());
                entries.accept(ODItems.BRAISED_SEA_PICKLE.get());
                entries.accept(ODItems.STUFFED_COD.get());
                entries.accept(ODItems.COOKED_STUFFED_COD.get());
                entries.accept(ODItems.HONEY_FRIED_KELP.get());
                entries.accept(ODItems.SEAGRASS_SALAD.get());
            })
            .build();


    public static final RegistryObject<CreativeModeTab> OD_TAB = TABS.register("oceansdelight", () -> FOODS);
}
