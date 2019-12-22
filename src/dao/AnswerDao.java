package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Answer;
import beans.Category;
import beans.Question;
import beans.User;
import db.DBUtils;

public class AnswerDao {

	public AnswerDao() {
		// TODO Auto-generated constructor stub
	}

	public boolean addAnswer(Answer n) throws SQLException {
		String query = "INSERT INTO answer(content,question_id, user_id) VALUES(?,?,?)";
		PreparedStatement pstmt = DBUtils.getPreparedStatement(query);
		pstmt.setString(1, n.getContent());
		pstmt.setInt(2, n.getQuestion_id());
		pstmt.setInt(3, n.getUser_id());
		pstmt.executeUpdate();
		return true;
	}
	

}
