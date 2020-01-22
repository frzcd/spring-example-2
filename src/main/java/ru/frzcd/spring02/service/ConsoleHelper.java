package ru.frzcd.spring02.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service("consoleHelper")
public class ConsoleHelper {
    private final BufferedReader reader;
    @Value("${test}")
    public String someString;

    public ConsoleHelper() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void print(String message) {
        System.out.println(message);
    }

    public String readLine() {
        String result = null;
        try {
            result = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
