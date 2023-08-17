package com.web.servic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entities.Employee;
import com.web.repo.EmpRepo;

@Service
public class EmpServiceImpl2 implements EmpService2
{
	@Autowired
	private EmpRepo eRepo;

	@Override
	public Employee saveEmployeeData(Employee employee) {
		
		Employee e2=new Employee();
		
		int empid=employee.getEmpid();
		String empName=employee.getEmpname();
		double empSal=employee.getEmpsal();
		double ta=employee.getTa();
		double da=employee.getDa();
		double hra=employee.getHra();
		double pf=employee.getPf();
		double grassSal=employee.getGrassSal();
		double netSal=employee.getNetSal();
		
		if(empSal>=50000)
		{
		 ta=empSal*0.17;        
		 hra=empSal*0.21;       
		 da=empSal*0.19;         
		 pf=empSal*0.25;     
		}
		else if(empSal>=30000 && empSal<50000)
		{
		 ta=empSal*0.12;        
		 hra=empSal*0.17;       
		 da=empSal*0.13;         
		 pf=empSal*0.22;     
		}
		else if(empSal<30000)
		{
		 ta=empSal*0.07;        
		 hra=empSal*0.11;       
		 da=empSal*0.09;         
		 pf=empSal*0.15;     
		 }
		
		grassSal=empSal+ta+hra+da;
		netSal=grassSal-pf;
		
		e2.setEmpid(empid);
		e2.setEmpname(empName);
		e2.setEmpsal(empSal);
		e2.setDa(da);
		e2.setTa(ta);
		e2.setHra(hra);
		e2.setPf(pf);
		e2.setGrassSal(grassSal);
		e2.setNetSal(netSal);
		
		return eRepo.save(e2);
		
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer empid) {
		Optional<Employee> optional=eRepo.findById(empid);
		
		Employee e2=optional.get();
		
		e2.setEmpid(empid);
		e2.setEmpname(employee.getEmpname());
		e2.setEmpsal(employee.getEmpsal());
		double empSal=employee.getEmpsal();
		double ta=0.0,da=0.0,hra=0.0,pf=0.0;
		if(empSal>=50000)
		{
		 ta=empSal*0.17;        
		 hra=empSal*0.21;       
		 da=empSal*0.19;         
		 pf=empSal*0.25;     
		}
		else if(empSal>=30000 && empSal<50000)
		{
		 ta=empSal*0.12;        
		 hra=empSal*0.17;       
		 da=empSal*0.13;         
		 pf=empSal*0.22;     
		}
		else if(empSal<30000)
		{
		 ta=empSal*0.07;        
		 hra=empSal*0.11;       
		 da=empSal*0.09;         
		 pf=empSal*0.15;     
		 }
		
		double netsalary=(employee.getEmpsal()+ta+hra)-pf;  
		double grassSal=employee.getEmpsal()+ta+hra+da;
		e2.setPf(pf);
		e2.setHra(hra);
		e2.setTa(ta);
		e2.setDa(da);
		e2.setNetSal(netsalary);
		e2.setGrassSal(grassSal);
		
		
		 return eRepo.save(e2);
		
		
	}

	@Override
	public void deleteEmployee(Integer empid) {
		eRepo.deleteById(empid);
		
	}

	@Override
	public Employee getEmployee(Integer empid) {
		return eRepo.findById(empid).get();
	
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return eRepo.findAll();
	}

	
}
