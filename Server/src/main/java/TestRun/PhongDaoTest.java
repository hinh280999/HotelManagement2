package TestRun;

import Dao.Impliment.LoaiPhongDao;
import Dao.Impliment.PhongDao;
import Dao.Impliment.TinhTrangPhongDao;
import Dao.Interface.ILoaiPhongDao;
import Dao.Interface.IPhongDao;
import Dao.Interface.ITinhTrangPhongDao;
import Entity.LoaiPhong;
import Entity.Phong;
import Entity.TinhTrangPhong;

public class PhongDaoTest {

	public static void main(String[] args) {
		IPhongDao Dao = new PhongDao();

//		ITinhTrangPhongDao DaoTTP = new TinhTrangPhongDao();
//		TinhTrangPhong tTTP = new TinhTrangPhong("Đã thuê");
//		DaoTTP.add(tTTP);
//
//		ILoaiPhongDao LPDao = new LoaiPhongDao();
//		LoaiPhong newLP = new LoaiPhong("Vip2", 100000.0);
//		LPDao.add(newLP);
//
//		Phong tPhong = new Phong("P2803");
//		tPhong.setMaTTP(tTTP);
//		tPhong.setMaLP(newLP);
//
//		if (Dao.add(tPhong)) {
//			System.out.println("Add Phong Complete");
//		} else {
//			System.out.println("Add Phong Fail");
//		}

//		Phong pInfo = null;
//		try {
//			pInfo = Dao.get(tPhong.getMaP());
//			System.out.println(pInfo.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		pInfo.setTen("Pepsi");
//		if (Dao.update(pInfo)) {
//			System.out.println("update Phong Complete");
//		} else {
//			System.out.println("update Phong Fail");
//		}
//
//		if (Dao.delete(pInfo.getMaP())) {
//			System.out.println("delete Phong Complete");
//		} else {
//			System.out.println("delete Phong Fail");
//		}
//		
//		DaoTTP.delete(tTTP.getMaTTP());
//		LPDao.delete(newLP.getMaLP());

//		Phong phongtrong = Dao.getPhongTrongByLoaiPhongId(11);
//		System.out.println(phongtrong.toString());
	}

}
