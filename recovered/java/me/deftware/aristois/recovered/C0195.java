package me.deftware.aristois.recovered;

import java.util.List;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.Message;

public class C0195 extends C0150 {
   private List<Message> f_8168f389;
   protected C0154 f_86037b1f;

   public C0195(GenericScreen var1, Message... var2) {
      this(var1, C0114.bootstrap<"call",0,1>(var2));
   }

   public C0195(GenericScreen var1, List<Message> var2) {
      super(var1);
      this.f_8168f389 = var2;
   }

   protected void m_cee889d9() {
      short var1 = 250;
      this.m_8d1d2aa9(
         new C0163[]{
            this.f_86037b1f = this.m_df3b6157(
               this.getGuiScreenWidth() / 2 - var1 / 2,
               this.getGuiScreenHeight() - 40,
               (float)var1,
               C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",10>()),
               this::goBack
            )
         }
      );
   }

   @Override
   protected void onDraw(int var1, int var2, float var3) {
      super.onDraw(var1, var2, var3);
      int var4 = this.getGuiScreenHeight() / 2 - this.f_8168f389.size() * C0114.bootstrap<"call",0,1>() / 2 - 40;
      int var5 = this.getGuiScreenWidth() / 2;

      for (Message var7 : this.f_8168f389) {
         C0114.bootstrap<"call",2,1>(var7, var5 - C0114.bootstrap<"call",1,1>(var7) / 2, var4, 16777215);
         var4 += C0114.bootstrap<"call",0,1>() + 2;
      }
   }

   public void m_c9cd73c1(List<Message> var1) {
      this.f_8168f389 = var1;
   }

   public List<Message> m_c0eedd08() {
      return this.f_8168f389;
   }

   public C0154 m_e0c5a994() {
      return this.f_86037b1f;
   }
}
