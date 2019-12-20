package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Category;
import db.DBUtils;


public class CategoryDao {

	public CategoryDao() {
		// TODO Auto-generated constructor stub
	}
	public List<Category> getAll(){
		String sql = "SELECT * FROM category";
		PreparedStatement pstmt = DBUtils.getPreparedStatement(sql);
		List<Category> list = new ArrayList<Category>();
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Category n = new Category();
				n.setCategory_id(rs.getInt("category_id"));
				n.setName(rs.getString("name"));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
