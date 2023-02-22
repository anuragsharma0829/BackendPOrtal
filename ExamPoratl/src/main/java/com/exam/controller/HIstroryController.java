package com.exam.controller;

import com.exam.model.exam.Ehistory;
import com.exam.repository.EhistoryRepository;
import com.exam.services.EhistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/history")
@CrossOrigin("*")
public class HIstroryController {

    @Autowired
    private EhistoryService ehistoryService;


    @PostMapping("/")
    public ResponseEntity<?> setHistory( @RequestBody Ehistory ehistory ){
        Ehistory ehistory1=this.ehistoryService.savehistory(ehistory);
        return ResponseEntity.ok(ehistory1);
    }

//
//    @GetMapping("/{quizId}/{uname}")
//    public ResponseEntity<Ehistory> getHistory(@PathVariable("quizId")Integer qId,
//                                               @PathVariable("uname") Integer uid) {
//        // Logic to fetch the quiz data goes here
//       Ehistory ehistory=this.ehistoryService.getHistory(qId,uid);
//       return ResponseEntity.ok(ehistory);
//}


//    @GetMapping("/data")
//    public ResponseEntity<Ehistory> getData(@RequestParam("uname") String userId, @RequestParam("quizId") String quizId) {
//        // fetch data based on the provided userId and quizId
//        Ehistory data = ehistoryService.getHistory(userId, quizId);
//        return ResponseEntity.ok(data);
//    }


//    @GetMapping("/{userId}/{quizId}")
//    public ResponseEntity<Ehistory> getDataByUserIdAndQuizId(@PathVariable("userId") Integer userId,
//                                                         @PathVariable("quizId") Integer quizId){
//        Ehistory data = (Ehistory) this.ehistoryService.getHistory(userId, quizId);
//        if (data == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(data, HttpStatus.OK);
//    }

    @GetMapping("/{userId}/{quizId}")
    public ResponseEntity<?> getDataByUserIdAndQuizId(@PathVariable("userId") Integer userId,
                                                       @PathVariable("quizId") Integer quizId)
    {
        return ResponseEntity.ok(this.ehistoryService.getHistory(userId, quizId));
    }

//    Get all history
    @GetMapping("/")
    public List<Ehistory> getallHistory(){
        List<Ehistory> ehistory= this.ehistoryService.getAllHistory();
        return ehistory;
    }



}
