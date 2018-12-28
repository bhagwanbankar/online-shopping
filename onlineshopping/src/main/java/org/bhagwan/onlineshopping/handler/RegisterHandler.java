package org.bhagwan.onlineshopping.handler;

import org.bhagwan.onlineshopping.model.RegisterModel;
import org.bhagwan.shoppingbackend.dao.UserDAO;
import org.bhagwan.shoppingbackend.dto.Address;
import org.bhagwan.shoppingbackend.dto.Cart;
import org.bhagwan.shoppingbackend.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler {
	
	@Autowired
	UserDAO userDAO;
	public RegisterModel init(){
		
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user){
		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address address){
		registerModel.setBilling(address);
	}
	
	public String saveAll(RegisterModel registerModel){
		String transitionValue="success";
		//fetch User
		User user= registerModel.getUser();
		if(user.getRole().equals("USER")){
			Cart cart= new Cart();
			cart.setUser(user);
			user.setCart(cart);
			
		}
		
		//save User
		userDAO.addUser(user);
		//get Address
		Address billing= registerModel.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		userDAO.addAddress(billing);
		
		return transitionValue;
	}
	
	public String validateUser(User user, MessageContext error){
		String transitionvalue="success";
		//checking password matching confirm password
		if(!(user.getPassword().equals(user.getConfirmPassword()))){
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Password Does Not mathc with confirm Password")
					.build());	
			transitionvalue="failure";
		}
		
		//check uniqueness of email
		if(userDAO.getUserByEmail(user.getEmail())!=null){
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("Email Address Already Exists")
					.build());	
			transitionvalue="failure";
		}
		
		return transitionvalue;
	}

}
