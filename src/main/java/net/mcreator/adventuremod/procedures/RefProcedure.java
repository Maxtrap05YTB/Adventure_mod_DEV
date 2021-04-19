package net.mcreator.adventuremod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.adventuremod.item.EpeedesgeantcasserItem;
import net.mcreator.adventuremod.item.EpeedesgeantItem;
import net.mcreator.adventuremod.AdventureModModElements;

import java.util.Map;

@AdventureModModElements.ModElement.Tag
public class RefProcedure extends AdventureModModElements.ModElement {
	public RefProcedure(AdventureModModElements instance) {
		super(instance, 27);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Ref!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(EpeedesgeantItem.block, (int) (1));
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
		}
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(EpeedesgeantcasserItem.block, (int) (1));
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
	}
}
