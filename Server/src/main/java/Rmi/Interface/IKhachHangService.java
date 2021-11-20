package Rmi.Interface;

import java.rmi.RemoteException;

import Model.PageList;
import Rmi.DTO.KhachHangDTO;

public interface IKhachHangService extends IBaseService<KhachHangDTO> {
	PageList<KhachHangDTO> searchListKhachhang(String tenKh, int pageNumb) throws RemoteException;
}
