package com.everstylish.dao;


	import java.util.List;

	import javax.transaction.Transactional;

	import org.hibernate.Criteria;
	import org.hibernate.Query;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

	import com.everstylish.model.Category;

	@SuppressWarnings("deprecation")
	@Repository
	public class CategoryDAOImpl implements CategoryDAO {
		
		@Autowired
		SessionFactory sessionFactory;
		
		public CategoryDAOImpl(SessionFactory sessionFactory) {
			
			this.sessionFactory = sessionFactory;
		}




		
		@Transactional
		public boolean saveCategory(Category category) {
			
			 sessionFactory.getCurrentSession().saveOrUpdate(category);
			
			
			
			 return true;
		}



		@Transactional
		public List<Category> list() {
			@SuppressWarnings("unchecked")
			List<Category> listCategory = (List<Category>) sessionFactory.getCurrentSession()
					.createCriteria(Category.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

			return listCategory;
		}




		@Transactional
		public Category getCategoryById(int category_id) {
			String hql = "from"+" Category"+" where id=" + category_id;
			@SuppressWarnings("rawtypes")
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<Category> listCategory = (List<Category>) query.list();
			
			if (listCategory != null && !listCategory.isEmpty()) {
				return listCategory.get(0);
			}
			
			return null;
		}



		@Transactional
		public Category removeCategoryById(int category_id) {
			Category CategoryToDelete = new Category();
			CategoryToDelete.setCatId(category_id);
			sessionFactory.getCurrentSession().delete(CategoryToDelete);
			return CategoryToDelete;
		}





		public boolean addCategory(Category category) {
			// TODO Auto-generated method stub
			return false;
		}





		public List<Category> retrieveCategory() {
			// TODO Auto-generated method stub
			return null;
		}





		public boolean deleteCategory(Category category) {
			// TODO Auto-generated method stub
			return false;
		}





		public Category getCategory(int catId) {
			// TODO Auto-generated method stub
			return null;
		}





		public boolean updateCategory(Category category) {
			// TODO Auto-generated method stub
			return false;
		}
		

	}
	
	
