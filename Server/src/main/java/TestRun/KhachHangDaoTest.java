package TestRun;

import Dao.Impliment.KhachHangDao;
import Dao.Interface.IKhachHangDao;
import Model.PageList;
import Rmi.DTO.KhachHangDTO;

public class KhachHangDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IKhachHangDao Dao = new KhachHangDao();
		
		
		PageList<KhachHangDTO> page = Dao.searchListKhachhang("",1);
		System.out.println(page.toString());
		for (KhachHangDTO kh : page.getListData()) {
			System.out.println(kh.toString());
		}
		
//		KhachHang tKhachHang = new KhachHang("Phan Trong HInh", "Samplemail@gmail.com", "0981986242", "Tp HCM", "123123");
//		
//		if (Dao.add(tKhachHang)) {
//			System.out.println("Add Complete");
//		} else {
//			System.out.println("Add fail");
//		}
		
//		KhachHang khInfo = null;
//		try {
//			khInfo = Dao.get(tKhachHang.getMaKH());
//			System.out.println(khInfo.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		khInfo.setTen("Pepsi");
//		if (Dao.update(khInfo)) {
//			System.out.println("update Complete");
//		} else {
//			System.out.println("update Fail");
//		}
//
//		if (Dao.delete(khInfo.getMaKH())) {
//			System.out.println("delete Complete");
//		} else {
//			System.out.println("delete Fail");
//		}
		
	}

}
