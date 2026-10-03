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
   private final C0219<C0246> f_e4fb2cbb;
   @C0098(
      value = "Matched Tags",
      description = {"Tags to detect, using RegExp"}
   )
   private final GuiScreen f_c9008739;
   @C0098(
      value = "Mode",
      description = {"Which type of comparison to use for prefixes"}
   )
   private C0102<C0342.anonymousconst> f_b1fdd7e3 = new C0102<>(C0342.anonymousconst.f_1144a7da);
   private int f_bdf5b17c = 0;

   public C0342() {
      this(C0260.m_15737526(), C0290.f_99d080af, C0260.m_6cf615ba());
      this.setMode(this.f_b1fdd7e3);
   }

   public C0342(String var1, C0290 var2, String var3) {
      super(var1, var2, var3);
      this.f_e4fb2cbb = new C0219<>(C0246.class, this.getModID() + C0260.m_ecb46027());
      this.f_c9008739 = new C0174<>(null, this.f_e4fb2cbb, C0260.m_b526dd3b());
   }

   @EventHandler
   private void m_3072cba8(EventUpdate var1) {
      NetworkHandler var2 = NetworkHandler.getNetworkHandler();
      if (var2 != null) {
         List var3 = var2._getPlayerList();
         BiFunction var4 = this.f_b1fdd7e3.m_284992ec().m_33a967cc();
         if (this.f_bdf5b17c != var3.size()) {
            for (PlayerEntry var6 : var3) {
               String var7 = var6._getName();
               if (var6._getDisplayName() != null) {
                  var7 = var6._getDisplayName().string();
               }

               for (C0246 var9 : this.f_e4fb2cbb) {
                  String var10 = var9.m_8d7dbe31();
                  if ((Boolean)var4.apply(var7, var10)) {
                     this.m_e5f08f7c(var7, var10);
                  }
               }
            }

            this.f_bdf5b17c = var3.size();
         }
      }
   }

   protected void m_e5f08f7c(String var1, String var2) {
      C0064.m_13c9ffeb().m_2c2620fc(String.format(C0260.m_9d6ca6d0(), var2)).m_ecf8e7ae(C0260.m_87c16989(), var1).m_1058ed9a();
   }

   public static enum anonymousconst {
      f_69fc75b6((var0, var1) -> var0.matches(var1)),
      f_1144a7da((var0, var1) -> var0.toLowerCase().contains(var1));

      private final BiFunction<String, String, Boolean> f_b10e7827;

      public BiFunction<String, String, Boolean> m_33a967cc() {
         return this.f_b10e7827;
      }

      private anonymousconst(BiFunction<String, String, Boolean> var3) {
         this.f_b10e7827 = var3;
      }
   }
}
