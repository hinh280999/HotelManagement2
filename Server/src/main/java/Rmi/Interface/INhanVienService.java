package Rmi.Interface;

import java.rmi.RemoteException;

import Model.PageList;
import Rmi.DTO.NhanVienDTO;

public interface INhanVienService extends IBaseService<NhanVienDTO> {
	PageList<NhanVienDTO> searchListNhanVien(String tenNv, int pageNumb) throws RemoteException;
	
	PageList<NhanVienDTO> getListNhanVienByPage(int pageNumb, int maxRow, String employeeName) throws RemoteException;
}
