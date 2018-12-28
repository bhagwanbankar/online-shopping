package org.bhagwan.shoppingbackend.daoimpl;

import java.util.List;

import org.bhagwan.shoppingbackend.dao.UserDAO;
import org.bhagwan.shoppingbackend.dto.Address;
import org.bhagwan.shoppingbackend.dto.Cart;
import org.bhagwan.shoppingbackend.dto.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) {
		
		try{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean addAddress(Address address) {
		try{
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		String sQuery="From User where email = :email";
		try{
			return sessionFactory.getCurrentSession()
					.createQuery(sQuery,User.class)
					.setParameter("email", email)
					.getSingleResult();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Address getBillingAddress(User user) {
		// TODO Auto-generated method stub
		String sQuery="From Address where user=:user AND billing=:billing";
		
		try{
			return sessionFactory.getCurrentSession().createQuery(sQuery,Address.class)
					.setParameter("user", user)
					.setParameter("billing", true).getSingleResult();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Address> listshippingAddress(User user) {
		// TODO Auto-generated method stub
		String sQuery="From Address where user=:user AND shipping=:shipping";
		
		try{
			return sessionFactory.getCurrentSession().createQuery(sQuery,Address.class)
					.setParameter("user", user)
					.setParameter("shipping", true).getResultList();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
