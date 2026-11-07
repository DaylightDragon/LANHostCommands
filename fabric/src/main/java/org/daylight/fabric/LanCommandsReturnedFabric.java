package org.daylight.fabric;

import net.fabricmc.api.ModInitializer;

import org.daylight.LanCommandsReturned;

public final class LanCommandsReturnedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        LanCommandsReturned.init();
    }
}
