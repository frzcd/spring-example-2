package ru.frzcd.spring02.domain;

import java.util.Arrays;

public class Question {
    private String[] data;
    private int answer;

    public Question(String[] data, int answer) {
        this.data = data;
        this.answer = answer;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {

        return Arrays.toString(data);
    }
}
