package com.everstylish.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.everstylish.dao.CategoryDAO;
import com.everstylish.model.Category;

import static org.junit.Assert.assertTrue;


@Ignore
public class CategoryTest 
{
    static CategoryDAO categoryDAO;
     
    @BeforeClass
    public static void initialize()
    {
        @SuppressWarnings("resource")
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
        configApplnContext.scan("com.everstylish");
        configApplnContext.refresh();
         
        //SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DataBaseConfig.class");
         
        categoryDAO=(CategoryDAO)configApplnContext.getBean("categoryDAO");
    }
    @Ignore
    @Test
    public void addCategoryTest()
    {
        Category category=new Category();
        category.setCatId(101);
        category.setCatName("rings");
        category.setCatDesc(" worn as an ornamental piece of jewellery around the finger ");
        assertTrue(categoryDAO.addCategory(category));
    }
    @Ignore
    @Test
    public void updateCategoryTest(int catId)
	{
		Category category=new Category();
		category.setCatId(103);
		category.setCatName("rings");
		category.setCatDesc("The Indian climatic life.");
		
		assertTrue(categoryDAO.updateCategory(catId));
	}
   
    
}