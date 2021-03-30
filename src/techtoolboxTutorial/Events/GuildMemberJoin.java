package techtoolboxTutorial.Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import techtoolboxTutorial.Television;

import java.util.Random;

public class GuildMemberJoin extends ListenerAdapter {

    String[] messages = {
            "[member] joined. You must construct additional pylons.",
            "Never gonna give [member] up. Never let [member] down!",
            "Hey! Listen! [member] has joined!",
            "Ha! [member] has joined! You activated my trap card!",
            "We've been expecting you, [member].",
            "It's dangerous to go alone, take [member]!",
            "Swoooosh. [member] just landed.",
            "Brace yourselves. [member] just joined the server.",
            "A wild [member] appeared."
    };

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        System.out.println("Member joined");
        Television.memberCount ++;
        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(0x66d8ff);
        join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention())); //Get as mention, mens ping them

        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();

        //Add role
        //event.getGuild().addRoleToMember(event.getMember(),event.getGuild().getRolesByName("Member", true)).complete();


    }

}
