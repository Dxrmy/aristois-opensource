package me.deftware.aristois.recovered;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import me.deftware.client.framework.config.Settings;

public class C0449 extends C0448 {
   public static final int f_8f993a33 = 498465498;
   public static final Path f_f911bf3c = Settings.configDir.resolve(C0252.bootstrap<"get",60129542199>());
   private final Map<Long, Set<Integer>> f_74037400 = new HashMap<>();
   private boolean f_86f95b72 = false;
   private final Path f_9f1c2f45;
   private final Path f_11a3779c;

   public C0449(int var1, int var2, int var3) {
      super(var1, var2, var3);
      String var4 = C0114.bootstrap<"call",0,1>();
      this.f_9f1c2f45 = f_f911bf3c.resolve(var4).resolve(C0252.bootstrap<"get",60129542190>());
      this.f_11a3779c = this.f_9f1c2f45
         .resolve(
            C0114.bootstrap<"call",2,1>(
               C0252.bootstrap<"get",60129542191>(),
               new Object[]{C0114.bootstrap<"call",1,1>(var1), C0114.bootstrap<"call",1,1>(var2), C0114.bootstrap<"call",1,1>(var3)}
            )
         );
   }

   public void m_bb6c7f0f() {
      if (C0114.bootstrap<"call",0,1>(this.f_11a3779c, new LinkOption[0])) {
         try (
            InputStream var1 = C0114.bootstrap<"call",1,1>(this.f_11a3779c, new OpenOption[0]);
            GZIPInputStream var3 = new GZIPInputStream(var1);
            DataInputStream var5 = new DataInputStream(var3);
         ) {
            int var7 = var5.readInt();
            if (var7 != 498465498) {
               throw new UnsupportedEncodingException(C0252.bootstrap<"get",60129542192>() + f_f911bf3c + C0252.bootstrap<"get",17179869188>() + var7);
            }

            int var8 = var5.readInt();
            if (var8 != C0114.bootstrap<"call",2,1>()) {
               System.err.println(C0252.bootstrap<"get",60129542193>());
            }

            int var9 = var5.readInt();
            System.out.println(C0252.bootstrap<"get",60129542194>() + var9 + C0252.bootstrap<"get",60129542195>() + this.f_11a3779c.getFileName());

            for (int var10 = 0; var10 < var9; var10++) {
               long var11 = var5.readLong();
               int var13 = var5.readInt();
               HashSet var14 = new HashSet();

               for (int var15 = 0; var15 < var13; var15++) {
                  int var16 = var5.readInt();
                  var14.add(C0114.bootstrap<"call",3,1>(var16));
               }

               this.f_74037400.put(C0114.bootstrap<"call",4,1>(var11), var14);
            }
         } catch (Exception var68) {
            var68.printStackTrace();
         }
      }
   }

   public void m_33b568ef() {
      if (this.f_86f95b72) {
         try {
            if (!C0114.bootstrap<"call",0,1>(this.f_9f1c2f45, new LinkOption[0])) {
               C0114.bootstrap<"call",1,1>(this.f_9f1c2f45, new FileAttribute[0]);
            }

            int var1 = 0;
            int var2 = (int)this.f_74037400.values().stream().filter(var0 -> !var0.isEmpty()).count();
            if (var2 > 0) {
               try (
                  OutputStream var3 = C0114.bootstrap<"call",2,1>(this.f_11a3779c, new OpenOption[0]);
                  GZIPOutputStream var5 = new GZIPOutputStream(var3);
                  DataOutputStream var7 = new DataOutputStream(var5);
               ) {
                  var7.writeInt(498465498);
                  var7.writeInt(C0114.bootstrap<"call",3,1>());
                  var7.writeInt(var2);

                  for (Entry var10 : this.f_74037400.entrySet()) {
                     Set var11 = (Set)var10.getValue();
                     if (!var11.isEmpty()) {
                        var7.writeLong((Long)var10.getKey());
                        var7.writeInt(var11.size());
                        var1 += var11.size();

                        for (Integer var13 : var11) {
                           var7.writeInt(var13);
                        }
                     }
                  }
               }

               System.out
                  .println(
                     C0252.bootstrap<"get",60129542196>()
                        + var1
                        + C0252.bootstrap<"get",60129542197>()
                        + var2
                        + C0252.bootstrap<"get",60129542198>()
                        + this.f_11a3779c.getFileName()
                  );
            }
         } catch (Exception var65) {
            var65.printStackTrace();
         }
      }
   }

   public void m_e2783c8e() {
      this.f_86f95b72 = true;
   }

   public Map<Long, Set<Integer>> m_780133c6() {
      return this.f_74037400;
   }

   static {
      if (!C0114.bootstrap<"call",0,1>(f_f911bf3c, new LinkOption[0])) {
         try {
            C0114.bootstrap<"call",1,1>(f_f911bf3c, new FileAttribute[0]);
         } catch (Exception var1) {
            var1.printStackTrace();
         }
      }
   }
}
