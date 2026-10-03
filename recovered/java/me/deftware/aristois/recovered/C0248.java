package me.deftware.aristois.recovered;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.deftware.client.framework.minecraft.Minecraft;

public enum C0248 implements Runnable {
   f_2a1966bb;

   private Cipher f_14634599;
   private Cipher f_8c78ebdf;

   private C0248() {
   }

   @Override
   public void run() {
      try {
         KeyPair var1 = this.m_e09c5213(this.m_9a1c6321(C0256.m_68957b31()), this.m_9a1c6321(C0256.m_4e02e7a9()));
         SecretKey var2 = this.m_49770b58(this.m_9a1c6321(C0257.m_0d6ae39b()), var1);
         this.f_14634599 = Cipher.getInstance(C0256.m_7f74d855());
         this.f_14634599.init(1, var2, new IvParameterSpec(var2.getEncoded()));
         this.f_8c78ebdf = Cipher.getInstance(C0256.m_7f74d855());
         this.f_8c78ebdf.init(2, var2, new IvParameterSpec(var2.getEncoded()));
      } catch (Exception var3) {
         System.out.println(C0256.m_b89b7876());
      }
   }

   public String m_866a453e(String var1) {
      try {
         return new String(this.m_ab03ba8b(var1.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
      } catch (Exception var3) {
         return C0256.m_a33fab52();
      }
   }

   public String m_d46f830f(String var1) {
      try {
         return new String(this.m_f17629f1(var1.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
      } catch (Exception var3) {
         return C0256.m_73708dd3();
      }
   }

   public Path m_9a1c6321(String var1) {
      return new File(this.m_c8327f23().getAbsolutePath() + File.separator + var1).toPath();
   }

   public File m_c8327f23() {
      File var1 = new File(
         Minecraft.getMinecraftGame()._getGameDir(),
         C0264.m_2e834348()
            + File.separator
            + C0264.m_e07cee76()
            + File.separator
            + Minecraft.getMinecraftVersion()
            + File.separator
            + C0253.m_7b0db73e()
            + File.separator
            + C0256.m_4e02e7a9()
            + File.separator
      );
      if (!var1.exists() && !var1.mkdirs()) {
         System.out.println(C0256.m_96ba50d4());
      }

      return var1;
   }

   public void m_179bbfad(Path var1, String var2) throws Exception {
      Files.write(var1, this.m_ab03ba8b(var2.getBytes(StandardCharsets.UTF_8)));
   }

   public String m_a6427a0b(Path var1) throws Exception {
      return new String(this.m_f17629f1(Files.readAllBytes(var1)), StandardCharsets.UTF_8);
   }

   public byte[] m_ab03ba8b(byte[] var1) throws Exception {
      return Base64.getEncoder().encode(this.f_14634599.doFinal(var1));
   }

   public byte[] m_f17629f1(byte[] var1) throws Exception {
      return this.f_8c78ebdf.doFinal(Base64.getDecoder().decode(var1));
   }

   private KeyPair m_e09c5213(Path var1, Path var2) throws Exception {
      if (!Files.notExists(var1) && !Files.notExists(var2)) {
         try {
            return this.m_6a774ca6(var1, var2);
         } catch (ReflectiveOperationException | IOException | GeneralSecurityException var4) {
            var4.printStackTrace();
            return this.m_d2aad824(var1, var2);
         }
      } else {
         return this.m_d2aad824(var1, var2);
      }
   }

   private SecretKey m_49770b58(Path var1, KeyPair var2) throws Exception {
      if (Files.notExists(var1)) {
         return this.m_d35d3d64(var1, var2);
      } else {
         try {
            return this.m_fea85584(var1, var2);
         } catch (IOException | GeneralSecurityException var4) {
            var4.printStackTrace();
            return this.m_d35d3d64(var1, var2);
         }
      }
   }

   private KeyPair m_d2aad824(Path var1, Path var2) throws Exception {
      KeyPairGenerator var3 = KeyPairGenerator.getInstance(C0264.m_afb31f66());
      var3.initialize(1024);
      KeyPair var4 = var3.generateKeyPair();
      KeyFactory var5 = KeyFactory.getInstance(C0264.m_afb31f66());

      try (ObjectOutputStream var6 = new ObjectOutputStream(Files.newOutputStream(var1))) {
         RSAPublicKeySpec var8 = var5.getKeySpec(var4.getPublic(), RSAPublicKeySpec.class);
         var6.writeObject(var8.getModulus());
         var6.writeObject(var8.getPublicExponent());
      }

      try (ObjectOutputStream var34 = new ObjectOutputStream(Files.newOutputStream(var2))) {
         RSAPrivateKeySpec var36 = var5.getKeySpec(var4.getPrivate(), RSAPrivateKeySpec.class);
         var34.writeObject(var36.getModulus());
         var34.writeObject(var36.getPrivateExponent());
      }

      return var4;
   }

   private SecretKey m_d35d3d64(Path var1, KeyPair var2) throws Exception {
      KeyGenerator var3 = KeyGenerator.getInstance(C0256.m_88726494());
      var3.init(128);
      SecretKey var4 = var3.generateKey();
      Cipher var5 = Cipher.getInstance(C0264.m_afb31f66());
      var5.init(1, var2.getPublic());
      Files.write(var1, var5.doFinal(var4.getEncoded()));
      return var4;
   }

   private KeyPair m_6a774ca6(Path var1, Path var2) throws GeneralSecurityException, ReflectiveOperationException, IOException {
      KeyFactory var3 = KeyFactory.getInstance(C0264.m_afb31f66());

      PublicKey var4;
      try (ObjectInputStream var5 = new ObjectInputStream(Files.newInputStream(var1))) {
         var4 = var3.generatePublic(new RSAPublicKeySpec((BigInteger)var5.readObject(), (BigInteger)var5.readObject()));
      }

      PrivateKey var33;
      try (ObjectInputStream var34 = new ObjectInputStream(Files.newInputStream(var2))) {
         var33 = var3.generatePrivate(new RSAPrivateKeySpec((BigInteger)var34.readObject(), (BigInteger)var34.readObject()));
      }

      return new KeyPair(var4, var33);
   }

   private SecretKey m_fea85584(Path var1, KeyPair var2) throws GeneralSecurityException, IOException {
      Cipher var3 = Cipher.getInstance(C0264.m_afb31f66());
      var3.init(2, var2.getPrivate());
      return new SecretKeySpec(var3.doFinal(Files.readAllBytes(var1)), C0256.m_88726494());
   }
}
