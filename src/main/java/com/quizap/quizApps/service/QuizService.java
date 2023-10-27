package com.quizap.quizApps.service;

import com.quizap.quizApps.Dao.QuestionDao;
import com.quizap.quizApps.Dao.QuizDao;
import com.quizap.quizApps.model.Questions;
import com.quizap.quizApps.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int noOfQues, String title) {

        List<Questions> questions = questionDao.findQuestionByCategory(category,noOfQues);

        Quiz quiz = new Quiz();

        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
}
