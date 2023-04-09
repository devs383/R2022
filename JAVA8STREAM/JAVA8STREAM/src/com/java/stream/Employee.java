package com.java.stream;


public class Employee {
  
	int empid;
	String empName;
	int deptId;
	String empStatus;
	int sal ;
	public Employee(int empid, String empName, int deptId, String empStatus, int sal) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.deptId = deptId;
		this.empStatus = empStatus;
		this.sal = sal;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", deptId=" + deptId + ", empStatus=" + empStatus
				+ ", sal=" + sal + "]";
	}
	
	
	
	
	
}
