package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.helper.WindowHelper;
import me.deftware.client.framework.minecraft.GameSetting;

@C0422(
   pinned = false
)
public class C0356 extends AbstractMod {
   private final GameSetting<Integer> f_885d0376 = GameSetting.MAX_FPS;
   @C0098(
      value = "Limited FPS",
      number = @C0096(
         min = 5.0,
         max = 200.0
      )
   )
   private int f_7a37aae5 = 5;

   public C0356() {
      super(C0260.m_17d51275(), C0290.f_99d080af, C0260.m_00ba16c2());
      GameSetting.MAX_FPS = new GameSetting<Integer>() {
         public Integer m_bc815670() {
            return C0356.this.isEnabled() && !WindowHelper.isFocused() ? C0356.this.f_7a37aae5 : (Integer)C0356.this.f_885d0376.get();
         }

         public void m_62fbf7f5(Integer var1) {
            C0356.this.f_885d0376.set(var1);
         }
      };
   }
}
