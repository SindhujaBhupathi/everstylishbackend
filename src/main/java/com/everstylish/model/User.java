package com.everstylish.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Entity
@Component
public class User implements Serializable
{
public static final long serialVersionUID=1L;


@Id
@GeneratedValue
private int id;

@NotNull(message="please enter the username")
@Size(min=5,max=10)
private String username;

@NotNull(message="please enter the email")
@Email
private String email;

@NotNull(message="please enter the password")
@Size(min = 6, max = 15)
private String password;

@NotNull(message="please enter the contact")
@Pattern(regexp="(^$|[0-9]{10})")
private String contact;

@NotNull(message="please enter the address")
@Size(min=10, max=30)
private String address;

private String role;
private boolean enabled;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}




}
