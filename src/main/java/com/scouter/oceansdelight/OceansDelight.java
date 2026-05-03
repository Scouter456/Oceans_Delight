package com.scouter.oceansdelight;

import com.mojang.logging.LogUtils;
import com.scouter.oceansdelight.setup.ClientSetup;
import com.scouter.oceansdelight.setup.Registration;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

import java.util.Locale;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OceansDelight.MODID)
public class OceansDelight
{
    public static final String MODID = "oceansdelight";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    public OceansDelight(IEventBus modEventBus, ModContainer modContainer)
    {
        Registration.init();
        IEventBus forgeBus = NeoForge.EVENT_BUS;

        IEventBus modbus = ModLoadingContext.get().getActiveContainer().getEventBus();

        if(FMLEnvironment.dist == Dist.CLIENT) {
            modbus.addListener(ClientSetup::init);
        }
    }


    public static ResourceLocation prefix(String name) {
        return  ResourceLocation.fromNamespaceAndPath(MODID, name.toLowerCase(Locale.ROOT));
    }

}
