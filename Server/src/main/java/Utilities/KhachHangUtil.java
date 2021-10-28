package Utilities;

import java.util.ArrayList;
import java.util.List;

import Entity.KhachHang;

public class KhachHangUtil {

	public static KhachHang convertObjectToKhachHang(Object[] object) {
		int maKH = (int) object[0];
		KhachHang temp = new KhachHang((String) object[4], (String) object[5], (String) object[2], (String) object[1],
				(String) object[3]);
		temp.setMaKH(maKH);
		return temp;
	}

	public static List<KhachHang> convertToListKhachHang(List<?> listObject) {
		List<KhachHang> returnList = new ArrayList<KhachHang>();

		for (Object objects : listObject) {
			Object[] o = (Object[]) objects;
			returnList.add(convertObjectToKhachHang(o));
		}

		return returnList;
	}
}
