package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.gui.screens.MinecraftScreen;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.world.ClientWorld;

public class C0304 extends C0342 {
   @C0098(
      value = "Health trigger",
      description = {"At what health to trigger at"}
   )
   private float f_27f95854 = 8.0F;
   @C0098(
      value = "Tags",
      description = {"Automatically disconnect when a", "matched prefix user joins the server"}
   )
   private boolean f_c771d0ec = false;
   @C0098(
      value = "AutoDisable",
      description = {"Disable AutoDisconnect when disconnecting"}
   )
   private boolean f_9bb2faa9 = true;
   @C0098(
      value = "Singleplayer",
      description = {"Allow AutoDisconnect in singleplayer"}
   )
   private boolean f_3ff60655 = false;
   @C0098(
      value = "Disable AutoReconnect",
      description = {"Automatically disables AutoReconnect"}
   )
   private boolean f_e06331a2 = true;

   public C0304() {
      super(C0263.m_678c4ddb(), C0290.f_4b7b2d37, C0263.m_1672ac4d());
   }

   @EventHandler
   private void m_3072cba8(EventUpdate var1) {
      MainEntityPlayer var2 = Minecraft.getMinecraftGame()._getPlayer();
      Minecraft var3 = Minecraft.getMinecraftGame();
      if (this.enabled && var2 != null && !var2.isCreative() && var2.getHealth() <= this.f_27f95854) {
         if (var3._isSinglePlayer() && !this.f_3ff60655) {
            return;
         }

         MinecraftScreen var4 = var3.getScreen();
         if (var4 != null && var4.getScreenType() == ScreenRegistry.Death) {
            return;
         }

         this.m_23674f64();
      }
   }

   private void m_23674f64() {
      if (this.f_9bb2faa9) {
         this.setState(false);
      }

      C0400 var1 = C0289.m_c3a8b502(C0400.class);
      if (this.f_e06331a2 && var1.isEnabled()) {
         var1.setState(false);
      }

      Minecraft.getMinecraftGame()
         .runOnRenderThread(
            () -> {
               ClientWorld.getClientWorld()._disconnect();
               if (C0213.f_17e12451.m_efa7610e()) {
                  ScreenRegistry.Disconnected
                     .open(
                        new Object[]{
                           null,
                           Message.of(C0263.m_e9a52709()).style(Appearance.of(DefaultColors.GRAY)),
                           Message.of(C0263.m_37c08c9d()).style(Appearance.of(DefaultColors.GRAY))
                        }
                     );
               } else {
                  ScreenRegistry.Multiplayer.open(new Object[]{(MinecraftScreen)null});
               }
            }
         );
   }

   @Override
   protected void m_e5f08f7c(String var1, String var2) {
      if (this.f_c771d0ec) {
         this.m_23674f64();
      }
   }
}
