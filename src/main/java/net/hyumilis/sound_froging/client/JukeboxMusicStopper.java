package net.hyumilis.sound_froging.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.block.Blocks;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.MusicTracker;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;

public class JukeboxMusicStopper {

    private static boolean wasPlaying = false;

    public static void init() {
        ClientTickEvents.END_WORLD_TICK.register(JukeboxMusicStopper::tick);
    }

    private static void tick(ClientWorld world) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null || world == null) return;

        boolean isPlaying = false;

        // Scan only the nearby area (jukeboxes must be loaded to be heard anyway)
        BlockPos playerPos = client.player.getBlockPos();
        int radius = 32; // jukebox audible range

        for (BlockPos pos : BlockPos.iterate(
                playerPos.add(-radius, -radius, -radius),
                playerPos.add(radius, radius, radius))) {

            var state = world.getBlockState(pos);

            if (state.isOf(Blocks.JUKEBOX)) {
                boolean hasRecord = state.get(JukeboxBlock.HAS_RECORD);
                if (hasRecord) {
                    isPlaying = true;
                    break;
                }
            }
        }

        // When starting playback: stop background music
        if (isPlaying && !wasPlaying) {
            MusicTracker tracker = client.getMusicTracker();
            tracker.stop();
        }

        wasPlaying = isPlaying;
    }
}
