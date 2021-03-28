package techtoolboxTutorial;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Television {
    public static JDA jda;
    public static String prefix = "-";


    //Main method, on start
    public static void main(String[] args) throws LoginException, InterruptedException {
        JDABuilder builder = JDABuilder.createDefault("Haha no way imma reveal this");
        jda = builder.build();
        //jda.getPresence().setStatus(OnlineStatus.IDLE);
        jda.getPresence().setActivity(Activity.watching("You all lose!"));
        //Load in other file, thingi commands
        jda.addEventListener(new Commands());
        jda.awaitReady(); // Blocking guarantees that JDA will be completely loaded.
        System.out.println("Bot started!");
    }


}
