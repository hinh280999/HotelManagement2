package Dao.Impliment;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import Dao.Interface.IPhieuThue;
import Entity.PhieuThue;
import Entity.Phong;
import Entity.TinhTrangPhong;
import Utilities.HibernateUtil;

public class PhieuThueDao implements IPhieuThue {
	private OgmSessionFactory sessionFactory;

	public PhieuThueDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	@Override
	public PhieuThue get(int id) throws Exception {
		if (id <= 0)
			throw new Exception("id < 0 is not allow");

		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();

		try {
			PhieuThue temp = session.find(PhieuThue.class, id);

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
	public List<PhieuThue> getAll() {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		String query = "db.phieuthues.find({})";
		try {
			List<PhieuThue> list = session.createNativeQuery(query, PhieuThue.class).getResultList();
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
	public boolean add(PhieuThue addObject) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		String query = "db.tinhtrangphongs.find({'tenTTP' : 'Đã Thuê'})";
		try {
			session.save(addObject);

			Phong phongThue = session.get(Phong.class, addObject.getPhong().getMaP());

			TinhTrangPhong ttp = session.createNativeQuery(query, TinhTrangPhong.class).getSingleResult();
			phongThue.setMaTTP(ttp);

			session.update(phongThue);

			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(PhieuThue updateObject) {
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
		String query = "db.tinhtrangphongs.find({'tenTTP' : 'Trống'})";
		try {
			PhieuThue temp = session.find(PhieuThue.class, deleteObjectId);

			Phong phongThue = session.get(Phong.class, temp.getPhong().getMaP());
			TinhTrangPhong ttp = session.createNativeQuery(query, TinhTrangPhong.class).getSingleResult();
			phongThue.setMaTTP(ttp);

			session.update(phongThue);

			session.delete(temp);

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
