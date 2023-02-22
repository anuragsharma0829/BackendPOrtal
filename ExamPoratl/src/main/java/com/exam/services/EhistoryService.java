package com.exam.services;

import com.exam.model.exam.Ehistory;
import com.exam.model.exam.Quiz;

import java.util.List;
import java.util.Set;

public interface EhistoryService {

    public Ehistory savehistory(Ehistory ehistory);

    public Set<Ehistory> getHistory(Integer uname , Integer quizId);

    List<Ehistory> getAllHistory();

}

