package com.sap.ward.web;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;

public class EmployeeServiceFactory extends ODataJPAServiceFactory
{
	private static final String PERSISTENCE_UNIT_NAME = "Employee.Service";

	@Override
	public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException
	{
		ODataJPAContext oDataJPAContext = this.getODataJPAContext();
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			oDataJPAContext.setEntityManagerFactory(emf);
			oDataJPAContext.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
			return oDataJPAContext;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
