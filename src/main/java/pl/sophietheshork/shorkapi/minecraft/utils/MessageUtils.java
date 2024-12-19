package pl.sophietheshork.shorkapi.minecraft.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.sophietheshork.shorkapi.minecraft.enums.Color;

import java.time.Duration;

/**
 * @author xKris
 */
public class MessageUtils {
    public static final String NO_ITEM_IN_HAND  = "You need to hold an item in hand";
    public static final String CONSOLE_ERROR    = "Only players can execute this command";
    public static final String CONSOLE_ONLY     = "Only console can execute this command";
    public static final String USER_IS_OFFLINE  = "This user is offline";
    public static final String CORRECT_USAGE    = "Usage: \n" + Color.TEXT_RED_LIGHT.asChatColor() + "%usage%";
    public static final String NOT_ENOUGH_MONEY = "You cannot afford it";
    public static final String MUST_BE_A_NUMBER = "Number is required to be more than 0";


    public static final TextComponent NO_PERMISSION
            = Component.text("No permission", Color.TEXT_RED.asTextColor());
    public static String coinCharacter = "$";


    public static void sendEmptyMessage(CommandSender sender) {
        sender.sendMessage("");
    }
    public static void sendMessage(CommandSender sender, String message) {
        ComponentUtils.newBuilder().normalPrefix().normal(message).send(sender);
    }
    public static void sendMessage(CommandSender sender, String prefix, String message) {
        ComponentUtils.newBuilder().darker(prefix + " ").normal(message).send(sender);
    }
    public static void sendErrorMessage(CommandSender sender, String message) {
        ComponentUtils.newBuilder().errorPrefix().redLight(message).send(sender);
    }

    public static void sendActionBar(Player player, String message) {
        player.sendActionBar(ComponentUtils.newBuilder().darker("• ").normal(message).darker(" •").toComponent());
    }

    public static void sendTitle(Player player, String title, String subtitle) {
        player.showTitle(Title.title(
                ComponentUtils.newBuilder().normal(title).toComponent(),
                ComponentUtils.newBuilder().darker(subtitle).toComponent(),
                Title.Times.times(
                        Duration.ofMillis(15 * 50),
                        Duration.ofMillis(50 * 50),
                        Duration.ofMillis(15 * 50)
                )
        ));
    }

    public static void broadcastEmptyMessage() {
        Bukkit.broadcast(Component.empty());
    }
    public static void broadcast(String message) {
        Bukkit.broadcast(ComponentUtils.newBuilder().normalPrefix().normal(message).toComponent());
    }
    public static void broadcast(String prefix, String message) {
        Bukkit.broadcast(ComponentUtils.newBuilder().darker(prefix + " ").normal(message).toComponent());
    }
    public static void broadcast(Component message) {
        Bukkit.broadcast(message);
    }
}
