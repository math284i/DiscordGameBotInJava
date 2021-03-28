package techtoolboxTutorial;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Television.prefix + "info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("🎮🕹 MiniGame Information");
            info.setDescription("This bot is made using java!, u just got informed!");

            //info.addField("Creator", "math284i", false); //last one, is inline or not

            info.setColor(0x00eaff); //Color found using html color picker
            info.setFooter("Created by: math284i", event.getMember().getUser().getAvatarUrl());

            //sendTyping is to make the little animation, like someone is typing
            event.getChannel().sendTyping().queue();
            //event.getChannel().sendMessage("This bot is made using java!, u just got informed!").queue();
            event.getChannel().sendMessage(info.build()).queue();

            //garbage helper
            info.clear();

        }

        if (args[0].equalsIgnoreCase(Television.prefix + "ping")) {
            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage("Pong!") /* => RestAction<Message> */
                    .queue(response /* => Message */ -> {
                        response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue();
                    });

        }


    }

    /*
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        System.out.println("Somewhere");

        if (args[0].equalsIgnoreCase(Television.prefix + "info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("🎮🕹 MiniGame Information");
            info.setDescription("Put some infomation description here!");

            //info.addField("Creator", "math284i", false); //last one, is inline or not

            info.setColor(0x00eaff); //Color found using html color picker
            info.setFooter("Created by: math284i", event.getMember().getUser().getAvatarUrl());

            System.out.println("We got info");
            //sendTyping is to make the little animation, like someone is typing
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("This bot is made using java!, u just got informed!").queue();
            event.getChannel().sendMessage(info.build()).queue();

            //garbage helper
            info.clear();

        }


    }

     */

}
