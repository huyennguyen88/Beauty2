package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import beans.Question;
import beans.QuestionWAnswer;
import beans.User;
import db.DBUtils;

public class QuestionWAnswerDao {

	public QuestionWAnswerDao() {
		// TODO Auto-generated constructor stub
	}
	public List<Question> getMyPendingQuestion(int user_id)
	{
		String sql = "SELECT * FROM question WHERE "
				+ "user_id = ? AND status = ?";
		PreparedStatement pstmt = DBUtils.getPreparedStatement(sql);
		
		List<Question> list = new ArrayList<Question>();
		try {
			pstmt.setInt(1, user_id);
			pstmt.setInt(2,0);
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
	public List<QuestionWAnswer> getMyDoneQuestion(int user_id)
	{
		String sql = "SELECT      t1.question_id,     "
				+ "t1.user_id as member_id,     "
				+ "t1.title,     "
				+ "t1.created_at as askdate,     "
				+ "t1.content as question_content,    "
				+ "t2.created_at as ansdate,     "
				+ "t2.user_id as consultant_id,     "
				+ "t2.answer_id,     "
				+ "t2.content as answer_content      "
				+ "FROM     question t1 "
				+ "INNER JOIN answer t2   USING(question_id)";
		PreparedStatement pstmt = DBUtils.getPreparedStatement(sql);
		
		List<QuestionWAnswer> list = new ArrayList<QuestionWAnswer>();
		try {
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getInt("member_id")==user_id) {
					QuestionWAnswer n = new QuestionWAnswer();
					n.setQuestion_id(rs.getInt("question_id"));
					n.setAnswer_content(rs.getString("answer_content"));
					n.setQuestion_content(rs.getString("question_content"));
					n.setAnswer_id(rs.getInt("answer_id"));
					n.setMember_id(rs.getInt("member_id"));
					n.setConsultan_id(rs.getInt("consultant_id"));
					n.setTitle(rs.getString("title"));	
					n.setAskdate(rs.getTimestamp("askdate"));
					n.setAnsDate(rs.getTimestamp("ansdate"));
					list.add(n);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

}
