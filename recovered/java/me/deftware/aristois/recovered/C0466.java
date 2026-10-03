package me.deftware.aristois.recovered;

public class C0466 {
   public static String f_a55a75ea = C0265.m_85cd13b4();
   public static String f_a409d03c = C0265.m_65c7e6e6();
   public static String f_fd917b96 = C0265.m_a19a564f();
   public static String f_5c0cb4c3 = C0265.m_03430357();
   public static String f_9fabfcb0 = C0265.m_ec329d2e();
   public static String f_aefe3956 = C0265.m_edf5fb69();
   public static String f_a22a2cbc = C0265.m_8ccfdf29();
   public static String f_e4c0c1f7 = C0265.m_0223faff();
   public static String f_c5017e85 = C0265.m_bdbd5e40();
   public static String f_a75e99f1 = C0265.m_c04d8f6e();
   public static String f_cb1e3165 = C0265.m_2dc36b02();
   public static String f_23001150 = C0265.m_4cbaf16f();
   public static String f_04ac890d = C0265.m_678c4ddb();
   public static String f_b019e80c = C0265.m_1672ac4d();
   public static String f_171328e6 = C0265.m_e9a52709();
   public static String f_a8c80033 = C0265.m_37c08c9d();
   public static String f_83a661b6 = C0265.m_1472ab32();
   public static String f_2e73c011 = C0265.m_a5b24d28();
   public static String f_0fa71afb = C0265.m_a9b6ecd9();
   public static String f_a54eb795 = C0265.m_09052c0b();

   private C0466() {
   }

   public static String m_866a453e(String var0) {
      int var1 = var0.length();
      StringBuffer var2 = new StringBuffer();
      int var3 = 0;

      while (var3 < var1) {
         char var4 = var0.charAt(var3);
         if (var4 == 3) {
            if (++var3 < var1) {
               var4 = var0.charAt(var3);
               if (Character.isDigit(var4)) {
                  if (++var3 < var1) {
                     var4 = var0.charAt(var3);
                     if (Character.isDigit(var4)) {
                        var3++;
                     }
                  }

                  if (var3 < var1) {
                     var4 = var0.charAt(var3);
                     if (var4 == ',') {
                        if (++var3 < var1) {
                           var4 = var0.charAt(var3);
                           if (Character.isDigit(var4)) {
                              if (++var3 < var1) {
                                 var4 = var0.charAt(var3);
                                 if (Character.isDigit(var4)) {
                                    var3++;
                                 }
                              }
                           } else {
                              var3--;
                           }
                        } else {
                           var3--;
                        }
                     }
                  }
               }
            }
         } else if (var4 == 15) {
            var3++;
         } else {
            var2.append(var4);
            var3++;
         }
      }

      return var2.toString();
   }

   public static String m_d46f830f(String var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder();

      for (int var3 = 0; var3 < var1; var3++) {
         char var4 = var0.charAt(var3);
         if (var4 != 15 && var4 != 2 && var4 != 31 && var4 != 22) {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   public static String m_2beb0f7e(String var0) {
      return m_d46f830f(m_866a453e(var0));
   }
}
