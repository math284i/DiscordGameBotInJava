package techtoolboxTutorial;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Television {
    public static JDA jda;
    public static String prefix = "-";


    //Main method, on start
    public static void main(String[] args) throws LoginException, InterruptedException, FileNotFoundException {
        JDABuilder builder = JDABuilder.createDefault(getToken()); //Hahah deffinetly dident reveal token on the first 3 commits, thats for sure!
        jda = builder.build();
        //jda.getPresence().setStatus(OnlineStatus.IDLE);
        jda.getPresence().setActivity(Activity.watching("You all lose!"));
        //Load in other file, thingi commands
        jda.addEventListener(new Commands());
        jda.awaitReady(); // Blocking guarantees that JDA will be completely loaded.
        System.out.println("Bot started!");
    }

    public static String getToken() throws FileNotFoundException {
        File file = new File("src/Information/Token");
        Scanner fin = new Scanner(file);
        return fin.nextLine();
    }

}
