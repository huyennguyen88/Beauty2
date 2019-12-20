package beans;

public class Category {
	private int category_id;
	private String name;
	public Category() {

	}
	public Category(int category_id, String name) {
		this.category_id = category_id;
		this.name = name;
	}
	public void setCategory_id(int category_id ) {
		this.category_id = category_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategory_id() {
		return this.category_id;
	}
	public String getName() {
		return this.name;
	}
	

}
