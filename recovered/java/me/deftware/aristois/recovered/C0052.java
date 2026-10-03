package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.QuadRenderStack;

public class C0052 extends C0150 {
   private final QuadRenderStack f_8fb8aa08 = (QuadRenderStack)new QuadRenderStack().setScaled(false);

   public C0052(GenericScreen var1) {
      super(var1);
   }

   @Override
   protected void m_1058ed9a() {
      this.m_ba846326(
         getScaledWidth() / 2,
         getScaledHeight() - 60,
         new Message[]{
            Message.of(C0257.m_813e3509()).style(Appearance.of(DefaultColors.GRAY)),
            Message.of(C0257.m_3855be80()).style(Appearance.of(DefaultColors.GRAY)),
            Message.of(C0257.m_a9247108()).style(Appearance.of(DefaultColors.GRAY))
         }
      );
      byte var1 = 70;
      this.m_4f7d4126(
         new C0163[]{
            this.m_79273652(getScaledWidth() / 2 - var1 - 2, getScaledHeight() - 90, (float)var1, Message.of(C0257.m_4626ac74()), () -> {
               Keyboard.openLink(C0050.m_c688f8ca());
               Minecraft.getMinecraftGame().openScreen(new C0051(this));
            }),
            this.m_5a1fbc03(
               getScaledWidth() / 2 + 2,
               getScaledHeight() - 90,
               (float)var1,
               Message.of(C0257.m_c688f8ca()),
               var1x -> {
                  if (C0241.f_f6e3d33b) {
                     C0053.m_a4e18580(this);
                  } else {
                     ((Button)var1x.m_b1b94a23().setComponentLabel(Message.of(C0257.m_624b40d8()).style(Appearance.of(DefaultColors.RED))))
                        .resetToAfter(1500, Message.of(C0257.m_c688f8ca()));
                  }
               }
            ),
            this.m_79273652(10, 10, 60.0F, Message.of(C0257.m_35cdaa1a()), this::goBack)
         }
      );
   }

   @Override
   protected void onDraw(int var1, int var2, float var3) {
      super.onDraw(var1, var2, var3);
      byte var4 = 40;
      byte var5 = 3;
      int var6 = 2 * var4 + var5;
      int var7 = getScaledWidth() / 2 - var6 / 2;
      byte var8 = 20;
      m_a5827fbf(this.f_8fb8aa08, var7, var8, var4);
   }

   public static void m_a5827fbf(QuadRenderStack var0, int var1, int var2, int var3) {
      byte var4 = 3;
      ((QuadRenderStack)((QuadRenderStack)((QuadRenderStack)((QuadRenderStack)var0.begin().glColor(new Color(255, 79, 24)))
                  .drawRect((float)var1, (float)var2, (float)(var1 + var3), (float)(var2 + var3))
                  .glColor(new Color(90, 187, 0)))
               .drawRect((float)(var1 + var3 + var4), (float)var2, (float)(var1 + var3 + var4 + var3), (float)(var2 + var3))
               .glColor(new Color(0, 165, 242)))
            .drawRect((float)var1, (float)(var2 + var3 + var4), (float)(var1 + var3), (float)(var2 + var3 + var4 + var3))
            .glColor(new Color(255, 186, 0)))
         .drawRect((float)(var1 + var3 + var4), (float)(var2 + var3 + var4), (float)(var1 + var3 + var4 + var3), (float)(var2 + var3 + var4 + var3))
         .end();
   }
}
