package me.deftware.aristois.recovered;

import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Collections;
import java.util.List;
import me.deftware.aristois.menu.view.RectTooltip;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.registry.ItemRegistry;

public class C0117 implements C0112<Item> {
   public C0117() {
   }

   @Override
   public List<Class<? extends Item>> m_350b5ae0() {
      return Collections.singletonList(Item.class);
   }

   @Override
   public C0163 m_5f0a4ee5(final C0094<Item> var1, ContainerWidget var2, boolean var3) {
      ButtonWidget var4 = new ButtonWidget(Message.of(var1.m_6f1f396d()), var2.m_519f75ae()) {
         @Override
         protected void onClick(int var1x) {
            if (var1x == 0) {
               Minecraft.getMinecraftGame().openScreen(C0217.m_81b76da4(Minecraft.getMinecraftGame().getScreen(), null).m_173e187f(var1xxx -> {
                  var1.m_a32b61ee(var1xxx);
                  return true;
               }));
            }
         }

         @Override
         public void m_1058ed9a() {
            super.m_1058ed9a();
            this.setLabel(C0117.this.m_08d19569(var1));
         }
      };
      if (var1.m_b3e55a9d() == null) {
         var4.m_c7a3618c(new RectTooltip(var4, C0289.m_c3a8b502(C0432.class), Message.of(var1.m_6f1f396d())));
      }

      var4.m_ec141b95(new C0426[]{C0426.f_c285454f});
      return var4;
   }

   private Message m_08d19569(C0094<Item> var1) {
      return var1.m_50ca8f08() != null ? ((Item)var1.m_50ca8f08()).getName() : Message.of(var1.m_6f1f396d());
   }

   public Item m_7ecf9439(String var1) {
      return ItemRegistry.INSTANCE.stream().filter(var1x -> var1x.getName().toString().equalsIgnoreCase(var1)).findFirst().orElse(null);
   }

   @Override
   public void m_44a89f72(SuggestionsBuilder var1) {
      ItemRegistry.INSTANCE
         .stream()
         .map(var0 -> var0.getName().toString().toLowerCase())
         .filter(var1x -> var1x.startsWith(var1.getRemaining().toLowerCase()))
         .forEach(var1::suggest);
   }
}
