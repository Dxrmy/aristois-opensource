package me.deftware.aristois.recovered;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.util.tinyfd.TinyFileDialogs;

public class C0216 {
   private final String f_39799e34;
   private final String f_7236b6f3;
   private PointerBuffer f_e62c208f;
   private MemoryStack f_974282d7;

   public C0216(String var1, String var2, String... var3) {
      this.f_39799e34 = var1;
      this.f_7236b6f3 = var2;
      if (C0213.f_203f1aa7.m_efa7610e()) {
         this.f_974282d7 = MemoryStack.stackPush();
         this.f_e62c208f = this.f_974282d7.mallocPointer(var3.length);

         for (String var7 : var3) {
            this.f_e62c208f.put(this.f_974282d7.UTF8(var7));
         }

         this.f_e62c208f.flip();
      }
   }

   public Optional<Path> m_cb9b9d68() {
      if (C0213.f_203f1aa7.m_efa7610e()) {
         String var1 = TinyFileDialogs.tinyfd_saveFileDialog(this.f_39799e34, C0256.m_37c08c9d(), this.f_e62c208f, this.f_7236b6f3);
         this.f_974282d7.pop();
         if (var1 != null && !var1.isEmpty()) {
            return Optional.of(Paths.get(var1));
         }
      }

      return Optional.empty();
   }

   public Optional<Path> m_2684dcf7() {
      if (C0213.f_203f1aa7.m_efa7610e()) {
         String var1 = TinyFileDialogs.tinyfd_openFileDialog(this.f_39799e34, C0256.m_37c08c9d(), this.f_e62c208f, this.f_7236b6f3, false);
         this.f_974282d7.pop();
         if (var1 != null && !var1.isEmpty()) {
            return Optional.of(Paths.get(var1));
         }
      }

      return Optional.empty();
   }
}
