package Rmi.Interface;

import java.rmi.RemoteException;

import Rmi.DTO.PhongDTO;

public interface IPhongService extends IBaseService<PhongDTO> {
	PhongDTO getPhongTrongByLoaiPhongId(int loaiPhongId) throws RemoteException;
}
