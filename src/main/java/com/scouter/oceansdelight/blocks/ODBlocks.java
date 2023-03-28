package com.scouter.oceansdelight.blocks;

import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.items.ODItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = OceansDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ODBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OceansDelight.MODID);
    public static final RegistryObject<Block> GUARDIAN_SOUP = BLOCKS.register("guardian_soup", () -> new GuardianSoupBlock(BlockBehaviour.Properties.of(Material.METAL)
            .strength(0.5F, 6.0F).noOcclusion()
            .sound(SoundType.LANTERN), ODItems.BOWL_OF_GUARDIAN_SOUP, true));
}
