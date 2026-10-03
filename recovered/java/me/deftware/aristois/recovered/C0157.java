package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.widgets.TextField;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public class C0157 extends C0168<TextField> implements C0163 {
   private final C0165 f_368bb4dc;
   private Message f_a048a565;
   private String f_a54d7fe6 = "";
   private String f_a3450660 = "";
   private Message f_327df58c;
   private final TextField f_e2486a4a;

   public C0157(int var1, int var2, int var3, int var4) {
      this.f_368bb4dc = new C0165((double)var1, (double)var2, (double)var3, (double)var4);
      this.f_e2486a4a = C0114.bootstrap<"call",0,1>(var1, var2, var3, var4);
   }

   public void m_4003551c() {
      this.m_63ef8c45("");
   }

   public void m_742449de() {
      this.setPosition((int)this.f_368bb4dc.m_14f8bc2c(), (int)this.f_368bb4dc.m_5a998971());
   }

   public C0157 m_09e822a9(String var1) {
      this.f_327df58c = C0114.bootstrap<"call",0,1>(var1).style(C0114.bootstrap<"call",1,1>(DefaultColors.DARK_GRAY));
      return this;
   }

   public C0157 m_d39ed081() {
      this.f_a54d7fe6 = C0252.bootstrap<"get",25769803879>();
      return this;
   }

   public int m_161753a4() {
      return C0114.bootstrap<"call",0,1>(this.m_55cc55cf());
   }

   public boolean m_e439f254() {
      if (!this.f_a54d7fe6.isEmpty() && !this.m_55cc55cf().trim().isEmpty()) {
         String var1 = this.m_55cc55cf();
         if (var1.startsWith(C0252.bootstrap<"get",4294967313>())) {
            var1 = var1.substring(1);
         }

         return var1.matches(this.f_a54d7fe6);
      } else {
         return !this.m_55cc55cf().trim().isEmpty();
      }
   }

   public String m_55cc55cf() {
      return this.f_e2486a4a._getText();
   }

   public void m_63ef8c45(String var1) {
      this.f_e2486a4a._setText(var1);
   }

   public boolean m_f4b6dd30(double var1, double var3, float var5, boolean var6) {
      if (this.f_a048a565 != null) {
         C0114.bootstrap<"call",1,1>(
            this.f_a048a565, (int)this.f_368bb4dc.m_14f8bc2c(), (int)this.f_368bb4dc.m_5a998971() - C0114.bootstrap<"call",0,1>() - 5, 16777215
         );
      }

      if (this.f_327df58c != null && this.m_55cc55cf().isEmpty()) {
         C0114.bootstrap<"call",1,1>(
            this.f_327df58c, this.getPositionX() + 4, (int)((double)this.getPositionY() + (this.m_4e48f5ec().m_fc7f45bc() - 8.0) / 2.0), 16777215
         );
      }

      return var6;
   }

   public void m_d3298760() {
      if (!this.f_a3450660.equals(this.m_55cc55cf())) {
         this.f_a3450660 = this.m_55cc55cf();
         this.m_5fe5b665();
      }
   }

   @Override
   public String toString() {
      return this.m_55cc55cf();
   }

   protected void m_5fe5b665() {
   }

   public C0165 m_4e48f5ec() {
      return this.f_368bb4dc;
   }

   public Message m_07ba16b8() {
      return this.f_a048a565;
   }

   public void m_f260ed14(Message var1) {
      this.f_a048a565 = var1;
   }

   public String m_23db04f7() {
      return this.f_a54d7fe6;
   }

   public String m_0b31c318() {
      return this.f_a3450660;
   }

   public void m_edbc42aa(String var1) {
      this.f_a54d7fe6 = var1;
   }

   public void m_fde4bcda(String var1) {
      this.f_a3450660 = var1;
   }

   public Message m_20aca3e9() {
      return this.f_327df58c;
   }

   public void m_6944db4d(Message var1) {
      this.f_327df58c = var1;
   }

   public TextField m_00c3febe() {
      return this.f_e2486a4a;
   }
}
