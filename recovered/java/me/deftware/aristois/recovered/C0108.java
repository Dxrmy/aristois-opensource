package me.deftware.aristois.recovered;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import me.deftware.aristois.menu.view.RectTooltip;
import me.deftware.aristois.menu.view.container.ContainerWidget;
import me.deftware.aristois.menu.view.container.ContextMenu;
import me.deftware.aristois.menu.widgets.EnumWidget;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0108 implements C0112<C0102> {
   public C0108() {
   }

   @Override
   public List<Class<? extends C0102>> m_350b5ae0() {
      return Collections.singletonList(C0102.class);
   }

   @Override
   public C0163 m_5f0a4ee5(final C0094 var1, ContainerWidget var2, boolean var3) {
      EnumWidget var4 = new EnumWidget((C0102)var1.m_50ca8f08(), var2.m_519f75ae()) {
         @Override
         protected void apply(String var1x, int var2) {
            var1.m_0e389a72();
         }

         @Override
         public void m_1058ed9a() {
            this.setLabel(Message.of(this.boxedEnum.m_d32ebe65()));
            String[] var1x = this.boxedEnum.m_61857e58();
            if (var1x == null) {
               var1x = new String[]{var1.m_6f1f396d()};
            }

            this.m_c7a3618c(new RectTooltip(this, this.m_519f75ae(), Arrays.stream(var1x).map(Message::of).toArray(Message[]::new)));
            if (Minecraft.getMinecraftGame().getScreen() instanceof C0446) {
               for (C0163 var3 : ((C0446)Minecraft.getMinecraftGame().getScreen()).m_ed46fa58()) {
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
               this.boxedEnum.m_b728afce();
               this.m_1058ed9a();
            }
         }
      };
      var4.m_ec141b95(new C0426[]{C0426.f_c285454f});
      return var4;
   }

   @Override
   public void m_6588d9db(JsonElement var1, C0094<?> var2, AbstractMod var3) {
      C0102 var4 = (C0102)var2.m_50ca8f08();
      var4.m_46938bdb(var1.getAsInt());
   }

   @Override
   public JsonElement m_695e59d3(C0094<?> var1) {
      return new JsonPrimitive(((C0102)var1.m_50ca8f08()).m_597f2e14());
   }
}
