package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import models.AnswerEntity;

@Repository
@Transactional
public interface AnswerDao extends JpaRepository<AnswerEntity,String> {
	
	@Query("Select ae from AnswerEntity ae where ae.que.que_id = ?1")
	public List<AnswerEntity> getAnswersByQueId(String que_id);

	@Query("Select ae from AnswerEntity ae where ae.isVerified = true and ae.que.que_id=?1")
	public List<AnswerEntity> getVerifiedAnswers(String que_id);
}
