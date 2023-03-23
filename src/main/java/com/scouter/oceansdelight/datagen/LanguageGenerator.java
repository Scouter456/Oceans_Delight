package com.scouter.oceansdelight.datagen;

import com.mojang.logging.LogUtils;
import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.blocks.ODBlocks;
import com.scouter.oceansdelight.items.ODItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.common.data.LanguageProvider;
import org.slf4j.Logger;

import java.util.function.Supplier;

public class LanguageGenerator extends LanguageProvider {
    public LanguageGenerator(DataGenerator gen){
        super(gen, OceansDelight.MODID, "en_us");
    }
    private static final Logger LOGGER = LogUtils.getLogger();
    @Override
    protected void addTranslations(){

        //BLOCKS
        addBlock(ODBlocks.GUARDIAN_SOUP, "Guardian Soup");

        addItem(ODItems.TENTACLES, "Tentacles");
        addItem(ODItems.CUT_TENTACLES, "Cut Tentacles");
        addItem(ODItems.TENTACLE_ON_A_STICK, "Tentacle on a Stick");
        addItem(ODItems.BAKED_TENTACLE_ON_A_STICK, "Baked Tentacle on a Stick");
        addItem(ODItems.SQUID_RINGS, "Squid Rings");
        addItem(ODItems.GUARDIAN, "Guardian");
        //addItem(ODItems.GUARDIAN_SOUP, "Guardian Soup");
        addItem(ODItems.GUARDIAN_TAIL, "Guardian Tail");
        addItem(ODItems.COOKED_GUARDIAN_TAIL, "Cooked Guardian Tail");
        addItem(ODItems.BOWL_OF_GUARDIAN_SOUP, "Bowl of Guardian Soup");
        addItem(ODItems.ELDER_GUARDIAN_SLAB, "Slab of Elder Guardian");
        addItem(ODItems.ELDER_GUARDIAN_SLICE, "Slice of Elder Guardian");
        addItem(ODItems.COOKED_ELDER_GUARDIAN_SLICE, "Cooked Slice of Elder Guardian");
        addItem(ODItems.ELDER_GUARDIAN_ROLL, "Roll of Elder Guardian");
        addItem(ODItems.CABBAGE_WRAPPED_ELDER_GUARDIAN, "Cabbage Wrapped Elder Guardian");
        addItem(ODItems.BRAISED_SEA_PICKLE, "Braised Sea Pickle");
        addItem(ODItems.FUGU_ROLL, "Fugu Roll");
        addItem(ODItems.FUGU_SLICE, "Fugu Slice");

        //TABS
        addTabName(ODItems.creativeTab, "Ocean's Delight");
    }

    @Override
    public String getName() {
        return "Ocean's Delight Languages: en_us";
    }

    public void addTabName(CreativeModeTab key, String name){
        add(key.getDisplayName().getString(), name);
    }

    public void add(CreativeModeTab key, String name) {
        add(key.getDisplayName().getString(), name);
    }

    public void addPotion(Supplier<? extends Potion> key, String name, String regName) {
        add(key.get(), name, regName);
    }

    public void add(Potion key, String name, String regName) {
        add("item.minecraft.potion.effect." + regName, name);
        add("item.minecraft.splash_potion.effect." + regName, "Splash " + name);
        add("item.minecraft.lingering_potion.effect." + regName, "Lingering " + name);
    }
}
