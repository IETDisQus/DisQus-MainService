package models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AnswerEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String ansId;
	
	@Column
	private String ansText;

	@Column
	private Date timeStamp;
	
	@Column
	private String user_id;
	
	@Column
	private Long upvotes;
	

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "queId", referencedColumnName = "que_id")
	private QuestionEntity que;
	
	@Column
	private Boolean isVerified;

	public String getAnsId() {
		return ansId;
	}

	public void setAnsId(String ansId) {
		this.ansId = ansId;
	}

	public String getAnsText() {
		return ansText;
	}

	public void setAnsText(String ansText) {
		this.ansText = ansText;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Long getUpvotes() {
		return upvotes;
	}

	public void setUpvotes(Long upvotes) {
		this.upvotes = upvotes;
	}

	public QuestionEntity getQue() {
		return que;
	}

	public void setQue(QuestionEntity que) {
		this.que = que;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}
	
	
}
