package Dao.Impliment;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import Dao.Interface.INhanVien;
import Entity.NhanVien;
import Utilities.HibernateUtil;

public class NhanVienDao implements INhanVien{
	private OgmSessionFactory sessionFactory;

	public NhanVienDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	@Override
	public NhanVien get(int id) throws Exception {
		if (id <= 0)
			throw new Exception("id < 0 is not allow");

		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();

		try {
			NhanVien temp = session.find(NhanVien.class, id);

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
	public List<NhanVien> getAll() {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		String query = "db.nhanviens.find({})";
		try {
			List<NhanVien> list = session.createNativeQuery(query, NhanVien.class)
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
	public boolean add(NhanVien addObject) {
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
	public boolean update(NhanVien updateObject) {
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
	public boolean delete(NhanVien deleteObject) {
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

}
