package org.bhagwan.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.bhagwan.shoppingbackend.dao.UserDAO;
import org.bhagwan.shoppingbackend.dto.Address;
import org.bhagwan.shoppingbackend.dto.Cart;
import org.bhagwan.shoppingbackend.dto.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user=null;
	private Cart cart=null;
	private Address address=null;
	
	@BeforeClass
	public static void init(){
		context= new AnnotationConfigApplicationContext();
		context.scan("org.bhagwan.shoppingbackend");
		context.refresh();
		userDAO= (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void getAddress(){
		
		user= userDAO.getUserByEmail("bhagwan@gmail.com");
		assertEquals("Failed to get shipping address", 2,userDAO.listshippingAddress(user).size());
		
		assertEquals("Failed to get shipping address", "Mumbai",userDAO.getBillingAddress(user).getCity());
	}
	
	/*@Test
	public void addAddress(){
		
		user= userDAO.getUserByEmail("bhagwan@gmail.com");
		//add shipping address
		address= new Address();
		address.setAddressLineOne("S Address Line 1");
		address.setAddressLineTwo("S Address Line2");
		address.setCity("S Bangalore");
		address.setState("S Karnataka");
		address.setCountry("S India");
		address.setPostalCode("S 4000028");
		address.setShipping(true);
		address.setUser(user);
		assertEquals("failed to add Shipping Address",true,userDAO.addAddress(address));
	}
*/	
	/*@Test
	public void updateAddress(){
		//add user
		user = new User();
		user.setFirstName("Bhagwan");
		user.setLastName("Bankar");
		user.setEmail("bhagwan@gmail.com");
		user.setContactNumber("7709442960");
		user.setRole("USER");
		user.setPassword("12345");
		
		//add user
		assertEquals("failed to add user",true,userDAO.addUser(user));
		
		address= new Address();
		address.setAddressLineOne("Address Line 1");
		address.setAddressLineTwo("Address Line2");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("4000028");
		address.setBilling(true);
		//attach user to address
		
		address.setUser(user);
		assertEquals("failed to add Address",true,userDAO.addAddress(address));
		
		//add shipping address
		address= new Address();
		address.setAddressLineOne("S Address Line 1");
		address.setAddressLineTwo("S Address Line2");
		address.setCity("S Mumbai");
		address.setState("S Maharashtra");
		address.setCountry("S India");
		address.setPostalCode("S 4000028");
		address.setShipping(true);
		address.setUser(user);
		assertEquals("failed to add Shipping Address",true,userDAO.addAddress(address));
		
	}*/
	
	/*@Test
	public void testUpdateCart(){
		user = userDAO.getUserByEmail("bhagwan@gmail.com");
		cart=user.getCart();
		cart.setGrandTotal(12324.324);
		cart.setCartLines(2);
		
		if(user.getRole().equals("USER")){
			//create cart for this user
			
			//add cart
			assertEquals("Failed to update Cart",true, userDAO.updateCart(cart));
			
		}
		
	}*/
	
	/*
	 @Test
	public void testAdd(){
		user = new User();
		user.setFirstName("Bhagwan");
		user.setLastName("Bankar");
		user.setEmail("bhagwan@gmail.com");
		user.setContactNumber("7709442960");
		user.setRole("USER");
		user.setPassword("12345");
		
		if(user.getRole().equals("USER")){
			//create cart for this user
			
			cart= new Cart();
			cart.setUser(user);
			//attach cart with user
			user.setCart(cart);
			//add cart
			assertEquals("Failed to add in User",true, userDAO.addUser(user));
			
		}
		
	}
	 
	 */
	
	/*
	 
	 
	 @Test
	public void testAdd(){
		user = new User();
		user.setFirstName("Bhagwan");
		user.setLastName("Bankar");
		user.setEmail("bhagwan@gmail.com");
		user.setContactNumber("7709442960");
		user.setRole("USER");
		user.setPassword("12345");
		
		//add user
		assertEquals("failed to add user",true,userDAO.addUser(user));
		
		address= new Address();
		address.setAddressLineOne("Address Line 1");
		address.setAddressLineTwo("Address Line2");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("4000028");
		address.setBilling(true);
		
		address.setUserId(user.getId());
		//add Address
		assertEquals("failed to add address",true,userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")){
			//create cart for this user
			
			cart= new Cart();
			cart.setUser(user);
			//add cart
			assertEquals("Failed to add in Cart",true, userDAO.addCart(cart));
			
			
			//shipping address
			address= new Address();
			address.setAddressLineOne("S Address Line 1");
			address.setAddressLineTwo("S Address Line2");
			address.setCity("S Mumbai");
			address.setState("S Maharashtra");
			address.setCountry("S India");
			address.setPostalCode("S 4000028");
			address.setShipping(true);
			//link it with user
			
			address.setUserId(user.getId());
			
			assertEquals("Failed to add shipping aaddress",true, userDAO.addAddress(address));
			
			
		}
		
	}
	 
	 */
	
}
