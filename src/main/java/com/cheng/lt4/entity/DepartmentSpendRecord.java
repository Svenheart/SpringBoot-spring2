package com.cheng.lt4.entity;

public class DepartmentSpendRecord {
	private String department;
	private String totalprice;

	public DepartmentSpendRecord(String department, String totalprice) {
		this.department = department;
		this.totalprice = totalprice;
	}

	public DepartmentSpendRecord() {
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
}
