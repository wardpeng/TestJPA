package com.sap.ward.TestJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sap.ward.model.Employee;
import com.sap.ward.model.data.EmployeeService;
import com.sap.ward.util.Utility;

public class EmployeeTest
{
	public static void main(String[] args)
	{
		// Set Singleton emf for name of EmployeeService
		Utility.setEntityFactory(Persistence.createEntityManagerFactory("Employee.Service"));
		EntityManagerFactory emf = Utility.getEntityFactory();

		EntityManager em = emf.createEntityManager();
		EmployeeService service = new EmployeeService(em);

		// // create and persist an employee
		// em.getTransaction().begin();
		// Employee empWard = service.createEmployee(327500, "Ward", 7500);
		// em.getTransaction().commit();
		// System.out.println("Create Persisted: " + empWard);
		//
		// // create and persist another employee
		// em.getTransaction().begin();
		// Employee empPeng = service.createEmployee(327501, "Peng", 7501);
		// em.getTransaction().commit();
		// System.out.println("Create Persisted: " + empPeng);

		// // find a specific employee
		// Employee empFound = service.findEmployee(327500);
		// System.out.println("Found" + empFound);

		// find all employee
		List<Employee> allEmployees = service.findAllEmployees();
		System.out.println("All employees:");
		for (Employee e : allEmployees) {
			System.out.println(e.getName());
		}

		// Update an employee
		em.getTransaction().begin();
		Employee empUpdate = service.raiseEmployeeSalary(327500, 10000);
		em.getTransaction().commit();
		System.out.println("Updated " + empUpdate.getSalary());

		// Check the update result
		System.out.println("Check " + service.findEmployee(327500).getSalary());

		// remove an employee
		/*
		 * em.getTransaction().begin(); service.removeEmployee(327501);
		 * em.getTransaction().commit();
		 * System.out.println("All employees after remove:"); for (Employee e :
		 * allEmployees) { System.out.println(e); }
		 */

		// close the EM and EMF when done
		em.close();
		emf.close();
	}

}
