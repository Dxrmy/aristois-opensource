package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.batching.QuadRenderStack;

public class C0052 extends C0150 {
   private final QuadRenderStack f_c6c0ad36 = (QuadRenderStack)new QuadRenderStack().setScaled(false);

   public C0052(GenericScreen var1) {
      super(var1);
   }

   protected void m_5496ccc8() {
      this.m_3cf03cc2(
         C0114.bootstrap<"call",0,1>() / 2,
         C0114.bootstrap<"call",1,1>() - 60,
         new Message[]{
            C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",1>()).style(C0114.bootstrap<"call",3,1>(DefaultColors.GRAY)),
            C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",2>()).style(C0114.bootstrap<"call",3,1>(DefaultColors.GRAY)),
            C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",3>()).style(C0114.bootstrap<"call",3,1>(DefaultColors.GRAY))
         }
      );
      byte var1 = 70;
      this.m_1dbfc94c(
         new C0163[]{
            this.m_2403502d(
               C0114.bootstrap<"call",0,1>() / 2 - var1 - 2,
               C0114.bootstrap<"call",1,1>() - 90,
               (float)var1,
               C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",4>()),
               () -> {
                  C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>());
                  C0114.bootstrap<"call",2,1>().openScreen(new C0051(this));
               }
            ),
            this.m_3acc2633(
               C0114.bootstrap<"call",0,1>() / 2 + 2,
               C0114.bootstrap<"call",1,1>() - 90,
               (float)var1,
               C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",5>()),
               var1x -> {
                  if (C0241.f_7826e715) {
                     C0114.bootstrap<"call",4,1>(this);
                  } else {
                     ((Button)var1x.m_8f596680()
                           .setComponentLabel(C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",7>()).style(C0114.bootstrap<"call",3,1>(DefaultColors.RED))))
                        .resetToAfter(1500, C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",5>()));
                  }
               }
            ),
            this.m_2403502d(10, 10, 60.0F, C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",6>()), this::goBack)
         }
      );
   }

   @Override
   protected void onDraw(int var1, int var2, float var3) {
      super.onDraw(var1, var2, var3);
      byte var4 = 40;
      byte var5 = 3;
      int var6 = 2 * var4 + var5;
      int var7 = C0114.bootstrap<"call",0,1>() / 2 - var6 / 2;
      byte var8 = 20;
      C0114.bootstrap<"call",1,1>(this.f_c6c0ad36, var7, var8, var4);
   }

   public static void m_27d11fc7(QuadRenderStack var0, int var1, int var2, int var3) {
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
