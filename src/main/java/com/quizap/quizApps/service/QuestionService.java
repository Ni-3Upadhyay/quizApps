package com.quizap.quizApps.service;

import com.quizap.quizApps.Dao.QuestionDao;
import com.quizap.quizApps.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    @RequestMapping("allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestion(){
        try{
       return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
    }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Questions>> getQuestionByCategory( String category){
        try{
        return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
    }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(@RequestBody Questions questions){
        questionDao.save(questions);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }
}
