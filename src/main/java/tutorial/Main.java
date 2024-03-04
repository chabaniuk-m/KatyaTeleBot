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
        String botToken = System.getenv("KATE_MAX_PLAYGROUND_TELEGRAM_BOT_TOKEN");
        System.out.println(botToken);
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new Bot(botToken));
    }
}