package TestRun;

import Dao.Impliment.DichVuDao;
import Dao.Interface.IDichVuDao;
import Entity.DichVu;

public class DichVuDaoTest {
	public static void main(String[] args) {
		IDichVuDao Dao = new DichVuDao();

		DichVu tDichVu = new DichVu("Coca-cola", 10000.0);

		if (Dao.add(tDichVu)) {
			System.out.println("Add DV Complete");
		} else {
			System.out.println("Add DV Fail");
		}

		DichVu dvInfo = null;
		try {
			dvInfo = Dao.get(tDichVu.getMaDv());
			System.out.println(dvInfo.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		dvInfo.setTenDv("Pepsi");
		if (Dao.update(dvInfo)) {
			System.out.println("update DV Complete");
		} else {
			System.out.println("update DV Fail");
		}

		if (Dao.delete(dvInfo.getMaDv())) {
			System.out.println("delete DV Complete");
		} else {
			System.out.println("delete DV Fail");
		}

	}
}
