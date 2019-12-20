package beans;

import java.util.Date;

public class Question {

	private int question_id;
	private String title;
	private String content;
	private int status;
	private Date created_at;
	private int user_id;
	private int category_id;
	public Question() {
		
	}
	public Question(int question_id, String title, String content, int status,  Date created_at, int user_id, int category_id) 
	{
		this.question_id = question_id;
		this.title = title ;
		this.content = content ;
		this.status = status ;
		this.created_at = created_at ;
		this.user_id = user_id ;
		this.category_id = category_id ;
		
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public void setTitle (String title) {
		this.title = title ;
	}
	public void setContent (String content) {
		this.content = content ;
	}
	public void setStatus (int status) {
		this.status = status ;
	}
	public void setCreated_at (Date created_at) {
		this.created_at = created_at ;
	}
	public void setUser_id (int user_id) {
		this.user_id = user_id ;
	}
	public void setCategory_id (int category_id) {
		this.category_id = category_id ;
	}
	public int getQuestion_id () {
		return this.question_id ;
	}
	public String getTitle () {
		return this.title ;
	}
	public String getContent () {
		return this.content ;
	}
	public int getStatus () {
		return this.status ;
	}
	public Date getCreated_at () {
		return this.created_at ;
	}
	public int getUser_id () {
		return this.user_id ;
	}
	public int getCategory_id () {
		return this.category_id ;
	}

}
