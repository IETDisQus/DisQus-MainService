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
import models.AnswerEntity;
import services.AnswerService;

@RestController
@RequestMapping("/answers")
@CrossOrigin(origins="*")
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;

	@PostMapping("/reply")
	public ResponseEntity<?> postAns(@RequestBody AnswerEntity ans) {
		AnswerEntity ansEntity = answerService.postAnswer(ans);
		 if(ansEntity != null) {
			 return new ResponseEntity<AnswerEntity>(ansEntity, HttpStatus.CREATED);
		 }else {
			 return new ResponseEntity<ErrorMessage>(new ErrorMessage("db error: ans is null"),HttpStatus.SERVICE_UNAVAILABLE);
		 }
	}
	
	@PostMapping("/verify/{ans_id}")
	public ResponseEntity<?> verifyAns(@PathVariable String ans_id) {
		
		if(answerService.verifyAnswer(ans_id)) {
			return  new ResponseEntity<String>("answer verified",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("db error: invalid ans_id",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@PostMapping("/upVote/{ans_id}")
	public ResponseEntity<?> upvoteAns(@PathVariable String ans_id) {
		
		if(answerService.upVoteAnswer(ans_id)) {
			return  new ResponseEntity<String>("answer upvoted",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("db error: invalid ans_id",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@GetMapping("/all/{que_id}")
	public ResponseEntity<?> getAllAnsToQue(@PathVariable String que_id){
		List<AnswerEntity > answers = answerService.getAllAnswersByQueId(que_id);
		if(answers != null) {
			return new ResponseEntity<List<AnswerEntity>>(answers , HttpStatus.OK);
		}else {
			ErrorMessage errorMsg = new ErrorMessage("answers not found");
			return new ResponseEntity<ErrorMessage>(errorMsg,HttpStatus.NOT_FOUND);
		}	
		
	}
	
}
