package Run;

import java.util.List;

import Dao.Impliment.KhachHangDaoImp;
import Dao.Interface.KhachHangDao;
import Entity.KhachHang;

public class Server {

	public static void main(String[] args) {


		KhachHangDao Dao = new KhachHangDaoImp() ;
//		KhachHang adObj = new KhachHang("Hinh", "Myemail", "123123", "asdasdzxc", "12313123");
//		
//		Dao.add(adObj);
		
		
//		try {
//			KhachHang getObj  = Dao.get(-1);
//			System.out.println(getObj.toString());
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}
		
		List<KhachHang> templist = Dao.getListByPage(2);
//		templist.stream().sorted((l, r) -> l.getMaKH().compareTo(r.getMaKH()));
		for (KhachHang khachHang : templist) {
			System.out.println(khachHang.toString());
		}
//		getObj.setDiaChi("this is new dia chi");
//		System.out.println(Dao.update(getObj));
//		
//		KhachHang temp = Dao.get(1);
//		System.out.println(temp.toString());
		
	}

}
