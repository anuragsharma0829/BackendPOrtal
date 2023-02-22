package com.exam.controller;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    //    Add quiz service
    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz) {
        Quiz quiz1 = this.quizService.addQuiz(quiz);
        return ResponseEntity.ok(quiz1);
    }

    //    Update Quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> updatte(@RequestBody Quiz quiz) {
        Quiz quiz1 = this.quizService.updateQuiz(quiz);
        return ResponseEntity.ok(quiz1);
    }

    //    get quiz
    @GetMapping("/")
    public ResponseEntity<?> quizzes() {
        Set<Quiz> quiz1 = this.quizService.getQuizzes();
        return ResponseEntity.ok(quiz1);
    }

    //Get single Quiz
    @GetMapping("/{qid}")
    public Quiz quiz(@PathVariable("qid") Long qid) {
        return this.quizService.getQuiz(qid);

    }

    //    Delete Quiz
    @DeleteMapping("/{qid}")
    public void delete(@PathVariable("qid") Long qid) {
        this.quizService.deleteQuiz(qid);
    }

    //Get Total category
    @GetMapping("/qtotal")
    public ResponseEntity<?> getTotalquizz() {
        int Total = this.quizService.totalQuizz();
        return ResponseEntity.ok(Total);
    }

    //    get active quiizess
    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes() {
        return this.quizService.getActiveQuizzes();
    }

//  get active quiizess of category

    @GetMapping("/active/active/{cid}")
    public List<Quiz> getActiveQuizzes(@PathVariable("cid") Long cid) {
        Category category=new Category();
        category.setCid(cid);
        return this.quizService.getActiveQuizzesOfCategory(category);
    }

    @GetMapping("/category/{cid}")
    public List<Quiz> getQuizzesOfCategory(@PathVariable("cid")Long cid){
        Category category=new Category();
        category.setCid(cid);
        return this.quizService.getQuizzesOfCategory(category);
    }
}