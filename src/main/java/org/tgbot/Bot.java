package org.tgbot;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.tgbot.handlers.MsgNonCommandHandler;

public final class Bot extends TelegramLongPollingCommandBot {
    private final String BOT_NAME;
    private final String BOT_TOKEN;
    //Класс для обработки сообщений, не являющихся командой
    private final MsgNonCommandHandler msgNonCommandHandler;

    /** Конструктор */
    public Bot(String botName, String botToken) {
        super();
        this.BOT_NAME = botName;
        this.BOT_TOKEN = botToken;
        //создаём вспомогательный класс для работы с сообщениями, не являющимися командами
        this.msgNonCommandHandler = new MsgNonCommandHandler();

        //регистрируем команды
        // register(new StartCommand("start", "Старт"));
        // register(new HelpCommand("help", "помощь"));

    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    /** Формирование ответа на сообщение, не являющееся командой */
    public void processNonCommandUpdate(Update update) {
        Message msg = update.getMessage();
        Long chatId = msg.getChatId();
        String userName = getUserName(msg);

        String answer = msgNonCommandHandler.nonCommandExecute(chatId, userName, msg.getText());
        setAnswer(chatId, userName, answer);
    }

    /** Формирование имени пользователя */
    private String getUserName(Message msg) {
        User user = msg.getFrom();
        String userName = user.getUserName();
        return (userName != null) ? userName : String.format("%s %s", user.getLastName(), user.getFirstName());
    }

    /** Отправка ответа */
    private void setAnswer(Long chatId, String userName, String text) {
        SendMessage answer = new SendMessage();
        answer.setText(text);
        answer.setChatId(chatId.toString());
        try {
            execute(answer);
        } catch (TelegramApiException e) {
            System.out.println(e + " " + userName);
        }
    }
}