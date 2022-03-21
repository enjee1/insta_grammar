import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.MessageUpdateEvent;
import net.dv8tion.jda.api.hooks.AnnotatedEventManager;
import net.dv8tion.jda.api.hooks.SubscribeEvent;
import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IGBot {
    public static void main(String[] args) throws LoginException, InterruptedException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("BotToken"));
        String botToken = reader.readLine().trim();
        JDA jda = JDABuilder.createDefault(botToken).setStatus(OnlineStatus.ONLINE).build();
        jda.awaitReady();
//        EnumSet<GatewayIntent> gatewayIntents = jda.getGatewayIntents();
//        IEventManager iEventManager = jda.getEventManager();
//        List<Guild> guildList = jda.getGuilds();
//        SelfUser selfUser = jda.getSelfUser();
        AnnotatedEventManager dedotatedWam = new AnnotatedEventManager();
        jda.setEventManager(dedotatedWam);
        dedotatedWam.register(new EventListener());
        //TODO:Figure out a way to shutdown cleanly without infinite loop.
        while (true) {
            Thread.sleep(10000);
            System.out.println(jda.getGatewayPing());
        }
//        jda.shutdownNow();


    }

    public static class EventListener
    {
        @SubscribeEvent
        public void onMsg(MessageReceivedEvent event)
        {
            System.out.printf("%s: %s\n", event.getAuthor().getName(), event.getMessage().getContentDisplay());
        }

        @SubscribeEvent
        public void onMsgUpdate(MessageUpdateEvent event)
        {
            System.out.printf("%s: %s\n", event.getAuthor().getName(), event.getMessage().getContentDisplay());
        }
    }

}
