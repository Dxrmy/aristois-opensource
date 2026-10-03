package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import me.deftware.aristois.menu.view.RectTooltip;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.view.container.ContextMenu;
import me.deftware.aristois.menu.view.list.ListWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.aristois.menu.widgets.ModButton;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

public class C0090 {
   private final C0441 f_a1e6612a;
   private final boolean f_b7f25b7b;
   private boolean f_1901c7f3 = false;
   private final List<Class<? extends AbstractMod>> f_4b14b54d = new ArrayList<>();
   private C0440 f_3ca13007 = null;

   public double m_9492ae24() {
      return this.f_a1e6612a.m_b419df18() / 2.1;
   }

   public void m_09dc0765(ContainerWidget var1, final AbstractMod var2) {
      ListWidget var3 = new ListWidget(0.0, 0.0, var1.m_908f7f94().m_830cb294(), 0.0, this.f_a1e6612a) {
         @Override
         protected boolean drawChildren(double var1, double var3, float var5, boolean var6) {
            return super.drawChildren(var1, var3, var5, !C0114.bootstrap<"call",0,1>(C0090.this) && var6);
         }

         @Override
         protected boolean shouldDrawChild(C0163 var1) {
            if (var1 instanceof C0428) {
               C0094 var2 = ((C0428)var1).m_4aa13764();
               if (var2 != null && !var2.m_05b0bd0d()) {
                  return false;
               }
            }

            return super.shouldDrawChild(var1);
         }
      };
      var3.m_43380922(new C0426[]{C0426.f_974a55e6, C0426.f_eabcfd17});
      var3.setRenderBackground(false);
      var3.setStencil(true);
      var3.setScissor(false);
      var3.m_c71b0a3c(this.f_b7f25b7b);
      var1.m_6b141cfc(var3);
      if (!var2.isSettingOnlyMod()) {
         var3.m_2fe952ac(new C0163[]{C0114.bootstrap<"call",0,1>(null, var2.getKeybind(), this.f_b7f25b7b, this.f_a1e6612a)});
         C0163 var4 = C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901988>()), new C0105<Boolean>() {
            public Boolean m_154e0c3e() {
               return C0114.bootstrap<"call",0,1>(var2.isPinned());
            }

            public void m_1baa5030(Object var1) {
               var2.setPinned((Boolean)var1);
            }
         }, this.f_a1e6612a, this.f_b7f25b7b);
         var4.m_37cca721(new RectTooltip(var4, this.f_a1e6612a, C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",12884901989>())));
         var3.m_2fe952ac(new C0163[]{var4});
      }

      for (C0094 var5 : var2.getFields()) {
         if (var5.m_fe66bb90()) {
            C0163 var6 = var5.m_fb21cd76().m_f0b57b5f(var5, var1, this.f_b7f25b7b);
            if (var6 instanceof ButtonWidget) {
               ButtonWidget var7 = (ButtonWidget)var6;
               var7.m_41bd8aea(var5);
               if (var5.m_50eeaf3d().length != 0) {
                  var7.m_43533edf(new RectTooltip(var7, this.f_a1e6612a, var5.m_50eeaf3d()));
               }

               var3.m_2fe952ac(new C0163[]{var7});
               var7.setTextAlign(C0427.f_f7cee513);
               if (this.f_b7f25b7b) {
                  var7.updatePadding(this.m_9492ae24());
               }
            }
         }
      }

      for (C0163 var10 : var3.m_9562001a()) {
         if (var10 instanceof C0443) {
            ((C0443)var10).m_e7c602de(this.f_b7f25b7b);
         }
      }
   }

   public ModButton[] m_6f8c4366(C0290 var1) {
      return C0289.f_c22b8d7e
         .m_ea73e1f0()
         .filter(var1x -> var1x.getCategory() == var1)
         .filter(var1x -> !this.f_4b14b54d.contains(var1x.getClass()))
         .sorted((var0, var1x) -> var0.m_5aac041f().compareToIgnoreCase(var1x.m_5aac041f()))
         .map(this::m_5eca5354)
         .toArray(ModButton[]::new);
   }

