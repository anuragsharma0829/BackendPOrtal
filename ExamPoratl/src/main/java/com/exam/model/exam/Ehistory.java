package com.exam.model.exam;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Ehistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Eid;
    private Integer uname;
    private Long marks;
    private Date date;
    private String correct_answer;
    private String attempted;
    private Integer quizId;
    private String quiz_name;


    public Integer getEid() {
        return Eid;
    }

    public void setEid(Integer eid) {
        Eid = eid;
    }

    public Integer getUname() {
        return uname;
    }

    public void setUname(Integer uname) {
        this.uname = uname;
    }

    public Long getMarks() {
        return marks;
    }

    public void setMarks(Long marks) {
        this.marks = marks;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public String getAttempted() {
        return attempted;
    }

    public void setAttempted(String attempted) {
        this.attempted = attempted;
    }

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public String getQuiz_name() {
        return quiz_name;
    }

    public void setQuiz_name(String quiz_name) {
        this.quiz_name = quiz_name;
    }

    public Ehistory(Integer eid, Integer uname, Long marks, Date date, String correct_answer, String attempted, Integer quizId, String quiz_name) {
        Eid = eid;
        this.uname = uname;
        this.marks = marks;
        this.date = date;
        this.correct_answer = correct_answer;
        this.attempted = attempted;
        this.quizId = quizId;
        this.quiz_name = quiz_name;
    }

    public Ehistory() {
    }
}
