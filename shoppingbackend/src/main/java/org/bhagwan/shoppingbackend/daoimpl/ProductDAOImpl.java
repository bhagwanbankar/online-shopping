package org.bhagwan.shoppingbackend.daoimpl;

import java.util.List;

import org.bhagwan.shoppingbackend.dao.ProductDAO;
import org.bhagwan.shoppingbackend.dto.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * (non-Javadoc)
	 * @see org.bhagwan.shoppingbackend.dao.ProductDAO#get(int)
	 * get Single product from product id
	 */
	@Override
	public Product get(int productId) {
		try{
			return sessionFactory.getCurrentSession().get(Product.class,Integer.valueOf(productId));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.bhagwan.shoppingbackend.dao.ProductDAO#list()
	 * List of products
	 */
	@Override
	public List<Product> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Product",Product.class).getResultList();
	}

	@Override
	public boolean add(Product product) {
		try{
			sessionFactory.getCurrentSession().persist(product);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(Product product) {
		try{
			sessionFactory.getCurrentSession().update(product);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(Product product) {

		try{
			product.setActive(false);
			this.update(product);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {

		String selectActiveProducts="FROM Product WHERE active= :active";
		
		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts,Product.class).setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductByCategory(int categoryId) {
		
		String selectActiveProductsByCategory="FROM Product WHERE categoryId=:categoryId AND active= :active";
		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProductsByCategory,Product.class)
					.setParameter("categoryId",categoryId).setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product WHERE active=:active ORDER BY id",Product.class)
					.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
	}

}
