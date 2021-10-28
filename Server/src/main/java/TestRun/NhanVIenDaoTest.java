package TestRun;

import Dao.Impliment.NhanVienDao;
import Dao.Interface.INhanVien;
import Entity.NhanVien;
import Entity.TaiKhoan;

public class NhanVIenDaoTest {
	public static void main(String[] args) {
		INhanVien Dao = new NhanVienDao();
		
		TaiKhoan tkNV = new TaiKhoan("hinh123123","123123",true);
		NhanVien nv = new NhanVien("Phan Trong Hinh", "abc@gmail.com", "male", "123123");
		nv.setTaiKhoan(tkNV);
		
		if (Dao.add(nv)) System.out.println("Add success");
		else System.out.println("Add fail");
		
		NhanVien temp = null;
		try {
			temp = Dao.get(nv.getMaNV());
			System.out.println(temp.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
