package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.EventListener;
import me.deftware.client.framework.event.events.EventChatReceive;
import me.deftware.client.framework.event.events.EventChatSend;
import me.deftware.client.framework.event.events.EventGameOver;
import me.deftware.client.framework.event.events.EventKeyAction;
import me.deftware.client.framework.event.events.EventServerPinged;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.event.events.EventWorldLoad;
import me.deftware.client.framework.event.events.EventChatSend.Type;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;

public final class C0045 extends EventListener {
   public static final C0045 f_d228694b = new C0045();
   private float f_399d67ca = 0.0F;
   private float f_cbcdef73 = 0.006F;
   private Color f_73e59e41 = Color.white;
   private long f_c49f2e5c = C0114.bootstrap<"call",0,1>();
   private EventChatSend f_6df59d2c;
   private long f_a0552e0e = 0L;

   public C0045() {
   }

   @EventHandler
   public void m_678df3fd(EventChatSend var1) {
      this.f_6df59d2c = var1;
   }

   @EventHandler
   public void m_01bd30f4(EventUpdate var1) {
      this.f_399d67ca = this.f_399d67ca + this.f_cbcdef73;
      if (this.f_399d67ca > 0.99F) {
         this.f_399d67ca = 0.01F;
      }

      this.f_73e59e41 = C0114.bootstrap<"call",0,1>(this.f_399d67ca + 0.05F, 1.0F, 1.0F);
   }

   @EventHandler
   public void m_4b1c87f9(EventWorldLoad var1) {
      if (!C0114.bootstrap<"call",1,1>().hasKey(C0252.bootstrap<"get",17179869223>())) {
         C0114.bootstrap<"call",1,1>().putPrimitive(C0252.bootstrap<"get",17179869223>(), true);
         Message var2 = new Builder()
            .append(C0252.bootstrap<"get",17179869224>())
            .append(C0252.bootstrap<"get",17179869225>(), C0114.bootstrap<"call",2,1>(DefaultColors.YELLOW))
            .append(C0252.bootstrap<"get",17179869226>())
            .build();
         C0269.f_13431579
            .m_71701f32(
               new C0286(
                     () -> C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(344)),
                     C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",17179869227>()),
                     var2
                  )
                  .m_b7d0bc68()
            );
      }
   }

   @EventHandler
   public void m_216f4e48(EventChatReceive var1) {
      for (C0250 var3 : C0114.bootstrap<"call",4,1>()) {
         if (C0114.bootstrap<"call",5,1>(var1.getMessage(), var3.m_84e98a9f())) {
            var1.setCanceled(true);
            break;
         }
      }
   }

   @EventHandler
   public void m_48df7a9e(EventKeyAction var1) {
      C0295 var2 = (C0295)C0114.bootstrap<"call",6,1>(C0295.class);
      if (var1.getKeyCode() == var2.getKeybind().m_6978c604() && C0114.bootstrap<"call",7,1>().getScreen() == null) {
         if (C0114.bootstrap<"call",8,1>() - this.f_a0552e0e < 250L && var1.getAction() != 2) {
            C0114.bootstrap<"call",7,1>().openScreen(new C0429());
         } else {
            this.f_a0552e0e = C0114.bootstrap<"call",8,1>();
         }
      } else {
         C0289.f_c22b8d7e
            .m_ea73e1f0()
            .forEach(
               var1x -> {
                  boolean var2x = C0114.bootstrap<"call",15,1>(292) || C0114.bootstrap<"call",15,1>(46);
                  if (var1x.getKeybind().m_6978c604() == var1.getKeyCode()
                     && var1x.getKeybind().m_6978c604() != -1
                     && !var2x
                     && (var1x.getKeybind().m_0c53f85c() == 0 || var1x.getKeybind().m_0c53f85c() == var1.getModifiers())) {
                     var1x.toggle();
                  }
               }
            );

         for (C0268 var4 : C0114.bootstrap<"call",9,1>()) {
            if (var4.m_9d73c835() != -1 && var4.m_9d73c835() == var1.getKeyCode() && (var4.m_1921cf88() == -1 || var4.m_1921cf88() == var1.getModifiers())) {
               var4.run();
            }
         }

         if (this.f_6df59d2c != null
            && var1.getKeyCode() == 265
            && !C0114.bootstrap<"call",10,1>(C0431.class)
            && ((C0296)C0114.bootstrap<"call",6,1>(C0296.class)).m_45e0418b()) {
            String var5 = (this.f_6df59d2c.getType() == Type.Command ? C0252.bootstrap<"get",17179869228>() : "") + this.f_6df59d2c.getMessage();
            C0114.bootstrap<"call",7,1>().runOnRenderThread(() -> ScreenRegistry.Chat.open(new Object[]{var5}));
         }
      }
   }

   @EventHandler
   public void m_d2b81718(EventServerPinged var1) {
      if (!C0114.bootstrap<"call",5,1>(var1.getPlayerList(), C0252.bootstrap<"get",17179869229>())) {
         Message var2 = new Builder()
            .append(var1.getGameVersion(), C0114.bootstrap<"call",2,1>(DefaultColors.AQUA))
            .append(C0252.bootstrap<"get",17179869230>(), C0114.bootstrap<"call",2,1>(DefaultColors.GRAY))
            .append(var1.getPlayerList())
            .build();
         var1.setPlayerList(var2);
      }
   }

   @EventHandler
   public void m_f99e303a(EventGameOver var1) {
      if (this.f_c49f2e5c + 10000L < C0114.bootstrap<"call",8,1>()) {
         this.f_c49f2e5c = C0114.bootstrap<"call",8,1>();
         if (((C0333)C0114.bootstrap<"call",11,1>(C0114.bootstrap<"call",6,1>(C0333.class))).m_398ba9a1()) {
            EntityPlayer var2 = (EntityPlayer)C0114.bootstrap<"call",11,1>(C0114.bootstrap<"call",7,1>()._getPlayer());
            C0244 var3 = new C0244();
            var3.m_5e296171((int)var2.getPosX());
            var3.m_989d0d43((int)var2.getPosY());
            var3.m_0faa1ebc((int)var2.getPosZ());
            var3.m_9d941243(false);
            var3.m_9bee8302(Color.pink.getRGB());
            var3.m_efd8b5f8(C0252.bootstrap<"get",17179869231>());
            C0114.bootstrap<"call",12,1>().add(var3);
            C0114.bootstrap<"call",13,1>()
               .m_5de8d0b8(
                  C0252.bootstrap<"get",17179869232>(),
                  C0114.bootstrap<"call",14,1>(var2.getPosX()),
                  C0114.bootstrap<"call",14,1>(var2.getPosY()),
                  C0114.bootstrap<"call",14,1>(var2.getPosZ())
               )
               .m_9d59fbe9();
         }
      }
   }

   public float m_8db20abd() {
      return this.f_399d67ca;
   }

   public void m_d87ed5e1(float var1) {
      this.f_cbcdef73 = var1;
   }

   public float m_03682d2e() {
      return this.f_cbcdef73;
   }

   public Color m_86ca0a09() {
      return this.f_73e59e41;
   }
}
