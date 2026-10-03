package me.deftware.aristois.recovered;

import java.awt.Color;
import java.util.Arrays;
import me.deftware.aristois.main.Main;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.minecraft.Minecraft;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

@C0420
public class C0432 extends AbstractMod implements C0441 {
   private final FontRenderStack f_cd0de8f8 = new FontRenderStack(C0231.f_9e490562);
   @C0098(
      value = "Active",
      description = {"The active mod color"}
   )
   private Color f_05fb3c8b = new Color(152, 255, 171);
   @C0098(
      value = "Header",
      description = {"The header color"}
   )
   private Color f_79eb56c5 = Color.white;
   @C0098(
      value = "Disabled",
      description = {"The disabled mod color"}
   )
   private Color f_7c205d38 = Color.white;
   @C0098(
      value = "Color",
      description = {"The background color"}
   )
   private Color f_3dd36ff3 = new Color(34, 40, 49);
   @C0098(
      value = "Popup",
      description = {"The background color of popup dialogs"}
   )
   private Color f_04ec68dd = this.f_3dd36ff3;
   @C0098(
      value = "Hover",
      description = {"The hover color"}
   )
   private Color f_9aaf3750 = new Color(57, 62, 70);
   @C0098(
      value = "Accent",
      description = {"The accent color of items"}
   )
   private Color f_c4add2e3 = new Color(111, 183, 102);
   @C0098(
      value = "RGB Accent",
      description = {"RGB accent"}
   )
   private boolean f_62e4c56f = false;
   @C0098(
      value = "Scrollbar",
      description = {"The scrollbar color"}
   )
   private Color f_15c5c423 = new Color(69, 83, 99);
   @C0098(
      value = "Scrollbar Width",
      description = {"The maximum scrollbar width"}
   )
   private double f_10fa5580 = 15.0;
   @C0098(
      value = "Padding",
      description = {"The height of items (requires restart)"}
   )
   private double f_5181b105 = 10.0;
   @C0098(
      value = "Tooltips",
      description = {"If tooltips should be rendered"}
   )
   private boolean f_88dd3a19 = true;
   @C0098(
      value = "Context Items",
      description = {"How many settings will be shown when right clicking a mod"},
      number = @C0096(
         min = 3.0,
         max = 10.0
      )
   )
   private int f_d76178ee = 5;
   @C0098(
      value = "Font",
      description = {"The font used in Aristois"}
   )
   private String f_c3f00a61 = C0261.m_593ecbab();
   @C0098(
      value = "Text Align",
      description = {"Text align of mod buttons"}
   )
   private C0102<C0427> f_2bcd49f8 = new C0102<>(C0427.f_26bd24ae);
   private long f_29d84737 = 170L;
   @C0098(
      value = "RGB speed",
      description = {"RGB color speed"},
      number = @C0096(
         min = 0.0010000000474974513,
         max = 0.014999999664723873,
         percentage = true
      ),
      id = 0
   )
   private C0103<Float> f_cdf03390 = new C0103<>(C0045.f_8f480fc4::m_b7fbb877, C0045.f_8f480fc4::m_d881d3e3).m_01388fcf();
   @C0098(
      value = "Font shadow",
      description = {"Font shadow size, set to 0 for none"},
      triggerPostChanged = true,
      number = @C0096(
         min = 0.0,
         max = 4.0
      ),
      id = 2
   )
   private int f_8b5ea381 = 1;

   public C0432() {
      super(C0262.m_83f6dd00(), C0290.f_020f9141, C0262.m_56c1229f());
   }

   @Override
   public Color m_e1729432() {
      return this.f_62e4c56f ? Color.getHSBColor(C0045.f_8f480fc4.m_796256b9() + 0.05F, 1.0F, 1.0F) : this.f_c4add2e3;
   }

   @Override
   public String getDisplayName() {
      return C0262.m_0d6ae39b();
   }

