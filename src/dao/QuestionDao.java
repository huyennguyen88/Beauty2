package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.Question;
import beans.User;
import db.DBUtils;

public class QuestionDao {

	public QuestionDao() {
		// TODO Auto-generated constructor stub
	}
	public List<Question> getPendingQuestions(){
		String sql = "SELECT * FROM question WHERE "
				+  "status = ?";
		PreparedStatement pstmt = DBUtils.getPreparedStatement(sql);
		
		List<Question> list = new ArrayList<Question>();
		try {
			pstmt.setInt(1, 0);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Question n = new Question();
				n.setQuestion_id(rs.getInt("question_id"));
				n.setCategory_id(rs.getInt("category_id"));
				n.setContent(rs.getString("content"));
				n.setCreated_at(rs.getDate("created_at"));
				n.setTitle(rs.getString("title"));
				n.setUser_id(rs.getInt("user_id"));
				n.setStatus(rs.getInt("status"));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
