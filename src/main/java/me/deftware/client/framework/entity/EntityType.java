/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1296
 *  net.minecraft.class_1297
 *  net.minecraft.class_1307
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1420
 *  net.minecraft.class_1421
 *  net.minecraft.class_1422
 *  net.minecraft.class_1427
 *  net.minecraft.class_1428
 *  net.minecraft.class_1429
 *  net.minecraft.class_1430
 *  net.minecraft.class_1433
 *  net.minecraft.class_1438
 *  net.minecraft.class_1439
 *  net.minecraft.class_1452
 *  net.minecraft.class_1453
 *  net.minecraft.class_1454
 *  net.minecraft.class_1456
 *  net.minecraft.class_1463
 *  net.minecraft.class_1472
 *  net.minecraft.class_1473
 *  net.minecraft.class_1477
 *  net.minecraft.class_1480
 *  net.minecraft.class_1481
 *  net.minecraft.class_1493
 *  net.minecraft.class_1495
 *  net.minecraft.class_1498
 *  net.minecraft.class_1500
 *  net.minecraft.class_1501
 *  net.minecraft.class_1510
 *  net.minecraft.class_1528
 *  net.minecraft.class_1542
 *  net.minecraft.class_1545
 *  net.minecraft.class_1548
 *  net.minecraft.class_1549
 *  net.minecraft.class_1550
 *  net.minecraft.class_1551
 *  net.minecraft.class_1559
 *  net.minecraft.class_1560
 *  net.minecraft.class_1564
 *  net.minecraft.class_1570
 *  net.minecraft.class_1571
 *  net.minecraft.class_1576
 *  net.minecraft.class_1577
 *  net.minecraft.class_1581
 *  net.minecraft.class_1589
 *  net.minecraft.class_1590
 *  net.minecraft.class_1593
 *  net.minecraft.class_1606
 *  net.minecraft.class_1613
 *  net.minecraft.class_1614
 *  net.minecraft.class_1621
 *  net.minecraft.class_1627
 *  net.minecraft.class_1628
 *  net.minecraft.class_1632
 *  net.minecraft.class_1634
 *  net.minecraft.class_1639
 *  net.minecraft.class_1640
 *  net.minecraft.class_1642
 *  net.minecraft.class_1646
 *  net.minecraft.class_1657
 *  net.minecraft.class_1676
 *  net.minecraft.class_3701
 *  net.minecraft.class_745
 *  net.minecraft.class_746
 */
package me.deftware.client.framework.entity;

import me.deftware.client.framework.entity.Entity;
import net.minecraft.class_1296;
import net.minecraft.class_1297;
import net.minecraft.class_1307;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1420;
import net.minecraft.class_1421;
import net.minecraft.class_1422;
import net.minecraft.class_1427;
import net.minecraft.class_1428;
import net.minecraft.class_1429;
import net.minecraft.class_1430;
import net.minecraft.class_1433;
import net.minecraft.class_1438;
import net.minecraft.class_1439;
import net.minecraft.class_1452;
import net.minecraft.class_1453;
import net.minecraft.class_1454;
import net.minecraft.class_1456;
import net.minecraft.class_1463;
import net.minecraft.class_1472;
import net.minecraft.class_1473;
import net.minecraft.class_1477;
import net.minecraft.class_1480;
import net.minecraft.class_1481;
import net.minecraft.class_1493;
import net.minecraft.class_1495;
import net.minecraft.class_1498;
import net.minecraft.class_1500;
import net.minecraft.class_1501;
import net.minecraft.class_1510;
import net.minecraft.class_1528;
import net.minecraft.class_1542;
import net.minecraft.class_1545;
import net.minecraft.class_1548;
import net.minecraft.class_1549;
import net.minecraft.class_1550;
import net.minecraft.class_1551;
import net.minecraft.class_1559;
import net.minecraft.class_1560;
import net.minecraft.class_1564;
import net.minecraft.class_1570;
import net.minecraft.class_1571;
import net.minecraft.class_1576;
import net.minecraft.class_1577;
import net.minecraft.class_1581;
import net.minecraft.class_1589;
import net.minecraft.class_1590;
import net.minecraft.class_1593;
import net.minecraft.class_1606;
import net.minecraft.class_1613;
import net.minecraft.class_1614;
import net.minecraft.class_1621;
import net.minecraft.class_1627;
import net.minecraft.class_1628;
import net.minecraft.class_1632;
import net.minecraft.class_1634;
import net.minecraft.class_1639;
import net.minecraft.class_1640;
import net.minecraft.class_1642;
import net.minecraft.class_1646;
import net.minecraft.class_1657;
import net.minecraft.class_1676;
import net.minecraft.class_3701;
import net.minecraft.class_745;
import net.minecraft.class_746;

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