   @Override
   public void onPostLoad() {
      this.f_c3f00a61 = Main.getConfig().getPrimitive(C0261.m_b0896de7(), C0261.m_593ecbab());
      Arrays.stream(C0231.values()).forEach(var1 -> var1.getFont().setShadow(this.f_8b5ea381));
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (!Main.getConfig().getPrimitive(C0261.m_b0896de7(), C0261.m_593ecbab()).equals(this.f_c3f00a61)) {
         Main.getConfig().putPrimitive(C0261.m_b0896de7(), this.f_c3f00a61);
         Arrays.stream(C0231.values()).forEach(C0231::m_b728afce);
         if (Minecraft.getMinecraftGame().getScreen() instanceof C0446) {
            ((C0446)Minecraft.getMinecraftGame().getScreen()).m_c7a3618c(null);
         }
      }

      if (var1.id() == 2) {
         Arrays.stream(C0231.values()).forEach(var1x -> var1x.getFont().setShadow(this.f_8b5ea381));
      }
   }

   @Override
   public FontRenderStack m_d996e5c5() {
      return this.f_cd0de8f8;
   }

   @Override
   public Color m_0a0c8c22() {
      return this.f_05fb3c8b;
   }

   @Override
   public Color m_f6c8a26c() {
      return this.f_79eb56c5;
   }

   @Override
   public Color m_303ad3a1() {
      return this.f_7c205d38;
   }

   @Override
   public Color m_d812cfb6() {
      return this.f_3dd36ff3;
   }

   @Override
   public Color m_ac758c94() {
      return this.f_04ec68dd;
   }

   @Override
   public Color m_98b03f4f() {
      return this.f_9aaf3750;
   }

   public boolean m_85f6d0f6() {
      return this.f_62e4c56f;
   }

   @Override
   public Color m_4a97268d() {
      return this.f_15c5c423;
   }

   @Override
   public double m_b2213d56() {
      return this.f_10fa5580;
   }

   @Override
   public double m_036bd5c5() {
      return this.f_5181b105;
   }

   @Override
   public boolean m_f7b07982() {
      return this.f_88dd3a19;
   }

   @Override
   public int m_197b2fc8() {
      return this.f_d76178ee;
   }

   public String m_396f9431() {
      return this.f_c3f00a61;
   }

   @Override
   public C0102<C0427> m_bfd5e3dd() {
      return this.f_2bcd49f8;
   }

   @Override
   public long m_c7c6e660() {
      return this.f_29d84737;
   }

   public C0103<Float> m_567b4bd8() {
      return this.f_cdf03390;
   }

   public int m_9274e178() {
      return this.f_8b5ea381;
   }

   @Override
   public void m_6e0baed2(Color var1) {
      this.f_05fb3c8b = var1;
   }

   @Override
   public void m_29e2138c(Color var1) {
      this.f_79eb56c5 = var1;
   }

   @Override
   public void m_049e1135(Color var1) {
      this.f_7c205d38 = var1;
   }

   @Override
   public void m_b2bfc074(Color var1) {
      this.f_3dd36ff3 = var1;
   }

   @Override
   public void m_78c0cc40(Color var1) {
      this.f_04ec68dd = var1;
   }

   @Override
   public void m_bc794843(Color var1) {
      this.f_9aaf3750 = var1;
   }

   @Override
   public void m_80c28d0d(Color var1) {
      this.f_c4add2e3 = var1;
   }

   public void m_394ecb95(boolean var1) {
      this.f_62e4c56f = var1;
   }

   @Override
   public void m_289e1884(Color var1) {
      this.f_15c5c423 = var1;
   }

   @Override
   public void m_4b04f920(double var1) {
      this.f_10fa5580 = var1;
   }

   @Override
   public void m_7c9e279f(double var1) {
      this.f_5181b105 = var1;
   }

   @Override
   public void m_d6ac7420(boolean var1) {
      this.f_88dd3a19 = var1;
   }

   @Override
   public void m_46938bdb(int var1) {
      this.f_d76178ee = var1;
   }

   public void m_256015fc(String var1) {
      this.f_c3f00a61 = var1;
   }

   public void m_64c14e2f(C0102<C0427> var1) {
      this.f_2bcd49f8 = var1;
   }

   @Override
   public void m_ad6c7e6f(long var1) {
      this.f_29d84737 = var1;
   }

   public void m_ec476b09(C0103<Float> var1) {
      this.f_cdf03390 = var1;
   }

   public void m_7c7fe86a(int var1) {
      this.f_8b5ea381 = var1;
   }
}
