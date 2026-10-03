package me.deftware.aristois.recovered;

import me.deftware.aristois.menu.view.dialog.DialogWidget;
import me.deftware.aristois.menu.widgets.ButtonWidget;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Message.Builder;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

public class C0434 extends DialogWidget {
   private final FontRenderStack f_d3d5bf5a = this.f_641324bf.m_4aa3f6de();
   private final double f_34be6f12 = 20.0;
   private Message[] f_ca1f07c2;

   public C0434(double var1, double var3, double var5, double var7, C0441 var9) {
      super(var1, var3, var5, var7, var9);
      this.setRenderBackground(true);
      this.setResizable(false);
      this.setDraggable(false);
      DefaultColors var10 = DefaultColors.YELLOW;
      this.m_634640e1(
         C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",34359738471>()),
         new Builder()
            .append(C0252.bootstrap<"get",34359738472>(), C0114.bootstrap<"call",1,1>(var10))
            .append(C0252.bootstrap<"get",34359738473>())
            .append(C0252.bootstrap<"get",34359738474>(), C0114.bootstrap<"call",1,1>(var10))
            .append(C0252.bootstrap<"get",34359738475>())
            .append(C0252.bootstrap<"get",34359738476>())
            .build(),
         new Builder()
            .append(C0252.bootstrap<"get",34359738477>())
            .append(C0252.bootstrap<"get",34359738478>(), C0114.bootstrap<"call",1,1>(var10))
            .append(C0252.bootstrap<"get",34359738479>())
            .append(C0252.bootstrap<"get",34359738474>(), C0114.bootstrap<"call",1,1>(var10))
            .append(C0252.bootstrap<"get",34359738480>())
            .build(),
         new Builder()
            .append(C0252.bootstrap<"get",34359738481>())
            .append(C0252.bootstrap<"get",34359738482>(), C0114.bootstrap<"call",1,1>(var10))
            .append(C0252.bootstrap<"get",34359738483>())
            .build(),
         new Builder()
            .append(C0252.bootstrap<"get",25769803830>())
            .append(C0252.bootstrap<"get",34359738484>(), C0114.bootstrap<"call",1,1>(var10))
            .append(C0252.bootstrap<"get",34359738485>())
            .build(),
         C0197.f_716a73fa,
         new Builder()
            .append(C0252.bootstrap<"get",34359738486>())
            .append(C0252.bootstrap<"get",34359738469>(), C0114.bootstrap<"call",1,1>(var10))
            .append(C0252.bootstrap<"get",34359738487>())
            .append(C0252.bootstrap<"get",34359738488>(), C0114.bootstrap<"call",1,1>(var10))
            .append(C0252.bootstrap<"get",34359738489>())
            .build(),
         new Builder().append(C0252.bootstrap<"get",34359738490>(), C0114.bootstrap<"call",1,1>(var10)).append(C0252.bootstrap<"get",34359738491>()).build()
      );
   }

   public void m_634640e1(Message... var1) {
      this.f_ca1f07c2 = var1;
   }

   @Override
   public DialogWidget setupComponents(Message var1) {
      super.setupComponents(var1);
      this.title.setDrawExitButton(false);
      ButtonWidget var2 = new ButtonWidget(0.0, 0.0, 100.0, C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",34359738492>()), this.f_641324bf) {
         @Override
         protected void onClick(int var1) {
         }

         public boolean m_c5e5af4f(double var1, double var3, int var5) {
            if (this.f_bedbb870.m_263d91ea(var1, var3) && var5 == 0) {
               C0114.bootstrap<"call",0,1>().putPrimitive(C0252.bootstrap<"get",8589934610>(), true);
               C0114.bootstrap<"call",0,1>().save();
               C0434.this.close();
            }

            return false;
         }
      };
      var2.setTextAlign(C0427.f_2db8c19a);
      var2.m_de124a35()
         .m_1e49f000(this.f_318f5155.m_830cb294() - var2.m_de124a35().m_830cb294() - 20.0, this.f_318f5155.m_fc7f45bc() - var2.m_de124a35().m_fc7f45bc() - 20.0);
      this.m_2f3f69e5(new C0163[]{var2});
      return this;
   }

   public boolean m_4abfa227(double var1, double var3, float var5, boolean var6) {
      var6 = super.m_83090461(var1, var3, var5, var6);
      if (this.f_ca1f07c2 != null) {
         double var7 = this.f_318f5155.m_14f8bc2c() + 20.0;
         double var9 = this.f_318f5155.m_5a998971() + this.title.m_cb4e693c().m_fc7f45bc() + 20.0;
         this.f_d3d5bf5a.begin();

         for (Message var14 : this.f_ca1f07c2) {
            this.f_d3d5bf5a.drawString(var7, var9, var14);
            var9 += (double)this.f_d3d5bf5a.getFontHeight();
         }

         this.f_d3d5bf5a.end();
      }

      return var6;
   }
}
