package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.GameSetting;

public class C0312 extends AbstractMod {
   private final GameSetting<Double> f_6e831e3a = GameSetting.GAMMA;
   @C0098(
      value = "Max brightness",
      number = @C0096(
         max = 16.0
      )
   )
   private double f_3a4a4986 = 16.0;
   private double f_30c9165f;

   public C0312() {
      super(C0260.m_023b99d9(), C0290.f_3210deb7, C0260.m_733bff3d());
      GameSetting.GAMMA = new GameSetting<Double>() {
         public Double m_f45ccc6e() {
            return C0312.this.isEnabled() ? C0312.this.m_0b5864b1() : (Double)C0312.this.f_6e831e3a.get();
         }

         public void m_cc03d365(Double var1) {
            C0312.this.f_6e831e3a.set(var1);
         }
      };
   }

   @Override
   public void onEnable() {
      this.f_30c9165f = (Double)this.f_6e831e3a.get();
   }

   @EventHandler
   public void m_3072cba8(EventUpdate var1) {
      if (this.f_30c9165f < this.f_3a4a4986) {
         this.f_30c9165f += 0.5;
      }
   }

   public double m_0b5864b1() {
      return this.f_30c9165f;
   }
}
