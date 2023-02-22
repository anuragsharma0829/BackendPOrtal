package com.exam.repository;

import com.exam.model.User;
import com.exam.model.exam.Ehistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String token);

//get best scorer by id

    @Query(value="SELECT CONCAT(FIRST_NAME, LAST_NAME) AS FULLNAME,profile,MAX(MARKS),title FROM USERS U JOIN EHISTORY E ON U.id=E.UNAME join quiz on quiz.q_id=e.quiz_id group by quiz_id;", nativeQuery = true)
    public List<Object[]> getbytableno();
}
