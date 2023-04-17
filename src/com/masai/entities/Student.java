package com.masai.entities;

import java.io.Serializable;

public class Student extends User implements Serializable {
	
	String courseName;
	String batchName;
	
	public Student() {
		
	}

	public Student( String username, String password, String address, String email) {
		super(username, password, address, email);
		
	}
  
	int count=0;
	
	public int getid() {
		return count++;
	}
	
	

	public String getCourseName() {
		return courseName;
	}




	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}




	public String getBatchName() {
		return batchName;
	}




	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}




	@Override
	public String toString() {
		return "Student [" + " Username=" + getUsername() + ",  Address=" + getAddress() + ",  Email=" + getEmail()
				+ ",  Password=" + getPassword() + ",  Course=" + getCourseName() + ",  Batch=" + getBatchName() + " ]";
	}


}
