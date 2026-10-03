package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3DNoBobbing;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.event.events.EventWorldLoad;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.registry.ItemRegistry;
import me.deftware.client.framework.render.batching.LineRenderStack;

public class C0368 extends AbstractMod {
   private final ArrayList<String> f_a1ed3e05 = new ArrayList<>();
   private C0219<Item> f_c5d4e7ae = new C0219<>(
      Item.class,
      C0252.bootstrap<"get",42949673003>(),
      C0114.bootstrap<"call",0,1>(
            ItemRegistry.INSTANCE,
            new String[]{C0252.bootstrap<"get",42949673004>(), C0252.bootstrap<"get",42949673005>(), C0252.bootstrap<"get",42949673006>()}
         )
         .toArray(new Item[0])
   );
   @C0098(
      value = "Announce",
      description = {"If enabled this mod will announce the murderer in chat"}
   )
   private boolean f_ec21bb86 = false;
   @C0098(
      value = "Tracer",
      description = {"Show a tracer line towards the murderer"}
   )
   private boolean f_67cde574 = true;
   @C0098(
      value = "Weapons",
      description = {"The weapons to search for"}
   )
   private final GuiScreen f_bb0d92f8 = new C0196(
      null, this.f_c5d4e7ae, ItemRegistry.INSTANCE, C0252.bootstrap<"get",42949673007>(), var0 -> var0.getName().string()
   );
   private final LineRenderStack f_9b5c8adf = new LineRenderStack();
   private ScheduledFuture<?> f_e1d468c8;
   private Entity f_cbd5f65e;

   public C0368() {
      super(C0252.bootstrap<"get",42949673001>(), C0290.f_d6bd3b90, C0252.bootstrap<"get",42949673002>());
   }

   @EventHandler
   private void m_33717a83(EventRender3DNoBobbing var1) {
      if (this.f_cbd5f65e != null && this.f_67cde574) {
         ((LineRenderStack)this.f_9b5c8adf.begin().glColor(Color.red, 200.0F)).lineToEntity(this.f_cbd5f65e).end();
      }
   }

   @EventHandler
   private void m_742b2d55(EventWorldLoad var1) {
      this.m_226d6afe();
   }

   @EventHandler
   public void m_a49db91c(EventUpdate var1) {
      C0114.bootstrap<"call",0,1>()
         .getLoadedEntities()
         .filter(var0 -> var0 instanceof EntityPlayer)
         .forEach(
            var1x -> {
               EntityPlayer var2 = (EntityPlayer)var1x;
               ItemStack var3 = var2.getInventory().getHeldItem(false);
               ItemStack var4 = var2.getInventory().getHeldItem(true);
               if ((var3 != null && this.f_c5d4e7ae.contains(var3.getItem()) || var4 != null && this.f_c5d4e7ae.contains(var4.getItem()))
                  && !this.f_a1ed3e05.contains(var2.getUsername())
                  && !var2.getUsername().equals(C0114.bootstrap<"call",1,1>())) {
                  this.f_a1ed3e05.add(var2.getUsername());
                  C0114.bootstrap<"call",2,1>()
                     .m_b7d6d46c(
                        new Builder()
                           .append(C0252.bootstrap<"get",42949673008>(), C0114.bootstrap<"call",3,1>(DefaultColors.GRAY))
                           .append(var2.getUsername(), C0114.bootstrap<"call",4,1>(2, DefaultColors.AQUA))
                           .append(C0252.bootstrap<"get",42949673009>(), C0114.bootstrap<"call",3,1>(DefaultColors.GRAY))
                           .build()
                     )
                     .m_66e721c0();
                  if (this.f_ec21bb86) {
                     C0114.bootstrap<"call",2,1>().m_5de8d0b8(C0252.bootstrap<"get",42949673010>(), var2.getName().string()).m_f0402f6b();
                  }

                  this.f_cbd5f65e = var2;
               }
            }
         );
   }

   @Override
   public void onEnable() {
      this.m_226d6afe();
      this.f_e1d468c8 = C0114.bootstrap<"call",0,1>().scheduleAtFixedRate(this::m_226d6afe, 0L, 600L, TimeUnit.SECONDS);
   }

   public void m_226d6afe() {
      this.f_a1ed3e05.clear();
      this.f_cbd5f65e = null;
   }

   @Override
   public void onDisable() {
      this.f_e1d468c8.cancel(true);
   }
}
