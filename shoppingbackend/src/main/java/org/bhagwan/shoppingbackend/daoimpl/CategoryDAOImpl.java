package org.bhagwan.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.bhagwan.shoppingbackend.dao.CategoryDAO;
import org.bhagwan.shoppingbackend.dto.Category;
import org.springframework.stereotype.Repository;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categoryList= new ArrayList<>();
	static{
		Category category=new Category();
		//adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is Description for category Televison");
		category.setImageURL("CAT_1.png");
		categoryList.add(category);
		
		category=new Category();
		//adding Second category
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is Description for category Mobile");
		category.setImageURL("CAT_2.png");
		categoryList.add(category);
		
		category=new Category();
		//adding Third category
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is Description for category Laptop");
		category.setImageURL("CAT_3.png");
		categoryList.add(category);
	}
	@Override
	public List<Category> list() {
		return categoryList;
	}
	@Override
	public Category get(int id) {
		for(Category cat:categoryList){
			if(cat.getId()==id) return cat;
		}
		return null;
	}

}
