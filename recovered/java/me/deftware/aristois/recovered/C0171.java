package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.Message;

public class C0171 extends C0150 {
   protected C0157 f_7a8bca33;
   protected C0160 f_03900406;
   protected C0160 f_fce448d3;
   protected String f_45ed19a3 = C0254.m_a55b07ff();
   protected String f_8b9abab9 = C0254.m_16315846();

   public C0171(GenericScreen var1) {
      super(var1);
   }

   @Override
   protected void m_1058ed9a() {
      this.addCenteredText(getScaledWidth() / 2, 30, Message.of(this.f_45ed19a3));
      short var1 = 380;
      short var2 = 130;
      this.m_4f7d4126(new C0163[]{this.f_7a8bca33 = this.m_c1f9f0d3(getScaledWidth() / 2 - var1 / 2, 60, var1, Message.of(C0254.m_e8fd0250()))});
      this.f_7a8bca33.m_6909040f()._setMaxLength(9999);
      this.m_ba846326(getScaledWidth() / 2, 105, new Message[]{Message.of(C0254.m_d0da63e8()), Message.of(C0254.m_0425f2ec()), Message.of(C0254.m_1b17f04f())});
      var1 = 280;
      this.m_4f7d4126(
         new C0163[]{
            new C0155(getScaledWidth() / 2, 160, (float)var1, (float)var2, this)
               .m_2ee4da8d(this.f_03900406 = new C0160(0, 0, var2, 20), this.f_fce448d3 = new C0160(0, 0, var2, 20))
         }
      );
      this.f_fce448d3.m_394ecb95(true);
      this.f_fce448d3.m_c7a3618c(new C0153(this.f_fce448d3, Message.of(C0254.m_bcef2112()), Message.of(C0254.m_114677c2())));
      this.m_4f7d4126(
         new C0163[]{
            new C0155(getScaledWidth() / 2, getScaledHeight() - 40, (float)var1, (float)var2, this)
               .m_2ee4da8d(
                  this.m_79273652(0, 0, (float)var2, Message.of(this.f_8b9abab9), this::m_23674f64)
                     .m_798462fc(() -> this.m_8407423a(new C0157[]{this.f_7a8bca33})),
                  this.m_79273652(0, 0, (float)var2, Message.of(C0261.m_56c1229f()), this::goBack)
               )
         }
      );
   }

   protected void m_e07ace4d(C0268 var1) {
      var1.m_a11708c5(this.f_7a8bca33.m_e9914bd3());
      var1.m_46938bdb(this.f_03900406.m_2ac34870());
      var1.m_7c7fe86a(this.f_fce448d3.m_2ac34870());
   }

   protected void m_23674f64() {
      C0268 var1 = new C0268();
      this.m_e07ace4d(var1);
      C0268.m_ea54feba().add(var1);
      this.goBack();
   }
}
