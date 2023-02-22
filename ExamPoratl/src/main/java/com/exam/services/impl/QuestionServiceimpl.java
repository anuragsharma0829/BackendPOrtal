package com.exam.services.impl;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.payload.QuestionResponse;
import com.exam.repository.QuestionRepository;
import com.exam.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuestionServiceimpl  implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public Question addQuestion(Question question) {
      return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
//        int pageSize=5;
//        int pageNumber=1;
//
//        Pageable p= PageRequest.of(pageNumber,pageSize);

        return new LinkedHashSet<>(this.questionRepository.findAll());
//         Page<Question> pagePost =this.questionRepository.findAll(p);
//        Set<Question> allQuestions= (Set<Question>) pagePost.getContent();
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesId) {
        Question question= new Question();
        question.setQuesId(quesId);
        this.questionRepository.delete(question);
    }


//    try pagination
    @Override
    public QuestionResponse getAllQuestion(Integer pageNumber, Integer pageSize) {
              Pageable p= PageRequest.of(pageNumber,pageSize);
              Page<Question> pageQuestion=this.questionRepository.findAll(p);
              List<Question> allQuestion=pageQuestion.getContent();
             List<Question> questions = allQuestion;

             QuestionResponse questionResponse= new QuestionResponse();

             questionResponse.setContent(questions);
             questionResponse.setPageSize(pageQuestion.getSize());
             questionResponse.setPageNumber(pageQuestion.getNumber());
             questionResponse.setTotalElements(pageQuestion.getTotalElements());

             questionResponse.setTotalPages(pageQuestion.getTotalPages());
             questionResponse.setLastPage(pageQuestion.isLast());


              return questionResponse;
    }
}
