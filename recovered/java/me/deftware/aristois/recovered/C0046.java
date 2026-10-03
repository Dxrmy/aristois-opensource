package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import me.deftware.aristois.main.Main;
import me.deftware.client.framework.command.CommandRegister;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.EventListener;
import me.deftware.client.framework.event.events.EventScreen;
import me.deftware.client.framework.event.events.EventScreen.Type;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.gui.screens.ConnectingScreen;
import me.deftware.client.framework.gui.screens.MinecraftScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.gui.widgets.TextField;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.minecraft.ServerDetails;
import me.deftware.client.framework.network.PacketRegistry;
import me.deftware.client.framework.network.SocksProxy;

public final class C0046 extends EventListener implements Runnable {
   public static final C0046 f_3cccbdf2 = new C0046();

   public C0046() {
   }

   @EventHandler
   private void m_65c92cfe(EventScreen var1) {
      MinecraftScreen var2 = var1.getScreen();
      if (var2.getScreenType() != null) {
         if (var2.getScreenType() == ScreenRegistry.Chat && var1.getType() == Type.Tick) {
            this.m_175161c6(var2);
         } else if (var1.getType() == Type.Setup) {
            switch (var2.getScreenType()) {
               case Disconnected:
                  this.m_30f30b7c(var2);
                  break;
               case IngameMenu:
                  this.m_47619d64(var2);
                  break;
               case Multiplayer:
                  this.m_a5231e0c(var2);
                  break;
               case MainMenu:
                  if (C0289.m_c3a8b502(C0296.class).m_e0f7c666()) {
                     Minecraft.getMinecraftGame().openScreen(new C0193());
                  }
            }
         }
      }
   }

   private void m_a5231e0c(MinecraftScreen var1) {
      this.m_f118a79a(var1, 8, 8, 70);
   }

   private void m_175161c6(MinecraftScreen var1) {
      TextField var2 = (TextField)var1.getFirstOfType(TextField.class);
      if (var2 != null) {
         String var3 = Main.getConfig().getPrimitive(C0253.m_af41331f(), C0266.m_f599ae93());
         boolean var4 = var2._getText().isEmpty() && C0289.m_c3a8b502(C0296.class).m_78cbd705();
         var2._setOverlay(var4 ? var3 + C0261.m_cc27b633() + CommandRegister.getCommandTrigger() + C0261.m_df6e621c() : "");
      }
   }

   private void m_30f30b7c(MinecraftScreen var1) {
      int var2 = GuiScreen.getScaledHeight() - 50;
      final C0236 var3 = C0236.f_758a0b10;
      if (var3.m_efa7610e()) {
         var1.addScreenComponent(new C0154(GuiScreen.getScaledWidth() / 2 - 100, var2, 200, 20, Message.of(C0261.m_73708dd3())) {
            @Override
            public boolean m_1521b1fa(int var1) {
               this.m_b1b94a23().setComponentLabel(Message.of(C0261.m_b89b7876()));
               CompletableFuture.runAsync(() -> {
                  C0238 var2 = var3.m_702aae34();

                  try {
                     var2.m_f1ec3ae8();
                     ServerDetails var3x = Minecraft.getMinecraftGame().getLastConnectedServer();
                     if (var3x != null) {
                        Minecraft.getMinecraftGame().runOnRenderThread(() -> ConnectingScreen._connect(var3x));
                     }
                  } catch (Exception var4) {
                     var4.printStackTrace();
                     ((Button)this.m_b1b94a23().setComponentLabel(Message.of(C0261.m_a33fab52()))).resetToAfter(1500, Message.of(C0261.m_73708dd3()));
                  }
               });
               return true;
            }
         });
         var2 += 25;
      }

      this.m_f118a79a(var1, GuiScreen.getScaledWidth() / 2 - 100, var2, 200);
   }

   private void m_f118a79a(final MinecraftScreen var1, int var2, int var3, int var4) {
      if (C0213.f_c129c8d4.m_efa7610e()) {
         C0154 var5 = new C0154(var2, var3, var4, 20, Message.of(C0261.m_56242a84())) {
            @Override
            public boolean m_1521b1fa(int var1x) {
               if (Keyboard.isCtrlPressed()) {
                  PacketRegistry.INSTANCE.setProxy(null);
                  this.m_1058ed9a();
               } else {
                  C0143.m_a4e18580(var1);
               }

               return true;
            }

            @Override
            public void m_1058ed9a() {
               this.m_b1b94a23().setComponentLabel(Message.of(C0261.m_96ba50d4()));
               ArrayList var1x = new ArrayList<>(
                  Arrays.asList(Message.of(C0261.m_88726494()), Message.of(String.format(C0261.m_27479cfa(), C0143.m_39057c01().size())))
               );
               SocksProxy var2 = PacketRegistry.INSTANCE.getProxy();
               if (var2 != null) {
                  var1x.addAll(Arrays.asList(C0197.f_9607505d, Message.of(C0261.m_23f794da()), Message.of(var2.getAddress())));
               }

               this.m_b1b94a23()._setTooltip(var1x.toArray(new Message[0]));
            }
         };
         var5.m_1058ed9a();
         var1.addScreenComponent(var5);
      }
   }

   private void m_47619d64(final MinecraftScreen var1) {
      if (C0289.m_c3a8b502(C0296.class).m_275ab222()) {
         var1.addScreenComponent(
            new C0154(GuiScreen.getScaledWidth() / 2 - 102, GuiScreen.getScaledHeight() / 4 + 152, 98, 20, Message.of(C0261.m_9e27f038())) {
               @Override
               public boolean m_1521b1fa(int var1x) {
                  Minecraft.getMinecraftGame().openScreen(new C0177(var1));
                  return true;
               }
            }
         );
      }

      if (C0289.m_c3a8b502(C0296.class).m_f21a055b()) {
         var1.addScreenComponent(new C0154(GuiScreen.getScaledWidth() / 2 + 4, GuiScreen.getScaledHeight() / 4 + 152, 98, 20, Message.of(C0261.m_af41331f())) {
            @Override
            public boolean m_1521b1fa(int var1) {
               C0149.f_9e30b55f.m_1058ed9a();
               return true;
            }
         });
      }
   }

   @Override
   public void run() {
      System.out.println(C0261.m_f257bcca());
   }
}
