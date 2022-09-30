package org.tgbot.handlers;

/** Обработка сообщения, не являющегося командой (не с "/") */
public class MsgNonCommandHandler {

    public String nonCommandExecute(Long chatId, String userName, String text) {
        String answer;
        try {
            answer = text;

        } catch (Exception e) {
            answer = "что-то пошло не так";
        }
        return answer;
    }
}