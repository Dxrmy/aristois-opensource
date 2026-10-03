package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.Button;

public class C0172 extends C0188<C0268> {
   public C0172(GenericScreen var1) {
      super(var1, C0114.bootstrap<"call",0,1>());
   }

   protected void m_3291b11a() {
      this.f_c126c75a = C0252.bootstrap<"get",21474836555>();
      this.f_fb43cc92 = 400;
      this.m_405502a2(true);
      super.m_295487ee();
   }

   protected C0155[] m_2d158db3() {
      short var1 = 130;
      short var2 = 130;
      return new C0155[]{
         new C0155((float)var1, this)
            .m_5d3ed1f2(
               this.m_c9e72ccd(0, 0, (float)var1, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836558>()), () -> new C0171(this)),
               this.m_8c51f6c1(0, 0, (float)var1, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836559>()), this::m_e0dbe97c)
                  .m_dc08502f(this::m_3c15851a),
               this.m_3ebd75fd(0, 0, (float)var2, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",10>()), this::goBack)
            ),
         new C0155((float)var2, this)
            .m_5d3ed1f2(
               this.m_8c51f6c1(
                     0,
                     0,
                     (float)var2,
                     C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836573>()),
                     var1x -> {
                        C0114.bootstrap<"call",0,1>(((C0268)this.m_e6e11032()).m_8ccabf49());
                        ((Button)var1x.m_8f596680().setComponentLabel(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836577>())))
                           .resetToAfter(2000, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836573>()));
                     }
                  )
                  .m_dc08502f(this::m_3c15851a),
               this.m_8c51f6c1(
                     0,
                     0,
                     (float)var2,
                     C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836574>()),
                     var1x -> {
                        MainEntityPlayer var2x = C0114.bootstrap<"call",0,1>()._getPlayer();
                        String var3 = "";
                        if (var2x == null) {
                           var3 = C0252.bootstrap<"get",21474836575>();
                        } else {
                           ((C0268)this.m_e6e11032()).run();
                           var3 = C0252.bootstrap<"get",21474836576>();
                        }

                        ((Button)var1x.m_8f596680().setComponentLabel(C0114.bootstrap<"call",1,1>(var3)))
                           .resetToAfter(2000, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836574>()));
                     }
                  )
                  .m_dc08502f(this::m_3c15851a),
               this.m_3ebd75fd(
                     0,
                     0,
                     (float)var1,
                     C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836560>()),
                     () -> C0114.bootstrap<"call",0,1>().openScreen(new C0173(this, (C0268)this.m_e6e11032()))
                  )
                  .m_dc08502f(this::m_3c15851a)
            )
      };
   }
}
