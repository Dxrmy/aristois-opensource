package me.deftware.aristois.recovered;

public class C0466 {
   public static String f_51129e9d = C0252.bootstrap<"get",30064771166>();
   public static String f_5474cf9b = C0252.bootstrap<"get",30064771167>();
   public static String f_e37613c1 = C0252.bootstrap<"get",30064771168>();
   public static String f_798d7a39 = C0252.bootstrap<"get",30064771169>();
   public static String f_050740a9 = C0252.bootstrap<"get",30064771170>();
   public static String f_961c493d = C0252.bootstrap<"get",30064771171>();
   public static String f_477723f1 = C0252.bootstrap<"get",30064771172>();
   public static String f_378c17fa = C0252.bootstrap<"get",30064771173>();
   public static String f_7ee27341 = C0252.bootstrap<"get",30064771174>();
   public static String f_218b0948 = C0252.bootstrap<"get",30064771175>();
   public static String f_f629a44a = C0252.bootstrap<"get",30064771176>();
   public static String f_6a325645 = C0252.bootstrap<"get",30064771177>();
   public static String f_c7e16bd0 = C0252.bootstrap<"get",30064771178>();
   public static String f_04bea8ee = C0252.bootstrap<"get",30064771179>();
   public static String f_0951d4e2 = C0252.bootstrap<"get",30064771180>();
   public static String f_35fbb2ef = C0252.bootstrap<"get",30064771181>();
   public static String f_205ffdc3 = C0252.bootstrap<"get",30064771182>();
   public static String f_e344de00 = C0252.bootstrap<"get",30064771183>();
   public static String f_4ad3fda0 = C0252.bootstrap<"get",30064771184>();
   public static String f_64d5189a = C0252.bootstrap<"get",30064771185>();

   private C0466() {
   }

   public static String m_e95b44fb(String var0) {
      int var1 = var0.length();
      StringBuffer var2 = new StringBuffer();
      int var3 = 0;

      while (var3 < var1) {
         char var4 = var0.charAt(var3);
         if (var4 == 3) {
            if (++var3 < var1) {
               var4 = var0.charAt(var3);
               if (C0114.bootstrap<"call",0,1>(var4)) {
                  if (++var3 < var1) {
                     var4 = var0.charAt(var3);
                     if (C0114.bootstrap<"call",0,1>(var4)) {
                        var3++;
                     }
                  }

                  if (var3 < var1) {
                     var4 = var0.charAt(var3);
                     if (var4 == ',') {
                        if (++var3 < var1) {
                           var4 = var0.charAt(var3);
                           if (C0114.bootstrap<"call",0,1>(var4)) {
                              if (++var3 < var1) {
                                 var4 = var0.charAt(var3);
                                 if (C0114.bootstrap<"call",0,1>(var4)) {
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

   public static String m_145771c0(String var0) {
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

   public static String m_2616ab7a(String var0) {
      return C0114.bootstrap<"call",1,1>(C0114.bootstrap<"call",0,1>(var0));
   }
}
