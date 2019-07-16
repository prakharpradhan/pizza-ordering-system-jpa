package com.cg.pos.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnection {
	private static final String PERSISTENCE_UNIT_NAME = "pos";
	private static EntityManagerFactory factory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return factory;
	}

	public static void shutdown() {
		if (factory != null) {
			factory.close();
		}
	}
}