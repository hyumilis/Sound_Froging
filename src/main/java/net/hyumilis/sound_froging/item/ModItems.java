package net.hyumilis.sound_froging.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hyumilis.sound_froging.Sound_Froging;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item Mob_Drop = registerItem("mob_drop", new Item(new Item.Settings()));
    //public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Sound_Froging.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Sound_Froging.LOGGER.info("Registering Mod Items for " + Sound_Froging.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(Mob_Drop);
            //entries.add(RAW_PINK_GARNET);
        });
    }
}