package TestRun;

import Dao.Impliment.LoaiPhongDao;
import Dao.Interface.ILoaiPhongDao;
import Entity.LoaiPhong;

public class LoaiPhongTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ILoaiPhongDao Dao = new LoaiPhongDao();
		
		LoaiPhong newLP = new LoaiPhong("Standard",100000.0);
		
		if (Dao.add(newLP)) {
			System.out.println("Add Complete");
		} else {
			System.out.println("Add fail");
		}
		
		LoaiPhong lpInfo = null;
		try {
			lpInfo = Dao.get(newLP.getMaLP());
			System.out.println("Lp get Name : " +lpInfo.getTenLP());
		} catch (Exception e) {
			e.printStackTrace();
		}

		lpInfo.setTenLP("Pepsi");
		if (Dao.update(lpInfo)) {
			System.out.println("update Complete");
		} else {
			System.out.println("update Fail");
		}

		if (Dao.delete(lpInfo)) {
			System.out.println("delete Complete");
		} else {
			System.out.println("delete Fail");
		}
	}

}
