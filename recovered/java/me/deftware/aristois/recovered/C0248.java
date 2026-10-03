package me.deftware.aristois.recovered;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public enum C0248 implements Runnable {
   f_960164e1;

   private Cipher f_5797f47c;
   private Cipher f_4c9b0e39;

   private C0248() {
   }

   @Override
   public void run() {
      try {
         KeyPair var1 = this.m_a82a87bc(this.m_3325b5f9(C0252.bootstrap<"get",55834574894>()), this.m_3325b5f9(C0252.bootstrap<"get",55834574895>()));
         SecretKey var2 = this.m_3d5b5aa5(this.m_3325b5f9(C0252.bootstrap<"get",127>()), var1);
         this.f_5797f47c = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",55834574896>());
         this.f_5797f47c.init(1, var2, new IvParameterSpec(var2.getEncoded()));
         this.f_4c9b0e39 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",55834574896>());
         this.f_4c9b0e39.init(2, var2, new IvParameterSpec(var2.getEncoded()));
      } catch (Exception var3) {
         System.out.println(C0252.bootstrap<"get",55834574897>());
      }
   }

   public String m_107e39bc(String var1) {
      try {
         return new String(this.m_572b85b1(var1.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
      } catch (Exception var3) {
         return C0252.bootstrap<"get",55834574898>();
      }
   }

   public String m_9b3daa32(String var1) {
      try {
         return new String(this.m_9a297da2(var1.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
      } catch (Exception var3) {
         return C0252.bootstrap<"get",55834574899>();
      }
   }

   public Path m_3325b5f9(String var1) {
      return new File(this.m_ac131abf().getAbsolutePath() + File.separator + var1).toPath();
   }

   public File m_ac131abf() {
      File var1 = new File(
         C0114.bootstrap<"call",0,1>()._getGameDir(),
         C0252.bootstrap<"get",4294967320>()
            + File.separator
            + C0252.bootstrap<"get",4294967321>()
            + File.separator
            + C0114.bootstrap<"call",1,1>()
            + File.separator
            + C0252.bootstrap<"get",8589934618>()
            + File.separator
            + C0252.bootstrap<"get",55834574895>()
            + File.separator
      );
      if (!var1.exists() && !var1.mkdirs()) {
         System.out.println(C0252.bootstrap<"get",55834574900>());
      }

      return var1;
   }

   public void m_4fd03dfb(Path var1, String var2) throws Exception {
      C0114.bootstrap<"call",2,1>(var1, this.m_572b85b1(var2.getBytes(StandardCharsets.UTF_8)), new OpenOption[0]);
   }

   public String m_ac7cc261(Path var1) throws Exception {
      return new String(this.m_9a297da2(C0114.bootstrap<"call",3,1>(var1)), StandardCharsets.UTF_8);
   }

   public byte[] m_572b85b1(byte[] var1) throws Exception {
      return C0114.bootstrap<"call",4,1>().encode(this.f_5797f47c.doFinal(var1));
   }

   public byte[] m_9a297da2(byte[] var1) throws Exception {
      return this.f_4c9b0e39.doFinal(C0114.bootstrap<"call",0,1>().decode(var1));
   }

   private KeyPair m_a82a87bc(Path var1, Path var2) throws Exception {
      if (!C0114.bootstrap<"call",5,1>(var1, new LinkOption[0]) && !C0114.bootstrap<"call",5,1>(var2, new LinkOption[0])) {
         try {
            return this.m_29223566(var1, var2);
         } catch (ReflectiveOperationException | IOException | GeneralSecurityException var4) {
            var4.printStackTrace();
            return this.m_272ecd8d(var1, var2);
         }
      } else {
         return this.m_272ecd8d(var1, var2);
      }
   }

   private SecretKey m_3d5b5aa5(Path var1, KeyPair var2) throws Exception {
      if (C0114.bootstrap<"call",5,1>(var1, new LinkOption[0])) {
         return this.m_2fb8251d(var1, var2);
      } else {
         try {
            return this.m_5ec06ff3(var1, var2);
         } catch (IOException | GeneralSecurityException var4) {
            var4.printStackTrace();
            return this.m_2fb8251d(var1, var2);
         }
      }
   }

   private KeyPair m_272ecd8d(Path var1, Path var2) throws Exception {
      KeyPairGenerator var3 = C0114.bootstrap<"call",1,1>(C0252.bootstrap<"get",4294967335>());
      var3.initialize(1024);
      KeyPair var4 = var3.generateKeyPair();
      KeyFactory var5 = C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",4294967335>());

      try (ObjectOutputStream var6 = new ObjectOutputStream(C0114.bootstrap<"call",3,1>(var1, new OpenOption[0]))) {
         RSAPublicKeySpec var8 = var5.getKeySpec(var4.getPublic(), RSAPublicKeySpec.class);
         var6.writeObject(var8.getModulus());
         var6.writeObject(var8.getPublicExponent());
      }

      try (ObjectOutputStream var34 = new ObjectOutputStream(C0114.bootstrap<"call",3,1>(var2, new OpenOption[0]))) {
         RSAPrivateKeySpec var36 = var5.getKeySpec(var4.getPrivate(), RSAPrivateKeySpec.class);
         var34.writeObject(var36.getModulus());
         var34.writeObject(var36.getPrivateExponent());
      }

      return var4;
   }

   private SecretKey m_2fb8251d(Path var1, KeyPair var2) throws Exception {
      KeyGenerator var3 = C0114.bootstrap<"call",4,1>(C0252.bootstrap<"get",55834574901>());
      var3.init(128);
      SecretKey var4 = var3.generateKey();
      Cipher var5 = C0114.bootstrap<"call",5,1>(C0252.bootstrap<"get",4294967335>());
      var5.init(1, var2.getPublic());
      C0114.bootstrap<"call",6,1>(var1, var5.doFinal(var4.getEncoded()), new OpenOption[0]);
      return var4;
   }

   private KeyPair m_29223566(Path var1, Path var2) throws GeneralSecurityException, ReflectiveOperationException, IOException {
      KeyFactory var3 = C0114.bootstrap<"call",0,1>(C0252.bootstrap<"get",4294967335>());

      PublicKey var4;
      try (ObjectInputStream var5 = new ObjectInputStream(C0114.bootstrap<"call",1,1>(var1, new OpenOption[0]))) {
         var4 = var3.generatePublic(new RSAPublicKeySpec((BigInteger)var5.readObject(), (BigInteger)var5.readObject()));
      }

      PrivateKey var33;
      try (ObjectInputStream var34 = new ObjectInputStream(C0114.bootstrap<"call",1,1>(var2, new OpenOption[0]))) {
         var33 = var3.generatePrivate(new RSAPrivateKeySpec((BigInteger)var34.readObject(), (BigInteger)var34.readObject()));
      }

      return new KeyPair(var4, var33);
   }

   private SecretKey m_5ec06ff3(Path var1, KeyPair var2) throws GeneralSecurityException, IOException {
      Cipher var3 = C0114.bootstrap<"call",2,1>(C0252.bootstrap<"get",4294967335>());
      var3.init(2, var2.getPrivate());
      return new SecretKeySpec(var3.doFinal(C0114.bootstrap<"call",3,1>(var1)), C0252.bootstrap<"get",55834574901>());
   }
}
