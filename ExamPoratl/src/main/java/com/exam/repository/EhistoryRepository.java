package com.exam.repository;

import com.exam.model.exam.Category;
import com.exam.model.exam.Ehistory;
import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface EhistoryRepository extends JpaRepository<Ehistory,Integer> {


//    List<Ehistory> findByUnameAndAndQuizId(String uname,String QuizId);

//  List<Ehistory>findByUnameAndAndQuizId(Integer quizId,Integer uname);

  Set<Ehistory>findByUnameAndAndQuizId(Integer quizId,Integer uname);
}
