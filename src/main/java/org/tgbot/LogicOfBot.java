package org.tgbot;


public class LogicOfBot {
    private final StandardResponses standardResponses;
    private final StandardUserRequest standardUserRequest;

    //КОНСТРУКТОР
    public LogicOfBot(StandardResponses standardResponses, StandardUserRequest standardUserRequest) {
        this.standardResponses = standardResponses;
        this.standardUserRequest = standardUserRequest;
    }

    //МЕТОДЫ
    public void respondUser(String message){
        if (message.equals(standardUserRequest.start)){
            //sendMessage
        }
    }
}
