package org.daylight.mixin;

import org.daylight.formixins.ICommandStateHolder;
import net.minecraft.world.level.storage.PrimaryLevelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PrimaryLevelData.class)
public class PrimaryLevelDataMixin implements ICommandStateHolder {
    @Unique
    private boolean lanCommandsReturned$openedToLanWithCommandsForOtherPlayers = false;

    @Override
    public boolean isLanCommandsReturned$isOpenedToLanWithCommandsForOtherPlayers() {
        return lanCommandsReturned$openedToLanWithCommandsForOtherPlayers;
    }

    @Override
    public void setLanCommandsReturned$isOpenedToLanWithCommandsForOtherPlayers(boolean value) {
        this.lanCommandsReturned$openedToLanWithCommandsForOtherPlayers = value;
    }

    @Inject(
            method = "isAllowCommands",
            at = @At("HEAD"),
            cancellable = true
    )
    public void lanCommandsReturned$checkAllowCommands(CallbackInfoReturnable<Boolean> cir) {
        if(isLanCommandsReturned$isOpenedToLanWithCommandsForOtherPlayers()) { // TODO
            cir.setReturnValue(true);
        }
    }
}
