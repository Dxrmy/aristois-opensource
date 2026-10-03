package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import me.deftware.client.framework.gui.widgets.SelectableList.ListItem;
import me.deftware.client.framework.math.position.BlockPosition;
import me.deftware.client.framework.math.position.DoubleBlockPosition;

public class C0244 implements ListItem {
   private static final C0219<C0244> f_8a2f132a = new C0219<>(C0244.class, C0252.bootstrap<"get",55834574923>());
   @SerializedName("x")
   private int f_956e123b;
   @SerializedName("y")
   private int f_8eb50e27;
   @SerializedName("z")
   private int f_7ea92f10;
   @SerializedName("color")
   private int f_00ba0cb5;
   @SerializedName("name")
   private String f_d41863ad;
   @SerializedName("server")
   private String f_c5d09a0b = C0114.bootstrap<"call",0,1>();
   @SerializedName("enabled")
   private boolean f_df1332a0;

   public C0244() {
   }

   @Override
   public String toString() {
      return C0114.bootstrap<"call",2,1>(
         C0252.bootstrap<"get",55834574919>(),
         new Object[]{
            C0114.bootstrap<"call",0,1>(this.f_956e123b),
            C0114.bootstrap<"call",0,1>(this.f_8eb50e27),
            C0114.bootstrap<"call",0,1>(this.f_7ea92f10),
            this.f_d41863ad,
            this.f_c5d09a0b,
            C0114.bootstrap<"call",1,1>(this.f_df1332a0)
         }
      );
   }

   public String m_025af698() {
      return C0114.bootstrap<"call",1,1>(
         C0252.bootstrap<"get",55834574920>(),
         new Object[]{
            C0114.bootstrap<"call",0,1>(this.m_93e58820()), C0114.bootstrap<"call",0,1>(this.m_aa5acfd6()), C0114.bootstrap<"call",0,1>(this.m_b0090208())
         }
      );
   }

   public BlockPosition m_a2e39655() {
      return new DoubleBlockPosition((double)this.f_956e123b, (double)this.f_8eb50e27, (double)this.f_7ea92f10);
   }

   public boolean m_7efa5db3() {
      return C0114.bootstrap<"call",0,1>().equalsIgnoreCase(this.f_c5d09a0b);
   }

   public void render(int var1, int var2, int var3, int var4, int var5, int var6, int var7, float var8) {
      C0114.bootstrap<"call",0,1>(var2, var3 + 5, this.m_1cfee894() ? C0071.f_594b4884 : C0071.f_a29f3429);
      var2 += 28;
      C0114.bootstrap<"call",4,1>(
         C0114.bootstrap<"call",3,1>(
            C0114.bootstrap<"call",2,1>(
               C0252.bootstrap<"get",55834574921>(),
               new Object[]{
                  this.m_efbf7bb8(),
                  C0114.bootstrap<"call",1,1>(this.m_93e58820()),
                  C0114.bootstrap<"call",1,1>(this.m_aa5acfd6()),
                  C0114.bootstrap<"call",1,1>(this.m_b0090208())
               }
            )
         ),
         var2,
         var3 + 3,
         10526880
      );
      C0114.bootstrap<"call",4,1>(
         C0114.bootstrap<"call",3,1>(
            C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",55834574922>(), new Object[]{C0114.bootstrap<"call",1,1>(var1), this.m_2612780e()})
         ),
         var2,
         var3 + 15,
         10526880
      );
   }

   public void m_5e296171(int var1) {
      this.f_956e123b = var1;
   }

   public void m_989d0d43(int var1) {
      this.f_8eb50e27 = var1;
   }

   public void m_0faa1ebc(int var1) {
      this.f_7ea92f10 = var1;
   }

   public void m_9bee8302(int var1) {
      this.f_00ba0cb5 = var1;
   }

   public void m_efd8b5f8(String var1) {
      this.f_d41863ad = var1;
   }

   public void m_6162e4ac(String var1) {
      this.f_c5d09a0b = var1;
   }

   public void m_9d941243(boolean var1) {
      this.f_df1332a0 = var1;
   }

   public int m_93e58820() {
      return this.f_956e123b;
   }

   public int m_aa5acfd6() {
      return this.f_8eb50e27;
   }

   public int m_b0090208() {
      return this.f_7ea92f10;
   }

   public int m_d8367831() {
      return this.f_00ba0cb5;
   }

   public String m_efbf7bb8() {
      return this.f_d41863ad;
   }

   public String m_2612780e() {
      return this.f_c5d09a0b;
   }

   public boolean m_1cfee894() {
      return this.f_df1332a0;
   }

   public static C0219<C0244> m_98a0fa02() {
      return f_8a2f132a;
   }
}
