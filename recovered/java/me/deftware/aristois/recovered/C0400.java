package me.deftware.aristois.recovered;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventScreen;
import me.deftware.client.framework.event.events.EventScreen.Type;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.gui.screens.ConnectingScreen;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.minecraft.ServerDetails;

public class C0400 extends AbstractMod {
   private static final List<String> f_f50fb57c = Arrays.asList(C0263.m_56242a84(), C0263.m_9e27f038());
   @C0098(
      value = "Reconnect delay",
      description = {"Delay before reconnecting"},
      number = @C0096(
         min = 1.0,
         max = 30.0
      )
   )
   private int f_976777ff = 5;
   @C0098("Interval")
   private C0102<C0400.anonymousconst> f_0c09a3e7 = new C0102<>(C0400.anonymousconst.f_ff61375b);
   private long f_db249e18;
   private long f_be7e1502;

   public C0400() {
      super(C0263.m_27479cfa(), C0290.f_dbc16475, C0263.m_23f794da());
      this.setMode(this.f_0c09a3e7);
   }

   @EventHandler
   public void m_65c92cfe(EventScreen var1) {
      ServerDetails var2 = Minecraft.getMinecraftGame().getLastConnectedServer();
      if (var1.getScreen().getScreenType() == ScreenRegistry.Disconnected && var2 != null) {
         if (var1.getType() == Type.Setup) {
            this.f_db249e18 = System.currentTimeMillis();
            this.f_be7e1502 = (long)this.f_976777ff * this.f_0c09a3e7.m_284992ec().m_7054c744();
         } else if (var1.getType() == Type.PostDraw) {
            String var3 = var2._getAddress();
            Message var4 = Message.of(C0263.m_cc27b633() + var3);
            if (!f_f50fb57c.contains(var3)) {
               long var5 = this.f_db249e18 + this.f_be7e1502 - System.currentTimeMillis();
               String var7 = this.f_0c09a3e7.m_284992ec().m_52d0c4d8().apply(var5);
               if (this.f_db249e18 + this.f_be7e1502 < System.currentTimeMillis()) {
                  ConnectingScreen._connect(var2);
               }

               var4 = Message.of(String.format(C0263.m_df6e621c(), var7, this.f_0c09a3e7.m_d32ebe65().toLowerCase()));
            }

            FontRenderer.drawCenteredString(var4, GuiScreen.getScaledWidth() / 2, 5, 16777215);
         }
      }
   }

   private static enum anonymousconst {
      f_ff61375b(1000L, var0 -> String.valueOf(TimeUnit.MILLISECONDS.toSeconds(var0))),
      f_f43c1353(60000L, var0 -> String.format(C0263.m_88726494(), TimeUnit.MILLISECONDS.toMinutes(var0), TimeUnit.MILLISECONDS.toSeconds(var0)));

      private final long f_06427409;
      private final Function<Long, String> f_1c14f26b;

      public long m_7054c744() {
         return this.f_06427409;
      }

      public Function<Long, String> m_52d0c4d8() {
         return this.f_1c14f26b;
      }

      private anonymousconst(long var3, Function<Long, String> var5) {
         this.f_06427409 = var3;
         this.f_1c14f26b = var5;
      }
   }
}
