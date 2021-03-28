package techtoolboxTutorial;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Television {
    public static JDA jda;


    //Main method, on start
    public static void main(String[] args) throws LoginException {
        jda = new JDABuilder(AccountType.BOT).setToken("Haha no way imma share this").build();


    }


}
