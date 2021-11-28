package TestRun;

import Dao.Impliment.TinhTrangPhongDao;
import Dao.Interface.ITinhTrangPhongDao;
import Entity.TinhTrangPhong;

public class AfterDeleteDatabaseRun {

	public static void main(String[] args) {
		ITinhTrangPhongDao ttpDao = new TinhTrangPhongDao();

		TinhTrangPhong tTTP = new TinhTrangPhong("Trống");
		TinhTrangPhong tTTP2 = new TinhTrangPhong("Đã Thuê");

		ttpDao.add(tTTP);
		ttpDao.add(tTTP2);

	}

}
