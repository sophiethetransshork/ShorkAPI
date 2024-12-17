package pl.sophietheshork.shorkapi.en.minecraft.enums;

/**
 * @author xKris
 */
public enum ChatState {
    ON(Color.TEXT_GREEN, "ON"),
    RESTRICTED(Color.TEXT_YELLOW, "RESTRICTED"),
    OFF(Color.TEXT_RED, "OFF")
    ;

    ChatState(Color color, String message) {
        this.color = color;
        this.message = message;
    }


    private final Color color;
    private final String message;



    public Color getColor() { return this.color; }
    public String getMessage() { return this.message; }
}
