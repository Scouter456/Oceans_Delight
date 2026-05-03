package com.scouter.oceansdelight.datagen;

import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.blocks.ODBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTagsGenerator extends BlockTagsProvider {
    public BlockTagsGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider,OceansDelight.MODID, existingFileHelper);
    }


    @Override
    public String getName() { return "Ocean's Delight Tags";}

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(
                ODBlocks.GUARDIAN_SOUP.get()
        );
    }
}
