package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.User;
import db.DBUtils;


public class UserDao {

	public UserDao() {
		
	}
	public List<User> getAll(){
		
		String sql = "SELECT * FROM user";
		PreparedStatement pstmt = DBUtils.getPreparedStatement(sql);
		List<User> list = new ArrayList<User>();
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				User n = new User();
				n.setUser_id(rs.getInt("user_id") );
				n.setEmail(rs.getString("email"));
				n.setName(rs.getString("name"));
				n.setPassword(rs.getString("password"));
				n.setRole(rs.getInt("role"));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public User getOne(int user_id){
			String sql = "SELECT * FROM user WHERE user_id = ?";
			PreparedStatement pstmt = DBUtils.getPreparedStatement(sql);
			try {
				pstmt.setInt(1,user_id );
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					User n = new User();
					n.setUser_id(rs.getInt("user_id") );
					n.setEmail(rs.getString("email"));
					n.setName(rs.getString("name"));
					n.setPassword(rs.getString("password"));
					n.setRole(rs.getInt("role"));
					return n;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

	public boolean addUser(User n) throws SQLException {
		String query = "INSERT INTO user(name,email,password,role) VALUES(?,?,?,?)";
		PreparedStatement pstmt = DBUtils.getPreparedStatement(query);
		pstmt.setString(1, n.getName());
		pstmt.setString(2, n.getEmail());
		pstmt.setString(3, n.getPassword());
		pstmt.setInt(4, n.getRole());
		pstmt.executeUpdate();
		return true;
	}
	public boolean updateUser(User n) throws SQLException {
		String query = "UPDATE user "
				+ "SET name= ?, email= ? , password= ?, role= ? "
				+ "WHERE user_id = ? ";
		PreparedStatement pstmt = DBUtils.getPreparedStatement(query);
		pstmt.setString(1, n.getName());
		pstmt.setString(2, n.getEmail());
		pstmt.setString(3, n.getPassword());
		pstmt.setInt(4, n.getRole());
		pstmt.setInt(5, n.getUser_id());
		pstmt.executeUpdate();
		return true;
	}
	public boolean deleteUser(int user_id) throws SQLException {
		String query = "DELETE FROM user "
				+ "WHERE user_id = ? ";
		PreparedStatement pstmt = DBUtils.getPreparedStatement(query);
		pstmt.setInt(1, user_id);
		pstmt.executeUpdate();
		return true;
	}
	public User findUser(int user_id) throws SQLException {
		String query = "SELECT * FROM user WHERE user_id=?";
        PreparedStatement pstm = DBUtils.getPreparedStatement(query);
        pstm.setInt(1, user_id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
        	User n = new User();
			n.setUser_id(rs.getInt("user_id") );
			n.setEmail(rs.getString("email"));
			n.setName(rs.getString("name"));
			n.setPassword(rs.getString("password"));
			n.setRole(rs.getInt("role"));
            return n;
        }
        return null;
	}

}
