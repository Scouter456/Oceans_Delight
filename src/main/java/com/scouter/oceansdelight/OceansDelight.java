package com.scouter.oceansdelight;
import com.scouter.oceansdelight.items.ODItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import com.scouter.oceansdelight.setup.ClientSetup;
import com.scouter.oceansdelight.setup.Registration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.advancements.critereon.EntityEquipmentPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.Locale;
import java.util.Set;

public class OceansDelight implements ModInitializer {
    public static final String MODID = "oceansdelight";
    public static final Logger LOGGER = LoggerFactory.getLogger("oceansdelight");

    @Override
    public void onInitialize() {
        Registration.init();
        this.registerLootTable();
    }


    public static ResourceLocation prefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(MODID, name.toLowerCase(Locale.ROOT));
    }
    //protected void registerLootTable() {
    //    Set<ResourceKey<LootTable>> scavengingEntityIdList = Set.of(
    //            EntityType.SQUID.getDefaultLootTable(),
    //            EntityType.GUARDIAN.getDefaultLootTable(),
    //            EntityType.ELDER_GUARDIAN.getDefaultLootTable()
    //    );
//
//
    //    //LootTableEvents.MODIFY.register(((key, tableBuilder, source) -> {
    //    //    ResourceLocation injectId =  ResourceLocation.fromNamespaceAndPath(FarmersDelight.MODID, "inject/" + key.location());
    //    //    if (scavengingEntityIdList.contains(key)) {
    //    //        tableBuilder.withPool(LootPool.lootPool().add(LootTableReference.lootTableReference(injectId)).build());
    //    //    }
    //    //}));
    //}

    public static void registerLootTable() {
        LootTableEvents.MODIFY.register(OceansDelight::modifyTable);
    }

    private static void modifyTable(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, HolderLookup.Provider registries) {
        scavengingLoot(key, tableBuilder, source, registries);
    }

    private static void scavengingLoot(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, HolderLookup.Provider registries) {

        if (key  == EntityType.SQUID.getDefaultLootTable() || key == EntityType.GLOW_SQUID.getDefaultLootTable()) {
            tableBuilder.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ODItems.TENTACLES)
                    .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
                            EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.KNIVES))
                    )))));
        }

        if (key  == EntityType.ELDER_GUARDIAN.getDefaultLootTable() ) {
            tableBuilder.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ODItems.ELDER_GUARDIAN_SLAB)
                    .when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
                            EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.KNIVES))
                    )))));
        }

        if (key  == EntityType.GUARDIAN.getDefaultLootTable() ) {
            tableBuilder.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ODItems.GUARDIAN)));
        }

    }
}


