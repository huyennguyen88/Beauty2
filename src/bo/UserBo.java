package bo;

import java.sql.SQLException;
import java.util.List;

import beans.User;
import dao.UserDao;



public class UserBo {
	UserDao userdao;
	public UserBo() {
		userdao = new UserDao();
	}
	
	public List<User> getAll(){
		return userdao.getAll();
	}
	public User getOne(int user_id) {
		return userdao.getOne(user_id);
	}
	public boolean addUser(User n) throws SQLException {
		 return userdao.addUser(n);
	}
	public boolean updateUser(User n) throws SQLException{
		return userdao.updateUser(n);
	}
	public boolean deleteUser(int user_id) throws SQLException {
		return userdao.deleteUser(user_id);
	}
	public User findUser(int new_id) throws SQLException{
		return userdao.findUser(new_id);
	}

}
