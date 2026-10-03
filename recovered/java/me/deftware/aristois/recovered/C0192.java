package me.deftware.aristois.recovered;

import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.texture.GlTexture;
import me.deftware.client.framework.util.types.Pair;

public class C0192 extends GuiScreen {
   public static final C0192 f_43508b36 = new C0192(C0228.f_3c443669, null)
      .m_df3d0404(C0267.m_9793dfe2(), () -> Keyboard.openLink(C0146.f_36f829be + C0267.m_15ef1a0d()))
      .m_a12ba90d()
      .m_1d66a9ba(5);
   public static final C0192 f_5cc08e88 = new C0192(C0228.f_15fce25d, null)
      .m_df3d0404(C0267.m_1635bc47(), () -> Keyboard.openLink(C0146.f_36f829be + C0267.m_8ced16bd()))
      .m_a12ba90d()
      .m_1d66a9ba(5);
   private boolean f_7a9d2cba = true;
   private Pair<String, Runnable> f_d6d7b5b7;
   private final Runnable f_798845eb;
   private int f_197458d7 = 0;
   private Button f_eb88ae28;

   public C0192(GlTexture var1, Runnable var2) {
      this.f_798845eb = var2;
      this.setBackgroundType(var1);
   }

   public C0192 m_a12ba90d() {
      this.f_7a9d2cba = false;
      return this;
   }

   public C0192 m_1d66a9ba(int var1) {
      this.f_197458d7 = var1 * 20;
      return this;
   }

   public C0192 m_df3d0404(String var1, Runnable var2) {
      this.f_d6d7b5b7 = new Pair(var1, var2);
      return this;
   }

   public void m_b728afce() {
      Minecraft.getMinecraftGame().openScreen(this);
   }

   protected boolean goBack() {
      return !this.f_7a9d2cba ? true : super.goBack();
   }

   protected void onInitGui() {
      Message var1 = Message.of(C0267.m_c42f1c7e());
      this.addComponent(
         this.f_eb88ae28 = (new C0154(this.getGuiScreenWidth() - FontRenderer.getStringWidth(var1) - 25, 10, FontRenderer.getStringWidth(var1) + 15, 20, var1) {
               @Override
               public boolean m_1521b1fa(int var1) {
                  if (C0192.this.f_798845eb != null) {
                     C0192.this.f_798845eb.run();
                  } else {
                     C0192.super.goBack();
                  }

                  return true;
               }
            })
            .m_b1b94a23()
      );
      if (this.f_d6d7b5b7 != null) {
         var1 = Message.of((String)this.f_d6d7b5b7.getLeft());
         this.addComponent(new C0154(10, 10, FontRenderer.getStringWidth(var1) + 15, 20, var1) {
            @Override
            public boolean m_1521b1fa(int var1) {
               ((Runnable)C0192.this.f_d6d7b5b7.getRight()).run();
               return true;
            }
         });
      }
   }

   protected void onDraw(int var1, int var2, float var3) {
   }

   protected void onUpdate() {
      if (this.f_197458d7 > 0) {
         this.f_197458d7--;
         this.f_eb88ae28.setComponentLabel(Message.of(C0267.m_6f1f396d() + this.f_197458d7 / 20 + C0257.m_9e27f038()));
         this.f_eb88ae28.setActive(false);
      } else {
         this.f_eb88ae28.setComponentLabel(Message.of(C0257.m_4626ac74()));
         this.f_eb88ae28.setActive(true);
      }
   }
}
