package me.deftware.aristois.recovered;

import java.util.stream.Collectors;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0332 extends AbstractMod {
   private C0219<C0246> f_828a8273 = new C0219<C0246>(C0246.class, C0260.m_fac478b2()) {
      @Override
      public boolean contains(Object var1) {
         if (var1 instanceof String) {
            for (C0246 var3 : this.f_2acc0bd9) {
               if (((String)var1).toLowerCase().contains(var3.m_8d7dbe31().toLowerCase())) {
                  return true;
               }
            }
         }

         return false;
      }
   };
   private C0219<C0251> f_27563618 = new C0219<>(C0251.class, C0260.m_9bf0a29a());
   @C0098(
      value = "Exclude",
      description = {"Excluded lines"}
   )
   private final GuiScreen f_d1ece23f = new C0174<>(null, this.f_828a8273, C0260.m_85cd13b4());
   @C0098(
      value = "Replace",
      description = {"Replaced lines, with regex"}
   )
   private final GuiScreen f_d42cb7f2 = new C0174<>(null, this.f_27563618, C0260.m_65c7e6e6());

   public C0332() {
      super(C0260.m_bcef2112(), C0290.f_3210deb7, C0260.m_114677c2());
      Minecraft.getMinecraftGame()
         .getDebugModifiers()
         .add(var1 -> !this.isEnabled() ? var1 : var1.stream().filter(var1x -> !this.f_828a8273.contains(var1x)).map(var1x -> {
               for (C0251 var3 : this.f_27563618) {
                  var1x = var1x.replaceAll(var3.m_8d7dbe31(), var3.m_3d3a8736());
               }

               return (String)var1x;
            }).collect(Collectors.toList()));
   }
}
