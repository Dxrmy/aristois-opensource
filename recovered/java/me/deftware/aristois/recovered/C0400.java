package me.deftware.aristois.recovered;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventScreen;
import me.deftware.client.framework.event.events.EventScreen.Type;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.ServerDetails;

public class C0400 extends AbstractMod {
   private static final List<String> f_d1fcd44e = C0114.bootstrap<"call",0,1>(
      new String[]{C0252.bootstrap<"get",38654705722>(), C0252.bootstrap<"get",38654705723>()}
   );
   @C0098(
      value = "Reconnect delay",
      description = {"Delay before reconnecting"},
      number = @C0096(
         min = 1.0,
         max = 30.0
      )
   )
   private int f_551888f0 = 5;
   @C0098("Interval")
   private C0102<C0400.anonymousconst> f_7d898f69 = new C0102<>(C0400.anonymousconst.f_d448f8ba);
   private long f_ba4bb2f3;
   private long f_bed4798d;

   public C0400() {
      super(C0252.bootstrap<"get",38654705718>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705719>());
      this.setMode(this.f_7d898f69);
   }

   @EventHandler
   public void m_3d905365(EventScreen var1) {
      ServerDetails var2 = C0114.bootstrap<"call",0,1>().getLastConnectedServer();
      if (var1.getScreen().getScreenType() == ScreenRegistry.Disconnected && var2 != null) {
         if (var1.getType() == Type.Setup) {
            this.f_ba4bb2f3 = C0114.bootstrap<"call",1,1>();
            this.f_bed4798d = (long)this.f_551888f0 * this.f_7d898f69.m_e2691446().m_494f2eb5();
         } else if (var1.getType() == Type.PostDraw) {
            String var3 = var2._getAddress();
            Message var4 = C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",38654705720>() + var3);
            if (!f_d1fcd44e.contains(var3)) {
               long var5 = this.f_ba4bb2f3 + this.f_bed4798d - C0114.bootstrap<"call",1,1>();
               String var7 = this.f_7d898f69.m_e2691446().m_5a345418().apply(C0114.bootstrap<"call",3,1>(var5));
               if (this.f_ba4bb2f3 + this.f_bed4798d < C0114.bootstrap<"call",1,1>()) {
                  C0114.bootstrap<"call",4,1>(var2);
               }

               var4 = C0114.bootstrap<"call",2,1>(
                  C0114.bootstrap<"call",5,1>(C0252.bootstrap<"get",38654705721>(), new Object[]{var7, this.f_7d898f69.m_27694bb2().toLowerCase()})
               );
            }

            C0114.bootstrap<"call",7,1>(var4, C0114.bootstrap<"call",6,1>() / 2, 5, 16777215);
         }
      }
   }

   private static enum anonymousconst {
      f_d448f8ba(1000L, var0 -> C0114.bootstrap<"call",0,1>(TimeUnit.MILLISECONDS.toSeconds(var0))),
      f_1e3bbc1c(
         60000L,
         var0 -> C0114.bootstrap<"call",1,1>(
               C0252.bootstrap<"get",38654705717>(),
               new Object[]{
                  C0114.bootstrap<"call",0,1>(TimeUnit.MILLISECONDS.toMinutes(var0)), C0114.bootstrap<"call",0,1>(TimeUnit.MILLISECONDS.toSeconds(var0))
               }
            )
      );

      private final long f_920d5187;
      private final Function<Long, String> f_6dacda65;

      public long m_494f2eb5() {
         return this.f_920d5187;
      }

      public Function<Long, String> m_5a345418() {
         return this.f_6dacda65;
      }

      private anonymousconst(long var3, Function<Long, String> var5) {
         this.f_920d5187 = var3;
         this.f_6dacda65 = var5;
      }
   }
}
