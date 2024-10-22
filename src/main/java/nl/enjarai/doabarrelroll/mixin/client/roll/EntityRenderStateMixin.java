package nl.enjarai.doabarrelroll.mixin.client.roll;

import net.minecraft.client.render.entity.state.EntityRenderState;
import nl.enjarai.doabarrelroll.api.RollRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(EntityRenderState.class)
public class EntityRenderStateMixin implements RollRenderState {
    @Unique
    protected boolean rolling;
    @Unique
    protected float roll;

    @Override
    public boolean doABarrelRoll$isRolling() {
        return rolling;
    }

    @Override
    public void doABarrelRoll$setRolling(boolean rolling) {
        this.rolling = rolling;
    }

    @Override
    public float doABarrelRoll$getRoll() {
        return roll;
    }

    @Override
    public void doABarrelRoll$setRoll(float roll) {
        this.roll = roll;
    }
}
