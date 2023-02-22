package com.exam.services;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Set<Quiz> getQuizzes();

    public Quiz getQuiz(Long quizID);

    public void deleteQuiz(Long quizID);

//    Total Quizzes
    public int totalQuizz();

    public List<Quiz> getActiveQuizzes();

    public List<Quiz> getActiveQuizzesOfCategory(Category c);

    public List<Quiz> getQuizzesOfCategory(Category category);
}
