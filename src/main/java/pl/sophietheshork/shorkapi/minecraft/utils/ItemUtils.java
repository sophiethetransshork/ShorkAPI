package pl.sophietheshork.shorkapi.en.minecraft.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xKris
 */
public class ItemUtils {
    public static ItemStack air = new ItemStack(Material.AIR, 1);

    public static ItemStack handItem(Player player) {
        return player.getInventory().getItemInMainHand().isEmpty() ? null : player.getInventory().getItemInMainHand();
    }

    public static void giveItems(Player player, ItemStack...itemStacks) {
        dropExcessItems(player.getInventory().addItem(itemStacks), player);
    }

    public static void dropExcessItems(HashMap<Integer, ItemStack> items, Player player) {
        if (!items.isEmpty()) {
            for(Map.Entry<Integer, ItemStack> entry : items.entrySet()) {
                player.getWorld().dropItemNaturally(player.getLocation(), entry.getValue());
            }
        }
    }
}
