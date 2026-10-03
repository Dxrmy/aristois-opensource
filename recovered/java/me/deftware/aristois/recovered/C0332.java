package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.gui.GuiScreen;

public class C0332 extends AbstractMod {
   private C0219<C0246> f_caac3ced = new C0219<C0246>(C0246.class, C0252.bootstrap<"get",47244640348>()) {
      @Override
      public boolean contains(Object var1) {
         if (var1 instanceof String) {
            for (C0246 var3 : this.f_b74f76e5) {
               if (((String)var1).toLowerCase().contains(var3.m_4dd2758c().toLowerCase())) {
                  return true;
               }
            }
         }

         return false;
      }
   };
   private C0219<C0251> f_10637674 = new C0219<>(C0251.class, C0252.bootstrap<"get",47244640349>());
   @C0098(
      value = "Exclude",
      description = {"Excluded lines"}
   )
   private final GuiScreen f_8d22f1c4 = new C0174<>(null, this.f_caac3ced, C0252.bootstrap<"get",47244640350>());
   @C0098(
      value = "Replace",
      description = {"Replaced lines, with regex"}
   )
   private final GuiScreen f_5cd7f2c7 = new C0174<>(null, this.f_10637674, C0252.bootstrap<"get",47244640351>());

   public C0332() {
      super(C0252.bootstrap<"get",47244640346>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",47244640347>());
      C0114.bootstrap<"call",0,1>()
         .getDebugModifiers()
         .add(var1 -> !this.isEnabled() ? var1 : var1.stream().filter(var1x -> !this.f_caac3ced.contains(var1x)).map(var1x -> {
               for (C0251 var3 : this.f_10637674) {
                  var1x = var1x.replaceAll(var3.m_683b214e(), var3.m_90aafe00());
               }

               return (String)var1x;
            }).collect(C0114.bootstrap<"call",0,1>()));
   }
}
