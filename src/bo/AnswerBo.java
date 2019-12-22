package bo;

import java.sql.SQLException;

import beans.Answer;
import dao.AnswerDao;

public class AnswerBo {
	AnswerDao dao;
	public AnswerBo() {
		dao =new AnswerDao();
	}
	public boolean addAnswer(Answer n) throws SQLException {
		return dao.addAnswer(n);
	}

}
