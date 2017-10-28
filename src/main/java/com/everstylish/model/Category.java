package com.everstylish.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Category 
{
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	int catId;
	String catName,catDesc;

	public void setCatId(int catId) {
		this.catId = catId;
	}

	
	public int getCatId() {
		return catId;
	}


	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	}
	