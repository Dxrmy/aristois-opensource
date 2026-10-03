/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.passive.PassiveEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.mob.FlyingEntity
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.passive.BatEntity
 *  net.minecraft.entity.mob.AmbientEntity
 *  net.minecraft.entity.passive.FishEntity
 *  net.minecraft.entity.passive.GolemEntity
 *  net.minecraft.entity.passive.ChickenEntity
 *  net.minecraft.entity.passive.AnimalEntity
 *  net.minecraft.entity.passive.CowEntity
 *  net.minecraft.entity.passive.DolphinEntity
 *  net.minecraft.entity.passive.MooshroomEntity
 *  net.minecraft.entity.passive.IronGolemEntity
 *  net.minecraft.entity.passive.PigEntity
 *  net.minecraft.entity.passive.ParrotEntity
 *  net.minecraft.entity.passive.PufferfishEntity
 *  net.minecraft.entity.passive.PolarBearEntity
 *  net.minecraft.entity.passive.RabbitEntity
 *  net.minecraft.entity.passive.SheepEntity
 *  net.minecraft.entity.passive.SnowGolemEntity
 *  net.minecraft.entity.passive.SquidEntity
 *  net.minecraft.entity.mob.WaterCreatureEntity
 *  net.minecraft.entity.passive.TurtleEntity
 *  net.minecraft.entity.passive.WolfEntity
 *  net.minecraft.entity.passive.DonkeyEntity
 *  net.minecraft.entity.passive.HorseEntity
 *  net.minecraft.entity.passive.MuleEntity
 *  net.minecraft.entity.passive.LlamaEntity
 *  net.minecraft.entity.boss.dragon.EnderDragonEntity
 *  net.minecraft.entity.boss.WitherEntity
 *  net.minecraft.entity.ItemEntity
 *  net.minecraft.entity.mob.BlazeEntity
 *  net.minecraft.entity.mob.CreeperEntity
 *  net.minecraft.entity.mob.CaveSpiderEntity
 *  net.minecraft.entity.mob.ElderGuardianEntity
 *  net.minecraft.entity.mob.DrownedEntity
 *  net.minecraft.entity.mob.EndermiteEntity
 *  net.minecraft.entity.mob.EndermanEntity
 *  net.minecraft.entity.mob.EvokerEntity
 *  net.minecraft.entity.mob.GiantEntity
 *  net.minecraft.entity.mob.GhastEntity
 *  net.minecraft.entity.mob.HuskEntity
 *  net.minecraft.entity.mob.GuardianEntity
 *  net.minecraft.entity.mob.IllusionerEntity
 *  net.minecraft.entity.mob.MagmaCubeEntity
 *  net.minecraft.entity.mob.ZombifiedPiglinEntity
 *  net.minecraft.entity.mob.PhantomEntity
 *  net.minecraft.entity.mob.ShulkerEntity
 *  net.minecraft.entity.mob.SkeletonEntity
 *  net.minecraft.entity.mob.SilverfishEntity
 *  net.minecraft.entity.mob.SlimeEntity
 *  net.minecraft.entity.mob.StrayEntity
 *  net.minecraft.entity.mob.SpiderEntity
 *  net.minecraft.entity.mob.VindicatorEntity
 *  net.minecraft.entity.mob.VexEntity
 *  net.minecraft.entity.mob.WitherSkeletonEntity
 *  net.minecraft.entity.mob.WitchEntity
 *  net.minecraft.entity.mob.ZombieEntity
 *  net.minecraft.entity.passive.VillagerEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.projectile.ProjectileEntity
 *  net.minecraft.entity.passive.OcelotEntity
 *  net.minecraft.client.network.OtherClientPlayerEntity
 *  net.minecraft.client.network.ClientPlayerEntity
 */
package me.deftware.client.framework.entity;

import me.deftware.client.framework.entity.Entity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.mob.AmbientEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.PufferfishEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.DonkeyEntity;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.entity.passive.MuleEntity;
import net.minecraft.entity.passive.LlamaEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.CaveSpiderEntity;
import net.minecraft.entity.mob.ElderGuardianEntity;
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.entity.mob.EndermiteEntity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.entity.mob.GiantEntity;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.entity.mob.HuskEntity;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.mob.IllusionerEntity;
import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.entity.mob.ShulkerEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.mob.StrayEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.entity.mob.WitchEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;

