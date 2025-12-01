package net.hyumilis.sound_froging.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hyumilis.sound_froging.Sound_Froging;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup SOUND_FROGING_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(Sound_Froging.MOD_ID,
            "sound_froging_items"), FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.Mob_Drop))
            .displayName(Text.translatable("itemgroup.sound_froging.mob_drop_items"))
            .entries((displayContext, entries) -> {
                entries.add(ModItems.Mob_Drop);
                entries.add(ModItems.Frog_Block);
                entries.add(ModItems.Frog_Boogie_Music_Disc);
            })
            .build());

    public static void registerItemGroup(){
        Sound_Froging.LOGGER.info("registered item group for" + Sound_Froging.MOD_ID);
    }
}
