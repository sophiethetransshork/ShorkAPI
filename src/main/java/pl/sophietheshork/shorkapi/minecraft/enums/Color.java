package pl.sophietheshork.shorkapi.en.minecraft.enums;

import net.kyori.adventure.text.format.TextColor;
import net.md_5.bungee.api.ChatColor;

/**
 * Colors for many features
 * Thx Kris for 'inspiration'
 * @author SophieTheShork, xKris
 */
@SuppressWarnings("deprecation")
public enum Color {
    TEXT_NORMAL(new java.awt.Color(255, 255, 255)),
    TEXT_DARKER(new java.awt.Color(142, 142, 142)),
    TEXT_DARKER2(new java.awt.Color(86, 86, 86)),

    TEXT_GREEN(new java.awt.Color(21, 197, 21)),
    TEXT_GREEN_LIGHT(new java.awt.Color(116, 227, 116)),

    TEXT_BLUE(new java.awt.Color(21, 103, 211)),
    TEXT_BLUE_LIGHT(new java.awt.Color(75, 153, 216)),

    TEXT_YELLOW(new java.awt.Color(209, 199, 19)),
    TEXT_YELLOW_LIGHT(new java.awt.Color(223, 223, 90)),

    TEXT_GOLDEN(new java.awt.Color(248, 163, 4)),
    TEXT_GOLDEN_LIGHT(new java.awt.Color(244, 194, 76)),

    TEXT_RED(new java.awt.Color(195, 23, 23)),
    TEXT_RED_LIGHT(new java.awt.Color(220, 71, 71)),

    TEXT_PURPLE(new java.awt.Color(116, 20, 206)),
    TEXT_PURPLE_LIGHT(new java.awt.Color(151, 80, 222)),

    DISCORD(new java.awt.Color(94, 126, 239)),
    DISCORD_TEXT(new java.awt.Color(163, 181, 241)),

    TEXT_ARG(new java.awt.Color(187, 51, 51)),


    RARITY_COMMON(new java.awt.Color(248, 248, 248)),
    RARITY_UNCOMMON(new java.awt.Color(1, 210, 1)),
    RARITY_RARE(new java.awt.Color(1, 103, 185)),
    RARITY_EPIC(new java.awt.Color(110, 0, 199)),
    RARITY_LEGENDARY(new java.awt.Color(241, 186, 0)),
    RARITY_MYTHICAL(new java.awt.Color(241, 0, 229)),
    RARITY_SPECIAL(new java.awt.Color(255, 0, 89)),
    RARITY_ADMIN(new java.awt.Color(255, 0, 0)),

    STAR_REGULAR(new java.awt.Color(255, 196, 0)),
    STAR_UPGRADED(new java.awt.Color(241, 0, 0)),
    STAR_MASTER(new java.awt.Color(129, 0, 0)),

    LEVEL_1(new java.awt.Color(169, 169, 169)),     // 0-25
    LEVEL_2(new java.awt.Color(255, 255, 255)),     // 25-75
    LEVEL_3(new java.awt.Color(4, 229, 4)),         // 75-125
    LEVEL_4(new java.awt.Color(255, 213, 0)),       // 125-200
    LEVEL_5(new java.awt.Color(229, 0, 0)),         // 200-300
    LEVEL_6(new java.awt.Color(100, 0, 222)),       // 300+

    RANK_PLAYER(new java.awt.Color(169, 169, 169)),
    RANK_VIP(new java.awt.Color(255, 233, 2)),
    RANK_VIP_PLUS(new java.awt.Color(48, 255, 2)),
    RANK_HELPER(new java.awt.Color(2, 82, 255)),
    RANK_ADMIN(new java.awt.Color(255, 0, 0)),

    MOB_NORMAL(new java.awt.Color(169, 169, 169)),
    MOB_BOSS(new java.awt.Color(253, 2, 2)),
    MOB_GOD(new java.awt.Color(110, 0, 199));


    private final java.awt.Color color;

    Color(java.awt.Color color) {
        this.color = color;
    }

    public java.awt.Color getColor() {
        return color;
    }

    public ChatColor asChatColor() {
        return ChatColor.of(color);
    }

    public TextColor asTextColor() {
        return TextColor.color(color.getRGB());
    }

    public ChatColor asChatColor(java.awt.Color color) {
        return ChatColor.of(color);
    }

    public TextColor asTextColor(java.awt.Color color) {
        return TextColor.color(color.getRGB());
    }

    public static String translateColor(String string) {return ChatColor.translateAlternateColorCodes('&', string);}


    /**
     * Website: <a href="https://codepen.io/HunorMarton/details/eWvewo">HSB Color Picker</a>
     */
    public static String gradient(Float length, Float add, Float saturation, Float brightness, String string, boolean bold) {
        StringBuilder sb = new StringBuilder();
        int l = string.length();
        for (int i = 0; i < l; i++) {
            sb.append(ChatColor.of(java.awt.Color.getHSBColor((((float) i / l) * length + add) % 1.0f, saturation, brightness)));
            if (bold) sb.append("&l");
            sb.append(string.charAt(i));
        }
        return translateColor(sb.toString());
    }
}
