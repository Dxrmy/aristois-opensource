package me.deftware.aristois.recovered;

import java.util.List;
import java.util.function.BiFunction;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventScreen;
import me.deftware.client.framework.event.events.EventScreen.Type;
import me.deftware.client.framework.gui.screens.SignEditScreen;

public class C0411 extends AbstractMod {
   @C0098(
      value = "Text",
      description = {"Text to write on each sign"},
      textProcessor = C0411.anonymousconst.class
   )
   private String f_7c113242 = C0252.bootstrap<"get",38654705733>();

   public C0411() {
      super(C0252.bootstrap<"get",38654705731>(), C0290.f_dad8467e, C0252.bootstrap<"get",38654705732>());
   }

   @EventHandler
   private void m_96a2dad7(EventScreen var1) {
      if (var1.getScreen() instanceof SignEditScreen && var1.getType() == Type.Setup) {
         SignEditScreen var2 = (SignEditScreen)var1.getScreen();
         List var3 = C0114.bootstrap<"call",0,1>(this.f_7c113242);
         if (this.f_7c113242.contains(C0252.bootstrap<"get",38654705730>())) {
            var3 = C0114.bootstrap<"call",1,1>(this.f_7c113242.split(C0252.bootstrap<"get",38654705730>()));
         }

         for (int var4 = 0; var4 < var3.size(); var4++) {
            String var5 = (String)var3.get(var4);
            var2._setLine(var4, var5);
         }

         var2._save();
         var2.close();
      }
   }

   public static class anonymousconst implements BiFunction<String, String, String> {
      public static final int f_75a47f89 = 90;

      public anonymousconst() {
      }

      public String m_a77b4706(String var1, String var2) {
         String var3 = var1 + var2;
         if (var3.contains(C0252.bootstrap<"get",38654705730>()) && !var3.equals(C0252.bootstrap<"get",38654705730>())) {
            var3 = var3.split(C0252.bootstrap<"get",38654705730>())[var3.split(C0252.bootstrap<"get",38654705730>()).length - 1];
         }

         if (C0114.bootstrap<"call",0,1>(var3) > 90) {
            var2 = var2 + C0252.bootstrap<"get",38654705730>();
         }

         return var2;
      }
   }
}
