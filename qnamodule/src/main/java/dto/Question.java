package dto;

import java.time.LocalDateTime;
import java.util.List;

public class Question {

	private String queId;
	
	private String queText;

	private List<String> tags;
	
	private Boolean isAnswered;
	
	private String questioned_by ;
	
	private List<Answer> answers;
	
	private LocalDateTime timeStamp ;
	
	public String getQueId() {
		return queId;
	}

	public void setQueId(String queId) {
		this.queId = queId;
	}

	public String getQueText() {
		return queText;
	}

	public void setQueText(String queText) {
		this.queText = queText;
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

	public String getQuestioned_by() {
		return questioned_by;
	}

	public void setQuestioned_by(String questioned_by) {
		this.questioned_by = questioned_by;
	}


	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public Question() {
		super();
	}

	public Question(String queId, String queText, List<String> tags, Boolean isAnswered, String questioned_by,
			List<Answer> answers, LocalDateTime timeStamp) {
		super();
		this.queId = queId;
		this.queText = queText;
		this.tags = tags;
		this.isAnswered = isAnswered;
		this.questioned_by = questioned_by;
		this.answers = answers;
		this.timeStamp = timeStamp;
	}
}
