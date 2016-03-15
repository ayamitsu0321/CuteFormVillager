package ayamitsu.cuteformvillager;

import ayamitsu.cuteformvillager.event.WhyTheyWereKilledCuteMobsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(
        modid = CuteFormVillager.MODID,
        name = CuteFormVillager.NAME,
        version = CuteFormVillager.VERSION
)
public class CuteFormVillager {

    public static final String MODID = "cuteformvillager";
    public static final String NAME = "CuteFormVillager";
    public static final String VERSION = "1.0.0";


    @Mod.Instance(MODID)
    public static CuteFormVillager instance;

    @SidedProxy(clientSide = "ayamitsu.cuteformvillager.client.ClientProxy", serverSide = "ayamitsu.cuteformvillager.server.ServerProxy")
    public static AbstractProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
        EntityRegistry.registerModEntity(EntityCuteFormVillager.class, "CuteFormVillager", 0, this, 80, 3, true);
        //EntityRegistry.registerEgg(EntityCuteFormVillager.class, 0x000000, 0x000000);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
        MinecraftForge.EVENT_BUS.register(new WhyTheyWereKilledCuteMobsEvent());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }

}