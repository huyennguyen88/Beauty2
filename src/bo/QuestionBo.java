package bo;

import java.sql.SQLException;
import java.util.List;

import beans.Question;
import dao.QuestionDao;
public class QuestionBo {
	public QuestionDao dao;
	public QuestionBo(){
		dao = new QuestionDao();
	}
	public List<Question> getPendingQuestions(){
		return dao.getPendingQuestions();
	}
	public boolean addQuestion(Question n) throws SQLException{
		return dao.addQuestion(n);
	}
	public boolean updateQueStatus(Question n) throws SQLException {
		return dao.updateQueStatus(n);
	}
	public Question getOneQuestion(int question_id) {
		return dao.getOneQuestion(question_id);
	}


}
