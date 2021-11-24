package services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.QuestionDao;
import models.QuestionEntity;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(QuestionServiceImpl.class);

	@Autowired
	QuestionDao questionDao;
	
	@Override
	@Transactional
	public QuestionEntity postQuestion(QuestionEntity que) {
		try {
			return questionDao.save(que);
		}
		catch(IllegalArgumentException e) {
			log.error("QuestionEntity is null");
			return null;
		}
	}

	
	@Override
	public List<QuestionEntity> getAllQue() {
		
		try {
			List<QuestionEntity> questionEntities = questionDao.findAll();
			return questionEntities;
		}
		catch(Exception e) {
			log.error("Exception while fetching ques from DB {}",e);
			return null;
		}
	}

	@Override
	public List<QuestionEntity> getQuesByUserId(String user_id) {
			try {
				if(user_id != null && user_id == "") {
					List<QuestionEntity> questions = questionDao.getAllQueByUserId(user_id);
					return questions;
				}else {
					throw new IllegalArgumentException("user_id is null or empty");
				}
			}
			catch(Exception e) {
				log.error("Exception {} while fetching que from Db with user_id {}",e, user_id);
				return null;
			}	
	}

	@Override
	public List<QuestionEntity> getAllAnsweredQue(String user_id) {
		
		try {
			if(user_id != null && user_id != "") {
				List<QuestionEntity> questions = questionDao.getAnsweredQueByUserId(user_id);
				return questions;
			}else {
				throw new IllegalArgumentException("user_id is null or empty");
			}
		}
		catch(Exception e) {
			log.error("Exception {} while fetching answered que from Db with user_id {}", e,user_id);
			return null;
		}	
	}

	@Override
	public Boolean deleteQue(String que_id) {
		try {
			questionDao.deleteById(que_id);
			return true;
		}
		catch(Exception e) {
			log.error("Exception {} while deleting que",e);
			return false;
		}
		
	}

}
