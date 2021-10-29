package Dao.Impliment;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import Dao.Interface.IPhieuDichVu;
import Entity.PhieuDichVu;
import Utilities.HibernateUtil;

public class PhieuDichVuDao implements IPhieuDichVu {
	private OgmSessionFactory sessionFactory;

	public PhieuDichVuDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	@Override
	public PhieuDichVu get(int id) throws Exception {
		if (id <= 0)
			throw new Exception("id < 0 is not allow");

		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();

		try {
			PhieuDichVu temp = session.find(PhieuDichVu.class, id);

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
	public List<PhieuDichVu> getAll() {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		String query = "db.phieudichvus.find({})";
		try {
			List<PhieuDichVu> list = session.createNativeQuery(query, PhieuDichVu.class).getResultList();
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
	public boolean add(PhieuDichVu addObject) {
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
	public boolean update(PhieuDichVu updateObject) {
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
	public boolean delete(int deleteObjectId) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		PhieuDichVu deleteObj = new PhieuDichVu();
		deleteObj.setMaPDV(deleteObjectId);
		try {
			session.delete(deleteObj);

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

}
