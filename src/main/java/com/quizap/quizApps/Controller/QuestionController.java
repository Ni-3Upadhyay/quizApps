package com.quizap.quizApps.Controller;

import com.quizap.quizApps.Dao.QuestionDao;
import com.quizap.quizApps.model.Questions;
import com.quizap.quizApps.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionDao questionDao;


    @RequestMapping("allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestion() {
        return questionService.getAllQuestion();

    }

    @RequestMapping("category/{category}")
    public ResponseEntity<List<Questions>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions questions){
        return questionService.addQuestion(questions);
    }


}
