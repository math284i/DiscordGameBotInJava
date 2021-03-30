package techtoolboxTutorial.Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import techtoolboxTutorial.Television;

import javax.annotation.Nonnull;
import java.util.Random;

public class GuildMemberLeave extends ListenerAdapter {

    String[] messages = {
            "[member] left, the party's over.",
    };
    @Override
    public void onGuildMemberRemove(@Nonnull GuildMemberRemoveEvent event) {
        System.out.println("People leaving");
        Television.memberCount --;
        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(0xf48342);
        join.setDescription(messages[number].replace("[member]", event.getUser().getName())); //Get as mention, mens ping them

        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();

    }
}
