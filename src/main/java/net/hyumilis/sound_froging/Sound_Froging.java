package net.hyumilis.sound_froging;

import net.fabricmc.api.ModInitializer;

import net.hyumilis.sound_froging.block.custom.ModBlocks;
import net.hyumilis.sound_froging.item.ModItemGroup;
import net.hyumilis.sound_froging.item.ModItems;
import net.hyumilis.sound_froging.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sound_Froging implements ModInitializer {
    public static final String MOD_ID = "sound_froging";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItemGroup.registerItemGroup();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModSounds.registerSound();
    }
}