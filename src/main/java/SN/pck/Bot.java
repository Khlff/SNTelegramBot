package SN.pck;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.Objects;

public class Bot {
    private final TelegramBot bot = new TelegramBot("5724149159:AAEQMBUa6mfTPLRPqdJTKiGQybCCJ4qp3QU");

    public void serve() {
        // Register for updates
        bot.setUpdatesListener(updates -> {
            updates.forEach(this::process);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    private void process(Update update) {
        // Send messages
        Message message = update.message();

        BaseRequest request = null;

        if (message != null) {

            System.out.println(message);

            if (Objects.equals(message.text(), "/start")) {
                long chatId = message.chat().id();
                request = new SendMessage(chatId, "This Bot tells you if a certain site or service is down. You can choose for up to 5 services for free. We monitor the services with the help of downdetector.com");
            }

            else {
                long chatId = message.chat().id();
                request = new SendMessage(chatId, "Hello!");
            }
        }

        if (request != null) {
            bot.execute(request);
        }
    }
}
