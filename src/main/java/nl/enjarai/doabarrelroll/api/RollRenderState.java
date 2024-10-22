package nl.enjarai.doabarrelroll.api;

public interface RollRenderState {
    boolean doABarrelRoll$isRolling();

    void doABarrelRoll$setRolling(boolean rolling);

    float doABarrelRoll$getRoll();

    void doABarrelRoll$setRoll(float roll);
}
