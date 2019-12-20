package beans;

public class User {
	private int user_id;
	private String name;
	private String password;
	private String email;
	private int role;
	public User() {
		
	}
	public User(int user_id, String name,String password, String email, int role) {
		this.user_id = user_id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getUser_id() {
		return this.user_id;
	}
	public String getName() {
		return this.name;
	}
	public String getPassword() {
		return this.password;
	}
	public String getEmail() {
		return this.email;
	}
	public int getRole() {
		return this.role;
	}

}
