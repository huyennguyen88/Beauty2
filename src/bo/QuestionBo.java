package bo;

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


}
