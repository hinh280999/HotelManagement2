package TestRun;

import java.util.Date;

import Dao.Impliment.ChucVuDao;
import Dao.Impliment.KhachHangDao;
import Dao.Impliment.LoaiPhongDao;
import Dao.Impliment.NhanVienDao;
import Dao.Impliment.PhieuThueDao;
import Dao.Impliment.PhongDao;
import Dao.Impliment.TinhTrangPhongDao;
import Dao.Interface.IChucVu;
import Dao.Interface.IKhachHangDao;
import Dao.Interface.ILoaiPhongDao;
import Dao.Interface.INhanVien;
import Dao.Interface.IPhieuThue;
import Dao.Interface.IPhongDao;
import Dao.Interface.ITinhTrangPhongDao;
import Entity.ChucVu;
import Entity.KhachHang;
import Entity.LoaiPhong;
import Entity.NhanVien;
import Entity.PhieuThue;
import Entity.Phong;
import Entity.TaiKhoan;
import Entity.TinhTrangPhong;

public class PhieuThueTest {
	public static void main(String[] args) {
		// can 1 so Dao de tao du lieu mau sau do xoa du lieu mau di
		IPhieuThue Dao = new PhieuThueDao();

		IKhachHangDao khDao = new KhachHangDao();
		INhanVien nvDao = new NhanVienDao();
		IPhongDao phongDao = new PhongDao();

		IChucVu cvDao = new ChucVuDao();

		ITinhTrangPhongDao DaoTTP = new TinhTrangPhongDao();
		ILoaiPhongDao LPDao = new LoaiPhongDao();

		TinhTrangPhong tTTP = new TinhTrangPhong("Trống");
		LoaiPhong newLP = new LoaiPhong("Standard", 100000.0);
		DaoTTP.add(tTTP);
		LPDao.add(newLP);

		Phong samplePhong = new Phong("P2809");
		samplePhong.setMaTTP(tTTP);
		samplePhong.setMaLP(newLP);

		// da co Sample Phong
		phongDao.add(samplePhong);

		ChucVu sampleCV = new ChucVu("SampleChucVu", 1.0);
		cvDao.add(sampleCV);

		TaiKhoan tkNV = new TaiKhoan("hinh123123", "123123", true);
		NhanVien tempNV = new NhanVien("Phan Trong Hinh", "abc@gmail.com", "male", "123123");
		tempNV.setChucVu(sampleCV);
		tempNV.setTaiKhoan(tkNV);

		// da co SampleNhanVien
		nvDao.add(tempNV);

		KhachHang tKhachHang = new KhachHang("Phan Trong HInh", "Samplemail@gmail.com", "0981986242", "Tp HCM",
				"123123");

		// da co khach hang sample
		khDao.add(tKhachHang);

		// === Start Add PhieuPhong ===========================================================//

		Date ngayDat = new Date(2021, 12, 10);
		Date ngayKetThuc = new Date(2022, 1, 10);
		PhieuThue samplePT = new PhieuThue(ngayDat, ngayKetThuc, samplePhong, tempNV, tKhachHang);

		if (Dao.add(samplePT))
			System.out.println("Add PT Success");
		else
			System.out.println("Add PT FAil");

		PhieuThue temp = null;

		try {
			temp = Dao.get(samplePT.getMaPT());
			System.out.println(temp.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		temp.setTrangThai("Rented");
		temp.setNgayNhan(new Date());
		if (Dao.update(temp))
			System.out.println("Update PT Success");
		else
			System.out.println("Update PT fail");

		try {
			PhieuThue checkUpdate = Dao.get(temp.getMaPT());
			System.out.println(checkUpdate.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (Dao.delete(temp))
			System.out.println("delete PT success");
		else
			System.out.println("delete PT fail");

		
		// ==== Delete All Sample Object (Khach Hang, Nhan Vien, Phong, .....) ==== //
		DaoTTP.delete(tTTP);
		LPDao.delete(newLP);
		khDao.delete(tKhachHang);
		phongDao.delete(samplePhong);
		cvDao.delete(sampleCV);
		nvDao.delete(tempNV);
		
	}
}