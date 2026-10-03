package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.aristois.menu.view.dialog.ColorDialogWidget;
import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;

public class C0185 extends C0150 {
   protected C0157 f_6e93dd85;
   protected C0157 f_a3543b5a;
   protected C0157 f_3ec05b51;
   protected C0157 f_023230e8;
   protected C0436 f_6d86342a;
   protected C0167 f_d32d343f;
   protected String f_78c6042e = C0252.bootstrap<"get",21474836578>();
   protected String f_b6c75b5a = C0252.bootstrap<"get",21474836565>();

   public C0185(C0186 var1) {
      super(var1);
   }

   protected void m_3a4a7259() {
      this.addCenteredText(C0114.bootstrap<"call",0,1>() / 2, 30, C0114.bootstrap<"call",1,1>(this.f_78c6042e));
      short var1 = 250;
      byte var2 = 75;
      this.m_fc9deb50(
         new C0163[]{
            this.f_6e93dd85 = this.m_744e2925(
               C0114.bootstrap<"call",0,1>() / 2 - var1 / 2, 60, var1, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836579>())
            ),
            new C0155(C0114.bootstrap<"call",0,1>() / 2, 120, (float)var1, (float)var2, this)
               .m_5d3ed1f2(
                  this.f_a3543b5a = this.m_744e2925(0, 0, var2, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",8589934661>())).m_d39ed081(),
                  this.f_3ec05b51 = this.m_744e2925(0, 0, var2, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",8589934662>())).m_d39ed081(),
                  this.f_023230e8 = this.m_744e2925(0, 0, var2, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",8589934663>())).m_d39ed081()
               )
         }
      );
      final Message var3 = C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836580>());
      this.m_fc9deb50(
         new C0163[]{
            this.f_d32d343f = new C0167(
               (double)C0114.bootstrap<"call",0,1>() / 2.0 + (double)var1 / 2.0 - 20.0,
               150.0,
               20.0,
               20.0,
               this.f_6d86342a = (new C0436(
                     20.0, 20.0, 200.0, 100.0, Color.pink, ColorDialogWidget.brightness, ColorDialogWidget.hue, ColorDialogWidget.opacity
                  ) {
                     public void m_79c6b85a(Color var1, boolean var2) {
                     }
                  })
                  .m_b77d0dba(false),
               C0167.anonymousimplements.f_b787d6f1
            ) {
               protected void m_2d21f468(double var1, double var3x, float var5) {
                  C0114.bootstrap<"call",0,1>();
                  ((QuadRenderStack)this.f_0cad6cdd.begin().glColor(((C0436)this.f_db8bb2c4).m_6af97ed1()))
                     .drawRect(
                        this.f_5c0e6e25.m_14f8bc2c(),
                        this.f_5c0e6e25.m_5a998971(),
                        this.f_5c0e6e25.m_14f8bc2c() + this.f_5c0e6e25.m_830cb294(),
                        this.f_5c0e6e25.m_5a998971() + this.f_5c0e6e25.m_fc7f45bc()
                     )
                     .end();
                  C0114.bootstrap<"call",1,1>();
                  C0114.bootstrap<"call",4,1>(
                     var3,
                     (int)(this.f_5c0e6e25.m_14f8bc2c() - (double)C0114.bootstrap<"call",2,1>(var3) - 5.0),
                     (int)(this.f_5c0e6e25.m_5a998971() + (this.f_5c0e6e25.m_fc7f45bc() / 2.0 - (double)(C0114.bootstrap<"call",3,1>() / 2))),
                     16777215
                  );
               }
            }
         }
      );
      this.f_d32d343f.m_51e4e198(new C0153(this.f_d32d343f, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836581>())));
      var2 = 115;
      this.m_fc9deb50(
         new C0163[]{
            new C0155(C0114.bootstrap<"call",0,1>() / 2, C0114.bootstrap<"call",2,1>() - 50, (float)var1, (float)var2, this)
               .m_5d3ed1f2(
                  this.m_04ed740d(0, 0, (float)var2, C0114.bootstrap<"call",1,1>(this.f_b6c75b5a), this::m_9b637cb7)
                     .m_dc08502f(
                        () -> C0114.bootstrap<"call",0,1>(this.m_0d4aa095(new C0157[]{this.f_6e93dd85, this.f_a3543b5a, this.f_3ec05b51, this.f_023230e8}))
                     ),
                  this.m_04ed740d(0, 0, (float)var2, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",17179869310>()), this::goBack)
               )
         }
      );
      this.m_612145d8();
   }

   protected void m_612145d8() {
      MainEntityPlayer var1 = C0114.bootstrap<"call",0,1>()._getPlayer();
      if (var1 != null) {
         this.f_a3543b5a.m_63ef8c45(C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(var1.getPosX())));
         this.f_3ec05b51.m_63ef8c45(C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(var1.getPosY())));
         this.f_023230e8.m_63ef8c45(C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(var1.getPosZ())));
      }
   }

   protected void m_ebf9634a(C0244 var1) {
      var1.m_5e296171(this.f_a3543b5a.m_161753a4());
      var1.m_989d0d43(this.f_3ec05b51.m_161753a4());
      var1.m_0faa1ebc(this.f_023230e8.m_161753a4());
      var1.m_efd8b5f8(this.f_6e93dd85.m_55cc55cf());
      var1.m_9bee8302(this.f_6d86342a.m_6af97ed1().getRGB());
   }

   protected void m_9b637cb7() {
      C0244 var1 = new C0244();
      this.m_ebf9634a(var1);
      var1.m_9d941243(true);
      C0114.bootstrap<"call",0,1>().add(var1);
      this.goBack();
   }
}
