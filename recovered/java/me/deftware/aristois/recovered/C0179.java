package me.deftware.aristois.recovered;

import java.util.List;
import me.deftware.client.framework.config.Settings;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;

public class C0179 extends C0150 {
   public static final String f_f7e9a617 = C0252.bootstrap<"get",21474836505>();

   public C0179(GenericScreen var1) {
      super(var1);
   }

   protected void m_e7e696bb() {
      List var1 = C0114.bootstrap<"call",1,1>(
         new Message[]{
            C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836496>()),
            C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836497>()),
            C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836498>()),
            C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836499>()),
            C0197.f_716a73fa,
            C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836500>()),
            C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836501>()),
            C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836502>())
         }
      );
      int var2 = C0114.bootstrap<"call",2,1>() / 2;
      int var3 = 65;

      for (Message var5 : var1) {
         this.addCenteredText(var2, var3, var5);
         var3 += C0114.bootstrap<"call",3,1>();
      }

      this.addCenteredText(var2, 30, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836503>()).style(C0114.bootstrap<"call",4,1>(DefaultColors.RED)));
      Message var9 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836504>());
      C0152 var10 = new C0152(var2, var3 + 15, 20, 20, false);
      var10.m_044b304a(var9);
      int var6 = 25 + C0114.bootstrap<"call",5,1>(var9);
      var10.m_a702859f().m_6894765d((double)var2 - (double)var6 / 2.0);
      this.m_6de9afa2(new C0163[]{var10});
      byte var7 = 90;
      int var8 = var3 + 40;
      this.m_6de9afa2(
         new C0163[]{
            this.m_2dec7c9d(var2 - var7 - 2, var8, (float)var7, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869310>()), this::goBack),
            this.m_2dec7c9d(var2 + 2, var8, (float)var7, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4>()), () -> {
               Settings var1x = C0114.bootstrap<"call",0,1>();
               var1x.putPrimitive(C0252.bootstrap<"get",21474836505>(), true);
               var1x.save();
               C0114.bootstrap<"call",1,1>().openScreen(new C0180(this.parent));
            }).m_dc08502f(var10::m_d4a52db6)
         }
      );
   }
}
