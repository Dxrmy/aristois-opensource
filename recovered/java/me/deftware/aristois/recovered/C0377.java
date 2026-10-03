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
   private C0104<Float> f_eb9e8c79 = new C0104<>(GameKeys.JUMP_HEIGHT, 0.8F).m_43d84283(this);

   public C0377() {
      super(C0259.m_d1f7b79f(), C0290.f_829d9b20, C0259.m_a29090eb());
   }
}
