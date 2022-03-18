import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

import javax.security.auth.login.LoginException;


public class IGBot {
    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA jda = JDABuilder.createDefault("***INSERT TOKEN***").setStatus(OnlineStatus.ONLINE).build();
        jda.addEventListener();
        Thread.sleep(10000);
        jda.shutdownNow();


    }
}
