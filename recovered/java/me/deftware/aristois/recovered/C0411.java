package me.deftware.aristois.recovered;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventScreen;
import me.deftware.client.framework.event.events.EventScreen.Type;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.screens.SignEditScreen;

public class C0411 extends AbstractMod {
   @C0098(
      value = "Text",
      description = {"Text to write on each sign"},
      textProcessor = C0411.anonymousconst.class
   )
   private String f_ac1f9fba = C0263.m_b0896de7();

   public C0411() {
      super(C0263.m_9d6ca6d0(), C0290.f_dbc16475, C0263.m_87c16989());
   }

   @EventHandler
   private void m_65c92cfe(EventScreen var1) {
      if (var1.getScreen() instanceof SignEditScreen && var1.getType() == Type.Setup) {
         SignEditScreen var2 = (SignEditScreen)var1.getScreen();
         List var3 = Collections.singletonList(this.f_ac1f9fba);
         if (this.f_ac1f9fba.contains(C0263.m_b526dd3b())) {
            var3 = Arrays.asList(this.f_ac1f9fba.split(C0263.m_b526dd3b()));
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
      public static final int f_8f7c5b85 = 90;

      public anonymousconst() {
      }

      public String m_8319a509(String var1, String var2) {
         String var3 = var1 + var2;
         if (var3.contains(C0263.m_b526dd3b()) && !var3.equals(C0263.m_b526dd3b())) {
            var3 = var3.split(C0263.m_b526dd3b())[var3.split(C0263.m_b526dd3b()).length - 1];
         }

         if (FontRenderer.getStringWidth(var3) > 90) {
            var2 = var2 + C0263.m_b526dd3b();
         }

         return var2;
      }
   }
}
