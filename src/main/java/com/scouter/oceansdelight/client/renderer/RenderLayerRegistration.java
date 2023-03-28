package com.scouter.oceansdelight.client.renderer;


import com.scouter.oceansdelight.blocks.ODBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;

public class RenderLayerRegistration {
    public static void init() {
        RenderType cutoutMipped = RenderType.cutoutMipped();
        RenderType cutout = RenderType.cutout();
        RenderType translucent = RenderType.translucent();
        RenderType translucentnocrumb = RenderType.translucentNoCrumbling();
        RenderType solid = RenderType.solid();
        ItemBlockRenderTypes.setRenderLayer(ODBlocks.GUARDIAN_SOUP.get(), translucent);
    }
}
