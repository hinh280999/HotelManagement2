package TestRun;

import Dao.Impliment.ChucVuDao;
import Dao.Interface.IChucVu;
import Entity.ChucVu;

public class ChucVuDaoTest {

	public static void main(String[] args) {
		IChucVu Dao = new ChucVuDao();
		
		ChucVu cv = new ChucVu("SampleChucVu",1.0);
		
		if (Dao.add(cv)) System.out.println("add success");
		else System.out.println("add fail");
		
		ChucVu temp = null;
		
		try {
			temp = Dao.get(cv.getMaCV());
			System.out.println("CV name : " + temp.getTenCV());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		temp.setTenCV("pepsi");
		if (Dao.update(temp)) System.out.println("update success");
		else System.out.println("update fail");
		
		if (Dao.delete(temp.getMaCV())) System.out.println("delete success");
		else System.out.println("delete fail");
	}

}
