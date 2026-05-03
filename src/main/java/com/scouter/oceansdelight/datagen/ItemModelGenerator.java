package com.scouter.oceansdelight.datagen;

import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.items.ODItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.scouter.oceansdelight.OceansDelight.prefix;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(PackOutput generator, ExistingFileHelper existingFileHelper){
        super(generator, OceansDelight.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels(){
        singleTex(ODItems.TENTACLES);
        singleTex(ODItems.TENTACLE_ON_A_STICK);
        singleTex(ODItems.CUT_TENTACLES);
        singleTex(ODItems.BAKED_TENTACLE_ON_A_STICK);
        singleTex(ODItems.SQUID_RINGS);
        singleTex(ODItems.GUARDIAN);
        singleTex(ODItems.GUARDIAN_TAIL);
        singleTex(ODItems.COOKED_GUARDIAN_TAIL);
        singleTex(ODItems.GUARDIAN_SOUP);
        singleTex(ODItems.BOWL_OF_GUARDIAN_SOUP);
        singleTex(ODItems.ELDER_GUARDIAN_SLAB);
        singleTex(ODItems.ELDER_GUARDIAN_SLICE);
        singleTex(ODItems.COOKED_ELDER_GUARDIAN_SLICE);
        singleTex(ODItems.ELDER_GUARDIAN_ROLL);
        singleTex(ODItems.CABBAGE_WRAPPED_ELDER_GUARDIAN);
        singleTex(ODItems.FUGU_SLICE);
        singleTex(ODItems.FUGU_ROLL);
        singleTex(ODItems.CABBAGE_WRAPPED_ELDER_GUARDIAN);
        singleTex(ODItems.BRAISED_SEA_PICKLE);
        singleTex(ODItems.STUFFED_COD);
        singleTex(ODItems.COOKED_STUFFED_COD);
        singleTex(ODItems.HONEY_FRIED_KELP);
        singleTex(ODItems.SEAGRASS_SALAD);
        singleTex(ODItems.COOKED_STUFFED_SQUID);
        singleTex(ODItems.STUFFED_SQUID);
        singleTex(ODItems.KELP_ENCRUSTED_COD);
    }
    private void toBlock(DeferredBlock<Block> b) {
        toBlockModel(b, b.getId().getPath());
    }

    private void toBlockModel(DeferredBlock<Block> b, String model) {
        toBlockModel(b, prefix("block/" + model));
    }

    private void toBlockModel(DeferredBlock<Block> b, ResourceLocation model) {
        withExistingParent(b.getId().getPath(), model);
    }

    private ItemModelBuilder singleTex(DeferredItem<Item> item) {
        return generated(item.getId().getPath(), prefix("item/" + item.getId().getPath()));
    }

    private ItemModelBuilder generated(String name, ResourceLocation... layers) {
        ItemModelBuilder builder = withExistingParent(name, "item/generated");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }
}
