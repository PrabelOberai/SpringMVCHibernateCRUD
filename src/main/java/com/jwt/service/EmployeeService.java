package com.jwt.service;

import java.util.List;

import com.jwt.model.Employee;
import com.jwt.model.Std;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer employeeId);

	public Employee getEmployee(int employeeid);

	public Employee updateEmployee(Employee employee);
	
	public void uploadEmployee(List<Employee> employee);
	
	public List<Std> getStdId();
	
}
