package com.scouter.oceansdelight.setup;

import com.scouter.oceansdelight.blocks.ODBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class ClientSetup implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RenderLayerRegistration();
    }


    public static void RenderLayerRegistration(){
        RenderType cutoutMipped = RenderType.cutoutMipped();
        RenderType cutout = RenderType.cutout();
        RenderType translucent = RenderType.translucent();
        RenderType translucentnocrumb = RenderType.translucentNoCrumbling();
        RenderType solid = RenderType.solid();

        BlockRenderLayerMap.INSTANCE.putBlock(ODBlocks.GUARDIAN_SOUP, cutout);



    }
    public static void init(){

    }
}
