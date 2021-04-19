
package net.mcreator.adventuremod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.adventuremod.AdventureModModElements;

import java.util.List;
import java.util.Collections;

@AdventureModModElements.ModElement.Tag
public class Soldonjon1Block extends AdventureModModElements.ModElement {
	@ObjectHolder("adventure_mod_:soldonjon_1")
	public static final Block block = null;
	public Soldonjon1Block(AdventureModModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.3f, 0f).lightValue(0).harvestLevel(4)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("soldonjon_1");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Soldonjon1Block.block, (int) (1)));
		}
	}
}