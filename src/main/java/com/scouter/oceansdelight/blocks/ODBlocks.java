package com.scouter.oceansdelight.blocks;

import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.items.ODItems;
import com.scouter.oceansdelight.setup.Registration;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.scouter.oceansdelight.OceansDelight.prefix;

public class ODBlocks {
    public static final Logger LOGGER = LoggerFactory.getLogger("oceansdelight");
    public static final Block GUARDIAN_SOUP = registerBlock("guardian_soup", new GuardianSoupBlock(),  Registration.defaultBuilder);

    private static Block registerBlock(String name, Block block, CreativeModeTab group){
        return Registry.register(Registry.BLOCK, prefix(name), block);
    }

    public static void BLOCKS(){
        LOGGER.info("Registering Blocks for " + OceansDelight.MODID);
    }
}
