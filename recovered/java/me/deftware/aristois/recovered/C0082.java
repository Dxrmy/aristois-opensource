package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;

public abstract class C0082 extends AbstractMod implements C0075 {
   @C0098(
      value = "Location",
      id = 0
   )
   private C0102<C0087> f_1b4e0049;
   @C0098(
      value = "Priority",
      id = 1
   )
   protected int f_fd8e2fcd = 1;

   public C0082(String var1, C0087 var2, String... var3) {
      super(var1, C0290.f_43c13687, var3);
      this.f_1b4e0049 = new C0102<>(var2);
   }

   protected void m_4edf5543(C0087 var1) {
   }

   @Override
   public C0087 m_a7c622af() {
      return this.f_1b4e0049.m_284992ec();
   }

   @Override
   public boolean m_89e0519f() {
      return this.isEnabled();
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (var1.id() <= 1) {
         if (var1.id() == 0) {
            this.m_4edf5543(this.m_a7c622af());
         }

         C0074.f_d3f3801b.m_d6ac7420(false);
      }
   }

   @Override
   public int m_36ffc578() {
      return this.f_fd8e2fcd;
   }
}
