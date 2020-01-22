package ru.frzcd.spring02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.frzcd.spring02.domain.Question;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataReaderService {
    private BufferedReader fileReader;
    @Autowired
    private StringToQuestionParser parser;

    public DataReaderService(@Value("${dataFile}")String filePath) throws FileNotFoundException {
        fileReader = new BufferedReader(new FileReader(filePath));
    }

    public String readString() throws IOException {
        return fileReader.readLine();
    }

    public List<Question> readAllData() throws IOException {
        List<Question> database = new ArrayList<Question>();
        String tempString = null;
        while ((tempString = fileReader.readLine()) != null) {
            database.add(parser.getQuestion(tempString));
        }

        return database;
    }
}
