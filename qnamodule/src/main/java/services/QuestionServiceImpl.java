package services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clients.UserClient;
import dao.QuestionDao;
import dto.Answer;
import dto.Question;
import models.AnswerEntity;
import models.QuestionEntity;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	QuestionDao questionDao;
	
	@Autowired UserClient userClient;

	@Override
	@Transactional
	public Boolean postQuestion(Question que) {
		
		QuestionEntity queEntity = new QuestionEntity();
		
		List<AnswerEntity> ansEntities = new ArrayList<AnswerEntity>();
		
		for(Answer answer : que.getAnswers()) {
			ansEntities.add(convertToEntity(answer));
		}
		
		queEntity.setUser_id(que.getQueId());
		queEntity.setIsAnswered(false);
		queEntity.setAnswers(ansEntities);
		queEntity.setQue_text(que.getQueText());
		queEntity.setTags(que.getTags());
		queEntity.setTimeStamp(que.getTimeStamp());
		queEntity.setUser_id(que.getQuestioned_by());
		
		try {
			questionDao.save(queEntity);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}

	private AnswerEntity convertToEntity(Answer answer) {
		AnswerEntity ansEntity = new AnswerEntity();
		
		ansEntity.setAnsId(answer.getAnsId());
		ansEntity.setAnsText(answer.getAnsText());
		ansEntity.setIsVerified(answer.getIsVerified());
		ansEntity.setQue(questionDao.findById(answer.getQue()).get());
		ansEntity.setTimeStamp(answer.getTimeStamp());
		ansEntity.setUpvotes(answer.getUpvotes());
		ansEntity.setUser_id(answer.getAnswered_by());
		
		return ansEntity;
	}

	@Override
	public List<Question> getAllQue() {
		
		List<QuestionEntity> questionEntities = questionDao.findAll();
		
		List<Question> questionDTOs = new ArrayList<Question>();
		
		for(QuestionEntity que : questionEntities) {
			questionDTOs.add(convertToDTO(que));
		}
		
		return null;
	}

	@Override
	public List<Question> getQuesByUserId(String user_id) {
		
				return null;
	}

	@Override
	public List<Question> getAllAnsweredQue(String user_id) {
		return null;
	}

	@Override
	public Boolean deleteQue(String que_id) {
		
		try {
			questionDao.deleteById(que_id);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}

	private Question convertToDTO(QuestionEntity que) {
		
		Question queDTO = new Question();
		
		List<Answer> answers = new ArrayList<Answer>();
		
		for(AnswerEntity ansEntity : que.getAnswers()) {
			answers.add(convertAnswerEntityToDTO(ansEntity));
		}
		
		queDTO.setIsAnswered(que.getIsAnswered());
		queDTO.setQueId(que.getQue_id());
		queDTO.setQueText(que.getQue_text());
		queDTO.setTags(que.getTags());
		queDTO.setTimeStamp(que.getTimeStamp());
		queDTO.setQuestioned_by(que.getUser_id());
		
		return queDTO;
	}

	private Answer convertAnswerEntityToDTO(AnswerEntity ansEntity) {
		
		Answer ans = new Answer();
		
		ans.setAnsId(ansEntity.getAnsId());
		ans.setAnsText(ansEntity.getAnsText());
		ans.setAnswered_by(ansEntity.getUser_id());
		ans.setIsVerified(ansEntity.getIsVerified());
		ans.setQue(ansEntity.getQue().getQue_id());
		ans.setTimeStamp(ansEntity.getTimeStamp());
		ans.setUpvotes(ansEntity.getUpvotes());
		
		return ans;
	}

}
