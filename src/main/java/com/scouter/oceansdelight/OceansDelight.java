package com.scouter.oceansdelight;

import com.nhoryzon.mc.farmersdelight.FarmersDelightMod;
import com.scouter.oceansdelight.setup.ClientSetup;
import com.scouter.oceansdelight.setup.Registration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Set;

public class OceansDelight implements ModInitializer {
    public static final String MODID = "oceansdelight";
    public static final Logger LOGGER = LoggerFactory.getLogger("oceansdelight");

    @Override
    public void onInitialize() {
        Registration.init();
        ClientSetup.init();
        this.registerLootTable();
    }


    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MODID, name.toLowerCase(Locale.ROOT));
    }
    protected void registerLootTable() {
        Set<ResourceLocation> scavengingEntityIdList = Set.of(
                EntityType.SQUID.getDefaultLootTable(),
                EntityType.GUARDIAN.getDefaultLootTable(),
                EntityType.ELDER_GUARDIAN.getDefaultLootTable()
        );

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            ResourceLocation injectId = new ResourceLocation(FarmersDelightMod.MOD_ID, "inject/" + id.getPath());
            if (scavengingEntityIdList.contains(id)) {
                tableBuilder.pool(LootPool.lootPool().add(LootTableReference.lootTableReference(injectId)).build());
            }
        });
    }
}

