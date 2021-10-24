package Dao.Impliment;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import Dao.Interface.IDichVuDao;
import Entity.DichVu;
import Utilities.HibernateUtil;

public class DichVuDao implements IDichVuDao {
	private static final int limit = 15;
	private OgmSessionFactory sessionFactory;

	public DichVuDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	@Override
	public DichVu get(int id) throws Exception {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();

		try {
			DichVu temp = session.find(DichVu.class, id);

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
	public List<DichVu> getAll() {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			String query = "db.dichvus.find({})";
			List<DichVu> list = session.createNativeQuery(query, DichVu.class).getResultList();

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
	public boolean add(DichVu addObject) {
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
	public boolean update(DichVu updateObject) {
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
	public boolean delete(DichVu deleteObject) {
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

//	@Override
//	public List<DichVu> getListByPage(int pageNumb) {
//		OgmSession session = sessionFactory.getCurrentSession();
//		Transaction tr = session.beginTransaction();
//
//		int skip = limit * (pageNumb - 1);
//		String query = "db.dichvus.find({})";
//
//		try {
//			List<DichVu> list = session.createNativeQuery(query, DichVu.class).setFirstResult(skip)
//					.setMaxResults(limit).list();
//
//			tr.commit();
//			session.close();
//
//			return list;
//		} catch (Exception e) {
//			tr.rollback();
//			session.close();
//
//			e.printStackTrace();
//		}
//
//		return null;
//	}

}
