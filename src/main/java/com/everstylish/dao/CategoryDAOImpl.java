package com.everstylish.dao;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.everstylish.model.Category;

@SuppressWarnings("deprecation")
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	
	}
	
/*	@Transactional
	public boolean addCategory(Category category) {
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
		return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		return false;
		}
	}*/
@Transactional
public boolean addCategory(Category category) {
	
	 try
        {
		 
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
        
        return true;
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        return false;
        }

}
	
	@Transactional
	public List<Category> retrieveCategory1() {
		Session session=sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query=session.createQuery("from Category");
		@SuppressWarnings("unchecked")
		List<Category> listCategory=((org.hibernate.query.Query) query).list();
		session.close();
		return listCategory;
	}
	
	@Transactional
	public List<Category> retrieveCategory() {
		// TODO Auto-generated method stub
		 Session session=sessionFactory.openSession();
	        @SuppressWarnings("rawtypes")
			Query query=session.createQuery("from Category");
	        @SuppressWarnings("unchecked")
			List<Category> listCategory=((org.hibernate.query.Query) query).list();
	        session.close();
	        return listCategory;
		
	}
	@Transactional
	public boolean deleteCategory(int catId) {
		Session session = sessionFactory.getCurrentSession();
		Object peristanceInstance = session.load(Category.class, catId);
		
		if(peristanceInstance != null){
			session.delete(peristanceInstance);
			System.out.println("Category deleted successfully");
		}
		
		return true;
	}
	
	@Transactional
	public Category getCategory(int catId) {
		// TODO Auto-generated method stub
		String hql = "from"+" Category"+" where id=" + catId;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) ((org.hibernate.query.Query) query).list();
		
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		
		return null;
	
	}
	
	@Transactional
	public boolean updateCategory(int catId){
		{
			try
			{
			sessionFactory.getCurrentSession().saveOrUpdate(catId);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception Arised:"+e);
			return false;
			}
		}
	}

	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	/*public Category deleteCategory(int catId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	/*public Category deleteCategory(int catId) {
		// TODO Auto-generated method stub
		return null;*/
	

	/*public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	public Category deleteCategory(int catId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*public Category deleteCategory(int catId) {
		// TODO Auto-generated method stub
		return null;*/
	}
	
