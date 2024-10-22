package nl.enjarai.doabarrelroll.mixin.client.roll;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.entity.Entity;
import nl.enjarai.doabarrelroll.api.RollEntity;
import nl.enjarai.doabarrelroll.api.RollRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin {
    @Inject(
            method = "updateRenderState",
            at = @At("TAIL")
    )
    private void updateRollState(Entity entity, EntityRenderState state, float tickDelta, CallbackInfo ci) {
        var rollEntity = (RollEntity) entity;
        var rollState = (RollRenderState) state;

        rollState.doABarrelRoll$setRolling(rollEntity.doABarrelRoll$isRolling());
        rollState.doABarrelRoll$setRoll(rollEntity.doABarrelRoll$getRoll(tickDelta));
    }
}
