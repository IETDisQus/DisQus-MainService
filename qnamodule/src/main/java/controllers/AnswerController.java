package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.Answer;
import services.AnswerService;

@RestController
@RequestMapping("/answers")
@CrossOrigin(origins="*")
public class AnswerController {
	
	@Autowired
	private AnswerService ansService;

	@PostMapping("/reply")
	public BodyBuilder postAns(@RequestBody Answer ans) {
		
		if(ansService.postAnswer(ans)) {
			return (BodyBuilder) ResponseEntity.ok();
		}
		else {
			return (BodyBuilder) ResponseEntity.status(0);
		}
	}
	
	@PostMapping("/verify/{ans_id")
	public BodyBuilder verifyAns(@PathVariable String ans_id) {
		
		if(ansService.verifyAnswer(ans_id)) {
			return (BodyBuilder) ResponseEntity.ok();
		}
		else {
			return (BodyBuilder) ResponseEntity.status(0);
		}
	}
	
	@PostMapping("/upVote/{ans_id")
	public BodyBuilder upVoteAns(@PathVariable String ans_id) {
		
		if(ansService.upVoteAnswer(ans_id)) {
			return (BodyBuilder) ResponseEntity.ok();
		}
		else {
			return (BodyBuilder) ResponseEntity.status(0);
		}
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/all/{que_id}")
	public ResponseEntity<List<Answer>> getAllAnswerstoQue(@PathVariable String que_id){
		
		List<Answer> answers = ansService.getAllAnswersByQueId(que_id);
		return (ResponseEntity<List<Answer>>) answers;
		
	}
	
	
}
