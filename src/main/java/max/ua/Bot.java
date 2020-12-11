package max.ua;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.telegram.telegrambots.api.methods.send.SendMessage;
//import org.telegram.telegrambots.api.objects.Document;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

import static max.ua.Parser.getPage;

public class Bot extends TelegramLongPollingBot {
    private  static  final String  TOKEN = "1465496493:AAEYLRNLiNicbyy_QL9TOxe6aACO8xhMkPw";
    private  static  final String USERNAME = "LabaLP_bot";

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
                inputText= "Привіт, мене звати бот LabaLPNU_Bot,\n" +
                           "до ваших послуг.Якщо потрібна допомга введіть команду \"/help\"";
                try {
                    execute(new SendMessage(char_id,inputText));
                }catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (inputText.equals("/help")) {
                inputText= "/cript - вивід криптовалютуи \n ";
                try {
                    execute(new SendMessage(char_id,inputText));
                }catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            if(inputText.equals("/cript")){
            try {

                execute(new SendMessage(char_id,"https://coinmarketcap.com/" ));
                execute(new SendMessage(char_id,"https://goverla.ua/" ));
            }catch (TelegramApiException e) {
                e.printStackTrace();
            }
            }
            if(inputText.equals("/c")){
                try {
                    Element page = getPage();
                    execute(new SendMessage(char_id, String.valueOf(page)));

                }catch (TelegramApiException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
