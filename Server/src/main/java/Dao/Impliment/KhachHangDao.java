package Dao.Impliment;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.query.NativeQuery;

import com.google.gson.Gson;

import Dao.Interface.IKhachHangDao;
import Entity.KhachHang;
import Model.PageList;
import Utilities.HibernateUtil;

public class KhachHangDao implements IKhachHangDao {
	private static final int limitRow_On_Page = 2;
	private OgmSessionFactory sessionFactory;
	Gson gs = new Gson();

	public KhachHangDao() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
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

//	@Override
//	public List<KhachHang> getListByPage(int pageNumb) {
//		OgmSession session = sessionFactory.getCurrentSession();
//		Transaction tr = session.beginTransaction();
//
//		int skip = limit * (pageNumb - 1);
//		String query = "db.khachhangs.find({})";
//
//		try {
//			List<KhachHang> list = session.createNativeQuery(query, KhachHang.class).setFirstResult(skip)
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

	public PageList<KhachHang> searchListKhachhang(String tenKh, int pageNumb) {
		OgmSession session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		String mongoAggregate = "db.khachhangs.aggregate([{ '$match': { '$text': { '$search': '" + tenKh + "' }}},"
				+ "{'$group':{'_id':null,'dsKH':{$push:'$$ROOT'},'totalCount' : { '$sum': 1 } }},"
				+ "{'$unwind':'$dsKH'}])";

		try {
			NativeQuery javaQuery = session.createNativeQuery(mongoAggregate);
			int totalRow = javaQuery.getResultList().size();
			
			List<?> khachHangs_Paged = javaQuery.setFirstResult(limitRow_On_Page * (pageNumb - 1)).setMaxResults(limitRow_On_Page)
					.getResultList();

			PageList<KhachHang> pageList = new PageList<>();
			pageList.setListData(convertToListKhachHang(khachHangs_Paged));
			pageList.setMaxPage((int) Math.ceil(totalRow / limitRow_On_Page));
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

	private List<KhachHang> convertToListKhachHang(List<?> listObject) {
		List<KhachHang> returnList = new ArrayList<KhachHang>();

		for (Object objects : listObject) {
			Object[] o = (Object[]) objects;
			Document temp = (Document) o[1];
			returnList.add(convertDocToKhachHang(temp));
		}

		return returnList;
	}

	private KhachHang convertDocToKhachHang(Document doc) {
		int maKH = doc.getInteger("_id");
		doc.remove("_id");
		doc.append("maKH", maKH);
		KhachHang returnKh = gs.fromJson(doc.toJson(), KhachHang.class);
		return returnKh;
	}

}
