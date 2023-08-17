package com.web.entities;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee_data")
public class Employee 
{
	@Id
	private int empid;
	private String empname;
	private double empsal;
	private double da;
	private double ta;
	private double hra;
	private double pf;
	private double grassSal;
	private double netSal;
}
