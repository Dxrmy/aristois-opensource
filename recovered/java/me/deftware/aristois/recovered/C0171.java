package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.Message;

public class C0171 extends C0150 {
   protected C0157 f_4733c937;
   protected C0160 f_ee52094e;
   protected C0160 f_8050faa8;
   protected String f_aabb2253 = C0252.bootstrap<"get",21474836564>();
   protected String f_d91f80a5 = C0252.bootstrap<"get",21474836565>();

   public C0171(GenericScreen var1) {
      super(var1);
   }

   protected void m_3c18b79c() {
      this.addCenteredText(C0114.bootstrap<"call",0,1>() / 2, 30, C0114.bootstrap<"call",1,1>(this.f_aabb2253));
      short var1 = 380;
      short var2 = 130;
      this.m_853fd341(
         new C0163[]{
            this.f_4733c937 = this.m_ed634012(
               C0114.bootstrap<"call",0,1>() / 2 - var1 / 2, 60, var1, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836566>())
            )
         }
      );
      this.f_4733c937.m_00c3febe()._setMaxLength(9999);
      this.m_deb13d8b(
         C0114.bootstrap<"call",0,1>() / 2,
         105,
         new Message[]{
            C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836567>()),
            C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836568>()),
            C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836569>())
         }
      );
      var1 = 280;
      this.m_853fd341(
         new C0163[]{
            new C0155(C0114.bootstrap<"call",0,1>() / 2, 160, (float)var1, (float)var2, this)
               .m_5d3ed1f2(this.f_ee52094e = new C0160(0, 0, var2, 20), this.f_8050faa8 = new C0160(0, 0, var2, 20))
         }
      );
      this.f_8050faa8.m_7a9b0e8d(true);
      this.f_8050faa8
         .m_20835c5b(
            new C0153(
               this.f_8050faa8,
               C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836570>()),
               C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836571>())
            )
         );
      this.m_853fd341(
         new C0163[]{
            new C0155(C0114.bootstrap<"call",0,1>() / 2, C0114.bootstrap<"call",2,1>() - 40, (float)var1, (float)var2, this)
               .m_5d3ed1f2(
                  this.m_c8e82587(0, 0, (float)var2, C0114.bootstrap<"call",1,1>(this.f_d91f80a5), this::m_f4bb942b)
                     .m_dc08502f(() -> C0114.bootstrap<"call",0,1>(this.m_3ef5a0cc(new C0157[]{this.f_4733c937}))),
                  this.m_c8e82587(0, 0, (float)var2, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",17179869310>()), this::goBack)
               )
         }
      );
   }

   protected void m_180f0cd8(C0268 var1) {
      var1.m_3e620f34(this.f_4733c937.m_55cc55cf());
      var1.m_2faedb85(this.f_ee52094e.m_12ad4521());
      var1.m_5dc61818(this.f_8050faa8.m_12ad4521());
   }

   protected void m_f4bb942b() {
      C0268 var1 = new C0268();
      this.m_180f0cd8(var1);
      C0114.bootstrap<"call",0,1>().add(var1);
      this.goBack();
   }
}
