package tools;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemTools {

	public static ItemStack createItem(String name,Material material) {
		return createItem(name,material,null);
	}
	public static ItemStack createItem(String name,Material material,List<String> lore) {
		ItemStack item = new ItemStack(material);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(name);
		if(lore != null) {
			itemm.setLore(lore);
		}
		item.setItemMeta(itemm);
		return item;
	}
	
	public static boolean hasItemNotNull(Player player) {
		return (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getType() != Material.AIR);
	}
}
