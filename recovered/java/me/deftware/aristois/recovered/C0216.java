package me.deftware.aristois.recovered;

import java.nio.file.Path;
import java.util.Optional;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;

public class C0216 {
   private final String f_314bd2dc;
   private final String f_75383362;
   private PointerBuffer f_725c3455;
   private MemoryStack f_af8d3617;

   public C0216(String var1, String var2, String... var3) {
      this.f_314bd2dc = var1;
      this.f_75383362 = var2;
      if (C0213.f_1bc818b5.m_093ae25a()) {
         this.f_af8d3617 = C0114.bootstrap<"call",0,1>();
         this.f_725c3455 = this.f_af8d3617.mallocPointer(var3.length);

         for (String var7 : var3) {
            this.f_725c3455.put(this.f_af8d3617.UTF8(var7));
         }

         this.f_725c3455.flip();
      }
   }

   public Optional<Path> m_c534f7d0() {
      if (C0213.f_1bc818b5.m_093ae25a()) {
         String var1 = C0114.bootstrap<"call",0,1>(this.f_314bd2dc, C0252.bootstrap<"get",55834574957>(), this.f_725c3455, this.f_75383362);
         this.f_af8d3617.pop();
         if (var1 != null && !var1.isEmpty()) {
            return C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(var1, new String[0]));
         }
      }

      return C0114.bootstrap<"call",3,1>();
   }

   public Optional<Path> m_b8b58442() {
      if (C0213.f_1bc818b5.m_093ae25a()) {
         String var1 = C0114.bootstrap<"call",0,1>(this.f_314bd2dc, C0252.bootstrap<"get",55834574957>(), this.f_725c3455, this.f_75383362, false);
         this.f_af8d3617.pop();
         if (var1 != null && !var1.isEmpty()) {
            return C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>(var1, new String[0]));
         }
      }

      return C0114.bootstrap<"call",3,1>();
   }
}
