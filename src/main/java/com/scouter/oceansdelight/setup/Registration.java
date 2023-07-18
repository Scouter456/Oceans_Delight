package com.scouter.oceansdelight.setup;

import com.mojang.logging.LogUtils;
import com.scouter.oceansdelight.blocks.ODBlocks;
import com.scouter.oceansdelight.creativetabs.ODTabs;
import com.scouter.oceansdelight.items.ODItems;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;

import java.util.Optional;


public class Registration {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static Optional<ItemStack> GUARDIAN_SOUP;
    public static void init(){

        GUARDIAN_SOUP = Optional.ofNullable(new ItemStack(ODItems.GUARDIAN_SOUP));
        ODItems.ITEMS();
        ODBlocks.BLOCKS();
        ODTabs.TABS();


    }

}
