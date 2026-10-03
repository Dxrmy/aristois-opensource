package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.entity.types.objects.EntityFishHook;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventMouseClick;
import me.deftware.client.framework.event.events.EventSound;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.event.events.EventWorldLoad;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import me.deftware.client.framework.input.Mouse;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.world.ClientWorld;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class C0410 extends AbstractMod {
   @C0098(
      value = "Auto replace",
      description = {"Automatically replace a broken fishing rod with a new from your inventory"}
   )
   private boolean f_82f01c8e = true;
   @C0098(
      value = "Auto cast",
      description = {"Automatically throw your fishing hook into water"}
   )
   private boolean f_142cd2f3 = true;
   @C0098(
      value = "Catch delay.",
      description = {"The delay before reeling back the fish after getting one in ticks"},
      number = @C0096(
         max = 60.0
      )
   )
   private int f_94090410 = 6;
   @C0098(
      value = "Splash range",
      description = {"The range to detect splashes"}
   )
   private float f_5de2ad9e = 10.0F;
   private long f_ef23f99e = System.currentTimeMillis();
   private boolean f_3f2e8b8b = false;
   private boolean f_f5a289c3 = false;
   private int f_99b72ba4 = 0;
   private Logger f_769b8422 = LogManager.getLogger(C0263.m_45aaaba8());
   private final C0072 f_6cd28d88 = C0072.m_17e298ea(C0070.f_a7890e4c);

   public C0410() {
      super(C0263.m_45aaaba8(), C0290.f_dbc16475, C0263.m_88937f2b());
   }

   @Override
   public void onEnable() {
      this.f_f5a289c3 = false;
      if (ClientWorld.getClientWorld() != null) {
         if (C0289.m_5caae0c3(C0370.class)) {
            C0064.m_13c9ffeb().m_ee04ba1b(C0263.m_396f9431()).m_1058ed9a();
         }

         if (!EntityFishHook.hasFish()) {
            C0064.m_13c9ffeb().m_ee04ba1b(C0263.m_e9914bd3()).m_1058ed9a();
         } else {
            this.f_f5a289c3 = true;
         }
      }
   }

   @Override
   public void onDisable() {
      this.f_3f2e8b8b = false;
      this.f_99b72ba4 = 0;
   }

   @EventHandler
   private void m_270a7d18(EventWorldLoad var1) {
      this.onDisable();
   }

   @EventHandler
   private void m_c56e628f(EventSound var1) {
      if (ClientWorld.getClientWorld() != null) {
         MainEntityPlayer var2 = Minecraft.getMinecraftGame()._getPlayer();
         if (EntityFishHook.hasFish()
            && var1.getSoundId().contains(C0263.m_8631f87f())
            && EntityFishHook.getInstance().distanceToEntity(var2) < this.f_5de2ad9e) {
            this.f_3f2e8b8b = true;
         }
      }
   }

   @EventHandler
   private void m_992be57a(EventMouseClick var1) {
      if (ClientWorld.getClientWorld() != null
         && Minecraft.getMinecraftGame().getScreen() == null
         && var1.getButton() == 1
         && var1.getAction() == 0
         && C0073.m_d3d286e7(C0070.f_a7890e4c)) {
         this.m_35150f14(!this.f_f5a289c3);
         this.f_ef23f99e = System.currentTimeMillis();
      }
   }

   private void m_35150f14(boolean var1) {
      this.f_f5a289c3 = var1;
      C0064.m_13c9ffeb().m_ecf8e7ae(C0263.m_818e6498(), this.f_f5a289c3 ? C0263.m_56d4c1c7() : C0263.m_d32ebe65()).m_1058ed9a();
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      if (this.f_f5a289c3) {
         if (this.f_3f2e8b8b) {
            if (this.f_99b72ba4++ < this.f_94090410) {
               return;
            }

            this.onDisable();
            this.f_ef23f99e = System.currentTimeMillis();
            Mouse.clickMouse(1);
         }

         if (!C0073.m_d3d286e7(C0070.f_a7890e4c) && !(Minecraft.getMinecraftGame().getScreen() instanceof ContainerScreen)) {
            this.f_769b8422.info(C0263.m_afb31f66());
            int var2 = this.f_6cd28d88.m_eb304949();
            if (!this.f_82f01c8e || var2 == -1) {
               this.f_769b8422.info(C0263.m_c254a253());
               this.m_35150f14(false);
               return;
            }

            if (!C0073.m_aa45d95d(var2)) {
               var2 = C0073.m_f76a4979().m_e1463257(var2).m_b252dc95().m_ac6eac3b().m_eb304949();
            }

            C0073.m_72cafc8a().m_7c42e94f(var2).m_ac6eac3b();
         }

         if (this.f_ef23f99e + 1000L < System.currentTimeMillis() && C0073.m_d3d286e7(C0070.f_a7890e4c) && !EntityFishHook.hasFish() && this.f_142cd2f3) {
            this.f_ef23f99e = System.currentTimeMillis();
            Mouse.clickMouse(1);
         }
      }
   }
}
