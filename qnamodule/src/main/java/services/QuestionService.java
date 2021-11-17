package services;

import java.util.List;

import org.springframework.stereotype.Service;

import dto.Question;

@Service
public interface QuestionService {
	
	public Boolean postQuestion(Question que);
	
	public List<Question> getAllQue();
	
	public List<Question> getQuesByUserId(String user_id);
	
	public List<Question> getAllAnsweredQue(String user_id);
	
	public Boolean deleteQue(String que_id);
		
}
