package com.quizap.quizApps.Dao;

import com.quizap.quizApps.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {

    List<Questions> findByCategory(String category);

    @Query(value = "select * from questions q where q.category=:category order by Random() Limit=:noOfQues", nativeQuery = true)
    List<Questions> findQuestionByCategory(String category, int noOfQues);
}
