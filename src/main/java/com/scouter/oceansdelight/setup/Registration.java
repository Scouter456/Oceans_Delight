package com.scouter.oceansdelight.setup;

import com.mojang.logging.LogUtils;
import com.scouter.oceansdelight.blocks.ODBlocks;
import com.scouter.oceansdelight.creativetabs.ODTabs;
import com.scouter.oceansdelight.items.ODItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import org.slf4j.Logger;


public class Registration {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static void init(){

        IEventBus bus = ModLoadingContext.get().getActiveContainer().getEventBus();

        ODBlocks.BLOCKS.register(bus);
        ODItems.ITEMS.register(bus);
        ODTabs.TABS.register(bus);

    }
}
