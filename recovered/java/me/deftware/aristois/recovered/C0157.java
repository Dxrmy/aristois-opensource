package me.deftware.aristois.recovered;

import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.widgets.TextField;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public class C0157 extends C0168<TextField> implements C0163 {
   private final C0165 f_e66b318c;
   private Message f_86c551f5;
   private String f_1e1cdc2b = "";
   private String f_a8988247 = "";
   private Message f_47012fbf;
   private final TextField f_535e9229;

   public C0157(int var1, int var2, int var3, int var4) {
      this.f_e66b318c = new C0165((double)var1, (double)var2, (double)var3, (double)var4);
      this.f_535e9229 = TextField.create(var1, var2, var3, var4);
   }

   public void m_23674f64() {
      this.m_333019c8("");
   }

   @Override
   public void m_1058ed9a() {
      this.setPosition((int)this.f_e66b318c.m_a005efae(), (int)this.f_e66b318c.m_84808068());
   }

   public C0157 m_407926d1(String var1) {
      this.f_47012fbf = Message.of(var1).style(Appearance.of(DefaultColors.DARK_GRAY));
      return this;
   }

   public C0157 m_35587e93() {
      this.f_1e1cdc2b = C0267.m_c04d8f6e();
      return this;
   }

   public int m_2ac34870() {
      return Integer.parseInt(this.m_e9914bd3());
   }

   public boolean m_f21a055b() {
      if (!this.f_1e1cdc2b.isEmpty() && !this.m_e9914bd3().trim().isEmpty()) {
         String var1 = this.m_e9914bd3();
         if (var1.startsWith(C0264.m_18204724())) {
            var1 = var1.substring(1);
         }

         return var1.matches(this.f_1e1cdc2b);
      } else {
         return !this.m_e9914bd3().trim().isEmpty();
      }
   }

   public String m_e9914bd3() {
      return this.f_535e9229._getText();
   }

   public void m_333019c8(String var1) {
      this.f_535e9229._setText(var1);
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      if (this.f_86c551f5 != null) {
         FontRenderer.drawStringWithShadow(
            this.f_86c551f5, (int)this.f_e66b318c.m_a005efae(), (int)this.f_e66b318c.m_84808068() - FontRenderer.getFontHeight() - 5, 16777215
         );
      }

      if (this.f_47012fbf != null && this.m_e9914bd3().isEmpty()) {
         FontRenderer.drawStringWithShadow(
            this.f_47012fbf, this.getPositionX() + 4, (int)((double)this.getPositionY() + (this.m_44bb072f().m_d42f3372() - 8.0) / 2.0), 16777215
         );
      }

      return var6;
   }

   @Override
   public void m_0e265701() {
      if (!this.f_a8988247.equals(this.m_e9914bd3())) {
         this.f_a8988247 = this.m_e9914bd3();
         this.m_b728afce();
      }
   }

   @Override
   public String toString() {
      return this.m_e9914bd3();
   }

   protected void m_b728afce() {
   }

   @Override
   public C0165 m_44bb072f() {
      return this.f_e66b318c;
   }

   public Message m_6fc98322() {
      return this.f_86c551f5;
   }

   public void m_8d564dc2(Message var1) {
      this.f_86c551f5 = var1;
   }

   public String m_6f1f396d() {
      return this.f_1e1cdc2b;
   }

   public String m_94acbdac() {
      return this.f_a8988247;
   }

   public void m_4404c3bc(String var1) {
      this.f_1e1cdc2b = var1;
   }

   public void m_4f03e646(String var1) {
      this.f_a8988247 = var1;
   }

   public Message m_1b2580f8() {
      return this.f_47012fbf;
   }

   public void m_efb6bb0d(Message var1) {
      this.f_47012fbf = var1;
   }

   public TextField m_6909040f() {
      return this.f_535e9229;
   }
}
