package techtoolboxTutorial.Events;

import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReactionAdd extends ListenerAdapter {

    @Override
    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
        if (event.getReactionEmote().getName().equals("❌") &&
                !event.getUser().isBot()) {
            if (event.getMember().getUser().equals(event.getChannel().retrieveMessageById(event.getMessageId()).complete().getAuthor())) {
                //If it's the author
                event.getChannel().retrieveMessageById(event.getMessageId()).complete().delete().queue();

            } else {
                //if not the author
                event.getReaction().removeReaction().queue();

            }
        }



    }



}
