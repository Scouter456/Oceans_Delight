package com.scouter.oceansdelight.setup;

import com.mojang.logging.LogUtils;
import com.scouter.oceansdelight.blocks.ODBlocks;
import com.scouter.oceansdelight.creativetabs.ODTabs;
import com.scouter.oceansdelight.items.ODItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


public class Registration {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static void init(){

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ODBlocks.BLOCKS.register(bus);
        ODItems.ITEMS.register(bus);
        ODTabs.TABS.register(bus);

    }
}