public enum EntityType {
    ENTITY_PLAYER_SP,
    EntityOtherPlayerMP,
    ENTITY_PLAYER,
    EntityAnimal,
    EntitySlime,
    EntityGolem,
    EntityFlying,
    EntityMob,
    EntityWaterMob,
    ENTITY_LIVING_BASE,
    ENTITY_LIVING,
    Entity_Ageable,
    EntityAmbientCreature,
    ENTITY_ITEM,
    ENTITY_PROJECTILE,
    ENTITY_BAT,
    ENTITY_CHICKEN,
    ENTITY_COW,
    ENTITY_FISH,
    ENTITY_MOOSHROOM,
    ENTITY_OCELOT,
    ENTITY_PIG,
    ENTITY_POLAR_BEAR,
    ENTITY_RABBIT,
    ENTITY_SHEEP,
    ENTITY_SQUID,
    ENTITY_TURTLE,
    ENTITY_VILLAGER,
    ENTITY_DOLPHIN,
    ENTITY_DONKEY,
    ENTITY_HORSE,
    ENTITY_MULE,
    ENTITY_PARROT,
    ENTITY_ENDERMAN,
    ENTITY_ZOMBIE_PIGMAN,
    ENTITY_SPIDER,
    ENTITY_WITHER_SKELETON,
    ENTITY_WITHER,
    ENTITY_DRAGON,
    ENTITY_PHANTOM,
    ENTITY_DROWNED,
    ENTITY_EVOKER,
    ENTITY_STRAY,
    ENTITY_ELDER_GUARDIAN,
    ENTITY_CREEPER,
    ENTITY_VINDICATOR,
    ENTITY_ILLUSIONER,
    ENTITY_ZOMBIE,
    ENTITY_HUSK,
    ENTITY_SKELETON,
    ENTITY_SHULKER,
    ENTITY_SLIME,
    ENTITY_GUARDIAN,
    ENTITY_VEX,
    ENTITY_SILVERFISH,
    ENTITY_WITCH,
    ENTITY_GIANT,
    ENTITY_BLAZE,
    ENTITY_ENDERMITE,
    ENTITY_GHAST,
    ENTITY_MAGMA_CUBE,
    ENTITY_CAVE_SPIDER,
    ENTITY_WOLF,
    ENTITY_LLAMA,
    ENTITY_IRON_GOLEM,
    ENTITY_SNOW_GOLEM,
    ENTITY_PUFFERFISH;


