package com.scouter.oceansdelight.datagen;

import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.blocks.ODBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class BlockTagsGenerator extends BlockTagsProvider {
    public BlockTagsGenerator(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, OceansDelight.MODID, helper);
    }

    @Override
    protected void addTags(){
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(
                ODBlocks.GUARDIAN_SOUP.get()
        );
    }


    @Override
    public String getName() { return "Ocean's Delight Tags";}
}
