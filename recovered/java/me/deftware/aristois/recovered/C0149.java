package me.deftware.aristois.recovered;

import java.util.ArrayList;
import me.deftware.aristois.marketplace.Marketplace;
import me.deftware.aristois.marketplace.MarketplaceMod;
import me.deftware.client.framework.FrameworkConstants;
import me.deftware.client.framework.FrameworkConstants.MappingsLoader;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;

public class C0149 extends Marketplace {
   public static final C0149 f_27db095d = new C0149();
   private static final Message f_2833aa25 = C0114.bootstrap<"call",1,1>(
      C0252.bootstrap<"get",25769803785>() + C0114.bootstrap<"call",0,1>() + C0252.bootstrap<"get",17179869228>() + FrameworkConstants.MAPPING_LOADER.name()
   );

   private C0149() {
      if (C0114.bootstrap<"call",0,1>().hasKey(C0252.bootstrap<"get",25769803782>())) {
         this.url = C0114.bootstrap<"call",0,1>().getPrimitive(C0252.bootstrap<"get",25769803782>(), null);
         this.logger.warn(C0252.bootstrap<"get",25769803783>(), new Object[]{this.url});
      }
   }

   public void m_48c6b1ee() {
      final Message var1 = C0114.bootstrap<"call",2,1>(
         C0114.bootstrap<"call",1,1>(
            C0252.bootstrap<"get",70>(), (CharSequence[])C0114.bootstrap<"call",0,1>(this.updated.split(C0252.bootstrap<"get",70>()), 1, 4)
         )
      );
      C0114.bootstrap<"call",3,1>()
         .openScreen(
            (new C0174<MarketplaceMod>(
                  C0114.bootstrap<"call",3,1>().getScreen(), f_27db095d.getModMap(), MarketplaceMod.class, C0252.bootstrap<"get",25769803784>()
               ) {
                  private boolean f_880d36a0 = false;

                  protected void m_e361f9eb() {
                     this.m_2b9133cb(true);
                     super.m_4a76dabf();
                     byte var1x = 60;
                     C0154 var2 = new C0154(
                        this.getGuiScreenWidth() - var1x - 12,
                        this.f_fe6b7f44 / 2 - 10,
                        var1x,
                        20,
                        C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836589>())
                     ) {
                        public boolean m_afe6e4e0(int var1x) {
                           String var2 = MarketplaceMod.fabricModPath.toUri().toString();
                           if (FrameworkConstants.MAPPING_LOADER != MappingsLoader.Fabric) {
                              var2 = MarketplaceMod.modPath.toUri().toString();
                           }

                           C0114.bootstrap<"call",0,1>(var2);
                           return true;
                        }
                     };
                     this.m_f2bd9ecc(new C0163[]{var2});
                  }

                  @Override
                  protected void onDraw(int var1x, int var2, float var3) {
                     super.onDraw(var1x, var2, var3);
                     if (C0114.bootstrap<"call",0,1>(C0149.this).isEmpty()) {
                        C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(), this.getGuiScreenWidth() / 2, 50, 16777215);
                     }

                     int var4 = this.f_fe6b7f44 / 2 - C0114.bootstrap<"call",3,1>() / 2;
                     C0114.bootstrap<"call",4,1>(var1, var4, var4, 16777215);
                  }

                  protected C0155[] m_23139303() {
                     byte var1x = 95;
                     return new C0155[]{
                        new C0155((float)var1x, this)
                           .m_5d3ed1f2(
                              this.m_5db34d11(
                                    0,
                                    0,
                                    (float)var1x,
                                    C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836590>()),
                                    () -> C0114.bootstrap<"call",0,1>()
                                          .openScreen(
                                             new C0195(
                                                this,
                                                ((MarketplaceMod)this.m_c714ea8e())
                                                   .getDescription()
                                                   .stream()
                                                   .map(Message::of)
                                                   .collect(C0114.bootstrap<"call",1,1>())
                                             )
                                          )
                                 )
                                 .m_dc08502f(this::m_3c15851a),
                              this.m_1d8035f6(
                                    0,
                                    0,
                                    (float)var1x,
                                    C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836591>()),
                                    var1xxx -> {
                                       MarketplaceMod var2 = (MarketplaceMod)this.m_c714ea8e();
                                       if (var2.isBeta()) {
                                          C0114.bootstrap<"call",1,1>()
                                             .openScreen(
                                                new C0169(
                                                   this,
                                                   new Message[]{
                                                      new Builder()
                                                         .append(C0252.bootstrap<"get",21474836607>(), C0114.bootstrap<"call",2,1>(2, DefaultColors.RED))
                                                         .append(C0252.bootstrap<"get",21474836608>(), C0114.bootstrap<"call",3,1>(DefaultColors.RED))
                                                         .append(C0252.bootstrap<"get",21474836609>(), C0114.bootstrap<"call",2,1>(8, DefaultColors.RED))
                                                         .append(C0252.bootstrap<"get",25769803776>(), C0114.bootstrap<"call",3,1>(DefaultColors.RED))
                                                         .build(),
                                                      C0197.f_716a73fa,
                                                      C0114.bootstrap<"call",0,1>(var2.getName() + C0252.bootstrap<"get",25769803777>()),
                                                      C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803778>()),
                                                      C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803779>()),
                                                      C0197.f_716a73fa,
                                                      C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803780>()),
                                                      C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803781>())
                                                         .style(C0114.bootstrap<"call",3,1>(DefaultColors.RED))
                                                   }
                                                ) {
                                                   public void m_7ec3ea3f() {
                                                      C0114.bootstrap<"call",0,1>(<VAR_NAMELESS_ENCLOSURE>, (MarketplaceMod)m_c714ea8e(), var1xxx);
                                                   }
                                                }
                                             );
                                       } else {
                                          this.m_a8ad36b5((MarketplaceMod)this.m_c714ea8e(), var1xxx);
                                       }
                                    }
                                 )
                                 .m_dc08502f(() -> C0114.bootstrap<"call",0,1>(this.m_3fc88839() && !((MarketplaceMod)this.m_c714ea8e()).isInstalled())),
                              this.m_1d8035f6(
                                    0,
                                    0,
                                    (float)var1x,
                                    C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836592>()),
                                    var1xxx -> {
                                       var1xxx.m_8f596680()
                                          .setComponentLabel(
                                             C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836605>())
                                                .style(C0114.bootstrap<"call",2,1>(DefaultColors.GOLD))
                                          );
                                       if (!((MarketplaceMod)this.m_c714ea8e()).uninstall()) {
                                          var1xxx.m_8f596680()
                                             .setComponentLabel(
                                                C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836606>())
                                                   .style(C0114.bootstrap<"call",2,1>(DefaultColors.RED))
                                             );
                                       } else {
                                          var1xxx.m_8f596680().setComponentLabel(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836592>()));
                                       }
                                    }
                                 )
                                 .m_dc08502f(() -> C0114.bootstrap<"call",0,1>(this.m_3fc88839() && ((MarketplaceMod)this.m_c714ea8e()).isInstalled())),
                              this.m_5db34d11(0, 0, (float)var1x, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",10>()), this::goBack)
                           )
                     };
                  }

                  private void m_a8ad36b5(MarketplaceMod var1x, C0154 var2) {
                     ArrayList var3 = var1x.getConflicts();
                     if (var3 != null && !var3.isEmpty()) {
                        for (String var5 : var3) {
                           if (C0149.f_27db095d.isInstalled(var5)) {
                              C0114.bootstrap<"call",1,1>()
                                 .openScreen(
                                    new C0195(
                                       C0114.bootstrap<"call",1,1>().getScreen(),
                                       C0114.bootstrap<"call",3,1>(
                                          new Message[]{
                                             C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836593>())
                                                .style(C0114.bootstrap<"call",2,1>(DefaultColors.RED)),
                                             C0197.f_716a73fa,
                                             C0114.bootstrap<"call",0,1>(
                                                C0252.bootstrap<"get",21474836594>() + var1x.getName() + C0252.bootstrap<"get",21474836595>()
                                             ),
                                             C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836596>() + var5)
                                          }
                                       )
                                    )
                                 );
                              return;
                           }
                        }
                     }

                     this.f_880d36a0 = false;
                     ArrayList var6 = new ArrayList(
                        C0114.bootstrap<"call",3,1>(
                           new Message[]{
                              C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836597>() + var1x.getName() + C0252.bootstrap<"get",21474836598>()),
                              C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836599>())
                           }
                        )
                     );
                     C0195 var7 = new C0195(this, var6) {
                        protected void m_33956d7f() {
                           super.m_cee889d9();
                           this.m_4024436c().setActive(C0114.bootstrap<"call",0,1>(<VAR_NAMELESS_ENCLOSURE>));
                        }
                     };
                     C0114.bootstrap<"call",1,1>().openScreen(var7);
                     C0114.bootstrap<"call",4,1>(100L, () -> C0114.bootstrap<"call",5,1>(() -> {
                           try {
                              var1x.install();
                              var6.set(
                                 0, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836600>() + var1x.getName() + C0252.bootstrap<"get",21474836601>())
                              );
                           } catch (Exception var5x) {
                              var1x.getLogger().error(C0252.bootstrap<"get",21474836602>(), var5x);
                              var6.set(0, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836603>() + var1x.getName() + C0252.bootstrap<"get",24>()));
                              var6.set(1, C0197.f_716a73fa);
                              var6.add(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836604>()));
                              var6.add(C0114.bootstrap<"call",0,1>(var5x.getMessage()));
                           }

                           var7.m_e0c5a994().setActive(this.f_880d36a0 = true);
                        }));
                  }
               })
               .m_b9549c7e(false)
         );
   }
}
