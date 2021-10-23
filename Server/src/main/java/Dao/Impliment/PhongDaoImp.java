package Dao.Impliment;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import Dao.Interface.PhongDao;
import Entity.Phong;
import Utilities.HibernateUtil;

public class PhongDaoImp implements PhongDao {
	private OgmSessionFactory sessionFactory;
	private static int limit = 2;

	public PhongDaoImp() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	@Override
	public Phong get(int id) throws Exception {
		if (id <= 0)
			throw new Exception("id < 0 is not allow");

		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();

		try {
			Phong temp = session.find(Phong.class, id);

			tr.commit();
			session.close();

			return temp;
		} catch (Exception e) {
			tr.rollback();
			session.close();

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Phong> getAll() {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		String query = "db.Phongs.find({})";
		try {
			List<Phong> list = session.createNativeQuery(query, Phong.class)
					.getResultList();
			tr.commit();
			session.close();

			return list;
		} catch (Exception e) {
			tr.rollback();
			session.close();

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean add(Phong addObject) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			session.save(addObject);

			tr.commit();
			session.close();

			return true;
		} catch (Exception e) {
			tr.rollback();
			session.close();

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(Phong updateObject) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			session.saveOrUpdate(updateObject);

			tr.commit();
			session.close();

			return true;
		} catch (Exception e) {
			tr.rollback();
			session.close();

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(Phong deleteObject) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			session.delete(deleteObject);

			tr.commit();
			session.close();

			return true;
		} catch (Exception e) {
			tr.rollback();
			session.close();

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Phong> getListByPage(int pageNumb) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		int skip = limit*(pageNumb-1);
		String query = "db.Phongs.find({}).skip("+skip+").limit("+limit+")";
		try {
			List<Phong> list = session.createNativeQuery(query, Phong.class)
					.getResultList();
			tr.commit();
			session.close();

			return list;
		} catch (Exception e) {
			tr.rollback();
			session.close();

			e.printStackTrace();
		}

		return null;
	}

}
