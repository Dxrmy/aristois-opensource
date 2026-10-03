/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.passive.ChickenEntity
 *  net.minecraft.entity.mob.WaterCreatureEntity
 *  net.minecraft.entity.passive.WolfEntity
 *  net.minecraft.entity.passive.HorseEntity
 *  net.minecraft.entity.decoration.EndCrystalEntity
 *  net.minecraft.entity.ItemEntity
 *  net.minecraft.entity.mob.Monster
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.projectile.ProjectileEntity
 *  net.minecraft.entity.vehicle.BoatEntity
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.entity.EntityPose
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.client.network.AbstractClientPlayerEntity
 *  net.minecraft.client.util.SkinTextures
 */
package me.deftware.client.framework.entity;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import me.deftware.client.framework.entity.EntityCapsule;
import me.deftware.client.framework.entity.EntityType;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.OwnedEntity;
import me.deftware.client.framework.entity.types.animals.HorseEntity;
import me.deftware.client.framework.entity.types.animals.MobEntity;
import me.deftware.client.framework.entity.types.animals.WaterEntity;
import me.deftware.client.framework.entity.types.animals.WolfEntity;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.objects.BoatEntity;
import me.deftware.client.framework.entity.types.objects.EndCrystalEntity;
import me.deftware.client.framework.entity.types.objects.ItemEntity;
import me.deftware.client.framework.entity.types.objects.ProjectileEntity;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.math.BlockPosition;
import me.deftware.client.framework.math.BoundingBox;
import me.deftware.client.framework.math.ChunkPosition;
import me.deftware.client.framework.math.Vector3;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.nbt.NbtCompound;
import me.deftware.client.framework.world.ClientWorld;
import me.deftware.client.framework.world.EnumFacing;
import me.deftware.mixin.imp.IMixinAbstractClientPlayer;
import me.deftware.mixin.imp.IMixinEntity;
import me.deftware.mixin.imp.IMixinEntityLivingBase;
import me.deftware.mixin.imp.IMixinNetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityPose;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.SkinTextures;

public class Entity {
    private List<ItemStack> armourItems = Collections.emptyList();
    private Entity vehicle;
    protected final class_1297 entity;

    public static Entity newInstance(class_1297 entity) {
        if (entity == class_310.method_1551().field_1724) {
            return new MainEntityPlayer((class_1657)entity);
        }
        if (entity instanceof class_1657) {
            return new EntityPlayer((class_1657)entity);
        }
        if (entity instanceof class_1676) {
            return new ProjectileEntity(entity);
        }
        if (entity instanceof class_1511) {
            return new EndCrystalEntity(entity);
        }
        if (entity instanceof class_1498) {
            return new HorseEntity(entity);
        }
        if (entity instanceof class_1690) {
            return new BoatEntity(entity);
        }
        if (entity instanceof class_1493) {
            return new WolfEntity(entity);
        }
        if (entity instanceof class_1480) {
            return new WaterEntity(entity);
        }
        if (entity instanceof class_1308) {
            return new MobEntity(entity);
        }
        if (entity instanceof class_1542) {
            return new ItemEntity(entity);
        }
        if (entity instanceof class_1309) {
            if (entity.method_5647(new class_2487()).method_25928("Owner")) {
                return new OwnedEntity(entity);
            }
            return new LivingEntity(entity);
        }
        return new Entity(entity);
    }

    protected Entity(class_1297 entity) {
        this.entity = entity;
        if (entity.method_5854() != null) {
            this.vehicle = ClientWorld.getClientWorld().getEntityByReference(entity.method_5854());
        }
    }

    public EnumFacing getHorizontalFacing() {
        return EnumFacing.fromMinecraft(this.getMinecraftEntity().method_5735());
    }

    public BlockPosition getBlockPosition() {
        return (BlockPosition)this.getMinecraftEntity().method_24515();
    }

    public class_1297 getMinecraftEntity() {
        return this.entity;
    }

    public BoundingBox getBoundingBox() {
        return (BoundingBox)this.getMinecraftEntity().method_5829();
    }

