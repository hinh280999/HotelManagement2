package Utilities;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.ogm.boot.OgmSessionFactoryBuilder;
import org.hibernate.ogm.cfg.OgmConfiguration;
import org.hibernate.ogm.cfg.OgmProperties;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static HibernateUtil instance = null;
	private OgmSessionFactory sessionFactory;

	private HibernateUtil() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySetting(OgmProperties.ENABLED, true)
				.configure().build();

		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

		sessionFactory = metadata.getSessionFactoryBuilder().unwrap(OgmSessionFactoryBuilder.class).build();

	}

	public synchronized static HibernateUtil getInstance() {
		if (instance == null)
			instance = new HibernateUtil();
		return instance;
	}

	public OgmSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void close() {
		sessionFactory.close();
	}
}
