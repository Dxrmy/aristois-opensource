package me.deftware.aristois.recovered;

import java.util.Arrays;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.EventListener;
import me.deftware.client.framework.event.events.EventPacketReceive;
import me.deftware.client.framework.network.packets.SPacketWorldTime;

public final class C0044 extends EventListener implements Runnable {
   public static final C0044 f_7b762377 = new C0044();
   private final float[] f_faaf0455 = new float[20];
   private long f_8b63bda3 = -1L;
   private int f_88f6c235 = 0;

   public C0044() {
      Arrays.fill(this.f_faaf0455, 20.0F);
   }

   @EventHandler
   private void m_212989b8(EventPacketReceive var1) {
      if (var1.getIPacket() instanceof SPacketWorldTime) {
         if (this.f_8b63bda3 != -1L) {
            float var2 = (float)(System.currentTimeMillis() - this.f_8b63bda3) / 1000.0F;
            float var3 = 20.0F / var2;
            int var4 = this.f_88f6c235++ % this.f_faaf0455.length;
            this.f_faaf0455[var4] = var3;
         }

         this.f_8b63bda3 = System.currentTimeMillis();
      }
   }

   public double m_a005efae() {
      float var1 = 0.0F;

      for (float var5 : this.f_faaf0455) {
         var1 += var5;
      }

      var1 /= (float)this.f_faaf0455.length;
      return (double)m_5472ad7f(0.0F, 20.0F, var1);
   }

   public static float m_5472ad7f(float var0, float var1, float var2) {
      return Math.min(Math.max(var0, var2), var1);
   }

   @Override
   public void run() {
      System.out.println(C0261.m_d9b37a36());
   }
}
