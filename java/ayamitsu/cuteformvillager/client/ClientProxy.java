package ayamitsu.cuteformvillager.client;

import ayamitsu.cuteformvillager.AbstractProxy;
import ayamitsu.cuteformvillager.EntityCuteFormVillager;
import ayamitsu.cuteformvillager.client.render.RenderCuteFormVillager;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/**
 * Created by ayamitsu0321 on 2016/03/14.
 */
public class ClientProxy extends AbstractProxy {

    public void preInit() {
        //RenderingRegistry.registerEntityRenderingHandler(EntityVillager.class, new RenderCuteFormVillager(FMLClientHandler.instance().getClient().getRenderManager()));
    }

    public void init() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCuteFormVillager.class, new RenderCuteFormVillager(FMLClientHandler.instance().getClient().getRenderManager()));
    }

    public void postInit() {
    }

}
