package com.red.diddybludcalc.block;

import com.red.diddybludcalc.DiddyBludCalc;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(3f,5f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .pistonBehavior(PistonBehavior.PUSH_ONLY)));


    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(3f)
                    .requiresTool()
                    .pistonBehavior(PistonBehavior.PUSH_ONLY)));

    public static final Block RAW_PINK_GARNET_ORE = registerBlock("raw_pink_garnet_ore",
            new Block(AbstractBlock.Settings.create()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .pistonBehavior(PistonBehavior.PUSH_ONLY)
                    .strength(2f)
                    .requiresTool()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(DiddyBludCalc.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(DiddyBludCalc.MOD_ID, name),
                    new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        DiddyBludCalc.LOGGER.info("Registering Mod Blocks for "+ DiddyBludCalc.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PINK_GARNET_BLOCK);
            entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
            entries.add(ModBlocks.RAW_PINK_GARNET_ORE);
        });
    }
}
