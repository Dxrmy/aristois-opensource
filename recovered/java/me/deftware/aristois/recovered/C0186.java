package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.main.MainEntityPlayer;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.message.DefaultColors;

public class C0186 extends C0188<C0244> {
   public C0186(GenericScreen var1) {
      super(var1, C0114.bootstrap<"call",0,1>());
   }

   protected void m_1f248ae1() {
      this.f_15c98010 = C0252.bootstrap<"get",21474836556>();
      this.f_70753c20 = 400;
      this.m_a2901b5b(true);
      super.m_295487ee();
   }

   protected C0155[] m_e341e464() {
      byte var1 = 95;
      short var2 = 130;
      C0154 var3;
      C0155[] var4 = new C0155[]{
         new C0155((float)var1, this)
            .m_5d3ed1f2(
               this.m_f3c7c9fd(0, 0, (float)var1, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836558>()), () -> new C0185(this)),
               this.m_f8cdafdd(0, 0, (float)var1, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836559>()), this::m_e0dbe97c)
                  .m_dc08502f(this::m_3c15851a),
               this.m_f3c7c9fd(
                     0, 0, (float)var1, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836560>()), () -> new C0187(this, (C0244)this.m_770b561d())
                  )
                  .m_dc08502f(this::m_3c15851a),
               this.m_1bd28ba2(0, 0, (float)var1, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",10>()), this::goBack)
            ),
         new C0155((float)var2, this)
            .m_5d3ed1f2(
               this.m_f8cdafdd(
                     0,
                     0,
                     (float)var2,
                     C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836583>()),
                     var1x -> {
                        C0114.bootstrap<"call",0,1>(((C0244)this.m_770b561d()).m_025af698());
                        ((Button)var1x.m_8f596680().setComponentLabel(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836577>())))
                           .resetToAfter(2000, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836583>()));
                     }
                  )
                  .m_dc08502f(this::m_3c15851a),
               this.m_f8cdafdd(
                     0,
                     0,
                     (float)var2,
                     C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836584>()),
                     var1x -> {
                        ((C0244)this.m_770b561d()).m_9d941243(!((C0244)this.m_770b561d()).m_1cfee894());
                        boolean var2x = ((C0244)this.m_770b561d()).m_1cfee894();
                        ((Button)var1x.m_8f596680()
                              .setComponentLabel(
                                 C0114.bootstrap<"call",0,1>(var2x ? C0252.bootstrap<"get",12884901927>() : C0252.bootstrap<"get",12884901928>())
                                    .style(C0114.bootstrap<"call",1,1>(var2x ? DefaultColors.GREEN : DefaultColors.RED))
                              ))
                           .resetToAfter(2000, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836584>()));
                     }
                  )
                  .m_dc08502f(this::m_3c15851a),
               var3 = this.m_f8cdafdd(
                     0,
                     0,
                     (float)var2,
                     C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836585>()),
                     var1x -> {
                        MainEntityPlayer var2x = C0114.bootstrap<"call",0,1>()._getPlayer();
                        String var3x = "";
                        if (var2x == null) {
                           var3x = C0252.bootstrap<"get",21474836575>();
                        } else {
                           var2x.sendMessage(
                              C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",21474836587>(), new Object[]{((C0244)this.m_770b561d()).m_025af698()}),
                              this.getClass()
                           );
                           var3x = C0252.bootstrap<"get",21474836588>();
                        }

                        ((Button)var1x.m_8f596680().setComponentLabel(C0114.bootstrap<"call",2,1>(var3x)))
                           .resetToAfter(2000, C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",21474836585>()));
                     }
                  )
                  .m_dc08502f(this::m_3c15851a)
            )
      };
      var3.m_ca06ea23(new C0153(var3, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836586>())));
      return var4;
   }
}
