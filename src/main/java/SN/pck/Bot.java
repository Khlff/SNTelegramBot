package SN.pck;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;

public class Bot {
    private final TelegramBot bot = new TelegramBot("5724149159:AAEQMBUa6mfTPLRPqdJTKiGQybCCJ4qp3QU");

    public void serve() {
        // Register for updates
        bot.setUpdatesListener(updates -> {
            updates.forEach(this::process);
            // ... process updates
            // return id of last processed update or confirm them all
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    private void process(Update update) {
        // Send messages
        Message message = update.message();
        CallbackQuery callbackQuery = update.callbackQuery();

        BaseRequest request = null;

        if (message != null) {
            long chatId = message.chat().id();
            request = new SendMessage(chatId, "Hello!");
        }

        if (request != null) {
            bot.execute(request);
        }
    }
}
