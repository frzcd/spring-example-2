package ru.frzcd.spring02.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.frzcd.spring02.dao.QuestionsDao;
import ru.frzcd.spring02.service.ConsoleHelper;
import ru.frzcd.spring02.service.QuizGameServices;

@Service
public class QuizGame {
    private QuestionsDao dao;
    private ConsoleHelper console;
    private QuizGameServices quizGameServices;
    private String playerName;
    private int questionsNumber;
    private int correctAnswers;

    public void playGame() {
        playerName = quizGameServices.takePlayerName();

        for (Question question : dao.getData()) {
            if (quizGameServices.playOneRound(question)) {
                correctAnswers++;
            }
        }
        quizGameServices.endGame(playerName, correctAnswers, questionsNumber);
    }



    @Autowired
    public QuizGame(QuestionsDao dao, ConsoleHelper console, QuizGameServices quizGameServices) {
        this.dao = dao;
        this.console = console;
        this.quizGameServices = quizGameServices;
        questionsNumber = dao.getData().size();
        correctAnswers = 0;
    }
}
