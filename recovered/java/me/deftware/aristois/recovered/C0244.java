package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import me.deftware.client.framework.fonts.FontRenderer;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.math.position.DoubleBlockPosition;
import me.deftware.client.framework.message.Message;
import me.deftware.client.framework.render.ItemRenderer;

public class C0244 implements ListItem {
   private static final C0219<C0244> f_9a0eb96a = new C0219<>(C0244.class, C0256.m_b2dd5137());
   @SerializedName("x")
   private int f_cb0b6df4;
   @SerializedName("y")
   private int f_d1631fc8;
   @SerializedName("z")
   private int f_4f608ace;
   @SerializedName("color")
   private int f_39226d52;
   @SerializedName("name")
   private String f_b78f81dd;
   @SerializedName("server")
   private String f_835a62ba = C0451.m_3855be80();
   @SerializedName("enabled")
   private boolean f_95d8d03b;

   public C0244() {
   }

   @Override
   public String toString() {
      return String.format(C0256.m_17d51275(), this.f_cb0b6df4, this.f_d1631fc8, this.f_4f608ace, this.f_b78f81dd, this.f_835a62ba, this.f_95d8d03b);
   }

   public String m_8d7dbe31() {
      return String.format(C0256.m_00ba16c2(), this.m_36ffc578(), this.m_a135e825(), this.m_f34ec3cf());
   }

   public BlockPosition m_e8f7735c() {
      return new DoubleBlockPosition((double)this.f_cb0b6df4, (double)this.f_d1631fc8, (double)this.f_4f608ace);
   }

   public boolean m_89e0519f() {
      return C0451.m_3855be80().equalsIgnoreCase(this.f_835a62ba);
   }

   public void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
      ItemRenderer.drawBlock(var2, var3 + 5, this.m_f0e7dcaa() ? C0071.f_4804720f : C0071.f_83bc8b61);
      var2 += 28;
      FontRenderer.drawString(
         Message.of(String.format(C0256.m_d1f7b79f(), this.m_c688f8ca(), this.m_36ffc578(), this.m_a135e825(), this.m_f34ec3cf())), var2, var3 + 3, 10526880
      );
      FontRenderer.drawString(Message.of(String.format(C0256.m_a29090eb(), var1, this.m_c42f1c7e())), var2, var3 + 15, 10526880);
   }

   public void m_46938bdb(int var1) {
      this.f_cb0b6df4 = var1;
   }

   public void m_7c7fe86a(int var1) {
      this.f_d1631fc8 = var1;
   }

   public void m_8b037516(int var1) {
      this.f_4f608ace = var1;
   }

   public void m_0e76b397(int var1) {
      this.f_39226d52 = var1;
   }

   public void m_256015fc(String var1) {
      this.f_b78f81dd = var1;
   }

   public void m_a11708c5(String var1) {
      this.f_835a62ba = var1;
   }

   public void m_d6ac7420(boolean var1) {
      this.f_95d8d03b = var1;
   }

   public int m_36ffc578() {
      return this.f_cb0b6df4;
   }

   public int m_a135e825() {
      return this.f_d1631fc8;
   }

   public int m_f34ec3cf() {
      return this.f_4f608ace;
   }

   public int m_8b15b5f4() {
      return this.f_39226d52;
   }

   public String m_c688f8ca() {
      return this.f_b78f81dd;
   }

   public String m_c42f1c7e() {
      return this.f_835a62ba;
   }

   public boolean m_f0e7dcaa() {
      return this.f_95d8d03b;
   }

   public static C0219<C0244> m_a492b2a7() {
      return f_9a0eb96a;
   }
}
