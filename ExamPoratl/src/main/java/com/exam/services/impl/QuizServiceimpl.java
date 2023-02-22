package com.exam.services.impl;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.repository.QuizRepository;
import com.exam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceimpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {

        return new LinkedHashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizID) {
        return this.quizRepository.findById(quizID).get();
    }

    @Override
    public void deleteQuiz(Long quizID) {

   this.quizRepository.deleteById(quizID);
    }

    @Override
    public int totalQuizz() {
        return this.quizRepository.toatlQuizzes();
    }



//    Get active quizzes
@Override
public List<Quiz> getActiveQuizzes() {
    return this.quizRepository.findByActive(true);
}

    @Override
    public List<Quiz> getActiveQuizzesOfCategory(Category c) {
        return this.quizRepository.findByCategoryAndActive(c,true);
    }

    @Override
    public List<Quiz> getQuizzesOfCategory(Category category) {
        return this.quizRepository.findBycategory(category);
    }


}
