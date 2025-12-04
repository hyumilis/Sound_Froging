package net.hyumilis.sound_froging.sound;

import net.hyumilis.sound_froging.Sound_Froging;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent EVENT_ONE = registerSoundEvent("event_one");

    public static final SoundEvent FROG_BLOCK_BREAK = registerSoundEvent("frog_block_break");
    public static final SoundEvent FROG_BLOCK_STEP = registerSoundEvent("frog_block_step");
    public static final SoundEvent FROG_BLOCK_PLACE = registerSoundEvent("frog_block_place");
    public static final SoundEvent FROG_BLOCK_HIT = registerSoundEvent("frog_block_hit");
    public static final SoundEvent FROG_BLOCK_FALL = registerSoundEvent("frog_block_fall");

    public static final BlockSoundGroup SOUND_FROGING_SOUNDS = new BlockSoundGroup(1f, 1f,
            FROG_BLOCK_BREAK, FROG_BLOCK_STEP, FROG_BLOCK_PLACE, FROG_BLOCK_HIT, FROG_BLOCK_FALL);

    public static final SoundEvent FROG_BOOGIE = registerSoundEvent("frog_boogie");
    public static final RegistryKey<JukeboxSong> FROG_BOOGIE_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Sound_Froging.MOD_ID, "frog_boogie"));

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Sound_Froging.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    };

    public static void registerSound() {
        Sound_Froging.LOGGER.info("register sound for" + Sound_Froging.MOD_ID);
    };
}