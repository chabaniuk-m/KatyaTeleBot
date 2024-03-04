package tutorial;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.List;

public class Bot extends TelegramLongPollingBot {
    Integer num = null;
    Integer num2 = null;
    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        User user = msg.getFrom();

        System.out.printf("Користувач %s написав %s\n", user.getFirstName() + user.getLastName(), msg.getText());
    }

    public Bot(String botToken) {
        super(botToken);
    }

    @Override
    public String getBotUsername() {
        return "kate_max_playground_bot";
    }
}
