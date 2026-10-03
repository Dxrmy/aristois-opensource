package me.deftware.aristois.recovered;

import java.util.UUID;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.message.DefaultColors;

public interface C0049 extends ListItem {
   C0224 f_81193085 = C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",0>()));
   int f_28837e36 = 20;

   static UUID m_46b7f546() {
      String var0 = C0114.bootstrap<"call",0,1>();
      int var1 = var0.length();
      return var1 != 32 && var1 != 36 ? null : C0114.bootstrap<"call",1,1>(var0);
   }

   String m_d940b335();

   UUID m_94ee9461();

   default String m_42452946() {
      return this.m_d940b335();
   }

   default C0230 m_dda36821() {
      return f_81193085;
   }

   default boolean m_f9052555() {
      UUID var1 = C0114.bootstrap<"call",0,1>();
      return var1 != null && var1.equals(this.m_94ee9461());
   }

   void m_afc8f035();

   void m_02fb878c() throws Exception;

   default void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
      C0114.bootstrap<"call",2,1>(
         C0114.bootstrap<"call",0,1>(this.m_42452946()).style(C0114.bootstrap<"call",1,1>(this.m_f9052555() ? DefaultColors.GREEN : DefaultColors.WHITE)),
         var2 + 20,
         var3 + 3,
         16777215
      );
      C0230 var9 = this.m_dda36821();
      if (var9.m_63716b28(C0230.anonymouscatch.f_b4b41867)) {
         var9.m_1d96e0fd(var2 - 8, var3 + 1, 24, 24, C0230.anonymouscatch.f_b4b41867);
      }
   }
}
