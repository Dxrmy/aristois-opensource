package me.deftware.aristois.recovered;

import java.util.StringTokenizer;
import java.util.Vector;

public class C0464 {
   private Vector<C0468> f_66a2e659 = new Vector<>();
   private C0461 f_4ce26551;

   public C0464(C0461 var1) {
      this.f_4ce26551 = var1;
   }

   public boolean m_2179ee1e(String var1, String var2, String var3, String var4) {
      StringTokenizer var5 = new StringTokenizer(var4);
      var5.nextToken();
      String var6 = var5.nextToken();
      String var7 = var5.nextToken();
      switch (var6) {
         case C0265.m_733bff3d():
            long var23 = Long.parseLong(var5.nextToken());
            int var25 = Integer.parseInt(var5.nextToken());
            long var28 = -1L;

            try {
               var28 = Long.parseLong(var5.nextToken());
            } catch (Exception var18) {
            }

            C0468 var31 = new C0468(this.f_4ce26551, this, var1, var2, var3, var6, var7, var23, var25, var28);
            this.f_4ce26551.m_f9b69576(var31);
            break;
         case C0265.m_3c19a819():
            int var22 = Integer.parseInt(var5.nextToken());
            long var24 = Long.parseLong(var5.nextToken());
            C0468 var27 = null;
            synchronized (this.f_66a2e659) {
               for (int var30 = 0; var30 < this.f_66a2e659.size(); var30++) {
                  var27 = this.f_66a2e659.elementAt(var30);
                  if (var27.m_3d3a8736().equals(var1) && var27.m_f34ec3cf() == var22) {
                     this.f_66a2e659.removeElementAt(var30);
                     break;
                  }
               }
            }

            if (var27 != null) {
               var27.m_e12f1e31(var24);
               this.f_4ce26551.m_412d10a2(var1, C0265.m_56cd5284() + var22 + C0257.m_593ecbab() + var24);
            }
            break;
         case C0265.m_f599ae93():
            int var21 = Integer.parseInt(var5.nextToken());
            long var11 = Long.parseLong(var5.nextToken());
            C0468 var26 = null;
            synchronized (this.f_66a2e659) {
               for (int var15 = 0; var15 < this.f_66a2e659.size(); var15++) {
                  var26 = this.f_66a2e659.elementAt(var15);
                  if (var26.m_3d3a8736().equals(var1) && var26.m_f34ec3cf() == var21) {
                     this.f_66a2e659.removeElementAt(var15);
                     break;
                  }
               }
            }

            if (var26 != null) {
               var26.m_2793dddf(var26.m_facf6936(), true);
            }
            break;
         case C0265.m_5b2d5cb2():
            long var10 = Long.parseLong(var5.nextToken());
            int var12 = Integer.parseInt(var5.nextToken());
            C0456 var13 = new C0456(this.f_4ce26551, var1, var2, var3, var10, var12);
            new Thread(() -> this.f_4ce26551.m_5a42b460(var13)).start();
            break;
         default:
            return false;
      }

      return true;
   }

   public void m_f9b69576(C0468 var1) {
      synchronized (this.f_66a2e659) {
         this.f_66a2e659.addElement(var1);
      }
   }

   public void m_81a3fe0e(C0468 var1) {
      this.f_66a2e659.removeElement(var1);
   }
}
