package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.GuiScreen.BackgroundType;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;

public class C0190 extends GuiScreen {
   private final C0245 f_8452f136;
   private int f_db752a74 = -1;

   public C0190(C0245 var1, GenericScreen var2) {
      super(var2);
      this.setBackgroundType(BackgroundType.TexturedOrTransparent);
      this.f_8452f136 = var1;
   }

   protected void onInitGui() {
      this.addCenteredText(
         this.getGuiScreenWidth() / 2,
         this.getGuiScreenHeight() / 2 - C0114.bootstrap<"call",0,1>() / 2,
         C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",25769803792>())
      );
      this.addCenteredText(
         this.getGuiScreenWidth() / 2,
         this.getGuiScreenHeight() / 2 - C0114.bootstrap<"call",0,1>() / 2 + C0114.bootstrap<"call",0,1>() + 5,
         C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",25769803793>() + this.f_8452f136.toString())
      );
      this.addCenteredText(
         this.getGuiScreenWidth() / 2,
         this.getGuiScreenHeight() / 2
            - C0114.bootstrap<"call",0,1>() / 2
            + C0114.bootstrap<"call",0,1>()
            + 5
            + C0114.bootstrap<"call",0,1>()
            + 5
            + C0114.bootstrap<"call",0,1>()
            + 5,
         C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",25769803794>())
      );
   }

   protected void onDraw(int var1, int var2, float var3) {
   }

   private void m_53a01a73(int var1, int var2, int var3) {
      if (var1 != 256 && var1 != -1) {
         if (var1 == 259) {
            this.f_8452f136.m_fce13178();
            C0114.bootstrap<"call",0,1>().m_6b4e8235(C0252.bootstrap<"get",25769803795>()).m_77a7bc18(C0252.bootstrap<"get",12884901932>()).m_66e721c0();
         } else {
            this.f_8452f136.m_3500412e(var1);
            this.f_8452f136.m_4adc9538(var3);
            Message var4 = new Builder()
               .append(C0252.bootstrap<"get",25769803796>(), C0114.bootstrap<"call",1,1>(DefaultColors.GRAY))
               .append(this.f_8452f136.toString(), C0114.bootstrap<"call",1,1>(DefaultColors.YELLOW))
               .build();
            C0114.bootstrap<"call",0,1>().m_6b4e8235(C0252.bootstrap<"get",25769803795>()).m_b7d6d46c(var4).m_66e721c0();
         }

         this.goBack();
      }
   }

   protected boolean onKeyPressed(int var1, int var2, int var3) {
      this.f_db752a74 = var1;
      return true;
   }

   protected boolean onKeyReleased(int var1, int var2, int var3) {
      if (this.f_db752a74 == var1) {
         this.m_53a01a73(var1, var2, var3);
      }

      return true;
   }

   protected boolean onMouseClicked(int var1, int var2, int var3) {
      this.m_53a01a73(var3, 0, C0114.bootstrap<"call",0,1>());
      return true;
   }

   public static int m_e4d12408() {
      byte var0 = 0;
      if (C0114.bootstrap<"call",2,1>()) {
         var0 = 2;
      } else if (C0114.bootstrap<"call",3,1>()) {
         var0 = 1;
      }

      return var0;
   }
}
