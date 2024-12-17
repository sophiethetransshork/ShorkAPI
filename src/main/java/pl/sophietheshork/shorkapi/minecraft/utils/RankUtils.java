package pl.sophietheshork.shorkapi.en.minecraft.utils;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import org.bukkit.OfflinePlayer;
import pl.sophietheshork.shorkapi.en.minecraft.enums.Color;

public class RankUtils {
    public static LuckPerms lpApi;

    public static Rank getPlayerRank(OfflinePlayer offlinePlayer) {
        UserManager userManager = lpApi.getUserManager();
        User user = userManager.getUser(offlinePlayer.getUniqueId());

        if (user == null) return Rank.PLAYER;

        String primaryGroup = user.getPrimaryGroup();

        return switch (primaryGroup) {
            case "admin" -> Rank.ADMIN;
            case "helper" -> Rank.HELPER;
            case "vipplus" -> Rank.VIP_PLUS;
            case "vip" -> Rank.VIP;
            default -> Rank.PLAYER;
        };
    }

    public enum Rank {
        ADMIN("Admin", "ADMIN ", Color.TEXT_RED, Color.TEXT_RED_LIGHT),
        HELPER("Helper", "HELPER ", Color.TEXT_BLUE, Color.TEXT_BLUE_LIGHT),
        VIP_PLUS("VIP+", "VIP+ ", Color.TEXT_GOLDEN, Color.TEXT_GOLDEN_LIGHT),
        VIP("VIP", "VIP ", Color.TEXT_YELLOW, Color.TEXT_YELLOW_LIGHT),
        PLAYER("Player", "", Color.TEXT_DARKER, Color.TEXT_DARKER);

        private final String name;
        private final String prefix;
        private final Color color;
        private final Color lightColor;

        Rank(String name, String prefix, Color color, Color lightColor) {
            this.name = name;
            this.prefix = prefix;
            this.color = color;
            this.lightColor = lightColor;
        }

        public String getName() {
            return name;
        }
        public String getPrefix() {
            return prefix;
        }
        public Color getColor(boolean light) {
            return light ? lightColor : color;
        }
    }
}
