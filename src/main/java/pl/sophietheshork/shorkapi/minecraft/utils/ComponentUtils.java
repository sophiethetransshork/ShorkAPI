package pl.sophietheshork.shorkapi.minecraft.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentBuilder;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.sophietheshork.shorkapi.minecraft.enums.Color;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xKris
 */
public class ComponentUtils {
    private final ComponentBuilder component;

    private ComponentUtils() {
        this.component = Component.text();
    }

    public static ComponentUtils newBuilder() {
        return new ComponentUtils();
    }

    public void send(Player player) {
        player.sendMessage(component.build());
    }
    public void send(CommandSender sender) {
        sender.sendMessage(component.build());
    }

    public Component toComponent() {
        return component.build();
    }

    public ComponentUtils booleanColored(String trueValue, String falseValue, boolean bool) {
        component.append(Component.text(bool ? trueValue : falseValue, bool ? Color.TEXT_GREEN_LIGHT.asTextColor() : Color.TEXT_RED.asTextColor()));
        return this;
    }

    public ComponentUtils booleanColored(String value, boolean bool) {
        component.append(Component.text(value, bool ? Color.TEXT_GREEN_LIGHT.asTextColor() : Color.TEXT_RED.asTextColor()));
        return this;
    }

    public ComponentUtils newLine() {
        component.append(Component.newline());
        return this;
    }

    public ComponentUtils hashMap(HashMap<?, ?> map, Color keyColor, Color valueColor) {
        for (Object key : map.keySet()) {
            custom(key.toString(), keyColor).darker(" : ").custom(map.get(key).toString(), valueColor);
        }
        return this;
    }

    public ComponentUtils list(List<?> list, String separator, Color elementColor, Color separatorColor) {
        if (list.isEmpty()) {
            darker("Brak");
            return this;
        }

        Iterator<?> iterator = list.iterator();

        while (iterator.hasNext()) {
            Object element = iterator.next();

            if (iterator.hasNext()) {
                custom(element.toString(), elementColor).custom(separator, separatorColor);
            } else {
                custom(element.toString(), elementColor);
            }

        }
        return this;
    }

    public ComponentUtils listWithCommand(List<?> list, String commandWithoutElement, String separator, Color elementColor, Color separatorColor) {
        if (list.isEmpty()) {
            darker("Brak");
            return this;
        }

        Iterator<?> iterator = list.iterator();

        while (iterator.hasNext()) {
            Object element = iterator.next();

            if (iterator.hasNext()) {
                command(element.toString(), commandWithoutElement + " " + element, elementColor).custom(separator, separatorColor);
            } else {
                command(element.toString(), commandWithoutElement + " " + element, elementColor);
            }

        }
        return this;
    }

    public ComponentUtils listWithSuggestion(List<?> list, String commandWithoutElement, String separator, Color elementColor, Color separatorColor) {
        if (list.isEmpty()) {
            darker("Brak");
            return this;
        }

        Iterator<?> iterator = list.iterator();

        while (iterator.hasNext()) {
            Object element = iterator.next();

            if (iterator.hasNext()) {
                suggestCommand(element.toString(), commandWithoutElement + " " + element, elementColor).custom(separator, separatorColor);
            } else {
                suggestCommand(element.toString(), commandWithoutElement + " " + element, elementColor);
            }
        }
        return this;
    }

    public ComponentUtils npc(String name, String desc) {
        component.append(
                Component.text(name, Color.TEXT_ARG.asTextColor())
                        .decorate(TextDecoration.BOLD)
                        .hoverEvent(HoverEvent.showText(Component.text(desc, Color.TEXT_DARKER.asTextColor())))
        );
        return this;
    }
    public ComponentUtils dialog(String text) {
        component.append(
                Component.text(text, Color.TEXT_DARKER.asTextColor())
                        .decorate(TextDecoration.ITALIC)
        );
        return this;
    }

    public ComponentUtils item(ItemStack itemStack) {
        item(itemStack, "[item]");
        return this;
    }
    public ComponentUtils item(ItemStack itemStack, String ifNull) {
        if (itemStack == null) {
            component.append(Component.text(ifNull, Color.TEXT_DARKER.asTextColor()));
            return this;
        }
        if (itemStack.getItemMeta() == null) {
            component.append(itemStack.displayName());
            return this;
        }

        TextComponent.Builder hover = Component.empty().toBuilder();
        hover.append(itemStack.displayName());

        List<Component> lore = itemStack.lore();
        if (lore != null)
            for (Component c : lore)
                hover.append(Component.newline()).append(c);

        component.append(Component.textOfChildren(
                itemStack.displayName(),
                (
                        itemStack.getAmount() > 1 ?
                                Component.text(" x" + itemStack.getAmount(), Color.TEXT_DARKER.asTextColor()) :
                                Component.empty()
                )
        ).hoverEvent(HoverEvent.showText(hover)));
        return this;
    }

