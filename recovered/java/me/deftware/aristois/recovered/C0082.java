package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;

public abstract class C0082 extends AbstractMod implements C0075 {
   @C0098(
      value = "Location",
      id = 0
   )
   private C0102<C0087> f_16473b02;
   @C0098(
      value = "Priority",
      id = 1
   )
   protected int f_2c05c16e = 1;

   public C0082(String var1, C0087 var2, String... var3) {
      super(var1, C0290.f_4792a25c, var3);
      this.f_16473b02 = new C0102<>(var2);
   }

   protected void m_4ad4f025(C0087 var1) {
   }

   public C0087 m_c8fdc8ee() {
      return this.f_16473b02.m_e2691446();
   }

   public boolean m_6ffca938() {
      return this.isEnabled();
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (var1.id() <= 1) {
         if (var1.id() == 0) {
            this.m_4ad4f025(this.m_c8fdc8ee());
         }

         C0074.f_c9f3a771.m_2244f384(false);
      }
   }

   public int m_78054fd6() {
      return this.f_2c05c16e;
   }
}
