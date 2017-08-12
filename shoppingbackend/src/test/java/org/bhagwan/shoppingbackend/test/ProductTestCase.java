package org.bhagwan.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.bhagwan.shoppingbackend.dao.ProductDAO;
import org.bhagwan.shoppingbackend.dto.Product;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("org.bhagwan.shoppingbackend");
		context.refresh();
		productDAO=(ProductDAO) context.getBean("productDAO");
	}
	
	/*@Test
	public void testCRUDProduct(){
		product=new Product();
		
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is description for Oppo mobile phones");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		//assertEquals("Something Went wrong while adding product", true,productDAO.add(product));
		product=productDAO.get(2);
		product.setName("Samsung Galaxy s4");
		assertEquals("Something Went wrong while updating product", true,productDAO.update(product));
		assertEquals("Something Went wrong while deleting product", true,productDAO.delete(product));
		assertEquals("Something Went wrong while adding product", 6,productDAO.list().size());
	}*/
	@Test
	public void testListActiveProduct(){
		assertEquals("Something Went wrong while getting active product", 5,productDAO.listActiveProducts().size());
	}
	@Test
	public void testListActiveProductByCategory(){
		assertEquals("Something Went wrong while getting active product", 3,productDAO.listActiveProductByCategory(3).size());
		assertEquals("Something Went wrong while getting active product", 2,productDAO.listActiveProductByCategory(1).size());
	}
	
	@Test
	public void testGetLatestActiveProducts(){
		assertEquals("Something Went wrong while getting latest active product", 3,productDAO.getLatestActiveProducts(3).size());
	}
	
}
