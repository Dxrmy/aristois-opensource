package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventUpdate;
import me.deftware.client.framework.minecraft.GameSetting;

public class C0312 extends AbstractMod {
   private final GameSetting<Double> f_4e908fe1 = GameSetting.GAMMA;
   @C0098(
      value = "Max brightness",
      number = @C0096(
         max = 16.0
      )
   )
   private double f_196c8080 = 16.0;
   private double f_4073a75b;

   public C0312() {
      super(C0252.bootstrap<"get",47244640370>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640371>());
      GameSetting.GAMMA = new GameSetting<Double>() {
         public Double m_48564a4e() {
            return C0312.this.isEnabled() ? C0114.bootstrap<"call",0,1>(C0312.this.m_d1b614a4()) : (Double)C0114.bootstrap<"call",1,1>(C0312.this).get();
         }

         public void m_a2e3bfbb(Double var1) {
            C0114.bootstrap<"call",1,1>(C0312.this).set(var1);
         }
      };
   }

   @Override
   public void onEnable() {
      this.f_4073a75b = (Double)this.f_4e908fe1.get();
   }

   @EventHandler
   public void m_c2eb83cc(EventUpdate var1) {
      if (this.f_4073a75b < this.f_196c8080) {
         this.f_4073a75b += 0.5;
      }
   }

   public double m_d1b614a4() {
      return this.f_4073a75b;
   }
}
