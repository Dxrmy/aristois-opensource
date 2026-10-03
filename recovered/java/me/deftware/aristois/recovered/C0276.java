package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.EntityPlayer;

public class C0276 extends C0277 {
   private final int f_cd6fe205;

   public C0276(int var1, EntityPlayer var2) {
      super(var1, var2);
      this.f_cd6fe205 = var2.getFoodLevel();
      this.f_06024348 = var1x -> var1x.getFoodLevel() <= this.f_cd6fe205;
   }
}
