package pl.sophietheshork.shorkapi.cloud;

import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.kyori.adventure.text.minimessage.tag.standard.StandardTags;
import org.bukkit.command.CommandSender;
import org.incendo.cloud.minecraft.extras.MinecraftExceptionHandler;
import org.incendo.cloud.minecraft.extras.caption.ComponentCaptionFormatter;
import org.incendo.cloud.paper.LegacyPaperCommandManager;
import org.intellij.lang.annotations.Subst;
import pl.sophietheshork.shorkapi.minecraft.enums.Color;
import pl.sophietheshork.shorkapi.minecraft.utils.ComponentUtils;


public class CaptionFormatters {
    public static void registerFormatter(LegacyPaperCommandManager<CommandSender> manager) {

        TagResolver.Builder tagResolverBuilder = TagResolver.builder();
        tagResolverBuilder.resolvers(
                TagResolver.resolver("error", Tag.inserting(ComponentUtils.newBuilder().errorPrefix().toComponent())),
                TagResolver.resolver("warn", Tag.inserting(ComponentUtils.newBuilder().warnPrefix().toComponent())),
                TagResolver.resolver("info", Tag.inserting(ComponentUtils.newBuilder().infoPrefix().toComponent())),
                TagResolver.resolver("debug", Tag.inserting(ComponentUtils.newBuilder().debugPrefix().toComponent())),
                TagResolver.resolver("prefix", Tag.inserting(ComponentUtils.newBuilder().normalPrefix().toComponent()))
        );
        for (Color c : Color.values()) {
            @Subst("color") String name = c.name().toLowerCase();
            tagResolverBuilder.resolver(TagResolver.resolver(name, Tag.styling(c.asTextColor())));
        }

        MiniMessage miniMessage = MiniMessage.builder()
                .tags(TagResolver.builder()
                        .resolvers(
                                StandardTags.defaults(),
                                tagResolverBuilder.build()
                        )
                        .build())
                .build();

        MinecraftExceptionHandler.<CommandSender>createNative()
                .defaultHandlers()
                .captionFormatter(ComponentCaptionFormatter.miniMessage(miniMessage))
                .registerTo(manager);
    }
}