   public ModButton m_5eca5354(final AbstractMod var1) {
      final ContextMenu var2 = new ContextMenu(0.0, 0.0, 200.0, 0.0, this.f_a1e6612a) {
         public boolean m_dd800b6d(int var1, int var2, int var3) {
            if (!C0114.bootstrap<"call",0,1>(C0090.this) || var1 != 257 && var1 != 335) {
               return super.m_b76ec401(var1, var2, var3);
            } else {
               this.close();
               return true;
            }
         }
      };
      var2.setRenderShadow(true);
      var2.m_532b04f4(this.f_b7f25b7b);
      ModButton var3 = new ModButton(C0114.bootstrap<"call",1,1>(var1.getDisplayName()), this.f_a1e6612a, var1) {
         private boolean f_d6374bea = false;

         @Override
         protected void onClick(int var1x) {
         }

         public boolean m_4b7fbfb0(double var1x, double var3, int var5) {
            if (this.f_fe74f89e.m_263d91ea(var1x, var3)) {
               if (var5 == 1) {
                  if (!var2.isOpen()) {
                     this.f_d6374bea = true;
                  } else {
                     var2.close();
                  }
               } else if (var5 == 0) {
                  var1.toggle();
                  this.updateLabel();
               }

               return true;
            } else {
               return false;
            }
         }

         public boolean m_c715a30e(double var1x, double var3, int var5) {
            if (this.f_d6374bea && var5 == 1) {
               this.f_d6374bea = false;
               if (!var2.m_4c2875c0().isEmpty()) {
                  var2.open(
                     this.f_fe74f89e,
                     var1x,
                     var3,
                     C0114.bootstrap<"call",0,1>(C0090.this) ? C0114.bootstrap<"call",1,1>(C0090.this) : C0114.bootstrap<"call",2,1>().getScreen()
                  );
                  return true;
               }
            }

            return false;
         }

         public boolean m_3c0689b1(String var1x) {
            var1x = var1x.toLowerCase();
            if (var1.getDisplayName().toLowerCase().contains(var1x)) {
               return true;
            } else {
               if (C0114.bootstrap<"call",3,1>(C0090.this)) {
                  for (C0094 var3 : var1.getFields()) {
                     if (var3.m_b5ae4ee3().toLowerCase().contains(var1x)) {
                        return true;
                     }
                  }
               }

               return false;
            }
         }

         @Override
         protected void drawText(double var1x, double var3, Message var5) {
            Color var6 = var1.isEnabled() && !var1.isSettingOnlyMod() ? this.f_c3bbd1bf.m_a29c6d84() : this.f_c3bbd1bf.m_3d33fc80();
            ((FontRenderStack)this.f_e42eb4df.glColor(var6)).begin().drawString((int)var1x, (int)var3, var1.getDisplayName());
            if (var1.getKeybind() != null && var1.getKeybind().m_6978c604() != -1 && ((C0297)C0114.bootstrap<"call",0,1>(C0297.class)).m_4e638610()) {
               String var7 = var1.getKeybind().toString();
               if (var7.length() == 1) {
                  int var8 = this.f_e42eb4df.getStringWidth(var7);
                  ((FontRenderStack)this.f_e42eb4df.glColor(this.f_c3bbd1bf.m_3d33fc80()))
                     .drawString(this.f_fe74f89e.m_14f8bc2c() + this.f_fe74f89e.m_830cb294() - (double)var8 - 20.0, var3, var7);
               }
            }

            this.f_e42eb4df.end();
         }
      };
      if (this.f_b7f25b7b) {
         var3.setTextAlign(C0427.f_f7cee513);
         var3.updatePadding(this.m_9492ae24());
      }

      var3.m_1b38516f(new C0426[]{C0426.f_974a55e6});
      if (var1.getDescription() != null && var1.getDescription().length != 0) {
         var3.m_447ce4e5(new RectTooltip(var3, this.f_a1e6612a, C0114.bootstrap<"call",3,1>(var1.getDescription()).map(Message::of).toArray(Message[]::new)));
      }

      this.m_09dc0765(var2, var1);
      return var3;
   }

   public C0090(C0441 var1, boolean var2) {
      this.f_a1e6612a = var1;
      this.f_b7f25b7b = var2;
   }

   public void m_ef263723(boolean var1) {
      this.f_1901c7f3 = var1;
   }

   public List<Class<? extends AbstractMod>> m_5335192e() {
      return this.f_4b14b54d;
   }

   public void m_644138ac(C0440 var1) {
      this.f_3ca13007 = var1;
   }
}
