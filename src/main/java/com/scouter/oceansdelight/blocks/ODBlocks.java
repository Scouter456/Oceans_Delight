package com.scouter.oceansdelight.blocks;

import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.items.ODItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ODBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(OceansDelight.MODID);
    public static final DeferredBlock<Block> GUARDIAN_SOUP = BLOCKS.register("guardian_soup", () -> new GuardianSoupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
            .strength(0.5F, 6.0F).noOcclusion()
            .sound(SoundType.LANTERN), ODItems.BOWL_OF_GUARDIAN_SOUP, true));
}
