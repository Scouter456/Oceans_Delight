package com.scouter.oceansdelight.setup;


import com.scouter.oceansdelight.OceansDelight;
import com.scouter.oceansdelight.client.renderer.RenderLayerRegistration;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {
    public static void init(FMLClientSetupEvent event){
        RenderLayerRegistration.init();
    }

}

