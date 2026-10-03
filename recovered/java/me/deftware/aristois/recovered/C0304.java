package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.gui.screens.MinecraftScreen;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0304 extends C0342 {
   @C0098(
      value = "Health trigger",
      description = {"At what health to trigger at"}
   )
   private float f_4d837b6d = 8.0F;
   @C0098(
      value = "Tags",
      description = {"Automatically disconnect when a", "matched prefix user joins the server"}
   )
   private boolean f_93f57e08 = false;
   @C0098(
      value = "AutoDisable",
      description = {"Disable AutoDisconnect when disconnecting"}
   )
   private boolean f_f4f851f6 = true;
   @C0098(
      value = "Singleplayer",
      description = {"Allow AutoDisconnect in singleplayer"}
   )
   private boolean f_1edd2f0d = false;
   @C0098(
      value = "Disable AutoReconnect",
      description = {"Automatically disables AutoReconnect"}
   )
   private boolean f_a5bf7a80 = true;

   public C0304() {
      super(C0252.bootstrap<"get",38654705770>(), C0290.f_e2483c18, C0252.bootstrap<"get",38654705771>());
   }

   @EventHandler
   private void m_540fbcdc(EventUpdate var1) {
      MainEntityPlayer var2 = C0114.bootstrap<"call",0,1>()._getPlayer();
      Minecraft var3 = C0114.bootstrap<"call",0,1>();
      if (this.enabled && var2 != null && !var2.isCreative() && var2.getHealth() <= this.f_4d837b6d) {
         if (var3._isSinglePlayer() && !this.f_1edd2f0d) {
            return;
         }

         MinecraftScreen var4 = var3.getScreen();
         if (var4 != null && var4.getScreenType() == ScreenRegistry.Death) {
            return;
         }

         this.m_a8b7ec43();
      }
   }

   private void m_a8b7ec43() {
      if (this.f_f4f851f6) {
         this.setState(false);
      }

      C0400 var1 = (C0400)C0114.bootstrap<"call",0,1>(C0400.class);
      if (this.f_a5bf7a80 && var1.isEnabled()) {
         var1.setState(false);
      }

      C0114.bootstrap<"call",1,1>()
         .runOnRenderThread(
            () -> {
               C0114.bootstrap<"call",0,1>()._disconnect();
               if (C0213.f_57699eb8.m_093ae25a()) {
                  ScreenRegistry.Disconnected
                     .open(
                        new Object[]{
                           null,
                           C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",38654705772>()).style(C0114.bootstrap<"call",2,1>(DefaultColors.GRAY)),
                           C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",38654705773>()).style(C0114.bootstrap<"call",2,1>(DefaultColors.GRAY))
                        }
                     );
               } else {
                  ScreenRegistry.Multiplayer.open(new Object[]{(MinecraftScreen)null});
               }
            }
         );
   }

   protected void m_c010a4d7(String var1, String var2) {
      if (this.f_93f57e08) {
         this.m_a8b7ec43();
      }
   }
}
