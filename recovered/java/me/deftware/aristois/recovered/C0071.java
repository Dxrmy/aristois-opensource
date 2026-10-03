package me.deftware.aristois.recovered;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import javax.imageio.ImageIO;
import me.deftware.client.framework.registry.BlockRegistry;
import me.deftware.client.framework.world.block.Block;

public class C0071 {
   public static final Block f_c6f7573e = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_6e2d03c3());
   public static final Block f_83bc8b61 = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_760db7bb());
   public static final Block f_4804720f = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_68957b31());
   public static final Block f_b20a8975 = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_4e02e7a9());
   public static final Block f_adbd1d51 = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_7f74d855());
   public static final Block f_ab96dc62 = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_b89b7876());
   public static final Block f_95072491 = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_a33fab52());
   public static final Block f_c686d65b = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_73708dd3());
   public static final Block f_96b89794 = C0207.m_6c580359(BlockRegistry.INSTANCE, C0266.m_96ba50d4());
   public static final Block f_e57a137f = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_96ba50d4());
   public static final Block f_0eadcd53 = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_88726494());
   public static final Block f_e29f51f3 = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_27479cfa());
   public static final Block f_b9cb311f = C0207.m_6c580359(BlockRegistry.INSTANCE, C0264.m_e7934778());
   public static final Block f_1d5e9526 = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_23f794da());
   public static final Block f_4e132e1e = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_cc27b633());
   public static final Block f_d503b57f = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_df6e621c());
   public static final Block f_b8217426 = C0207.m_6c580359(BlockRegistry.INSTANCE, C0264.m_d0e43f69());
   public static final Block f_9751c393 = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_56242a84());
   public static final Block f_153c92dd = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_9e27f038());
   public static final Block f_80ae02db = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_af41331f());
   public static final Block f_cdbb4931 = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_f257bcca());
   public static final Block f_43b9c78f = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_d9b37a36());
   public static final Block f_89066a04 = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_15737526());
   public static final Block f_caee3783 = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_6cf615ba());
   public static final Block f_12d5e360 = C0207.m_6c580359(BlockRegistry.INSTANCE, C0265.m_ecb46027());
   private static final Map<Block, Color> f_42db7bb8 = new ConcurrentHashMap<>();

   public C0071() {
   }

   public static Color m_b9636182(Block var0) {
      return m_1d810c95(var0, var0::getAsset);
   }

   public static Color m_1d810c95(Block var0, Callable<InputStream> var1) {
      return f_42db7bb8.computeIfAbsent(var0, var1x -> {
         Color var2 = Color.white;

         try (InputStream var3 = (InputStream)var1.call()) {
            BufferedImage var5 = ImageIO.read(var3);
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
            System.out.printf(C0265.m_022da1b4(), var1x.getIdentifierKey());
         }

         return var2;
      });
   }

   static {
      if (f_153c92dd != null) {
         f_42db7bb8.put(f_153c92dd, Color.red);
      }

      if (f_c6f7573e != null) {
         f_42db7bb8.put(f_c6f7573e, Color.green);
      }

      if (f_e57a137f != null) {
         f_42db7bb8.put(f_e57a137f, Color.red);
      }

      if (f_96b89794 != null) {
         f_42db7bb8.put(f_96b89794, Color.orange);
      }
   }
}
