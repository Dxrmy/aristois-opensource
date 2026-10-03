package me.deftware.aristois.recovered;

import java.util.function.Supplier;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.message.Message;

public abstract class C0154 extends C0168<Button> implements C0163 {
   private final C0165 f_f711b0b4;
   private Supplier<Boolean> f_660c42d8;
   private C0153 f_fe5febf4;
   private final Button f_20e93119;

   public C0154(int var1, int var2, int var3, int var4, Message var5) {
      this.f_f711b0b4 = new C0165((double)var1, (double)var2, (double)var3, (double)var4);
      this.f_20e93119 = C0114.bootstrap<"call",0,1>(var1, var2, var3, var4, var5, true, this::m_e4ed7296);
   }

   public abstract boolean m_e4ed7296(int var1);

   public void m_a980318c() {
      this.f_20e93119.setPosition((int)this.f_f711b0b4.m_14f8bc2c(), (int)this.f_f711b0b4.m_5a998971());
   }

   public C0154 m_dc08502f(Supplier<Boolean> var1) {
      this.f_660c42d8 = var1;
      return this;
   }

   public C0154 m_ceeaf922(boolean var1) {
      this.f_20e93119.setActive(var1);
      return this;
   }

   public C0154 m_a901629a(Message... var1) {
      this.f_20e93119._setTooltip(var1);
      return this;
   }

   public boolean m_0315506a(double var1, double var3, float var5, boolean var6) {
      return var6;
   }

   public void m_4713001f() {
      if (this.f_660c42d8 != null) {
         this.f_20e93119.setActive(this.f_660c42d8.get());
      }
   }

   public C0165 m_9c5eea58() {
      return this.f_f711b0b4;
   }

   public Supplier<Boolean> m_8762c4ed() {
      return this.f_660c42d8;
   }

   public C0153 m_cbf9d30b() {
      return this.f_fe5febf4;
   }

   public void m_ca06ea23(C0153 var1) {
      this.f_fe5febf4 = var1;
   }

   public Button m_8f596680() {
      return this.f_20e93119;
   }
}
