package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;
import db.DBUtils;

public class CheckLoginDao {

	public CheckLoginDao() {
		
	}
	
	public User checkUserLogin(String email,String password)  {
		String sql = "SELECT * FROM user WHERE "
				+ "email = ? AND"
				+ " password = ?";
		PreparedStatement pstmt = DBUtils.getPreparedStatement(sql);
		User u=null;
		try {
			pstmt.setString(1, email);
			pstmt.setString(2,password);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				u = new User();
				u.setUser_id(rs.getInt("user_id"));
				u.setPassword(rs.getString("password"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setRole(rs.getInt("role"));
				System.out.println("Yes");
			}
			return u;

		} catch (SQLException e) {

			e.printStackTrace();
		}		
		return u;
	}


}
