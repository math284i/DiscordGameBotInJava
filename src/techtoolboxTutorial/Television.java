package techtoolboxTutorial;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import techtoolboxTutorial.Commands.Clear;
import techtoolboxTutorial.Commands.Temp;
import techtoolboxTutorial.Events.GuildMemberJoin;
import techtoolboxTutorial.Events.GuildMemberLeave;
import techtoolboxTutorial.Events.GuildMessageReactionAdd;
import techtoolboxTutorial.Events.GuildMessageReceived;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Television {
    public static JDA jda;
    public static String prefix = "-";
    public static int memberCount = 2;


    //Main method, on start
    public static void main(String[] args) throws LoginException, InterruptedException, FileNotFoundException {
        JDABuilder builder = JDABuilder.createDefault(getToken()); //Hahah deffinetly dident reveal token on the first 3 commits, thats for sure!
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        jda = builder.build();
        //jda.getPresence().setStatus(OnlineStatus.IDLE);
        jda.getPresence().setActivity(Activity.watching("You all lose!"));
        //Load in other file, thingi commands
        jda.addEventListener(new Temp());
        jda.addEventListener(new Clear());
        jda.addEventListener(new GuildMemberJoin());
        jda.addEventListener(new GuildMemberLeave());
        jda.addEventListener(new GuildMessageReceived());
        jda.addEventListener(new GuildMessageReactionAdd());
        jda.awaitReady(); // Blocking guarantees that JDA will be completely loaded.
        System.out.println("Bot started!");
    }

    public static String getToken() throws FileNotFoundException {
        File file = new File("src/Information/Token");
        Scanner fin = new Scanner(file);
        return fin.nextLine();
    }

}
