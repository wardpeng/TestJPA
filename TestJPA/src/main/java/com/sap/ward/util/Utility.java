package com.sap.ward.util;
/**
 * 
 * This is a Singleton Utility class that is used to Configure an
 * {@link EntityManagerFactory}.
 * <p>
 * Refer to the Documentation <i>
 * (http://docs.oracle.com/javaee/7/api/javax/persistence/EntityManagerFactory.html)
 * </i> for more information on how to configure an EntityManager.
 * <p>
 * For more information regarding the Model classes and other JPA related
 * configuration details, refer to the "META-INF/persistence.xml" file in the
 * resources folder.
 * 
 */

import javax.persistence.EntityManagerFactory;

public class Utility
{
	/**
	 * The {@link EntityManagerFactory} instance.
	 */
	private static EntityManagerFactory emf;

	/**
	 * The static method to return the {@link EntityManagerFactory} instance.
	 * 
	 * @return
	 */
	public static EntityManagerFactory getEntityFactory()
	{
		if (emf == null) {
			throw new IllegalArgumentException("EntityManagerfactory is not initialized!!!");
		} else {
			return emf;
		}
	}

	/**
	 * Setter for the {@link EntityManagerFactory}
	 * 
	 * @param emf
	 *            - The {@link EntityManagerFactory} to set.
	 */
	public static void setEntityFactory(EntityManagerFactory emf)
	{
		Utility.emf = emf;
	}
}
