package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class QuestionEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String que_id;
	
	@Column
	private String que_text;
	
	@Column
	private String user_id;
	
	@Column
	private List<String> tags;
	
	@Column
	private Boolean isAnswered;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "que", cascade = CascadeType.ALL)
	private List<AnswerEntity> answers =  new ArrayList<>();
	
	@Column
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
