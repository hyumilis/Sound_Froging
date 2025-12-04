package net.hyumilis.sound_froging.block.custom;

import net.hyumilis.sound_froging.Sound_Froging;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block FROG_BLOCK = registerBlock("frog_block",
    new Block(AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.SLIME).luminance((state) -> 13).allowsSpawning(Blocks::always).slipperiness(1.02F)));

    private static Block registerBlock(String name, Block block){
        registerModBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Sound_Froging.MOD_ID, name), block);
    };

    private static void registerModBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Sound_Froging.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        Sound_Froging.LOGGER.info("register blocks for "+ Sound_Froging.MOD_ID);
    }
}
