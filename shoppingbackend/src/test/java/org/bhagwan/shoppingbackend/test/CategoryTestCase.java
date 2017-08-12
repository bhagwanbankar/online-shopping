package org.bhagwan.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.bhagwan.shoppingbackend.dao.CategoryDAO;
import org.bhagwan.shoppingbackend.dto.Category;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private static Category category;
	@BeforeClass
	public static void init(){
		context= new AnnotationConfigApplicationContext();
		context.scan("org.bhagwan.shoppingbackend");
		context.refresh();
		categoryDAO= (CategoryDAO) context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testAddCategory(){
		category= new Category();
		category.setName("Laptop");
		category.setDescription("This is Description for category Laptop");
		category.setImageURL("CAT_3.png");
		assertEquals("Successfully Added Category inside table", true,categoryDAO.add(category));
	}
	 */	
	/*@Test
	public void testGetCategory(){
		category=categoryDAO.get(3);
		assertEquals("Successfully fetched single Category from table", "Laptop",category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory(){
		category=categoryDAO.get(1);
		category.setName("TV");
		assertEquals("Successfully updated single Category in the table", true,categoryDAO.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory(){
		category=categoryDAO.get(1);
		assertEquals("Successfully deleted single Category from the table", true,categoryDAO.delete(category));
	}*/
	
	@Test	
	public void testListCategory(){
		assertEquals("Successfully fetched list of Categories from the table", 2,categoryDAO.list().size());
	}
}
