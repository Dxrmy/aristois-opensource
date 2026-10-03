package me.deftware.aristois.recovered;

import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.gui.widgets.Button;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;

public class C0191 extends GuiScreen {
   private int f_1ad635f9 = 100;

   public C0191() {
   }

   protected boolean goBack() {
      return true;
   }

   protected void onInitGui() {
      Message var1 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803786>());
      this.addComponent(new C0154(this.getGuiScreenWidth() - C0114.bootstrap<"call",1,1>(var1) - 17, 10, C0114.bootstrap<"call",1,1>(var1) + 10, 20, var1) {
         public boolean m_58a0f016(int var1) {
            C0114.bootstrap<"call",0,1>(C0191.this);
            return true;
         }
      });
      this.addCenteredText(this.getGuiScreenWidth() / 2, 20, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803821>()));
      this.addText(30, 45, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803822>()).style(C0114.bootstrap<"call",2,1>(8, DefaultColors.AQUA)));
      this.addText(
         30,
         60,
         new Builder()
            .append(C0252.bootstrap<"get",25769803823>())
            .append(C0252.bootstrap<"get",25769803824>(), C0114.bootstrap<"call",3,1>(DefaultColors.AQUA))
            .build()
      );
      this.addText(
         30,
         70,
         new Builder()
            .append(C0252.bootstrap<"get",25769803825>())
            .append(C0252.bootstrap<"get",25769803826>(), C0114.bootstrap<"call",3,1>(DefaultColors.AQUA))
            .append(C0252.bootstrap<"get",25769803827>())
            .build()
      );
      this.addText(
         30,
         80,
         new Builder()
            .append(C0252.bootstrap<"get",25769803828>())
            .append(C0252.bootstrap<"get",25769803829>(), C0114.bootstrap<"call",3,1>(DefaultColors.AQUA))
            .append(C0252.bootstrap<"get",25769803827>())
            .build()
      );
      this.addText(
         30,
         90,
         new Builder()
            .append(C0252.bootstrap<"get",25769803830>())
            .append(C0252.bootstrap<"get",25769803831>(), C0114.bootstrap<"call",3,1>(DefaultColors.AQUA))
            .append(C0252.bootstrap<"get",25769803832>())
            .build()
      );
      this.addText(30, 115, new Builder().append(C0252.bootstrap<"get",25769803833>(), C0114.bootstrap<"call",2,1>(8, DefaultColors.AQUA)).build());
      this.addText(
         30,
         130,
         new Builder()
            .append(C0252.bootstrap<"get",25769803834>())
            .append(C0252.bootstrap<"get",25769803835>(), C0114.bootstrap<"call",3,1>(DefaultColors.AQUA))
            .append(C0252.bootstrap<"get",25769803836>())
            .build()
      );
      this.addText(
         30,
         140,
         new Builder()
            .append(C0252.bootstrap<"get",25769803837>())
            .append(C0252.bootstrap<"get",25769803838>(), C0114.bootstrap<"call",3,1>(DefaultColors.AQUA))
            .append(C0252.bootstrap<"get",25769803839>())
            .build()
      );
      this.addText(30, 165, new Builder().append(C0252.bootstrap<"get",25769803840>(), C0114.bootstrap<"call",2,1>(8, DefaultColors.AQUA)).build());
      this.addText(
         30,
         180,
         new Builder()
            .append(C0252.bootstrap<"get",25769803841>())
            .append(C0252.bootstrap<"get",25769803842>(), C0114.bootstrap<"call",3,1>(DefaultColors.AQUA))
            .append(C0252.bootstrap<"get",25769803843>())
            .build()
      );
      this.addText(
         30,
         190,
         new Builder()
            .append(C0252.bootstrap<"get",25769803844>())
            .append(C0252.bootstrap<"get",25769803845>(), C0114.bootstrap<"call",3,1>(DefaultColors.AQUA))
            .append(C0252.bootstrap<"get",25769803846>())
            .build()
      );
      this.addText(
         30,
         200,
         new Builder()
            .append(C0252.bootstrap<"get",25769803847>())
            .append(C0252.bootstrap<"get",25769803848>(), C0114.bootstrap<"call",3,1>(DefaultColors.AQUA))
            .build()
      );
   }

   protected void onDraw(int var1, int var2, float var3) {
   }

   protected void onUpdate() {
      if (this.f_1ad635f9 > 0) {
         this.f_1ad635f9--;
      }

      Button var1 = (Button)this.getMinecraftScreen().getFirstOfType(Button.class);
      var1.setComponentLabel(
         C0114.bootstrap<"call",0,1>(
            C0252.bootstrap<"get",25769803849>()
               + (
                  this.f_1ad635f9 > 0
                     ? C0252.bootstrap<"get",25769803850>() + this.f_1ad635f9 / 20 + C0252.bootstrap<"get",59>()
                     : C0252.bootstrap<"get",25769803851>()
               )
         )
      );
      var1.setActive(this.f_1ad635f9 <= 0);
   }
}
