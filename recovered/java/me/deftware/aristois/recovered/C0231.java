package me.deftware.aristois.recovered;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.InputStream;
import java.util.HashMap;
import me.deftware.client.framework.fonts.AtlasTextureFont;
import me.deftware.client.framework.registry.font.IFontProvider;

public enum C0231 implements IFontProvider {
   f_ea7dcd0b(35),
   f_bf1e7885(35, false),
   f_c2e9ce7e(22),
   f_e63e664b(22, false),
   f_a3b67470(18),
   f_eda958c4(18, false),
   f_70d0cf33(16),
   f_d3b6070e(16, false),
   f_9c96dbc0(18, true, true);

   private AtlasTextureFont f_9b209754;
   private final int f_249859d6;
   private final boolean f_a42fdd79;
   private final boolean f_583db2fb;

   private C0231(int var3) {
      this(var3, true);
   }

   private C0231(int var3, boolean var4) {
      this(var3, var4, false);
   }

   private C0231(int var3, boolean var4, boolean var5) {
      this.f_249859d6 = var3;
      this.f_a42fdd79 = var4;
      this.f_583db2fb = var5;
      this.m_760c4b4b();
   }

   public void m_760c4b4b() {
      this.f_9b209754 = new AtlasTextureFont(this.m_7c386b2d(), this.f_249859d6, this.f_a42fdd79);
      this.f_9b209754.initialize();
   }

   public void m_7a5f945b() {
      this.f_9b209754.setFont(this.m_7c386b2d());
      this.f_9b209754.initialize();
   }

   public Font m_7c386b2d() {
      String var1 = C0114.bootstrap<"call",0,1>().getPrimitive(C0252.bootstrap<"get",17179869253>(), C0252.bootstrap<"get",17179869254>());
      return var1.equalsIgnoreCase(C0252.bootstrap<"get",17179869254>())
         ? C0231.anonymousthis.f_d62d2ea6
         : C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(var1));
   }

   public static Font m_c253257c(Font var0) {
      HashMap var1 = new HashMap();
      var1.put(TextAttribute.LIGATURES, TextAttribute.LIGATURES_ON);
      return var0.deriveFont(var1);
   }

   public static Font m_cc1dae3c(Font var0) {
      HashMap var1 = new HashMap();
      var1.put(TextAttribute.FAMILY, C0252.bootstrap<"get",17179869255>());
      return var0.deriveFont(var1);
   }

   public AtlasTextureFont getFont() {
      return this.f_9b209754;
   }

   public int m_b98612ed() {
      return this.f_249859d6;
   }

   public boolean m_09939cf7() {
      return this.f_a42fdd79;
   }

   public boolean m_49f9c9e6() {
      return this.f_583db2fb;
   }

   public static class anonymousthis {
      public static final Font f_d62d2ea6 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",17179869252>());

      public anonymousthis() {
      }

      public static Font m_746f71d2(String var0) {
         try (InputStream var1 = C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(), var0)) {
            return C0114.bootstrap<"call",4,1>(C0114.bootstrap<"call",3,1>(0, (InputStream)C0114.bootstrap<"call",2,1>(var1)));
         } catch (Exception var15) {
            throw new RuntimeException(C0252.bootstrap<"get",17179869251>() + var0);
         }
      }
   }
}
