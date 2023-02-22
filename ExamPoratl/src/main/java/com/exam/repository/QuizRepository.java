package com.exam.repository;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizRepository  extends JpaRepository<Quiz,Long> {

    @Query("select  count(q.qId)  from Quiz q ")
    public int toatlQuizzes();

    public List<Quiz> findByActive(Boolean b);
    public List<Quiz> findByCategoryAndActive(Category c,Boolean b);

    public List<Quiz> findBycategory(Category category);

}

