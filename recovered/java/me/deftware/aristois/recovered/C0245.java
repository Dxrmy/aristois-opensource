package me.deftware.aristois.recovered;

import com.google.gson.annotations.SerializedName;
import me.deftware.client.framework.input.Keyboard;
import me.deftware.client.framework.input.Mouse;

public class C0245 {
   @SerializedName("keyCode")
   private int f_b85bf86c;
   @SerializedName("modifier")
   private int f_50c973a2 = 0;
   @SerializedName("displayName")
   private String f_cfabdd9e;
   private Runnable f_c57d985c;

   public C0245() {
      this(-1);
   }

   public C0245(int var1) {
      this.f_b85bf86c = var1;
   }

   public void m_46938bdb(int var1) {
      this.f_b85bf86c = var1;
      if (this.f_c57d985c != null) {
         this.f_c57d985c.run();
      }
   }

   public void m_7c7fe86a(int var1) {
      this.f_50c973a2 = var1;
      if (this.f_c57d985c != null) {
         this.f_c57d985c.run();
      }
   }

   public void m_1058ed9a() {
      this.m_46938bdb(-1);
      this.m_7c7fe86a(0);
   }

   @Override
   public String toString() {
      if (this.f_b85bf86c < 0) {
         return C0261.m_733bff3d();
      } else {
         String var1 = this.f_50c973a2 != 0 ? C0217.m_d46f830f(C0217.m_d0cd04ec(this.f_50c973a2).toLowerCase()) + C0256.m_df6e621c() : "";
         if (this.m_89e0519f()) {
            return var1 + String.format(C0256.m_56242a84(), this.f_b85bf86c);
         } else if (this.f_cfabdd9e != null && !this.f_cfabdd9e.isEmpty()) {
            return var1 + this.f_cfabdd9e;
         } else {
            String var2 = C0217.m_d46f830f(Keyboard.getKeyName(this.f_b85bf86c).replace(C0264.m_16315846(), C0257.m_593ecbab()).toLowerCase());
            return this.f_b85bf86c == -1 ? C0261.m_733bff3d() : var1 + var2;
         }
      }
   }

   public boolean m_9362a920() {
      return this.f_b85bf86c != -1 || this.f_50c973a2 != 0;
   }

   public boolean m_89e0519f() {
      return this.f_b85bf86c < 7;
   }

   public boolean m_aa45d95d(int var1) {
      return this.m_89e0519f()
         ? Mouse.isButtonDown(this.f_b85bf86c) && var1 == this.f_50c973a2
         : Keyboard.isKeyDown(this.f_b85bf86c) && var1 == this.f_50c973a2;
   }

   public int m_36ffc578() {
      return this.f_b85bf86c;
   }

   public int m_a135e825() {
      return this.f_50c973a2;
   }

   public String m_8ced16bd() {
      return this.f_cfabdd9e;
   }

   public Runnable m_84ec6ac4() {
      return this.f_c57d985c;
   }

   public void m_256015fc(String var1) {
      this.f_cfabdd9e = var1;
   }

   public void m_c162d659(Runnable var1) {
      this.f_c57d985c = var1;
   }
}
