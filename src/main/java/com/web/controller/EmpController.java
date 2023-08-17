package com.web.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.entities.Employee;
import com.web.servic.EmpService2;

@RestController
public class EmpController 
{
	@Autowired
	private EmpService2 empService;
	
	@PostMapping("/save")
	public Employee SaveEmployee(@RequestBody Employee employee)
	{
		return empService.saveEmployeeData(employee);
		
		
	}
	
	@PutMapping("/update/{empid}")
	public Employee updateEmpData(@RequestBody Employee employee,@PathVariable int empid)
	{
		return empService.updateEmployee(employee, empid);
	}
	
	@GetMapping("/get/{empid}")
	public Employee getOneEmployee(@PathVariable int empid)
	{
		return empService.getEmployee(empid);
	}
	
	@GetMapping("/getall")
	public List<Employee> getAllEmployee()
	{
		return empService.getAllEmployee();
	}
}
