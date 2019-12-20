package bo;

import beans.User;
import dao.CheckLoginDao;

public class CheckLoginBo {

	CheckLoginDao checklogindao;
	public CheckLoginBo() {
		checklogindao = new CheckLoginDao();
	}
	public User checkUserLogin(String email,String password) {
		return checklogindao.checkUserLogin(email, password);
	}
	

}
