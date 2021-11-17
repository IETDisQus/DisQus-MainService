package services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AnswerDao;
import dao.QuestionDao;
import dto.Answer;
import models.AnswerEntity;

@Service
public class AnswerServiceImpl implements AnswerService{
	
	@Autowired
	private AnswerDao answerDao;
	
	@Autowired 
	private QuestionDao queDao;

	@Override
	@Transactional
	public Boolean postAnswer(Answer ans) {
		AnswerEntity ansEntity = new AnswerEntity();
		ansEntity.setAnsText(ans.getAnsText());
		ansEntity.setIsVerified(false);
		ansEntity.setQue(queDao.getById(ans.getQue()));
		ansEntity.setTimeStamp(ans.getTimeStamp());
		ansEntity.setUpvotes(ans.getUpvotes());
		ansEntity.setUser_id(ans.getAnswered_by());
		
		try {
			answerDao.save(ansEntity);
			return true;
		}
		catch(Exception e) {
			return false;
		}
			
	}

	@Override
	public List<Answer> getAllAnswersByQueId(String que_id) {
		
		if(que_id != null && queDao.existsById(que_id)) {
			List<Answer> answers = new ArrayList<Answer>();
			try {
				List<AnswerEntity> ansEntities = answerDao.getAnswersByQueId(que_id);
				for(AnswerEntity ansEntity : ansEntities) {
					answers.add(convertToDTO(ansEntity));
				}
				return answers;
			}
			catch(Exception e) {
				return null;
			}
			
		}
		else {
			return null;
		}
		
	}

	@Override
	public List<Answer> getAllVerifiedAnswer(String que_id) {
		List<Answer> answers = new ArrayList<Answer>();
		List<AnswerEntity> ansEntities = answerDao.getAnswersByQueId(que_id);
		for(AnswerEntity ansEntity : ansEntities) {
			answers.add(convertToDTO(ansEntity));
		}
		return answers;
	}

	@Override
	@Transactional
	public Boolean verifyAnswer(String ans_id) {
		
		if(ans_id != null && answerDao.existsById(ans_id)) {
			AnswerEntity ansEntity = answerDao.getById(ans_id);
			ansEntity.setIsVerified(true);
			try {
				answerDao.save(ansEntity);	
				return true;
			}
			catch(Exception e) {
				return false;
			}
		}
		else {
			return false;
		}
			
	}

	@Override
	@Transactional
	public Boolean upVoteAnswer(String ans_id) {
		
		if(ans_id != null && answerDao.existsById(ans_id)) {
			AnswerEntity ansEntity = answerDao.getById(ans_id);
			 ansEntity.setUpvotes(ansEntity.getUpvotes()+1);
			 try {
				 answerDao.save(ansEntity);
				 return true;
			 }
			 catch(Exception e) {
				 return false;
			 }
		}
		else {
			return false;
		}
		
	}
	
	private Answer convertToDTO(AnswerEntity ansEntity) {
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
