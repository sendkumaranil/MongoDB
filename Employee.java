package com.mongodb.example;

public class Employee {

	private int empid;
	private String empname;
	private Address empaddress;
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Address getEmpaddress() {
		return empaddress;
	}
	public void setEmpaddress(Address empaddress) {
		this.empaddress = empaddress;
	}	
}
