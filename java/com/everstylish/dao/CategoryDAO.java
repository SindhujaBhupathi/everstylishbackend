package com.everstylish.dao;
 
import java.util.List;

import com.everstylish.model.Category;


 
public interface CategoryDAO 
{
	 public boolean saveCategory(Category category);
	  public boolean getCategory(int id);
	  public boolean updateCategory(Category category);
	  public boolean deleteCategory(int id);
   
}