package me.deftware.aristois.recovered;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;
import me.deftware.aristois.main.Main;
import me.deftware.client.framework.fonts.AtlasTextureFont;
import me.deftware.client.framework.registry.font.IFontProvider;
import me.deftware.client.framework.util.ResourceUtils;

public enum C0231 implements IFontProvider {
   f_a9d23a71(35),
   f_4a6d43a5(35, false),
   f_99d3962b(22),
   f_6ea14e57(22, false),
   f_83bcaed9(18),
   f_33373362(18, false),
   f_9e490562(16),
   f_0e10fc55(16, false),
   f_b126585b(18, true, true);

   private AtlasTextureFont f_5463a4a8;
   private final int f_9e373424;
   private final boolean f_793ed956;
   private final boolean f_580b4a00;

   private C0231(int var3) {
      this(var3, true);
   }

   private C0231(int var3, boolean var4) {
      this(var3, var4, false);
   }

   private C0231(int var3, boolean var4, boolean var5) {
      this.f_9e373424 = var3;
      this.f_793ed956 = var4;
      this.f_580b4a00 = var5;
      this.m_1058ed9a();
   }

   public void m_1058ed9a() {
      this.f_5463a4a8 = new AtlasTextureFont(this.m_f9cede15(), this.f_9e373424, this.f_793ed956);
      this.f_5463a4a8.initialize();
   }

   public void m_b728afce() {
      this.f_5463a4a8.setFont(this.m_f9cede15());
      this.f_5463a4a8.initialize();
   }

   public Font m_f9cede15() {
      String var1 = Main.getConfig().getPrimitive(C0261.m_b0896de7(), C0261.m_593ecbab());
      return var1.equalsIgnoreCase(C0261.m_593ecbab()) ? C0231.anonymousthis.f_c994a59b : m_3288c45f(AtlasTextureFont.getSystem(var1));
   }

   public static Font m_3288c45f(Font var0) {
      HashMap var1 = new HashMap();
      var1.put(TextAttribute.LIGATURES, TextAttribute.LIGATURES_ON);
      return var0.deriveFont(var1);
   }

   public static Font m_00554707(Font var0) {
      HashMap var1 = new HashMap();
      var1.put(TextAttribute.FAMILY, C0261.m_17d51275());
      return var0.deriveFont(var1);
   }

   public AtlasTextureFont getFont() {
      return this.f_5463a4a8;
   }

   public int m_36ffc578() {
      return this.f_9e373424;
   }

   public boolean m_e606d819() {
      return this.f_793ed956;
   }

   public boolean m_e0f7c666() {
      return this.f_580b4a00;
   }

   public static class anonymousthis {
      public static final Font f_c994a59b = m_9515d83f(C0261.m_87c16989());

      public anonymousthis() {
      }

      public static Font m_9515d83f(String var0) {
         try (InputStream var1 = ResourceUtils.getStreamFromModResources(Main.getInstance(), var0)) {
            return C0231.m_3288c45f(Font.createFont(0, Objects.requireNonNull(var1)));
         } catch (Exception var15) {
            throw new RuntimeException(C0261.m_9d6ca6d0() + var0);
         }
      }
   }
}
