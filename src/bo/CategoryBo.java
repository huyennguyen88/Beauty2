package bo;

import java.util.List;

import beans.Category;
import dao.CategoryDao;

public class CategoryBo {

	public CategoryDao cd;
	public CategoryBo() {
		cd = new CategoryDao();
	}
	public List<Category> getAll(){
		return cd.getAll();
	}

}
