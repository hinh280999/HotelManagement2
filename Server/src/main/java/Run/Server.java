package Run;

import org.hibernate.HibernateException;
import org.hibernate.ogm.OgmSessionFactory;

import Utilities.HibernateUtil;

public class Server {

	public static void main(String[] args) {
		try {
			OgmSessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
		} catch (HibernateException exception){
		     System.out.println("Problem creating session factory");
		     exception.printStackTrace();
		}

	}

}
