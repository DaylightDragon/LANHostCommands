package org.daylight.fabric;

import net.fabricmc.api.ModInitializer;

import org.daylight.LanHostCommands;

public final class LanHostCommandsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        LanHostCommands.init();
    }
}
