package Dao.Interface;

import Entity.KhachHang;
import Model.PageList;

public interface IKhachHangDao extends IBaseDao<KhachHang> {
	
	PageList<KhachHang> searchListKhachhang(String tenKh, int pageNumb);
}
