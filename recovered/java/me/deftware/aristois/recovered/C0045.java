package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.Objects;
import me.deftware.aristois.main.Main;
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
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.minecraft.Minecraft;

public final class C0045 extends EventListener {
   public static final C0045 f_8f480fc4 = new C0045();
   private float f_05140345 = 0.0F;
   private float f_dc4d2046 = 0.006F;
   private Color f_dc4e3630 = Color.white;
   private long f_04bd724a = System.currentTimeMillis();
   private EventChatSend f_d32481ec;
   private long f_8c0dfc57 = 0L;

   public C0045() {
   }

   @EventHandler
   public void m_7161a1f8(EventChatSend var1) {
      this.f_d32481ec = var1;
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      this.f_05140345 = this.f_05140345 + this.f_dc4d2046;
      if (this.f_05140345 > 0.99F) {
         this.f_05140345 = 0.01F;
      }

      this.f_dc4e3630 = Color.getHSBColor(this.f_05140345 + 0.05F, 1.0F, 1.0F);
   }

   @EventHandler
   public void m_270a7d18(EventWorldLoad var1) {
      if (!Main.getConfig().hasKey(C0261.m_afb31f66())) {
         Main.getConfig().putPrimitive(C0261.m_afb31f66(), true);
         Message var2 = new Builder()
            .append(C0261.m_c254a253())
            .append(C0261.m_3d3a8736(), Appearance.of(DefaultColors.YELLOW))
            .append(C0261.m_94acbdac())
            .build();
         C0269.f_44d31626.m_dfae9307(new C0286(() -> Keyboard.isKeyDown(344), Message.of(C0261.m_022da1b4()), var2).m_6a1b300a());
      }
   }

   @EventHandler
   public void m_f84326ec(EventChatReceive var1) {
      for (C0250 var3 : C0250.m_a13a31bc()) {
         if (C0197.m_6bc011d7(var1.getMessage(), var3.m_3d3a8736())) {
            var1.setCanceled(true);
            break;
         }
      }
   }

   @EventHandler
   public void m_1e0a909c(EventKeyAction var1) {
      C0295 var2 = C0289.m_c3a8b502(C0295.class);
      if (var1.getKeyCode() == var2.getKeybind().m_36ffc578() && Minecraft.getMinecraftGame().getScreen() == null) {
         if (System.currentTimeMillis() - this.f_8c0dfc57 < 250L && var1.getAction() != 2) {
            Minecraft.getMinecraftGame().openScreen(new C0429());
         } else {
            this.f_8c0dfc57 = System.currentTimeMillis();
         }
      } else {
         C0289.f_85a7343f
            .m_918b7b9e()
            .forEach(
               var1x -> {
                  boolean var2x = Keyboard.isKeyDown(292) || Keyboard.isKeyDown(46);
                  if (var1x.getKeybind().m_36ffc578() == var1.getKeyCode()
                     && var1x.getKeybind().m_36ffc578() != -1
                     && !var2x
                     && (var1x.getKeybind().m_a135e825() == 0 || var1x.getKeybind().m_a135e825() == var1.getModifiers())) {
                     var1x.toggle();
                  }
               }
            );

         for (C0268 var4 : C0268.m_ea54feba()) {
            if (var4.m_79bbc2da() != -1 && var4.m_79bbc2da() == var1.getKeyCode() && (var4.m_037208cc() == -1 || var4.m_037208cc() == var1.getModifiers())) {
               var4.run();
            }
         }

         if (this.f_d32481ec != null && var1.getKeyCode() == 265 && !C0289.m_5caae0c3(C0431.class) && C0289.m_c3a8b502(C0296.class).m_6c9f39f9()) {
            String var5 = (this.f_d32481ec.getType() == Type.Command ? C0261.m_6e2d03c3() : "") + this.f_d32481ec.getMessage();
            Minecraft.getMinecraftGame().runOnRenderThread(() -> ScreenRegistry.Chat.open(new Object[]{var5}));
         }
      }
   }

   @EventHandler
   public void m_31ec7ab2(EventServerPinged var1) {
      if (!C0197.m_6bc011d7(var1.getPlayerList(), C0261.m_760db7bb())) {
         Message var2 = new Builder()
            .append(var1.getGameVersion(), Appearance.of(DefaultColors.AQUA))
            .append(C0261.m_68957b31(), Appearance.of(DefaultColors.GRAY))
            .append(var1.getPlayerList())
            .build();
         var1.setPlayerList(var2);
      }
   }

   @EventHandler
   public void m_cf449f57(EventGameOver var1) {
      if (this.f_04bd724a + 10000L < System.currentTimeMillis()) {
         this.f_04bd724a = System.currentTimeMillis();
         if (Objects.requireNonNull(C0289.m_c3a8b502(C0333.class)).m_e0f7c666()) {
            EntityPlayer var2 = Objects.requireNonNull(Minecraft.getMinecraftGame()._getPlayer());
            C0244 var3 = new C0244();
            var3.m_46938bdb((int)var2.getPosX());
            var3.m_7c7fe86a((int)var2.getPosY());
            var3.m_8b037516((int)var2.getPosZ());
            var3.m_d6ac7420(false);
            var3.m_0e76b397(Color.pink.getRGB());
            var3.m_256015fc(C0261.m_4e02e7a9());
            C0244.m_a492b2a7().add(var3);
            C0064.m_13c9ffeb().m_ecf8e7ae(C0261.m_7f74d855(), var2.getPosX(), var2.getPosY(), var2.getPosZ()).m_b728afce();
         }
      }
   }

   public float m_796256b9() {
      return this.f_05140345;
   }

   public void m_d881d3e3(float var1) {
      this.f_dc4d2046 = var1;
   }

   public float m_b7fbb877() {
      return this.f_dc4d2046;
   }

   public Color m_f6c8a26c() {
      return this.f_dc4e3630;
   }
}
