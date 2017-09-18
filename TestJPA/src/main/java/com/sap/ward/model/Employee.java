package com.sap.ward.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@NamedQueries({ @NamedQuery(name = "Employee.getAllEmployees", query = "SELECT e FROM Employee e"), })
public class Employee
{
	@Id
	private int id;
	private String name;
	private long salary;

	public Employee()
	{
	}

	public Employee(int iId)
	{
		this.id = iId;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int iId)
	{
		this.id = iId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String sName)
	{
		this.name = sName;
	}

	public long getSalary()
	{
		return salary;
	}

	public void setSalary(long lSalary)
	{
		this.salary = lSalary;
	}
}
