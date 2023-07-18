package com.scouter.oceansdelight.blocks;

import com.scouter.oceansdelight.OceansDelight;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.scouter.oceansdelight.OceansDelight.prefix;

public class ODBlocks {
    public static final Logger LOGGER = LoggerFactory.getLogger("oceansdelight");
    public static final Block GUARDIAN_SOUP = registerBlock("guardian_soup", new GuardianSoupBlock());

    private static Block registerBlock(String name, Block block){
        return Registry.register(BuiltInRegistries.BLOCK, prefix(name), block);
    }

    public static void BLOCKS(){
        LOGGER.info("Registering Blocks for " + OceansDelight.MODID);
    }
}
