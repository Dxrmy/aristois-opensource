package me.deftware.aristois.recovered;

import java.util.UUID;

public class C0159 extends C0162 {
   private final C0230 f_4df5bdf0;
   private C0230.anonymouscatch f_e5fe13db = C0230.anonymouscatch.f_b4b41867;

   public C0159(int var1, int var2, int var3, UUID var4) {
      super(var1, var2, var3, var3, null);
      this.f_4df5bdf0 = C0114.bootstrap<"call",0,1>(var4);
   }

   public boolean m_93d07cd0(double var1, double var3, float var5, boolean var6) {
      if (this.f_4df5bdf0.m_63716b28(this.f_e5fe13db)) {
         this.f_4df5bdf0
            .m_1d96e0fd(
               (int)this.f_2af424a3.m_14f8bc2c(),
               (int)this.f_2af424a3.m_5a998971(),
               (int)this.f_2af424a3.m_830cb294(),
               (int)this.f_2af424a3.m_fc7f45bc(),
               this.f_e5fe13db
            );
      }

      return var6;
   }

   public void m_0e143f80(C0230.anonymouscatch var1) {
      this.f_e5fe13db = var1;
   }
}
