package org.tgbot;

import java.util.HashMap;

public class Questions {
    Questions() {
        questions.put("Когда родился Александр Сергеевич пушкин?(год)", 1799);
        questions.put("Год развала СССР?", 1991);
        questions.put("Год крещения Руси?", 988);
    }
    HashMap<String, Integer> questions = new HashMap<>();
    void addQuestion(String stringQuestion, Integer intAnswer) {
        questions.put(stringQuestion, intAnswer);
    }
}




