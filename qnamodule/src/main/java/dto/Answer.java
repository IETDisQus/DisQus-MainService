package dto;

import java.util.Date;

public class Answer {
	
	private String ansId;
	
	private String ansText;
	
	private Date timeStamp;
	
	private String answered_by;
	
	private Long upvotes;
	
	private String queId;
	
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

	public String getAnswered_by() {
		return answered_by;
	}

	public void setAnswered_by(String answered_by) {
		this.answered_by = answered_by;
	}

	public Long getUpvotes() {
		return upvotes;
	}

	public void setUpvotes(Long upvotes) {
		this.upvotes = upvotes;
	}

	public String getQue() {
		return queId;
	}

	public void setQue(String que) {
		this.queId = que;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public Answer(String ansId, String ansText, Date timeStamp, String answered_by, Long upvotes, String que,
			Boolean isVerified) {
		super();
		this.ansId = ansId;
		this.ansText = ansText;
		this.timeStamp = timeStamp;
		this.answered_by = answered_by;
		this.upvotes = upvotes;
		this.queId = que;
		this.isVerified = isVerified;
	}

	public Answer() {
		super();
	}
	
}
