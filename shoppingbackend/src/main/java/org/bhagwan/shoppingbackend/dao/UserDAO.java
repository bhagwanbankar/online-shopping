package org.bhagwan.shoppingbackend.dao;

import java.util.List;

import org.bhagwan.shoppingbackend.dto.Address;
import org.bhagwan.shoppingbackend.dto.Cart;
import org.bhagwan.shoppingbackend.dto.User;

public interface UserDAO {

	boolean addUser(User user);
	boolean addAddress(Address address);
	boolean updateCart(Cart cart);
	
	User getUserByEmail(String email);
	//Alternative
	//Address getBillingAddress(int userId);
	//List<Address> listshippingAddress(int userId);

	
	Address getBillingAddress(User user);
	List<Address> listshippingAddress(User user);
	
}
