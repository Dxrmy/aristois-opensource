package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.deftware.aristois.menu.view.RectTooltip;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.view.container.ContextMenu;
import me.deftware.aristois.menu.view.list.ListWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.aristois.menu.widgets.ModButton;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

public class C0090 {
   private final C0441 f_7706a68b;
   private final boolean f_589a4b16;
   private boolean f_e79d2cfd = false;
   private final List<Class<? extends AbstractMod>> f_7ce0ab60 = new ArrayList<>();
   private C0440 f_52ece064 = null;

   public double m_a005efae() {
      return this.f_7706a68b.m_036bd5c5() / 2.1;
   }

   public void m_d0d3b091(ContainerWidget var1, final AbstractMod var2) {
      ListWidget var3 = new ListWidget(0.0, 0.0, var1.m_44bb072f().m_4388ac29(), 0.0, this.f_7706a68b) {
         @Override
         protected boolean drawChildren(double var1, double var3, float var5, boolean var6) {
            return super.drawChildren(var1, var3, var5, !C0090.this.f_589a4b16 && var6);
         }

         @Override
         protected boolean shouldDrawChild(C0163 var1) {
            if (var1 instanceof C0428) {
               C0094 var2 = ((C0428)var1).m_42d188d9();
               if (var2 != null && !var2.m_9362a920()) {
                  return false;
               }
            }

            return super.shouldDrawChild(var1);
         }
      };
      var3.m_ec141b95(new C0426[]{C0426.f_c285454f, C0426.f_f7a0f908});
      var3.setRenderBackground(false);
      var3.setStencil(true);
      var3.setScissor(false);
      var3.m_d6ac7420(this.f_589a4b16);
      var1.m_cb54a800(var3);
      if (!var2.isSettingOnlyMod()) {
         var3.m_cb54a800(new C0163[]{C0110.m_7d393be8(null, var2.getKeybind(), this.f_589a4b16, this.f_7706a68b)});
         C0163 var4 = C0118.m_bea0fb4e(Message.of(C0266.m_8ccfdf29()), new C0105<Boolean>() {
            public Boolean m_95c71f4f() {
               return var2.isPinned();
            }

            @Override
            public void m_a32b61ee(Object var1) {
               var2.setPinned((Boolean)var1);
            }
         }, this.f_7706a68b, this.f_589a4b16);
         var4.m_c7a3618c(new RectTooltip(var4, this.f_7706a68b, Message.of(C0266.m_0223faff())));
         var3.m_cb54a800(new C0163[]{var4});
      }

      for (C0094 var5 : var2.getFields()) {
         if (var5.m_297cfef6()) {
            C0163 var6 = var5.m_a4e51be1().m_5f0a4ee5(var5, var1, this.f_589a4b16);
            if (var6 instanceof ButtonWidget) {
               ButtonWidget var7 = (ButtonWidget)var6;
               var7.m_876939c7(var5);
               if (var5.m_b3e55a9d().length != 0) {
                  var7.m_c7a3618c(new RectTooltip(var7, this.f_7706a68b, var5.m_b3e55a9d()));
               }

               var3.m_cb54a800(new C0163[]{var7});
               var7.setTextAlign(C0427.f_26bd24ae);
               if (this.f_589a4b16) {
                  var7.updatePadding(this.m_a005efae());
               }
            }
         }
      }

      for (C0163 var10 : var3.m_98dc1191()) {
         if (var10 instanceof C0443) {
            ((C0443)var10).m_d6ac7420(this.f_589a4b16);
         }
      }
   }

   public ModButton[] m_e0d7439c(C0290 var1) {
      return C0289.f_85a7343f
         .m_918b7b9e()
         .filter(var1x -> var1x.getCategory() == var1)
         .filter(var1x -> !this.f_7ce0ab60.contains(var1x.getClass()))
         .sorted((var0, var1x) -> var0.m_6f1f396d().compareToIgnoreCase(var1x.m_6f1f396d()))
         .map(this::m_7dfd7845)
         .toArray(ModButton[]::new);
   }

