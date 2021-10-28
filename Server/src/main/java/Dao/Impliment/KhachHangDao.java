package Dao.Impliment;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.query.NativeQuery;

import com.google.gson.Gson;

import Constant.Page;
import Dao.Interface.IKhachHangDao;
import Entity.KhachHang;
import Model.PageList;
import Utilities.HibernateUtil;
import Utilities.KhachHangUtil;

public class KhachHangDao implements IKhachHangDao {
	private OgmSessionFactory sessionFactory;
	private Gson gs;

	public KhachHangDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
		gs = new Gson();
	}

	@Override
	public KhachHang get(int id) throws Exception {
		if (id <= 0)
			throw new Exception("id < 0 is not allow");

		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();

		try {
			KhachHang temp = session.find(KhachHang.class, id);

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
	public List<KhachHang> getAll() {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		try {
			String query = "db.khachhangs.find({})";
			List<KhachHang> list = session.createNativeQuery(query, KhachHang.class).getResultList();

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
	public boolean add(KhachHang addObject) {
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
	public boolean update(KhachHang updateObject) {
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
	public boolean delete(KhachHang deleteObject) {
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
	public PageList<KhachHang> searchListKhachhang(String tenKh, int pageNumb) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();

		String mongoAggregate = "db.khachhangs.aggregate([{ '$match': { '$text': { '$search': '" + tenKh + "' }}}])";

		try {
			NativeQuery javaQuery = session.createNativeQuery(mongoAggregate);
			int totalRow = javaQuery.getResultList().size();

			List<?> khachHangs_Paged = javaQuery.setFirstResult(Page.LIMITROW_ONPAGE * (pageNumb - 1))
					.setMaxResults(Page.LIMITROW_ONPAGE).getResultList();

			PageList<KhachHang> pageList = new PageList<>();
			int maxPage = (int)Math.ceil(totalRow / Page.LIMITROW_ONPAGE);
			pageList.setListData(KhachHangUtil.convertToListKhachHang(khachHangs_Paged));
			pageList.setMaxPage( maxPage == 0 ? 1 : maxPage );
			pageList.setCurrentPage(pageNumb);

			tr.commit();
			session.close();

			return pageList;
		} catch (Exception e) {
			tr.rollback();
			session.close();

			e.printStackTrace();
		}

		return null;
	}
}
