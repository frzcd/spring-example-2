package ru.frzcd.spring02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.frzcd.spring02.domain.Question;

@Service
public class QuizGameServices {
    private ConsoleHelper console;

    public String takePlayerName() {
        console.print("Please, type your name below: ");
        String name = null;
        while ((name = console.readLine()) == null || name.isEmpty()) {
            console.print("Sorry, name cannot be empty. Try again: ");
        }
        console.print("Hello, " + name);
        return name;
    }

    public boolean playOneRound(Question question) {

        console.print(question.getData()[0]);
        console.print("Choose your answer: ");
        for (int i = 1; i < question.getData().length; i++) {
            console.print(i + question.getData()[i]);
        }
        String answer = null;
        while (isAnswerOk(answer = console.readLine())) {
            console.print("Sorry, the answer must be a number a from 1 to 4");
        }
        return question.getAnswer() == Integer.parseInt(answer);
    }

    public void endGame(String name, int correct, int gameLength) {
        console.print(name + ", thank you for participating");
        console.print("Your result is " + correct + " correct answers out of " + gameLength + " questions");
        console.print(correct + "/" + gameLength);
    }

    private boolean isAnswerOk(String answer) {
        if (answer.length() != 1) {
            return false;
        }
        char letter = answer.charAt(0);
        return
                letter != '1' &&
                letter != '2' &&
                letter != '3' &&
                letter != '4';

    }

    @Autowired
    public QuizGameServices(ConsoleHelper console) {
        this.console = console;
    }
}
