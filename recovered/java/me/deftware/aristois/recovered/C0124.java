package me.deftware.aristois.recovered;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.types.ArmourItem;
import me.deftware.client.framework.item.types.BlockItem;
import me.deftware.client.framework.item.types.BowItem;
import me.deftware.client.framework.item.types.CrossbowItem;
import me.deftware.client.framework.item.types.FishingRodItem;
import me.deftware.client.framework.item.types.FoodItem;
import me.deftware.client.framework.item.types.PotionItem;
import me.deftware.client.framework.item.types.RangedWeaponItem;
import me.deftware.client.framework.item.types.SwordItem;
import me.deftware.client.framework.item.types.ToolItem;
import me.deftware.client.framework.item.types.TridentItem;
import me.deftware.client.framework.item.types.WeaponItem;
import me.deftware.client.framework.registry.ItemRegistry;

public class C0124 implements C0131<Item> {
   public C0124() {
   }

   public void m_4b6710c7(JsonWriter var1, Item var2) throws IOException {
      var1.name(C0266.m_c04d8f6e());
      var1.value(var2.getIdentifierKey());
   }

   public Item m_97e6d26f(JsonReader var1) throws IOException {
      String var2 = var1.nextName();
      return (Item)ItemRegistry.INSTANCE.find(var1.nextString()).orElseThrow(() -> new IOException(C0266.m_a5b24d28() + var2));
   }

   @Override
   public List<Class<? extends Item>> m_350b5ae0() {
      return Arrays.asList(
         Item.class,
         ArmourItem.class,
         CrossbowItem.class,
         BowItem.class,
         SwordItem.class,
         WeaponItem.class,
         ToolItem.class,
         FoodItem.class,
         BlockItem.class,
         PotionItem.class,
         FishingRodItem.class,
         TridentItem.class,
         RangedWeaponItem.class
      );
   }
}
