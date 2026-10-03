package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameKeys;

public class C0377 extends AbstractMod {
   @C0098(
      value = "Jump Height",
      number = @C0096(
         min = 0.1,
         max = 1.0,
         percentage = true
      )
   )
   private C0104<Float> f_fb3644ba = new C0104<>(GameKeys.JUMP_HEIGHT, C0114.bootstrap<"call",0,1>(0.8F)).m_958520b0(this);

   public C0377() {
      super(C0252.bootstrap<"get",42949673033>(), C0290.f_cd638c01, C0252.bootstrap<"get",42949673034>());
   }
}
