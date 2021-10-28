package TestRun;

import Dao.Impliment.ChucVuDao;
import Dao.Impliment.NhanVienDao;
import Dao.Interface.IChucVu;
import Dao.Interface.INhanVien;
import Entity.ChucVu;
import Entity.NhanVien;
import Entity.TaiKhoan;

public class NhanVIenDaoTest {
	public static void main(String[] args) {
		INhanVien nvDao = new NhanVienDao();
		IChucVu cvDao = new ChucVuDao();

		ChucVu sampleCV = new ChucVu("SampleChucVu", 1.0);
		cvDao.add(sampleCV);

		TaiKhoan tkNV = new TaiKhoan("hinh123123", "123123", true);
		NhanVien nv = new NhanVien("Phan Trong Hinh", "abc@gmail.com", "male", "123123");
		nv.setChucVu(sampleCV);
		nv.setTaiKhoan(tkNV);

		if (nvDao.add(nv))
			System.out.println("Add success");
		else
			System.out.println("Add fail");

		NhanVien temp = null;
		try {
			temp = nvDao.get(nv.getMaNV());
			System.out.println(temp.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		temp.setTen("pepsi");
		if (nvDao.update(temp)) System.out.println("update success");
		else System.out.println("fail success");
		
		if(nvDao.delete(temp)) System.out.println("delete success");
		else System.out.println("delete fail");

	}
}
