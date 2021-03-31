package max.ua;

import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.bots.DefaultBotOptions;

public class Main {
    public  static  void main (String[] args) {

        ApiContextInitializer.init();
        DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
        Bot botLab = new Bot(botOptions);

        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(botLab);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
