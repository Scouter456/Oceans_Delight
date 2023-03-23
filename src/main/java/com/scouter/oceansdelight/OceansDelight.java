package com.scouter.oceansdelight;

import com.mojang.logging.LogUtils;
import com.scouter.oceansdelight.setup.ClientSetup;
import com.scouter.oceansdelight.setup.ModSetup;
import com.scouter.oceansdelight.setup.Registration;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

import java.util.Locale;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OceansDelight.MODID)
public class OceansDelight
{
    public static final String MODID = "oceansdelight";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    public OceansDelight()
    {
        Registration.init();
        ModSetup.setup();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        modbus.addListener(ModSetup::init);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modbus.addListener(ClientSetup::init));
    }


    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MODID, name.toLowerCase(Locale.ROOT));
    }

}
