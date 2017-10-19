package com.everstylish.dao;

import java.util.List;

import com.everstylish.model.User;

public interface UserDAO {
	
	
	 public boolean saveOrUpdate(User user);
	  public List<User> list();
	  public User getUserById(int user_id);
	  public void removeUserById(int user_id);
	  
	  public User get(String email);
}
