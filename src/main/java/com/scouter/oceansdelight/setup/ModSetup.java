package com.scouter.oceansdelight.setup;

import com.scouter.oceansdelight.OceansDelight;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = OceansDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {

    public static void init(FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
        });
    }

    public static void setup(){
        IEventBus bus = MinecraftForge.EVENT_BUS;
    }
}