    public ComponentUtils parsedMessage(Player player, String message) {

        message = message
                .replace("<3", "❤")
                .replace(":*:", "✯")
                .replace(":>>:", "»")
                .replace(":<<:", "«");

        int lastEnd = 0;

        Matcher matcher = Pattern.compile("\\[item]").matcher(message);
        while (matcher.find()) {
            normal(message.substring(lastEnd, matcher.start()));
            item(ItemUtils.handItem(player), "[item]");
            lastEnd = matcher.end();
        }

        if (!message.substring(lastEnd).isEmpty()) {
            normal(message.substring(lastEnd));
        }

        return this;
    }

    public ComponentUtils location(Location location) {
        arg("X: " + location.getX())
                .normal(", ")
                .arg("Y: " + location.getY())
                .normal(", ")
                .arg("Z: " + location.getZ())
                .normal(" in world ")
                .arg(location.getWorld().getName());
        return this;
    }

    public enum Prefix {
        ERROR(" ERROR » "),
        WARNING(" WARN » "),
        INFO(" INFO » "),
        DEBUG(" DEBUG » "),
        NORMAL(" » "),
        PARTY(" PARTY » ")
        ;
        private final String prefix;

        Prefix(String prefix) {
            this.prefix = prefix;
        }

        public String getPrefix() {
            return prefix;
        }
    }

    public ComponentUtils errorPrefix() {
        component.append(Component.text(Prefix.ERROR.getPrefix(), Color.TEXT_RED.asTextColor()));
        return this;
    }
    public ComponentUtils warnPrefix() {
        component.append(Component.text(Prefix.WARNING.getPrefix(), Color.TEXT_YELLOW.asTextColor()));
        return this;
    }
    public ComponentUtils infoPrefix() {
        component.append(Component.text(Prefix.INFO.getPrefix(), Color.TEXT_GREEN.asTextColor()));
        return this;
    }
    public ComponentUtils partyPrefix() {
        component.append(Component.text(Prefix.PARTY.getPrefix(), Color.TEXT_GREEN_LIGHT.asTextColor()));
        return this;
    }
    public ComponentUtils debugPrefix() {
        component.append(Component.text(Prefix.DEBUG.getPrefix(), Color.TEXT_BLUE.asTextColor()));
        return this;
    }
    public ComponentUtils normalPrefix() {
        component.append(Component.text(Prefix.NORMAL.getPrefix(), Color.TEXT_DARKER.asTextColor()));
        return this;
    }

    public ComponentUtils custom(String text, Color color) {
        component.append(Component.text(text, TextColor.color(color.asTextColor())));
        return this;
    }

    public ComponentUtils otherComponent(Component component) {
        this.component.append(component);
        return this;
    }

    public ComponentUtils common(String text) {
        component.append(Component.text(text, Color.RARITY_COMMON.asTextColor()));
        return this;
    }
    public ComponentUtils uncommon(String text) {
        component.append(Component.text(text, Color.RARITY_UNCOMMON.asTextColor()));
        return this;
    }
    public ComponentUtils rare(String text) {
        component.append(Component.text(text, Color.RARITY_RARE.asTextColor()));
        return this;
    }
    public ComponentUtils epic(String text) {
        component.append(Component.text(text, Color.RARITY_EPIC.asTextColor()));
        return this;
    }
    public ComponentUtils legendary(String text) {
        component.append(Component.text(text, Color.RARITY_LEGENDARY.asTextColor()));
        return this;
    }
    public ComponentUtils mythic(String text) {
        component.append(Component.text(text, Color.RARITY_MYTHICAL.asTextColor()));
        return this;
    }
    public ComponentUtils special(String text) {
        component.append(Component.text(text, Color.RARITY_SPECIAL.asTextColor()));
        return this;
    }
    public ComponentUtils admin(String text) {
        component.append(Component.text(text, Color.RARITY_ADMIN.asTextColor()));
        return this;
    }

