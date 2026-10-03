package me.deftware.aristois.recovered;

public class C0285 extends C0288<C0285> {
   protected boolean f_206f8e47 = false;
   protected boolean f_0aebd4ca = false;

   public C0285(Runnable var1) {
      if (var1 != null) {
         this.m_1ba7da6b(var1);
      }
   }

   protected void m_1ba7da6b(Runnable var1) {
      C0114.bootstrap<"call",0,1>().submit(() -> {
         var1.run();
         this.f_0aebd4ca = true;
      });
   }

   public C0285 m_239622f4() {
      this.f_0aebd4ca = true;
      return this;
   }

   public C0285 m_cb933644() {
      this.f_80c2ddee = C0114.bootstrap<"call",0,1>();
      this.f_206f8e47 = true;
      return this;
   }

   public C0285 m_732f694e() {
      return this;
   }

   public boolean m_68ef7232() {
      return this.f_206f8e47;
   }

   public boolean m_59701e4b() {
      return this.f_0aebd4ca;
   }
}
