package com.scouter.oceansdelight.setup;


import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.client.renderer.RenderLayerRegistration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = OceansDelight.MODID, value = Dist.CLIENT,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    public static void init(FMLClientSetupEvent event){
        RenderLayerRegistration.init();
    }

}

