package me.deftware.aristois.recovered;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.deftware.client.framework.gui.screens.GenericScreen;
import me.deftware.client.framework.gui.widgets.SelectableList;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.message.Appearance;
import me.deftware.client.framework.message.DefaultColors;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.message.Appearance.ClickAction;
import me.deftware.client.framework.message.Message.Builder;

public class C0189 extends C0150 {
   private final List<C0189.anonymousimplements> f_5d641c87;
   private final Message f_44213b0d;
   private final Message f_a8bdaf06;
   private static final Pattern f_d7fbabb5 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803802>());

   public C0189(GenericScreen var1, List<C0189.anonymousimplements> var2, Message var3, Message var4) {
      super(var1);
      this.f_44213b0d = var3;
      this.f_a8bdaf06 = var4;
      this.f_5d641c87 = var2;
   }

   protected void m_6d2bec55() {
      SelectableList var1 = new SelectableList(
         this.f_5d641c87, this.getGuiScreenWidth(), this.getGuiScreenHeight(), 43, this.getGuiScreenHeight(), C0114.bootstrap<"call",0,1>() + 2
      );
      var1.setExtended(true);
      this.addComponent(var1);
      Message var2 = C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",4>());
      this.m_5b3badac(
         new C0163[]{
            this.m_22ac2276(
               this.getGuiScreenWidth() - C0114.bootstrap<"call",2,1>(var2) - 25, 10, (float)(C0114.bootstrap<"call",2,1>(var2) + 15), var2, this::goBack
            )
         }
      );
      this.addCenteredText(this.getGuiScreenWidth() / 2, 15, this.f_44213b0d);
      this.addCenteredText(this.getGuiScreenWidth() / 2, 15 + C0114.bootstrap<"call",0,1>() + 2, this.f_a8bdaf06);
   }

   private static C0189.anonymousimplements m_7f8cea98(String var0) {
      Builder var1 = new Builder();
      String[] var2 = var0.split(C0252.bootstrap<"get",70>());
      String var3 = null;

      for (String var7 : var2) {
         Matcher var8 = f_d7fbabb5.matcher(var7);
         if (var8.matches()) {
            Appearance var10000 = C0114.bootstrap<"call",3,1>(8, DefaultColors.GRAY);
            var3 = var7;
            Appearance var9 = var10000.withClickEvent(ClickAction.OPEN_URL, var7)
               .withTextHoverEvent(C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",25769803797>()));
            var1.append(C0114.bootstrap<"call",1,1>(var7).style(var9));
         } else {
            var1.append(var7);
         }

         var1.append(C0252.bootstrap<"get",70>());
      }

      return new C0189.anonymousimplements(var1.build(), var3);
   }

   public static C0189 m_6b334c35(GenericScreen var0) throws IOException {
      int var1 = C0114.bootstrap<"call",0,1>().getMeta().getVersion();

      C0189 var9;
      try (InputStream var2 = C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(), C0252.bootstrap<"get",25769803798>())) {
         if (var2 == null) {
            throw new IOException(C0252.bootstrap<"get",25769803799>());
         }

         try (
            InputStreamReader var4 = new InputStreamReader(var2);
            BufferedReader var6 = new BufferedReader(var4);
         ) {
            List var8 = var6.lines().map(C0189::m_7f8cea98).collect(C0114.bootstrap<"call",2,1>());
            var9 = new C0189(
               var0,
               var8,
               C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",25769803800>() + var1 + C0252.bootstrap<"get",24>()),
               C0114.bootstrap<"call",3,1>(C0252.bootstrap<"get",25769803801>())
            ) {
               protected void m_184eca6a() {
                  super.m_6d2bec55();
                  if (!C0241.f_7826e715) {
                     Message var1 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",25769803790>());
                     this.m_729ebb8a(
                        new C0163[]{
                           this.m_47421e66(
                              10,
                              10,
                              (float)(C0114.bootstrap<"call",1,1>(var1) + 15),
                              var1,
                              () -> C0114.bootstrap<"call",0,1>(C0146.f_c02c60c3 + C0252.bootstrap<"get",25769803789>())
                           )
                        }
                     );
                  }
               }
            };
         }
      }

      return var9;
   }

   private static class anonymousimplements implements ListItem {
      private final Message f_eca5ea07;
      private final String f_e9cc0219;

      public void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
         C0114.bootstrap<"call",1,1>(
            C0114.bootstrap<"call",0,1>(this.f_eca5ea07, var1x -> C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(var1x) > var4 - 6)),
            var2,
            var3,
            16777215
         );
      }

      public boolean onMouseClicked(double var1, double var3, int var5) {
         if (this.f_e9cc0219 != null) {
            C0114.bootstrap<"call",0,1>(this.f_e9cc0219);
         }

         return false;
      }

      public anonymousimplements(Message var1, String var2) {
         this.f_eca5ea07 = var1;
         this.f_e9cc0219 = var2;
      }
   }
}
