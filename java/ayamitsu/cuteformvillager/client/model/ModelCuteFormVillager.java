package ayamitsu.cuteformvillager.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.entity.Entity;

/**
 * Created by ayamitsu0321 on 2016/03/14.
 */
public class ModelCuteFormVillager extends ModelVillager {

    public ModelRenderer[] cutes = new ModelRenderer[8];
    ;

    public ModelCuteFormVillager(float p_i1163_1_) {
        this(p_i1163_1_, 0.0F, 64, 64);
    }

    public ModelCuteFormVillager(float p_i1164_1_, float p_i1164_2_, int p_i1164_3_, int p_i1164_4_) {
        super(p_i1164_1_, p_i1164_2_, p_i1164_3_, p_i1164_4_);

        // clear
        this.villagerHead.cubeList.clear();
        this.villagerNose.cubeList.clear();
        this.villagerArms.cubeList.clear();
        this.villagerBody.cubeList.clear();
        this.rightVillagerLeg.cubeList.clear();
        this.leftVillagerLeg.cubeList.clear();

        // villager
        this.villagerBody = (new ModelRenderer(this)).setTextureSize(p_i1164_3_, p_i1164_4_);
        this.villagerBody.setTextureOffset(30, 32).addBox(-4.0F, 4.0F, -3.0F, 8, /*12*/8, 6, p_i1164_1_);
        this.villagerBody.setTextureOffset(0, 44).addBox(-4.0F, 4.0F, -3.0F, 8, /*18*/14, 6, p_i1164_1_ + 0.5F);
        this.rightVillagerLeg = (new ModelRenderer(this, 30, 48)).setTextureSize(p_i1164_3_, p_i1164_4_);
        this.rightVillagerLeg.setRotationPoint(-2.0F, 12.0F + p_i1164_2_, 0.0F);
        this.rightVillagerLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, p_i1164_1_);
        this.leftVillagerLeg = (new ModelRenderer(this, 30, 48)).setTextureSize(p_i1164_3_, p_i1164_4_);
        this.leftVillagerLeg.mirror = true;
        this.leftVillagerLeg.setRotationPoint(2.0F, 12.0F + p_i1164_2_, 0.0F);
        this.leftVillagerLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, p_i1164_1_);

        // cute
        this.villagerHead = (new ModelRenderer(this)).setTextureSize(p_i1164_3_, p_i1164_4_);
        this.villagerHead.addBox(-6F, -16F, -6F, 12, 16, 12);
        this.villagerHead.setRotationPoint(0F, 8F, 0F);

        byte b0 = -16;

        for (int i = 0; i < this.cutes.length; ++i) {
            this.cutes[i] = new ModelRenderer(this, 54, 0).setTextureSize(p_i1164_3_, p_i1164_4_);
            // bind with head for rotation
            this.villagerHead.addChild(this.cutes[i]);
            double d0 = (double)i * Math.PI * 2.0D / (double)this.cutes.length;
            float f = (float)Math.cos(d0) * 5.0F;
            float f1 = (float)Math.sin(d0) * 5.0F;
            this.cutes[i].addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2);
            this.cutes[i].rotationPointX = f;
            this.cutes[i].rotationPointZ = f1;
            //this.cutes[i].rotationPointY = (float)(31 + b0);
            this.cutes[i].rotationPointY = 0F;
            d0 = (double)i * Math.PI * -2.0D / (double)this.cutes.length + (Math.PI / 2D);
            this.cutes[i].rotateAngleY = (float)d0;
        }
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);

        ModelRenderer[] amodelrenderer = this.cutes;
        int i = amodelrenderer.length;
        double d0;

        for (int j = 0; j < i; ++j) {
            ModelRenderer modelrenderer = amodelrenderer[j];
            modelrenderer.rotateAngleX = p_78087_3_;
        }

    }

    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
        super.render(p_78088_1_, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);

        // render at head's child, not need this code
        /*
        for (int i = 0; i < this.cutes.length; ++i) {
            this.cutes[i].render(p_78088_7_);
        }
        */
    }

}
