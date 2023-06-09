package com.scouter.oceansdelight.datagen;

import com.google.common.collect.Sets;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;
import java.util.function.Consumer;

import static com.scouter.oceansdelight.OceansDelight.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent evt) {
        if (evt.includeServer())
            registerServerProviders(evt.getGenerator(), evt);

        if (evt.includeClient())
            registerClientProviders(evt.getGenerator(), evt);


    }

    private static void registerClientProviders(DataGenerator generator, GatherDataEvent evt) {
        ExistingFileHelper helper = evt.getExistingFileHelper();
        generator.addProvider(true, new BlockTagsGenerator(generator, helper));
    }

    private static void registerServerProviders(DataGenerator generator, GatherDataEvent evt) {
        ExistingFileHelper helper = evt.getExistingFileHelper();
        BlockTagsGenerator blockTags = new BlockTagsGenerator(generator, helper);
        Set<BlockStateGenerator> set = Sets.newHashSet();
        Consumer<BlockStateGenerator> consumer = set::add;
        generator.addProvider(true, new BlockstateGenerator(generator, helper));
        generator.addProvider(true, new LanguageGenerator(generator));
        generator.addProvider(true, new RecipeGenerator(generator));
        generator.addProvider(true, new ItemTagsGenerator(generator, blockTags, helper));
        generator.addProvider(true, new ItemModelGenerator(generator, helper));
    }
}
