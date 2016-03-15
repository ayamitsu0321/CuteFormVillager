package ayamitsu.cuteformvillager.event;

import ayamitsu.cuteformvillager.EntityCuteFormVillager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.village.Village;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by ayamitsu0321 on 2016/03/15.
 */
public class WhyTheyWereKilledCuteMobsEvent {

    @SubscribeEvent
    public void handleLivingDeath(LivingDeathEvent event) {
        DamageSource source = event.source;
        Entity entity = source.getEntity();

        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)entity;
            EntityVillager target = null;

            // 近場をみる
            for (Object obj : player.worldObj.getEntitiesWithinAABB(EntityVillager.class, player.getEntityBoundingBox().expand(64D, 64D, 64D))) {
                if (obj.getClass() == EntityVillager.class) {
                    target = (EntityVillager)obj;
                    break;
                }
            }

            if (target == null) {
                //村を総当たり
                for (Object obj : player.worldObj.getVillageCollection().getVillageList()) {
                    if (obj instanceof Village) {
                        Village village = (Village)obj;
                        int villageRadius = village.getVillageRadius();

                        for (Object obj1 : player.worldObj.getEntitiesWithinAABB(EntityVillager.class, new AxisAlignedBB(village.getCenter().add(-villageRadius, -villageRadius, -villageRadius), village.getCenter().add(villageRadius, villageRadius, villageRadius)))) {
                            if (obj1 instanceof EntityVillager) {
                                target = (EntityVillager)obj1;
                                break;
                            }
                        }

                        if (target != null) break;
                    }
                }
            }

            if (target != null && !player.worldObj.isRemote) {
                EntityCuteFormVillager cute = new EntityCuteFormVillager(player.worldObj, target.getProfession());
                // take over
                NBTTagCompound nbt = new NBTTagCompound();
                target.writeToNBT(nbt);
                cute.readFromNBT(nbt);

                cute.setPositionAndRotation(target.posX, target.posY, target.posZ, target.rotationYaw, target.rotationPitch);
                target.setDead();
                player.worldObj.spawnEntityInWorld(cute);

            }
        }
    }

}
