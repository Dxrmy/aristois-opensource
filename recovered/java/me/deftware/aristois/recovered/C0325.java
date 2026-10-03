package me.deftware.aristois.recovered;

import java.awt.Color;
import me.deftware.aristois.modules.AbstractMod;
import me.deftware.client.framework.entity.Entity;
import me.deftware.client.framework.entity.block.StorageEntity;
import me.deftware.client.framework.entity.types.EntityPlayer;
import me.deftware.client.framework.entity.types.LivingEntity;
import me.deftware.client.framework.entity.types.objects.ItemEntity;
import me.deftware.client.framework.event.EventHandler;
import me.deftware.client.framework.event.events.EventRender3DNoBobbing;
import me.deftware.client.framework.gui.GuiScreen;
import me.deftware.client.framework.item.Item;
import me.deftware.client.framework.minecraft.GameSetting;
import me.deftware.client.framework.render.batching.LineRenderStack;
import me.deftware.client.framework.render.gl.GLX;

public class C0325 extends AbstractMod {
   private static final C0201 f_be91f5ff = new C0201(C0252.bootstrap<"get",51539607564>());
   private static final C0219<Item> f_2760d5e3 = new C0219<>(Item.class, C0252.bootstrap<"get",51539607565>());
   @C0098("Players")
   private boolean f_420306a3 = true;
   @C0098(
      value = "Storage",
      description = {"Chests/ShulkerBoxes/Barrels/etc"}
   )
   private boolean f_23a99e09 = false;
   @C0098(
      value = "Hidden",
      description = {"Draw tracers to hidden entities"}
   )
   private boolean f_8d7e5e07 = false;
   @C0098("Selected Entities")
   private final GuiScreen f_16efc57a = C0114.bootstrap<"call",0,1>(null, f_be91f5ff);
   @C0098("Selected Items")
   private final GuiScreen f_b96beb6c = C0114.bootstrap<"call",1,1>(null, f_2760d5e3);
   private final LineRenderStack f_cd552d54 = new LineRenderStack();

   public C0325() {
      super(C0252.bootstrap<"get",51539607562>(), C0290.f_5d5ce22b, C0252.bootstrap<"get",51539607563>());
   }

   @EventHandler
   public void m_f2585c6e(EventRender3DNoBobbing var1) {
      if (C0114.bootstrap<"call",0,1>() != null && !(Boolean)GameSetting.DEBUG_INFO.get()) {
         Entity var2 = (Entity)C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>()._getCameraEntity());
         Entity var3 = (Entity)C0114.bootstrap<"call",2,1>(C0114.bootstrap<"call",1,1>()._getPlayer());
         C0114.bootstrap<"call",3,1>();
         GLX.INSTANCE.color(1.0F, 1.0F, 1.0F, 1.0F);
         this.f_cd552d54.begin();
         if (this.f_23a99e09) {
            C0114.bootstrap<"call",0,1>()
               .getLoadedTileEntities()
               .filter(var0 -> var0 instanceof StorageEntity)
               .map(StorageEntity.class::cast)
               .forEach(var1x -> ((LineRenderStack)this.f_cd552d54.glColor(C0114.bootstrap<"call",8,1>(var1x.getBlock()), 190.0F)).lineToEntity(var1x));
         }

         C0114.bootstrap<"call",0,1>()
            .getLoadedEntities()
            .filter(var1x -> !var1x.isInvisible() || this.f_8d7e5e07)
            .filter(var0 -> C0114.bootstrap<"call",1,1>() ? !C0114.bootstrap<"call",2,1>(var0) : !var0.isSelf())
            .filter(var1x -> !var3.isRiding() || var3.getVehicle().getEntityId() != var1x.getEntityId())
            .filter(
               var1x -> {
                  if (var1x instanceof ItemEntity) {
                     return f_2760d5e3.contains(((ItemEntity)var1x).getStack().getItem());
                  } else {
                     return var1x instanceof LivingEntity && !(var1x instanceof EntityPlayer)
                        ? f_be91f5ff.m_4fb0d5ef(var1x)
                        : var1x instanceof EntityPlayer && this.f_420306a3;
                  }
               }
            )
            .forEach(var2x -> ((LineRenderStack)this.f_cd552d54.glColor(C0114.bootstrap<"call",0,1>(var2x, var2), 190.0F)).lineToEntity(var2x));
         this.f_cd552d54.end();
         C0114.bootstrap<"call",4,1>();
      }
   }

   public static Color m_a2dd5d36(Entity var0, Entity var1) {
      float var2 = C0114.bootstrap<"call",6,1>(1.0F, C0114.bootstrap<"call",5,1>(var0.distanceToEntity(var1) / 48.0F, 0.0F));
      return C0114.bootstrap<"call",7,1>((double)var2, Color.green, Color.red);
   }

   public static C0201 m_b7f209c4() {
      return f_be91f5ff;
   }

   public static C0219<Item> m_ea95d708() {
      return f_2760d5e3;
   }
}
