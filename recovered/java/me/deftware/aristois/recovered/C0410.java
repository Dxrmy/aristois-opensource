package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventMouseClick;
import me.deftware.client.framework.event.events.EventSound;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.event.events.EventWorldLoad;
import me.deftware.client.framework.gui.screens.ContainerScreen;
import org.apache.logging.log4j.Logger;

public class C0410 extends AbstractMod {
   @C0098(
      value = "Auto replace",
      description = {"Automatically replace a broken fishing rod with a new from your inventory"}
   )
   private boolean f_e48d836e = true;
   @C0098(
      value = "Auto cast",
      description = {"Automatically throw your fishing hook into water"}
   )
   private boolean f_c28a8ef1 = true;
   @C0098(
      value = "Catch delay.",
      description = {"The delay before reeling back the fish after getting one in ticks"},
      number = @C0096(
         max = 60.0
      )
   )
   private int f_bffe9951 = 6;
   @C0098(
      value = "Splash range",
      description = {"The range to detect splashes"}
   )
   private float f_277a1342 = 10.0F;
   private long f_7f122a21 = C0114.bootstrap<"call",0,1>();
   private boolean f_443c58c2 = false;
   private boolean f_92d6d1b2 = false;
   private int f_60425047 = 0;
   private Logger f_9cc83eff = C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",38654705695>());
   private final C0072 f_f084bf4f = C0114.bootstrap<"call",2,1>(C0070.f_a317a8b8);

   public C0410() {
      super(C0252.bootstrap<"get",38654705695>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705696>());
   }

   @Override
   public void onEnable() {
      this.f_92d6d1b2 = false;
      if (C0114.bootstrap<"call",0,1>() != null) {
         if (C0114.bootstrap<"call",1,1>(C0370.class)) {
            C0114.bootstrap<"call",2,1>().m_77a7bc18(C0252.bootstrap<"get",38654705697>()).m_66e721c0();
         }

         if (!C0114.bootstrap<"call",3,1>()) {
            C0114.bootstrap<"call",2,1>().m_77a7bc18(C0252.bootstrap<"get",38654705698>()).m_66e721c0();
         } else {
            this.f_92d6d1b2 = true;
         }
      }
   }

   @Override
   public void onDisable() {
      this.f_443c58c2 = false;
      this.f_60425047 = 0;
   }

   @EventHandler
   private void m_a86abb47(EventWorldLoad var1) {
      this.onDisable();
   }

   @EventHandler
   private void m_cd0b24eb(EventSound var1) {
      if (C0114.bootstrap<"call",0,1>() != null) {
         MainEntityPlayer var2 = C0114.bootstrap<"call",1,1>()._getPlayer();
         if (C0114.bootstrap<"call",2,1>()
            && var1.getSoundId().contains(C0252.bootstrap<"get",38654705699>())
            && C0114.bootstrap<"call",3,1>().distanceToEntity(var2) < this.f_277a1342) {
            this.f_443c58c2 = true;
         }
      }
   }

   @EventHandler
   private void m_b5968849(EventMouseClick var1) {
      if (C0114.bootstrap<"call",0,1>() != null
         && C0114.bootstrap<"call",1,1>().getScreen() == null
         && var1.getButton() == 1
         && var1.getAction() == 0
         && C0114.bootstrap<"call",4,1>(C0070.f_a317a8b8)) {
         this.m_a169956f(!this.f_92d6d1b2);
         this.f_7f122a21 = C0114.bootstrap<"call",5,1>();
      }
   }

   private void m_a169956f(boolean var1) {
      this.f_92d6d1b2 = var1;
      C0114.bootstrap<"call",0,1>()
         .m_5de8d0b8(C0252.bootstrap<"get",38654705700>(), this.f_92d6d1b2 ? C0252.bootstrap<"get",38654705701>() : C0252.bootstrap<"get",38654705702>())
         .m_66e721c0();
   }

   @EventHandler
   public void m_7af31f66(EventUpdate var1) {
      if (this.f_92d6d1b2) {
         if (this.f_443c58c2) {
            if (this.f_60425047++ < this.f_bffe9951) {
               return;
            }

            this.onDisable();
            this.f_7f122a21 = C0114.bootstrap<"call",5,1>();
            C0114.bootstrap<"call",6,1>(1);
         }

         if (!C0114.bootstrap<"call",4,1>(C0070.f_a317a8b8) && !(C0114.bootstrap<"call",1,1>().getScreen() instanceof ContainerScreen)) {
            this.f_9cc83eff.info(C0252.bootstrap<"get",38654705703>());
            int var2 = this.f_f084bf4f.m_a0aa8556();
            if (!this.f_e48d836e || var2 == -1) {
               this.f_9cc83eff.info(C0252.bootstrap<"get",38654705704>());
               this.m_a169956f(false);
               return;
            }

            if (!C0114.bootstrap<"call",7,1>(var2)) {
               var2 = ((C0073.anonymousdefault)((C0073.anonymousdefault)((C0073.anonymousdefault)C0114.bootstrap<"call",8,1>().m_44d897bb(var2)).m_6a6e19f6())
                     .m_08fa2bad())
                  .m_514a3e72();
            }

            ((C0073.anonymousboolean)C0114.bootstrap<"call",9,1>().m_b5be4463(var2)).m_eebb0db7();
         }

         if (this.f_7f122a21 + 1000L < C0114.bootstrap<"call",5,1>()
            && C0114.bootstrap<"call",4,1>(C0070.f_a317a8b8)
            && !C0114.bootstrap<"call",2,1>()
            && this.f_c28a8ef1) {
            this.f_7f122a21 = C0114.bootstrap<"call",5,1>();
            C0114.bootstrap<"call",6,1>(1);
         }
      }
   }
}
