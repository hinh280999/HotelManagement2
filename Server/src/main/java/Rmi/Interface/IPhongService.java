package Rmi.Interface;

import java.rmi.RemoteException;

import Model.PageList;
import Rmi.DTO.PhongDTO;

public interface IPhongService extends IBaseService<PhongDTO> {
	PhongDTO getPhongTrongByLoaiPhongId(int loaiPhongId) throws RemoteException;

	PageList<PhongDTO> getListPhongByPage(int pageNumb, int maxRow, String roomName) throws RemoteException;
}
