package me.deftware.aristois.recovered;

import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.global.GameMap;
import me.deftware.client.framework.global.IGameKey;

public class C0104<T> implements C0105<T> {
   protected final IGameKey f_7b605818;
   protected final T f_9f18701b;
   protected T f_1dd63561;
   protected AbstractMod f_1df79726;

   @Override
   public T m_50ca8f08() {
      return (T)(this.f_1dd63561 != null ? this.f_1dd63561 : GameMap.INSTANCE.get(this.f_7b605818, this.f_9f18701b));
   }

   @Override
   public void m_a32b61ee(Object var1) {
      this.f_1dd63561 = (T)var1;
      if (this.f_1df79726 == null || this.f_1df79726.isEnabled()) {
         GameMap.INSTANCE.put(this.f_7b605818, this.f_1dd63561);
      }
   }

   public void m_1058ed9a() {
      GameMap.INSTANCE.remove(this.f_7b605818);
   }

   public void m_fd4438d8() {
      if (this.f_1dd63561 == null) {
         this.f_1dd63561 = this.f_9f18701b;
      }

      this.m_a32b61ee(this.f_1dd63561);
   }

   public C0104<T> m_43d84283(AbstractMod var1) {
      this.f_1df79726 = var1;
      var1.getToggleWatch().add(var1x -> {
         if (!var1x) {
            this.m_1058ed9a();
         } else {
            this.m_fd4438d8();
         }
      });
      return this;
   }

   @Override
   public boolean m_e0f7c666() {
      return true;
   }

   public C0104(IGameKey var1, T var2) {
      this.f_7b605818 = var1;
      this.f_9f18701b = (T)var2;
   }
}
