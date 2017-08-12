package org.bhagwan.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.bhagwan.shoppingbackend.dao.CategoryDAO;
import org.bhagwan.shoppingbackend.dto.Category;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> list() {
		
		String selectActiveCategory="FROM Category WHERE isActive=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active",true);
		return query.getResultList();
	}
	/*
	 * (non-Javadoc)
	 * @see org.bhagwan.shoppingbackend.dao.CategoryDAO#get(int)
	 * To get single category from category id
	 */
	@Override
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
	@Override
	public boolean add(Category category) {

		try{
			sessionFactory.getCurrentSession().persist(category);
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	/*
	 * (non-Javadoc)
	 * @see org.bhagwan.shoppingbackend.dao.CategoryDAO#update(org.bhagwan.shoppingbackend.dto.Category)
	 * Method for update category
	 */
	@Override
	public boolean update(Category category) {
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/*
	 * (non-Javadoc)
	 * @see org.bhagwan.shoppingbackend.dao.CategoryDAO#delete(org.bhagwan.shoppingbackend.dto.Category)
	 * delete category from table
	 */
	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
