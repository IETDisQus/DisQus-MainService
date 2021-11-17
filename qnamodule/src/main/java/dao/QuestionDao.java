package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.QuestionEntity;

@Repository
public interface QuestionDao extends JpaRepository<QuestionEntity,String>{

}
