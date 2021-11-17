package services;

import java.util.List;

import org.springframework.stereotype.Service;

import dto.Answer;

@Service
public interface AnswerService {
	
	public Boolean postAnswer(Answer ans);
	
	public List<Answer> getAllAnswersByQueId(String que_id);
	
	public List<Answer> getAllVerifiedAnswer(String que_id);
	
	public Boolean verifyAnswer(String ans_id);
	
	public Boolean upVoteAnswer(String ans_id);
	
}
