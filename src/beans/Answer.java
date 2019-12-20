package beans;

import java.util.Date;

public class Answer {
	private int answer_id;
	private String content;
	private Date created_at;
	private int user_id;
	private int question_id;
	public Answer() {
		
	}
	public Answer(int answer_id, String content, Date created_at ,int user_id, int question_id) {
		this.answer_id = answer_id;
		this.content = content;
		this.created_at = created_at;
		this.user_id = user_id;
		this.question_id = question_id;
	}
	public void setAnswer_id (int answer_id) {
		this.answer_id = answer_id;
	}
	public void setContent (String content) {
		this.content = content;
	}
	public void setCreated_at (Date created_at) {
		this.created_at = created_at;
	}
	public void setUser_id (int user_id) {
		this.user_id = user_id;
	}
	public void setQuestion_id (int question_id) {
		this.question_id = question_id;
	}
	public int getAnswer_id() {
		return this.answer_id ;
	}
	public String getContent () {
		return this.content ;
	}
	public Date getCreated_at () {
		return this.created_at ;
	}
	public int getUser_id () {
		return this.user_id ;
	}
	public int getQuestion_id () {
		return this.question_id ;
	}
	

}
