package com.test;

public class Employee implements Cloneable{
	
	private int empId;
	private String empName;
	private double empSalary;
	private String gender;
	private String region;
	private String currency;
	
	
	public Employee(int empId, String empName, double empSalary, String gender, String region,String currency) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.gender = gender;
		this.region = region;
		this.currency = currency;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", gender=" + gender
				+ ", region=" + region + ", currency=" + currency + "]";
	}

	@Override
	public int hashCode() {
		return 1;
	}
		
}
