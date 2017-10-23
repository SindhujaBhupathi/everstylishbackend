package com.everstylish.dao;
 
import java.util.List;

import com.everstylish.model.Category;


 
public interface CategoryDAO 
{
    public boolean addCategory(Category category);
    public List<Category> retrieveCategory();
    public boolean deleteCategory(int catId);
    public Category getCategory(int catId);
    public boolean updateCategory(int catId);
   
}