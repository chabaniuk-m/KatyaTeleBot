package tutorial;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/*
Build systems:
1. Maven:
 */

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        // don't work if run with maven
        // works if code is run manually from the terminal
//        String botToken = System.getenv("KATE_MAX_PLAYGROUND_TELEGRAM_BOT_TOKEN");
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new Bot("6653988497:AAEb8w16YGsY-ePqTFBVZ44d9SZyePcCq_Q"));
    }
}