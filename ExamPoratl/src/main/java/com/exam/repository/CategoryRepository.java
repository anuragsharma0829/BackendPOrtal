package com.exam.repository;

import com.exam.model.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("select  count(c.cid)  from Category c ")
    public int toatlCategory();

}
