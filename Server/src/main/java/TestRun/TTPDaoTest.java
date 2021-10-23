package TestRun;

import Dao.Impliment.TinhTrangPhongDao;
import Dao.Interface.ITinhTrangPhongDao;
import Entity.TinhTrangPhong;

public class TTPDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ITinhTrangPhongDao Dao  = new TinhTrangPhongDao();
		
		TinhTrangPhong tTTP = new TinhTrangPhong("Trống");
		
		if (Dao.add(tTTP)) {
			System.out.println("Add Complete");
		} else {
			System.out.println("Add fail");
		}
		
		TinhTrangPhong ttpInfo = null;
		try {
			ttpInfo = Dao.get(tTTP.getMaTTP());
			System.out.println("TTP get : " +ttpInfo.getTenTTP());
		} catch (Exception e) {
			e.printStackTrace();
		}

		ttpInfo.setTenTTP("Pepsi");
		if (Dao.update(ttpInfo)) {
			System.out.println("update Complete");
		} else {
			System.out.println("update Fail");
		}

		if (Dao.delete(ttpInfo)) {
			System.out.println("delete Complete");
		} else {
			System.out.println("delete Fail");
		}
	}

}
