package me.deftware.aristois.recovered;

public class C0142 {
   private final String f_5a780584;
   private int f_9cb26973 = 25565;

   public C0142(String var1, int var2) {
      this.f_5a780584 = var1;
      this.f_9cb26973 = var2;
   }

   public C0142(String var1) {
      if (var1.contains(C0267.m_0d6ae39b())) {
         String[] var2 = var1.split(C0267.m_0d6ae39b());
         this.f_5a780584 = var2[0];

         try {
            this.f_9cb26973 = Integer.parseInt(var2[1]);
            if (!this.m_1521b1fa(this.f_9cb26973)) {
               throw new Exception(C0255.m_a29090eb());
            }
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      } else {
         this.f_5a780584 = var1;
      }
   }

   public String m_8d7dbe31() {
      return String.format(C0255.m_b2dd5137(), this.f_5a780584, this.f_9cb26973);
   }

   public String m_3d3a8736() {
      return this.f_5a780584;
   }

   public int m_037208cc() {
      return this.f_9cb26973;
   }

   private boolean m_1521b1fa(int var1) {
      return var1 >= 0 && var1 <= 65535;
   }
}
