package services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AnswerDao;
import dao.QuestionDao;
import models.AnswerEntity;

@Service
public class AnswerServiceImpl implements AnswerService{
	
	@Autowired
	private AnswerDao answerDao;
	
	@Autowired 
	private QuestionDao queDao;
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AnswerServiceImpl.class);

	@Override
	@Transactional
	public AnswerEntity postAnswer(AnswerEntity ans) {
		try {
			return answerDao.save(ans);
		}
		catch(IllegalArgumentException e) {
			log.error("AnswerEntity is null");
			return null;
		}		
	}

	@Override
	public List<AnswerEntity> getAllAnswersByQueId(String que_id) {
	 try {
		 if(que_id != null && queDao.existsById(que_id)) {
				List<AnswerEntity> answers = answerDao.getAnswersByQueId(que_id);
				return answers;
			}
			else{
				log.error("que_id is null");
				return null;
			}
	 }catch(Exception e) {
		 log.error("Exception {} while fetching answers of que {}",e,que_id);
		 return null;
	 }
		
	}

	@Override
	public List<AnswerEntity> getAllVerifiedAnswer(String que_id){
		 try {
			 if(que_id != null && queDao.existsById(que_id)) {
					List<AnswerEntity> answers = answerDao.getVerifiedAnswers(que_id);
					return answers;
				}
				else{
					log.error("que_id is null");
					return null;
				}
		 }catch(Exception e) {
			 log.error("Exception {} while fetching answers of que {}",e,que_id);
			 return null;
		 }		
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
	
}
