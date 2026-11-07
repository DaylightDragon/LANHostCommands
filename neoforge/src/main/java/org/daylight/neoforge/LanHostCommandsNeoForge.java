package org.daylight.neoforge;

import net.neoforged.fml.common.Mod;

import org.daylight.LanHostCommands;

@Mod(LanHostCommands.MOD_ID)
public final class LanHostCommandsNeoForge {
    public LanHostCommandsNeoForge() {
        LanHostCommands.init();
    }
}
