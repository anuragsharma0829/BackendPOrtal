package com.exam.services.impl;

import com.exam.model.exam.Ehistory;
import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.repository.EhistoryRepository;
import com.exam.services.EhistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Repository
public class EhistoryServiceImpl implements EhistoryService {

    @Autowired
    private EhistoryRepository ehistoryRepository;

    @Override
    public Ehistory savehistory(Ehistory ehistory) {
       return this.ehistoryRepository.save(ehistory);
    }

    @Override
    public Set<Ehistory> getHistory(Integer quizId, Integer uname) {
        return this.ehistoryRepository.findByUnameAndAndQuizId(quizId,uname);
    }

    @Override
    public List<Ehistory> getAllHistory() {
        return this.ehistoryRepository.findAll();
    }
}