    public static boolean isInstance(Entity emcEntity, EntityType type) {
        class_1297 entity = emcEntity.getMinecraftEntity();
        if (type.equals((Object)ENTITY_PLAYER_SP)) {
            return entity instanceof class_746;
        }
        if (type.equals((Object)EntityOtherPlayerMP)) {
            return entity instanceof class_745;
        }
        if (type.equals((Object)ENTITY_PLAYER)) {
            return entity instanceof class_1657;
        }
        if (type.equals((Object)ENTITY_LIVING_BASE)) {
            return entity instanceof class_1309;
        }
        if (type.equals((Object)ENTITY_LIVING)) {
            return entity instanceof class_1309;
        }
        if (type.equals((Object)ENTITY_ITEM)) {
            return entity instanceof class_1542;
        }
        if (type.equals((Object)ENTITY_PROJECTILE)) {
            return entity instanceof class_1676;
        }
        if (type.equals((Object)Entity_Ageable)) {
            return entity instanceof class_1296;
        }
        if (type.equals((Object)EntityAmbientCreature)) {
            return entity instanceof class_1421;
        }
        if (type.equals((Object)EntityWaterMob)) {
            return entity instanceof class_1480;
        }
        if (type.equals((Object)EntityMob)) {
            return entity instanceof class_1308;
        }
        if (type.equals((Object)EntityAnimal)) {
            return entity instanceof class_1429;
        }
        if (type.equals((Object)ENTITY_BAT)) {
            return entity instanceof class_1420;
        }
        if (type.equals((Object)ENTITY_CHICKEN)) {
            return entity instanceof class_1428;
        }
        if (type.equals((Object)ENTITY_COW)) {
            return entity instanceof class_1430;
        }
        if (type.equals((Object)ENTITY_FISH)) {
            return entity instanceof class_1422;
        }
        if (type.equals((Object)ENTITY_MOOSHROOM)) {
            return entity instanceof class_1438;
        }
        if (type.equals((Object)ENTITY_OCELOT)) {
            return entity instanceof class_3701;
        }
        if (type.equals((Object)ENTITY_PIG)) {
            return entity instanceof class_1452;
        }
        if (type.equals((Object)ENTITY_POLAR_BEAR)) {
            return entity instanceof class_1456;
        }
        if (type.equals((Object)ENTITY_RABBIT)) {
            return entity instanceof class_1463;
        }
        if (type.equals((Object)ENTITY_SHEEP)) {
            return entity instanceof class_1472;
        }
        if (type.equals((Object)ENTITY_SQUID)) {
            return entity instanceof class_1477;
        }
        if (type.equals((Object)ENTITY_TURTLE)) {
            return entity instanceof class_1481;
        }
        if (type.equals((Object)ENTITY_VILLAGER)) {
            return entity instanceof class_1646;
        }
        if (type.equals((Object)ENTITY_DOLPHIN)) {
            return entity instanceof class_1433;
        }
        if (type.equals((Object)ENTITY_DONKEY)) {
            return entity instanceof class_1495;
        }
        if (type.equals((Object)ENTITY_MULE)) {
            return entity instanceof class_1500;
        }
        if (type.equals((Object)ENTITY_HORSE)) {
            return entity instanceof class_1498;
        }
        if (type.equals((Object)ENTITY_PARROT)) {
            return entity instanceof class_1453;
        }
        if (type.equals((Object)EntitySlime) || type.equals((Object)ENTITY_SLIME)) {
            return entity instanceof class_1621;
        }
        if (type.equals((Object)EntityFlying)) {
            return entity instanceof class_1307;
        }
        if (type.equals((Object)EntityGolem)) {
            return entity instanceof class_1427;
        }
        if (type.equals((Object)ENTITY_SPIDER)) {
            return entity instanceof class_1628;
        }
        if (type.equals((Object)ENTITY_ZOMBIE_PIGMAN)) {
            return entity instanceof class_1590;
        }
        if (type.equals((Object)ENTITY_ENDERMAN)) {
            return entity instanceof class_1560;
        }
        if (type.equals((Object)ENTITY_WITHER_SKELETON)) {
            return entity instanceof class_1639;
        }
        if (type.equals((Object)ENTITY_WITHER)) {
            return entity instanceof class_1528;
        }
        if (type.equals((Object)ENTITY_DRAGON)) {
            return entity instanceof class_1510;
        }
        if (type.equals((Object)ENTITY_PHANTOM)) {
            return entity instanceof class_1593;
        }
        if (type.equals((Object)ENTITY_DROWNED)) {
            return entity instanceof class_1551;
        }
        if (type.equals((Object)ENTITY_EVOKER)) {
            return entity instanceof class_1564;
        }
        if (type.equals((Object)ENTITY_STRAY)) {
            return entity instanceof class_1627;
        }
        if (type.equals((Object)ENTITY_ELDER_GUARDIAN)) {
            return entity instanceof class_1550;
        }
        if (type.equals((Object)ENTITY_CREEPER)) {
            return entity instanceof class_1548;
        }
        if (type.equals((Object)ENTITY_VINDICATOR)) {
            return entity instanceof class_1632;
        }
        if (type.equals((Object)ENTITY_ILLUSIONER)) {
            return entity instanceof class_1581;
        }
        if (type.equals((Object)ENTITY_HUSK)) {
            return entity instanceof class_1576;
        }
        if (type.equals((Object)ENTITY_ZOMBIE)) {
            return entity instanceof class_1642;
        }
        if (type.equals((Object)ENTITY_SKELETON)) {
            return entity instanceof class_1613;
        }
        if (type.equals((Object)ENTITY_SHULKER)) {
            return entity instanceof class_1606;
        }
        if (type.equals((Object)ENTITY_GUARDIAN)) {
            return entity instanceof class_1577;
        }
        if (type.equals((Object)ENTITY_VEX)) {
            return entity instanceof class_1634;
        }
        if (type.equals((Object)ENTITY_SILVERFISH)) {
            return entity instanceof class_1614;
        }
        if (type.equals((Object)ENTITY_WITCH)) {
            return entity instanceof class_1640;
        }
        if (type.equals((Object)ENTITY_GIANT)) {
            return entity instanceof class_1570;
        }
        if (type.equals((Object)ENTITY_BLAZE)) {
            return entity instanceof class_1545;
        }
        if (type.equals((Object)ENTITY_ENDERMITE)) {
            return entity instanceof class_1559;
        }
        if (type.equals((Object)ENTITY_GHAST)) {
            return entity instanceof class_1571;
        }
        if (type.equals((Object)ENTITY_MAGMA_CUBE)) {
            return entity instanceof class_1589;
        }
        if (type.equals((Object)ENTITY_CAVE_SPIDER)) {
            return entity instanceof class_1549;
        }
        if (type.equals((Object)ENTITY_WOLF)) {
            return entity instanceof class_1493;
        }
        if (type.equals((Object)ENTITY_LLAMA)) {
            return entity instanceof class_1501;
        }
        if (type.equals((Object)ENTITY_IRON_GOLEM)) {
            return entity instanceof class_1439;
        }
        if (type.equals((Object)ENTITY_SNOW_GOLEM)) {
            return entity instanceof class_1473;
        }
        if (type.equals((Object)ENTITY_PUFFERFISH)) {
            return entity instanceof class_1454;
        }
        return false;
    }
}

