package com.sap.ward.model.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sap.ward.model.Employee;

/**
 * Create test data in mysql database, for test Apache olingo odata server
 * 
 * @author I327500
 *
 */
public class CreateSourceData
{
	public static void main(String[] args)
	{
		// Set Singleton emf for name of EmployeeService
		// Utility.setEntityFactory(Persistence.createEntityManagerFactory("EmployeeService"));
		// EntityManagerFactory emf = Utility.getEntityFactory();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employee.Service");

		EntityManager em = emf.createEntityManager();
		EmployeeService service = new EmployeeService(em);

		for (int i = 0; i < 20; i++) {
			em.getTransaction().begin();
			Employee empWard = service.createEmployee(327500 + i, "Ward" + i, 7500 + i);
			em.getTransaction().commit();
			System.out.println("Create Employee Service: " + empWard.getId());
		}
		// create and persist an employee

		em.close();
		emf.close();
	}
}
