package ayamitsu.cuteformvillager;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by ayamitsu0321 on 2016/03/15.
 */
public class EntityCuteFormVillager extends EntityVillager {

    public float cuteAngle;
    public float lastCuteAngle;

    public float cuteRotation;
    public float rotationVelocity;

    public EntityCuteFormVillager(World worldIn) {
        super(worldIn);
        this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
    }

    public EntityCuteFormVillager(World worldIn, int professionId) {
        super(worldIn, professionId);
        this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.lastCuteAngle = this.cuteAngle;
        this.cuteRotation += this.rotationVelocity;

        if ((double)this.cuteRotation > (Math.PI * 2D)) {
            if (this.worldObj.isRemote) {
                this.cuteRotation = ((float)Math.PI * 2F);
            } else {
                this.cuteRotation = (float)((double)this.cuteRotation - (Math.PI * 2D));

                if (this.rand.nextInt(10) == 0) {
                    this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
                }

                this.worldObj.setEntityState(this, (byte)19);
            }
        }

        this.cuteAngle = MathHelper.abs(MathHelper.sin(this.cuteRotation)) * (float)Math.PI * 0.25F;
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte p_70103_1_) {
        if (p_70103_1_ == 19) {
            this.cuteRotation = 0.0F;
        } else {
            super.handleHealthUpdate(p_70103_1_);
        }
    }

    /**
     * @return a frog's child is a frog
     */
    @Override
    public EntityVillager func_180488_b(EntityAgeable p_180488_1_) {
        EntityVillager entityvillager = new EntityCuteFormVillager(this.worldObj);
        entityvillager.func_180482_a(this.worldObj.getDifficultyForLocation(new BlockPos(entityvillager)), (IEntityLivingData)null);
        return entityvillager;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    protected String getLivingSound() {
        return null;
    }

    @Override
    protected String getHurtSound() {
        return null;
    }

    @Override
    protected String getDeathSound() {
        return null;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }


}
