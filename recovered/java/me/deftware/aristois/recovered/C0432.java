package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.render.batching.font.FontRenderStack;

@C0420
public class C0432 extends AbstractMod implements C0441 {
   private final FontRenderStack f_101a8cc7 = new FontRenderStack(C0231.f_70d0cf33);
   @C0098(
      value = "Active",
      description = {"The active mod color"}
   )
   private Color f_9b8b850b = new Color(152, 255, 171);
   @C0098(
      value = "Header",
      description = {"The header color"}
   )
   private Color f_179267af = Color.white;
   @C0098(
      value = "Disabled",
      description = {"The disabled mod color"}
   )
   private Color f_fcf9932f = Color.white;
   @C0098(
      value = "Color",
      description = {"The background color"}
   )
   private Color f_09ec4348 = new Color(34, 40, 49);
   @C0098(
      value = "Popup",
      description = {"The background color of popup dialogs"}
   )
   private Color f_b328c9e8 = this.f_09ec4348;
   @C0098(
      value = "Hover",
      description = {"The hover color"}
   )
   private Color f_a4e8bd44 = new Color(57, 62, 70);
   @C0098(
      value = "Accent",
      description = {"The accent color of items"}
   )
   private Color f_871f8f5d = new Color(111, 183, 102);
   @C0098(
      value = "RGB Accent",
      description = {"RGB accent"}
   )
   private boolean f_343164d6 = false;
   @C0098(
      value = "Scrollbar",
      description = {"The scrollbar color"}
   )
   private Color f_5733df6b = new Color(69, 83, 99);
   @C0098(
      value = "Scrollbar Width",
      description = {"The maximum scrollbar width"}
   )
   private double f_0ca20cbe = 15.0;
   @C0098(
      value = "Padding",
      description = {"The height of items (requires restart)"}
   )
   private double f_78b1a20d = 10.0;
   @C0098(
      value = "Tooltips",
      description = {"If tooltips should be rendered"}
   )
   private boolean f_6c2f699e = true;
   @C0098(
      value = "Context Items",
      description = {"How many settings will be shown when right clicking a mod"},
      number = @C0096(
         min = 3.0,
         max = 10.0
      )
   )
   private int f_0674bd0b = 5;
   @C0098(
      value = "Font",
      description = {"The font used in Aristois"}
   )
   private String f_01dc29ca = C0252.bootstrap<"get",17179869254>();
   @C0098(
      value = "Text Align",
      description = {"Text align of mod buttons"}
   )
   private C0102<C0427> f_e01117db = new C0102<>(C0427.f_f7cee513);
   private long f_7794548c = 170L;
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
   private C0103<Float> f_a063e3b6 = new C0103<>(C0045.f_d228694b::m_03682d2e, C0045.f_d228694b::m_d87ed5e1).m_d66ab8dc();
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
   private int f_d7175159 = 1;

   public C0432() {
      super(C0252.bootstrap<"get",34359738493>(), C0290.f_5fe5d165, C0252.bootstrap<"get",34359738494>());
   }

   public Color m_604f8702() {
      return this.f_343164d6 ? C0114.bootstrap<"call",0,1>(C0045.f_d228694b.m_8db20abd() + 0.05F, 1.0F, 1.0F) : this.f_871f8f5d;
   }

   @Override
   public String getDisplayName() {
      return C0252.bootstrap<"get",34359738495>();
   }

   @Override
   public void onPostLoad() {
      this.f_01dc29ca = C0114.bootstrap<"call",0,1>().getPrimitive(C0252.bootstrap<"get",17179869253>(), C0252.bootstrap<"get",17179869254>());
      C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>()).forEach(var1 -> var1.getFont().setShadow(this.f_d7175159));
   }

   @Override
   public void onSettingUpdate(C0098 var1) {
      if (!C0114.bootstrap<"call",0,1>().getPrimitive(C0252.bootstrap<"get",17179869253>(), C0252.bootstrap<"get",17179869254>()).equals(this.f_01dc29ca)) {
         C0114.bootstrap<"call",0,1>().putPrimitive(C0252.bootstrap<"get",17179869253>(), this.f_01dc29ca);
         C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>()).forEach(C0231::m_7a5f945b);
         if (C0114.bootstrap<"call",3,1>().getScreen() instanceof C0446) {
            ((C0446)C0114.bootstrap<"call",3,1>().getScreen()).m_ff2cab60(null);
         }
      }

      if (var1.id() == 2) {
         C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>()).forEach(var1x -> var1x.getFont().setShadow(this.f_d7175159));
      }
   }

   public FontRenderStack m_2b5ffd6d() {
      return this.f_101a8cc7;
   }

   public Color m_176689e4() {
      return this.f_9b8b850b;
   }

   public Color m_8a4b7dc8() {
      return this.f_179267af;
   }

   public Color m_c7f4a69d() {
      return this.f_fcf9932f;
   }

   public Color m_ffa6b505() {
      return this.f_09ec4348;
   }

   public Color m_549ec60d() {
      return this.f_b328c9e8;
   }

   public Color m_866af780() {
      return this.f_a4e8bd44;
   }

   public boolean m_518c3e79() {
      return this.f_343164d6;
   }

   public Color m_71b42965() {
      return this.f_5733df6b;
   }

   public double m_6e84df6f() {
      return this.f_0ca20cbe;
   }

   public double m_581aafd6() {
      return this.f_78b1a20d;
   }

   public boolean m_102f5021() {
      return this.f_6c2f699e;
   }

   public int m_4f0c2a7f() {
      return this.f_0674bd0b;
   }

   public String m_062aa38c() {
      return this.f_01dc29ca;
   }

   public C0102<C0427> m_6267b7cd() {
      return this.f_e01117db;
   }

   public long m_2c5ff8ca() {
      return this.f_7794548c;
   }

   public C0103<Float> m_8a89332e() {
      return this.f_a063e3b6;
   }

   public int m_775d0a77() {
      return this.f_d7175159;
   }

   public void m_ada89720(Color var1) {
      this.f_9b8b850b = var1;
   }

   public void m_41803336(Color var1) {
      this.f_179267af = var1;
   }

   public void m_7312f417(Color var1) {
      this.f_fcf9932f = var1;
   }

   public void m_d9292c39(Color var1) {
      this.f_09ec4348 = var1;
   }

   public void m_e67b82d4(Color var1) {
      this.f_b328c9e8 = var1;
   }

   public void m_f21d197c(Color var1) {
      this.f_a4e8bd44 = var1;
   }

   public void m_6b6b553d(Color var1) {
      this.f_871f8f5d = var1;
   }

   public void m_b9538cdc(boolean var1) {
      this.f_343164d6 = var1;
   }

   public void m_7100de87(Color var1) {
      this.f_5733df6b = var1;
   }

   public void m_b083bb16(double var1) {
      this.f_0ca20cbe = var1;
   }

   public void m_0702a9ca(double var1) {
      this.f_78b1a20d = var1;
   }

   public void m_0bd42af9(boolean var1) {
      this.f_6c2f699e = var1;
   }

   public void m_68f48085(int var1) {
      this.f_0674bd0b = var1;
   }

   public void m_573bfd91(String var1) {
      this.f_01dc29ca = var1;
   }

   public void m_c024f49e(C0102<C0427> var1) {
      this.f_e01117db = var1;
   }

   public void m_21677bb5(long var1) {
      this.f_7794548c = var1;
   }

   public void m_fae30556(C0103<Float> var1) {
      this.f_a063e3b6 = var1;
   }

   public void m_dc3641bd(int var1) {
      this.f_d7175159 = var1;
   }
}
