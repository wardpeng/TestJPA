package com.sap.ward.model.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.sap.ward.model.Employee;

public class EmployeeService
{
	protected EntityManager em;

	public EmployeeService(EntityManager em)
	{
		this.em = em;
	}

	public Employee createEmployee(int iId, String sName, long lSalary)
	{
		/*
		 * EntityManagerFactory emf =
		 * Persistence.createEntityManagerFactory("EmployeeService");
		 * EntityManager em = emf.createEntityManager();
		 */
		Employee emp = new Employee(iId);
		emp.setName(sName);
		emp.setSalary(lSalary);
		em.persist(emp);
		return emp;
	}

	public void removeEmployee(int iId)
	{
		Employee emp = findEmployee(iId);
		if (emp != null) {
			em.remove(emp);
		}
	}

	public Employee findEmployee(int iId)
	{
		return em.find(Employee.class, iId);
	}

	public Employee raiseEmployeeSalary(int iId, long lRaise)
	{
		Employee emp = em.find(Employee.class, iId);
		if (emp != null) {
			emp.setSalary(emp.getSalary() + lRaise);
		}
		return emp;
	}

	public List<Employee> findAllEmployees()
	{
		TypedQuery<Employee> query = em.createNamedQuery("Employee.getAllEmployees", Employee.class);
		return query.getResultList();
	}
}
