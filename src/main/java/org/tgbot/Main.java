package org.tgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.tgbot.handlers.TestHandler;

public class Main extends TelegramLongPollingBot {
    private static final String LOGTAG = "MAIN";

    public static void main(String[] args) throws TelegramApiException {

        //ПЕРЕМЕННЫЕ
        String botName = "...";
        String botToken = "5724149159:AAEQMBUa6mfTPLRPqdJTKiGQybCCJ4qp3QU";


        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new TestHandler());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
        @Override
        public String getBotUsername() {
            return "DownAlarm";
            //возвращаем юзера
        }

        @Override
        public void onUpdateReceived(Update e) {
            // Тут будет то, что выполняется при получении сообщения
        }

        @Override
        public String getBotToken() {
            return "YOUR_BOT_TOKEN";
            //Токен бота
        }
}

