package me.deftware.aristois.services.types;

import me.deftware.aristois.services.Service;
import me.deftware.client.framework.event.EventBus;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventWorldLoad;

@Service(
   value = {"kaptainwutax.seedcrackerX.SeedCracker"},
   source = {"https://github.com/19MisterX98/SeedcrackerX/", "https://github.com/KaptainWutax/SeedCracker"},
   name = "SeedCracker"
)
public class SeedCrackerService implements Runnable {
   public SeedCrackerService() {
   }

   @Override
   public void run() {
      EventBus.registerClass(this.getClass(), this);
   }

   @EventHandler
   private void onWorldLoad(EventWorldLoad event) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.struct.gen.VarType.isGeneric()" because "newRet" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.InvocationExprent.getInferredExprType(InvocationExprent.java:634)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.ArrayExprent.getInferredExprType(ArrayExprent.java:45)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.getCastedExprent(ExprProcessor.java:966)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.AssignmentExprent.toJava(AssignmentExprent.java:154)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.listToJava(ExprProcessor.java:895)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.BasicBlockStatement.toJava(BasicBlockStatement.java:90)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.IfStatement.toJava(IfStatement.java:203)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.CatchStatement.toJava(CatchStatement.java:166)
      //   at org.jetbrains.java.decompiler.modules.decompiler.ExprProcessor.jmpWrapper(ExprProcessor.java:833)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.SequenceStatement.toJava(SequenceStatement.java:107)
      //   at org.jetbrains.java.decompiler.modules.decompiler.stats.RootStatement.toJava(RootStatement.java:36)
      //   at org.jetbrains.java.decompiler.main.ClassWriter.writeMethod(ClassWriter.java:1283)
      //
      // Bytecode:
      // 00: ldc "kaptainwutax.seedcrackerX.config.Config"
      // 02: astore 2
      // 03: aload 2
      // 04: invokestatic java/lang/Class.forName (Ljava/lang/String;)Ljava/lang/Class;
      // 07: astore 3
      // 08: new java/lang/StringBuilder
      // 0b: dup
      // 0c: invokespecial java/lang/StringBuilder.<init> ()V
      // 0f: aload 2
      // 10: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 13: ldc "$RenderType"
      // 15: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 18: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 1b: invokestatic java/lang/Class.forName (Ljava/lang/String;)Ljava/lang/Class;
      // 1e: astore 4
      // 20: aload 3
      // 21: ldc "get"
      // 23: bipush 0
      // 24: anewarray 46
      // 27: invokevirtual java/lang/Class.getMethod (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      // 2a: aconst_null
      // 2b: bipush 0
      // 2c: anewarray 4
      // 2f: invokevirtual java/lang/reflect/Method.invoke (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      // 32: astore 5
      // 34: aload 4
      // 36: invokevirtual java/lang/Class.getEnumConstants ()[Ljava/lang/Object;
      // 39: bipush 0
      // 3a: aaload
      // 3b: astore 6
      // 3d: aload 3
      // 3e: ldc "render"
      // 40: invokevirtual java/lang/Class.getField (Ljava/lang/String;)Ljava/lang/reflect/Field;
      // 43: astore 7
      // 45: aload 7
      // 47: aload 5
      // 49: invokevirtual java/lang/reflect/Field.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 4c: aload 6
      // 4e: if_acmpeq 79
      // 51: aload 7
      // 53: aload 5
      // 55: aload 6
      // 57: invokevirtual java/lang/reflect/Field.set (Ljava/lang/Object;Ljava/lang/Object;)V
      // 5a: aload 3
      // 5b: ldc "save"
      // 5d: bipush 0
      // 5e: anewarray 46
      // 61: invokevirtual java/lang/Class.getMethod (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      // 64: aload 5
      // 66: bipush 0
      // 67: anewarray 4
      // 6a: invokevirtual java/lang/reflect/Method.invoke (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      // 6d: pop
      // 6e: ldc2_w 1000
      // 71: invokedynamic run ()Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, me/deftware/aristois/services/types/SeedCrackerService.lambda$onWorldLoad$0 ()V, ()V ]
      // 76: invokestatic me/deftware/aristois/recovered/C0217.m_124336d4 (JLjava/lang/Runnable;)V
      // 79: goto 81
      // 7c: astore 2
      // 7d: aload 2
      // 7e: invokevirtual java/lang/Throwable.printStackTrace ()V
      // 81: return
   }
}
