package services;

import java.util.List;

import org.springframework.stereotype.Service;

import models.QuestionEntity;

@Service
public interface QuestionService {
	
	public QuestionEntity postQuestion(QuestionEntity que);
	
	public List<QuestionEntity> getAllQue();
	
	public List<QuestionEntity> getQuesByUserId(String user_id);
	
	public List<QuestionEntity> getAllAnsweredQue(String user_id);
	
	public Boolean deleteQue(String que_id);
		
}
