package com.example.mixin;

import com.example.formixins.ICommandStateHolder;
import net.minecraft.client.server.IntegratedServer;
import net.minecraft.world.level.storage.WorldData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(IntegratedServer.class)
public class IntegratedServerMixin {
    @Inject(
            method = "setCommandsAllowedForOtherPlayers",
            at = @At("HEAD")
    )
    public void lanCommandsReturned$onSetOtherPlayers(boolean allowCommands, CallbackInfo ci) {
        WorldData worldData = ((IntegratedServer) (Object) this).getWorldData();
        if(worldData instanceof ICommandStateHolder commandStateHolder) {
            commandStateHolder.setLanCommandsReturned$isOpenedToLanWithCommandsForOtherPlayers(allowCommands);
        }
    }
}
