package pl.sophietheshork.shorkapi;

import org.bukkit.scheduler.BukkitScheduler;

/**
 * @author SophieTheShork
 */
public class ShorkAPI {
    public static String VERSION = "1.0.0";
    public static String AUTHOR  = "SophieTheShork";


    private static ShorkAPI instance;
    public static ShorkAPI getInstance() {
        return instance;
    }

    private static BukkitScheduler scheduler;
    public static BukkitScheduler getScheduler() {
        return scheduler;
    }
}