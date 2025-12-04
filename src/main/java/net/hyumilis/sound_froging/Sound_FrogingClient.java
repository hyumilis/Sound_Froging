package net.hyumilis.sound_froging;

import net.fabricmc.api.ClientModInitializer;
import net.hyumilis.sound_froging.client.JukeboxMusicStopper;

public class Sound_FrogingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        JukeboxMusicStopper.init();
    }
}
