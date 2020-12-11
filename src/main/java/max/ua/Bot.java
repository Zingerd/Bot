package max.ua;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import java.io.IOException;


import static max.ua.Parser.getPage;


public class Bot extends TelegramLongPollingBot {
    private  static  final String  TOKEN = "1479650541:AAFYyQKWCq8mm0-epUpvU4UkfifFEw4YeiY";
    private  static  final String USERNAME = "CryptoCurrency_Bot";
    public  Bot(DefaultBotOptions options) {
        super(options);
    }
    public  String getBotToken() {
        return  TOKEN;
    }
    public String getBotUsername() {
        return USERNAME;
    }
    public  void onUpdateReceived(Update update) {
        if(update.getMessage()!= null && update.getMessage().hasText()) {
            long char_id = update.getMessage().getChatId();
            String inputText = update.getMessage().getText();

            if (inputText.equals("/start")) {
                inputText= "Привіт, мене звати бот @Rate_CryptoCurrency_bot,\n" +
                           "до ваших послуг.Якщо потрібна допомога введіть команду \"/help\"";
                try {
                    execute(new SendMessage(char_id,inputText));
                }catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (inputText.equals("/help")) {
                inputText= "/crypto - курс криптовалют \n ";
                try {
                    execute(new SendMessage(char_id,inputText));
                }catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

            if(inputText.equals("/crypto")){
//
                try {
                    String page = getPage();
                    execute(new SendMessage(char_id, String.valueOf(page)));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
