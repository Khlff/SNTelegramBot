package org.tgbot.commands;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
public class HelpCommand extends ServiceCommand {
    public HelpCommand(String identifier, String description) {
        super(identifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        // Формируем имя пользователя, если имя пользователя скрыто, то берём Имя и Фамилию
        String userName = (user.getUserName() != null) ? user.getUserName() :
                String.format("%s %s", user.getLastName(), user.getFirstName());
        //обращаемся к методу суперкласса для отправки пользователю ответа
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName,
                "/talk - начать общение\n" +
                        "/stoptalk - прекратить поиск\n" +
                        "/change - сменить анкету");
    }
}
