package com.everstylish.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.everstylish.model.Category;

@SuppressWarnings("deprecation")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		 try
	        {
	        Session session=sessionFactory.getCurrentSession();
	        session.save(category);
	        return true;
	        }
	        catch(Exception e)
	        {
	        return false;
	        }
	
	}

	
	public List<Category> retrieveCategory() {
		// TODO Auto-generated method stub
		 Session session=sessionFactory.openSession();
	        @SuppressWarnings("rawtypes")
			Query query=session.createQuery("from Category");
	        @SuppressWarnings("unchecked")
			List<Category> listCategory=query.list();
	        session.close();
	        return listCategory;
		
	}

	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		 try
	        {
	        Session session=sessionFactory.getCurrentSession();
	        session.delete(category);
	        return true;
	        }
	        catch(Exception e)
	        {
	        System.out.println("Exception Arised:"+e);  
	        return false;
	        }
	}

	public Category getCategory(int catId) {
		// TODO Auto-generated method stub
		String hql = "from"+" Category"+" where id=" + catId;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		
		return null;
	
	}

	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveCategory(Category category) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().saveOrUpdate(category);
			
			
			
		 return true;
		
	}

	public boolean editCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}
}