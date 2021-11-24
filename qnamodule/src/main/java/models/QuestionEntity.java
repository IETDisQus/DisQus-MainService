package models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table
public class QuestionEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String que_id;
	
	private String que_text;
	
	
	private String user_id;
	
	@ElementCollection
	private List<String> tags;
	
	private Boolean isAnswered;
	
	@JsonIgnore
	@OneToMany(mappedBy = "que")
	private List<AnswerEntity> answers ;
	
	private LocalDateTime timeStamp ;
	
	
	public String getQue_id() {
		return que_id;
	}

	public void setQue_id(String que_id) {
		this.que_id = que_id;
	}

	public String getQue_text() {
		return que_text;
	}

	public void setQue_text(String que_text) {
		this.que_text = que_text;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Boolean getIsAnswered() {
		return isAnswered;
	}

	public void setIsAnswered(Boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	public List<AnswerEntity> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerEntity> answers) {
		this.answers = answers;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	
}
