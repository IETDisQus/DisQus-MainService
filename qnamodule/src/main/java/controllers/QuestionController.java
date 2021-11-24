package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import error.ErrorMessage;
import models.QuestionEntity;
import services.QuestionService;

@RestController
@RequestMapping("/questions")
@CrossOrigin(origins="*")
public class QuestionController {
	
	@Autowired 
	private QuestionService questionService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllQue(){
		List<QuestionEntity > questions = questionService.getAllQue();
		if(questions != null) {
			return new ResponseEntity<List<QuestionEntity>>(questions , HttpStatus.OK);
		}else {
			ErrorMessage errorMsg = new ErrorMessage("questions not found");
			return new ResponseEntity<ErrorMessage>(errorMsg,HttpStatus.NOT_FOUND);
		}	
	}
	
	@PostMapping("/ask")
	public ResponseEntity<?> postQue(@RequestBody QuestionEntity que){
		 QuestionEntity queEntity = questionService.postQuestion(que);
		 if(queEntity != null) {
			 return new ResponseEntity<QuestionEntity>(queEntity, HttpStatus.CREATED);
		 }else {
			 return new ResponseEntity<ErrorMessage>(new ErrorMessage("db error: que is null"),HttpStatus.SERVICE_UNAVAILABLE);
		 }
	}
	
	@GetMapping("/replies/{user_id}/")
	public ResponseEntity<?>  getAnsweredQueOfUser(@PathVariable String user_id){
		List<QuestionEntity > questions = questionService.getAllAnsweredQue(user_id);
		if(questions != null) {
			return new ResponseEntity<List<QuestionEntity>>(questions , HttpStatus.OK);
		}else {
			ErrorMessage errorMsg = new ErrorMessage("questions not found");
			return new ResponseEntity<ErrorMessage>(errorMsg,HttpStatus.NOT_FOUND);
		}	
	}
	
	@GetMapping("/{user_id}")
	public ResponseEntity<?> getAllQueOfUser(@PathVariable String user_id){
		List<QuestionEntity > questions = questionService.getQuesByUserId(user_id);
		if(questions != null) {
			return new ResponseEntity<List<QuestionEntity>>(questions , HttpStatus.OK);
		}else {
			ErrorMessage errorMsg = new ErrorMessage("questions not found");
			return new ResponseEntity<ErrorMessage>(errorMsg,HttpStatus.NOT_FOUND);
		}	
	}
	
}
