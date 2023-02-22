package com.exam.services;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.payload.QuestionResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();


    public Question getQuestion(Long questionId);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

//    Delete Question
public void deleteQuestion(Long quesId);

//try pagination
QuestionResponse getAllQuestion(Integer pageNumber, Integer pageSize);

}
