package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameMap;
import me.deftware.client.framework.global.IGameKey;

public class C0104<T> implements C0105<T> {
   protected final IGameKey f_044fbf09;
   protected final T f_0117d71e;
   protected T f_3e324f91;
   protected AbstractMod f_d5d39aa6;

   public T m_113f38d3() {
      return (T)(this.f_3e324f91 != null ? this.f_3e324f91 : GameMap.INSTANCE.get(this.f_044fbf09, this.f_0117d71e));
   }

   public void m_91c3a4e2(Object var1) {
      this.f_3e324f91 = (T)var1;
      if (this.f_d5d39aa6 == null || this.f_d5d39aa6.isEnabled()) {
         GameMap.INSTANCE.put(this.f_044fbf09, this.f_3e324f91);
      }
   }

   public void m_3be40943() {
      GameMap.INSTANCE.remove(this.f_044fbf09);
   }

   public void m_5ad907bf() {
      if (this.f_3e324f91 == null) {
         this.f_3e324f91 = this.f_0117d71e;
      }

      this.m_91c3a4e2(this.f_3e324f91);
   }

   public C0104<T> m_958520b0(AbstractMod var1) {
      this.f_d5d39aa6 = var1;
      var1.getToggleWatch().add(var1x -> {
         if (!var1x) {
            this.m_3be40943();
         } else {
            this.m_5ad907bf();
         }
      });
      return this;
   }

   public boolean m_2e055eb6() {
      return true;
   }

   public C0104(IGameKey var1, T var2) {
      this.f_044fbf09 = var1;
      this.f_0117d71e = (T)var2;
   }
}
