package services;

import java.util.List;

import org.springframework.stereotype.Service;

import models.AnswerEntity;

@Service
public interface AnswerService {
	
	public AnswerEntity postAnswer(AnswerEntity ans);
	
	public List<AnswerEntity> getAllAnswersByQueId(String que_id);
	
	public List<AnswerEntity> getAllVerifiedAnswer(String que_id);
	
	public Boolean verifyAnswer(String ans_id);
	
	public Boolean upVoteAnswer(String ans_id);
	
}
