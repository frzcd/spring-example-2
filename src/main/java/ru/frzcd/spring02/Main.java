package ru.frzcd.spring02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.frzcd.spring02.config.ApplicationConfig;
import ru.frzcd.spring02.domain.QuizGame;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        QuizGame game = context.getBean("quizGame", QuizGame.class);
        game.playGame();
    }
}
