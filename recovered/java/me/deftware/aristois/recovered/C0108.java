package me.deftware.aristois.recovered;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.List;
import me.deftware.aristois.menu.view.RectTooltip;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.view.container.ContextMenu;
import me.deftware.aristois.menu.widgets.EnumWidget;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.message.Message;

public class C0108 implements C0112<C0102> {
   public C0108() {
   }

   public List<Class<? extends C0102>> m_cfa1d77b() {
      return C0114.bootstrap<"call",0,1>(C0102.class);
   }

   public C0163 m_1546f9b0(final C0094 var1, ContainerWidget var2, boolean var3) {
      EnumWidget var4 = new EnumWidget((C0102)var1.m_48b16e97(), var2.m_0826645c()) {
         @Override
         protected void apply(String var1x, int var2) {
            var1.m_50c1fe8b();
         }

         public void m_035a14db() {
            this.setLabel(C0114.bootstrap<"call",0,1>(this.boxedEnum.m_27694bb2()));
            String[] var1x = this.boxedEnum.m_39d671cb();
            if (var1x == null) {
               var1x = new String[]{var1.m_b5ae4ee3()};
            }

            this.m_30e3a51a(new RectTooltip(this, this.m_2146fe93(), C0114.bootstrap<"call",1,1>(var1x).map(Message::of).toArray(Message[]::new)));
            if (C0114.bootstrap<"call",2,1>().getScreen() instanceof C0446) {
               for (C0163 var3 : ((C0446)C0114.bootstrap<"call",2,1>().getScreen()).m_b63ca3f1()) {
                  if (var3 instanceof ContextMenu) {
                     ((ContextMenu)var3).recalculate();
                  }
               }
            }
         }

         @Override
         protected void onClick(int var1x) {
            super.onClick(var1x);
            if (var1x == 2) {
               this.boxedEnum.m_322bf07c();
               this.m_035a14db();
            }
         }
      };
      var4.m_adac03f0(new C0426[]{C0426.f_974a55e6});
      return var4;
   }

   public void m_bd446fdc(JsonElement var1, C0094<?> var2, AbstractMod var3) {
      C0102 var4 = (C0102)var2.m_48b16e97();
      var4.m_d2d71c50(var1.getAsInt());
   }

   public JsonElement m_1ede369d(C0094<?> var1) {
      return new JsonPrimitive(C0114.bootstrap<"call",1,1>(((C0102)var1.m_48b16e97()).m_36cf9409()));
   }
}
