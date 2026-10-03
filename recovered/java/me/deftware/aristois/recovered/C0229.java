package me.deftware.aristois.recovered;

public class C0229 implements C0230 {
   public static final C0229 f_91d70760 = new C0229(C0252.bootstrap<"get",17179869277>());
   private static final String f_fa6eac55 = C0252.bootstrap<"get",17179869274>();
   protected C0148 f_a308789d;
   protected C0148 f_c9d306fd;
   protected final String f_7fd57eb0;

   public C0229(String var1) {
      this.f_7fd57eb0 = var1;
      this.m_0dc46159();
   }

   protected void m_0dc46159() {
      this.f_a308789d = new C0148(
         C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869273>(), new Object[]{C0252.bootstrap<"get",17179869274>(), this.f_7fd57eb0})
      );
      this.f_c9d306fd = new C0148(
         C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869275>(), new Object[]{C0252.bootstrap<"get",17179869274>(), this.f_7fd57eb0})
      );
   }

   public boolean m_7f6bc8ea(C0230.anonymouscatch var1) {
      switch (var1) {
         case f_88d11990:
            return this.f_a308789d.isReady();
         case f_b4b41867:
            return this.f_c9d306fd.isReady();
         default:
            throw new RuntimeException(C0252.bootstrap<"get",17179869276>());
      }
   }

   public void m_c961669a(int var1, int var2, int var3, int var4, C0230.anonymouscatch var5) {
      switch (var5) {
         case f_88d11990:
            this.f_a308789d.bind().draw(var1, var2, var3, var4).unbind();
            break;
         case f_b4b41867:
            this.f_c9d306fd.bind().draw(var1, var2, var3, var4).unbind();
      }
   }

   public int m_1009ae4d() {
      return this.f_a308789d.getTextureWidth();
   }

   public int m_2d4a3b72() {
      return this.f_a308789d.getTextureHeight();
   }

   public String m_3f5a70f6() {
      return this.f_7fd57eb0;
   }
}