   public ModButton m_7dfd7845(final AbstractMod var1) {
      final ContextMenu var2 = new ContextMenu(0.0, 0.0, 200.0, 0.0, this.f_7706a68b) {
         @Override
         public boolean m_82e0832a(int var1, int var2, int var3) {
            if (!C0090.this.f_589a4b16 || var1 != 257 && var1 != 335) {
               return super.m_82e0832a(var1, var2, var3);
            } else {
               this.close();
               return true;
            }
         }
      };
      var2.setRenderShadow(true);
      var2.m_d6ac7420(this.f_589a4b16);
      ModButton var3 = new ModButton(Message.of(var1.getDisplayName()), this.f_7706a68b, var1) {
         private boolean f_a0d45117 = false;

         @Override
         protected void onClick(int var1x) {
         }

         @Override
         public boolean m_8407b1bf(double var1x, double var3, int var5) {
            if (this.f_7fd3d7b7.m_a58797d6(var1x, var3)) {
               if (var5 == 1) {
                  if (!var2.isOpen()) {
                     this.f_a0d45117 = true;
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

         @Override
         public boolean m_a2722fba(double var1x, double var3, int var5) {
            if (this.f_a0d45117 && var5 == 1) {
               this.f_a0d45117 = false;
               if (!var2.m_98dc1191().isEmpty()) {
                  var2.open(this.f_7fd3d7b7, var1x, var3, C0090.this.f_589a4b16 ? C0090.this.f_52ece064 : Minecraft.getMinecraftGame().getScreen());
                  return true;
               }
            }

            return false;
         }

         @Override
         public boolean m_828a75ae(String var1x) {
            var1x = var1x.toLowerCase();
            if (var1.getDisplayName().toLowerCase().contains(var1x)) {
               return true;
            } else {
               if (C0090.this.f_e79d2cfd) {
                  for (C0094 var3 : var1.getFields()) {
                     if (var3.m_6f1f396d().toLowerCase().contains(var1x)) {
                        return true;
                     }
                  }
               }

               return false;
            }
         }

         @Override
         protected void drawText(double var1x, double var3, Message var5) {
            Color var6 = var1.isEnabled() && !var1.isSettingOnlyMod() ? this.f_02ea293d.m_0a0c8c22() : this.f_02ea293d.m_303ad3a1();
            ((FontRenderStack)this.f_360de984.glColor(var6)).begin().drawString((int)var1x, (int)var3, var1.getDisplayName());
            if (var1.getKeybind() != null && var1.getKeybind().m_36ffc578() != -1 && C0289.m_c3a8b502(C0297.class).m_691d9b1d()) {
               String var7 = var1.getKeybind().toString();
               if (var7.length() == 1) {
                  int var8 = this.f_360de984.getStringWidth(var7);
                  ((FontRenderStack)this.f_360de984.glColor(this.f_02ea293d.m_303ad3a1()))
                     .drawString(this.f_7fd3d7b7.m_a005efae() + this.f_7fd3d7b7.m_4388ac29() - (double)var8 - 20.0, var3, var7);
               }
            }

            this.f_360de984.end();
         }
      };
      if (this.f_589a4b16) {
         var3.setTextAlign(C0427.f_26bd24ae);
         var3.updatePadding(this.m_a005efae());
      }

      var3.m_ec141b95(new C0426[]{C0426.f_c285454f});
      if (var1.getDescription() != null && var1.getDescription().length != 0) {
         var3.m_c7a3618c(new RectTooltip(var3, this.f_7706a68b, Arrays.stream(var1.getDescription()).map(Message::of).toArray(Message[]::new)));
      }

      this.m_d0d3b091(var2, var1);
      return var3;
   }

   public C0090(C0441 var1, boolean var2) {
      this.f_7706a68b = var1;
      this.f_589a4b16 = var2;
   }

   public void m_d6ac7420(boolean var1) {
      this.f_e79d2cfd = var1;
   }

   public List<Class<? extends AbstractMod>> m_ed46fa58() {
      return this.f_7ce0ab60;
   }

   public void m_8d86689a(C0440 var1) {
      this.f_52ece064 = var1;
   }
}
