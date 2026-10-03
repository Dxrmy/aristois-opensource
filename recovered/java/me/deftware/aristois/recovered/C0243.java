package me.deftware.aristois.recovered;

import me.deftware.aristois.main.Main;
import me.deftware.client.framework.main.ModMeta;

public class C0243 {
   public C0243() {
   }

   public static void m_1058ed9a() {
      ModMeta var0 = Main.getInstance().getMeta();
      if (!var0.getName().equals(C0264.m_5fa6dd07()) || !var0.getAuthor().equals(C0258.m_5fa6dd07())) {
         System.exit(0);
      }
   }
}
