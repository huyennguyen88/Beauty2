package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.Question;
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
				n.setCreated_at(rs.getTimestamp("created_at"));
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
	public Question getOneQuestion(int question_id) {
		Question n = null;
		String sql = "SELECT * FROM question WHERE "
				+  "question_id = ?";
		PreparedStatement pstmt = DBUtils.getPreparedStatement(sql);
		try {
			pstmt.setInt(1, question_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				n = new Question();
				n.setQuestion_id(rs.getInt("question_id"));
				n.setCategory_id(rs.getInt("category_id"));
				n.setContent(rs.getString("content"));
				n.setCreated_at(rs.getTimestamp("created_at"));
				n.setTitle(rs.getString("title"));
				n.setUser_id(rs.getInt("user_id"));
				n.setStatus(rs.getInt("status"));
				return n;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}
	public boolean addQuestion(Question n) throws SQLException {
		String query = "INSERT INTO question(title,content,category_id, user_id) VALUES(?,?,?,?)";
		PreparedStatement pstmt = DBUtils.getPreparedStatement(query);
		pstmt.setString(1, n.getTitle());
		pstmt.setString(2, n.getContent());
		pstmt.setInt(3, n.getCategory_id());
		pstmt.setInt(4, n.getUser_id());
		pstmt.executeUpdate();
		return true;
	}
	public boolean updateQueStatus(Question n) throws SQLException {
		String query = "UPDATE question "
				+ "SET status= ? "
				+ "WHERE question_id = ? ";
		PreparedStatement pstmt = DBUtils.getPreparedStatement(query);
		pstmt.setInt(1,1);
		pstmt.setInt(2, n.getQuestion_id());
		pstmt.executeUpdate();
		return true;
	}

}
