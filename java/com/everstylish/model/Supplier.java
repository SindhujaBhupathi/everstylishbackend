package com.everstylish.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Supplier {
	@Id
    int supId;
     
    String supName,supDesc;
 
    public void setSupId(int supId) {
        this.supId = supId;
    }
 
    
    
    public int getSupId() {
        return supId;
    }
 
    
    public String getSupName() {
        return supName;
    }
 
    public void setSupName(String supName) {
        this.supName = supName;
    }
 
    public String getSupDesc() {
        return supDesc;
    }
 
    public void setSupDesc(String supDesc) {
        this.supDesc = supDesc;
    }

	
     
}

