package ru.frzcd.spring02.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.frzcd.spring02.domain.Question;
import ru.frzcd.spring02.service.DataReaderService;

import java.io.IOException;
import java.util.List;

@Repository
public class QuestionsDao {

    private List<Question> data;

    @Autowired
    public void setDataReaderService(DataReaderService dataReaderService) throws IOException {
        data = dataReaderService.readAllData();
    }

    public List<Question> getData() {
        return data;
    }
}
