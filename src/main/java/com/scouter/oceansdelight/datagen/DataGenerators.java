package com.scouter.oceansdelight.datagen;

import com.google.common.collect.Sets;
import com.scouter.oceansdelight.OceansDelight;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

@EventBusSubscriber(modid = OceansDelight.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent evt) {
        if (evt.includeServer())
            registerServerProviders(evt.getGenerator(), evt);

    }


    private static void registerServerProviders(DataGenerator generator, GatherDataEvent evt) {
        ExistingFileHelper helper = evt.getExistingFileHelper();

        Set<BlockStateGenerator> set = Sets.newHashSet();
        CompletableFuture<HolderLookup.Provider> lookupProvider = evt.getLookupProvider();
        BlockTagsGenerator blockTagGenerator = generator.addProvider(evt.includeServer(),
                new BlockTagsGenerator(generator.getPackOutput(), lookupProvider, helper));
        Consumer<BlockStateGenerator> consumer = set::add;
        generator.addProvider(true, new BlockstateGenerator(generator.getPackOutput(), helper));
        generator.addProvider(true, new LanguageGenerator(generator));
        generator.addProvider(true, new RecipeGenerator(generator.getPackOutput(),lookupProvider));
        generator.addProvider(true, new ItemModelGenerator(generator.getPackOutput(), helper));
    }
}
