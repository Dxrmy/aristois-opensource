package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.minecraft.GameSetting;

@C0422(
   pinned = false
)
public class C0356 extends AbstractMod {
   private final GameSetting<Integer> f_c056501f = GameSetting.MAX_FPS;
   @C0098(
      value = "Limited FPS",
      number = @C0096(
         min = 5.0,
         max = 200.0
      )
   )
   private int f_70513cd6 = 5;

   public C0356() {
      super(C0252.bootstrap<"get",47244640327>(), C0290.f_a5db61fd, C0252.bootstrap<"get",47244640328>());
      GameSetting.MAX_FPS = new GameSetting<Integer>() {
         public Integer m_9892c34a() {
            return C0356.this.isEnabled() && !C0114.bootstrap<"call",0,1>()
               ? C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(C0356.this))
               : (Integer)C0114.bootstrap<"call",3,1>(C0356.this).get();
         }

         public void m_5e4ed5d2(Integer var1) {
            C0114.bootstrap<"call",3,1>(C0356.this).set(var1);
         }
      };
   }
}
