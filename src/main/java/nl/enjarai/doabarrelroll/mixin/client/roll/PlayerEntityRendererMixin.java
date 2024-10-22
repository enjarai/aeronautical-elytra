package nl.enjarai.doabarrelroll.mixin.client.roll;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.util.math.RotationAxis;
import nl.enjarai.doabarrelroll.api.RollEntity;
import nl.enjarai.doabarrelroll.api.RollRenderState;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin {
    @ModifyArg(
            method = "setupTransforms(Lnet/minecraft/client/render/entity/state/PlayerEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;FF)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;multiply(Lorg/joml/Quaternionf;)V",
                    ordinal = 1
            ),
            index = 0
    )
    private Quaternionf doABarrelRoll$modifyRoll(Quaternionf original,
                                                 @Local(argsOnly = true) PlayerEntityRenderState state) {
        var rollState = (RollRenderState) state;

        if (rollState.doABarrelRoll$isRolling()) {
            var roll = rollState.doABarrelRoll$getRoll();
            return RotationAxis.POSITIVE_Y.rotationDegrees(roll);
        }

        return original;
    }
}
