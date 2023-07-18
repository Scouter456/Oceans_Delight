package com.scouter.oceansdelight.creativetabs;

import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.items.ODItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import static com.scouter.oceansdelight.OceansDelight.LOGGER;
import static com.scouter.oceansdelight.OceansDelight.prefix;

public class ODTabs {


    private static final CreativeModeTab FOODS = FabricItemGroup
            .builder()
            .title(Component.translatable("itemGroup.oceansdelight"))
            .icon(ODItems.GUARDIAN_SOUP::getDefaultInstance)
            .displayItems((d, entries) -> {
                entries.accept(ODItems.TENTACLES );
                entries.accept(ODItems.CUT_TENTACLES );
                entries.accept(ODItems.SQUID_RINGS  );
                entries.accept(ODItems.TENTACLE_ON_A_STICK  );
                entries.accept(ODItems.BAKED_TENTACLE_ON_A_STICK  );
                entries.accept(ODItems.GUARDIAN  );
                entries.accept(ODItems.GUARDIAN_SOUP  );
                entries.accept(ODItems.GUARDIAN_TAIL  );
                entries.accept(ODItems.COOKED_GUARDIAN_TAIL  );
                entries.accept(ODItems.BOWL_OF_GUARDIAN_SOUP  );
                entries.accept(ODItems.ELDER_GUARDIAN_SLAB  );
                entries.accept(ODItems.ELDER_GUARDIAN_SLICE  );
                entries.accept(ODItems.COOKED_ELDER_GUARDIAN_SLICE  );
                entries.accept(ODItems.ELDER_GUARDIAN_ROLL  );
                entries.accept(ODItems.CABBAGE_WRAPPED_ELDER_GUARDIAN  );
                entries.accept(ODItems.FUGU_SLICE  );
                entries.accept(ODItems.FUGU_ROLL  );
                entries.accept(ODItems.BRAISED_SEA_PICKLE  );
                entries.accept(ODItems.STUFFED_COD  );
                entries.accept(ODItems.COOKED_STUFFED_COD  );
                entries.accept(ODItems.HONEY_FRIED_KELP  );
                entries.accept(ODItems.SEAGRASS_SALAD  );
            })
            .build();



    public static final CreativeModeTab OD_TAB = creativeModeTab("oceansdelight", FOODS);
    private static CreativeModeTab creativeModeTab(String name, CreativeModeTab item) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, prefix(name), item);
    }


    public static void TABS(){
        LOGGER.info("Registering tabs for " + OceansDelight.MODID);
    }
}
