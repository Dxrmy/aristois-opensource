/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  net.minecraft.item.ItemStack
 *  net.minecraft.village.TradeOffer
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.play.SetTradeOffersS2CPacket
 */
package me.deftware.client.framework.network.packets;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.network.PacketWrapper;
import net.minecraft.item.ItemStack;
import net.minecraft.village.TradeOffer;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.SetTradeOffersS2CPacket;

public class SPacketTradeOffers
extends PacketWrapper {
    public SPacketTradeOffers(class_2596<?> packet) {
        super(packet);
    }

    public JsonObject getJson() {
        class_3943 packet = (class_3943)this.packet;
        JsonObject json = new JsonObject();
        json.addProperty("experience", (Number)packet.method_19459());
        json.addProperty("level", (Number)packet.method_19458());
        JsonArray trades = new JsonArray();
        for (class_1914 offer : packet.method_17590()) {
            JsonObject trade = new JsonObject();
            trade.add("first", (JsonElement)this.getItem(offer.method_19272()));
            offer.method_57557().ifPresent(tradedItem -> trade.add("second", (JsonElement)this.getItem(tradedItem.comp_2427())));
            trade.add("sell", (JsonElement)this.getItem(offer.method_8250()));
            trade.addProperty("xp", (Number)offer.method_19279());
            trade.addProperty("uses", (Number)offer.method_8249());
            trade.addProperty("maxUses", (Number)offer.method_8248());
            trades.add((JsonElement)trade);
        }
        json.add("trades", (JsonElement)trades);
        return json;
    }

    private JsonObject getItem(class_1799 stack) {
        JsonObject json = new JsonObject();
        json.addProperty("count", (Number)stack.method_7947());
        json.addProperty("id", stack.method_7909().method_7876());
        JsonArray meta = new JsonArray();
        ((ItemStack)stack).enchantments((level, enchantment) -> meta.add(enchantment.getName((int)level).getString()));
        if (!meta.isEmpty()) {
            json.add("meta", (JsonElement)meta);
        }
        return json;
    }
}

