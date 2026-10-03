package me.deftware.aristois.recovered;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.world.block.Block;

public class C0071 {
   public static final Block f_d91ec95d = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771116>());
   public static final Block f_a29f3429 = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771117>());
   public static final Block f_594b4884 = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771118>());
   public static final Block f_eb4d77a9 = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771119>());
   public static final Block f_f5c338c0 = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771120>());
   public static final Block f_5c7ed30b = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771121>());
   public static final Block f_c7c6621d = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771122>());
   public static final Block f_47f5415c = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771123>());
   public static final Block f_ce67562d = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",12884901940>());
   public static final Block f_3bf79199 = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771124>());
   public static final Block f_5727aaf5 = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771125>());
   public static final Block f_0942e113 = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771126>());
   public static final Block f_633dfc7a = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",4294967375>());
   public static final Block f_1eed9530 = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771127>());
   public static final Block f_ac8f8cb8 = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771128>());
   public static final Block f_6276ab1d = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771129>());
   public static final Block f_534eec6c = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",4294967376>());
   public static final Block f_55bb623e = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771130>());
   public static final Block f_9b9b8c1d = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771131>());
   public static final Block f_19c3efd9 = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771132>());
   public static final Block f_88dee4bd = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771133>());
   public static final Block f_a208b2a3 = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771134>());
   public static final Block f_dfe32957 = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771135>());
   public static final Block f_6f1d2d8d = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771136>());
   public static final Block f_10cf7abf = (Block)C0114.bootstrap<"call",0,1>(BlockRegistry.INSTANCE, C0252.bootstrap<"get",30064771137>());
   private static final Map<Block, Color> f_4dfe7310 = new ConcurrentHashMap<>();

   public C0071() {
   }

   public static Color m_f5e6365a(Block var0) {
      return C0114.bootstrap<"call",0,1>(var0, var0::getAsset);
   }

   public static Color m_8e98ac53(Block var0, Callable<InputStream> var1) {
      return f_4dfe7310.computeIfAbsent(var0, var1x -> {
         Color var2 = Color.white;

         try (InputStream var3 = (InputStream)var1.call()) {
            BufferedImage var5 = C0114.bootstrap<"call",1,1>(var3);
            long var6 = 0L;
            long var8 = 0L;
            long var10 = 0L;

            for (int var12 = 0; var12 < var5.getWidth(); var12++) {
               for (int var13 = 0; var13 < var5.getHeight(); var13++) {
                  Color var14 = new Color(var5.getRGB(var12, var13));
                  var6 += (long)var14.getRed();
                  var8 += (long)var14.getGreen();
                  var10 += (long)var14.getBlue();
               }
            }

            int var26 = var5.getWidth() * var5.getHeight();
            var2 = new Color((int)var6 / var26, (int)var8 / var26, (int)var10 / var26);
         } catch (Exception var25) {
            System.out.printf(C0252.bootstrap<"get",30064771115>(), var1x.getIdentifierKey());
         }

         return var2;
      });
   }

   static {
      if (f_9b9b8c1d != null) {
         f_4dfe7310.put(f_9b9b8c1d, Color.red);
      }

      if (f_d91ec95d != null) {
         f_4dfe7310.put(f_d91ec95d, Color.green);
      }

      if (f_3bf79199 != null) {
         f_4dfe7310.put(f_3bf79199, Color.red);
      }

      if (f_ce67562d != null) {
         f_4dfe7310.put(f_ce67562d, Color.orange);
      }
   }
}
