package com.everstylish.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everstylish.model.User;


@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	   public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		
	}

	public boolean saveUser(User user) {
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(user);
		Transaction tx=session.beginTransaction();
		tx.commit();
		
		
		return true;
		
	}

	public User get(String email) {
		@SuppressWarnings("deprecation")
		Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("email", email));

		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) c.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		} else {
			return null;
		}
	}

	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserById(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeUserById(int user_id) {
		// TODO Auto-generated method stub
		
	}

		
}