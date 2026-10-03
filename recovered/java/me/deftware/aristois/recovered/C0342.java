package me.deftware.aristois.recovered;

import java.util.List;
import java.util.function.BiFunction;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.network.NetworkHandler;
import me.deftware.client.framework.world.player.PlayerEntry;

public class C0342 extends AbstractMod {
   private final C0219<C0246> f_418ddf86;
   @C0098(
      value = "Matched Tags",
      description = {"Tags to detect, using RegExp"}
   )
   private final GuiScreen f_9dc639d8;
   @C0098(
      value = "Mode",
      description = {"Which type of comparison to use for prefixes"}
   )
   private C0102<C0342.anonymousconst> f_3ba06e56 = new C0102<>(C0342.anonymousconst.f_7ae24fa3);
   private int f_e6239d2e = 0;

   public C0342() {
      this(C0252.bootstrap<"get",47244640319>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640320>());
      this.setMode(this.f_3ba06e56);
   }

   public C0342(String var1, C0290 var2, String var3) {
      super(var1, var2, var3);
      this.f_418ddf86 = new C0219<>(C0246.class, this.getModID() + C0252.bootstrap<"get",47244640321>());
      this.f_9dc639d8 = new C0174<>(null, this.f_418ddf86, C0252.bootstrap<"get",47244640322>());
   }

   @EventHandler
   private void m_d838d3ae(EventUpdate var1) {
      NetworkHandler var2 = C0114.bootstrap<"call",0,1>();
      if (var2 != null) {
         List var3 = var2._getPlayerList();
         BiFunction var4 = this.f_3ba06e56.m_e2691446().m_b9c783c1();
         if (this.f_e6239d2e != var3.size()) {
            for (PlayerEntry var6 : var3) {
               String var7 = var6._getName();
               if (var6._getDisplayName() != null) {
                  var7 = var6._getDisplayName().string();
               }

               for (C0246 var9 : this.f_418ddf86) {
                  String var10 = var9.m_4dd2758c();
                  if ((Boolean)var4.apply(var7, var10)) {
                     this.m_278b2b5e(var7, var10);
                  }
               }
            }

            this.f_e6239d2e = var3.size();
         }
      }
   }

   protected void m_278b2b5e(String var1, String var2) {
      C0114.bootstrap<"call",1,1>()
         .m_6b4e8235(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",47244640323>(), new Object[]{var2}))
         .m_5de8d0b8(C0252.bootstrap<"get",47244640324>(), var1)
         .m_66e721c0();
   }

   public static enum anonymousconst {
      f_be1971b4((var0, var1) -> C0114.bootstrap<"call",0,1>(var0.matches(var1))),
      f_7ae24fa3((var0, var1) -> C0114.bootstrap<"call",0,1>(var0.toLowerCase().contains(var1)));

      private final BiFunction<String, String, Boolean> f_f6dd9d9d;

      public BiFunction<String, String, Boolean> m_b9c783c1() {
         return this.f_f6dd9d9d;
      }

      private anonymousconst(BiFunction<String, String, Boolean> var3) {
         this.f_f6dd9d9d = var3;
      }
   }
}
