package net.hyumilis.sound_froging.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hyumilis.sound_froging.Sound_Froging;
import net.hyumilis.sound_froging.sound.ModSounds;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item Mob_Drop = registerItem("mob_drop", new Item(new Item.Settings().maxCount(16)));
    public static final Item Frog_Boogie_Music_Disc = registerItem("frog_boogie_music_disc", new Item(new Item.Settings().jukeboxPlayable(ModSounds.FROG_BOOGIE_KEY).maxCount(1)));
    public static final Item Frog_Block = registerItem("frog_block", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Sound_Froging.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Sound_Froging.LOGGER.info("Registering Items for " + Sound_Froging.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(Mob_Drop);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(Frog_Boogie_Music_Disc);
        });
    }
    public static void registerModBlocks(){
        Sound_Froging.LOGGER.info("Registering Blocks for " + Sound_Froging.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(Frog_Block);
        });
    }
}