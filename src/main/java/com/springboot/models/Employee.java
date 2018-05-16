package com.springboot.models;

public class Employee {
	private int emp_id;
	private String name;
	private String position;
	private String businessUnit;
	private float hourlyRate;
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public float getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	@Override
    public String toString() {
		return "Employee {" + "employeeID=" + emp_id + ", fname=" + name + ", position=" + position + ", businessUnit=" + businessUnit + ", hourlyRate=" + hourlyRate + '}';
    }
}
