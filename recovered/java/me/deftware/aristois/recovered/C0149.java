package me.deftware.aristois.recovered;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import me.deftware.aristois.main.Main;
import me.deftware.aristois.marketplace.Marketplace;
import me.deftware.aristois.marketplace.MarketplaceMod;
import me.deftware.client.framework.FrameworkConstants;
import me.deftware.client.framework.FrameworkConstants.MappingsLoader;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0149 extends Marketplace {
   public static final C0149 f_9e30b55f = new C0149();
   private static final Message f_98c0502e = Message.of(
      C0267.m_1d87ef21() + Minecraft.getMinecraftVersion() + C0261.m_6e2d03c3() + FrameworkConstants.MAPPING_LOADER.name()
   );

   private C0149() {
      if (Main.getConfig().hasKey(C0267.m_35cdaa1a())) {
         this.url = Main.getConfig().getPrimitive(C0267.m_35cdaa1a(), null);
         this.logger.warn(C0267.m_624b40d8(), new Object[]{this.url});
      }
   }

   public void m_1058ed9a() {
      final Message var1 = Message.of(String.join(C0257.m_593ecbab(), Arrays.copyOfRange(this.updated.split(C0257.m_593ecbab()), 1, 4)));
      Minecraft.getMinecraftGame()
         .openScreen(
            (new C0174<MarketplaceMod>(Minecraft.getMinecraftGame().getScreen(), f_9e30b55f.getModMap(), MarketplaceMod.class, C0267.m_8d7dbe31()) {
                  private boolean f_e3e64d22 = false;

                  @Override
                  protected void m_1058ed9a() {
                     this.m_d6ac7420(true);
                     super.m_1058ed9a();
                     byte var1x = 60;
                     C0154 var2 = new C0154(this.getGuiScreenWidth() - var1x - 12, this.f_cb8ccdd5 / 2 - 10, var1x, 20, Message.of(C0254.m_37c08c9d())) {
                        @Override
                        public boolean m_1521b1fa(int var1x) {
                           String var2 = MarketplaceMod.fabricModPath.toUri().toString();
                           if (FrameworkConstants.MAPPING_LOADER != MappingsLoader.Fabric) {
                              var2 = MarketplaceMod.modPath.toUri().toString();
                           }

                           Keyboard.openLink(var2);
                           return true;
                        }
                     };
                     this.m_4f7d4126(new C0163[]{var2});
                  }

                  @Override
                  protected void onDraw(int var1x, int var2, float var3) {
                     super.onDraw(var1x, var2, var3);
                     if (C0149.this.modMap.isEmpty()) {
                        FontRenderer.drawCenteredString(C0149.f_98c0502e, this.getGuiScreenWidth() / 2, 50, 16777215);
                     }

                     int var4 = this.f_cb8ccdd5 / 2 - FontRenderer.getFontHeight() / 2;
                     FontRenderer.drawStringWithShadow(var1, var4, var4, 16777215);
                  }

                  @Override
                  protected C0155[] m_da527608() {
                     byte var1x = 95;
                     return new C0155[]{
                        new C0155((float)var1x, this)
                           .m_2ee4da8d(
                              this.m_79273652(
                                    0,
                                    0,
                                    (float)var1x,
                                    Message.of(C0254.m_1472ab32()),
                                    () -> Minecraft.getMinecraftGame()
                                          .openScreen(
                                             new C0195(this, this.m_cee5fd5a().getDescription().stream().<Message>map(Message::of).collect(Collectors.toList()))
                                          )
                                 )
                                 .m_798462fc(this::m_51ce03a5),
                              this.m_5a1fbc03(
                                    0,
                                    0,
                                    (float)var1x,
                                    Message.of(C0254.m_a5b24d28()),
                                    var1xxx -> {
                                       MarketplaceMod var2 = this.m_cee5fd5a();
                                       if (var2.isBeta()) {
                                          Minecraft.getMinecraftGame()
                                             .openScreen(
                                                new C0169(
                                                   this,
                                                   new Message[]{
                                                      new Builder()
                                                         .append(C0254.m_0d6ae39b(), Appearance.of(2, DefaultColors.RED))
                                                         .append(C0254.m_65d43991(), Appearance.of(DefaultColors.RED))
                                                         .append(C0254.m_c6614274(), Appearance.of(8, DefaultColors.RED))
                                                         .append(C0267.m_44418b5d(), Appearance.of(DefaultColors.RED))
                                                         .build(),
                                                      C0197.f_9607505d,
                                                      Message.of(var2.getName() + C0267.m_813e3509()),
                                                      Message.of(C0267.m_3855be80()),
                                                      Message.of(C0267.m_a9247108()),
                                                      C0197.f_9607505d,
                                                      Message.of(C0267.m_4626ac74()),
                                                      Message.of(C0267.m_c688f8ca()).style(Appearance.of(DefaultColors.RED))
                                                   }
                                                ) {
                                                   @Override
                                                   public void m_f1ec3ae8() {
                                                      m_a7d21cc3(m_cee5fd5a(), var1xxx);
                                                   }
                                                }
                                             );
                                       } else {
                                          this.m_a7d21cc3(this.m_cee5fd5a(), var1xxx);
                                       }
                                    }
                                 )
                                 .m_798462fc(() -> this.m_51ce03a5() && !this.m_cee5fd5a().isInstalled()),
                              this.m_5a1fbc03(0, 0, (float)var1x, Message.of(C0254.m_a9b6ecd9()), var1xxx -> {
                                 var1xxx.m_b1b94a23().setComponentLabel(Message.of(C0254.m_83f6dd00()).style(Appearance.of(DefaultColors.GOLD)));
                                 if (!this.m_cee5fd5a().uninstall()) {
                                    var1xxx.m_b1b94a23().setComponentLabel(Message.of(C0254.m_56c1229f()).style(Appearance.of(DefaultColors.RED)));
                                 } else {
                                    var1xxx.m_b1b94a23().setComponentLabel(Message.of(C0254.m_a9b6ecd9()));
                                 }
                              }).m_798462fc(() -> this.m_51ce03a5() && this.m_cee5fd5a().isInstalled()),
                              this.m_79273652(0, 0, (float)var1x, Message.of(C0257.m_c42f1c7e()), this::goBack)
                           )
                     };
                  }

                  private void m_a7d21cc3(MarketplaceMod var1x, C0154 var2) {
                     ArrayList var3 = var1x.getConflicts();
                     if (var3 != null && !var3.isEmpty()) {
                        for (String var5 : var3) {
                           if (C0149.f_9e30b55f.isInstalled(var5)) {
                              Minecraft.getMinecraftGame()
                                 .openScreen(
                                    new C0195(
                                       Minecraft.getMinecraftGame().getScreen(),
                                       Arrays.asList(
                                          Message.of(C0254.m_09052c0b()).style(Appearance.of(DefaultColors.RED)),
                                          C0197.f_9607505d,
                                          Message.of(C0254.m_023b99d9() + var1x.getName() + C0254.m_733bff3d()),
                                          Message.of(C0254.m_76700429() + var5)
                                       )
                                    )
                                 );
                              return;
                           }
                        }
                     }

                     this.f_e3e64d22 = false;
                     ArrayList var6 = new ArrayList<>(
                        Arrays.asList(Message.of(C0254.m_8870d2c1() + var1x.getName() + C0254.m_a004d745()), Message.of(C0254.m_3c19a819()))
                     );
                     C0195 var7 = new C0195(this, var6) {
                        @Override
                        protected void m_1058ed9a() {
                           super.m_1058ed9a();
                           this.m_ef9bc8d5().setActive(f_e3e64d22);
                        }
                     };
                     Minecraft.getMinecraftGame().openScreen(var7);
                     C0217.m_124336d4(100L, () -> C0217.m_c162d659(() -> {
                           try {
                              var1x.install();
                              var6.set(0, Message.of(C0254.m_f599ae93() + var1x.getName() + C0254.m_5b2d5cb2()));
                           } catch (Exception var5x) {
                              var1x.getLogger().error(C0254.m_56cd5284(), var5x);
                              var6.set(0, Message.of(C0254.m_62895921() + var1x.getName() + C0257.m_2e834348()));
                              var6.set(1, C0197.f_9607505d);
                              var6.add(Message.of(C0254.m_ec4ef19a()));
                              var6.add(Message.of(var5x.getMessage()));
                           }

                           var7.m_ef9bc8d5().setActive(this.f_e3e64d22 = true);
                        }));
                  }
               })
               .m_91e3b8ed(false)
         );
   }
}
