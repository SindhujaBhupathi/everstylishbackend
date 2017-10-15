package com.everstylish.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.everstylish.model.Product;

import com.everstylish.dao.ProductDAO;
@Repository("productDao")
	public class ProductDAOImpl implements ProductDAO
	{
		@Autowired
	    SessionFactory sessionFactory;

		 @Transactional
		public boolean addProduct(Product product) {
			// TODO Auto-generated method stub
			 try
		      {
		      sessionFactory.getCurrentSession().save(product);
		      return true;
		      }
		      catch(Exception e)
		      {
		      return false;
		      }
		      
		}
        public List<Product> retrieveProducts() {
			// TODO Auto-generated method stub
        	Session session=sessionFactory.openSession();
        	@SuppressWarnings("rawtypes")
			Query query = session.createQuery("from Product");
        	@SuppressWarnings("unchecked")
			List<Product> listProducts = query.list();
        	session.close();
			return listProducts;
		}

		public boolean deleteProduct(Product product) {
			// TODO Auto-generated method stub
			 try
		     {
		     sessionFactory.getCurrentSession().delete(product);
		     return true;
		     }
		     catch(Exception e)
		     {
		     System.out.println("Exception Arised:"+e);  
			return false;
		     }
		}

		public Product getProduct(int productId) {
			// TODO Auto-generated method stub
			 Session session=sessionFactory.openSession();
			 Product product=(Product)session.get(Product.class,productId);
		     session.close();
		     return product;
			
		}

		public boolean updateProduct(Product product) {
			// TODO Auto-generated method stub
			try
		     {
		     sessionFactory.getCurrentSession().saveOrUpdate(product);
		     return true;
		     }
		     catch(Exception e)
		     {
		     System.out.println("Exception Arised:"+e);
		     return false;
			
		}
		
		
		}
		
}
