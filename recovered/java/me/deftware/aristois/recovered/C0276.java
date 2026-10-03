package me.deftware.aristois.recovered;

import me.deftware.client.framework.entity.types.EntityPlayer;

public class C0276 extends C0277 {
   private final int f_799802f2;

   public C0276(int var1, EntityPlayer var2) {
      super(var1, var2);
      this.f_799802f2 = var2.getFoodLevel();
      this.f_d3b5dda9 = var1x -> var1x.getFoodLevel() <= this.f_799802f2;
   }
}
