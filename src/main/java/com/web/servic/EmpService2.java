package com.web.servic;

import java.util.List;

import com.web.entities.Employee;

public interface EmpService2 
{
	  public Employee saveEmployeeData(Employee employee);
	  public Employee updateEmployee(Employee employee,Integer empid);
	  public void deleteEmployee(Integer empid);
	  public Employee getEmployee(Integer empid);
	  public List<Employee> getAllEmployee();

}
