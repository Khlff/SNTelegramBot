package org.tgbot.handlers;

/** Обработка сообщения, не являющегося командой (не с "/") */
public class MsgNonCommandHandler {

    public String nonCommandExecute(Long chatId, String userName, String text, Boolean status) {
        String answer;
        try {
            if (!status){
                answer=Math.random()*3;
            }

        } catch (Exception e) {
            answer = "что-то пошло не так";
        }
        return answer;
    }
}