    public boolean isSpectating() {
        return this.entity.method_7325();
    }

    public boolean isRiding() {
        return this.entity.method_5765();
    }

    public boolean isAirBorne() {
        return this.entity.field_6007;
    }

    public float getFallDistance() {
        return this.entity.field_6017;
    }

    public Entity getVehicle() {
        if (this.entity.method_5854() == null) {
            return null;
        }
        if (this.vehicle == null || this.vehicle.getMinecraftEntity() != this.entity.method_5854()) {
            this.vehicle = ClientWorld.getClientWorld().getEntityByReference(this.entity.method_5854());
        }
        return this.vehicle;
    }

    public boolean isTouchingWater() {
        return this.entity.method_5799();
    }

    public ItemStack getEntityHeldItem(boolean offhand) {
        return ItemStack.EMPTY;
    }

    public void armorInventory(Consumer<ItemStack> consumer) {
        class_1297 class_12972 = this.entity;
        if (class_12972 instanceof class_1309) {
            class_1309 e = (class_1309)class_12972;
            e.method_5661().forEach(itemStack -> consumer.accept((ItemStack)itemStack));
        }
    }

    public void setInPortal(boolean inPortal) {
        ((IMixinEntity)this.entity).setInPortal(inPortal);
    }

    public void reloadSkin() {
        class_742 abstractEntity;
        class_8685 texture;
        class_1297 class_12972 = this.entity;
        if (class_12972 instanceof class_742 && (texture = (abstractEntity = (class_742)class_12972).method_52814()).comp_1628() != null) {
            ((IMixinNetworkPlayerInfo)((IMixinAbstractClientPlayer)abstractEntity).getPlayerNetworkInfo()).reloadTextures();
        }
    }

    public boolean isCollidedHorizontally() {
        return this.entity.field_5976;
    }

    public boolean isCollidedVertically() {
        return this.entity.field_5992;
    }

    public int getResponseTime() {
        class_634 networkHandler;
        if (class_310.method_1551().method_1562() != null && (networkHandler = class_310.method_1551().method_1562()).method_2871(this.entity.method_5667()) != null) {
            return Objects.requireNonNull(networkHandler.method_2871(this.entity.method_5667())).method_2959();
        }
        return -1;
    }

    public boolean hasNbt() {
        return this.entity.method_5647(new class_2487()) != null && this.entity.method_5647(new class_2487()).method_10546() != 0;
    }

    public NbtCompound getNbt() {
        return (NbtCompound)this.entity.method_5647(new class_2487());
    }

    public int getTicksExisted() {
        return this.entity.field_6012;
    }

    public boolean isSneaking() {
        return this.entity.method_5715();
    }

    public boolean isInLiquid() {
        return this.entity.method_5799() || this.entity.method_5771();
    }

    public boolean isSelf() {
        return this.entity == class_310.method_1551().field_1724;
    }

    public int getEntityId() {
        return this.entity.method_5628();
    }

    public float getHeight() {
        return this.entity.method_17682();
    }

    public void setGlowing(boolean state) {
        this.entity.method_5834(state);
    }

    public boolean isOnGround() {
        return this.entity.method_24828();
    }

    public void setOnGround(boolean flag) {
        this.entity.method_24830(flag);
    }

    public boolean isOnFire() {
        return this.entity.method_5809();
    }

    public void setOnFire(int seconds) {
        this.entity.method_5639((float)seconds);
    }

    public float getStepHeight() {
        return this.entity.method_49476();
    }

    public void setStepHeight(float height) {
        class_1297 class_12972 = this.entity;
        if (class_12972 instanceof IMixinEntityLivingBase) {
            IMixinEntityLivingBase base = (IMixinEntityLivingBase)class_12972;
            base._setStepHeight(height);
        }
    }

    public boolean isWithinChunk(ChunkPosition chunkPos) {
        return this.getPosX() >= (double)chunkPos.getStartX() && this.getPosX() <= (double)chunkPos.getEndX() && this.getPosZ() >= (double)chunkPos.getStartZ() && this.getPosZ() <= (double)chunkPos.getEndZ();
    }

