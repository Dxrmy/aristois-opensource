package me.deftware.aristois.recovered;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import me.deftware.client.framework.config.Settings;
import me.deftware.client.framework.minecraft.Minecraft;

public class C0449 extends C0448 {
   public static final int f_aead397a = 498465498;
   public static final Path f_b877dc05 = Settings.configDir.resolve(C0258.m_23f794da());
   private final Map<Long, Set<Integer>> f_b0a9aa75 = new HashMap<>();
   private boolean f_84145127 = false;
   private final Path f_8bf7094c;
   private final Path f_0e5b83d2;

   public C0449(int var1, int var2, int var3) {
      super(var1, var2, var3);
      String var4 = C0451.m_d32ebe65();
      this.f_8bf7094c = f_b877dc05.resolve(var4).resolve(C0258.m_68957b31());
      this.f_0e5b83d2 = this.f_8bf7094c.resolve(String.format(C0258.m_4e02e7a9(), var1, var2, var3));
   }

   public void m_23674f64() {
      if (Files.exists(this.f_0e5b83d2)) {
         try (
            InputStream var1 = Files.newInputStream(this.f_0e5b83d2);
            GZIPInputStream var3 = new GZIPInputStream(var1);
            DataInputStream var5 = new DataInputStream(var3);
         ) {
            int var7 = var5.readInt();
            if (var7 != 498465498) {
               throw new UnsupportedEncodingException(C0258.m_7f74d855() + f_b877dc05 + C0261.m_4626ac74() + var7);
            }

            int var8 = var5.readInt();
            if (var8 != Minecraft.getMinecraftProtocolVersion()) {
               System.err.println(C0258.m_b89b7876());
            }

            int var9 = var5.readInt();
            System.out.println(C0258.m_a33fab52() + var9 + C0258.m_73708dd3() + this.f_0e5b83d2.getFileName());

            for (int var10 = 0; var10 < var9; var10++) {
               long var11 = var5.readLong();
               int var13 = var5.readInt();
               HashSet var14 = new HashSet();

               for (int var15 = 0; var15 < var13; var15++) {
                  int var16 = var5.readInt();
                  var14.add(var16);
               }

               this.f_b0a9aa75.put(var11, var14);
            }
         } catch (Exception var68) {
            var68.printStackTrace();
         }
      }
   }

   public void m_f1ec3ae8() {
      if (this.f_84145127) {
         try {
            if (!Files.exists(this.f_8bf7094c)) {
               Files.createDirectories(this.f_8bf7094c);
            }

            int var1 = 0;
            int var2 = (int)this.f_b0a9aa75.values().stream().filter(var0 -> !var0.isEmpty()).count();
            if (var2 > 0) {
               try (
                  OutputStream var3 = Files.newOutputStream(this.f_0e5b83d2);
                  GZIPOutputStream var5 = new GZIPOutputStream(var3);
                  DataOutputStream var7 = new DataOutputStream(var5);
               ) {
                  var7.writeInt(498465498);
                  var7.writeInt(Minecraft.getMinecraftProtocolVersion());
                  var7.writeInt(var2);

                  for (Entry var10 : this.f_b0a9aa75.entrySet()) {
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

               System.out.println(C0258.m_96ba50d4() + var1 + C0258.m_88726494() + var2 + C0258.m_27479cfa() + this.f_0e5b83d2.getFileName());
            }
         } catch (Exception var65) {
            var65.printStackTrace();
         }
      }
   }

   public void m_0e389a72() {
      this.f_84145127 = true;
   }

   public Map<Long, Set<Integer>> m_203344cd() {
      return this.f_b0a9aa75;
   }

   static {
      if (!Files.exists(f_b877dc05)) {
         try {
            Files.createDirectories(f_b877dc05);
         } catch (Exception var1) {
            var1.printStackTrace();
         }
      }
   }
}
