package me.deftware.aristois.recovered;

import java.util.ArrayList;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.EventListener;
import me.deftware.client.framework.event.events.EventScreen;
import me.deftware.client.framework.event.events.EventScreen.Type;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.gui.screens.MinecraftScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.gui.widgets.TextField;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.ServerDetails;
import me.deftware.client.framework.network.PacketRegistry;
import me.deftware.client.framework.network.SocksProxy;

public final class C0046 extends EventListener implements Runnable {
   public static final C0046 f_33e1045e = new C0046();

   public C0046() {
   }

   @EventHandler
   private void m_34ab7acc(EventScreen var1) {
      MinecraftScreen var2 = var1.getScreen();
      if (var2.getScreenType() != null) {
         if (var2.getScreenType() == ScreenRegistry.Chat && var1.getType() == Type.Tick) {
            this.m_380f2924(var2);
         } else if (var1.getType() == Type.Setup) {
            switch (var2.getScreenType()) {
               case Disconnected:
                  this.m_6cd82145(var2);
                  break;
               case IngameMenu:
                  this.m_15d6192d(var2);
                  break;
               case Multiplayer:
                  this.m_5a7d0af3(var2);
                  break;
               case MainMenu:
                  if (((C0296)C0114.bootstrap<"call",0,1>(C0296.class)).m_859a7265()) {
                     C0114.bootstrap<"call",1,1>().openScreen(new C0193());
                  }
            }
         }
      }
   }

   private void m_5a7d0af3(MinecraftScreen var1) {
      this.m_93e01370(var1, 8, 8, 70);
   }

   private void m_380f2924(MinecraftScreen var1) {
      TextField var2 = (TextField)var1.getFirstOfType(TextField.class);
      if (var2 != null) {
         String var3 = C0114.bootstrap<"call",0,1>().getPrimitive(C0252.bootstrap<"get",8589934652>(), C0252.bootstrap<"get",12884902008>());
         boolean var4 = var2._getText().isEmpty() && ((C0296)C0114.bootstrap<"call",1,1>(C0296.class)).m_a818a537();
         var2._setOverlay(var4 ? var3 + C0252.bootstrap<"get",17179869240>() + C0114.bootstrap<"call",2,1>() + C0252.bootstrap<"get",17179869241>() : "");
      }
   }

   private void m_6cd82145(MinecraftScreen var1) {
      int var2 = C0114.bootstrap<"call",0,1>() - 50;
      final C0236 var3 = C0236.f_8b0448cf;
      if (var3.m_af69325d()) {
         var1.addScreenComponent(
            new C0154(C0114.bootstrap<"call",1,1>() / 2 - 100, var2, 200, 20, C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",17179869235>())) {
               public boolean m_cbf4341a(int var1) {
                  this.m_5d4ce26e().setComponentLabel(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869233>()));
                  C0114.bootstrap<"call",1,1>(
                     () -> {
                        C0238 var2 = var3.m_d92a89b2();

                        try {
                           var2.m_2ca21399();
                           ServerDetails var3x = C0114.bootstrap<"call",2,1>().getLastConnectedServer();
                           if (var3x != null) {
                              C0114.bootstrap<"call",2,1>().runOnRenderThread(() -> C0114.bootstrap<"call",3,1>(var3x));
                           }
                        } catch (Exception var4) {
                           var4.printStackTrace();
                           ((Button)this.m_5d4ce26e().setComponentLabel(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869234>())))
                              .resetToAfter(1500, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869235>()));
                        }
                     }
                  );
                  return true;
               }
            }
         );
         var2 += 25;
      }

      this.m_93e01370(var1, C0114.bootstrap<"call",1,1>() / 2 - 100, var2, 200);
   }

   private void m_93e01370(final MinecraftScreen var1, int var2, int var3, int var4) {
      if (C0213.f_9a8bd5d6.m_093ae25a()) {
         C0154 var5 = new C0154(var2, var3, var4, 20, C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",17179869242>())) {
            public boolean m_ec495ec6(int var1x) {
               if (C0114.bootstrap<"call",0,1>()) {
                  PacketRegistry.INSTANCE.setProxy(null);
                  this.m_4bc31980();
               } else {
                  C0114.bootstrap<"call",1,1>(var1);
               }

               return true;
            }

            public void m_4bc31980() {
               this.m_7b8b0488().setComponentLabel(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",17179869236>()));
               ArrayList var1x = new ArrayList(
                  C0114.bootstrap<"call",6,1>(
                     new Message[]{
                        C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",17179869237>()),
                        C0114.bootstrap<"call",2,1>(
                           C0114.bootstrap<"call",5,1>(
                              C0252.bootstrap<"get",17179869238>(), new Object[]{C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>().size())}
                           )
                        )
                     }
                  )
               );
               SocksProxy var2 = PacketRegistry.INSTANCE.getProxy();
               if (var2 != null) {
                  var1x.addAll(
                     C0114.bootstrap<"call",6,1>(
                        new Message[]{
                           C0197.f_716a73fa, C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",17179869239>()), C0114.bootstrap<"call",2,1>(var2.getAddress())
                        }
                     )
                  );
               }

               this.m_7b8b0488()._setTooltip(var1x.toArray(new Message[0]));
            }
         };
         var5.m_a980318c();
         var1.addScreenComponent(var5);
      }
   }

   private void m_15d6192d(final MinecraftScreen var1) {
      if (((C0296)C0114.bootstrap<"call",0,1>(C0296.class)).m_2b3e6d6e()) {
         var1.addScreenComponent(
            new C0154(
               C0114.bootstrap<"call",1,1>() / 2 - 102,
               C0114.bootstrap<"call",2,1>() / 4 + 152,
               98,
               20,
               C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",17179869243>())
            ) {
               public boolean m_e4469428(int var1x) {
                  C0114.bootstrap<"call",0,1>().openScreen(new C0177(var1));
                  return true;
               }
            }
         );
      }

      if (((C0296)C0114.bootstrap<"call",0,1>(C0296.class)).m_4bd179de()) {
         var1.addScreenComponent(
            new C0154(
               C0114.bootstrap<"call",1,1>() / 2 + 4,
               C0114.bootstrap<"call",2,1>() / 4 + 152,
               98,
               20,
               C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",17179869244>())
            ) {
               public boolean m_eedf6dc2(int var1) {
                  C0149.f_27db095d.m_48c6b1ee();
                  return true;
               }
            }
         );
      }
   }

   @Override
   public void run() {
      System.out.println(C0252.bootstrap<"get",17179869245>());
   }
}
