package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.Executors;
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
import me.deftware.client.framework.helper.SessionHelper;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.item.ItemStack;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.registry.ItemRegistry;
import me.deftware.client.framework.render.batching.LineRenderStack;
import me.deftware.client.framework.world.ClientWorld;

public class C0368 extends AbstractMod {
   private final ArrayList<String> f_fc6394f9 = new ArrayList<>();
   private C0219<Item> f_1a1622ed = new C0219<>(
      Item.class, C0259.m_022da1b4(), C0207.m_2290cbf8(ItemRegistry.INSTANCE, C0259.m_6e2d03c3(), C0259.m_760db7bb(), C0259.m_68957b31()).toArray(new Item[0])
   );
   @C0098(
      value = "Announce",
      description = {"If enabled this mod will announce the murderer in chat"}
   )
   private boolean f_c0862cf5 = false;
   @C0098(
      value = "Tracer",
      description = {"Show a tracer line towards the murderer"}
   )
   private boolean f_8284ff6f = true;
   @C0098(
      value = "Weapons",
      description = {"The weapons to search for"}
   )
   private final GuiScreen f_b23f5a9c = new C0196(null, this.f_1a1622ed, ItemRegistry.INSTANCE, C0259.m_4e02e7a9(), var0 -> var0.getName().string());
   private final LineRenderStack f_888d9c24 = new LineRenderStack();
   private ScheduledFuture<?> f_6ead9032;
   private Entity f_36281de1;

   public C0368() {
      super(C0259.m_3d3a8736(), C0290.f_b895465e, C0259.m_94acbdac());
   }

   @EventHandler
   private void m_4f06bdb8(EventRender3DNoBobbing var1) {
      if (this.f_36281de1 != null && this.f_8284ff6f) {
         ((LineRenderStack)this.f_888d9c24.begin().glColor(Color.red, 200.0F)).lineToEntity(this.f_36281de1).end();
      }
   }

   @EventHandler
   private void m_270a7d18(EventWorldLoad var1) {
      this.m_23674f64();
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      ClientWorld.getClientWorld()
         .getLoadedEntities()
         .filter(var0 -> var0 instanceof EntityPlayer)
         .forEach(
            var1x -> {
               EntityPlayer var2 = (EntityPlayer)var1x;
               ItemStack var3 = var2.getInventory().getHeldItem(false);
               ItemStack var4 = var2.getInventory().getHeldItem(true);
               if ((var3 != null && this.f_1a1622ed.contains(var3.getItem()) || var4 != null && this.f_1a1622ed.contains(var4.getItem()))
                  && !this.f_fc6394f9.contains(var2.getUsername())
                  && !var2.getUsername().equals(SessionHelper.getPlayerUsername())) {
                  this.f_fc6394f9.add(var2.getUsername());
                  C0064.m_13c9ffeb()
                     .m_f41992de(
                        new Builder()
                           .append(C0259.m_7f74d855(), Appearance.of(DefaultColors.GRAY))
                           .append(var2.getUsername(), Appearance.of(2, DefaultColors.AQUA))
                           .append(C0259.m_b89b7876(), Appearance.of(DefaultColors.GRAY))
                           .build()
                     )
                     .m_1058ed9a();
                  if (this.f_c0862cf5) {
                     C0064.m_13c9ffeb().m_ecf8e7ae(C0259.m_a33fab52(), var2.getName().string()).m_0e265701();
                  }

                  this.f_36281de1 = var2;
               }
            }
         );
   }

   @Override
   public void onEnable() {
      this.m_23674f64();
      this.f_6ead9032 = Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(this::m_23674f64, 0L, 600L, TimeUnit.SECONDS);
   }

   public void m_23674f64() {
      this.f_fc6394f9.clear();
      this.f_36281de1 = null;
   }

   @Override
   public void onDisable() {
      this.f_6ead9032.cancel(true);
   }
}
