package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.Question;
import services.QuestionService;

@RestController
@RequestMapping("/questions")
@CrossOrigin(origins="*")
public class QuestionController {
	
	@Autowired 
	private QuestionService questionService;
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/all")
	public ResponseEntity<List<Question>> getAllQuestions(){
		
		List<Question> questions = questionService.getAllQue();
		return (ResponseEntity<List<Question>>) questions;
		
	}
	
	@PostMapping("/ask")
	public BodyBuilder postQuery(@RequestBody Question que){
		
		if(questionService.postQuestion(que)) {
			return ResponseEntity.ok();
		}else {
			return ResponseEntity.status(0);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/replies/{que_id}")
	public ResponseEntity<List<Question>>  getAnsweredQue(@PathVariable String que_id){
		
		List<Question> answeredQues = questionService.getAllAnsweredQue(que_id);
		return (ResponseEntity<List<Question>>) answeredQues;
	}

}
