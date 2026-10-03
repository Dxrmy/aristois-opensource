package me.deftware.aristois.recovered;

import java.util.StringTokenizer;
import java.util.Vector;

public class C0464 {
   private Vector<C0468> f_e79bf04f = new Vector<>();
   private C0461 f_b1e91446;

   public C0464(C0461 var1) {
      this.f_b1e91446 = var1;
   }

   public boolean m_4e28377a(String var1, String var2, String var3, String var4) {
      StringTokenizer var5 = new StringTokenizer(var4);
      var5.nextToken();
      String var6 = var5.nextToken();
      String var7 = var5.nextToken();
      switch (var6) {
         case C0252.bootstrap<"get",30064771187>():
            long var23 = C0114.bootstrap<"call",0,1>(var5.nextToken());
            int var25 = C0114.bootstrap<"call",1,1>(var5.nextToken());
            long var28 = -1L;

            try {
               var28 = C0114.bootstrap<"call",0,1>(var5.nextToken());
            } catch (Exception var18) {
            }

            C0468 var31 = new C0468(this.f_b1e91446, this, var1, var2, var3, var6, var7, var23, var25, var28);
            this.f_b1e91446.m_5fa4ada6(var31);
            break;
         case C0252.bootstrap<"get",30064771191>():
            int var22 = C0114.bootstrap<"call",1,1>(var5.nextToken());
            long var24 = C0114.bootstrap<"call",0,1>(var5.nextToken());
            C0468 var27 = null;
            synchronized (this.f_e79bf04f) {
               for (int var30 = 0; var30 < this.f_e79bf04f.size(); var30++) {
                  var27 = this.f_e79bf04f.elementAt(var30);
                  if (var27.m_c9fee510().equals(var1) && var27.m_146d9f78() == var22) {
                     this.f_e79bf04f.removeElementAt(var30);
                     break;
                  }
               }
            }

            if (var27 != null) {
               var27.m_9fe748e5(var24);
               this.f_b1e91446.m_ce0210e2(var1, C0252.bootstrap<"get",30064771194>() + var22 + C0252.bootstrap<"get",70>() + var24);
            }
            break;
         case C0252.bootstrap<"get",30064771192>():
            int var21 = C0114.bootstrap<"call",1,1>(var5.nextToken());
            long var11 = C0114.bootstrap<"call",0,1>(var5.nextToken());
            C0468 var26 = null;
            synchronized (this.f_e79bf04f) {
               for (int var15 = 0; var15 < this.f_e79bf04f.size(); var15++) {
                  var26 = this.f_e79bf04f.elementAt(var15);
                  if (var26.m_c9fee510().equals(var1) && var26.m_146d9f78() == var21) {
                     this.f_e79bf04f.removeElementAt(var15);
                     break;
                  }
               }
            }

            if (var26 != null) {
               var26.m_190c3916(var26.m_2335353c(), true);
            }
            break;
         case C0252.bootstrap<"get",30064771193>():
            long var10 = C0114.bootstrap<"call",0,1>(var5.nextToken());
            int var12 = C0114.bootstrap<"call",1,1>(var5.nextToken());
            C0456 var13 = new C0456(this.f_b1e91446, var1, var2, var3, var10, var12);
            new Thread(() -> this.f_b1e91446.m_45c0a98e(var13)).start();
            break;
         default:
            return false;
      }

      return true;
   }

   public void m_043b2416(C0468 var1) {
      synchronized (this.f_e79bf04f) {
         this.f_e79bf04f.addElement(var1);
      }
   }

   public void m_6ed12368(C0468 var1) {
      this.f_e79bf04f.removeElement(var1);
   }
}
