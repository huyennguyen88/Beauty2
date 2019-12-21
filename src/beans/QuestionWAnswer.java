package beans;

public class QuestionWAnswer {
    private int question_id;
    private int answer_id;
    private int member_id;
    private int consultant_id;
    private String question_content;
    private String answer_content;
    private String title;
	public QuestionWAnswer() {
		// TODO Auto-generated constructor stub
	}
	public void setQuestion_id (int question_id ) {
		this.question_id = question_id;
	}
	public void setAnswer_id (int answer_id) {
		this.answer_id = answer_id;
	}
	public void setMember_id (int member_id ) {
		this.member_id = member_id;
	}
	public void setConsultan_id (int consultant_id ) {
		this.consultant_id = consultant_id;
	}
	public void setQuestion_content (String question_content ) {
		this.question_content = question_content;
	}
	public void setAnswer_content (String answer_content ) {
		this.answer_content = answer_content;
	}
	public void setTitle (String title ) {
		this.title = title;
	}
	public int getQuestion_id() {
		return this.question_id;
	}
	public int getAnswer_id() {
		return this.answer_id;
	}
	public int getMember_id() {
		return this.member_id;
	}
	public int getConsultan_id() {
		return this.consultant_id;
	}
	public String getQuestion_content() {
		return this.question_content;
	}
	public String getAnswer_content() {
		return this.answer_content;
	}
	public String getTitle() {
		return this.title;
	}


}
