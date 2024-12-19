package pl.sophietheshork.shorkapi.minecraft.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import pl.sophietheshork.shorkapi.ShorkAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayerUtils {
    private static final BukkitScheduler scheduler = ShorkAPI.getScheduler();
    private static final ShorkAPI plugin = ShorkAPI.getInstance();


    private static final List<Player> playersClickingOnEntity = new ArrayList<>();
    public static int baseHealth = 100;
    public static int baseMana = 100;
    public static int baseEnergy = 10;


    public static List<Player> helpopCooldown = new ArrayList<>();
    public static void helpopCooldown(Player player) {
        helpopCooldown.add(player);
        scheduler.runTaskLater((Plugin) plugin, () -> {
            helpopCooldown.remove(player);
        }, 60*20);
    }
    public static boolean hasHelpopCooldown(Player player) {
        return helpopCooldown.contains(player);
    }


    public static HashMap<Player, Player> conversations = new HashMap<>();
    public static Player getReplyTarget(Player messager) {
        return conversations.get(messager);
    }
    public static void setReplyTarget(Player messager, Player receiver) {
        conversations.put(messager, receiver);
        conversations.put(receiver, messager);
    }


    public static HashMap<Player, Location> deathLocations = new HashMap<>();
    public static org.bukkit.Location getDeathLocation(Player player) {
        return deathLocations.get(player);
    }
    public static void setDeathLocation(Player player, org.bukkit.Location location) {
        deathLocations.put(player, location);
    }
    public static void removeDeathLocation(Player player) {
        deathLocations.remove(player);
    }

    public static boolean checkPlayerInteraction(Player player) {
        return playersClickingOnEntity.contains(player);
    }
    public static void playerInteracted(Player player, boolean withEntity) {
        if (withEntity) {
            if (!playersClickingOnEntity.contains(player)) {
                playersClickingOnEntity.add(player);
            }
        } else {
            playersClickingOnEntity.remove(player);
        }

    }

    public static HashMap<Player, Location> backLocations = new HashMap<>();
    public static Location getPlayerBackLocation(Player player) {
        return backLocations.get(player);
    }
    public static void setPlayerBackLocation(Player player, Location location) {
        backLocations.put(player, location);
    }
    public static List<Player> usedDisabledCommand = new ArrayList<>();


    private static final List<Player> respawnProtection = new ArrayList<>();

    public static void protectPlayer(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100, 0));
        respawnProtection.add(player);
        Bukkit.getScheduler().runTaskLater((Plugin) plugin, () -> respawnProtection.remove(player), 100L);
    }
    public static boolean isProtected(Player player) {
        return respawnProtection.contains(player);
    }
}
