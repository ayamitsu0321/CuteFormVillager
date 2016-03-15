package ayamitsu.cuteformvillager.client.render;

import ayamitsu.cuteformvillager.EntityCuteFormVillager;
import ayamitsu.cuteformvillager.client.model.ModelCuteFormVillager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

/**
 * Created by ayamitsu0321 on 2016/03/14.
 */
public class RenderCuteFormVillager extends RenderLiving {

    private static final ResourceLocation texture = new ResourceLocation("cuteformvillager", "textures/entity/cuteformvillager.png");

    public RenderCuteFormVillager(RenderManager manager) {
        super(manager, new ModelCuteFormVillager(0.0F), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }

    // from cute mob
    protected float handleRotationFloat(EntityCuteFormVillager villager, float p_77044_2_) {
        return villager.lastCuteAngle + (villager.cuteAngle - villager.lastCuteAngle) * p_77044_2_;
    }

    @Override
    protected float handleRotationFloat(EntityLivingBase p_77044_1_, float p_77044_2_) {
        return this.handleRotationFloat((EntityCuteFormVillager)p_77044_1_, p_77044_2_);
    }
}
