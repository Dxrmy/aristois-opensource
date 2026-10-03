package me.deftware.aristois.recovered;

import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.EventListener;
import me.deftware.client.framework.event.events.EventPacketReceive;
import me.deftware.client.framework.network.packets.SPacketWorldTime;

public final class C0044 extends EventListener implements Runnable {
   public static final C0044 f_35859108 = new C0044();
   private final float[] f_ccfed59b = new float[20];
   private long f_ac9e169b = -1L;
   private int f_297f3bdf = 0;

   public C0044() {
      C0114.bootstrap<"call",0,1>(this.f_ccfed59b, 20.0F);
   }

   @EventHandler
   private void m_e1c3dcec(EventPacketReceive var1) {
      if (var1.getIPacket() instanceof SPacketWorldTime) {
         if (this.f_ac9e169b != -1L) {
            float var2 = (float)(C0114.bootstrap<"call",0,1>() - this.f_ac9e169b) / 1000.0F;
            float var3 = 20.0F / var2;
            int var4 = this.f_297f3bdf++ % this.f_ccfed59b.length;
            this.f_ccfed59b[var4] = var3;
         }

         this.f_ac9e169b = C0114.bootstrap<"call",0,1>();
      }
   }

   public double m_b56b2c3d() {
      float var1 = 0.0F;

      for (float var5 : this.f_ccfed59b) {
         var1 += var5;
      }

      var1 /= (float)this.f_ccfed59b.length;
      return (double)C0114.bootstrap<"call",1,1>(0.0F, 20.0F, var1);
   }

   public static float m_8dfae850(float var0, float var1, float var2) {
      return C0114.bootstrap<"call",3,1>(C0114.bootstrap<"call",2,1>(var0, var2), var1);
   }

   @Override
   public void run() {
      System.out.println(C0252.bootstrap<"get",17179869246>());
   }
}
