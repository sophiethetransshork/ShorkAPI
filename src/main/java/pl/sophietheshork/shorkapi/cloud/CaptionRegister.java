package pl.sophietheshork.shorkapi.cloud;

import org.bukkit.command.CommandSender;
import org.incendo.cloud.bukkit.BukkitCaptionKeys;
import org.incendo.cloud.caption.CaptionProvider;
import org.incendo.cloud.caption.StandardCaptionKeys;
import org.incendo.cloud.paper.LegacyPaperCommandManager;

public class CaptionRegister {
    public static void registerStandard(LegacyPaperCommandManager<CommandSender> manager) {
        manager.captionRegistry()
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_BOOLEAN,
                        "<error><text_red>\"<input>\" <text_red_light>is not a valid boolean value"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_NUMBER,
                        "<error><text_red>\"<input>\" <text_red_light>is out of range from <text_red><min> <text_red_light>to <text_red><max>"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_CHAR,
                        "<error><text_red>\"<input>\" <text_red_light>is not a valid character"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_ENUM,
                        "<error><text_red>\"<input>\" <text_red_light>is not in the list of acceptable arguments: <text_red><acceptableValues>"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_STRING,
                        "<error><text_red>\"<input>\" <text_red_light>is not a valid string of type <text_red><stringMode>"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_UUID,
                        "<error><text_red>\"<input>\" <text_red_light>is not a valid UUID"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_REGEX,
                        "<error><text_red>\"<input>\" <text_red_light>does not match the pattern <text_red>\"<pattern>\""
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_FLAG_UNKNOWN_FLAG,
                        "<error><text_red_light>Unknown flag <text_red>\"<flag>\""
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_FLAG_DUPLICATE_FLAG,
                        "<error><text_red>Duplicate flag \"<flag>\""
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_FLAG_NO_FLAG_STARTED,
                        "<error><text_red>No flag started. <text_red_light>Don't know what to do with \"<input>\""
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_FLAG_MISSING_ARGUMENT,
                        "<error><text_red_light>Missing argument for <text_red>\"<flag>\""
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_FLAG_NO_PERMISSION,
                        "<error><text_red>No permission"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_COLOR,
                        "<error><text_red>\"<input>\" <text_red_light>is not a valid color"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_DURATION,
                        "<error><text_red>\"<input>\" <text_red_light>is not a valid duration format"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_AGGREGATE_MISSING_INPUT,
                        "<error><text_red>Missing component \"<component>\""
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_AGGREGATE_COMPONENT_FAILURE,
                        "<error><text_red>Invalid component \"<component>\": <failure>"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.ARGUMENT_PARSE_FAILURE_EITHER,
                        "<error><text_red>Cannot recognize <primary> or <fallback> from \"<input>\""
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.EXCEPTION_UNEXPECTED,
                        "<error><text_red>An internal error occurred while attempting to execute this command"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.EXCEPTION_INVALID_ARGUMENT,
                        "<error><text_red>Invalid command usage<newline><error><text_red_light>Correct syntax: <syntax>."
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.EXCEPTION_NO_SUCH_COMMAND,
                        "<error><text_red>Unknown command"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.EXCEPTION_NO_PERMISSION,
                        "<error><text_red>No permission"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.EXCEPTION_INVALID_SENDER,
                        "<error><text_red>No permission"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.EXCEPTION_INVALID_SENDER_LIST,
                        "<error><text_red>No permission"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        StandardCaptionKeys.EXCEPTION_INVALID_SYNTAX,
                        "<error><text_red>Invalid command usage<newline><error><text_red_light>Correct syntax: <syntax>."
                ))
        ;
    }

    public static void registerBukkit(LegacyPaperCommandManager<CommandSender> manager) {
        manager.captionRegistry()
                .registerProvider(CaptionProvider.constantProvider(
                        BukkitCaptionKeys.ARGUMENT_PARSE_FAILURE_ENCHANTMENT,
                        "<error><text_red_light>Enchantment <text_red>\"<input>\" <text_red_light>does not exist"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        BukkitCaptionKeys.ARGUMENT_PARSE_FAILURE_MATERIAL,
                        "<error><text_red_light>Material <text_red>\"<input>\" <text_red_light>does not exist"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        BukkitCaptionKeys.ARGUMENT_PARSE_FAILURE_OFFLINEPLAYER,
                        "<error><text_red_light>Player <text_red>\"<input>\" not found"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        BukkitCaptionKeys.ARGUMENT_PARSE_FAILURE_PLAYER,
                        "<error><text_red_light>Player <text_red>\"<input>\" not found"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        BukkitCaptionKeys.ARGUMENT_PARSE_FAILURE_WORLD,
                        "<error><text_red_light>World <text_red>\"<input>\" not found"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        BukkitCaptionKeys.ARGUMENT_PARSE_FAILURE_LOCATION_INVALID_FORMAT,
                        "<error><text_red>\"<input>\" <text_red_light>is not a valid location.<newline><error><text_red_light>Required format is: <text_red>\"<x> <y> <z>\""
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        BukkitCaptionKeys.ARGUMENT_PARSE_FAILURE_LOCATION_MIXED_LOCAL_ABSOLUTE,
                        "<error><text_red>Cannot mix relative and absolute coordinates.<newline><error><text_red_light>(all coordinates must use <text_red>\"^\" <text_red_light>or none)"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        BukkitCaptionKeys.ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_NAMESPACE,
                        "<error><text_red>Invalid namespace \"<input>\".<newline><error><text_red_light>Must be [a-z0-9._-]"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        BukkitCaptionKeys.ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_KEY,
                        "<error><text_red>Invalid key \"<input>\".<newline><error><text_red_light>Must be [a-z0-9/._-]"
                ))
                .registerProvider(CaptionProvider.constantProvider(
                        BukkitCaptionKeys.ARGUMENT_PARSE_FAILURE_NAMESPACED_KEY_NEED_NAMESPACE,
                        "<error><text_red>Invalid input \"<input>\".<newline><error><text_red_light>Requires a fully qualified namespace."
                ))
        ;
    }
}
