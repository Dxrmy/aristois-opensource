package me.deftware.aristois.recovered;

import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.List;
import me.deftware.aristois.menu.view.RectTooltip;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.registry.ItemRegistry;

public class C0117 implements C0112<Item> {
   public C0117() {
   }

   public List<Class<? extends Item>> m_b251c7a2() {
      return C0114.bootstrap<"call",0,1>(Item.class);
   }

   public C0163 m_91cb484c(final C0094<Item> var1, ContainerWidget var2, boolean var3) {
      ButtonWidget var4 = new ButtonWidget(C0114.bootstrap<"call",1,1>(var1.m_b5ae4ee3()), var2.m_0826645c()) {
         @Override
         protected void onClick(int var1x) {
            if (var1x == 0) {
               C0114.bootstrap<"call",0,1>().openScreen(C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>().getScreen(), null).m_fcbb48eb(var1xxx -> {
                  var1.m_a8634ed3(var1xxx);
                  return C0114.bootstrap<"call",1,1>(true);
               }));
            }
         }

         public void m_35596834() {
            super.m_7a10bd15();
            this.setLabel(C0114.bootstrap<"call",0,1>(C0117.this, var1));
         }
      };
      if (var1.m_50eeaf3d() == null) {
         var4.m_43533edf(new RectTooltip(var4, (C0441)C0114.bootstrap<"call",2,1>(C0432.class), C0114.bootstrap<"call",1,1>(var1.m_b5ae4ee3())));
      }

      var4.m_e61ee212(new C0426[]{C0426.f_974a55e6});
      return var4;
   }

   private Message m_a8ef7a7d(C0094<Item> var1) {
      return var1.m_48b16e97() != null ? ((Item)var1.m_48b16e97()).getName() : C0114.bootstrap<"call",0,1>(var1.m_b5ae4ee3());
   }

   public Item m_75d210aa(String var1) {
      return ItemRegistry.INSTANCE.stream().filter(var1x -> var1x.getName().toString().equalsIgnoreCase(var1)).findFirst().orElse(null);
   }

   public void m_4fda5dce(SuggestionsBuilder var1) {
      ItemRegistry.INSTANCE
         .stream()
         .map(var0 -> var0.getName().toString().toLowerCase())
         .filter(var1x -> var1x.startsWith(var1.getRemaining().toLowerCase()))
         .forEach(var1::suggest);
   }
}
