package tutorial;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Bot extends TelegramLongPollingBot {
    Integer num = null;
    Integer num2 = null;
    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        if (msg.isCommand()) {
            if (msg.getText().equals("/time")) {
                executeTimeCommand(msg);
            }
        }
    }

    private void executeTimeCommand(Message msg) {
        LocalDateTime time = LocalDateTime.now();
        String[] strTime = time.toString().split("T");
        String[] str = strTime[1].split("\\.");
        String text = str[0];
        sendText(msg.getChatId(), text);
    }

    private void addTwoNumber(Message msg) {
        if (num == null) {
            num = Integer.valueOf(msg.getText());
        } else {
            calcSum(msg.getFrom().getId(), msg.getText());
        }
    }

    private void calcSum(Long chatID, String secondValue) {
        num2 = Integer.valueOf(secondValue);
        int sum = num + num2;
        String text = "Sum of two numbers: " + sum;
        sendText(chatID, text);
        num = null;
        num2 = null;
    }


    public void sendText(Long chatID, String text) {
        SendMessage sm = SendMessage.builder().chatId(chatID).text(text).build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public Bot(String botToken) {
        super(botToken);
    }

    @Override
    public String getBotUsername() {
        return "kate_max_playground_bot";
    }
}
