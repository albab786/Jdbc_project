package com.jsp.jdbc_project_architecture_crud.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6678117736236411656L;
	
	private int id;
	private String name;
	private String email;
	private String address;
	private LocalDate dob;
	
	//alt+s+a
	public User() {
		super();
	}
	
	public User(int id, String name, String email, String address, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.dob = dob;
	}



	//alt+s+r
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	
	//alt+shift+s+h  to generate equals and hascode method
	
	
	@Override
	public int hashCode() {
		return Objects.hash(address, dob, email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(address, other.address) && Objects.equals(dob, other.dob)
				&& Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name);
	}

	//alt+shift+s+s
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", dob=" + dob + "]";
	}
	
	
	
}
