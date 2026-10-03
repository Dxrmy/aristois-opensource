package me.deftware.aristois.recovered;

import java.util.List;
import java.util.concurrent.Future;
import me.deftware.client.framework.gui.ScreenRegistry;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Appearance.FormattingColor;

public class C0051 extends C0052 {
   private Message f_27b3f35a = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",8>()).style(C0114.bootstrap<"call",1,1>(DefaultColors.GOLD));
   private Message f_93e05064 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",9>()).style(C0114.bootstrap<"call",1,1>(DefaultColors.GOLD));
   private final Future<Void> f_5ba741db = C0114.bootstrap<"call",2,1>(() -> {
      C0114.bootstrap<"call",0,1>().setName(C0252.bootstrap<"get",14>());

      try {
         C0050 var1x = new C0050();
         if (!var1x.m_488b7328()) {
            throw new Exception(C0252.bootstrap<"get",15>());
         }

         this.m_2344beb6(C0252.bootstrap<"get",16>(), DefaultColors.GREEN);
         this.m_ec5841b2(C0252.bootstrap<"get",17>());
         var1x.m_65a56fc7();
         this.m_ec5841b2(C0252.bootstrap<"get",18>());
         var1x.m_2997ae9a();
         this.m_ec5841b2(C0252.bootstrap<"get",19>());
         var1x.m_00408695();
         this.m_ec5841b2(C0252.bootstrap<"get",20>());
         var1x.m_51e0bc72();
         this.m_d6ed5c22(C0252.bootstrap<"get",21>(), DefaultColors.GREEN);
         this.f_c7fee9b1 = new C0053(var1x);
         this.f_c7fee9b1.m_63d2dc9e();
         this.m_2344beb6(C0252.bootstrap<"get",22>(), DefaultColors.DARK_GREEN);
         this.m_d6ed5c22(C0252.bootstrap<"get",23>() + C0114.bootstrap<"call",1,1>() + C0252.bootstrap<"get",24>(), DefaultColors.GREEN);
         this.onInitGui();
      } catch (Exception var2) {
         var2.printStackTrace();
         this.m_2344beb6(C0252.bootstrap<"get",25>(), DefaultColors.RED);
         this.m_d6ed5c22(var2.getMessage(), DefaultColors.RED);
      }
   });
   private C0053 f_c7fee9b1;

   public C0051(GenericScreen var1) {
      super(var1);
   }

   protected void onGuiClose() {
      if (this.f_5ba741db != null && !this.f_5ba741db.isDone()) {
         this.f_5ba741db.cancel(true);
      }
   }

   private void m_ec5841b2(String var1) {
      this.m_d6ed5c22(var1, DefaultColors.GOLD);
   }

   private void m_d6ed5c22(String var1, FormattingColor var2) {
      this.f_93e05064 = C0114.bootstrap<"call",0,1>(var1).style(C0114.bootstrap<"call",1,1>(var2));
   }

   private void m_2344beb6(String var1, FormattingColor var2) {
      this.f_27b3f35a = C0114.bootstrap<"call",0,1>(var1).style(C0114.bootstrap<"call",1,1>(var2));
   }

   protected void m_878415d2() {
      this.m_b01db4f5(new C0163[]{this.m_539ccaaf(10, 10, 60.0F, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",10>()), this::goBack)});
      if (this.f_c7fee9b1 != null) {
         byte var1 = 90;
         int var2 = C0114.bootstrap<"call",2,1>() - 100;
         List var3 = C0114.bootstrap<"call",3,1>();
         this.m_b01db4f5(
            new C0163[]{
               this.m_539ccaaf(
                  C0114.bootstrap<"call",4,1>() / 2 - var1 - 2,
                  var2,
                  (float)var1,
                  C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",11>()),
                  () -> ScreenRegistry.Multiplayer.open(new Object[]{new C0193()})
               ),
               this.m_9aa47cca(
                  C0114.bootstrap<"call",4,1>() / 2 + 2,
                  var2,
                  (float)var1,
                  C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",12>()),
                  var2x -> {
                     if (C0241.f_7826e715) {
                        if (!var3.contains(this.f_c7fee9b1)) {
                           C0114.bootstrap<"call",3,1>().add(this.f_c7fee9b1);
                           C0114.bootstrap<"call",5,1>(this.parent);
                        } else {
                           var2x.m_8f596680().setComponentLabel(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",13>()));
                        }
                     } else {
                        var2x.m_8f596680()
                           .setComponentLabel(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",7>()).style(C0114.bootstrap<"call",1,1>(DefaultColors.RED)));
                     }
                  }
               )
            }
         );
      }
   }

   @Override
   protected void onDraw(int var1, int var2, float var3) {
      super.onDraw(var1, var2, var3);
      C0114.bootstrap<"call",2,1>(this.f_27b3f35a, C0114.bootstrap<"call",0,1>() / 2, C0114.bootstrap<"call",1,1>() - 60, 16777215);
      C0114.bootstrap<"call",2,1>(this.f_93e05064, C0114.bootstrap<"call",0,1>() / 2, C0114.bootstrap<"call",1,1>() - 60 + 15, 16777215);
   }
}
