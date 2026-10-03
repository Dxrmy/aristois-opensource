package me.deftware.aristois.recovered;

public class C0142 {
   private final String f_2a5cb9e5;
   private int f_b5dce41d = 25565;

   public C0142(String var1, int var2) {
      this.f_2a5cb9e5 = var1;
      this.f_b5dce41d = var2;
   }

   public C0142(String var1) {
      if (var1.contains(C0252.bootstrap<"get",25769803903>())) {
         String[] var2 = var1.split(C0252.bootstrap<"get",25769803903>());
         this.f_2a5cb9e5 = var2[0];

         try {
            this.f_b5dce41d = C0114.bootstrap<"call",0,1>(var2[1]);
            if (!this.m_85c38824(this.f_b5dce41d)) {
               throw new Exception(C0252.bootstrap<"get",51539607626>());
            }
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      } else {
         this.f_2a5cb9e5 = var1;
      }
   }

   public String m_3fe49b69() {
      return C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",51539607627>(), new Object[]{this.f_2a5cb9e5, C0114.bootstrap<"call",0,1>(this.f_b5dce41d)});
   }

   public String m_a4d19008() {
      return this.f_2a5cb9e5;
   }

   public int m_00c47d69() {
      return this.f_b5dce41d;
   }

   private boolean m_85c38824(int var1) {
      return var1 >= 0 && var1 <= 65535;
   }
}
