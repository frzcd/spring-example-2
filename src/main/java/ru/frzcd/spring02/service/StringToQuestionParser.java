package ru.frzcd.spring02.service;

import org.springframework.stereotype.Service;
import ru.frzcd.spring02.domain.Question;

@Service
public class StringToQuestionParser {
    public Question getQuestion(String string) {
        int answer = Integer.parseInt(string.split("/")[5]);
        string = string.substring(0, string.lastIndexOf('/'));
        String[] data = string.split("/");

        return new Question(data, answer);
    }
}