    public ComponentUtils normalMob(String text) {
        component.append(Component.text(text, Color.MOB_NORMAL.asTextColor()));
        return this;
    }
    public ComponentUtils boss(String text) {
        component.append(Component.text(text, Color.MOB_BOSS.asTextColor()));
        return this;
    }
    public ComponentUtils god(String text) {
        component.append(Component.text(text, Color.MOB_GOD.asTextColor()));
        return this;
    }

    public ComponentUtils arg(String text) {
        component.append(Component.text(text, Color.TEXT_ARG.asTextColor()));
        return this;
    }
    public ComponentUtils normal(String text) {
        component.append(Component.text(text, Color.TEXT_NORMAL.asTextColor()));
        return this;
    }
    public ComponentUtils darker(String text) {
        component.append(Component.text(text, Color.TEXT_DARKER.asTextColor()));
        return this;
    }
    public ComponentUtils darker2(String text) {
        component.append(Component.text(text, Color.TEXT_DARKER2.asTextColor()));
        return this;
    }

    public ComponentUtils green(String text) {
        component.append(Component.text(text, Color.TEXT_GREEN.asTextColor()));
        return this;
    }
    public ComponentUtils greenLight(String text) {
        component.append(Component.text(text, Color.TEXT_GREEN_LIGHT.asTextColor()));
        return this;
    }

    public ComponentUtils blue(String text) {
        component.append(Component.text(text, Color.TEXT_BLUE.asTextColor()));
        return this;
    }
    public ComponentUtils blueLight(String text) {
        component.append(Component.text(text, Color.TEXT_BLUE_LIGHT.asTextColor()));
        return this;
    }

    public ComponentUtils yellow(String text) {
        component.append(Component.text(text, Color.TEXT_YELLOW.asTextColor()));
        return this;
    }
    public ComponentUtils yellowLight(String text) {
        component.append(Component.text(text, Color.TEXT_YELLOW_LIGHT.asTextColor()));
        return this;
    }

    public ComponentUtils golden(String text) {
        component.append(Component.text(text, Color.TEXT_GOLDEN.asTextColor()));
        return this;
    }
    public ComponentUtils goldenLight(String text) {
        component.append(Component.text(text, Color.TEXT_GOLDEN_LIGHT.asTextColor()));
        return this;
    }

    public ComponentUtils red(String text) {
        component.append(Component.text(text, Color.TEXT_RED.asTextColor()));
        return this;
    }
    public ComponentUtils redLight(String text) {
        component.append(Component.text(text, Color.TEXT_RED_LIGHT.asTextColor()));
        return this;
    }

    public ComponentUtils purple(String text) {
        component.append(Component.text(text, Color.TEXT_PURPLE.asTextColor()));
        return this;
    }
    public ComponentUtils purpleLight(String text) {
        component.append(Component.text(text, Color.TEXT_PURPLE_LIGHT.asTextColor()));
        return this;
    }

    public ComponentUtils discord(String text) {
        component.append(Component.text(text, Color.DISCORD.asTextColor()));
        return this;
    }
    public ComponentUtils discordText(String text) {
        component.append(Component.text(text, Color.DISCORD_TEXT.asTextColor()));
        return this;
    }

    public ComponentUtils link(String text, String url, Color color) {
        component.append(Component.text(text, color.asTextColor())).clickEvent(ClickEvent.openUrl(url));
        return this;
    }

    public ComponentUtils italic(String text, Color color) {
        component.append(Component.text(text, color.asTextColor()).decorate(TextDecoration.ITALIC));
        return this;
    }

    public ComponentUtils bold(String text, Color color) {
        component.append(Component.text(text, color.asTextColor()).decorate(TextDecoration.BOLD));
        return this;
    }

    public ComponentUtils command(String text, String command, Color color) {
        component.append(
                Component.text(text, color.asTextColor())
                        .hoverEvent(HoverEvent.showText(
                                Component.textOfChildren(
                                        Component.text("Click, to execute command ", Color.TEXT_NORMAL.asTextColor()),
                                        Component.text(command, color.asTextColor())
                                )
                        ))
                        .clickEvent(ClickEvent.runCommand(command))
        );
        return this;
    }

    public ComponentUtils suggestCommand(String text, String command, Color color) {
        component.append(
                Component.text(text, color.asTextColor())
                        .hoverEvent(HoverEvent.showText(
                                Component.textOfChildren(
                                        Component.text("Click, to write command ", Color.TEXT_NORMAL.asTextColor()),
                                        Component.text(command, color.asTextColor())
                                )
                        ))
                        .clickEvent(ClickEvent.suggestCommand(command))
        );
        return this;
    }
}
