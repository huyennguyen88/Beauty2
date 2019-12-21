package bo;
import java.util.List;

import beans.Question;
import beans.QuestionWAnswer;
import dao.QuestionWAnswerDao;
public class QuestionWAnswerBo {
    public QuestionWAnswerDao dao;
	public QuestionWAnswerBo() {
		dao = new QuestionWAnswerDao();
	}
	public List<Question> getMyPendingQuestion(int user_id){
		return dao.getMyPendingQuestion(user_id);
	}
	public List<QuestionWAnswer> getMyDoneQuestion(int user_id){
		return dao.getMyDoneQuestion(user_id);
	}
}
