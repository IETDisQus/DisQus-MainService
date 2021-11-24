package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import models.QuestionEntity;

@Repository
public interface QuestionDao extends JpaRepository<QuestionEntity,String>{
	
	@Query("Select qe from QuestionEntity qe where qe.user_id = ?1")
	public List<QuestionEntity> getAllQueByUserId(String user_id);
	
	@Query("Select qe from QuestionEntity qe where qe.user_id=?1 and qe.isAnswered = true")
	public List<QuestionEntity> getAnsweredQueByUserId(String user_id);
	
}
