package com.exam.controller;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.payload.QuestionResponse;
import com.exam.services.QuestionService;
import com.exam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;


//Add Question
    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question)
    {
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

//    Update Question
    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question)
    {
        Question question1= this.questionService.updateQuestion(question);
        return ResponseEntity.ok(question1);
    }

//    Get all Question of any Quiz
    @GetMapping("/quiz/{qid}")
public ResponseEntity<?> getQuestionofQuiz(@PathVariable("qid") Long qid)
    {
//        Normal Way
//        Quiz quiz=new Quiz();
//        quiz.setqId(qid);
//        Set<Question> questionOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questionOfQuiz);

      Quiz quiz=  this.quizService.getQuiz(qid);
     Set <Question> questions= quiz.getQuestions();
     List list=new ArrayList(questions);
     if(list.size() >Integer.parseInt(quiz.getNumberOfQuestions()))
     {
         list=list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
     }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }


//    All  questions of
@GetMapping("/quiz/all/{qid}")
public ResponseEntity<?> getQuestionofQuizAdmin(@PathVariable("qid") Long qid)
{
//        Normal Way
        Quiz quiz=new Quiz();
        quiz.setqId(qid);
        Set<Question> questionOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questionOfQuiz);
}


//    Get Single Question
    @GetMapping("/{quesId}")
    public Question get(@PathVariable("quesId") Long quesId){
        return this.questionService.getQuestion((quesId));
    }

//    Delete Question
    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") Long quesId)
    {
        this.questionService.deleteQuestion(quesId);
    }

//    tryl pagination

    @GetMapping("/quest/")
    public ResponseEntity<QuestionResponse> getallQuestions(
            @RequestParam (value = "pageNumber",defaultValue ="0",required = false)Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize
            ){

        QuestionResponse questionResponse= this.questionService.getAllQuestion(pageNumber,pageSize);
        return new ResponseEntity<QuestionResponse>(questionResponse, HttpStatus.OK);
    }
}