    public boolean isHostile() {
        if (this.entity instanceof class_1428) {
            return ((class_1428)this.entity).field_6740;
        }
        return this.entity instanceof class_1569;
    }

    public boolean isAlive() {
        return this.entity.method_5805();
    }

    public boolean instanceOf(EntityType type) {
        return EntityType.isInstance(this, type);
    }

    public boolean isInvisible() {
        return this.entity.method_5767();
    }

    public double getEyeHeight() {
        return this.entity.method_18381(this.entity.method_18376());
    }

    public double getStandingEyeHeight() {
        return this.entity.method_18381(class_4050.field_18076);
    }

    public boolean canBeSeenBy(EntityPlayer entity) {
        return !this.entity.method_5756(entity.getMinecraftEntity());
    }

    public float distanceToEntity(Entity entity) {
        return this.entity.method_5739(entity.getMinecraftEntity());
    }

    public Message getName() {
        return (Message)this.entity.method_5476();
    }

    public String getEntityTypeName() {
        return this.entity.method_5864().method_5897().getString();
    }

    public void setNoClip(boolean state) {
        this.entity.field_5960 = state;
    }

    public void setFallDistance(float distance) {
        this.entity.field_6017 = distance;
    }

    public String getEntityName() {
        return this.entity.method_5845();
    }

    public double getLastTickPosX() {
        return this.entity.field_6038;
    }

    public double getLastTickPosY() {
        return this.entity.field_5971;
    }

    public double getLastTickPosZ() {
        return this.entity.field_5989;
    }

    public Vector3<Double> getRotationVector() {
        return (Vector3)this.getMinecraftEntity().method_5720();
    }

    public Vector3<Double> getPosition() {
        return (Vector3)this.getMinecraftEntity().method_19538();
    }

    public int getChunkX() {
        return this.entity.method_31476().field_9181;
    }

    public int getChunkY() {
        return 0;
    }

    public int getChunkZ() {
        return this.entity.method_31476().field_9180;
    }

    public double getPosX() {
        return this.entity.method_23317();
    }

    public double getPosY() {
        return this.entity.method_23318();
    }

    public double getPosZ() {
        return this.entity.method_23321();
    }

    public double getPrevPosX() {
        return this.entity.field_6014;
    }

    public double getPrevPosY() {
        return this.entity.field_6036;
    }

    public double getPrevPosZ() {
        return this.entity.field_5969;
    }

    public float getRotationYaw() {
        return this.entity.method_36454();
    }

    public float getRotationPitch() {
        return this.entity.method_36455();
    }

    public void setRotationYaw(float yaw) {
        this.entity.method_36456(yaw);
    }

    public void setRotationPitch(float pitch) {
        this.entity.method_36457(pitch);
    }

    public void setPosition(double x, double y, double z) {
        this.entity.method_30634(x, y, z);
    }

    public void setPositionAndRotation(double x, double y, double z, float yaw, float pitch) {
        this.entity.method_5808(x, y, z, yaw, pitch);
    }

    public Vector3<Double> getEyesPos() {
        return Vector3.ofDouble(this.entity.method_23317(), this.entity.method_23318() + (double)this.entity.method_18381(this.entity.method_18376()), this.entity.method_23321());
    }

    public boolean getFlag(int id) {
        return ((IMixinEntity)this.entity).getAFlag(id);
    }

    public void setVelocity(double x, double y, double z) {
        this.entity.method_18800(x, y, z);
    }

    public void setVelocity(Vector3<Double> vector3d) {
        this.entity.method_18799((class_243)vector3d);
    }

    public Vector3<Double> getVelocity() {
        return (Vector3)this.entity.method_18798();
    }

    public boolean equals(Object o) {
        if (o instanceof EntityCapsule) {
            return ((EntityCapsule)o).getTranslationKey().equalsIgnoreCase(this.entity.method_5864().method_5882());
        }
        return super.equals(o);
    }
}

