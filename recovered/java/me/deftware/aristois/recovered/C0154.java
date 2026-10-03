package me.deftware.aristois.recovered;

import java.util.function.Supplier;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.message.Message;

public abstract class C0154 extends C0168<Button> implements C0163 {
   private final C0165 f_5225733f;
   private Supplier<Boolean> f_320f6299;
   private C0153 f_17d853f0;
   private final Button f_7b5e2cde;

   public C0154(int var1, int var2, int var3, int var4, Message var5) {
      this.f_5225733f = new C0165((double)var1, (double)var2, (double)var3, (double)var4);
      this.f_7b5e2cde = Button.create(var1, var2, var3, var4, var5, true, this::m_1521b1fa);
   }

   public abstract boolean m_1521b1fa(int var1);

   @Override
   public void m_1058ed9a() {
      this.f_7b5e2cde.setPosition((int)this.f_5225733f.m_a005efae(), (int)this.f_5225733f.m_84808068());
   }

   public C0154 m_798462fc(Supplier<Boolean> var1) {
      this.f_320f6299 = var1;
      return this;
   }

   public C0154 m_463a22e9(boolean var1) {
      this.f_7b5e2cde.setActive(var1);
      return this;
   }

   public C0154 m_e3aa1fb0(Message... var1) {
      this.f_7b5e2cde._setTooltip(var1);
      return this;
   }

   @Override
   public boolean m_572d14e6(double var1, double var3, float var5, boolean var6) {
      return var6;
   }

   @Override
   public void m_0e265701() {
      if (this.f_320f6299 != null) {
         this.f_7b5e2cde.setActive(this.f_320f6299.get());
      }
   }

   @Override
   public C0165 m_44bb072f() {
      return this.f_5225733f;
   }

   public Supplier<Boolean> m_a582509c() {
      return this.f_320f6299;
   }

   @Override
   public C0153 m_75885561() {
      return this.f_17d853f0;
   }

   @Override
   public void m_c7a3618c(C0153 var1) {
      this.f_17d853f0 = var1;
   }

   public Button m_b1b94a23() {
      return this.f_7b5e2cde;
   }
}
