package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;

public class C0182 extends GuiScreen {
   private final C0236 f_51d738d8 = C0236.f_8b0448cf;
   private C0157 f_b98f34e8;
   private Runnable f_c3e8a5df;

   public C0182(GenericScreen var1) {
      super(var1);
   }

   protected void onInitGui() {
      this.f_b98f34e8 = new C0157(this.getGuiScreenWidth() / 2 - 100, this.getGuiScreenHeight() / 2 - 25, 200, 20);
      this.f_b98f34e8.m_00c3febe()._setPasswordMode(true);
      this.addComponent(this.f_b98f34e8);
      this.addComponent(
         new C0154(this.getGuiScreenWidth() / 2 - 100, this.getGuiScreenHeight() / 2 + 50, 200, 20, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4>())) {
            public boolean m_e98cd406(int var1) {
               this.m_c556e045().setComponentLabel(C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836506>()));
               C0114.bootstrap<"call",1,1>(C0182.this)
                  .m_3cc0ac72(
                     C0114.bootstrap<"call",2,1>(C0182.this).m_55cc55cf(),
                     var1x -> {
                        if (var1x) {
                           C0114.bootstrap<"call",3,1>(C0182.this, () -> C0114.bootstrap<"call",0,1>().openScreen(new C0180(C0182.this.parent)));
                        } else {
                           this.m_c556e045()
                              .setComponentLabel(
                                 C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836507>()).style(C0114.bootstrap<"call",4,1>(DefaultColors.RED))
                              );
                        }
                     }
                  );
               return true;
            }
         }
      );
      this.addComponent(
         new C0154(this.getGuiScreenWidth() / 2 - 100, this.getGuiScreenHeight() / 2 + 75, 97, 20, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",10>())) {
            public boolean m_985de966(int var1) {
               C0114.bootstrap<"call",0,1>().openScreen(null);
               return true;
            }
         }
      );
      this.addComponent(
         new C0154(
            this.getGuiScreenWidth() / 2 + 3, this.getGuiScreenHeight() / 2 + 75, 97, 20, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836508>())
         ) {
            public boolean m_c8715e8e(int var1) {
               C0114.bootstrap<"call",0,1>().openScreen(new C0180(C0182.this.parent));
               return true;
            }
         }
      );
      Message var1 = new Builder()
         .append(C0252.bootstrap<"get",21474836482>(), C0114.bootstrap<"call",1,1>(DefaultColors.WHITE))
         .append(C0252.bootstrap<"get",21474836509>(), C0114.bootstrap<"call",1,1>(DefaultColors.GREEN))
         .build();
      this.addCenteredText(this.getGuiScreenWidth() / 2, this.getGuiScreenHeight() / 2 - 45, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",21474836510>()));
      this.addCenteredText(
         this.getGuiScreenWidth() / 2,
         35,
         new Builder().append(C0252.bootstrap<"get",21474836511>(), C0114.bootstrap<"call",1,1>(DefaultColors.GRAY)).append(var1).build()
      );
      this.addCenteredText(
         this.getGuiScreenWidth() / 2,
         this.getGuiScreenHeight() / 2 + 10,
         new Builder()
            .append(C0252.bootstrap<"get",21474836512>(), C0114.bootstrap<"call",1,1>(DefaultColors.GRAY))
            .append(var1)
            .append(C0252.bootstrap<"get",21474836513>(), C0114.bootstrap<"call",1,1>(DefaultColors.GRAY))
            .build()
      );
      this.addCenteredText(
         this.getGuiScreenWidth() / 2,
         this.getGuiScreenHeight() / 2 + 20,
         new Builder()
            .append(C0252.bootstrap<"get",21474836514>(), C0114.bootstrap<"call",1,1>(DefaultColors.GRAY))
            .append(C0252.bootstrap<"get",21474836515>(), C0114.bootstrap<"call",2,1>(8, DefaultColors.GREEN))
            .append(C0252.bootstrap<"get",21474836516>(), C0114.bootstrap<"call",1,1>(DefaultColors.GRAY))
            .build()
      );
      this.addCenteredText(
         this.getGuiScreenWidth() / 2,
         this.getGuiScreenHeight() / 2 + 30,
         new Builder()
            .append(C0252.bootstrap<"get",21474836517>(), C0114.bootstrap<"call",1,1>(DefaultColors.GRAY))
            .append(C0252.bootstrap<"get",21474836518>(), C0114.bootstrap<"call",1,1>(DefaultColors.GREEN))
            .append(C0252.bootstrap<"get",21474836519>(), C0114.bootstrap<"call",1,1>(DefaultColors.GRAY))
            .build()
      );
   }

   protected void onDraw(int var1, int var2, float var3) {
      if (this.f_c3e8a5df != null) {
         this.f_c3e8a5df.run();
         this.f_c3e8a5df = null;
      }
   }

   protected void onUpdate() {
      ((Button)this.getMinecraftScreen().getFirstOfType(Button.class))
         .setActive(this.f_b98f34e8.m_55cc55cf().length() != 0 && this.f_b98f34e8.m_55cc55cf().startsWith(C0252.bootstrap<"get",21474836520>()));
   }
}
